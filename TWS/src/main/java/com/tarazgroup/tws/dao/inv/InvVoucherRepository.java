package com.tarazgroup.tws.dao.inv;

import com.tarazgroup.tws.dao.ResultErrMsgNewID;
import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.dao.pub.PubVoucherTypeRepository;
import com.tarazgroup.tws.dao.sale.SaleVoucherHeaderRepository;
import com.tarazgroup.tws.model.inv.InvVoucher;
import com.tarazgroup.tws.model.inv.InvVoucherDetail;
import com.tarazgroup.tws.model.inv.InvVoucherHeader;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TCalendar;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.tabletype.SQLServerDataRecord.SQLServerDataRecordTSerial;
import com.tarazgroup.tws.util.tabletype.SQLServerDataRecord.SQLServerDataRecordTempT2;
import com.tarazgroup.tws.util.tabletype.TSerial;
import com.tarazgroup.tws.util.tabletype.TempT2;
import com.tarazgroup.tws.util.tabletype.inv.InvVDTblType;
import org.apache.xmlbeans.impl.common.NameUtil;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
public interface InvVoucherRepository extends TCrudRepository<InvVoucher>, CrudRepository<InvVoucher, BigDecimal> {

    default InvVoucher invShowVoucher(InvVoucherHeaderRepository invVoucherHeaderRepository,
                                      InvVoucherDetailRepository invVoucherDetailRepository,
                                      BigDecimal voucherHeaderID) {

        InvVoucherHeader invVoucherHeader = invVoucherHeaderRepository.invShowVoucherHeaderByID(voucherHeaderID);
        List<InvVoucherDetail> invVoucherDetails = invVoucherDetailRepository.invShowVoucherDetailByID(voucherHeaderID, false, null, null);
        InvVoucher invVoucher = new InvVoucher();
        invVoucher.setHeader(invVoucherHeader);
        invVoucher.setDetails(invVoucherDetails);
        return invVoucher;
    }


//    default InvVoucher invInsVoucherHD1(
//            BigDecimal voucherHeaderID,
//            InvVoucherHeaderRepository voucherHeaderRepository,
//            InvVoucherDetailRepository voucherDetailRepository,
//            InvVoucher invVoucher
//    ) {
//
//
//        LogLogins logLogins = fetchUserDetail();
//        List<InvVoucherDetail> invVoucherDetails = invVoucher.getDetails();
//        InvVoucherHeader invVoucherHeader = invVoucher.getHeader();
//        invVoucherHeader.setVoucherHeaderID(voucherHeaderID);
//        TCalendar tCalendar = new TCalendar();
//        String manualDate = invVoucherHeader.getVoucherDate();
//        String voucherDate;
//        String voucherDateG;
//        if (manualDate != null) {
//            tCalendar.setIranianDateBySlash(manualDate);
//        }
//
//        voucherDate = tCalendar.getIranianDateBySlashZero();
//        voucherDateG = tCalendar.getGregorianDateByTime();
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        List<InvVDTblType> invVDTblTypes = new ArrayList<>();
//
//
//        for (int i = 0; i < invVoucherDetails.size(); i++) {
//            InvVDTblType invVDTblType = new InvVDTblType();
//            invVDTblType.setRowNo(new BigDecimal(i));
//            invVDTblType.setVoucherDetailID(invVoucherDetails.get(i).getVoucherDetailID());
//            invVDTblType.setVoucherDetailID(invVoucherDetails.get(i).getVoucherDetailID());
//            invVDTblType.setVoucherDetailID(invVoucherDetails.get(i).getVoucherDetailID());
//            invVDTblType.setVoucherHeaderID(invVoucherDetails.get(i).getVoucherHeaderID());
//            invVDTblType.setGoodsID(invVoucherDetails.get(i).getGoodsID());
//            invVDTblType.setSecUnitID(invVoucherDetails.get(i).getSecUnitID());
//            invVDTblType.setQuantity(invVoucherDetails.get(i).getQuantity());
//            invVDTblType.setFee(invVoucherDetails.get(i).getFee());
//            invVDTblType.setDetailXDesc(invVoucherDetails.get(i).getDetailXDesc());
//            invVDTblType.setDReferID(invVoucherDetails.get(i).getdReferID());
//            invVDTblType.setCreatorID(invVoucherDetails.get(i).getCreatorID());
//            invVDTblType.setModifierID(invVoucherDetails.get(i).getModifierID());
//            invVDTblType.setDifferentialID(invVoucherDetails.get(i).getDifferentialID());
//            invVDTblType.setAnalysisSetup(null);
//            invVDTblType.setComputeValue(invVoucherDetails.get(i).getComputeValue());
//            invVDTblType.setCustomField1(invVoucherDetails.get(i).getCustomField1());
//            invVDTblType.setCustomField2(invVoucherDetails.get(i).getCustomField2());
//            invVDTblType.setCustomField3(invVoucherDetails.get(i).getCustomField3());
//            invVDTblType.setCustomField4(invVoucherDetails.get(i).getCustomField4());
//            invVDTblType.setCustomField5(invVoucherDetails.get(i).getCustomField5());
//            invVDTblType.setCustomField6(invVoucherDetails.get(i).getCustomField6());
//            invVDTblType.setCustomField7(invVoucherDetails.get(i).getCustomField7());
//            invVDTblType.setCustomField8(invVoucherDetails.get(i).getCustomField8());
//            invVDTblType.setCustomField9(invVoucherDetails.get(i).getCustomField9());
//            invVDTblType.setCustomField10(invVoucherDetails.get(i).getCustomField10());
//            invVDTblType.setCustomField11(invVoucherDetails.get(i).getCustomField11());
//            invVDTblType.setFeeFrieghtCharges(invVoucherDetails.get(i).getFeeFrieghtCharges());
//            invVDTblType.setlCReferID(invVoucherDetails.get(i).getlCReferID());
//            invVDTblType.setAgrReferID(invVoucherDetails.get(i).getAgrReferID());
//            invVDTblType.setQuantity2(invVoucherDetails.get(i).getQuantity2());
//            invVDTblType.setQuantity3(invVoucherDetails.get(i).getQuantity3());
//            invVDTblType.setSecUnitID2(invVoucherDetails.get(i).getSecUnitID2());
//            invVDTblType.setSecUnitID3(invVoucherDetails.get(i).getSecUnitID3());
//            invVDTblType.setCustomField12(invVoucherDetails.get(i).getCustomField12());
//            invVDTblType.setCustomField13(invVoucherDetails.get(i).getCustomField13());
//            invVDTblType.setCustomField14(invVoucherDetails.get(i).getCustomField14());
//            invVDTblType.setCustomField15(invVoucherDetails.get(i).getCustomField15());
//            invVDTblType.setCustomField16(invVoucherDetails.get(i).getCustomField16());
//            invVDTblType.setCustomField17(invVoucherDetails.get(i).getCustomField17());
//            invVDTblType.setCustomField18(invVoucherDetails.get(i).getCustomField18());
//            invVDTblType.setCustomField19(invVoucherDetails.get(i).getCustomField19());
//            invVDTblType.setCustomField20(invVoucherDetails.get(i).getCustomField20());
//            invVDTblType.setCustomField21(invVoucherDetails.get(i).getCustomField21());
//            invVDTblType.setCustomField22(invVoucherDetails.get(i).getCustomField22());
//            invVDTblType.setCustomField23(invVoucherDetails.get(i).getCustomField23());
//            invVDTblType.setCustomField24(invVoucherDetails.get(i).getCustomField24());
//            invVDTblType.setCustomField25(invVoucherDetails.get(i).getCustomField25());
//            invVDTblType.setStoreID(invVoucherDetails.get(i).getStoreID());
//            invVDTblType.setFeeAgreement(invVoucherDetails.get(i).getFeeAgreement());
//            invVDTblType.setFeeDiscountPrice(invVoucherDetails.get(i).getFeeDiscountPrice());
//            invVDTblType.setFeeDiscountPercent(invVoucherDetails.get(i).getFeeDiscountPercent());
//            invVDTblType.setCenter1ID(invVoucherDetails.get(i).getCenter1ID());
//            invVDTblType.setCenter2ID(invVoucherDetails.get(i).getCenter3ID());
//            invVDTblType.setiGUID(null);
//            invVDTblType.setBaseFee(invVoucherDetails.get(i).getBaseFee());
//            invVDTblType.setAnalysisNo(invVoucherDetails.get(i).getAnalysisNo());
//            invVDTblType.setBaseDReferId(invVoucherDetails.get(i).getBaseDReferID());
//            invVDTblType.setAnalysisNos(invVoucherDetails.get(i).getAnalysisNos());
//            invVDTblType.setSupplyType(null);
//            invVDTblType.setMppDID(invVoucherDetails.get(i).getMppDID());
//            invVDTblType.setBuyDID(null);
//            invVDTblTypes.add(invVDTblType);
//        }
//
//        if (invVoucherHeader.getVoucherNumber() == null) {
////            Insert
//            tParameters.add(new TParameter<>("VoucherNumber", new BigDecimal(1)));
//        } else {
////            Update
//            tParameters.add(new TParameter<>("VoucherNumber", invVoucherHeader.getVoucherNumber()));
//        }
//
//
//        tParameters.add(new TParameter<>("VoucherDate", voucherDate));
//        tParameters.add(new TParameter<>("VoucherDateG", voucherDateG));
//        tParameters.add(new TParameter<>("ReferNumber", invVoucherHeader.getReferNumber()));
//        tParameters.add(new TParameter<>("ReferDate", invVoucherHeader.getReferDate()));
//        tParameters.add(new TParameter<>("VoucherTypeID", invVoucherHeader.getVoucherTypeID()));
//        tParameters.add(new TParameter<>("RefTypeID", invVoucherHeader.getRefTypeID()));
//        tParameters.add(new TParameter<>("TafsiliID", invVoucherHeader.getTafsiliID()));
//        tParameters.add(new TParameter<>("StoreID", invVoucherHeader.getStoreID()));
//        tParameters.add(new TParameter<>("ToStoreID", invVoucherHeader.getToStoreID()));
//        tParameters.add(new TParameter<>("VoucherStatID", invVoucherHeader.getVoucherStatID()));
//        tParameters.add(new TParameter<>("YearID", logLogins.getPubUser().getActiveYearID()));
//        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
//        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
//        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
//        tParameters.add(new TParameter<>("VoucherDesc", invVoucherHeader.getVoucherDesc()));
//        tParameters.add(new TParameter<>("ReferID", invVoucherHeader.getReferID()));
//        tParameters.add(new TParameter<>("AnalysisSetup", null));
//        tParameters.add(new TParameter<>("Center1ID", invVoucherHeader.getCenter1ID()));
//        tParameters.add(new TParameter<>("Center2ID", invVoucherHeader.getCenter2ID()));
//        tParameters.add(new TParameter<>("Center3ID", invVoucherHeader.getCenter3ID()));
//        tParameters.add(new TParameter<>("AccountID", invVoucherHeader.getAccountID()));
//        tParameters.add(new TParameter<>("BaseRefTypeId", invVoucherHeader.getBaseRefTypeId()));
//        tParameters.add(new TParameter<>("VoucherHeaderID", voucherHeaderID));
//        tParameters.add(new TParameter<>("RowID", invVoucherHeader.getRowID()));
//        tParameters.add(new TParameter<>("TDel", null));
//        tParameters.add(new TParameter<>("TVD", invVDTblTypes));
//        tParameters.add(new TParameter<>("TSerial", null));
//        tParameters.add(new TParameter<>("TSerialDel", null));
//        tParameters.add(new TParameter<>("CurrencyID", null));
//
//        tParameters.add(new TParameter<>("MppDID", null));
//        tParameters.add(new TParameter<>("MppOPCProcessID", null));
//        tParameters.add(new TParameter<>("AnalysisNo", null));
//        tParameters.add(new TParameter<>("DeliveryID", null));
//        ResultErrMsgNewID resultErrMsgNewID = execSPNativeQuery(InvVoucher.class, "InvInsVoucherHD", tParameters);
//        return invShowVoucher(
//                voucherHeaderRepository,
//                voucherDetailRepository,
//                resultErrMsgNewID.getNewID());
//
//
//    }

