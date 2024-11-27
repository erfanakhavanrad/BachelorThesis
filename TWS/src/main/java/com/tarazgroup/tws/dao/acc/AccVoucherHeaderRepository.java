package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccVoucherHeader;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
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
public interface AccVoucherHeaderRepository extends TCrudRepository<AccVoucherHeader>, CrudRepository<AccVoucherHeader, BigDecimal> {

    default List<AccVoucherHeader> accShowVoucherHeader(AccVoucherHeader accVoucherHeader) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("GeneralFilter", null));
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", accVoucherHeader._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", accVoucherHeader._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("ServerDBName", null));
        tParameters.add(new TParameter<>("PageFilter", accVoucherHeader._pageFilter()));
        return showSP("AccShowVoucherHeader", tParameters, true);
    }

    default AccVoucherHeader accShowVoucherHeaderByID(BigDecimal voucherHeaderID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("GeneralFilter", null));
        tParameters.add(new TParameter<>("Filter", " AND main.VoucherHeaderID=" + voucherHeaderID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("ServerDBName", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("AccShowVoucherHeader", tParameters, true).get(0);
    }


    default void accDeletedVoucherHeader(BigDecimal voucherHeaderID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("VoucherHeaderID", voucherHeaderID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("AccDeletedVoucherHeader", tParameters);
    }

    default void accRestoreVoucherHeader(BigDecimal voucherHeaderID, BigDecimal yearID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("VoucherHeaderID", voucherHeaderID));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("YearID", yearID));
        updSP("AccRestoreVoucherHeader", tParameters);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "voucherHeaderID", "voucherHeaderID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "voucherNumber", "شماره سند", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "voucherDate", "تاریخ سند|شمسی", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "voucherDateG", "تاریخ سند|میلادی", Type.DATE, 100, true, true, false));
        cols.add(new Col(null, "voucherTime", "voucherTime", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "voucherDesc", "توضیحات سند", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "createDateStr", "تاریخ تنظیم", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "creatorName", "creatorName", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "modifyDateStr", "تاریخ ویرایش", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "yearID", "yearID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "serialCode", "شماره ثبت|شماره", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "dayCode", "شماره روز", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "secondaryCode", "شماره فرعی", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "referNumber", "شماره عطف", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "referDate", "تاریخ عطف", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "voucherStatID", "voucherStatID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "voucherStatDesc", "وضعیت سند", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "isDeleted", "حذف شده", Type.BOOLEAN, 50, true, true, false));
        cols.add(new Col(null, "refrenceNumber", "شماره ارجاع", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "combineVoucherID", "combineVoucherID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "isTransfered", "isTransfered", Type.BOOLEAN, 0, false, false, false));
        cols.add(new Col(null, "vStatID", "vStatID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "controllerName", "آخرین کنترل کننده", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "reciverName", "reciverName", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "voucherTypeDesc", "نوع سند", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "serverDesc", "محل صدور", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "sumVoucher", "جمع سند", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "bedBesStat", "bedBesStat", Type.INTEGER, 0, false, false, false));
        cols.add(new Col(null, "modifierName", "ویرایش کننده", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "combineNumber", "combineNumber", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "customVNo", "تجمیع اسناد|شماره سند", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "customVDate", "تجمیع اسناد|تاریخ سند", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "customSNo", "تجمیع اسناد|شماره ثبت", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "voucherTypeID", "voucherTypeID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "rowID", "rowID", Type.STRING, 0, false, false, false));
        return new Meta(cols);
    }
}
