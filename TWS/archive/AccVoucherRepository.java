package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.ResultErrMsgNewID;
import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccVoucher;
import com.tarazgroup.tws.model.acc.AccVoucherDetail;
import com.tarazgroup.tws.model.acc.AccVoucherHeader;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TCalendar;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.tabletype.acc.AccVDTblType;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
public interface AccVoucherRepository extends TCrudRepository<AccVoucher>, CrudRepository<AccVoucher, BigDecimal> {

    default AccVoucher accShowVoucher(AccVoucherHeaderRepository accVoucherHeaderRepository,
                                      AccVoucherDetailRepository accVoucherDetailRepository,
                                      BigDecimal voucherHeaderID) {


        AccVoucherHeader accVoucherHeader = accVoucherHeaderRepository.accShowVoucherHeaderByID(voucherHeaderID);
        List<AccVoucherDetail> accVoucherDetailLights = accVoucherDetailRepository.accShowVoucherDetail(voucherHeaderID);
        AccVoucher accVoucher = new AccVoucher();
        accVoucher.setHeader(accVoucherHeader);
        accVoucher.setDetails(accVoucherDetailLights);
        return accVoucher;
    }

    default AccVoucher accInsVoucher(
            BigDecimal voucherHeaderID,
            AccVoucherHeaderRepository voucherHeaderRepository,
            AccVoucherDetailRepository voucherDetailRepository,
            AccVoucher accVoucher

    ) {
        LogLogins logLogins = fetchUserDetail();
        List<AccVoucherDetail> accVoucherDetails = accVoucher.getDetails();
        AccVoucherHeader accVoucherHeader = accVoucher.getHeader();
        accVoucherHeader.setVoucherHeaderID(voucherHeaderID);
        TCalendar tCalendar = new TCalendar();
        tCalendar
        String manualDate = accVoucherHeader.getVoucherDate();
        String voucherDate;
        String voucherDateG;
        if (manualDate != null) {
            tCalendar.setIranianDateBySlash(manualDate);
        }

        voucherDate = tCalendar.getIranianDateBySlashZero();
        voucherDateG = tCalendar.getGregorianDateByTime();
        List<TParameter<?>> tParameters = new ArrayList<>();
        List<AccVDTblType> accVDTblTypes = new ArrayList<>();

        for (int i = 0; i < accVoucherDetails.size(); i++) {
            AccVDTblType accVDTblType = new AccVDTblType();
            accVDTblType.setRowNo(new BigDecimal(i));
            accVDTblType.setVoucherDetailID(accVoucherDetails.get(i).getVoucherDetailID());
            accVDTblType.setVoucherDetailID(accVoucherDetails.get(i).getVoucherDetailID());
            accVDTblType.setAccountID(accVoucherDetails.get(i).getAccountID());
            accVDTblType.setTafsiliID(accVoucherDetails.get(i).getTafsiliID());
            accVDTblType.setCenter1ID(accVoucherDetails.get(i).getCenter1ID());
            accVDTblType.setCenter2ID(accVoucherDetails.get(i).getCenter2ID());
            accVDTblType.setCenter3ID(accVoucherDetails.get(i).getCenter3ID());
            accVDTblType.setBed(accVoucherDetails.get(i).getBed());
            accVDTblType.setBes(accVoucherDetails.get(i).getBes());
            accVDTblType.setDetailXDesc(accVoucherDetails.get(i).getDetailXDesc());
            accVDTblType.setCurrencyID(accVoucherDetails.get(i).getCurrencyID());
            accVDTblType.setCurrencyCount(null);
            accVDTblType.setDocCount(null);
            accVDTblType.setDocNum(accVoucherDetails.get(i).getDocNum());
            accVDTblType.setDocDate(accVoucherDetails.get(i).getDocDate());
            accVDTblType.setRowNo(new BigDecimal(i + 1));
            accVDTblType.setReferID(null);
            accVDTblType.setRefTypeID(null);
            accVDTblTypes.add(accVDTblType);
        }
        if (accVoucherHeader.getVoucherNumber() == null) {
//            Insert
            tParameters.add(new TParameter<>("VoucherNumber", new BigDecimal(1)));
        } else {
//            Update
            tParameters.add(new TParameter<>("VoucherNumber", accVoucherHeader.getVoucherNumber()));
        }
        tParameters.add(new TParameter("VoucherDate", voucherDate));
        tParameters.add(new TParameter("VoucherDateG", voucherDateG));
        tParameters.add(new TParameter<>("VoucherDesc", accVoucherHeader.getVoucherDesc()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getCreatorID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("YearID", logLogins.getPubUser().getActiveYearID()));
        tParameters.add(new TParameter<>("SerialCode", accVoucherHeader.getSerialCode()));
        tParameters.add(new TParameter<>("DayCode", accVoucherHeader.getDayCode()));
        tParameters.add(new TParameter<>("SecondaryCode", accVoucherHeader.getSecondaryCode()));
        tParameters.add(new TParameter<>("ReferNumber", accVoucherHeader.getReferNumber()));
        tParameters.add(new TParameter<>("ReferDate", accVoucherHeader.getReferDate()));
        tParameters.add(new TParameter<>("VoucherTypeID", accVoucherHeader.getVoucherTypeID()));
        tParameters.add(new TParameter<>("VoucherStatID", accVoucherHeader.getVoucherStatID()));
        tParameters.add(new TParameter<>("IsDeleted", accVoucherHeader.getIsDeleted()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("RefrenceNumber", accVoucherHeader.getRefrenceNumber()));
        tParameters.add(new TParameter<>("IsFromExcel", null));
        tParameters.add(new TParameter<>("IsAutoVch", null));
        tParameters.add(new TParameter<>("VoucherHeaderID", voucherHeaderID));
        tParameters.add(new TParameter<>("RefID", null));
        tParameters.add(new TParameter<>("RowID", accVoucher.getHeader().getRowID()));
        tParameters.add(new TParameter<>("TDel", "TempT2", null));
        tParameters.add(new TParameter<>("TempT2", "TempT2", null));
        tParameters.add(new TParameter<>("TempT3", "TempT3", null));
        tParameters.add(new TParameter<>("TVD", "AccVDTblType", accVDTblTypes));
        ResultErrMsgNewID resultErrMsgNewID = executeStoredProcedureInsUpd(AccVoucher.class, "AccInsVoucherHD",tParameters);
        return accShowVoucher(
                voucherHeaderRepository,
                voucherDetailRepository,
                resultErrMsgNewID.getNewID());
    }


//        List<AccVoucherDetail> accVoucherDetails = accVoucher.getDetails();
//        AccVDTblType[] accVDTblTypes = new AccVDTblType[accVoucherDetails.size()];
//
//        for (int i = 0; i < accVoucherDetails.size(); i++) {
//            AccVDTblType accVDTblType = new AccVDTblType();
//            accVDTblType.setVoucherDetailID(accVoucherDetails.get(i).getVoucherDetailID());
//            accVDTblType.setAccountID(accVoucherDetails.get(i).getAccountID());
//            accVDTblType.setTafsiliID(accVoucherDetails.get(i).getTafsiliID());
//            accVDTblType.setCenter1ID(accVoucherDetails.get(i).getCenter1ID());
//            accVDTblType.setCenter2ID(accVoucherDetails.get(i).getCenter2ID());
//            accVDTblType.setCenter3ID(accVoucherDetails.get(i).getCenter3ID());
//            accVDTblType.setBed(accVoucherDetails.get(i).getBed());
//            accVDTblType.setBes(accVoucherDetails.get(i).getBes());
//            accVDTblType.setDetailXDesc(accVoucherDetails.get(i).getDetailXDesc());
//            accVDTblType.setCurrencyID(accVoucherDetails.get(i).getCurrencyID());
//            accVDTblType.setCurrencyCount(null);
//            accVDTblType.setDocCount(null);
//            accVDTblType.setDocNum(accVoucherDetails.get(i).getDocNum());
//            accVDTblType.setDocDate(accVoucherDetails.get(i).getDocDate());
//            accVDTblType.setRowNo(new BigDecimal(i + 1));
//            accVDTblType.setReferID(null);
//            accVDTblType.setRefTypeID(null);
//            accVDTblTypes[i] = accVDTblType;
//        }
//
//        SQLServerDataRecordTempT2 tDel = new SQLServerDataRecordTempT2(new TempT2[0]);
//        SQLServerDataRecordTempT2 tempT2 = new SQLServerDataRecordTempT2(new TempT2[0]);
//        SQLServerDataRecordTempT3 tempT3 = new SQLServerDataRecordTempT3(new TempT3[0]);
//        SQLServerDataRecordAccVDTblType TVD = new SQLServerDataRecordAccVDTblType(accVDTblTypes);
//
//        LogLogins logLogins = fetchUserDetail();
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter<>("VoucherNumber", accVoucher.getHeader().getVoucherNumber()));
//        tParameters.add(new TParameter("VoucherDate", new TCalendar().getIranianDateBySlashZero()));
//        tParameters.add(new TParameter<>("VoucherDesc", accVoucher.getHeader().getVoucherDesc()));
//        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getCreatorID()));
//        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
//        //todo
//        tParameters.add(new TParameter<>("YearID", logLogins.getPubUser().getActiveYearID()));
//        tParameters.add(new TParameter<>("SerialCode", accVoucher.getHeader().getSerialCode()));
//        tParameters.add(new TParameter<>("DayCode", accVoucher.getHeader().getDayCode()));
//        tParameters.add(new TParameter<>("SecondaryCode", accVoucher.getHeader().getSecondaryCode()));
//        tParameters.add(new TParameter<>("ReferNumber", accVoucher.getHeader().getReferNumber()));
//        tParameters.add(new TParameter<>("ReferDate", accVoucher.getHeader().getReferDate()));
//        tParameters.add(new TParameter<>("VoucherTypeID", accVoucher.getHeader().getVoucherTypeID()));
//        tParameters.add(new TParameter<>("VoucherStatID", accVoucher.getHeader().getVoucherStatID()));
//        tParameters.add(new TParameter<>("IsDeleted", accVoucher.getHeader().getIsDeleted()));
//        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
//        tParameters.add(new TParameter<>("RefrenceNumber", accVoucher.getHeader().getRefrenceNumber()));
////        DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:MM");
////        String arrgregorianDate = formatter.format(new Date());
////        tParameters.add(new TParameter("VoucherDateG", arrgregorianDate));
//        TCalendar tc = new TCalendar();
//        String manualDate = accVoucher.getHeader().getVoucherDate(); //A date that json give us(user entered himself)
//        if (manualDate != null) {
//            tc.setIranianDateBySlash(manualDate);
//            tParameters.add(new TParameter<>("VoucherDate", tc.getIranianDateBySlashZero()));
//            tParameters.add(new TParameter<>("VoucherDateG", tc.getSqlDate()));
//        } else { //Auto dating
//            tParameters.add(new TParameter<>("VoucherDate", tc.getIranianDateBySlashZero()));
//            tParameters.add(new TParameter<>("VoucherDateG", new Date()));
//        }
//        //todo how to initialize
//        tParameters.add(new TParameter<>("IsFromExcel", null));
//        //todo how to initialize
//        tParameters.add(new TParameter<>("IsAutoVch", null));
//        tParameters.add(new TParameter<>("VoucherHeaderID", accVoucher.getHeader().getVoucherHeaderID()));
//        //todo how to initialize
//        tParameters.add(new TParameter<>("RefID", null));
//        //todo how to initialize
//        tParameters.add(new TParameter<>("RowID", accVoucher.getHeader().getRowID()));
//        tParameters.add(new TParameter<>("TDel", "TempT2", tDel));
//        tParameters.add(new TParameter<>("TempT2", "TempT2", tempT2));
//        tParameters.add(new TParameter<>("TempT3", "TempT3", tempT3));
//        tParameters.add(new TParameter<>("TVD", "AccVDTblType", TVD));
//        Map<String, Object> res = executeStoredProcedure(AccVoucher.class, tParameters);
//        BigDecimal result = (BigDecimal) res.get("Result");
//        String errMsg = (String) res.get("ErrMsg");
//        BigDecimal newID = (BigDecimal) res.get("NewID");
//
//        if (result.intValue() == 0) {
//            return accShowVoucher(
//                    voucherHeaderRepository,
//                    voucherDetailRepository,
//                    newID);
//        } else {
//            throw new TConflictException(result.intValue(), errMsg);
//
//        }
//******************************************************************************
//        AccVoucherHeader accVoucherHeader = new AccVoucherHeader();
//        accVoucherHeader.setVoucherHeaderID(voucherHeaderID);
//        List<AccVoucherHeader> voucherHeaderList = voucherHeaderRepository.accShowVoucherHeader(accVoucherHeader);
//        List<AccVoucherDetail> voucherDetailList = voucherDetailRepository.accShowVoucherDetail(voucherHeaderID);
//
//        AccVoucher accVoucher = new AccVoucher();
//        accVoucher.setHeader(voucherHeaderList.get(0));
//        accVoucher.setDetails(voucherDetailList);
//        return accVoucher;
//    }
//
//
//    default AccVoucher accInsVoucher(AccVoucherHeaderRepository voucherHeaderRepository,
//                                     AccVoucherDetailRepository voucherDetailRepository,
//                                     AccVoucher accVoucher) {
//        List<AccVoucherDetail> accVoucherDetails = accVoucher.getDetails();
//        AccVDTblType[] accVDTblTypes = new AccVDTblType[accVoucherDetails.size()];
//
//        for (int i = 0; i < accVoucherDetails.size(); i++) {
//            AccVDTblType accVDTblType = new AccVDTblType();
//            accVDTblType.setVoucherDetailID(accVoucherDetails.get(i).getVoucherDetailID());
//            accVDTblType.setAccountID(accVoucherDetails.get(i).getAccountID());
//            accVDTblType.setTafsiliID(accVoucherDetails.get(i).getTafsiliID());
//            accVDTblType.setCenter1ID(accVoucherDetails.get(i).getCenter1ID());
//            accVDTblType.setCenter2ID(accVoucherDetails.get(i).getCenter2ID());
//            accVDTblType.setCenter3ID(accVoucherDetails.get(i).getCenter3ID());
//            accVDTblType.setBed(accVoucherDetails.get(i).getBed());
//            accVDTblType.setBes(accVoucherDetails.get(i).getBes());
//            accVDTblType.setDetailXDesc(accVoucherDetails.get(i).getDetailXDesc());
//            accVDTblType.setCurrencyID(accVoucherDetails.get(i).getCurrencyID());
//            accVDTblType.setCurrencyCount(null);
//            accVDTblType.setDocCount(null);
//            accVDTblType.setDocNum(accVoucherDetails.get(i).getDocNum());
//            accVDTblType.setDocDate(accVoucherDetails.get(i).getDocDate());
//            accVDTblType.setRowNo(new BigDecimal(i + 1));
//            accVDTblType.setReferID(null);
//            accVDTblType.setRefTypeID(null);
//            accVDTblTypes[i] = accVDTblType;
//        }
//
//        SQLServerDataRecordTempT2 tDel = new SQLServerDataRecordTempT2(new TempT2[0]);
//        SQLServerDataRecordTempT2 tempT2 = new SQLServerDataRecordTempT2(new TempT2[0]);
//        SQLServerDataRecordTempT3 tempT3 = new SQLServerDataRecordTempT3(new TempT3[0]);
//        SQLServerDataRecordAccVDTblType TVD = new SQLServerDataRecordAccVDTblType(accVDTblTypes);
//
//        LogLogins logLogins = fetchUserDetail();
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter<>("VoucherNumber", accVoucher.getHeader().getVoucherNumber()));
//        tParameters.add(new TParameter("VoucherDate", new TCalendar().getIranianDateBySlashZero()));
//        tParameters.add(new TParameter<>("VoucherDesc", accVoucher.getHeader().getVoucherDesc()));
//        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getCreatorID()));
//        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
//        //todo
//        tParameters.add(new TParameter<>("YearID", logLogins.getPubUser().getActiveYearID()));
//        tParameters.add(new TParameter<>("SerialCode", accVoucher.getHeader().getSerialCode()));
//        tParameters.add(new TParameter<>("DayCode", accVoucher.getHeader().getDayCode()));
//        tParameters.add(new TParameter<>("SecondaryCode", accVoucher.getHeader().getSecondaryCode()));
//        tParameters.add(new TParameter<>("ReferNumber", accVoucher.getHeader().getReferNumber()));
//        tParameters.add(new TParameter<>("ReferDate", accVoucher.getHeader().getReferDate()));
//        tParameters.add(new TParameter<>("VoucherTypeID", accVoucher.getHeader().getVoucherTypeID()));
//        tParameters.add(new TParameter<>("VoucherStatID", accVoucher.getHeader().getVoucherStatID()));
//        tParameters.add(new TParameter<>("IsDeleted", accVoucher.getHeader().getIsDeleted()));
//        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
//        tParameters.add(new TParameter<>("RefrenceNumber", accVoucher.getHeader().getRefrenceNumber()));
////        DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:MM");
////        String arrgregorianDate = formatter.format(new Date());
////        tParameters.add(new TParameter("VoucherDateG", arrgregorianDate));
//        TCalendar tc = new TCalendar();
//        String manualDate = accVoucher.getHeader().getVoucherDate(); //A date that json give us(user entered himself)
//        if (manualDate != null) {
//            tc.setIranianDateBySlash(manualDate);
//            tParameters.add(new TParameter<>("VoucherDate", tc.getIranianDateBySlashZero()));
//            tParameters.add(new TParameter<>("VoucherDateG", tc.getSqlDate()));
//        } else { //Auto dating
//            tParameters.add(new TParameter<>("VoucherDate", tc.getIranianDateBySlashZero()));
//            tParameters.add(new TParameter<>("VoucherDateG", new Date()));
//        }
//        //todo how to initialize
//        tParameters.add(new TParameter<>("IsFromExcel", null));
//        //todo how to initialize
//        tParameters.add(new TParameter<>("IsAutoVch", null));
//        tParameters.add(new TParameter<>("VoucherHeaderID", accVoucher.getHeader().getVoucherHeaderID()));
//        //todo how to initialize
//        tParameters.add(new TParameter<>("RefID", null));
//        //todo how to initialize
//        tParameters.add(new TParameter<>("RowID", accVoucher.getHeader().getRowID()));
//        tParameters.add(new TParameter<>("TDel", "TempT2", tDel));
//        tParameters.add(new TParameter<>("TempT2", "TempT2", tempT2));
//        tParameters.add(new TParameter<>("TempT3", "TempT3", tempT3));
//        tParameters.add(new TParameter<>("TVD", "AccVDTblType", TVD));
//
//        HashMap<String, Object> res = execute1("AccInsVoucherHD", tParameters);
//        BigDecimal result = (BigDecimal) res.get("Result");
//        String errMsg = (String) res.get("ErrMsg");
//        BigDecimal newID = (BigDecimal) res.get("NewID");
//
//        if (result.intValue() == 0) {
//            return accShowVoucher(
//                    voucherHeaderRepository,
//                    voucherDetailRepository,
//                    newID);
//        } else {
//            throw new TConflictException(result.intValue(), errMsg);
//
//        }

