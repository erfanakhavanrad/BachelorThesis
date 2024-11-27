package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.dao.pub.PubCompanyRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.pub.PubCompany;
import com.tarazgroup.tws.model.sale.*;
import com.tarazgroup.tws.util.exception.TConflictException;
import com.tarazgroup.tws.util.global.TCalendar;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.tabletype.SQLServerDataRecord.SQLServerDataRecordSaleVDTblType;
import com.tarazgroup.tws.util.tabletype.SQLServerDataRecord.SQLServerDataRecordTElement;
import com.tarazgroup.tws.util.tabletype.SQLServerDataRecord.SQLServerDataRecordTSerial;
import com.tarazgroup.tws.util.tabletype.SQLServerDataRecord.SQLServerDataRecordTempT2;
import com.tarazgroup.tws.util.tabletype.TElement;
import com.tarazgroup.tws.util.tabletype.TSerial;
import com.tarazgroup.tws.util.tabletype.TempT2;
import com.tarazgroup.tws.util.tabletype.sale.SaleVDTblType;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */
@SuppressWarnings("Duplicates")
public interface
SaleVoucherRepository extends TCrudRepository<SaleVoucher>, CrudRepository<SaleVoucher, BigDecimal> {

    default SaleVoucher saleShowVoucher(
            SaleVoucherHeaderRepository saleVoucherHeaderRepository,
            SaleVoucherDetailLightRepository saleVoucherDetailLightRepository,
            BigDecimal voucherHeaderID) {

        SaleVoucherHeader saleVoucherHeader = saleVoucherHeaderRepository.saleShowVoucherHeaderByID(voucherHeaderID);
        List<SaleVoucherDetailLight> saleVoucherDetailLights = saleVoucherDetailLightRepository.saleShowVoucherDetailLightByID(voucherHeaderID);

        SaleVoucher saleVoucher = new SaleVoucher();
        saleVoucher.setHeader(saleVoucherHeader);
        saleVoucher.setDetails(saleVoucherDetailLights);

        return saleVoucher;
    }

    default InputStreamResource reportPDF(
            BigDecimal voucherHeaderID,
            PubCompanyRepository pubCompanyRepository,
            SaleVoucherHeaderRepository saleVoucherHeaderRepository
    ) {
        PubCompany pubCompany = pubCompanyRepository.pubShowCompany();
        SaleVoucherHeader saleVoucherHeader = saleVoucherHeaderRepository.saleShowVoucherHeaderByID(voucherHeaderID);
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " and VType.VoucherTypeID = 6001 and Main.VoucherHeaderID=" + voucherHeaderID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", " and Main.ServerID in (" + saleVoucherHeader.getServerID() + ") and (Main.ServerID in (Select ServerID from dbo.PubUsersAccessServer Where UserID = 10000000) or (1 = 1))"));
        tParameters.add(new TParameter<>("YearFilter", " and Main.YearID = " + saleVoucherHeader.getYearID()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("VoucherTypeID", saleVoucherHeader.getVoucherTypeID()));
        HashMap<String, Object> parameterFields = new HashMap();
        parameterFields.put("@CompanyName", pubCompany.getCompanyFName());
        return exportCrystalReportToPDF("novinchoob", parameterFields, tParameters);
    }

    default SaleVoucher saleInsVoucher(SaleVoucherHeaderRepository saleVoucherHeaderRepository,
                                       SaleVoucherDetailLightRepository saleVoucherDetailLightRepository,
                                       PromotionElementRepository promotionElementRepository,
                                       SaleVoucher saleVoucher,
                                       SaleSysSetupRepository saleSysSetupRepository) {
        LogLogins logLogins = fetchUserDetail();
        SaleSysSetup saleSysSetup = saleSysSetupRepository.selectSaleSysSetup();
        List<SaleVoucherDetailLight> saleVoucherDetailLights = saleVoucher.getDetails();
        List<Promotion> promotions = saleVoucher.getPromotions();
        List<Element> elements = saleVoucher.getElements();

        TCalendar tCalendar = new TCalendar();
        String manualDate = saleVoucher.getHeader().getVoucherDate();
        String voucherDate;
        String voucherDateG;
        if (manualDate != null) {
            // تاریخ از سمت یوزر پر شده
            tCalendar.setIranianDateBySlash(manualDate);
        }
        voucherDate = tCalendar.getIranianDateBySlashZero();
        voucherDateG = tCalendar.getGregorianDateByTime();

        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("DECLARE @Result DECIMAL(38,4)").append("\n");
        sqlQuery.append("DECLARE @ErrMsg NVARCHAR(MAX)").append("\n");
        sqlQuery.append("DECLARE @NewID DECIMAL(38,4)").append("\n");
        sqlQuery.append("DECLARE @TDel dbo.TempT2").append("\n");
        sqlQuery.append("DECLARE @TVD dbo.SaleVDTblType").append("\n");
        sqlQuery.append("DECLARE @TSerial dbo.TSerial").append("\n");
        sqlQuery.append("DECLARE @TSerialDel dbo.TempT2").append("\n");
        sqlQuery.append("DECLARE @TElement dbo.TElement").append("\n");

        sqlQuery.append("-- افزودن کالا").append("\n");
        for (int i = 0; i < saleVoucherDetailLights.size(); i++) {
            sqlQuery.append("INSERT INTO @TVD VALUES(").append("\n");
            sqlQuery.append(i).append(", --RowNo").append("\n");// RowNo
            sqlQuery.append("NULL").append(", --VoucherDetailID").append("\n");// VoucherDetailID
            sqlQuery.append("NULL").append(", --VoucherHeaderID").append("\n");// VoucherHeaderID
            sqlQuery.append(saleVoucherDetailLights.get(i).getGoodsID()).append(", --GoodsID").append("\n");// GoodsID
            sqlQuery.append(saleVoucherDetailLights.get(i).getSecUnitID()).append(", --SecUnitID").append("\n");// SecUnitID
            sqlQuery.append(saleVoucherDetailLights.get(i).getQuantity()).append(", --Quantity").append("\n");// Quantity
            sqlQuery.append(saleVoucherDetailLights.get(i).getFee()).append(", --Fee").append("\n");// Fee
            sqlQuery.append(saleVoucherDetailLights.get(i).getDetailXDesc()).append(", --DetailXDesc").append("\n");// DetailXDesc
            sqlQuery.append(saleVoucherDetailLights.get(i).getdReferID()).append(", --DReferID").append("\n");// DReferID
            sqlQuery.append(logLogins.getPubUser().getUserID()).append(", --CreatorID").append("\n");// CreatorID
            sqlQuery.append(logLogins.getPubUser().getUserID()).append(", --ModifierID").append("\n");// ModifierID
            sqlQuery.append("NULL").append(", --DifferentialID").append("\n");// DifferentialID
            sqlQuery.append(saleVoucherDetailLights.get(i).getComputeValue()).append(", --ComputeValue").append("\n");// ComputeValue
            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField1()).append(", --CustomField1").append("\n");// CustomField1
            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField2()).append(", --CustomField2").append("\n");// CustomField2
            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField3()).append(", --CustomField3").append("\n");// CustomField3
            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField4()).append(", --CustomField4").append("\n");// CustomField4
            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField5()).append(", --CustomField5").append("\n");// CustomField5
            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField6()).append(", --CustomField6").append("\n");// CustomField6
            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField7()).append(", --CustomField7").append("\n");// CustomField7
            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField8()).append(", --CustomField8").append("\n");// CustomField8
            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField9()).append(", --CustomField9").append("\n");// CustomField9
            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField10()).append(", --CustomField10").append("\n");// CustomField10
            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField11()).append(", --CustomField11").append("\n");// CustomField11
            sqlQuery.append(saleVoucherDetailLights.get(i).getFee()).append(", --FeeAgreement").append("\n");// FeeAgreement
            sqlQuery.append(saleVoucherDetailLights.get(i).getFeeDiscountPrice()).append(", --FeeDiscountPrice").append("\n");// FeeDiscountPrice
            sqlQuery.append(saleVoucherDetailLights.get(i).getFeeDiscountPercent()).append(", --FeeDiscountPercent").append("\n");// FeeDiscountPercent
            sqlQuery.append("NULL").append(", --FeeFrieghtCharges").append("\n");// FeeFrieghtCharges
            sqlQuery.append("NULL").append(", --AllocatedQuantity2").append("\n");// AllocatedQuantity2
            sqlQuery.append("NULL").append(", --OverAllocatedQuantity2").append("\n");// OverAllocatedQuantity2
            sqlQuery.append("NULL").append(", --LCReferID").append("\n");// LCReferID
            sqlQuery.append("NULL").append(", --AgrReferID").append("\n");// AgrReferID
            sqlQuery.append("NULL").append(", --Quantity2").append("\n");// Quantity2
            sqlQuery.append("NULL").append(", --Quantity3").append("\n");// Quantity3
            sqlQuery.append("NULL").append(", --SecUnitID2").append("\n");// SecUnitID2
            sqlQuery.append("NULL").append(", --SecUnitID3").append("\n");// SecUnitID3
            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField12()).append(", --CustomField12").append("\n");// CustomField12
            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField13()).append(", --CustomField13").append("\n");// CustomField13
            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField14()).append(", --CustomField14").append("\n");// CustomField14
            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField15()).append(", --CustomField15").append("\n");// CustomField15
            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField16()).append(", --CustomField16").append("\n");// CustomField16
            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField17()).append(", --CustomField17").append("\n");// CustomField17
            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField18()).append(", --CustomField18").append("\n");// CustomField18
            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField19()).append(", --CustomField19").append("\n");// CustomField19
            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField20()).append(", --CustomField20").append("\n");// CustomField20
            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField21()).append(", --CustomField21").append("\n");// CustomField21
            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField22()).append(", --CustomField22").append("\n");// CustomField22
            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField23()).append(", --CustomField23").append("\n");// CustomField23
            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField24()).append(", --CustomField24").append("\n");// CustomField24
            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField25()).append(", --CustomField25").append("\n");// CustomField25

            if (saleSysSetup.getIsStoreInDet() == false) {
                // اگر تنظیمات فروش بگوید که انبار ردیفی نداریم
                sqlQuery.append("NULL").append(", --StoreID").append("\n");// StoreID
            } else {
                // اگر تنظیمات فروش بگوید که انبار ردیفی داریم
                sqlQuery.append(saleVoucherDetailLights.get(i).getStoreID()).append(", --StoreID").append("\n");// StoreID
            }
            sqlQuery.append("NULL").append(", --Center1ID").append("\n");// Center1ID
            sqlQuery.append("NULL").append(", --Center2ID").append("\n");// Center2ID
            sqlQuery.append("NULL").append(", --Center3ID").append("\n");// Center3ID
            sqlQuery.append("NULL").append(", --iGUID").append("\n");// iGUID
            sqlQuery.append("NULL").append(", --TaxMab").append("\n");// TaxMab
            sqlQuery.append("NULL").append(", --TollMab").append("\n");// TollMab
            sqlQuery.append("NULL").append(", --TaxCoEff").append("\n");// TaxCoEff
            sqlQuery.append("NULL").append(", --IsPromotion").append("\n");// IsPromotion
            sqlQuery.append("NULL").append(", --BaseDReferID").append("\n");// BaseDReferID
            sqlQuery.append("NULL").append(", --SecondGoodsID").append("\n");// SecondGoodsID
            sqlQuery.append("NULL").append(", --RRowMabPrice").append("\n");// RRowMabPrice
            sqlQuery.append("NULL").append(", --RRowMabPercent").append("\n");// RRowMabPercent
            sqlQuery.append("NULL").append(" --TollCoEff").append("\n");
            sqlQuery.append(")").append("\n");
        }

        sqlQuery.append("-- افزودن جایزه").append("\n");
        for (int i = 0; i < promotions.size(); i++) {
            sqlQuery.append("INSERT INTO @TVD VALUES(").append("\n");
            sqlQuery.append(saleVoucherDetailLights.size() + i).append(", --RowNo").append("\n");// RowNo
            sqlQuery.append("NULL").append(", --VoucherDetailID").append("\n");// VoucherDetailID
            sqlQuery.append("NULL").append(", --VoucherHeaderID").append("\n");// VoucherHeaderID
            sqlQuery.append(saleVoucherDetailLights.get(i).getGoodsID()).append(", --GoodsID").append("\n");// GoodsID
            sqlQuery.append(saleVoucherDetailLights.get(i).getSecUnitID()).append(", --SecUnitID").append("\n");// SecUnitID
            sqlQuery.append(saleVoucherDetailLights.get(i).getQuantity()).append(", --Quantity").append("\n");// Quantity
            sqlQuery.append("NULL").append(", --Fee").append("\n");// Fee
            sqlQuery.append("NULL").append(", --DetailXDesc").append("\n");// DetailXDesc
            sqlQuery.append("NULL").append(", --DReferID").append("\n");// DReferID
            sqlQuery.append(logLogins.getPubUser().getUserID()).append(", --CreatorID").append("\n");// CreatorID
            sqlQuery.append(logLogins.getPubUser().getUserID()).append(", --ModifierID").append("\n");// ModifierID
            sqlQuery.append("NULL").append(", --DifferentialID").append("\n");// DifferentialID
            sqlQuery.append("NULL").append(", --ComputeValue").append("\n");// ComputeValue
            sqlQuery.append("NULL").append(", --CustomField1").append("\n");// CustomField1
            sqlQuery.append("NULL").append(", --CustomField2").append("\n");// CustomField2
            sqlQuery.append("NULL").append(", --CustomField3").append("\n");// CustomField3
            sqlQuery.append("NULL").append(", --CustomField4").append("\n");// CustomField4
            sqlQuery.append("NULL").append(", --CustomField5").append("\n");// CustomField5
            sqlQuery.append("NULL").append(", --CustomField6").append("\n");// CustomField6
            sqlQuery.append("NULL").append(", --CustomField7").append("\n");// CustomField7
            sqlQuery.append("NULL").append(", --CustomField8").append("\n");// CustomField8
            sqlQuery.append("NULL").append(", --CustomField9").append("\n");// CustomField9
            sqlQuery.append("NULL").append(", --CustomField10").append("\n");// CustomField10
            sqlQuery.append("NULL").append(", --CustomField11").append("\n");// CustomField11
            sqlQuery.append("NULL").append(", --FeeAgreement").append("\n");// FeeAgreement
            sqlQuery.append("0").append(", --FeeDiscountPrice").append("\n");// FeeDiscountPrice
            sqlQuery.append("0").append(", --FeeDiscountPercent").append("\n");// FeeDiscountPercent
            sqlQuery.append("NULL").append(", --FeeFrieghtCharges").append("\n");// FeeFrieghtCharges
            sqlQuery.append("NULL").append(", --AllocatedQuantity2").append("\n");// AllocatedQuantity2
            sqlQuery.append("NULL").append(", --OverAllocatedQuantity2").append("\n");// OverAllocatedQuantity2
            sqlQuery.append("NULL").append(", --LCReferID").append("\n");// LCReferID
            sqlQuery.append("NULL").append(", --AgrReferID").append("\n");// AgrReferID
            sqlQuery.append("NULL").append(", --Quantity2").append("\n");// Quantity2
            sqlQuery.append("NULL").append(", --Quantity3").append("\n");// Quantity3
            sqlQuery.append("NULL").append(", --SecUnitID2").append("\n");// SecUnitID2
            sqlQuery.append("NULL").append(", --SecUnitID3").append("\n");// SecUnitID3
            sqlQuery.append("NULL").append(", --CustomField12").append("\n");// CustomField12
            sqlQuery.append("NULL").append(", --CustomField13").append("\n");// CustomField13
            sqlQuery.append("NULL").append(", --CustomField14").append("\n");// CustomField14
            sqlQuery.append("NULL").append(", --CustomField15").append("\n");// CustomField15
            sqlQuery.append("NULL").append(", --CustomField16").append("\n");// CustomField16
            sqlQuery.append("NULL").append(", --CustomField17").append("\n");// CustomField17
            sqlQuery.append("NULL").append(", --CustomField18").append("\n");// CustomField18
            sqlQuery.append("NULL").append(", --CustomField19").append("\n");// CustomField19
            sqlQuery.append("NULL").append(", --CustomField20").append("\n");// CustomField20
            sqlQuery.append("NULL").append(", --CustomField21").append("\n");// CustomField21
            sqlQuery.append("NULL").append(", --CustomField22").append("\n");// CustomField22
            sqlQuery.append("NULL").append(", --CustomField23").append("\n");// CustomField23
            sqlQuery.append("NULL").append(", --CustomField24").append("\n");// CustomField24
            sqlQuery.append("NULL").append(", --CustomField25").append("\n");// CustomField25
            sqlQuery.append("NULL").append(", --StoreID").append("\n");// StoreID
            sqlQuery.append("NULL").append(", --Center1ID").append("\n");// Center1ID
            sqlQuery.append("NULL").append(", --Center2ID").append("\n");// Center2ID
            sqlQuery.append("NULL").append(", --Center3ID").append("\n");// Center3ID
            sqlQuery.append("NULL").append(", --iGUID").append("\n");// iGUID
            sqlQuery.append("NULL").append(", --TaxMab").append("\n");// TaxMab
            sqlQuery.append("NULL").append(", --TollMab").append("\n");// TollMab
            sqlQuery.append("NULL").append(", --TaxCoEff").append("\n");// TaxCoEff
            sqlQuery.append("NULL").append(", --IsPromotion").append("\n");// IsPromotion
            sqlQuery.append("NULL").append(", --BaseDReferID").append("\n");// BaseDReferID
            sqlQuery.append("NULL").append(", --SecondGoodsID").append("\n");// SecondGoodsID
            sqlQuery.append("NULL").append(", --RRowMabPrice").append("\n");// RRowMabPrice
            sqlQuery.append("NULL").append(", --RRowMabPercent").append("\n");// RRowMabPercent
            sqlQuery.append("NULL").append(" --TollCoEff").append("\n");
            sqlQuery.append(")").append("\n");
        }

        sqlQuery.append("EXEC SaleInsVoucherHD ").append("\n");
        sqlQuery.append("1").append(", --VoucherNumber").append("\n");// VoucherNumber
        sqlQuery.append("N'").append(voucherDate).append("'").append(", --voucherDate").append("\n");// voucherDate
        sqlQuery.append("N'").append(voucherDateG).append("'").append(", --voucherDateG").append("\n");// voucherDateG
        sqlQuery.append(saleVoucher.getHeader().getCustomerID()).append(", --CustomerID").append("\n");// CustomerID
        sqlQuery.append(saleVoucher.getHeader().getStoreID()).append(", --StoreID").append("\n");// StoreID
        sqlQuery.append(saleVoucher.getHeader().getVoucherTypeID()).append(", --VoucherTypeID").append("\n");// VoucherTypeID
        sqlQuery.append(saleVoucher.getHeader().getRefTypeID()).append(", --RefTypeID").append("\n");// RefTypeID
        sqlQuery.append(logLogins.getPubUser().getUserID()).append(", --CreatorID").append("\n");// CreatorID
        sqlQuery.append(logLogins.getPubUser().getUserID()).append(", --ModifierID").append("\n");// ModifierID
        sqlQuery.append(logLogins.getPubUser().getActiveYearID()).append(", --YearID").append("\n");// YearID
        sqlQuery.append(saleVoucher.getHeader().getSaleCenterID()).append(", --SaleCenterID").append("\n");// SaleCenterID
        sqlQuery.append(saleVoucher.getHeader().getDeliverCenterID()).append(", --DeliverCenterID").append("\n");// DeliverCenterID

        if (saleVoucher.getHeader().getVoucherDesc() == null) {
            sqlQuery.append("NULL").append(", --VoucherDesc").append("\n");// VoucherDesc
        } else {
            sqlQuery.append("N'").append(saleVoucher.getHeader().getVoucherDesc()).append("'").append(", --VoucherDesc").append("\n");// VoucherDesc
        }

        if (saleVoucher.getHeader().getReferNumber() == null) {
            sqlQuery.append("NULL").append(", --ReferNumber").append("\n");// ReferNumber
        } else {
            sqlQuery.append("N'").append(saleVoucher.getHeader().getReferNumber()).append("'").append(", --ReferNumber").append("\n");// ReferNumber
        }

        if (saleVoucher.getHeader().getReferDate() == null) {
            sqlQuery.append("NULL").append(", --ReferDate").append("\n");// ReferDate
        } else {
            sqlQuery.append("N'").append(saleVoucher.getHeader().getReferDate()).append("'").append(", --ReferDate").append("\n");// ReferDate
        }

        sqlQuery.append(saleVoucher.getHeader().getSalesManID()).append(", --SalesManID").append("\n");// SalesManID
        sqlQuery.append(saleVoucher.getHeader().getMarketingManID()).append(", --MarketingManID").append("\n");// MarketingManID
        sqlQuery.append(saleVoucher.getHeader().getSaleTypeID()).append(", --SaleTypeID").append("\n");// SaleTypeID

        if (saleVoucher.getHeader().getSecondNumber() == null) {
            sqlQuery.append("NULL").append(", --SecondNumber").append("\n");// SecondNumber
        } else {
            sqlQuery.append("N'").append(saleVoucher.getHeader().getSecondNumber()).append("'").append(", --SecondNumber").append("\n");// SecondNumber
        }
        sqlQuery.append(saleVoucher.getHeader().getCurrencyID()).append(", --CurrencyID").append("\n");// CurrencyID
        sqlQuery.append(saleVoucher.getHeader().getPaymentWayID()).append(", --PaymentWayID").append("\n");// PaymentWayID
        sqlQuery.append("@Result OUTPUT").append(", --Result").append("\n");// Result
        sqlQuery.append(logLogins.getLoginId()).append(", --LoginID").append("\n");// LoginID
        sqlQuery.append("@ErrMsg OUTPUT").append(", --ErrMsg").append("\n");// ErrMsg

        if (saleVoucher.getHeader().getExtraDesc() == null) {
            sqlQuery.append("NULL").append(", --ExtraDesc").append("\n");// ExtraDesc
        } else {
            sqlQuery.append("N'").append(saleVoucher.getHeader().getExtraDesc()).append("'").append(", --ExtraDesc").append("\n");// ExtraDesc
        }

        sqlQuery.append("@NewID OUTPUT").append(", --NewID").append("\n");// NewID
        sqlQuery.append(saleVoucher.getHeader().getReferID()).append(", --ReferID").append("\n");// ReferID
        sqlQuery.append(saleVoucher.getOther().getAnalysisSetup()).append(", --AnalysisSetup").append("\n");// AnalysisSetup
        sqlQuery.append(saleVoucher.getHeader().getCenter1ID()).append(", --Center1ID").append("\n");// Center1ID
        sqlQuery.append(saleVoucher.getHeader().getCenter2ID()).append(", --Center2ID").append("\n");// Center2ID
        sqlQuery.append(saleVoucher.getHeader().getCenter3ID()).append(", --Center3ID").append("\n");// Center3ID
        sqlQuery.append(saleVoucher.getHeader().getAccountID()).append(", --AccountID").append("\n");// AccountID
        sqlQuery.append(saleVoucher.getHeader().getDayCount()).append(", --DayCount").append("\n");// DayCount
        sqlQuery.append(saleVoucher.getHeader().getDocPrice()).append(", --DocPrice").append("\n");// DocPrice
        sqlQuery.append(saleVoucher.getHeader().getCashID()).append(", --CashID").append("\n");// CashID
        sqlQuery.append(saleVoucher.getHeader().getBaseRefTypeID()).append(", --BaseRefTypeID").append("\n");// BaseRefTypeID
        sqlQuery.append(saleVoucher.getHeader().getIsManualPromotion()).append(", --IsManualPromotion").append("\n");// IsManualPromotion
        sqlQuery.append(saleVoucher.getOther().getIsAndroidUser()).append(", --IsAndroidUser").append("\n");// IsAndroidUser
        sqlQuery.append(saleVoucher.getOther().getIsAmendment()).append(", --IsAmendment").append("\n");// IsAmendment

        if (saleVoucher.getOther().getContractNumber() == null) {
            sqlQuery.append("NULL").append(", --ContractNumber").append("\n");// ContractNumber
        } else {
            sqlQuery.append("N'").append(saleVoucher.getOther().getContractNumber()).append("'").append(", --ContractNumber").append("\n");// ContractNumber
        }

        if (saleVoucher.getOther().getContractDate() == null) {
            sqlQuery.append("NULL").append(", --ContractDate").append("\n");// ContractDate
        } else {
            sqlQuery.append("N'").append(saleVoucher.getOther().getContractDate()).append("'").append(", --ContractDate").append("\n");// ContractDate
        }

        if (saleVoucher.getOther().getBruntNumber() == null) {
            sqlQuery.append("NULL").append(", --BruntNumber").append("\n");// BruntNumber
        } else {
            sqlQuery.append("N'").append(saleVoucher.getOther().getBruntNumber()).append("'").append(", --BruntNumber").append("\n");// BruntNumber
        }

        if (saleVoucher.getOther().getCarNumber() == null) {
            sqlQuery.append("NULL").append(", --CarNumber").append("\n");// CarNumber
        } else {
            sqlQuery.append("N'").append(saleVoucher.getOther().getCarNumber()).append("'").append(", --CarNumber").append("\n");// CarNumber
        }

        if (saleVoucher.getOther().getOtherDesc() == null) {
            sqlQuery.append("NULL").append(", --OtherDesc").append("\n");// OtherDesc
        } else {
            sqlQuery.append("N'").append(saleVoucher.getOther().getOtherDesc()).append("'").append(", --OtherDesc").append("\n");// OtherDesc
        }

        if (saleVoucher.getOther().getxDesc() == null) {
            sqlQuery.append("NULL").append(", --XDesc").append("\n");// XDesc
        } else {
            sqlQuery.append("N'").append(saleVoucher.getOther().getxDesc()).append("'").append(", --XDesc").append("\n");// XDesc
        }

        sqlQuery.append(saleVoucher.getOther().getDriverID()).append(", --DriverID").append("\n");// DriverID
        sqlQuery.append(saleVoucher.getOther().getDistNameID()).append(", --DistNameID").append("\n");// DistNameID
        sqlQuery.append(saleVoucher.getHeader().getRowID()).append(", --RowID").append("\n");// RowID
        sqlQuery.append(saleVoucher.getHeader().getVoucherHeaderID()).append(", --VoucherHeaderID").append("\n");// VoucherHeaderID
        sqlQuery.append("@TDel").append(", --TDel").append("\n");// TDel
        sqlQuery.append("@TVD").append(", --TVD").append("\n");// TVD
        sqlQuery.append("@TSerial").append(", --TSerial").append("\n");// TSerial
        sqlQuery.append("@TSerialDel").append(", --TSerialDel").append("\n");// TSerialDel
        sqlQuery.append("@TElement").append(", --TElement").append("\n");// TElement
        sqlQuery.append(saleVoucher.getOther().getWebUserType()).append(", --WebUserType").append("\n");// WebUserType
        sqlQuery.append(saleVoucher.getHeader().getTableID()).append(" --TableID").append("\n");// TableID
        sqlQuery.append("SELECT @Result AS Result,@ErrMsg AS ErrMsg,@NewID AS NewID");
        Map<String,Object> row =  execute(sqlQuery.toString());
        BigDecimal newID = (BigDecimal) row.get("NewID");
        promotionElementRepository.saleInsPromotion(newID, elements);
        return saleShowVoucher(
                saleVoucherHeaderRepository,
                saleVoucherDetailLightRepository,
                newID);
    }


    default SaleVoucher saleInsVoucher1(SaleVoucherHeaderRepository saleVoucherHeaderRepository,
                                        SaleVoucherDetailLightRepository saleVoucherDetailLightRepository,
                                        PromotionElementRepository promotionElementRepository,
                                        SaleVoucher saleVoucher,
                                        SaleSysSetupRepository saleSysSetupRepository) {
        LogLogins logLogins = fetchUserDetail();
        List<SaleVoucherDetailLight> saleVoucherDetailLights = saleVoucher.getDetails();
        List<Promotion> promotions = saleVoucher.getPromotions();
        List<Element> elements = saleVoucher.getElements();

        SaleVDTblType[] saleVDTblTypesDetails = new SaleVDTblType[saleVoucherDetailLights.size()];
        SaleVDTblType[] saleVDTblTypesPromotions = new SaleVDTblType[promotions.size()];

        // add details to SaleVDTblType[]
        for (int i = 0; i < saleVoucherDetailLights.size(); i++) {
            SaleVDTblType saleVDTblType = new SaleVDTblType();
            saleVDTblType.setRowNo(new BigDecimal(i + 1));
            saleVDTblType.setVoucherDetailID(null);
            saleVDTblType.setVoucherHeaderID(null);
            saleVDTblType.setGoodsID(saleVoucherDetailLights.get(i).getGoodsID());
            saleVDTblType.setSecUnitID(saleVoucherDetailLights.get(i).getSecUnitID());
            saleVDTblType.setQuantity(saleVoucherDetailLights.get(i).getQuantity());
            saleVDTblType.setFee(saleVoucherDetailLights.get(i).getFee());
            saleVDTblType.setDetailXDesc(saleVoucherDetailLights.get(i).getDetailXDesc());
            saleVDTblType.setdReferID(saleVoucherDetailLights.get(i).getdReferID());
            saleVDTblType.setCreatorID(logLogins.getPubUser().getUserID());
            saleVDTblType.setModifierID(logLogins.getPubUser().getUserID());
            saleVDTblType.setDifferentialID(null);
            saleVDTblType.setComputeValue(saleVoucherDetailLights.get(i).getComputeValue());
            saleVDTblType.setCustomField1(saleVoucherDetailLights.get(i).getCustomField1());
            saleVDTblType.setCustomField2(saleVoucherDetailLights.get(i).getCustomField2());
            saleVDTblType.setCustomField3(saleVoucherDetailLights.get(i).getCustomField3());
            saleVDTblType.setCustomField4(saleVoucherDetailLights.get(i).getCustomField4());
            saleVDTblType.setCustomField5(saleVoucherDetailLights.get(i).getCustomField5());
            saleVDTblType.setCustomField6(saleVoucherDetailLights.get(i).getCustomField6());
            saleVDTblType.setCustomField7(saleVoucherDetailLights.get(i).getCustomField7());
            saleVDTblType.setCustomField8(saleVoucherDetailLights.get(i).getCustomField8());
            saleVDTblType.setCustomField9(saleVoucherDetailLights.get(i).getCustomField9());
            saleVDTblType.setCustomField10(saleVoucherDetailLights.get(i).getCustomField10());
            saleVDTblType.setCustomField11(saleVoucherDetailLights.get(i).getCustomField11());
            saleVDTblType.setFeeAgreement(saleVoucherDetailLights.get(i).getFee());
            saleVDTblType.setFeeDiscountPrice(saleVoucherDetailLights.get(i).getFeeDiscountPrice());
            saleVDTblType.setFeeDiscountPercent(saleVoucherDetailLights.get(i).getFeeDiscountPercent());
            saleVDTblType.setFeeFrieghtCharges(null);
            saleVDTblType.setAllocatedQuantity2(null);
            saleVDTblType.setOverAllocatedQuantity2(null);
            saleVDTblType.setLCReferID(null);
            saleVDTblType.setAgrReferID(null);
            saleVDTblType.setQuantity2(null);
            saleVDTblType.setQuantity3(null);
            saleVDTblType.setSecUnitID2(null);
            saleVDTblType.setSecUnitID3(null);
            saleVDTblType.setCustomField12(saleVoucherDetailLights.get(i).getCustomField12());
            saleVDTblType.setCustomField13(saleVoucherDetailLights.get(i).getCustomField13());
            saleVDTblType.setCustomField14(saleVoucherDetailLights.get(i).getCustomField14());
            saleVDTblType.setCustomField15(saleVoucherDetailLights.get(i).getCustomField15());
            saleVDTblType.setCustomField16(saleVoucherDetailLights.get(i).getCustomField16());
            saleVDTblType.setCustomField17(saleVoucherDetailLights.get(i).getCustomField17());
            saleVDTblType.setCustomField18(saleVoucherDetailLights.get(i).getCustomField18());
            saleVDTblType.setCustomField19(saleVoucherDetailLights.get(i).getCustomField19());
            saleVDTblType.setCustomField20(saleVoucherDetailLights.get(i).getCustomField20());
            saleVDTblType.setCustomField21(saleVoucherDetailLights.get(i).getCustomField21());
            saleVDTblType.setCustomField22(saleVoucherDetailLights.get(i).getCustomField22());
            saleVDTblType.setCustomField23(saleVoucherDetailLights.get(i).getCustomField23());
            saleVDTblType.setCustomField24(saleVoucherDetailLights.get(i).getCustomField24());
            saleVDTblType.setCustomField25(saleVoucherDetailLights.get(i).getCustomField25());
            // استور آی دی بخاطر پاک ساب شویان حذف شد اما سیم و کابل به مشکل برخورد و من مجبور شدم دوباره بذارم

            SaleSysSetup saleSysSetup = saleSysSetupRepository.selectSaleSysSetup();
            if (saleSysSetup.getIsStoreInDet() == false)
                saleVDTblType.setStoreID(null);
            else
                saleVDTblType.setStoreID(saleVoucherDetailLights.get(i).getStoreID());
            saleVDTblType.setCenter1ID(null);
            saleVDTblType.setCenter2ID(null);
            saleVDTblType.setCenter3ID(null);
            saleVDTblType.setiGUID(null);
            saleVDTblType.setTaxMab(null);
            saleVDTblType.setTollMab(null);
            saleVDTblType.setTaxCoEff(null);
            saleVDTblType.setIsPromotion(null);
            saleVDTblType.setBaseDReferID(saleVoucherDetailLights.get(i).getBaseDReferID());
            saleVDTblType.setSecondGoodsID(null);
            saleVDTblType.setrRowMabPrice(null);
            saleVDTblType.setrRowMabPercent(null);
            saleVDTblType.setTollCoEff(null);
            saleVDTblTypesDetails[i] = saleVDTblType;
        }


        // add propotions to SaleVDTblType[] , isPromotion = true
        for (int i = 0; i < promotions.size(); i++) {
            SaleVDTblType saleVDTblType = new SaleVDTblType();
            saleVDTblType.setRowNo(new BigDecimal(saleVoucherDetailLights.size() + i + 1));
            saleVDTblType.setVoucherDetailID(null);
            saleVDTblType.setVoucherHeaderID(null);
            saleVDTblType.setGoodsID(promotions.get(i).getGoodsID());
            saleVDTblType.setSecUnitID(promotions.get(i).getSecUnitID());
            saleVDTblType.setQuantity(promotions.get(i).getQuantity());
            saleVDTblType.setFee(null);
            saleVDTblType.setDetailXDesc(null);
            saleVDTblType.setdReferID(null);
            saleVDTblType.setCreatorID(logLogins.getPubUser().getUserID());
            saleVDTblType.setModifierID(logLogins.getPubUser().getUserID());
            saleVDTblType.setDifferentialID(null);
            saleVDTblType.setComputeValue(null);
            saleVDTblType.setCustomField1(null);
            saleVDTblType.setCustomField2(null);
            saleVDTblType.setCustomField3(null);
            saleVDTblType.setCustomField4(null);
            saleVDTblType.setCustomField5(null);
            saleVDTblType.setCustomField6(null);
            saleVDTblType.setCustomField7(null);
            saleVDTblType.setCustomField8(null);
            saleVDTblType.setCustomField9(null);
            saleVDTblType.setCustomField10(null);
            saleVDTblType.setCustomField11(null);
            saleVDTblType.setFeeAgreement(null);
            saleVDTblType.setFeeDiscountPrice(new BigDecimal(0));
            saleVDTblType.setFeeDiscountPercent(new BigDecimal(0));
            saleVDTblType.setFeeFrieghtCharges(null);
            saleVDTblType.setAllocatedQuantity2(null);
            saleVDTblType.setOverAllocatedQuantity2(null);
            saleVDTblType.setLCReferID(null);
            saleVDTblType.setAgrReferID(null);
            saleVDTblType.setQuantity2(null);
            saleVDTblType.setQuantity3(null);
            saleVDTblType.setSecUnitID2(null);
            saleVDTblType.setSecUnitID3(null);
            saleVDTblType.setCustomField12(null);
            saleVDTblType.setCustomField13(null);
            saleVDTblType.setCustomField14(null);
            saleVDTblType.setCustomField15(null);
            saleVDTblType.setCustomField16(null);
            saleVDTblType.setCustomField17(null);
            saleVDTblType.setCustomField18(null);
            saleVDTblType.setCustomField19(null);
            saleVDTblType.setCustomField20(null);
            saleVDTblType.setCustomField21(null);
            saleVDTblType.setCustomField22(null);
            saleVDTblType.setCustomField23(null);
            saleVDTblType.setCustomField24(null);
            saleVDTblType.setCustomField25(null);
            saleVDTblType.setStoreID(null);
            saleVDTblType.setCenter1ID(null);
            saleVDTblType.setCenter2ID(null);
            saleVDTblType.setCenter3ID(null);
            saleVDTblType.setiGUID(null);
            saleVDTblType.setTaxMab(null);
            saleVDTblType.setTollMab(null);
            saleVDTblType.setTaxCoEff(null);
            saleVDTblType.setIsPromotion(true);
            saleVDTblType.setBaseDReferID(null);
            saleVDTblType.setSecondGoodsID(null);
            saleVDTblType.setrRowMabPrice(null);
            saleVDTblType.setrRowMabPercent(null);
            saleVDTblType.setTollCoEff(null);
            saleVDTblTypesPromotions[i] = saleVDTblType;
        }

        SaleVDTblType[] saleVDTblTypes = ArrayUtils.addAll(saleVDTblTypesDetails, saleVDTblTypesPromotions);

        SQLServerDataRecordSaleVDTblType sQLServerDataRecordSaleVDTblType = new SQLServerDataRecordSaleVDTblType(saleVDTblTypes);
        SQLServerDataRecordTempT2 sqlServerDataRecordTempT2TDel = new SQLServerDataRecordTempT2(new TempT2[0]);
        SQLServerDataRecordTSerial sqlServerDataRecordTSerial = new SQLServerDataRecordTSerial(new TSerial[0]);
        SQLServerDataRecordTempT2 sqlServerDataRecordTempT2TSerialDel = new SQLServerDataRecordTempT2(new TempT2[0]);
        SQLServerDataRecordTElement sqlServerDataRecordTempT2TElement = new SQLServerDataRecordTElement(new TElement[0]);


        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("VoucherNumber", new BigDecimal(1)));
        TCalendar tc = new TCalendar();
        String manualDate = saleVoucher.getHeader().getVoucherDate(); //A date that json give us(user entered himself)
        if (manualDate != null) {
            tc.setIranianDateBySlash(manualDate);
            tParameters.add(new TParameter<>("VoucherDate", tc.getIranianDateBySlashZero()));
            tParameters.add(new TParameter<>("VoucherDateG", tc.getSqlDate()));
        } else { //Auto dating
            tParameters.add(new TParameter<>("VoucherDate", tc.getIranianDateBySlashZero()));
            tParameters.add(new TParameter<>("VoucherDateG", new Date()));
        }
        tParameters.add(new TParameter<>("CustomerID", saleVoucher.getHeader().getCustomerID()));
        tParameters.add(new TParameter<>("StoreID", saleVoucher.getHeader().getStoreID()));
        tParameters.add(new TParameter<>("VoucherTypeID", saleVoucher.getHeader().getVoucherTypeID()));
        tParameters.add(new TParameter<>("RefTypeID", saleVoucher.getHeader().getRefTypeID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("YearID", logLogins.getPubUser().getActiveYearID()));
        tParameters.add(new TParameter<>("SaleCenterID", saleVoucher.getHeader().getSaleCenterID()));
        tParameters.add(new TParameter<>("DeliverCenterID", saleVoucher.getHeader().getDeliverCenterID()));
        tParameters.add(new TParameter<>("VoucherDesc", saleVoucher.getHeader().getVoucherDesc()));
        tParameters.add(new TParameter<>("ReferNumber", saleVoucher.getHeader().getReferNumber()));
        tParameters.add(new TParameter<>("ReferDate", saleVoucher.getHeader().getReferDate()));
        tParameters.add(new TParameter<>("SalesManID", saleVoucher.getHeader().getSalesManID()));
        tParameters.add(new TParameter<>("MarketingManID", saleVoucher.getHeader().getMarketingManID()));
        tParameters.add(new TParameter<>("SaleTypeID", saleVoucher.getHeader().getSaleTypeID()));
        tParameters.add(new TParameter<>("SecondNumber", saleVoucher.getHeader().getSecondNumber()));
        tParameters.add(new TParameter<>("CurrencyID", saleVoucher.getHeader().getCurrencyID()));
        tParameters.add(new TParameter<>("PaymentWayID", saleVoucher.getHeader().getPaymentWayID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("ExtraDesc", saleVoucher.getHeader().getExtraDesc()));
        tParameters.add(new TParameter<>("ReferID", saleVoucher.getHeader().getReferID()));
        tParameters.add(new TParameter<>("AnalysisSetup", saleVoucher.getOther().getAnalysisSetup()));
        tParameters.add(new TParameter<>("Center1ID", saleVoucher.getHeader().getCenter1ID()));
        tParameters.add(new TParameter<>("Center2ID", saleVoucher.getHeader().getCenter2ID()));
        tParameters.add(new TParameter<>("Center3ID", saleVoucher.getHeader().getCenter3ID()));
        tParameters.add(new TParameter<>("AccountID", saleVoucher.getHeader().getAccountID()));
        tParameters.add(new TParameter<>("DayCount", saleVoucher.getHeader().getDayCount()));
        tParameters.add(new TParameter<>("DocPrice", saleVoucher.getHeader().getDocPrice()));
        tParameters.add(new TParameter<>("CashID", saleVoucher.getHeader().getCashID()));
        tParameters.add(new TParameter<>("BaseRefTypeID", saleVoucher.getHeader().getBaseRefTypeID()));
        tParameters.add(new TParameter<>("IsManualPromotion", saleVoucher.getHeader().getIsManualPromotion()));
        tParameters.add(new TParameter<>("IsAndroidUser", saleVoucher.getOther().getIsAndroidUser()));
        tParameters.add(new TParameter<>("IsAmendment", saleVoucher.getOther().getIsAmendment()));
        tParameters.add(new TParameter<>("ContractNumber", saleVoucher.getOther().getContractNumber()));
        tParameters.add(new TParameter<>("ContractDate", saleVoucher.getOther().getContractDate()));
        tParameters.add(new TParameter<>("BruntNumber", saleVoucher.getOther().getBruntNumber()));
        tParameters.add(new TParameter<>("CarNumber", saleVoucher.getOther().getCarNumber()));
        tParameters.add(new TParameter<>("OtherDesc", saleVoucher.getOther().getOtherDesc()));
        tParameters.add(new TParameter<>("XDesc", saleVoucher.getOther().getxDesc()));
        tParameters.add(new TParameter<>("DriverID", saleVoucher.getOther().getDriverID()));
        tParameters.add(new TParameter<>("DistNameID", saleVoucher.getOther().getDistNameID()));
        tParameters.add(new TParameter<>("RowID", saleVoucher.getHeader().getRowID()));
        tParameters.add(new TParameter<>("VoucherHeaderID", saleVoucher.getHeader().getVoucherHeaderID()));
        tParameters.add(new TParameter<>("TDel", "TempT2", sqlServerDataRecordTempT2TDel));
        tParameters.add(new TParameter<>("TVD", "SaleVDTblType", sQLServerDataRecordSaleVDTblType));
        tParameters.add(new TParameter<>("TSerial", "TSerial", sqlServerDataRecordTSerial));
        tParameters.add(new TParameter<>("TSerialDel", "TempT2", sqlServerDataRecordTempT2TSerialDel));
        tParameters.add(new TParameter<>("TElement", "TElement", sqlServerDataRecordTempT2TElement));
        tParameters.add(new TParameter<>("WebUserType", saleVoucher.getOther().getWebUserType()));
        tParameters.add(new TParameter<>("TableID", saleVoucher.getHeader().getTableID()));
        HashMap<String, Object> res = execute1("SaleInsVoucherHD", tParameters);
        BigDecimal result = (BigDecimal) res.get("Result");
        String errMsg = (String) res.get("ErrMsg");
        BigDecimal newID = (BigDecimal) res.get("NewID");
        if (result.intValue() == 0) {
            //if voucher was saved call saleInsPromotion for saving Elemets
            promotionElementRepository.saleInsPromotion(newID, elements);
            return saleShowVoucher(
                    saleVoucherHeaderRepository,
                    saleVoucherDetailLightRepository,
                    newID);
        } else {
            throw new TConflictException(result.intValue(), errMsg);
        }
    }

    default SaleVoucher saleUpdVoucher(SaleVoucherHeaderRepository saleVoucherHeaderRepository,
                                       SaleVoucherDetailLightRepository saleVoucherDetailLightRepository,
                                       PromotionElementRepository promotionElementRepository,
                                       SaleVoucher saleVoucher,
                                       BigDecimal voucherHeaderID) {
        LogLogins logLogins = fetchUserDetail();
        List<SaleVoucherDetailLight> saleVoucherDetailLights = saleVoucher.getDetails();
        List<Promotion> promotions = saleVoucher.getPromotions();
        List<Element> elements = saleVoucher.getElements();

        SaleVDTblType[] saleVDTblTypesDetails = new SaleVDTblType[saleVoucherDetailLights.size()];
        SaleVDTblType[] saleVDTblTypesPromotions = new SaleVDTblType[promotions.size()];

        // add details to SaleVDTblType[]
        for (int i = 0; i < saleVoucherDetailLights.size(); i++) {
            SaleVDTblType saleVDTblType = new SaleVDTblType();
            saleVDTblType.setRowNo(new BigDecimal(i + 1));
            saleVDTblType.setVoucherDetailID(saleVoucherDetailLights.get(i).getVoucherDetailID());
            saleVDTblType.setVoucherHeaderID(saleVoucherDetailLights.get(i).getVoucherHeaderID());
            saleVDTblType.setGoodsID(saleVoucherDetailLights.get(i).getGoodsID());
            saleVDTblType.setSecUnitID(saleVoucherDetailLights.get(i).getSecUnitID());
            saleVDTblType.setQuantity(saleVoucherDetailLights.get(i).getQuantity());
            saleVDTblType.setFee(saleVoucherDetailLights.get(i).getFee());
            saleVDTblType.setDetailXDesc(saleVoucherDetailLights.get(i).getDetailXDesc());
            saleVDTblType.setdReferID(null);
            saleVDTblType.setCreatorID(logLogins.getPubUser().getUserID());
            saleVDTblType.setModifierID(logLogins.getPubUser().getUserID());
            saleVDTblType.setDifferentialID(null);
            saleVDTblType.setComputeValue(saleVoucherDetailLights.get(i).getComputeValue());
            saleVDTblType.setCustomField1(saleVoucherDetailLights.get(i).getCustomField1());
            saleVDTblType.setCustomField2(saleVoucherDetailLights.get(i).getCustomField2());
            saleVDTblType.setCustomField3(saleVoucherDetailLights.get(i).getCustomField3());
            saleVDTblType.setCustomField4(saleVoucherDetailLights.get(i).getCustomField4());
            saleVDTblType.setCustomField5(saleVoucherDetailLights.get(i).getCustomField5());
            saleVDTblType.setCustomField6(saleVoucherDetailLights.get(i).getCustomField6());
            saleVDTblType.setCustomField7(saleVoucherDetailLights.get(i).getCustomField7());
            saleVDTblType.setCustomField8(saleVoucherDetailLights.get(i).getCustomField8());
            saleVDTblType.setCustomField9(saleVoucherDetailLights.get(i).getCustomField9());
            saleVDTblType.setCustomField10(saleVoucherDetailLights.get(i).getCustomField10());
            saleVDTblType.setCustomField11(saleVoucherDetailLights.get(i).getCustomField11());
            saleVDTblType.setFeeAgreement(saleVoucherDetailLights.get(i).getFeeAgreement());
            saleVDTblType.setFeeDiscountPrice(saleVoucherDetailLights.get(i).getFeeDiscountPrice());
            saleVDTblType.setFeeDiscountPercent(saleVoucherDetailLights.get(i).getFeeDiscountPercent());
            saleVDTblType.setFeeFrieghtCharges(null);
            saleVDTblType.setAllocatedQuantity2(null);
            saleVDTblType.setOverAllocatedQuantity2(null);
            saleVDTblType.setLCReferID(null);
            saleVDTblType.setAgrReferID(null);
            saleVDTblType.setQuantity2(null);
            saleVDTblType.setQuantity3(null);
            saleVDTblType.setSecUnitID2(null);
            saleVDTblType.setSecUnitID3(null);
            saleVDTblType.setCustomField12(saleVoucherDetailLights.get(i).getCustomField12());
            saleVDTblType.setCustomField13(saleVoucherDetailLights.get(i).getCustomField13());
            saleVDTblType.setCustomField14(saleVoucherDetailLights.get(i).getCustomField14());
            saleVDTblType.setCustomField15(saleVoucherDetailLights.get(i).getCustomField15());
            saleVDTblType.setCustomField16(saleVoucherDetailLights.get(i).getCustomField16());
            saleVDTblType.setCustomField17(saleVoucherDetailLights.get(i).getCustomField17());
            saleVDTblType.setCustomField18(saleVoucherDetailLights.get(i).getCustomField18());
            saleVDTblType.setCustomField19(saleVoucherDetailLights.get(i).getCustomField19());
            saleVDTblType.setCustomField20(saleVoucherDetailLights.get(i).getCustomField20());
            saleVDTblType.setCustomField21(saleVoucherDetailLights.get(i).getCustomField21());
            saleVDTblType.setCustomField22(saleVoucherDetailLights.get(i).getCustomField22());
            saleVDTblType.setCustomField23(saleVoucherDetailLights.get(i).getCustomField23());
            saleVDTblType.setCustomField24(saleVoucherDetailLights.get(i).getCustomField24());
            saleVDTblType.setCustomField25(saleVoucherDetailLights.get(i).getCustomField25());
            saleVDTblType.setStoreID(saleVoucherDetailLights.get(i).getStoreID());
            saleVDTblType.setCenter1ID(null);
            saleVDTblType.setCenter2ID(null);
            saleVDTblType.setCenter3ID(null);
            saleVDTblType.setiGUID(null);
            saleVDTblType.setTaxMab(null);
            saleVDTblType.setTollMab(null);
            saleVDTblType.setTaxCoEff(null);
            saleVDTblType.setIsPromotion(null);
            saleVDTblType.setBaseDReferID(null);
            saleVDTblType.setSecondGoodsID(null);
            saleVDTblType.setrRowMabPrice(null);
            saleVDTblType.setrRowMabPercent(null);
            saleVDTblTypesDetails[i] = saleVDTblType;
        }


        // add propotions to SaleVDTblType[] , isPromotion = true
        for (int i = 0; i < promotions.size(); i++) {
            SaleVDTblType saleVDTblType = new SaleVDTblType();
            saleVDTblType.setRowNo(new BigDecimal(saleVoucherDetailLights.size() + i + 1));
            saleVDTblType.setVoucherDetailID(null);
            saleVDTblType.setVoucherHeaderID(null);
            saleVDTblType.setGoodsID(promotions.get(i).getGoodsID());
            saleVDTblType.setSecUnitID(promotions.get(i).getSecUnitID());
            saleVDTblType.setQuantity(promotions.get(i).getQuantity());
            saleVDTblType.setFee(null);
            saleVDTblType.setDetailXDesc(null);
            saleVDTblType.setdReferID(null);
            saleVDTblType.setCreatorID(logLogins.getPubUser().getUserID());
            saleVDTblType.setModifierID(logLogins.getPubUser().getUserID());
            saleVDTblType.setDifferentialID(null);
            saleVDTblType.setComputeValue(null);
            saleVDTblType.setCustomField1(null);
            saleVDTblType.setCustomField2(null);
            saleVDTblType.setCustomField3(null);
            saleVDTblType.setCustomField4(null);
            saleVDTblType.setCustomField5(null);
            saleVDTblType.setCustomField6(null);
            saleVDTblType.setCustomField7(null);
            saleVDTblType.setCustomField8(null);
            saleVDTblType.setCustomField9(null);
            saleVDTblType.setCustomField10(null);
            saleVDTblType.setCustomField11(null);
            saleVDTblType.setFeeAgreement(null);
            saleVDTblType.setFeeDiscountPrice(new BigDecimal(0));
            saleVDTblType.setFeeDiscountPercent(new BigDecimal(0));
            saleVDTblType.setFeeFrieghtCharges(null);
            saleVDTblType.setAllocatedQuantity2(null);
            saleVDTblType.setOverAllocatedQuantity2(null);
            saleVDTblType.setLCReferID(null);
            saleVDTblType.setAgrReferID(null);
            saleVDTblType.setQuantity2(null);
            saleVDTblType.setQuantity3(null);
            saleVDTblType.setSecUnitID2(null);
            saleVDTblType.setSecUnitID3(null);
            saleVDTblType.setCustomField12(null);
            saleVDTblType.setCustomField13(null);
            saleVDTblType.setCustomField14(null);
            saleVDTblType.setCustomField15(null);
            saleVDTblType.setCustomField16(null);
            saleVDTblType.setCustomField17(null);
            saleVDTblType.setCustomField18(null);
            saleVDTblType.setCustomField19(null);
            saleVDTblType.setCustomField20(null);
            saleVDTblType.setCustomField21(null);
            saleVDTblType.setCustomField22(null);
            saleVDTblType.setCustomField23(null);
            saleVDTblType.setCustomField24(null);
            saleVDTblType.setCustomField25(null);
            saleVDTblType.setStoreID(null);
            saleVDTblType.setCenter1ID(null);
            saleVDTblType.setCenter2ID(null);
            saleVDTblType.setCenter3ID(null);
            saleVDTblType.setiGUID(null);
            saleVDTblType.setTaxMab(null);
            saleVDTblType.setTollMab(null);
            saleVDTblType.setTaxCoEff(null);
            saleVDTblType.setIsPromotion(true);
            saleVDTblType.setBaseDReferID(null);
            saleVDTblType.setSecondGoodsID(null);
            saleVDTblType.setrRowMabPrice(null);
            saleVDTblType.setrRowMabPercent(null);
            saleVDTblTypesPromotions[i] = saleVDTblType;
        }

        SaleVDTblType[] saleVDTblTypes = ArrayUtils.addAll(saleVDTblTypesDetails, saleVDTblTypesPromotions);

        //دیتیل هایی که در دیتابیس هست ولی در بادی وب سرویس نیست
        //این دیتیل ها باید داخل تی دل قرار گیرند

        //دیتیل های فعلی را از دیتابیس می گیریم
        ArrayList<TempT2> tempT2s = new ArrayList<>();
        List<SaleVoucherDetailLight> saleVoucherDetailsDBLight = saleVoucherDetailLightRepository.saleShowVoucherDetailLightByID(voucherHeaderID);
        for (int i = 0; i < saleVoucherDetailsDBLight.size(); i++) {
            SaleVoucherDetailLight saleVoucherDetailLightDB = saleVoucherDetailsDBLight.get(i);
            List<SaleVoucherDetailLight> saleVoucherDetailsFilteredLight = saleVoucherDetailLights.stream()
                    .filter(item -> {
                        if (item.getVoucherDetailID() != null) {
                            return item.getVoucherDetailID().intValue() == saleVoucherDetailLightDB.getVoucherDetailID().intValue();
                        }
                        return false;
                    })
                    .collect(Collectors.toList());
            if (saleVoucherDetailsFilteredLight.isEmpty()) {
                // یعنی این دیتیل در ویرایش فعلی حذف شده است و باید داخل تی دل قرار گیرد
                TempT2 tempT2 = new TempT2();
                tempT2.setmID(saleVoucherDetailLightDB.getVoucherDetailID());
                tempT2s.add(tempT2);
            }
        }

        TempT2[] tempT2Dels = new TempT2[tempT2s.size()];
        tempT2Dels = tempT2s.toArray(tempT2Dels);

        SQLServerDataRecordSaleVDTblType sQLServerDataRecordSaleVDTblType = new SQLServerDataRecordSaleVDTblType(saleVDTblTypes);
        SQLServerDataRecordTempT2 sqlServerDataRecordTempT2TDel = new SQLServerDataRecordTempT2(tempT2Dels);
        SQLServerDataRecordTSerial sqlServerDataRecordTSerial = new SQLServerDataRecordTSerial(new TSerial[0]);
        SQLServerDataRecordTempT2 sqlServerDataRecordTempT2TSerialDel = new SQLServerDataRecordTempT2(new TempT2[0]);
        SQLServerDataRecordTElement sqlServerDataRecordTempT2TElement = new SQLServerDataRecordTElement(new TElement[0]);


        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("VoucherNumber", saleVoucher.getHeader().getVoucherNumber()));
        TCalendar tc = new TCalendar();
        String manualDate = saleVoucher.getHeader().getVoucherDate(); //A date that json give us(user entered himself)
        if (manualDate != null) {
            tc.setIranianDateBySlash(manualDate);
            tParameters.add(new TParameter<>("VoucherDate", tc.getIranianDateBySlashZero()));
            tParameters.add(new TParameter<>("VoucherDateG", tc.getSqlDate()));
        } else { //Auto dating
            tParameters.add(new TParameter<>("VoucherDate", tc.getIranianDateBySlashZero()));
            tParameters.add(new TParameter<>("VoucherDateG", new Date()));

        }
        tParameters.add(new TParameter<>("CustomerID", saleVoucher.getHeader().getCustomerID()));
        tParameters.add(new TParameter<>("StoreID", saleVoucher.getHeader().getStoreID()));
        tParameters.add(new TParameter<>("VoucherTypeID", saleVoucher.getHeader().getVoucherTypeID()));
        tParameters.add(new TParameter<>("RefTypeID", saleVoucher.getHeader().getRefTypeID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("YearID", logLogins.getPubUser().getActiveYearID()));
        tParameters.add(new TParameter<>("SaleCenterID", saleVoucher.getHeader().getSaleCenterID()));
        tParameters.add(new TParameter<>("DeliverCenterID", saleVoucher.getHeader().getDeliverCenterID()));
        tParameters.add(new TParameter<>("VoucherDesc", saleVoucher.getHeader().getVoucherDesc()));
        tParameters.add(new TParameter<>("ReferNumber", saleVoucher.getHeader().getReferNumber()));
        tParameters.add(new TParameter<>("ReferDate", saleVoucher.getHeader().getReferDate()));
        tParameters.add(new TParameter<>("SalesManID", saleVoucher.getHeader().getSalesManID()));
        tParameters.add(new TParameter<>("MarketingManID", saleVoucher.getHeader().getMarketingManID()));
        tParameters.add(new TParameter<>("SaleTypeID", saleVoucher.getHeader().getSaleTypeID()));
        tParameters.add(new TParameter<>("SecondNumber", saleVoucher.getHeader().getSecondNumber()));
        tParameters.add(new TParameter<>("CurrencyID", saleVoucher.getHeader().getCurrencyID()));
        tParameters.add(new TParameter<>("PaymentWayID", saleVoucher.getHeader().getPaymentWayID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("ExtraDesc", saleVoucher.getHeader().getExtraDesc()));
        tParameters.add(new TParameter<>("ReferID", saleVoucher.getHeader().getReferID()));
        tParameters.add(new TParameter<>("AnalysisSetup", saleVoucher.getOther().getAnalysisSetup()));
        tParameters.add(new TParameter<>("Center1ID", saleVoucher.getHeader().getCenter1ID()));
        tParameters.add(new TParameter<>("Center2ID", saleVoucher.getHeader().getCenter2ID()));
        tParameters.add(new TParameter<>("Center3ID", saleVoucher.getHeader().getCenter3ID()));
        tParameters.add(new TParameter<>("AccountID", saleVoucher.getHeader().getAccountID()));
        tParameters.add(new TParameter<>("DayCount", saleVoucher.getHeader().getDayCount()));
        tParameters.add(new TParameter<>("DocPrice", saleVoucher.getHeader().getDocPrice()));
        tParameters.add(new TParameter<>("CashID", saleVoucher.getHeader().getCashID()));
        tParameters.add(new TParameter<>("BaseRefTypeID", saleVoucher.getHeader().getBaseRefTypeID()));
        tParameters.add(new TParameter<>("IsManualPromotion", saleVoucher.getHeader().getIsManualPromotion()));
        tParameters.add(new TParameter<>("IsAndroidUser", saleVoucher.getOther().getIsAndroidUser()));
        tParameters.add(new TParameter<>("IsAmendment", saleVoucher.getOther().getIsAmendment()));
        tParameters.add(new TParameter<>("ContractNumber", saleVoucher.getOther().getContractNumber()));
        tParameters.add(new TParameter<>("ContractDate", saleVoucher.getOther().getContractDate()));
        tParameters.add(new TParameter<>("BruntNumber", saleVoucher.getOther().getBruntNumber()));
        tParameters.add(new TParameter<>("CarNumber", saleVoucher.getOther().getCarNumber()));
        tParameters.add(new TParameter<>("OtherDesc", saleVoucher.getOther().getOtherDesc()));
        tParameters.add(new TParameter<>("XDesc", saleVoucher.getOther().getxDesc()));
        tParameters.add(new TParameter<>("DriverID", saleVoucher.getOther().getDriverID()));
        tParameters.add(new TParameter<>("DistNameID", saleVoucher.getOther().getDistNameID()));
        tParameters.add(new TParameter<>("RowID", saleVoucher.getHeader().getRowID()));
        tParameters.add(new TParameter<>("VoucherHeaderID", saleVoucher.getHeader().getVoucherHeaderID()));
        tParameters.add(new TParameter<>("TDel", "TempT2", sqlServerDataRecordTempT2TDel));
        tParameters.add(new TParameter<>("TVD", "SaleVDTblType", sQLServerDataRecordSaleVDTblType));
        tParameters.add(new TParameter<>("TSerial", "TSerial", sqlServerDataRecordTSerial));
        tParameters.add(new TParameter<>("TSerialDel", "TempT2", sqlServerDataRecordTempT2TSerialDel));
        tParameters.add(new TParameter<>("TElement", "TElement", sqlServerDataRecordTempT2TElement));
        tParameters.add(new TParameter<>("WebUserType", saleVoucher.getOther().getWebUserType()));
        tParameters.add(new TParameter<>("TableID", saleVoucher.getHeader().getTableID()));
        HashMap<String, Object> res = execute1("SaleInsVoucherHD", tParameters);
        BigDecimal result = (BigDecimal) res.get("Result");
        String errMsg = (String) res.get("ErrMsg");
        BigDecimal newID = (BigDecimal) res.get("NewID");
        if (result.intValue() == 0) {
            //if voucher was saved call saleInsPromotion for saving Elements
            promotionElementRepository.saleInsPromotion(newID, elements);
            return saleShowVoucher(
                    saleVoucherHeaderRepository,
                    saleVoucherDetailLightRepository,
                    newID);
        } else {
            throw new TConflictException(result.intValue(), errMsg);
        }
    }

}