    default InvVoucher invInsVoucherHD(
            BigDecimal voucherHeaderID,
            InvVoucherHeaderRepository voucherHeaderRepository,
            InvVoucherDetailRepository voucherDetailRepository,
            PubVoucherTypeRepository pubVoucherTypeRepository,
            SaleVoucherHeaderRepository saleVoucherHeaderRepository,
            InvVoucher invVoucher
    ) {


        LogLogins logLogins = fetchUserDetail();
        List<InvVoucherDetail> invVoucherDetails = invVoucher.getDetails();
        InvVoucherHeader invVoucherHeader = invVoucher.getHeader();
        invVoucherHeader.setVoucherHeaderID(voucherHeaderID);
        TCalendar tCalendar = new TCalendar();
        String manualDate = invVoucherHeader.getVoucherDate();
        String voucherDate;
        String voucherDateG;
        if (manualDate != null) {
            tCalendar.setIranianDateBySlash(manualDate);
        }

        voucherDate = tCalendar.getIranianDateBySlashZero();
        voucherDateG = tCalendar.getGregorianDateByTime();
        List<TParameter<?>> tParameters = new ArrayList<>();
        List<InvVDTblType> invVDTblTypes = new ArrayList<>();
//        List<TSerial> tSerials = new ArrayList<>();

        for (int i = 0; i < invVoucherDetails.size(); i++) {
//            List<TSerial> tTSerialsDTO =  invVoucherDetails.get(i).getTSerials();
//            if(tTSerialsDTO==null){
//                tTSerialsDTO= new ArrayList<>();
//            }
//            for (int j = 0; j < tTSerialsDTO.size(); j++) {
//                TSerial tSerial = new TSerial();
//                tSerial.setField1(tTSerialsDTO.get(j).getField1());
//                tSerial.setField2(tTSerialsDTO.get(j).getField2());
//                tSerial.setField3(tTSerialsDTO.get(j).getField3());
//                tSerial.setField4(tTSerialsDTO.get(j).getField4());
//                tSerial.setField5(tTSerialsDTO.get(j).getField5());
//                tSerial.setField6(tTSerialsDTO.get(j).getField6());
//                tSerial.setField7(tTSerialsDTO.get(j).getField7());
//                tSerial.setField8(tTSerialsDTO.get(j).getField8());
//                tSerial.setField9(tTSerialsDTO.get(j).getField9());
//                tSerial.setField10(tTSerialsDTO.get(j).getField10());
//                tSerial.setBaseSerialGoodsID(tTSerialsDTO.get(j).getBaseSerialGoodsID());
//                tSerial.setRefSerialGoodsID(tTSerialsDTO.get(j).getRefSerialGoodsID());
//                tSerial.setSerialGoodsDesc(tTSerialsDTO.get(j).getSerialGoodsDesc());
//                tSerial.setSerialGoodsID(tTSerialsDTO.get(j).getSerialGoodsID());
//                tSerial.setSerialQuantity(tTSerialsDTO.get(j).getSerialQuantity());
//                tSerial.setRowID(tTSerialsDTO.get(j).getRowID());
//                tSerial.setvDID(tTSerialsDTO.get(j).getvDID());
//                tSerial.setiGUID(String.valueOf(i));// این مقدار باید برای هر یطر یونیک باشد و برابر جی یو آی دی هر سطر باشد
//                tSerials.add(tSerial);
//
//            }
            InvVDTblType invVDTblType = new InvVDTblType();
            invVDTblType.setRowNo(new BigDecimal(i));
            invVDTblType.setVoucherDetailID(invVoucherDetails.get(i).getVoucherDetailID());
            invVDTblType.setVoucherDetailID(invVoucherDetails.get(i).getVoucherDetailID());
            invVDTblType.setVoucherDetailID(invVoucherDetails.get(i).getVoucherDetailID());
            invVDTblType.setVoucherHeaderID(invVoucherDetails.get(i).getVoucherHeaderID());
            invVDTblType.setGoodsID(invVoucherDetails.get(i).getGoodsID());
            invVDTblType.setSecUnitID(invVoucherDetails.get(i).getSecUnitID());
            invVDTblType.setQuantity(invVoucherDetails.get(i).getQuantity());
            invVDTblType.setFee(invVoucherDetails.get(i).getFee());
            invVDTblType.setDetailXDesc(invVoucherDetails.get(i).getDetailXDesc());
            invVDTblType.setDReferID(invVoucherDetails.get(i).getdReferID());
            invVDTblType.setCreatorID(invVoucherDetails.get(i).getCreatorID());
            invVDTblType.setModifierID(invVoucherDetails.get(i).getModifierID());
            invVDTblType.setDifferentialID(invVoucherDetails.get(i).getDifferentialID());
            invVDTblType.setAnalysisSetup(null);
            invVDTblType.setComputeValue(invVoucherDetails.get(i).getComputeValue());
            invVDTblType.setCustomField1(invVoucherDetails.get(i).getCustomField1());
            invVDTblType.setCustomField2(invVoucherDetails.get(i).getCustomField2());
            invVDTblType.setCustomField3(invVoucherDetails.get(i).getCustomField3());
            invVDTblType.setCustomField4(invVoucherDetails.get(i).getCustomField4());
            invVDTblType.setCustomField5(invVoucherDetails.get(i).getCustomField5());
            invVDTblType.setCustomField6(invVoucherDetails.get(i).getCustomField6());
            invVDTblType.setCustomField7(invVoucherDetails.get(i).getCustomField7());
            invVDTblType.setCustomField8(invVoucherDetails.get(i).getCustomField8());
            invVDTblType.setCustomField9(invVoucherDetails.get(i).getCustomField9());
            invVDTblType.setCustomField10(invVoucherDetails.get(i).getCustomField10());
            invVDTblType.setCustomField11(invVoucherDetails.get(i).getCustomField11());
            invVDTblType.setFeeFrieghtCharges(invVoucherDetails.get(i).getFeeFrieghtCharges());
            invVDTblType.setlCReferID(invVoucherDetails.get(i).getlCReferID());
            invVDTblType.setAgrReferID(invVoucherDetails.get(i).getAgrReferID());
            invVDTblType.setQuantity2(invVoucherDetails.get(i).getQuantity2());
            invVDTblType.setQuantity3(invVoucherDetails.get(i).getQuantity3());
            invVDTblType.setSecUnitID2(invVoucherDetails.get(i).getSecUnitID2());
            invVDTblType.setSecUnitID3(invVoucherDetails.get(i).getSecUnitID3());
            invVDTblType.setCustomField12(invVoucherDetails.get(i).getCustomField12());
            invVDTblType.setCustomField13(invVoucherDetails.get(i).getCustomField13());
            invVDTblType.setCustomField14(invVoucherDetails.get(i).getCustomField14());
            invVDTblType.setCustomField15(invVoucherDetails.get(i).getCustomField15());
            invVDTblType.setCustomField16(invVoucherDetails.get(i).getCustomField16());
            invVDTblType.setCustomField17(invVoucherDetails.get(i).getCustomField17());
            invVDTblType.setCustomField18(invVoucherDetails.get(i).getCustomField18());
            invVDTblType.setCustomField19(invVoucherDetails.get(i).getCustomField19());
            invVDTblType.setCustomField20(invVoucherDetails.get(i).getCustomField20());
            invVDTblType.setCustomField21(invVoucherDetails.get(i).getCustomField21());
            invVDTblType.setCustomField22(invVoucherDetails.get(i).getCustomField22());
            invVDTblType.setCustomField23(invVoucherDetails.get(i).getCustomField23());
            invVDTblType.setCustomField24(invVoucherDetails.get(i).getCustomField24());
            invVDTblType.setCustomField25(invVoucherDetails.get(i).getCustomField25());
            invVDTblType.setStoreID(invVoucherDetails.get(i).getStoreID());
            invVDTblType.setFeeAgreement(invVoucherDetails.get(i).getFeeAgreement());
            invVDTblType.setFeeDiscountPrice(invVoucherDetails.get(i).getFeeDiscountPrice());
            invVDTblType.setFeeDiscountPercent(invVoucherDetails.get(i).getFeeDiscountPercent());
            invVDTblType.setCenter1ID(invVoucherDetails.get(i).getCenter1ID());
            invVDTblType.setCenter2ID(invVoucherDetails.get(i).getCenter3ID());
            invVDTblType.setiGUID(null);
            invVDTblType.setBaseFee(invVoucherDetails.get(i).getBaseFee());
            invVDTblType.setAnalysisNo(invVoucherDetails.get(i).getAnalysisNo());
            invVDTblType.setBaseDReferId(invVoucherDetails.get(i).getBaseDReferID());
            invVDTblType.setAnalysisNos(invVoucherDetails.get(i).getAnalysisNos());
            invVDTblType.setSupplyType(null);
//            invVDTblType.setMppDID(invVoucherDetails.get(i).getMppDID());
            invVDTblType.setMppDID(null);
            invVDTblType.setBuyDID(null);
            invVDTblTypes.add(invVDTblType);
        }

//        SQLServerDataRecordTSerial sQLServerDataRecordTSerialTSerial = new SQLServerDataRecordTSerial(tSerials.toArray(new TSerial[0]));
//        SQLServerDataRecordTempT2 sQLServerDataRecordTempT2TSerialDel = new SQLServerDataRecordTempT2(new TempT2[0]);


        if (invVoucherHeader.getVoucherNumber() == null) {
//            Insert
            tParameters.add(new TParameter<>("VoucherNumber", new BigDecimal(1)));
        } else {
//            Update
            tParameters.add(new TParameter<>("VoucherNumber", invVoucherHeader.getVoucherNumber()));
        }
        if (invVoucherHeader.getRefTypeID() != null || invVoucherHeader.getRefTypeID() != BigDecimal.valueOf(1)) {
            if ((pubVoucherTypeRepository.pubShowVoucherTypeByID(invVoucherHeader.getRefTypeID()).getSystemID()) == BigDecimal.valueOf(6)) {
                tParameters.add(new TParameter<>("TafsiliID", saleVoucherHeaderRepository.saleShowVoucherHeaderByID(voucherHeaderID).getCustomerTID()));
            } else {
                tParameters.add(new TParameter<>("TafsiliID", invVoucherHeader.getTafsiliID()));
            }
        }
//
//        if ((pubVoucherTypeRepository.pubShowVoucherTypeByID(invVoucherHeader.getRefTypeID()).getSystemID()) == BigDecimal.valueOf(6)) {
//            tParameters.add(new TParameter<>("TafsiliID", null));
//        } else {
//            tParameters.add(new TParameter<>("TafsiliID", invVoucherHeader.getTafsiliID()));
//        }


        tParameters.add(new TParameter<>("VoucherDate", voucherDate));
        tParameters.add(new TParameter<>("VoucherDateG", voucherDateG));
        tParameters.add(new TParameter<>("ReferNumber", invVoucherHeader.getReferNumber()));
        tParameters.add(new TParameter<>("ReferDate", invVoucherHeader.getReferDate()));
        tParameters.add(new TParameter<>("VoucherTypeID", invVoucherHeader.getVoucherTypeID()));
        tParameters.add(new TParameter<>("RefTypeID", invVoucherHeader.getRefTypeID()));
        tParameters.add(new TParameter<>("TafsiliID", invVoucherHeader.getTafsiliID()));
        tParameters.add(new TParameter<>("StoreID", invVoucherHeader.getStoreID()));
        tParameters.add(new TParameter<>("ToStoreID", invVoucherHeader.getToStoreID()));
        tParameters.add(new TParameter<>("VoucherStatID", invVoucherHeader.getVoucherStatID()));
        tParameters.add(new TParameter<>("YearID", logLogins.getPubUser().getActiveYearID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("VoucherDesc", invVoucherHeader.getVoucherDesc()));
        tParameters.add(new TParameter<>("ReferID", invVoucherHeader.getReferID()));
        tParameters.add(new TParameter<>("AnalysisSetup", null));
        tParameters.add(new TParameter<>("Center1ID", invVoucherHeader.getCenter1ID()));
        tParameters.add(new TParameter<>("Center2ID", invVoucherHeader.getCenter2ID()));
        tParameters.add(new TParameter<>("Center3ID", invVoucherHeader.getCenter3ID()));
        tParameters.add(new TParameter<>("AccountID", invVoucherHeader.getAccountID()));
        tParameters.add(new TParameter<>("BaseRefTypeId", invVoucherHeader.getBaseRefTypeId()));
        tParameters.add(new TParameter<>("VoucherHeaderID", voucherHeaderID));
        tParameters.add(new TParameter<>("RowID", invVoucherHeader.getRowID()));
        tParameters.add(new TParameter<>("TDel", null));
        tParameters.add(new TParameter<>("TVD", invVDTblTypes));
        tParameters.add(new TParameter<>("TSerial", null));
        tParameters.add(new TParameter<>("TSerialDel", null));
        tParameters.add(new TParameter<>("CurrencyID", null));

        tParameters.add(new TParameter<>("MppDID", null));
        tParameters.add(new TParameter<>("MppOPCProcessID", null));
        tParameters.add(new TParameter<>("AnalysisNo", null));
//        tParameters.add(new TParameter<>("DeliveryID", null));
        ResultErrMsgNewID resultErrMsgNewID = execSPNativeQuery(InvVoucher.class, "InvInsVoucherHD", tParameters);
        return invShowVoucher(
                voucherHeaderRepository,
                voucherDetailRepository,
                resultErrMsgNewID.getNewID());


    }


    default InvVoucher invInsVoucherHDRostami(
            BigDecimal voucherHeaderID,
            InvVoucherHeaderRepository voucherHeaderRepository,
            InvVoucherDetailRepository voucherDetailRepository,
            PubVoucherTypeRepository pubVoucherTypeRepository,
            InvVoucher invVoucher
    ) {


        LogLogins logLogins = fetchUserDetail();
        List<InvVoucherDetail> invVoucherDetails = invVoucher.getDetails();
        InvVoucherHeader invVoucherHeader = invVoucher.getHeader();
        invVoucherHeader.setVoucherHeaderID(voucherHeaderID);
        TCalendar tCalendar = new TCalendar();
        String manualDate = invVoucherHeader.getVoucherDate();
        String voucherDate;
        String voucherDateG;
        if (manualDate != null) {
            tCalendar.setIranianDateBySlash(manualDate);
        }

        voucherDate = tCalendar.getIranianDateBySlashZero();
        voucherDateG = tCalendar.getGregorianDateByTime();
        List<TParameter<?>> tParameters = new ArrayList<>();
        List<InvVDTblType> invVDTblTypes = new ArrayList<>();
        List<TSerial> tSerial = new ArrayList<>();

        for (int i = 0; i < invVoucherDetails.size(); i++) {
            List<TSerial> tTSerialsDTO = invVoucherDetails.get(i).getTSerial();
            if (tTSerialsDTO == null) {
                tTSerialsDTO = new ArrayList<>();
            }
            for (int j = 0; j < tTSerialsDTO.size(); j++) {
//                TSerial tSerialObject = new TSerial();
//                tSerialObject.setField1(tTSerialsDTO.get(j).getField1());
//                tSerialObject.setField2(tTSerialsDTO.get(j).getField2());
//                tSerialObject.setField3(tTSerialsDTO.get(j).getField3());
//                tSerialObject.setField4(tTSerialsDTO.get(j).getField4());
//                tSerialObject.setField5(tTSerialsDTO.get(j).getField5());
//                tSerialObject.setField6(tTSerialsDTO.get(j).getField6());
//                tSerialObject.setField7(tTSerialsDTO.get(j).getField7());
//                tSerialObject.setField8(tTSerialsDTO.get(j).getField8());
//                tSerialObject.setField9(tTSerialsDTO.get(j).getField9());
//                tSerialObject.setField10(tTSerialsDTO.get(j).getField10());
//                tSerialObject.setBaseSerialGoodsID(tTSerialsDTO.get(j).getBaseSerialGoodsID());
//                tSerialObject.setRefSerialGoodsID(tTSerialsDTO.get(j).getRefSerialGoodsID());
//                tSerialObject.setSerialGoodsDesc(tTSerialsDTO.get(j).getSerialGoodsDesc());
//                tSerialObject.setSerialGoodsID(tTSerialsDTO.get(j).getSerialGoodsID());
//                tSerialObject.setSerialQuantity(tTSerialsDTO.get(j).getSerialQuantity());
//                tSerialObject.setRowID(tTSerialsDTO.get(j).getRowID());
//                tSerialObject.setvDID(tTSerialsDTO.get(j).getvDID());
//                tSerialObject.setiGUID(String.valueOf(i));// این مقدار باید برای هر یطر یونیک باشد و برابر جی یو آی دی هر سطر باشد
//                tSerial.add(tSerialObject);
                TSerial tSerialObject = new TSerial();
                tSerialObject.setSerialGoodsDesc(tTSerialsDTO.get(j).getSerialGoodsDesc());
                tSerialObject.setSerialQuantity(tTSerialsDTO.get(j).getSerialQuantity());
                tSerialObject.setRefSerialGoodsID(tTSerialsDTO.get(j).getRefSerialGoodsID());
                tSerialObject.setSerialGoodsID(tTSerialsDTO.get(j).getSerialGoodsID());
                tSerialObject.setBaseSerialGoodsID(tTSerialsDTO.get(j).getBaseSerialGoodsID());
                tSerialObject.setField1(tTSerialsDTO.get(j).getField1());
                tSerialObject.setField2(tTSerialsDTO.get(j).getField2());
                tSerialObject.setField3(tTSerialsDTO.get(j).getField3());
                tSerialObject.setField4(tTSerialsDTO.get(j).getField4());
                tSerialObject.setField5(tTSerialsDTO.get(j).getField5());
                tSerialObject.setField6(tTSerialsDTO.get(j).getField6());
                tSerialObject.setField7(tTSerialsDTO.get(j).getField7());
                tSerialObject.setField8(tTSerialsDTO.get(j).getField8());
                tSerialObject.setField9(tTSerialsDTO.get(j).getField9());
                tSerialObject.setField10(tTSerialsDTO.get(j).getField10());
                tSerialObject.setRowID(tTSerialsDTO.get(j).getRowID());
                tSerialObject.setiGUID(String.valueOf(i));
                tSerialObject.setvDID(tTSerialsDTO.get(j).getvDID());
                tSerial.add(tSerialObject);
                System.out.println("tTSerialsDTO.get(j).getSerialGoodsDesc() " +
                        "" + tTSerialsDTO.get(j).getSerialGoodsDesc());
                System.out.println("tSerial " + tSerial.get(j).getSerialGoodsDesc());
            }
            InvVDTblType invVDTblType = new InvVDTblType();
            invVDTblType.setRowNo(new BigDecimal(i));
            invVDTblType.setVoucherDetailID(invVoucherDetails.get(i).getVoucherDetailID());
            invVDTblType.setVoucherDetailID(invVoucherDetails.get(i).getVoucherDetailID());
            invVDTblType.setVoucherDetailID(invVoucherDetails.get(i).getVoucherDetailID());
            invVDTblType.setVoucherHeaderID(invVoucherDetails.get(i).getVoucherHeaderID());
            invVDTblType.setGoodsID(invVoucherDetails.get(i).getGoodsID());
            invVDTblType.setSecUnitID(invVoucherDetails.get(i).getSecUnitID());
            invVDTblType.setQuantity(invVoucherDetails.get(i).getQuantity());
            invVDTblType.setFee(invVoucherDetails.get(i).getFee());
            invVDTblType.setDetailXDesc(invVoucherDetails.get(i).getDetailXDesc());
            invVDTblType.setDReferID(invVoucherDetails.get(i).getdReferID());
            invVDTblType.setCreatorID(invVoucherDetails.get(i).getCreatorID());
            invVDTblType.setModifierID(invVoucherDetails.get(i).getModifierID());
            invVDTblType.setDifferentialID(invVoucherDetails.get(i).getDifferentialID());
            invVDTblType.setAnalysisSetup(null);
            invVDTblType.setComputeValue(invVoucherDetails.get(i).getComputeValue());
            invVDTblType.setCustomField1(invVoucherDetails.get(i).getCustomField1());
            invVDTblType.setCustomField2(invVoucherDetails.get(i).getCustomField2());
            invVDTblType.setCustomField3(invVoucherDetails.get(i).getCustomField3());
            invVDTblType.setCustomField4(invVoucherDetails.get(i).getCustomField4());
            invVDTblType.setCustomField5(invVoucherDetails.get(i).getCustomField5());
            invVDTblType.setCustomField6(invVoucherDetails.get(i).getCustomField6());
            invVDTblType.setCustomField7(invVoucherDetails.get(i).getCustomField7());
            invVDTblType.setCustomField8(invVoucherDetails.get(i).getCustomField8());
            invVDTblType.setCustomField9(invVoucherDetails.get(i).getCustomField9());
            invVDTblType.setCustomField10(invVoucherDetails.get(i).getCustomField10());
            invVDTblType.setCustomField11(invVoucherDetails.get(i).getCustomField11());
            invVDTblType.setFeeFrieghtCharges(invVoucherDetails.get(i).getFeeFrieghtCharges());
            invVDTblType.setlCReferID(invVoucherDetails.get(i).getlCReferID());
            invVDTblType.setAgrReferID(invVoucherDetails.get(i).getAgrReferID());
            invVDTblType.setQuantity2(invVoucherDetails.get(i).getQuantity2());
            invVDTblType.setQuantity3(invVoucherDetails.get(i).getQuantity3());
            invVDTblType.setSecUnitID2(invVoucherDetails.get(i).getSecUnitID2());
            invVDTblType.setSecUnitID3(invVoucherDetails.get(i).getSecUnitID3());
            invVDTblType.setCustomField12(invVoucherDetails.get(i).getCustomField12());
            invVDTblType.setCustomField13(invVoucherDetails.get(i).getCustomField13());
            invVDTblType.setCustomField14(invVoucherDetails.get(i).getCustomField14());
            invVDTblType.setCustomField15(invVoucherDetails.get(i).getCustomField15());
            invVDTblType.setCustomField16(invVoucherDetails.get(i).getCustomField16());
            invVDTblType.setCustomField17(invVoucherDetails.get(i).getCustomField17());
            invVDTblType.setCustomField18(invVoucherDetails.get(i).getCustomField18());
            invVDTblType.setCustomField19(invVoucherDetails.get(i).getCustomField19());
            invVDTblType.setCustomField20(invVoucherDetails.get(i).getCustomField20());
            invVDTblType.setCustomField21(invVoucherDetails.get(i).getCustomField21());
            invVDTblType.setCustomField22(invVoucherDetails.get(i).getCustomField22());
            invVDTblType.setCustomField23(invVoucherDetails.get(i).getCustomField23());
            invVDTblType.setCustomField24(invVoucherDetails.get(i).getCustomField24());
            invVDTblType.setCustomField25(invVoucherDetails.get(i).getCustomField25());
            invVDTblType.setStoreID(invVoucherDetails.get(i).getStoreID());
            invVDTblType.setFeeAgreement(invVoucherDetails.get(i).getFeeAgreement());
            invVDTblType.setFeeDiscountPrice(invVoucherDetails.get(i).getFeeDiscountPrice());
            invVDTblType.setFeeDiscountPercent(invVoucherDetails.get(i).getFeeDiscountPercent());
            invVDTblType.setCenter1ID(invVoucherDetails.get(i).getCenter1ID());
            invVDTblType.setCenter2ID(invVoucherDetails.get(i).getCenter3ID());
            invVDTblType.setiGUID(null);
            invVDTblType.setBaseFee(invVoucherDetails.get(i).getBaseFee());
            invVDTblType.setAnalysisNo(invVoucherDetails.get(i).getAnalysisNo());
            invVDTblType.setBaseDReferId(invVoucherDetails.get(i).getBaseDReferID());
            invVDTblType.setAnalysisNos(invVoucherDetails.get(i).getAnalysisNos());
            invVDTblType.setSupplyType(null);
//            invVDTblType.setMppDID(invVoucherDetails.get(i).getMppDID());
            invVDTblType.setMppDID(null);
            invVDTblType.setBuyDID(null);
            invVDTblTypes.add(invVDTblType);
        }

//        SQLServerDataRecordTSerial sQLServerDataRecordTSerial = new SQLServerDataRecordTSerial(tSerials.toArray(new TSerial[0]));
//        SQLServerDataRecordTSerial sQLServerDataRecordTSerial = new SQLServerDataRecordTSerial(tSerials.toArray(new TSerial[0]));
//        SQLServerDataRecordTempT2 sQLServerDataRecordTempT2TSerialDel = new SQLServerDataRecordTempT2(new TempT2[0]);


        if (invVoucherHeader.getVoucherNumber() == null) {
//            Insert
            tParameters.add(new TParameter<>("VoucherNumber", new BigDecimal(1)));
        } else {
//            Update
            tParameters.add(new TParameter<>("VoucherNumber", invVoucherHeader.getVoucherNumber()));
        }
//
//        if ((pubVoucherTypeRepository.pubShowVoucherTypeByID(invVoucherHeader.getRefTypeID()).getSystemID()) == BigDecimal.valueOf(6)) {
//            tParameters.add(new TParameter<>("TafsiliID", null));
//        } else {
//            tParameters.add(new TParameter<>("TafsiliID", invVoucherHeader.getTafsiliID()));
//        }

        tParameters.add(new TParameter<>("VoucherDate", voucherDate));
        tParameters.add(new TParameter<>("VoucherDateG", voucherDateG));
        tParameters.add(new TParameter<>("ReferNumber", invVoucherHeader.getReferNumber()));
        tParameters.add(new TParameter<>("ReferDate", invVoucherHeader.getReferDate()));
        tParameters.add(new TParameter<>("VoucherTypeID", invVoucherHeader.getVoucherTypeID()));
        tParameters.add(new TParameter<>("RefTypeID", invVoucherHeader.getRefTypeID()));
        tParameters.add(new TParameter<>("TafsiliID", invVoucherHeader.getTafsiliID()));
        tParameters.add(new TParameter<>("StoreID", invVoucherHeader.getStoreID()));
        tParameters.add(new TParameter<>("ToStoreID", invVoucherHeader.getToStoreID()));
        tParameters.add(new TParameter<>("VoucherStatID", invVoucherHeader.getVoucherStatID()));
        tParameters.add(new TParameter<>("YearID", logLogins.getPubUser().getActiveYearID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("VoucherDesc", invVoucherHeader.getVoucherDesc()));
        tParameters.add(new TParameter<>("ReferID", invVoucherHeader.getReferID()));
        tParameters.add(new TParameter<>("AnalysisSetup", null));
        tParameters.add(new TParameter<>("Center1ID", invVoucherHeader.getCenter1ID()));
        tParameters.add(new TParameter<>("Center2ID", invVoucherHeader.getCenter2ID()));
        tParameters.add(new TParameter<>("Center3ID", invVoucherHeader.getCenter3ID()));
        tParameters.add(new TParameter<>("AccountID", invVoucherHeader.getAccountID()));
        tParameters.add(new TParameter<>("BaseRefTypeId", invVoucherHeader.getBaseRefTypeId()));
        tParameters.add(new TParameter<>("VoucherHeaderID", voucherHeaderID));
        tParameters.add(new TParameter<>("RowID", invVoucherHeader.getRowID()));
        tParameters.add(new TParameter<>("TDel", null));
        tParameters.add(new TParameter<>("TVD", invVDTblTypes));
        System.out.println("Last is " + tSerial.get(0).getSerialGoodsDesc());
        tParameters.add(new TParameter<>("TSerial", "tSerial", tSerial));
//        tParameters.add(new TParameter<>("TSerial", "TSerial", tSerial));
        tParameters.add(new TParameter<>("TSerialDel", "TSerialDel", null));
        tParameters.add(new TParameter<>("CurrencyID", null));

        tParameters.add(new TParameter<>("MppDID", null));
        tParameters.add(new TParameter<>("MppOPCProcessID", null));
        tParameters.add(new TParameter<>("AnalysisNo", null));
//        tParameters.add(new TParameter<>("DeliveryID", null));
        ResultErrMsgNewID resultErrMsgNewID = execSPNativeQueryTSerial(InvVoucher.class, "InvInsVoucherHD", tParameters);
//        ResultErrMsgNewID resultErrMsgNewID = execSPNativeQuery(InvVoucher.class, "InvInsVoucherHD", tParameters);
        return invShowVoucher(
                voucherHeaderRepository,
                voucherDetailRepository,
                resultErrMsgNewID.getNewID());


    }

//    default InvVoucher invInsVoucherHD(InvVoucherHeaderRepository invVoucherHeaderRepository,
//                                       InvVoucherDetailRepository invVoucherDetailRepository,
//                                       com.tarazgroup.tws.dto.inv.InvVoucher invVoucher) {
//        LogLogins logLogins = fetchUserDetail();
//        List<com.tarazgroup.tws.dto.inv.InvVoucherDetail> invVoucherDetails = invVoucher.getDetails();
//        InvVDTblType[] invVDTblTypesDetails = new InvVDTblType[invVoucherDetails.size()];
//        List<TSerial> tSerials = new ArrayList<>();
//
//        for (int i = 0; i < invVoucherDetails.size(); i++) {
//            List<com.tarazgroup.tws.dto.inv.TSerial> tTSerialsDTO =  invVoucherDetails.get(i).getTSerials();
//            if(tTSerialsDTO==null){
//                tTSerialsDTO= new ArrayList<>();
//            }
//            for (int j = 0; j < tTSerialsDTO.size(); j++) {
//                TSerial tSerial = new TSerial();
//                tSerial.setField1(tTSerialsDTO.get(j).getField1());
//                tSerial.setField2(tTSerialsDTO.get(j).getField2());
//                tSerial.setField3(tTSerialsDTO.get(j).getField3());
//                tSerial.setField4(tTSerialsDTO.get(j).getField4());
//                tSerial.setField5(tTSerialsDTO.get(j).getField5());
//                tSerial.setField6(tTSerialsDTO.get(j).getField6());
//                tSerial.setField7(tTSerialsDTO.get(j).getField7());
//                tSerial.setField8(tTSerialsDTO.get(j).getField8());
//                tSerial.setField9(tTSerialsDTO.get(j).getField9());
//                tSerial.setField10(tTSerialsDTO.get(j).getField10());
//                tSerial.setBaseSerialGoodsID(tTSerialsDTO.get(j).getBaseSerialGoodsID());
//                tSerial.setRefSerialGoodsID(tTSerialsDTO.get(j).getRefSerialGoodsID());
//                tSerial.setSerialGoodsDesc(tTSerialsDTO.get(j).getSerialGoodsDesc());
//                tSerial.setSerialGoodsID(tTSerialsDTO.get(j).getSerialGoodsID());
//                tSerial.setSerialQuantity(tTSerialsDTO.get(j).getSerialQuantity());
//                tSerial.setRowID(tTSerialsDTO.get(j).getRowID());
//                tSerial.setvDID(tTSerialsDTO.get(j).getvDID());
//                tSerial.setiGUID(String.valueOf(i));// این مقدار باید برای هر یطر یونیک باشد و برابر جی یو آی دی هر سطر باشد
//                tSerials.add(tSerial);
//
//            }
//            InvVDTblType invVDTblType = new InvVDTblType();
//            invVDTblType.setRowNo(new BigDecimal(i + 1));
//            invVDTblType.setVoucherDetailID(null);
//            invVDTblType.setVoucherHeaderID(null);
//            invVDTblType.setGoodsID(invVoucherDetails.get(i).getGoodsID());
//            invVDTblType.setSecUnitID(invVoucherDetails.get(i).getSecUnitID());
//            invVDTblType.setQuantity(invVoucherDetails.get(i).getQuantity());
//            invVDTblType.setFee(null);
//            invVDTblType.setDetailXDesc(null);
//            invVDTblType.setDReferID(invVoucherDetails.get(i).getDReferID());
//            invVDTblType.setCreatorID(logLogins.getPubUser().getUserID());
//            invVDTblType.setModifierID(logLogins.getPubUser().getUserID());
//            invVDTblType.setDifferentialID(null);
//            invVDTblType.setAnalysisSetup(null);
//            invVDTblType.setComputeValue(invVoucherDetails.get(i).getComputeValue());
//            invVDTblType.setCustomField2(null);
//            invVDTblType.setCustomField3(null);
//            invVDTblType.setCustomField4(null);
//            invVDTblType.setCustomField5(null);
//            invVDTblType.setCustomField6(null);
//            invVDTblType.setCustomField7(null);
//            invVDTblType.setCustomField8(null);
//            invVDTblType.setCustomField9(null);
//            invVDTblType.setCustomField10(null);
//            invVDTblType.setCustomField11(null);
//            invVDTblType.setFeeFrieghtCharges(null);
//            invVDTblType.setLCReferID(null);
//            invVDTblType.setAgrReferID(null);
//            invVDTblType.setQuantity2(null);
//            invVDTblType.setQuantity3(null);
//            invVDTblType.setSecUnitID2(null);
//            invVDTblType.setSecUnitID3(null);
//            invVDTblType.setCustomField12(null);
//            invVDTblType.setCustomField13(null);
//            invVDTblType.setCustomField14(null);
//            invVDTblType.setCustomField15(null);
//            invVDTblType.setCustomField16(null);
//            invVDTblType.setCustomField17(null);
//            invVDTblType.setCustomField18(null);
//            invVDTblType.setCustomField19(null);
//            invVDTblType.setCustomField20(null);
//            invVDTblType.setCustomField21(null);
//            invVDTblType.setCustomField22(null);
//            invVDTblType.setCustomField23(null);
//            invVDTblType.setCustomField24(null);
//            invVDTblType.setCustomField25(null);
//            invVDTblType.setFeeAgreement(null);
//            invVDTblType.setFeeDiscountPrice(null);
//            invVDTblType.setFeeDiscountPercent(null);
//            invVDTblType.setStoreID(null);
//            invVDTblType.setCenter1ID(null);
//            invVDTblType.setCenter2ID(null);
//            invVDTblType.setCenter3ID(null);
//            invVDTblType.setiGUID(String.valueOf(i));// این مقدار باید یونیک باشد و اگه کالا سریال دارد جی یو آی دی هر سطر و سریال های هر سطر یکی باشد
//            invVDTblType.setBaseFee(null);
//            invVDTblType.setAnalysisNo(null);
//            invVDTblType.setBaseDReferId(invVoucherDetails.get(i).getBaseDReferID());
//            invVDTblType.setAnalysisNos(null);
//            invVDTblTypesDetails[i] = invVDTblType;
//        }
//
//        SQLServerDataRecordInvVDTblType TVD = new SQLServerDataRecordInvVDTblType(invVDTblTypesDetails);
//        SQLServerDataRecordTempT2 sQLServerDataRecordTempT2TDel = new SQLServerDataRecordTempT2(new TempT2[0]);
//        SQLServerDataRecordTSerial sQLServerDataRecordTSerialTSerial = new SQLServerDataRecordTSerial(tSerials.toArray(new TSerial[0]));
//        SQLServerDataRecordTempT2 sQLServerDataRecordTempT2TSerialDel = new SQLServerDataRecordTempT2(new TempT2[0]);
//
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter("VoucherNumber", new BigDecimal(1)));
//        TCalendar tc = new TCalendar();
//        String manualDate = invVoucher.getHeader().getVoucherDate(); //A date that json give us(user entered himself)
//        if (manualDate != null) {
//            tc.setIranianDateBySlash(manualDate);
//            tParameters.add(new TParameter<>("VoucherDate", tc.getIranianDateBySlashZero()));
//            tParameters.add(new TParameter<>("VoucherDateG", tc.getSqlDate()));
//        } else { //Auto dating
//            tParameters.add(new TParameter<>("VoucherDate", tc.getIranianDateBySlashZero()));
//            tParameters.add(new TParameter<>("VoucherDateG", new Date()));
//        }
//        tParameters.add(new TParameter("ReferNumber", invVoucher.getHeader().getReferNumber()));
//        tParameters.add(new TParameter("ReferDate", invVoucher.getHeader().getReferDate()));
//        tParameters.add(new TParameter("VoucherTypeID", invVoucher.getHeader().getVoucherTypeID()));
//        tParameters.add(new TParameter("RefTypeID", invVoucher.getHeader().getRefTypeID()));
//        tParameters.add(new TParameter<>("TafsiliID", invVoucher.getHeader().getTafsiliID()));
//        tParameters.add(new TParameter<>("StoreID", invVoucher.getHeader().getStoreID()));
//        tParameters.add(new TParameter<>("ToStoreID", invVoucher.getHeader().getToStoreID()));
//        tParameters.add(new TParameter<>("VoucherStatID", invVoucher.getHeader().getVoucherStateID()));
//        tParameters.add(new TParameter<>("YearID", logLogins.getPubUser().getActiveYearID()));
//        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
//        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
//        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
//        tParameters.add(new TParameter<>("VoucherDesc", invVoucher.getHeader().getVoucherDesc()));
//        tParameters.add(new TParameter<>("ReferID", invVoucher.getHeader().getReferID()));
//        tParameters.add(new TParameter<>("AnalysisSetup", false));
//        tParameters.add(new TParameter<>("Center1ID", invVoucher.getHeader().getCenter1ID()));
//        tParameters.add(new TParameter<>("Center2ID", invVoucher.getHeader().getCenter2ID()));
//        tParameters.add(new TParameter<>("Center3ID", invVoucher.getHeader().getCenter3ID()));
//        tParameters.add(new TParameter<>("AccountID", invVoucher.getHeader().getAccountID()));
//        tParameters.add(new TParameter<>("BaseRefTypeId", invVoucher.getHeader().getBaseRefTypeId()));
//        tParameters.add(new TParameter<>("VoucherHeaderID", invVoucher.getHeader().getVoucherHeaderID()));
//        tParameters.add(new TParameter<>("RowID", invVoucher.getHeader().getRowID()));
//        tParameters.add(new TParameter<>("TDel", "TempT2", sQLServerDataRecordTempT2TDel));
//        tParameters.add(new TParameter<>("TVD", "InvVDTblType", TVD));
//        tParameters.add(new TParameter<>("TSerial", "TSerial", sQLServerDataRecordTSerialTSerial));
//        tParameters.add(new TParameter<>("TSerialDel", "TempT2", sQLServerDataRecordTempT2TSerialDel));
//        HashMap<String, Object> res = execute1("InvInsVoucherHD", tParameters);
//        BigDecimal result = (BigDecimal) res.get("Result");
//        String errMsg = (String) res.get("ErrMsg");
//        BigDecimal newID = (BigDecimal) res.get("NewID");
//        if (result.intValue() == 0) {
//            return invShowVoucher(
//                    invVoucherHeaderRepository,
//                    invVoucherDetailRepository,
//                    newID);
//        } else {
//            throw new TConflictException(result.intValue() , errMsg);
//        }
//
//    }
//**********************************************************************


}
