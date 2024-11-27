package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.ResultErrMsgNewID;
import com.tarazgroup.tws.dao.ShowSPReturnType;
import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.dao.inv.InvVoucherDetailRepository;
import com.tarazgroup.tws.dao.pub.PubCompanyRepository;
import com.tarazgroup.tws.model.inv.InvVoucherDetail;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.pub.PubCompany;
import com.tarazgroup.tws.model.sale.*;
import com.tarazgroup.tws.util.global.TCalendar;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.tabletype.sale.SaleVDTblType;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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

    String mine = "USE Alpha\n" +
            "\n" +
            "exec sp_executesql N'DECLARE @Result DECIMAL(38,4)\n" +
            "DECLARE @ErrMsg NVARCHAR(MAX)\n" +
            "DECLARE @NewID DECIMAL(38,4)\n" +
            "DECLARE @TDel dbo.TempT2\n" +
            "DECLARE @TVD dbo.SaleVDTblType\n" +
            "DECLARE @TSerial dbo.TSerial\n" +
            "DECLARE @TSerialDel dbo.TempT2\n" +
            "DECLARE @TElement dbo.TElement\n" +
            "INSERT INTO @TVD VALUES(\n" +
            "0, --rowNo\n" +
            "10593309, --voucherDetailID\n" +
            "NULL, --voucherHeaderID\n" +
            "10000005, --goodsID\n" +
            "10000001, --secUnitID\n" +
            "3, --quantity\n" +
            "1200, --fee\n" +
            "NULL, --detailXDesc\n" +
            "NULL, --dReferID\n" +
            "10000000, --creatorID\n" +
            "10000000, --modifierID\n" +
            "NULL, --differentialID\n" +
            "5, --computeValue\n" +
            "NULL, --customField1\n" +
            "NULL, --customField2\n" +
            "NULL, --customField3\n" +
            "NULL, --customField4\n" +
            "NULL, --customField5\n" +
            "NULL, --customField6\n" +
            "NULL, --customField7\n" +
            "NULL, --customField8\n" +
            "NULL, --customField9\n" +
            "NULL, --customField10\n" +
            "NULL, --customField11\n" +
            "1200, --feeAgreement\n" +
            "NULL, --feeDiscountPrice\n" +
            "NULL, --feeDiscountPercent\n" +
            "NULL, --feeFrieghtCharges\n" +
            "NULL, --allocatedQuantity2\n" +
            "NULL, --overAllocatedQuantity2\n" +
            "NULL, --lCReferID\n" +
            "NULL, --agrReferID\n" +
            "NULL, --quantity2\n" +
            "NULL, --quantity3\n" +
            "NULL, --secUnitID2\n" +
            "NULL, --secUnitID3\n" +
            "NULL, --customField12\n" +
            "NULL, --customField13\n" +
            "NULL, --customField14\n" +
            "NULL, --customField15\n" +
            "NULL, --customField16\n" +
            "NULL, --customField17\n" +
            "NULL, --customField18\n" +
            "NULL, --customField19\n" +
            "NULL, --customField20\n" +
            "NULL, --customField21\n" +
            "NULL, --customField22\n" +
            "NULL, --customField23\n" +
            "NULL, --customField24\n" +
            "NULL, --customField25\n" +
            "NULL, --storeID\n" +
            "NULL, --center1ID\n" +
            "NULL, --center2ID\n" +
            "NULL, --center3ID\n" +
            "NULL, --iGUID\n" +
            "NULL, --taxMab\n" +
            "NULL, --tollMab\n" +
            "NULL, --taxCoEff\n" +
            "NULL, --isPromotion\n" +
            "NULL, --baseDReferID\n" +
            "NULL, --secondGoodsID\n" +
            "NULL, --rRowMabPrice\n" +
            "NULL, --rRowMabPercent\n" +
            "NULL, --tollCoEff\n" +
            "NULL, --currencyID\n" +
            "NULL --analysisNo\n" +
            ")\n" +
            "\n" +
            "INSERT INTO @TVD VALUES(\n" +
            "1, --rowNo\n" +
            "10593310, --voucherDetailID\n" +
            "NULL, --voucherHeaderID\n" +
            "10000005, --goodsID\n" +
            "10000001, --secUnitID\n" +
            "14, --quantity\n" +
            "1250, --fee\n" +
            "NULL, --detailXDesc\n" +
            "NULL, --dReferID\n" +
            "10000000, --creatorID\n" +
            "10000000, --modifierID\n" +
            "NULL, --differentialID\n" +
            "5, --computeValue\n" +
            "NULL, --customField1\n" +
            "NULL, --customField2\n" +
            "NULL, --customField3\n" +
            "NULL, --customField4\n" +
            "NULL, --customField5\n" +
            "NULL, --customField6\n" +
            "NULL, --customField7\n" +
            "NULL, --customField8\n" +
            "NULL, --customField9\n" +
            "NULL, --customField10\n" +
            "NULL, --customField11\n" +
            "1250, --feeAgreement\n" +
            "NULL, --feeDiscountPrice\n" +
            "NULL, --feeDiscountPercent\n" +
            "NULL, --feeFrieghtCharges\n" +
            "NULL, --allocatedQuantity2\n" +
            "NULL, --overAllocatedQuantity2\n" +
            "NULL, --lCReferID\n" +
            "NULL, --agrReferID\n" +
            "NULL, --quantity2\n" +
            "NULL, --quantity3\n" +
            "NULL, --secUnitID2\n" +
            "NULL, --secUnitID3\n" +
            "NULL, --customField12\n" +
            "NULL, --customField13\n" +
            "NULL, --customField14\n" +
            "NULL, --customField15\n" +
            "NULL, --customField16\n" +
            "NULL, --customField17\n" +
            "NULL, --customField18\n" +
            "NULL, --customField19\n" +
            "NULL, --customField20\n" +
            "NULL, --customField21\n" +
            "NULL, --customField22\n" +
            "NULL, --customField23\n" +
            "NULL, --customField24\n" +
            "NULL, --customField25\n" +
            "NULL, --storeID\n" +
            "NULL, --center1ID\n" +
            "NULL, --center2ID\n" +
            "NULL, --center3ID\n" +
            "NULL, --iGUID\n" +
            "NULL, --taxMab\n" +
            "NULL, --tollMab\n" +
            "NULL, --taxCoEff\n" +
            "NULL, --isPromotion\n" +
            "NULL, --baseDReferID\n" +
            "NULL, --secondGoodsID\n" +
            "NULL, --rRowMabPrice\n" +
            "NULL, --rRowMabPercent\n" +
            "NULL, --tollCoEff\n" +
            "NULL, --currencyID\n" +
            "NULL --analysisNo\n" +
            ")\n" +
            "\n" +
            "EXEC SaleInsVoucherHD\n" +
            "8207, --VoucherNumber\n" +
            "''1401/11/01'', --VoucherDate\n" +
            "''2023/01/21 12:36:45'', --VoucherDateG\n" +
            "NULL, --CustomerID\n" +
            "10000001, --StoreID\n" +
            "6001, --VoucherTypeID\n" +
            "NULL, --RefTypeID\n" +
            "10000000, --CreatorID\n" +
            "10000000, --ModifierID\n" +
            "10000021, --YearID\n" +
            "10000001, --SaleCenterID\n" +
            "10000002, --DeliverCenterID\n" +
            "NULL, --VoucherDesc\n" +
            "NULL, --ReferNumber\n" +
            "NULL, --ReferDate\n" +
            "NULL, --SalesManID\n" +
            "10000086, --MarketingManID\n" +
            "10000002, --SaleTypeID\n" +
            "NULL, --SecondNumber\n" +
            "NULL, --CurrencyID\n" +
            "28, --PaymentWayID\n" +
            "@Result OUTPUT, --Result\n" +
            "30476, --LoginID\n" +
            "@ErrMsg OUTPUT, --ErrMsg\n" +
            "NULL, --ExtraDesc\n" +
            "@NewID OUTPUT, --NewID\n" +
            "NULL, --ReferID\n" +
            "NULL, --AnalysisSetup\n" +
            "NULL, --Center1ID\n" +
            "NULL, --Center2ID\n" +
            "NULL, --Center3ID\n" +
            "NULL, --AccountID\n" +
            "NULL, --DayCount\n" +
            "NULL, --DocPrice\n" +
            "NULL, --CashID\n" +
            "NULL, --BaseRefTypeID\n" +
            "NULL, --IsManualPromotion\n" +
            "NULL, --IsAndroidUser\n" +
            "NULL, --IsAmendment\n" +
            "NULL, --ContractNumber\n" +
            "NULL, --ContractDate\n" +
            "NULL, --BruntNumber\n" +
            "NULL, --CarNumber\n" +
            "NULL, --OtherDesc\n" +
            "NULL, --XDesc\n" +
            "NULL, --DriverID\n" +
            "NULL, --DistNameID\n" +
            "NULL, --RowID\n" +
            "NULL, --VoucherHeaderID\n" +
            "@TDel, --TDel\n" +
            "@TVD, --TVD\n" +
            "@TSerial, --TSerial\n" +
            "@TSerialDel, --TSerialDel\n" +
            "@TElement, --TElement\n" +
            "NULL, --WebUserType\n" +
            "NULL, --TableID\n" +
            "NULL --TafsiliTypeID\n" +
            "SELECT @Result AS Result,@ErrMsg AS ErrMsg,@NewID AS NewID'";


    // Not enough in store
    String myString2 = "use Alpha\n" +
            "exec sp_executesql N'DECLARE @Result DECIMAL(38,4)\n" +
            "DECLARE @ErrMsg NVARCHAR(MAX)\n" +
            "DECLARE @NewID DECIMAL(38,4)\n" +
            "DECLARE @TDel dbo.TempT2\n" +
            "DECLARE @TVD dbo.SaleVDTblType\n" +
            "DECLARE @TSerial dbo.TSerial\n" +
            "DECLARE @TSerialDel dbo.TempT2\n" +
            "DECLARE @TElement dbo.TElement\n" +
            "INSERT INTO @TVD VALUES(\n" +
            "0, --rowNo\n" +
            "NULL, --voucherDetailID\n" +
            "NULL, --voucherHeaderID\n" +
            "10000005, --goodsID\n" +
            "10000001, --secUnitID\n" +
            "3, --quantity\n" +
            "1200, --fee\n" +
            "NULL, --detailXDesc\n" +
            "NULL, --dReferID\n" +
            "10000000, --creatorID\n" +
            "10000000, --modifierID\n" +
            "NULL, --differentialID\n" +
            "NULL, --computeValue\n" +
            "NULL, --customField1\n" +
            "NULL, --customField2\n" +
            "NULL, --customField3\n" +
            "NULL, --customField4\n" +
            "NULL, --customField5\n" +
            "NULL, --customField6\n" +
            "NULL, --customField7\n" +
            "NULL, --customField8\n" +
            "NULL, --customField9\n" +
            "NULL, --customField10\n" +
            "NULL, --customField11\n" +
            "1200, --feeAgreement\n" +
            "NULL, --feeDiscountPrice\n" +
            "NULL, --feeDiscountPercent\n" +
            "NULL, --feeFrieghtCharges\n" +
            "NULL, --allocatedQuantity2\n" +
            "NULL, --overAllocatedQuantity2\n" +
            "NULL, --lCReferID\n" +
            "NULL, --agrReferID\n" +
            "NULL, --quantity2\n" +
            "NULL, --quantity3\n" +
            "NULL, --secUnitID2\n" +
            "NULL, --secUnitID3\n" +
            "NULL, --customField12\n" +
            "NULL, --customField13\n" +
            "NULL, --customField14\n" +
            "NULL, --customField15\n" +
            "NULL, --customField16\n" +
            "NULL, --customField17\n" +
            "NULL, --customField18\n" +
            "NULL, --customField19\n" +
            "NULL, --customField20\n" +
            "NULL, --customField21\n" +
            "NULL, --customField22\n" +
            "NULL, --customField23\n" +
            "NULL, --customField24\n" +
            "NULL, --customField25\n" +
            "NULL, --storeID\n" +
            "NULL, --center1ID\n" +
            "NULL, --center2ID\n" +
            "NULL, --center3ID\n" +
            "NULL, --iGUID\n" +
            "NULL, --taxMab\n" +
            "NULL, --tollMab\n" +
            "NULL, --taxCoEff\n" +
            "NULL, --isPromotion\n" +
            "NULL, --baseDReferID\n" +
            "NULL, --secondGoodsID\n" +
            "NULL, --rRowMabPrice\n" +
            "NULL, --rRowMabPercent\n" +
            "NULL, --tollCoEff\n" +
            "NULL, --currencyID\n" +
            "NULL --analysisNo\n" +
            ")\n" +
            "\n" +
            "INSERT INTO @TVD VALUES(\n" +
            "1, --rowNo\n" +
            "NULL, --voucherDetailID\n" +
            "NULL, --voucherHeaderID\n" +
            "10000005, --goodsID\n" +
            "10000001, --secUnitID\n" +
            "14, --quantity\n" +
            "1250, --fee\n" +
            "NULL, --detailXDesc\n" +
            "NULL, --dReferID\n" +
            "10000000, --creatorID\n" +
            "10000000, --modifierID\n" +
            "NULL, --differentialID\n" +
            "NULL, --computeValue\n" +
            "NULL, --customField1\n" +
            "NULL, --customField2\n" +
            "NULL, --customField3\n" +
            "NULL, --customField4\n" +
            "NULL, --customField5\n" +
            "NULL, --customField6\n" +
            "NULL, --customField7\n" +
            "NULL, --customField8\n" +
            "NULL, --customField9\n" +
            "NULL, --customField10\n" +
            "NULL, --customField11\n" +
            "1250, --feeAgreement\n" +
            "NULL, --feeDiscountPrice\n" +
            "NULL, --feeDiscountPercent\n" +
            "NULL, --feeFrieghtCharges\n" +
            "NULL, --allocatedQuantity2\n" +
            "NULL, --overAllocatedQuantity2\n" +
            "NULL, --lCReferID\n" +
            "NULL, --agrReferID\n" +
            "NULL, --quantity2\n" +
            "NULL, --quantity3\n" +
            "NULL, --secUnitID2\n" +
            "NULL, --secUnitID3\n" +
            "NULL, --customField12\n" +
            "NULL, --customField13\n" +
            "NULL, --customField14\n" +
            "NULL, --customField15\n" +
            "NULL, --customField16\n" +
            "NULL, --customField17\n" +
            "NULL, --customField18\n" +
            "NULL, --customField19\n" +
            "NULL, --customField20\n" +
            "NULL, --customField21\n" +
            "NULL, --customField22\n" +
            "NULL, --customField23\n" +
            "NULL, --customField24\n" +
            "NULL, --customField25\n" +
            "NULL, --storeID\n" +
            "NULL, --center1ID\n" +
            "NULL, --center2ID\n" +
            "NULL, --center3ID\n" +
            "NULL, --iGUID\n" +
            "NULL, --taxMab\n" +
            "NULL, --tollMab\n" +
            "NULL, --taxCoEff\n" +
            "NULL, --isPromotion\n" +
            "NULL, --baseDReferID\n" +
            "NULL, --secondGoodsID\n" +
            "NULL, --rRowMabPrice\n" +
            "NULL, --rRowMabPercent\n" +
            "NULL, --tollCoEff\n" +
            "NULL, --currencyID\n" +
            "NULL --analysisNo\n" +
            ")\n" +
            "\n" +
            "EXEC SaleInsVoucherHD\n" +
            "1, --VoucherNumber\n" +
            "''1401/09/10'', --VoucherDate\n" +
            "''2022/12/01 10:41:12'', --VoucherDateG\n" +
            "10000003, --CustomerID\n" +
            "10000001, --StoreID\n" +
            "6001, --VoucherTypeID\n" +
            "NULL, --RefTypeID\n" +
            "10000000, --CreatorID\n" +
            "10000000, --ModifierID\n" +
            "10000021, --YearID\n" +
            "10000001, --SaleCenterID\n" +
            "10000002, --DeliverCenterID\n" +
            "NULL, --VoucherDesc\n" +
            "NULL, --ReferNumber\n" +
            "NULL, --ReferDate\n" +
            "10000003, --SalesManID\n" +
            "10000003, --MarketingManID\n" +
            "NULL, --SaleTypeID\n" +
            "NULL, --SecondNumber\n" +
            "NULL, --CurrencyID\n" +
            "28, --PaymentWayID\n" +
            "@Result OUTPUT, --Result\n" +
            "28787, --LoginID\n" +
            "@ErrMsg OUTPUT, --ErrMsg\n" +
            "NULL, --ExtraDesc\n" +
            "@NewID OUTPUT, --NewID\n" +
            "NULL, --ReferID\n" +
            "NULL, --AnalysisSetup\n" +
            "NULL, --Center1ID\n" +
            "NULL, --Center2ID\n" +
            "NULL, --Center3ID\n" +
            "NULL, --AccountID\n" +
            "15, --DayCount\n" +
            "NULL, --DocPrice\n" +
            "NULL, --CashID\n" +
            "NULL, --BaseRefTypeID\n" +
            "NULL, --IsManualPromotion\n" +
            "NULL, --IsAndroidUser\n" +
            "NULL, --IsAmendment\n" +
            "NULL, --ContractNumber\n" +
            "NULL, --ContractDate\n" +
            "NULL, --BruntNumber\n" +
            "NULL, --CarNumber\n" +
            "NULL, --OtherDesc\n" +
            "NULL, --XDesc\n" +
            "NULL, --DriverID\n" +
            "NULL, --DistNameID\n" +
            "NULL, --RowID\n" +
            "NULL, --VoucherHeaderID\n" +
            "@TDel, --TDel\n" +
            "@TVD, --TVD\n" +
            "@TSerial, --TSerial\n" +
            "@TSerialDel, --TSerialDel\n" +
            "@TElement, --TElement\n" +
            "NULL, --WebUserType\n" +
            "NULL, --TableID\n" +
            "NULL --TafsiliTypeID\n" +
            "SELECT @Result AS Result,@ErrMsg AS ErrMsg,@NewID AS NewID'";

    // Not a valid date in voucher
    String myString1 = "use Alpha\n" +
            "exec sp_executesql N'DECLARE @Result DECIMAL(38,4)\n" +
            "DECLARE @ErrMsg NVARCHAR(MAX)\n" +
            "DECLARE @NewID DECIMAL(38,4)\n" +
            "DECLARE @TDel dbo.TempT2\n" +
            "DECLARE @TVD dbo.SaleVDTblType\n" +
            "DECLARE @TSerial dbo.TSerial\n" +
            "DECLARE @TSerialDel dbo.TempT2\n" +
            "DECLARE @TElement dbo.TElement\n" +
            "INSERT INTO @TVD VALUES(\n" +
            "0, --rowNo\n" +
            "NULL, --voucherDetailID\n" +
            "NULL, --voucherHeaderID\n" +
            "10000005, --goodsID\n" +
            "10000001, --secUnitID\n" +
            "3, --quantity\n" +
            "1200, --fee\n" +
            "NULL, --detailXDesc\n" +
            "NULL, --dReferID\n" +
            "10000000, --creatorID\n" +
            "10000000, --modifierID\n" +
            "NULL, --differentialID\n" +
            "NULL, --computeValue\n" +
            "NULL, --customField1\n" +
            "NULL, --customField2\n" +
            "NULL, --customField3\n" +
            "NULL, --customField4\n" +
            "NULL, --customField5\n" +
            "NULL, --customField6\n" +
            "NULL, --customField7\n" +
            "NULL, --customField8\n" +
            "NULL, --customField9\n" +
            "NULL, --customField10\n" +
            "NULL, --customField11\n" +
            "1200, --feeAgreement\n" +
            "NULL, --feeDiscountPrice\n" +
            "NULL, --feeDiscountPercent\n" +
            "NULL, --feeFrieghtCharges\n" +
            "NULL, --allocatedQuantity2\n" +
            "NULL, --overAllocatedQuantity2\n" +
            "NULL, --lCReferID\n" +
            "NULL, --agrReferID\n" +
            "NULL, --quantity2\n" +
            "NULL, --quantity3\n" +
            "NULL, --secUnitID2\n" +
            "NULL, --secUnitID3\n" +
            "NULL, --customField12\n" +
            "NULL, --customField13\n" +
            "NULL, --customField14\n" +
            "NULL, --customField15\n" +
            "NULL, --customField16\n" +
            "NULL, --customField17\n" +
            "NULL, --customField18\n" +
            "NULL, --customField19\n" +
            "NULL, --customField20\n" +
            "NULL, --customField21\n" +
            "NULL, --customField22\n" +
            "NULL, --customField23\n" +
            "NULL, --customField24\n" +
            "NULL, --customField25\n" +
            "NULL, --storeID\n" +
            "NULL, --center1ID\n" +
            "NULL, --center2ID\n" +
            "NULL, --center3ID\n" +
            "NULL, --iGUID\n" +
            "NULL, --taxMab\n" +
            "NULL, --tollMab\n" +
            "NULL, --taxCoEff\n" +
            "NULL, --isPromotion\n" +
            "NULL, --baseDReferID\n" +
            "NULL, --secondGoodsID\n" +
            "NULL, --rRowMabPrice\n" +
            "NULL, --rRowMabPercent\n" +
            "NULL, --tollCoEff\n" +
            "NULL, --currencyID\n" +
            "NULL --analysisNo\n" +
            ")\n" +
            "\n" +
            "INSERT INTO @TVD VALUES(\n" +
            "1, --rowNo\n" +
            "NULL, --voucherDetailID\n" +
            "NULL, --voucherHeaderID\n" +
            "10000005, --goodsID\n" +
            "10000001, --secUnitID\n" +
            "14, --quantity\n" +
            "1250, --fee\n" +
            "NULL, --detailXDesc\n" +
            "NULL, --dReferID\n" +
            "10000000, --creatorID\n" +
            "10000000, --modifierID\n" +
            "NULL, --differentialID\n" +
            "NULL, --computeValue\n" +
            "NULL, --customField1\n" +
            "NULL, --customField2\n" +
            "NULL, --customField3\n" +
            "NULL, --customField4\n" +
            "NULL, --customField5\n" +
            "NULL, --customField6\n" +
            "NULL, --customField7\n" +
            "NULL, --customField8\n" +
            "NULL, --customField9\n" +
            "NULL, --customField10\n" +
            "NULL, --customField11\n" +
            "1250, --feeAgreement\n" +
            "NULL, --feeDiscountPrice\n" +
            "NULL, --feeDiscountPercent\n" +
            "NULL, --feeFrieghtCharges\n" +
            "NULL, --allocatedQuantity2\n" +
            "NULL, --overAllocatedQuantity2\n" +
            "NULL, --lCReferID\n" +
            "NULL, --agrReferID\n" +
            "NULL, --quantity2\n" +
            "NULL, --quantity3\n" +
            "NULL, --secUnitID2\n" +
            "NULL, --secUnitID3\n" +
            "NULL, --customField12\n" +
            "NULL, --customField13\n" +
            "NULL, --customField14\n" +
            "NULL, --customField15\n" +
            "NULL, --customField16\n" +
            "NULL, --customField17\n" +
            "NULL, --customField18\n" +
            "NULL, --customField19\n" +
            "NULL, --customField20\n" +
            "NULL, --customField21\n" +
            "NULL, --customField22\n" +
            "NULL, --customField23\n" +
            "NULL, --customField24\n" +
            "NULL, --customField25\n" +
            "NULL, --storeID\n" +
            "NULL, --center1ID\n" +
            "NULL, --center2ID\n" +
            "NULL, --center3ID\n" +
            "NULL, --iGUID\n" +
            "NULL, --taxMab\n" +
            "NULL, --tollMab\n" +
            "NULL, --taxCoEff\n" +
            "NULL, --isPromotion\n" +
            "NULL, --baseDReferID\n" +
            "NULL, --secondGoodsID\n" +
            "NULL, --rRowMabPrice\n" +
            "NULL, --rRowMabPercent\n" +
            "NULL, --tollCoEff\n" +
            "NULL, --currencyID\n" +
            "NULL --analysisNo\n" +
            ")\n" +
            "\n" +
            "EXEC SaleInsVoucherHD\n" +
            "1, --VoucherNumber\n" +
            "''1401/09/13'', --VoucherDate\n" +
            "''2022/12/04 10:47:07'', --VoucherDateG\n" +
            "10000003, --CustomerID\n" +
            "10000001, --StoreID\n" +
            "6001, --VoucherTypeID\n" +
            "NULL, --RefTypeID\n" +
            "10000000, --CreatorID\n" +
            "10000000, --ModifierID\n" +
            "10000020, --YearID\n" +
            "10000001, --SaleCenterID\n" +
            "10000002, --DeliverCenterID\n" +
            "NULL, --VoucherDesc\n" +
            "NULL, --ReferNumber\n" +
            "NULL, --ReferDate\n" +
            "10000003, --SalesManID\n" +
            "10000003, --MarketingManID\n" +
            "NULL, --SaleTypeID\n" +
            "NULL, --SecondNumber\n" +
            "NULL, --CurrencyID\n" +
            "28, --PaymentWayID\n" +
            "@Result OUTPUT, --Result\n" +
            "28885, --LoginID\n" +
            "@ErrMsg OUTPUT, --ErrMsg\n" +
            "NULL, --ExtraDesc\n" +
            "@NewID OUTPUT, --NewID\n" +
            "NULL, --ReferID\n" +
            "NULL, --AnalysisSetup\n" +
            "NULL, --Center1ID\n" +
            "NULL, --Center2ID\n" +
            "NULL, --Center3ID\n" +
            "NULL, --AccountID\n" +
            "15, --DayCount\n" +
            "NULL, --DocPrice\n" +
            "NULL, --CashID\n" +
            "NULL, --BaseRefTypeID\n" +
            "NULL, --IsManualPromotion\n" +
            "NULL, --IsAndroidUser\n" +
            "NULL, --IsAmendment\n" +
            "NULL, --ContractNumber\n" +
            "NULL, --ContractDate\n" +
            "NULL, --BruntNumber\n" +
            "NULL, --CarNumber\n" +
            "NULL, --OtherDesc\n" +
            "NULL, --XDesc\n" +
            "NULL, --DriverID\n" +
            "NULL, --DistNameID\n" +
            "NULL, --RowID\n" +
            "NULL, --VoucherHeaderID\n" +
            "@TDel, --TDel\n" +
            "@TVD, --TVD\n" +
            "@TSerial, --TSerial\n" +
            "@TSerialDel, --TSerialDel\n" +
            "@TElement, --TElement\n" +
            "NULL, --WebUserType\n" +
            "NULL, --TableID\n" +
            "NULL --TafsiliTypeID\n" +
            "SELECT @Result AS Result,@ErrMsg AS ErrMsg,@NewID AS NewID'";


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
        return exportCrystalReportToPDF(SaleVoucher.class, "novinchoob", parameterFields, tParameters, ShowSPReturnType.NATIVE);
    }

    default SaleVoucher saleInsVoucherHD(
            BigDecimal voucherHeaderID,
            SaleVoucherHeaderRepository saleVoucherHeaderRepository,
            SaleVoucherDetailLightRepository saleVoucherDetailLightRepository,
            InvVoucherDetailRepository invVoucherDetailRepository,
            PromotionElementRepository promotionElementRepository,
            SaleSysSetupRepository saleSysSetupRepository,
            SaleVoucher saleVoucher
    ) {
        LogLogins logLogins = fetchUserDetail();
        SaleSysSetup saleSysSetup = saleSysSetupRepository.selectSaleSysSetup();
        List<SaleVoucherDetailLight> saleVoucherDetailLights = saleVoucher.getDetails();
        SaleVoucherHeader saleVoucherHeader = saleVoucher.getHeader();

        SaleVoucherOther saleVoucherOther = saleVoucher.getOther();
        List<Promotion> promotions = saleVoucher.getPromotions();
        List<Element> elements = saleVoucher.getElements();

        // وقتی که سند مرجع دارد است و جایزه هم دارد جایزه ها باید از این لیست مصرف شود
        List<InvVoucherDetail> invVoucherDetailsForConsuming = null;

        List<InvVoucherDetail> voucherDetailsForPromotion = new ArrayList<>();

        // آیا این سند مرجع دارد
        boolean hasRefer = false;
        if (saleVoucher.getHeader().getRefTypeID() != null) {
            hasRefer = true;
            invVoucherDetailsForConsuming = invVoucherDetailRepository.invShowVoucherDetailReferWithoutImage(
                    saleVoucherHeader.getStoreID(),
                    saleVoucherHeader.getVoucherTypeID(),
                    saleVoucherHeader.getRefTypeID());
        }

        TCalendar tCalendar = new TCalendar();
        String manualDate = saleVoucherHeader.getVoucherDate();
        String voucherDate;
        String voucherDateG;
        if (manualDate != null) {
            // تاریخ از سمت یوزر پر شده
            tCalendar.setIranianDateBySlash(manualDate);
        }
        voucherDate = tCalendar.getIranianDateBySlashZero();
        voucherDateG = tCalendar.getGregorianDateByTime();

        List<TParameter<?>> tParameters = new ArrayList<>();
        List<SaleVDTblType> saleVDTblTypes = new ArrayList<>();// در این لیست هم کالا و هم جایزه قرار میگیرد
        for (int i = 0; i < saleVoucherDetailLights.size(); i++) {
            if (hasRefer) {
                // اگر سند مرجع دار است باید بابت تک تک ردیف های سند فعلی ردیف های مراجع قبلی مصرف شود
                // انتهای این حلقه فور ردیف های نهایی که برای مصرف جایزه باقی میماند در
                // voucherDetailsForPromotion
                // وجود دارد
                voucherDetailsForPromotion.addAll(consumeVoucherDetailsForCurrentGoods(
                        saleVoucherDetailLights.get(i).getGoodsID(),
                        saleVoucherDetailLights.get(i).getQuantity(),
                        invVoucherDetailsForConsuming));
            }
            // افزودن کالا
            SaleVDTblType saleVDTblType = new SaleVDTblType();
            saleVDTblType.setRowNo(new BigDecimal(i));
            saleVDTblType.setVoucherDetailID(saleVoucherDetailLights.get(i).getVoucherDetailID());
            saleVDTblType.setVoucherHeaderID(voucherHeaderID);
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
            if (saleSysSetup.getIsStoreInDet() == false) {
                // اگر تنظیمات فروش بگوید که انبار ردیفی نداریم
                saleVDTblType.setStoreID(null);
            } else {
                // اگر تنظیمات فروش بگوید که انبار ردیفی داریم
                saleVDTblType.setStoreID(saleVoucherDetailLights.get(i).getStoreID());
            }
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
            saleVDTblType.setTollCoEff(null);
            saleVDTblType.setAnalysisNo(null);
            saleVDTblTypes.add(saleVDTblType);
        }

        for (int i = 0; i < promotions.size(); i++) {
            // افزودن جایزه
            SaleVDTblType saleVDTblType = new SaleVDTblType();
            if (hasRefer) {
                // اگر این سند مرجع دارد است
                // نمیتوان همین جوری !!! جایزه محاسبه شده را به سند اضافه کرد
                // بلکه این جایزه باید از ردیف سند های مراجع قبلی مصرف شود
                saleVDTblType.setdReferID(computeDReferID(
                        promotions.get(i),
                        voucherDetailsForPromotion
                ));
            } else {
                // وقتی سند مرجع دار نیست براحتی میتوان جایزه به سند اضافه کرد
                // و نیازی به ست کردن
                // dReferID
                // نیست
                saleVDTblType.setdReferID(null);
            }
            saleVDTblType.setRowNo(new BigDecimal(saleVoucherDetailLights.size() + i));
            saleVDTblType.setVoucherDetailID(null);// حتما باید نال باشد
            saleVDTblType.setVoucherHeaderID(null);// حتما باید نال باشد
            saleVDTblType.setGoodsID(promotions.get(i).getGoodsID());
            saleVDTblType.setSecUnitID(promotions.get(i).getSecUnitID());
            saleVDTblType.setQuantity(promotions.get(i).getQuantity());
            saleVDTblType.setFee(null);
            saleVDTblType.setDetailXDesc(null);


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
            saleVDTblType.setAnalysisNo(null);
            saleVDTblTypes.add(saleVDTblType);
        }

        if (saleVoucherHeader.getVoucherNumber() == null) {
            // Insert
            tParameters.add(new TParameter<>("VoucherNumber", new BigDecimal(1)));
        } else {
            // Update
            tParameters.add(new TParameter<>("VoucherNumber", saleVoucherHeader.getVoucherNumber()));
        }
        tParameters.add(new TParameter<>("VoucherDate", voucherDate));
        tParameters.add(new TParameter<>("VoucherDateG", voucherDateG));
        tParameters.add(new TParameter<>("CustomerID", saleVoucherHeader.getCustomerID()));
        tParameters.add(new TParameter<>("StoreID", saleVoucherHeader.getStoreID()));
        tParameters.add(new TParameter<>("VoucherTypeID", saleVoucherHeader.getVoucherTypeID()));
        tParameters.add(new TParameter<>("RefTypeID", saleVoucherHeader.getRefTypeID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("YearID", logLogins.getPubUser().getActiveYearID()));
        tParameters.add(new TParameter<>("SaleCenterID", saleVoucherHeader.getSaleCenterID()));
        tParameters.add(new TParameter<>("DeliverCenterID", saleVoucherHeader.getDeliverCenterID()));
        tParameters.add(new TParameter<>("VoucherDesc", saleVoucherHeader.getVoucherDesc()));
        tParameters.add(new TParameter<>("ReferNumber", saleVoucherHeader.getReferNumber()));
        tParameters.add(new TParameter<>("ReferDate", saleVoucherHeader.getReferDate()));
        tParameters.add(new TParameter<>("SalesManID", saleVoucherHeader.getSalesManID()));
        tParameters.add(new TParameter<>("MarketingManID", saleVoucherHeader.getMarketingManID()));
        tParameters.add(new TParameter<>("SaleTypeID", saleVoucherHeader.getSaleTypeID()));
        tParameters.add(new TParameter<>("SecondNumber", saleVoucherHeader.getSecondNumber()));
        tParameters.add(new TParameter<>("CurrencyID", saleVoucherHeader.getCurrencyID()));
        tParameters.add(new TParameter<>("PaymentWayID", saleVoucherHeader.getPaymentWayID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("ExtraDesc", saleVoucherHeader.getExtraDesc()));
        tParameters.add(new TParameter<>("ReferID", saleVoucherHeader.getReferID()));
        tParameters.add(new TParameter<>("AnalysisSetup", saleVoucherOther.getAnalysisSetup()));
        tParameters.add(new TParameter<>("Center1ID", saleVoucherHeader.getCenter1ID()));
        tParameters.add(new TParameter<>("Center2ID", saleVoucherHeader.getCenter2ID()));
        tParameters.add(new TParameter<>("Center3ID", saleVoucherHeader.getCenter3ID()));
        tParameters.add(new TParameter<>("AccountID", saleVoucherHeader.getAccountID()));
        tParameters.add(new TParameter<>("DayCount", saleVoucherHeader.getDayCount()));
        tParameters.add(new TParameter<>("DocPrice", saleVoucherHeader.getDocPrice()));
        tParameters.add(new TParameter<>("CashID", saleVoucherHeader.getCashID()));
        tParameters.add(new TParameter<>("BaseRefTypeID", saleVoucherHeader.getBaseRefTypeID()));
        tParameters.add(new TParameter<>("IsManualPromotion", saleVoucherHeader.getIsManualPromotion()));
        tParameters.add(new TParameter<>("IsAndroidUser", saleVoucherOther.getIsAndroidUser()));
        tParameters.add(new TParameter<>("IsAmendment", saleVoucherOther.getIsAmendment()));
        tParameters.add(new TParameter<>("ContractNumber", saleVoucherOther.getContractNumber()));
        tParameters.add(new TParameter<>("ContractDate", saleVoucherOther.getContractDate()));
        tParameters.add(new TParameter<>("BruntNumber", saleVoucherOther.getBruntNumber()));
        tParameters.add(new TParameter<>("CarNumber", saleVoucherOther.getCarNumber()));
        tParameters.add(new TParameter<>("OtherDesc", saleVoucherOther.getOtherDesc()));
        tParameters.add(new TParameter<>("XDesc", saleVoucherOther.getxDesc()));
        tParameters.add(new TParameter<>("DriverID", saleVoucherOther.getDriverID()));
        tParameters.add(new TParameter<>("DistNameID", saleVoucherOther.getDistNameID()));
        tParameters.add(new TParameter<>("RowID", saleVoucherHeader.getRowID()));
        tParameters.add(new TParameter<>("VoucherHeaderID", voucherHeaderID));
        tParameters.add(new TParameter<>("TDel", null));
        tParameters.add(new TParameter<>("TVD", saleVDTblTypes));
        tParameters.add(new TParameter<>("TSerial", null));
        tParameters.add(new TParameter<>("TSerialDel", null));
        tParameters.add(new TParameter<>("TElement", null));
        tParameters.add(new TParameter<>("WebUserType", saleVoucherOther.getWebUserType()));
        tParameters.add(new TParameter<>("TableID", saleVoucherHeader.getTableID()));
        tParameters.add(new TParameter<>("TafsiliTypeID", null));
        ResultErrMsgNewID resultErrMsgNewID = execSPNativeQuery(SaleVoucher.class, "SaleInsVoucherHD", tParameters);

        promotionElementRepository.saleInsPromotion(resultErrMsgNewID.getNewID(), elements);
        return saleShowVoucher(
                saleVoucherHeaderRepository,
                saleVoucherDetailLightRepository,
                resultErrMsgNewID.getNewID());
    }

    default SaleVoucher saleInsVoucherHDCrm(
            BigDecimal voucherHeaderID,
            SaleVoucherHeaderRepository saleVoucherHeaderRepository,
            SaleVoucherDetailLightRepository saleVoucherDetailLightRepository,
            InvVoucherDetailRepository invVoucherDetailRepository,
            PromotionElementRepository promotionElementRepository,
            SaleSysSetupRepository saleSysSetupRepository,
            SaleVoucher saleVoucher
    ) {

        LogLogins logLogins = fetchUserDetail();
        SaleSysSetup saleSysSetup = saleSysSetupRepository.selectSaleSysSetup();
        List<SaleVoucherDetailLight> saleVoucherDetailLights = saleVoucher.getDetails();
        SaleVoucherHeader saleVoucherHeader = saleVoucher.getHeader();

        SaleVoucherOther saleVoucherOther = saleVoucher.getOther();
        List<Promotion> promotions = saleVoucher.getPromotions();
        List<Element> elements = saleVoucher.getElements();

        // وقتی که سند مرجع دارد است و جایزه هم دارد جایزه ها باید از این لیست مصرف شود
        List<InvVoucherDetail> invVoucherDetailsForConsuming = null;

        List<InvVoucherDetail> voucherDetailsForPromotion = new ArrayList<>();

        // آیا این سند مرجع دارد
        boolean hasRefer = false;
        if (saleVoucher.getHeader().getRefTypeID() != null) {
            hasRefer = true;
            invVoucherDetailsForConsuming = invVoucherDetailRepository.invShowVoucherDetailReferWithoutImage(
                    saleVoucherHeader.getStoreID(),
                    saleVoucherHeader.getVoucherTypeID(),
                    saleVoucherHeader.getRefTypeID());
        }

        TCalendar tCalendar = new TCalendar();
        String manualDate = saleVoucherHeader.getVoucherDate();
        String voucherDate;
        String voucherDateG;
        if (manualDate != null) {
            // تاریخ از سمت یوزر پر شده
            tCalendar.setIranianDateBySlash(manualDate);
        }
        voucherDate = tCalendar.getIranianDateBySlashZero();
        Date gregorianDateByTime = null;
//        LocalDate localDate = LocalDate.of( 2015 , 6 , 7 );

// Here working on Date
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date = format.parse("26/10/1985");
            gregorianDateByTime = date;
        } catch (ParseException e) {
            e.printStackTrace();
        }


//        gregorianDateByTime = String.valueOf(saleVoucherHeader.getVoucherDateG().getTime());
        //        2021-04-28T07:06:12.540+00:00


        List<TParameter<?>> tParameters = new ArrayList<>();
        List<SaleVDTblType> saleVDTblTypes = new ArrayList<>();// در این لیست هم کالا و هم جایزه قرار میگیرد
        for (int i = 0; i < saleVoucherDetailLights.size(); i++) {
            if (hasRefer) {
                // اگر سند مرجع دار است باید بابت تک تک ردیف های سند فعلی ردیف های مراجع قبلی مصرف شود
                // انتهای این حلقه فور ردیف های نهایی که برای مصرف جایزه باقی میماند در
                // voucherDetailsForPromotion
                // وجود دارد
                voucherDetailsForPromotion.addAll(consumeVoucherDetailsForCurrentGoods(
                        saleVoucherDetailLights.get(i).getGoodsID(),
                        saleVoucherDetailLights.get(i).getQuantity(),
                        invVoucherDetailsForConsuming));
            }
            // افزودن کالا
            SaleVDTblType saleVDTblType = new SaleVDTblType();
            saleVDTblType.setRowNo(new BigDecimal(i));
            saleVDTblType.setVoucherDetailID(saleVoucherDetailLights.get(i).getVoucherDetailID());
            saleVDTblType.setVoucherHeaderID(voucherHeaderID);
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
            if (saleSysSetup.getIsStoreInDet() == false) {
                // اگر تنظیمات فروش بگوید که انبار ردیفی نداریم
                saleVDTblType.setStoreID(null);
            } else {
                // اگر تنظیمات فروش بگوید که انبار ردیفی داریم
                saleVDTblType.setStoreID(saleVoucherDetailLights.get(i).getStoreID());
            }
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
            saleVDTblType.setTollCoEff(null);
            saleVDTblType.setAnalysisNo(null);
            saleVDTblTypes.add(saleVDTblType);
        }

        for (int i = 0; i < promotions.size(); i++) {
            // افزودن جایزه
            SaleVDTblType saleVDTblType = new SaleVDTblType();
            if (hasRefer) {
                // اگر این سند مرجع دارد است
                // نمیتوان همین جوری !!! جایزه محاسبه شده را به سند اضافه کرد
                // بلکه این جایزه باید از ردیف سند های مراجع قبلی مصرف شود
                saleVDTblType.setdReferID(computeDReferID(
                        promotions.get(i),
                        voucherDetailsForPromotion
                ));
            } else {
                // وقتی سند مرجع دار نیست براحتی میتوان جایزه به سند اضافه کرد
                // و نیازی به ست کردن
                // dReferID
                // نیست
                saleVDTblType.setdReferID(null);
            }
            saleVDTblType.setRowNo(new BigDecimal(saleVoucherDetailLights.size() + i));
            saleVDTblType.setVoucherDetailID(null);// حتما باید نال باشد
            saleVDTblType.setVoucherHeaderID(null);// حتما باید نال باشد
            saleVDTblType.setGoodsID(promotions.get(i).getGoodsID());
            saleVDTblType.setSecUnitID(promotions.get(i).getSecUnitID());
            saleVDTblType.setQuantity(promotions.get(i).getQuantity());
            saleVDTblType.setFee(null);
            saleVDTblType.setDetailXDesc(null);


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
            saleVDTblType.setAnalysisNo(null);
            saleVDTblTypes.add(saleVDTblType);
        }

        if (saleVoucherHeader.getVoucherNumber() == null) {
            // Insert
            tParameters.add(new TParameter<>("VoucherNumber", new BigDecimal(1)));
        } else {
            // Update
            tParameters.add(new TParameter<>("VoucherNumber", saleVoucherHeader.getVoucherNumber()));
        }
        tParameters.add(new TParameter<>("VoucherDate", voucherDate));
//        tParameters.add(new TParameter<>("VoucherDateG", voucherDateG));
        tParameters.add(new TParameter<>("VoucherDateG", gregorianDateByTime));
        tParameters.add(new TParameter<>("CustomerID", saleVoucherHeader.getCustomerID()));
        tParameters.add(new TParameter<>("StoreID", saleVoucherHeader.getStoreID()));
        tParameters.add(new TParameter<>("VoucherTypeID", saleVoucherHeader.getVoucherTypeID()));
        tParameters.add(new TParameter<>("RefTypeID", saleVoucherHeader.getRefTypeID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("YearID", logLogins.getPubUser().getActiveYearID()));
        tParameters.add(new TParameter<>("SaleCenterID", saleVoucherHeader.getSaleCenterID()));
        tParameters.add(new TParameter<>("DeliverCenterID", saleVoucherHeader.getDeliverCenterID()));
        tParameters.add(new TParameter<>("VoucherDesc", saleVoucherHeader.getVoucherDesc()));
        tParameters.add(new TParameter<>("ReferNumber", saleVoucherHeader.getReferNumber()));
        tParameters.add(new TParameter<>("ReferDate", saleVoucherHeader.getReferDate()));
        tParameters.add(new TParameter<>("SalesManID", saleVoucherHeader.getSalesManID()));
        tParameters.add(new TParameter<>("MarketingManID", saleVoucherHeader.getMarketingManID()));
        tParameters.add(new TParameter<>("SaleTypeID", saleVoucherHeader.getSaleTypeID()));
        tParameters.add(new TParameter<>("SecondNumber", saleVoucherHeader.getSecondNumber()));
        tParameters.add(new TParameter<>("CurrencyID", saleVoucherHeader.getCurrencyID()));
        tParameters.add(new TParameter<>("PaymentWayID", saleVoucherHeader.getPaymentWayID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("ExtraDesc", saleVoucherHeader.getExtraDesc()));
        tParameters.add(new TParameter<>("ReferID", saleVoucherHeader.getReferID()));
        tParameters.add(new TParameter<>("AnalysisSetup", saleVoucherOther.getAnalysisSetup()));
        tParameters.add(new TParameter<>("Center1ID", saleVoucherHeader.getCenter1ID()));
        tParameters.add(new TParameter<>("Center2ID", saleVoucherHeader.getCenter2ID()));
        tParameters.add(new TParameter<>("Center3ID", saleVoucherHeader.getCenter3ID()));
        tParameters.add(new TParameter<>("AccountID", saleVoucherHeader.getAccountID()));
        tParameters.add(new TParameter<>("DayCount", saleVoucherHeader.getDayCount()));
        tParameters.add(new TParameter<>("DocPrice", saleVoucherHeader.getDocPrice()));
        tParameters.add(new TParameter<>("CashID", saleVoucherHeader.getCashID()));
        tParameters.add(new TParameter<>("BaseRefTypeID", saleVoucherHeader.getBaseRefTypeID()));
        tParameters.add(new TParameter<>("IsManualPromotion", saleVoucherHeader.getIsManualPromotion()));
        tParameters.add(new TParameter<>("IsAndroidUser", saleVoucherOther.getIsAndroidUser()));
        tParameters.add(new TParameter<>("IsAmendment", saleVoucherOther.getIsAmendment()));
        tParameters.add(new TParameter<>("ContractNumber", saleVoucherOther.getContractNumber()));
        tParameters.add(new TParameter<>("ContractDate", saleVoucherOther.getContractDate()));
        tParameters.add(new TParameter<>("BruntNumber", saleVoucherOther.getBruntNumber()));
        tParameters.add(new TParameter<>("CarNumber", saleVoucherOther.getCarNumber()));
        tParameters.add(new TParameter<>("OtherDesc", saleVoucherOther.getOtherDesc()));
        tParameters.add(new TParameter<>("XDesc", saleVoucherOther.getxDesc()));
        tParameters.add(new TParameter<>("DriverID", saleVoucherOther.getDriverID()));
        tParameters.add(new TParameter<>("DistNameID", saleVoucherOther.getDistNameID()));
        tParameters.add(new TParameter<>("RowID", saleVoucherHeader.getRowID()));
        tParameters.add(new TParameter<>("VoucherHeaderID", voucherHeaderID));
        tParameters.add(new TParameter<>("TDel", null));
        tParameters.add(new TParameter<>("TVD", saleVDTblTypes));
        tParameters.add(new TParameter<>("TSerial", null));
        tParameters.add(new TParameter<>("TSerialDel", null));
        tParameters.add(new TParameter<>("TElement", null));
        tParameters.add(new TParameter<>("WebUserType", saleVoucherOther.getWebUserType()));
        tParameters.add(new TParameter<>("TableID", saleVoucherHeader.getTableID()));
        tParameters.add(new TParameter<>("TafsiliTypeID", null));
//        ResultErrMsgNewID resultErrMsgNewID = execSPNativeQuery(SaleVoucher.class, "SaleInsVoucherHD", tParameters);
//        ResultErrMsgNewID resultErrMsgNewID = execSPNativeQueryForVoucher(SaleVoucher.class, "SaleInsVoucherHD", tParameters);
//        final List saleInsVoucherHD = mixed("SaleInsVoucherHD");


//        execSPNativeQueryTestAK(mine);

        ResultErrMsgNewID resultErrMsgNewID = execSPNativeQueryMultiResultSet(SaleVoucher.class, "SaleInsVoucherHD", tParameters);


        promotionElementRepository.saleInsPromotion(resultErrMsgNewID.getNewID(), elements);
        return saleShowVoucher(
                saleVoucherHeaderRepository,
                saleVoucherDetailLightRepository,
                resultErrMsgNewID.getNewID());
//        return null;
    }


    default List<InvVoucherDetail> consumeVoucherDetailsForCurrentGoods(
            BigDecimal goodsID,
            BigDecimal quantity,
            List<InvVoucherDetail> invVoucherDetailsForConsuming
    ) {
        // ردیف های قبلی را برای این کالای سند فعلی بیرون می کشیم
        List<InvVoucherDetail> goodsForConsuming = invVoucherDetailsForConsuming.stream()
                .filter(invVoucherDetail -> invVoucherDetail.getGoodsID().compareTo(goodsID) == 0)
                .collect(Collectors.toList());

        BigDecimal quantityCurrent = quantity;
        for (int i = 0; i < goodsForConsuming.size(); i++) {
            InvVoucherDetail goodForConsuming = goodsForConsuming.get(i);
            BigDecimal quantityExist = goodForConsuming.getQuantity();
            if (quantityExist.compareTo(quantityCurrent) == 0) {
                // یعنی مقدار ردیف قبلی با مقدار کالای فعلی برابر است
                // پس این ردیف برای این کالا مصرف شده و حذف شود
                goodsForConsuming.remove(i);
                break;
            } else if (quantityExist.compareTo(quantityCurrent) > 0) {
                // یعنی مقدار ردیف قبلی از مقدار کالای فعلی بیشتر است
                // پس به میزان کالای فعلی از این ردیف مصرف میشود یعنی مقدار ردیف بعدی آپدیت شود
                int quantityRemainedFromConsuming = quantityExist.intValue() - quantityCurrent.intValue();
                goodForConsuming.setQuantity(new BigDecimal(quantityRemainedFromConsuming));
                break;
            } else {
                // یعنی مقدار ردیف قبلی برای مصرف مقدار کالای فعلی کفایت نمیکند
                // پس این ردیف حذف شود و برود سراغ کالای بعدی تا مصرفش کند
                goodsForConsuming.remove(i);
                int quantityRemainedFromCurrent = quantityCurrent.intValue() - quantityExist.intValue();
                quantityCurrent = new BigDecimal(quantityRemainedFromCurrent);
                continue;
            }
        }
        return goodsForConsuming;
    }

    default BigDecimal computeDReferID(Promotion promotion, List<InvVoucherDetail> voucherDetailsForPromotion) {
        BigDecimal goodsID = promotion.getGoodsID();
        // از ردیف های باقیمانده برای جایزه ردیف های این کالا را بیرون میکشیم
        List<InvVoucherDetail> goodsForPromotionConsume = voucherDetailsForPromotion.stream()
                .filter(voucherDetailForPromotion -> voucherDetailForPromotion.getGoodsID().compareTo(goodsID) == 0)
                .collect(Collectors.toList());

        goodsForPromotionConsume.sort(Comparator.comparing(InvVoucherDetail::getQuantity));
        for (int i = 0; i < goodsForPromotionConsume.size(); i++) {
            BigDecimal quantityPromotion = promotion.getQuantity();
            InvVoucherDetail goodForPromotionConsume = goodsForPromotionConsume.get(i);
            BigDecimal quantityExist = goodForPromotionConsume.getQuantity();
            if (quantityExist.compareTo(quantityPromotion) == 0) {
                // یعنی مقدار ردیف قبلی با مقدار جایزه برابر است
                // پس این ردیف برای این جایزه مصرف شده و آی دی این رکورد بر میگردد
                return goodForPromotionConsume.getVoucherDetailID();
            } else if (quantityExist.compareTo(quantityPromotion) > 0) {
                // یعنی مقدار ردیف قبلی از جایزه بیشتر است
                // پس این ردیف برای این جایزه مصرف شده و آی دی این رکورد بر میگردد
                return goodForPromotionConsume.getVoucherDetailID();
            } else {
                // یعنی مقدار ردیف قبلی برای مصرف مقدار جایزه کفایت نمیکند
                // پس مقدار نال برای دی ریفر آی دی برمیگردد
            }
        }
        return null;
    }

//    default BigDecimal computeDReferID(
//            List<InvVoucherDetail> invVoucherDetailsForConsuming,
//            List<SaleVoucherDetailLight> saleVoucherDetailLights,
//            BigDecimal goodsID,
//            BigDecimal storeID,
//            BigDecimal voucherTypeID,
//            BigDecimal refTypeID
//    ) {
//        // در این متد ردیف سند های قبلی برای این کالا گرفته میشود تا برای جایزه مصرف شود
//
//        // از کل ردیف های قبلی فقط ردیف هایی را بیرون میکشیم که متعلق به این کالاست
//        // این ردیف ها در گام اول باید برای ردیف های سند فعلی مصرف شود
//        // در گام دوم برای جایزه ها
//        List<InvVoucherDetail> goodsForConsuming = invVoucherDetailsForConsuming.stream()
//                .filter(invVoucherDetail -> invVoucherDetail.getGoodsID().compareTo(goodsID) == 0)
//                .collect(Collectors.toList());
//
//        // ردیف های فعلی سند را برای این کالا ببرون میکشیم
//        List<SaleVoucherDetailLight> goodsForCurrentVoucher = saleVoucherDetailLights.stream()
//                .filter(saleVoucherDetailLight -> saleVoucherDetailLight.getGoodsID().compareTo(goodsID) == 0)
//                .collect(Collectors.toList());
//
//        // حال یاید از ردیف های قبلی کالاهای سند فعلی را کم کنیم تا ببینیم چقدر برای مصرف جایزه ها ردیف باقی میماند
//        for (int i = 0; i < goodsForCurrentVoucher.size(); i++) {
//            SaleVoucherDetailLight goodForCurrentVoucher = goodsForCurrentVoucher.get(i);
//            for (int j = 0; j < goodsForConsuming.size(); j++) {
//                BigDecimal quantityCurrent = goodForCurrentVoucher.getQuantity();
//                InvVoucherDetail goodForConsuming = goodsForConsuming.get(j);
//                BigDecimal quantityExist = goodForConsuming.getQuantity();
//                if (quantityExist.compareTo(quantityCurrent) == 0) {
//                    // یعنی مقدار ردیف قبلی با مقدار کالای فعلی برابر است
//                    // پس این ردیف برای این کالا مصرف شده و حذف شود
//                    goodsForConsuming.remove(j);
//                    break;
//                } else if (quantityExist.compareTo(quantityCurrent) > 0) {
//                    // یعنی مقدار ردیف قبلی از مقدار کالای فعلی بیشتر است
//                    // پس به میزان کالای فعلی از این ردیف مصرف میشود یعنی مقدار ردیف بعدی آپدیت شود
//                    int quantityRemainedFromConsuming = quantityExist.intValue() - quantityCurrent.intValue();
//                    goodForConsuming.setQuantity(new BigDecimal(quantityRemainedFromConsuming));
//                    break;
//                } else {
//                    // یعنی مقدار ردیف قبلی برای مصرف مقدار کالای فعلی کفایت نمیکند
//                    // پس این ردیف حذف شود و برود سراغ کالای بعدی تا مصرفش کند
//                    goodsForConsuming.remove(j);
//                    int quantityRemainedFromCurrent = quantityCurrent.intValue() - quantityExist.intValue();
//                    goodForCurrentVoucher.setQuantity(new BigDecimal(quantityRemainedFromCurrent));
//                    continue;
//                }
//            }
//        }
//
//        int g = 0;
//        // ابتدا این دیتیل ها برای خود کالاهای سند مصرف شود
//
//        return null;
//    }
//    default SaleVoucher saleInsVoucherHD1(
//            BigDecimal voucherHeaderID,
//            SaleVoucherHeaderRepository saleVoucherHeaderRepository,
//            SaleVoucherDetailLightRepository saleVoucherDetailLightRepository,
//            PromotionElementRepository promotionElementRepository,
//            SaleSysSetupRepository saleSysSetupRepository,
//            SaleVoucher saleVoucher
//    ) {
//        LogLogins logLogins = fetchUserDetail();
//        SaleSysSetup saleSysSetup = saleSysSetupRepository.selectSaleSysSetup();
//        List<SaleVoucherDetailLight> saleVoucherDetailLights = saleVoucher.getDetails();
//        List<Promotion> promotions = saleVoucher.getPromotions();
//        List<Element> elements = saleVoucher.getElements();
//
//        TCalendar tCalendar = new TCalendar();
//        String manualDate = saleVoucher.getHeader().getVoucherDate();
//        String voucherDate;
//        String voucherDateG;
//        if (manualDate != null) {
//            // تاریخ از سمت یوزر پر شده
//            tCalendar.setIranianDateBySlash(manualDate);
//        }
//        voucherDate = tCalendar.getIranianDateBySlashZero();
//        voucherDateG = tCalendar.getGregorianDateByTime();
//
//        StringBuilder sqlQuery = new StringBuilder();
//        sqlQuery.append("DECLARE @Result DECIMAL(38,4)").append("\n");
//        sqlQuery.append("DECLARE @ErrMsg NVARCHAR(MAX)").append("\n");
//        sqlQuery.append("DECLARE @NewID DECIMAL(38,4)").append("\n");
//        sqlQuery.append("DECLARE @TDel dbo.TempT2").append("\n");
//        sqlQuery.append("DECLARE @TVD dbo.SaleVDTblType").append("\n");
//        sqlQuery.append("DECLARE @TSerial dbo.TSerial").append("\n");
//        sqlQuery.append("DECLARE @TSerialDel dbo.TempT2").append("\n");
//        sqlQuery.append("DECLARE @TElement dbo.TElement").append("\n");
//
//        sqlQuery.append("-- افزودن کالا").append("\n");
//        for (int i = 0; i < saleVoucherDetailLights.size(); i++) {
//            sqlQuery.append("INSERT INTO @TVD VALUES(").append("\n");
//            sqlQuery.append(i).append(", --RowNo").append("\n");// RowNo
//            sqlQuery.append(saleVoucherDetailLights.get(i).getVoucherDetailID()).append(", --VoucherDetailID").append("\n");// VoucherDetailID
//            sqlQuery.append(voucherHeaderID).append(", --VoucherHeaderID").append("\n");// VoucherHeaderID
//            sqlQuery.append(saleVoucherDetailLights.get(i).getGoodsID()).append(", --GoodsID").append("\n");// GoodsID
//            sqlQuery.append(saleVoucherDetailLights.get(i).getSecUnitID()).append(", --SecUnitID").append("\n");// SecUnitID
//            sqlQuery.append(saleVoucherDetailLights.get(i).getQuantity()).append(", --Quantity").append("\n");// Quantity
//            sqlQuery.append(saleVoucherDetailLights.get(i).getFee()).append(", --Fee").append("\n");// Fee
//            sqlQuery.append(saleVoucherDetailLights.get(i).getDetailXDesc()).append(", --DetailXDesc").append("\n");// DetailXDesc
//            sqlQuery.append(saleVoucherDetailLights.get(i).getdReferID()).append(", --DReferID").append("\n");// DReferID
//            sqlQuery.append(logLogins.getPubUser().getUserID()).append(", --CreatorID").append("\n");// CreatorID
//            sqlQuery.append(logLogins.getPubUser().getUserID()).append(", --ModifierID").append("\n");// ModifierID
//            sqlQuery.append("NULL").append(", --DifferentialID").append("\n");// DifferentialID
//            sqlQuery.append(saleVoucherDetailLights.get(i).getComputeValue()).append(", --ComputeValue").append("\n");// ComputeValue
//            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField1()).append(", --CustomField1").append("\n");// CustomField1
//            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField2()).append(", --CustomField2").append("\n");// CustomField2
//            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField3()).append(", --CustomField3").append("\n");// CustomField3
//            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField4()).append(", --CustomField4").append("\n");// CustomField4
//            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField5()).append(", --CustomField5").append("\n");// CustomField5
//            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField6()).append(", --CustomField6").append("\n");// CustomField6
//            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField7()).append(", --CustomField7").append("\n");// CustomField7
//            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField8()).append(", --CustomField8").append("\n");// CustomField8
//            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField9()).append(", --CustomField9").append("\n");// CustomField9
//            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField10()).append(", --CustomField10").append("\n");// CustomField10
//            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField11()).append(", --CustomField11").append("\n");// CustomField11
//            sqlQuery.append(saleVoucherDetailLights.get(i).getFee()).append(", --FeeAgreement").append("\n");// FeeAgreement
//            sqlQuery.append(saleVoucherDetailLights.get(i).getFeeDiscountPrice()).append(", --FeeDiscountPrice").append("\n");// FeeDiscountPrice
//            sqlQuery.append(saleVoucherDetailLights.get(i).getFeeDiscountPercent()).append(", --FeeDiscountPercent").append("\n");// FeeDiscountPercent
//            sqlQuery.append("NULL").append(", --FeeFrieghtCharges").append("\n");// FeeFrieghtCharges
//            sqlQuery.append("NULL").append(", --AllocatedQuantity2").append("\n");// AllocatedQuantity2
//            sqlQuery.append("NULL").append(", --OverAllocatedQuantity2").append("\n");// OverAllocatedQuantity2
//            sqlQuery.append("NULL").append(", --LCReferID").append("\n");// LCReferID
//            sqlQuery.append("NULL").append(", --AgrReferID").append("\n");// AgrReferID
//            sqlQuery.append("NULL").append(", --Quantity2").append("\n");// Quantity2
//            sqlQuery.append("NULL").append(", --Quantity3").append("\n");// Quantity3
//            sqlQuery.append("NULL").append(", --SecUnitID2").append("\n");// SecUnitID2
//            sqlQuery.append("NULL").append(", --SecUnitID3").append("\n");// SecUnitID3
//            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField12()).append(", --CustomField12").append("\n");// CustomField12
//            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField13()).append(", --CustomField13").append("\n");// CustomField13
//            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField14()).append(", --CustomField14").append("\n");// CustomField14
//            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField15()).append(", --CustomField15").append("\n");// CustomField15
//            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField16()).append(", --CustomField16").append("\n");// CustomField16
//            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField17()).append(", --CustomField17").append("\n");// CustomField17
//            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField18()).append(", --CustomField18").append("\n");// CustomField18
//            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField19()).append(", --CustomField19").append("\n");// CustomField19
//            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField20()).append(", --CustomField20").append("\n");// CustomField20
//            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField21()).append(", --CustomField21").append("\n");// CustomField21
//            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField22()).append(", --CustomField22").append("\n");// CustomField22
//            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField23()).append(", --CustomField23").append("\n");// CustomField23
//            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField24()).append(", --CustomField24").append("\n");// CustomField24
//            sqlQuery.append(saleVoucherDetailLights.get(i).getCustomField25()).append(", --CustomField25").append("\n");// CustomField25
//
//            if (saleSysSetup.getIsStoreInDet() == false) {
//                // اگر تنظیمات فروش بگوید که انبار ردیفی نداریم
//                sqlQuery.append("NULL").append(", --StoreID").append("\n");// StoreID
//            } else {
//                // اگر تنظیمات فروش بگوید که انبار ردیفی داریم
//                sqlQuery.append(saleVoucherDetailLights.get(i).getStoreID()).append(", --StoreID").append("\n");// StoreID
//            }
//            sqlQuery.append("NULL").append(", --Center1ID").append("\n");// Center1ID
//            sqlQuery.append("NULL").append(", --Center2ID").append("\n");// Center2ID
//            sqlQuery.append("NULL").append(", --Center3ID").append("\n");// Center3ID
//            sqlQuery.append("NULL").append(", --iGUID").append("\n");// iGUID
//            sqlQuery.append("NULL").append(", --TaxMab").append("\n");// TaxMab
//            sqlQuery.append("NULL").append(", --TollMab").append("\n");// TollMab
//            sqlQuery.append("NULL").append(", --TaxCoEff").append("\n");// TaxCoEff
//            sqlQuery.append("NULL").append(", --IsPromotion").append("\n");// IsPromotion
//            sqlQuery.append("NULL").append(", --BaseDReferID").append("\n");// BaseDReferID
//            sqlQuery.append("NULL").append(", --SecondGoodsID").append("\n");// SecondGoodsID
//            sqlQuery.append("NULL").append(", --RRowMabPrice").append("\n");// RRowMabPrice
//            sqlQuery.append("NULL").append(", --RRowMabPercent").append("\n");// RRowMabPercent
//            sqlQuery.append("NULL").append(" --TollCoEff").append("\n");
//            sqlQuery.append(")").append("\n");
//        }
//
//        sqlQuery.append("-- افزودن جایزه").append("\n");
//        for (int i = 0; i < promotions.size(); i++) {
//            sqlQuery.append("INSERT INTO @TVD VALUES(").append("\n");
//            sqlQuery.append(saleVoucherDetailLights.size() + i).append(", --RowNo").append("\n");// RowNo
//            sqlQuery.append("NULL").append(", --VoucherDetailID").append("\n");// VoucherDetailID
//            sqlQuery.append("NULL").append(", --VoucherHeaderID").append("\n");// VoucherHeaderID
//            sqlQuery.append(promotions.get(i).getGoodsID()).append(", --GoodsID").append("\n");// GoodsID
//            sqlQuery.append(promotions.get(i).getSecUnitID()).append(", --SecUnitID").append("\n");// SecUnitID
//            sqlQuery.append(promotions.get(i).getQuantity()).append(", --Quantity").append("\n");// Quantity
//            sqlQuery.append("NULL").append(", --Fee").append("\n");// Fee
//            sqlQuery.append("NULL").append(", --DetailXDesc").append("\n");// DetailXDesc
//            sqlQuery.append("NULL").append(", --DReferID").append("\n");// DReferID
//            sqlQuery.append(logLogins.getPubUser().getUserID()).append(", --CreatorID").append("\n");// CreatorID
//            sqlQuery.append(logLogins.getPubUser().getUserID()).append(", --ModifierID").append("\n");// ModifierID
//            sqlQuery.append("NULL").append(", --DifferentialID").append("\n");// DifferentialID
//            sqlQuery.append("NULL").append(", --ComputeValue").append("\n");// ComputeValue
//            sqlQuery.append("NULL").append(", --CustomField1").append("\n");// CustomField1
//            sqlQuery.append("NULL").append(", --CustomField2").append("\n");// CustomField2
//            sqlQuery.append("NULL").append(", --CustomField3").append("\n");// CustomField3
//            sqlQuery.append("NULL").append(", --CustomField4").append("\n");// CustomField4
//            sqlQuery.append("NULL").append(", --CustomField5").append("\n");// CustomField5
//            sqlQuery.append("NULL").append(", --CustomField6").append("\n");// CustomField6
//            sqlQuery.append("NULL").append(", --CustomField7").append("\n");// CustomField7
//            sqlQuery.append("NULL").append(", --CustomField8").append("\n");// CustomField8
//            sqlQuery.append("NULL").append(", --CustomField9").append("\n");// CustomField9
//            sqlQuery.append("NULL").append(", --CustomField10").append("\n");// CustomField10
//            sqlQuery.append("NULL").append(", --CustomField11").append("\n");// CustomField11
//            sqlQuery.append("NULL").append(", --FeeAgreement").append("\n");// FeeAgreement
//            sqlQuery.append("0").append(", --FeeDiscountPrice").append("\n");// FeeDiscountPrice
//            sqlQuery.append("0").append(", --FeeDiscountPercent").append("\n");// FeeDiscountPercent
//            sqlQuery.append("NULL").append(", --FeeFrieghtCharges").append("\n");// FeeFrieghtCharges
//            sqlQuery.append("NULL").append(", --AllocatedQuantity2").append("\n");// AllocatedQuantity2
//            sqlQuery.append("NULL").append(", --OverAllocatedQuantity2").append("\n");// OverAllocatedQuantity2
//            sqlQuery.append("NULL").append(", --LCReferID").append("\n");// LCReferID
//            sqlQuery.append("NULL").append(", --AgrReferID").append("\n");// AgrReferID
//            sqlQuery.append("NULL").append(", --Quantity2").append("\n");// Quantity2
//            sqlQuery.append("NULL").append(", --Quantity3").append("\n");// Quantity3
//            sqlQuery.append("NULL").append(", --SecUnitID2").append("\n");// SecUnitID2
//            sqlQuery.append("NULL").append(", --SecUnitID3").append("\n");// SecUnitID3
//            sqlQuery.append("NULL").append(", --CustomField12").append("\n");// CustomField12
//            sqlQuery.append("NULL").append(", --CustomField13").append("\n");// CustomField13
//            sqlQuery.append("NULL").append(", --CustomField14").append("\n");// CustomField14
//            sqlQuery.append("NULL").append(", --CustomField15").append("\n");// CustomField15
//            sqlQuery.append("NULL").append(", --CustomField16").append("\n");// CustomField16
//            sqlQuery.append("NULL").append(", --CustomField17").append("\n");// CustomField17
//            sqlQuery.append("NULL").append(", --CustomField18").append("\n");// CustomField18
//            sqlQuery.append("NULL").append(", --CustomField19").append("\n");// CustomField19
//            sqlQuery.append("NULL").append(", --CustomField20").append("\n");// CustomField20
//            sqlQuery.append("NULL").append(", --CustomField21").append("\n");// CustomField21
//            sqlQuery.append("NULL").append(", --CustomField22").append("\n");// CustomField22
//            sqlQuery.append("NULL").append(", --CustomField23").append("\n");// CustomField23
//            sqlQuery.append("NULL").append(", --CustomField24").append("\n");// CustomField24
//            sqlQuery.append("NULL").append(", --CustomField25").append("\n");// CustomField25
//            sqlQuery.append("NULL").append(", --StoreID").append("\n");// StoreID
//            sqlQuery.append("NULL").append(", --Center1ID").append("\n");// Center1ID
//            sqlQuery.append("NULL").append(", --Center2ID").append("\n");// Center2ID
//            sqlQuery.append("NULL").append(", --Center3ID").append("\n");// Center3ID
//            sqlQuery.append("NULL").append(", --iGUID").append("\n");// iGUID
//            sqlQuery.append("NULL").append(", --TaxMab").append("\n");// TaxMab
//            sqlQuery.append("NULL").append(", --TollMab").append("\n");// TollMab
//            sqlQuery.append("NULL").append(", --TaxCoEff").append("\n");// TaxCoEff
//            sqlQuery.append("NULL").append(", --IsPromotion").append("\n");// IsPromotion
//            sqlQuery.append("NULL").append(", --BaseDReferID").append("\n");// BaseDReferID
//            sqlQuery.append("NULL").append(", --SecondGoodsID").append("\n");// SecondGoodsID
//            sqlQuery.append("NULL").append(", --RRowMabPrice").append("\n");// RRowMabPrice
//            sqlQuery.append("NULL").append(", --RRowMabPercent").append("\n");// RRowMabPercent
//            sqlQuery.append("NULL").append(" --TollCoEff").append("\n");
//            sqlQuery.append(")").append("\n");
//        }
//
//        // در حالت آپدیت دیتیل هایی که در در دیتابیس هست ولی در بادی وب سرویس نیست باید در تی دل قرار گیرد
//        if (voucherHeaderID != null) {
//            List<SaleVoucherDetailLight> saleVoucherDetailsDBLight = saleVoucherDetailLightRepository.saleShowVoucherDetailLightByID(voucherHeaderID);
//            for (int i = 0; i < saleVoucherDetailsDBLight.size(); i++) {
//                SaleVoucherDetailLight saleVoucherDetailLightDB = saleVoucherDetailsDBLight.get(i);
//                List<SaleVoucherDetailLight> saleVoucherDetailsFilteredLight = saleVoucherDetailLights.stream()
//                        .filter(item -> {
//                            if (item.getVoucherDetailID() != null) {
//                                return item.getVoucherDetailID().intValue() == saleVoucherDetailLightDB.getVoucherDetailID().intValue();
//                            }
//                            return false;
//                        })
//                        .collect(Collectors.toList());
//                if (saleVoucherDetailsFilteredLight.isEmpty()) {
//                    sqlQuery.append("INSERT INTO @TDel VALUES(").append("\n");
//                    sqlQuery.append(saleVoucherDetailLightDB.getVoucherDetailID()).append(", --mID").append("\n");// mID
//                    sqlQuery.append("NULL").append(" --mID2").append("\n");// mID2
//                    sqlQuery.append(")").append("\n");
//                }
//            }
//        }
//        sqlQuery.append("EXEC SaleInsVoucherHD ").append("\n");
//        if (saleVoucher.getHeader().getVoucherNumber() == null) {
//            // Insert
//            sqlQuery.append("1").append(", --VoucherNumber").append("\n");// VoucherNumber
//        } else {
//            // Update
//            sqlQuery.append(saleVoucher.getHeader().getVoucherNumber()).append(", --VoucherNumber").append("\n");// VoucherNumber
//        }
//
//        sqlQuery.append("N'").append(voucherDate).append("'").append(", --voucherDate").append("\n");// voucherDate
//        sqlQuery.append("N'").append(voucherDateG).append("'").append(", --voucherDateG").append("\n");// voucherDateG
//        sqlQuery.append(saleVoucher.getHeader().getCustomerID()).append(", --CustomerID").append("\n");// CustomerID
//        sqlQuery.append(saleVoucher.getHeader().getStoreID()).append(", --StoreID").append("\n");// StoreID
//        sqlQuery.append(saleVoucher.getHeader().getVoucherTypeID()).append(", --VoucherTypeID").append("\n");// VoucherTypeID
//        sqlQuery.append(saleVoucher.getHeader().getRefTypeID()).append(", --RefTypeID").append("\n");// RefTypeID
//        sqlQuery.append(logLogins.getPubUser().getUserID()).append(", --CreatorID").append("\n");// CreatorID
//        sqlQuery.append(logLogins.getPubUser().getUserID()).append(", --ModifierID").append("\n");// ModifierID
//        sqlQuery.append(logLogins.getPubUser().getActiveYearID()).append(", --YearID").append("\n");// YearID
//        sqlQuery.append(saleVoucher.getHeader().getSaleCenterID()).append(", --SaleCenterID").append("\n");// SaleCenterID
//        sqlQuery.append(saleVoucher.getHeader().getDeliverCenterID()).append(", --DeliverCenterID").append("\n");// DeliverCenterID
//
//        if (saleVoucher.getHeader().getVoucherDesc() == null) {
//            sqlQuery.append("NULL").append(", --VoucherDesc").append("\n");// VoucherDesc
//        } else {
//            sqlQuery.append("N'").append(saleVoucher.getHeader().getVoucherDesc()).append("'").append(", --VoucherDesc").append("\n");// VoucherDesc
//        }
//
//        if (saleVoucher.getHeader().getReferNumber() == null) {
//            sqlQuery.append("NULL").append(", --ReferNumber").append("\n");// ReferNumber
//        } else {
//            sqlQuery.append("N'").append(saleVoucher.getHeader().getReferNumber()).append("'").append(", --ReferNumber").append("\n");// ReferNumber
//        }
//
//        if (saleVoucher.getHeader().getReferDate() == null) {
//            sqlQuery.append("NULL").append(", --ReferDate").append("\n");// ReferDate
//        } else {
//            sqlQuery.append("N'").append(saleVoucher.getHeader().getReferDate()).append("'").append(", --ReferDate").append("\n");// ReferDate
//        }
//
//        sqlQuery.append(saleVoucher.getHeader().getSalesManID()).append(", --SalesManID").append("\n");// SalesManID
//        sqlQuery.append(saleVoucher.getHeader().getMarketingManID()).append(", --MarketingManID").append("\n");// MarketingManID
//        sqlQuery.append(saleVoucher.getHeader().getSaleTypeID()).append(", --SaleTypeID").append("\n");// SaleTypeID
//
//        if (saleVoucher.getHeader().getSecondNumber() == null) {
//            sqlQuery.append("NULL").append(", --SecondNumber").append("\n");// SecondNumber
//        } else {
//            sqlQuery.append("N'").append(saleVoucher.getHeader().getSecondNumber()).append("'").append(", --SecondNumber").append("\n");// SecondNumber
//        }
//        sqlQuery.append(saleVoucher.getHeader().getCurrencyID()).append(", --CurrencyID").append("\n");// CurrencyID
//        sqlQuery.append(saleVoucher.getHeader().getPaymentWayID()).append(", --PaymentWayID").append("\n");// PaymentWayID
//        sqlQuery.append("@Result OUTPUT").append(", --Result").append("\n");// Result
//        sqlQuery.append(logLogins.getLoginId()).append(", --LoginID").append("\n");// LoginID
//        sqlQuery.append("@ErrMsg OUTPUT").append(", --ErrMsg").append("\n");// ErrMsg
//
//        if (saleVoucher.getHeader().getExtraDesc() == null) {
//            sqlQuery.append("NULL").append(", --ExtraDesc").append("\n");// ExtraDesc
//        } else {
//            sqlQuery.append("N'").append(saleVoucher.getHeader().getExtraDesc()).append("'").append(", --ExtraDesc").append("\n");// ExtraDesc
//        }
//
//        sqlQuery.append("@NewID OUTPUT").append(", --NewID").append("\n");// NewID
//        sqlQuery.append(saleVoucher.getHeader().getReferID()).append(", --ReferID").append("\n");// ReferID
//        sqlQuery.append(saleVoucher.getOther().getAnalysisSetup()).append(", --AnalysisSetup").append("\n");// AnalysisSetup
//        sqlQuery.append(saleVoucher.getHeader().getCenter1ID()).append(", --Center1ID").append("\n");// Center1ID
//        sqlQuery.append(saleVoucher.getHeader().getCenter2ID()).append(", --Center2ID").append("\n");// Center2ID
//        sqlQuery.append(saleVoucher.getHeader().getCenter3ID()).append(", --Center3ID").append("\n");// Center3ID
//        sqlQuery.append(saleVoucher.getHeader().getAccountID()).append(", --AccountID").append("\n");// AccountID
//        sqlQuery.append(saleVoucher.getHeader().getDayCount()).append(", --DayCount").append("\n");// DayCount
//        sqlQuery.append(saleVoucher.getHeader().getDocPrice()).append(", --DocPrice").append("\n");// DocPrice
//        sqlQuery.append(saleVoucher.getHeader().getCashID()).append(", --CashID").append("\n");// CashID
//        sqlQuery.append(saleVoucher.getHeader().getBaseRefTypeID()).append(", --BaseRefTypeID").append("\n");// BaseRefTypeID
//        sqlQuery.append(saleVoucher.getHeader().getIsManualPromotion()).append(", --IsManualPromotion").append("\n");// IsManualPromotion
//        sqlQuery.append(saleVoucher.getOther().getIsAndroidUser()).append(", --IsAndroidUser").append("\n");// IsAndroidUser
//        sqlQuery.append(saleVoucher.getOther().getIsAmendment()).append(", --IsAmendment").append("\n");// IsAmendment
//
//        if (saleVoucher.getOther().getContractNumber() == null) {
//            sqlQuery.append("NULL").append(", --ContractNumber").append("\n");// ContractNumber
//        } else {
//            sqlQuery.append("N'").append(saleVoucher.getOther().getContractNumber()).append("'").append(", --ContractNumber").append("\n");// ContractNumber
//        }
//
//        if (saleVoucher.getOther().getContractDate() == null) {
//            sqlQuery.append("NULL").append(", --ContractDate").append("\n");// ContractDate
//        } else {
//            sqlQuery.append("N'").append(saleVoucher.getOther().getContractDate()).append("'").append(", --ContractDate").append("\n");// ContractDate
//        }
//
//        if (saleVoucher.getOther().getBruntNumber() == null) {
//            sqlQuery.append("NULL").append(", --BruntNumber").append("\n");// BruntNumber
//        } else {
//            sqlQuery.append("N'").append(saleVoucher.getOther().getBruntNumber()).append("'").append(", --BruntNumber").append("\n");// BruntNumber
//        }
//
//        if (saleVoucher.getOther().getCarNumber() == null) {
//            sqlQuery.append("NULL").append(", --CarNumber").append("\n");// CarNumber
//        } else {
//            sqlQuery.append("N'").append(saleVoucher.getOther().getCarNumber()).append("'").append(", --CarNumber").append("\n");// CarNumber
//        }
//
//        if (saleVoucher.getOther().getOtherDesc() == null) {
//            sqlQuery.append("NULL").append(", --OtherDesc").append("\n");// OtherDesc
//        } else {
//            sqlQuery.append("N'").append(saleVoucher.getOther().getOtherDesc()).append("'").append(", --OtherDesc").append("\n");// OtherDesc
//        }
//
//        if (saleVoucher.getOther().getxDesc() == null) {
//            sqlQuery.append("NULL").append(", --XDesc").append("\n");// XDesc
//        } else {
//            sqlQuery.append("N'").append(saleVoucher.getOther().getxDesc()).append("'").append(", --XDesc").append("\n");// XDesc
//        }
//
//        sqlQuery.append(saleVoucher.getOther().getDriverID()).append(", --DriverID").append("\n");// DriverID
//        sqlQuery.append(saleVoucher.getOther().getDistNameID()).append(", --DistNameID").append("\n");// DistNameID
//        sqlQuery.append(saleVoucher.getHeader().getRowID()).append(", --RowID").append("\n");// RowID
//        sqlQuery.append(voucherHeaderID).append(", --VoucherHeaderID").append("\n");// VoucherHeaderID
//        sqlQuery.append("@TDel").append(", --TDel").append("\n");// TDel
//        sqlQuery.append("@TVD").append(", --TVD").append("\n");// TVD
//        sqlQuery.append("@TSerial").append(", --TSerial").append("\n");// TSerial
//        sqlQuery.append("@TSerialDel").append(", --TSerialDel").append("\n");// TSerialDel
//        sqlQuery.append("@TElement").append(", --TElement").append("\n");// TElement
//        sqlQuery.append(saleVoucher.getOther().getWebUserType()).append(", --WebUserType").append("\n");// WebUserType
//        sqlQuery.append(saleVoucher.getHeader().getTableID()).append(" --TableID").append("\n");// TableID
//        sqlQuery.append("SELECT @Result AS Result,@ErrMsg AS ErrMsg,@NewID AS NewID");
//        Map<String, Object> row = execute(sqlQuery.toString());
//        BigDecimal newID = (BigDecimal) row.get("NewID");
//        promotionElementRepository.saleInsPromotion(newID, elements);
//        return saleShowVoucher(
//                saleVoucherHeaderRepository,
//                saleVoucherDetailLightRepository,
//                newID);
//    }
}
