package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccVoucherDetail;
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
public interface AccVoucherDetailRepository extends TCrudRepository<AccVoucherDetail>, CrudRepository<AccVoucherDetail, BigDecimal> {

    default List<AccVoucherDetail> accShowVoucherDetail(BigDecimal voucherHeaderID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND  Det.VoucherHeaderID = " + voucherHeaderID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("AccShowVoucherDetail", tParameters, true);
    }

    default void accRestoreVoucherDetail(BigDecimal voucherHeaderID, BigDecimal voucherDetailID, BigDecimal yearID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("VoucherHeaderID", voucherHeaderID));
        tParameters.add(new TParameter<>("VoucherDetailID", voucherDetailID));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("YearID", yearID));
        updSP("AccRestoreVoucherDetail", tParameters);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null,"voucherDetailID", "voucherDetailID", Type.DECIMAL, 0, false, false,  true));
        cols.add(new Col(null,"besStat", "besStat", Type.INTEGER, 0, false, true,  false));
        cols.add(new Col(null,"bedStat", "bedStat", Type.INTEGER, 0, false, true,  false));
        cols.add(new Col(null,"voucherHeaderID", "voucherHeaderID", Type.DECIMAL, 0, false, true,  false));
        cols.add(new Col(null,"accountID", "accountID", Type.DECIMAL, 0, false, true,  false));
        cols.add(new Col(null,"tafsiliID", "tafsiliID", Type.DECIMAL, 0, false, true,  false));
        cols.add(new Col(null,"center1ID", "center1ID", Type.DECIMAL, 0, false, true,  false));
        cols.add(new Col(null,"center2ID", "center2ID", Type.DECIMAL, 0, false, true,  false));
        cols.add(new Col(null,"center3ID", "center3ID", Type.DECIMAL, 0, false, true,  false));
        cols.add(new Col(null,"bed", "بدهکار", Type.DECIMAL, 100, true, true,  false));
        cols.add(new Col(null,"bes", "بستانکار", Type.DECIMAL, 100, true, true,  false));
        cols.add(new Col(null,"detailXDesc", "شرح ردیف", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"serverID", "serverID", Type.DECIMAL, 0, false, true,  false));
        cols.add(new Col(null,"createDate", "createDate", Type.DATE, 0, false, true,  false));
        cols.add(new Col(null,"creatorID", "creatorID", Type.DECIMAL, 0, false, true,  false));
        cols.add(new Col(null,"modifyDate", "modifyDate", Type.DATE, 0, false, true,  false));
        cols.add(new Col(null,"modifierID", "modifierID", Type.DECIMAL, 0, false, true,  false));
        cols.add(new Col(null,"currencyID", "currencyID", Type.DECIMAL, 0, false, true,  false));
        cols.add(new Col(null,"currencyCount", "تعداد ارز", Type.STRING, 0, false, true,  false));
        cols.add(new Col(null,"docNum", "شماره اسناد", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"docDate", "تاریخ اسناد", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"rowNo", "ردیف", Type.DECIMAL, 100, true, true,  false));
        cols.add(new Col(null,"isDeleted", "isDeleted", Type.BOOLEAN, 50, true, true,  false));
        cols.add(new Col(null,"tafsilicode", "تفصیلی", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"center1Code", "سطح 5", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"center2Code", "سطح 6", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"center3Code", "سطح 7", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"tafsiliDesc", "tafsiliDesc", Type.STRING, 0, false, true,  false));
        cols.add(new Col(null,"center1Desc", "center1Desc", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"center2Desc", "center2Desc", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"center3Desc", "center3Desc", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"accountCode", "معین", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"accountDesc", "معین|شرح", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"isDocCount", "isDocCount", Type.BOOLEAN, 0, false, true,  false));
        cols.add(new Col(null,"isCurrency", "isCurrency", Type.BOOLEAN, 0, false, true,  false));
        cols.add(new Col(null,"trace", "trace", Type.BOOLEAN, 0, false, true,  false));
        cols.add(new Col(null,"isError", "isError", Type.BOOLEAN, 0, false, true,  false));
        cols.add(new Col(null,"isWarning", "isWarning", Type.BOOLEAN, 0, false, true,  false));
        cols.add(new Col(null,"accountNature", "accountNature", Type.STRING, 0, false, true,  false));
        cols.add(new Col(null,"ColID", "ColID", Type.DECIMAL, 0, false, true,  false));
        cols.add(new Col(null,"colCode", "کل|کد", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"colDesc", "کل|شرح", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"groupsCode", "گروه|کد", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"groupsDesc", "گروه|شرح", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"currencyName", "نوع ارز", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"tafsiliTypeStr", "tafsiliTypeStr", Type.STRING, 0, false, true,  false));
        cols.add(new Col(null,"center1TypeStr", "center1TypeStr", Type.STRING, 0, false, true,  false));
        cols.add(new Col(null,"center2TypeStr", "center2TypeStr", Type.STRING, 0, false, true,  false));
        cols.add(new Col(null,"center3TypeStr", "center3TypeStr", Type.STRING, 0, false, true,  false));
        cols.add(new Col(null,"accountXDesc", "accountXDesc", Type.STRING, 0, false, true,  false));
        cols.add(new Col(null,"refTypeDesc", "سیستم ارسال کننده", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"referID", "referID", Type.DECIMAL, 0, false, true,  false));
        cols.add(new Col(null,"otherLevels", "otherLevels", Type.STRING, 0, false, true,  false));
        cols.add(new Col(null,"refTypeID", "refTypeID", Type.DECIMAL, 0, false, true,  false));
        cols.add(new Col(null,"voucherNumber", "voucherNumber", Type.STRING, 0, false, true,  false));
        cols.add(new Col(null,"voucherDate", "voucherDate", Type.STRING, 0, false, true,  false));
        return new Meta(cols);
    }
}
