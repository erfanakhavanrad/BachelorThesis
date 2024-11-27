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
        ResultErrMsgNewID resultErrMsgNewID = execSPNativeQuery(AccVoucher.class, "AccInsVoucherHD", tParameters);
        return accShowVoucher(
                voucherHeaderRepository,
                voucherDetailRepository,
                resultErrMsgNewID.getNewID());
    }

    default void accDelVoucher(BigDecimal voucherHeaderID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("VoucherHeaderID", voucherHeaderID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("SystemID", logLogins.getSystemId()));
        delSP("AccDelVoucherHeader", tParameters);
    }

}