    // TODO: 10/30/21  accUpdVoucher
//    default AccVoucher accUpdVoucher(AccVoucherHeaderRepository voucherHeaderRepository,
//                                     AccVoucherDetailRepository voucherDetailRepository,
//                                     AccVoucher accVoucher,
//                                     BigDecimal voucherHeaderID) {
//        List<AccVoucherDetail> accVoucherDetails = accVoucher.getDetails();
//        AccVDTblType[] accVDTblTypes = new AccVDTblType[accVoucherDetails.size()];
//
//        for (int i = 0; i < accVoucherDetails.size(); i++) {
//            AccVDTblType accVDTblType = new AccVDTblType();
//            accVDTblType.setVoucherDetailID(accVoucherDetails.get(i).getVoucherDetailID());
//            accVDTblType.setAccountID(accVoucherDetails.get(i).getAccountID());
//            accVDTblType.setTafsiliID(accVoucherDetails.get(i).getTafsiliID());
//            accVDTblType.setCenter1ID(accVoucherDetails.get(i).getCenter1ID());
//            accVDTblType.setCenter2ID(accVoucherDetails.get(i).getCenter2ID());
//            accVDTblType.setCenter3ID(accVoucherDetails.get(i).getCenter3ID());
//            accVDTblType.setBed(accVoucherDetails.get(i).getBed());
//            accVDTblType.setBes(accVoucherDetails.get(i).getBes());
//            accVDTblType.setDetailXDesc(accVoucherDetails.get(i).getDetailXDesc());
//            accVDTblType.setCurrencyID(accVoucherDetails.get(i).getCurrencyID());
//            accVDTblType.setCurrencyCount(null);
//            accVDTblType.setDocCount(null);
//            accVDTblType.setDocNum(accVoucherDetails.get(i).getDocNum());
//            accVDTblType.setDocDate(accVoucherDetails.get(i).getDocDate());
//            accVDTblType.setRowNo(new BigDecimal(i + 1));
//            accVDTblType.setReferID(null);
//            accVDTblType.setRefTypeID(null);
//            accVDTblTypes[i] = accVDTblType;
//        }
////******************************************************
//        //دیتیل هایی که در دیتابیس هست ولی در بادی وب سرویس نیست
//        //این دیتیل ها باید داخل تی دل قرار گیرند
//
//        //دیتیل های فعلی را از دیتابیس می گیریم
//        ArrayList<TempT2> tempT2s = new ArrayList<>();
//        List<AccVoucherDetail> voucherDetailList = voucherDetailRepository.accShowVoucherDetail(voucherHeaderID);
//        for (int i = 0; i < voucherDetailList.size(); i++) {
//            AccVoucherDetail accVoucherDetail = voucherDetailList.get(i);
//            List<AccVoucherDetail> accVoucherDetails1 = accVoucherDetails.stream()
//                    .filter(item -> {
//                        if (item.getVoucherDetailID() != null) {
//                            return item.getVoucherDetailID().intValue() == accVoucherDetail.getVoucherDetailID().intValue();
//                        }
//                        return false;
//                    })
//                    .collect(Collectors.toList());
//            if (accVoucherDetails1.isEmpty()) {
//                // یعنی این دیتیل در ویرایش فعلی حذف شده است و باید داخل تی دل قرار گیرد
//                TempT2 tempT2 = new TempT2();
//                tempT2.setmID(accVoucherDetail.getVoucherDetailID());
//                tempT2s.add(tempT2);
//            }
//        }
//
//        TempT2[] tempT2Dels = new TempT2[tempT2s.size()];
//        tempT2Dels = tempT2s.toArray(tempT2Dels);
//
//        SQLServerDataRecordTempT2 tDel = new SQLServerDataRecordTempT2(tempT2Dels);
//        SQLServerDataRecordTempT2 tempT2 = new SQLServerDataRecordTempT2(new TempT2[0]);
//        SQLServerDataRecordTempT3 tempT3 = new SQLServerDataRecordTempT3(new TempT3[0]);
//        SQLServerDataRecordAccVDTblType TVD = new SQLServerDataRecordAccVDTblType(accVDTblTypes);
//
//        LogLogins logLogins = fetchUserDetail();
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter<>("VoucherNumber", accVoucher.getHeader().getVoucherNumber()));
//        tParameters.add(new TParameter("VoucherDate", new TCalendar().getIranianDateBySlashZero()));
//        tParameters.add(new TParameter<>("VoucherDesc", accVoucher.getHeader().getVoucherDesc()));
//        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getCreatorID()));
//        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
//        //todo
//        tParameters.add(new TParameter<>("YearID", logLogins.getPubUser().getActiveYearID()));
//        tParameters.add(new TParameter<>("SerialCode", accVoucher.getHeader().getSerialCode()));
//        tParameters.add(new TParameter<>("DayCode", accVoucher.getHeader().getDayCode()));
//        tParameters.add(new TParameter<>("SecondaryCode", accVoucher.getHeader().getSecondaryCode()));
//        tParameters.add(new TParameter<>("ReferNumber", accVoucher.getHeader().getReferNumber()));
//        tParameters.add(new TParameter<>("ReferDate", accVoucher.getHeader().getReferDate()));
//        tParameters.add(new TParameter<>("VoucherTypeID", accVoucher.getHeader().getVoucherTypeID()));
//        tParameters.add(new TParameter<>("VoucherStatID", accVoucher.getHeader().getVoucherStatID()));
//        tParameters.add(new TParameter<>("IsDeleted", accVoucher.getHeader().getIsDeleted()));
//        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
//        tParameters.add(new TParameter<>("RefrenceNumber", accVoucher.getHeader().getRefrenceNumber()));
////        DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:MM");
////        String arrgregorianDate = formatter.format(new Date());
////        tParameters.add(new TParameter("VoucherDateG", arrgregorianDate));
//        TCalendar tc = new TCalendar();
//        String manualDate = accVoucher.getHeader().getVoucherDate(); //A date that json give us(user entered himself)
//        if (manualDate != null) {
//            tc.setIranianDateBySlash(manualDate);
//            tParameters.add(new TParameter<>("VoucherDate", tc.getIranianDateBySlashZero()));
//            tParameters.add(new TParameter<>("VoucherDateG", tc.getSqlDate()));
//        } else { //Auto dating
//            tParameters.add(new TParameter<>("VoucherDate", tc.getIranianDateBySlashZero()));
//            tParameters.add(new TParameter<>("VoucherDateG", new Date()));
//        }
//        //todo how to initialize
//        tParameters.add(new TParameter<>("IsFromExcel", null));
//        //todo how to initialize
//        tParameters.add(new TParameter<>("IsAutoVch", null));
//        tParameters.add(new TParameter<>("VoucherHeaderID", voucherHeaderID));// this means update in AccInsVoucherHD
//        //todo how to initialize
//        tParameters.add(new TParameter<>("RefID", null));
//        //todo how to initialize
//        tParameters.add(new TParameter<>("RowID", accVoucher.getHeader().getRowID()));
//        tParameters.add(new TParameter<>("TDel", "TempT2", tDel));
//        tParameters.add(new TParameter<>("TempT2", "TempT2", tempT2));
//        tParameters.add(new TParameter<>("TempT3", "TempT3", tempT3));
//        tParameters.add(new TParameter<>("TVD", "AccVDTblType", TVD));
//
//        HashMap<String, Object> res = execute1("AccInsVoucherHD", tParameters);
//        BigDecimal result = (BigDecimal) res.get("Result");
//        String errMsg = (String) res.get("ErrMsg");
//        BigDecimal newID = (BigDecimal) res.get("NewID");
//
//        if (result.intValue() == 0) {
//            return accShowVoucher(
//                    voucherHeaderRepository,
//                    voucherDetailRepository,
//                    newID);
//        } else {
//            throw new TConflictException(result.intValue(), errMsg);
//
//        }
//    }

    default void accDelVoucher(BigDecimal voucherHeaderID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("VoucherHeaderID", voucherHeaderID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("SystemID", logLogins.getSystemId()));
        delSP("AccDelVoucherHeader", tParameters);
    }

}
