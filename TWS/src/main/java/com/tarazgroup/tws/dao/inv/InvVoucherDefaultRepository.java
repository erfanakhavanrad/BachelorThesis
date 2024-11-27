package com.tarazgroup.tws.dao.inv;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.inv.InvVoucherDefault;
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
public interface InvVoucherDefaultRepository extends TCrudRepository<InvVoucherDefault>, CrudRepository<InvVoucherDefault, BigDecimal> {

    default List<InvVoucherDefault> invShowVoucherDefault(InvVoucherDefault invVoucherDefault) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", invVoucherDefault._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", invVoucherDefault._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", invVoucherDefault._pageFilter()));
        return showSP("InvShowVoucherDefault", tParameters, true);
    }

    default InvVoucherDefault invInsVoucherDefault(InvVoucherDefault invVoucherDefault) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("UserID", invVoucherDefault.getUserID()));
        tParameters.add(new TParameter<>("VoucherTypeID", invVoucherDefault.getVoucherTypeID()));
        tParameters.add(new TParameter<>("RefTypeID", invVoucherDefault.getRefTypeID()));
        tParameters.add(new TParameter<>("AccountID", invVoucherDefault.getAccountID()));
        tParameters.add(new TParameter<>("StoreID", invVoucherDefault.getStoreID()));
        tParameters.add(new TParameter<>("TafsiliID", invVoucherDefault.getTafsiliID()));
        tParameters.add(new TParameter<>("Center1ID", invVoucherDefault.getCenter1ID()));
        tParameters.add(new TParameter<>("Center2ID", invVoucherDefault.getCenter2ID()));
        tParameters.add(new TParameter<>("Center3ID", invVoucherDefault.getCenter3ID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getCreatorID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ImportExport", invVoucherDefault.getImportExport()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("IsLevelVoucherDefault", invVoucherDefault.getIsLevelVoucherDefault()));
        BigDecimal newID = insSP("InvInsVoucherDefault", tParameters);
        InvVoucherDefault temp = new InvVoucherDefault();
        temp.setVoucherDefaultID(newID);
        return invShowVoucherDefault(temp).get(0);
    }

    default void invDelVoucherDefault(BigDecimal voucherDefaultID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("VoucherDefaultID", voucherDefaultID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("InvDelVoucherDefault", tParameters);
    }

    default InvVoucherDefault invUpdVoucherDefault(BigDecimal voucherDefaultID, InvVoucherDefault invVoucherDefault) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("VoucherDefaultID", voucherDefaultID));
        tParameters.add(new TParameter<>("UserID", invVoucherDefault.getUserID()));
        tParameters.add(new TParameter<>("VoucherTypeID", invVoucherDefault.getVoucherTypeID()));
        tParameters.add(new TParameter<>("RefTypeID", invVoucherDefault.getRefTypeID()));
        tParameters.add(new TParameter<>("AccountID", invVoucherDefault.getAccountID()));
        tParameters.add(new TParameter<>("StoreID", invVoucherDefault.getStoreID()));
        tParameters.add(new TParameter<>("TafsiliID", invVoucherDefault.getTafsiliID()));
        tParameters.add(new TParameter<>("Center1ID", invVoucherDefault.getCenter1ID()));
        tParameters.add(new TParameter<>("Center2ID", invVoucherDefault.getCenter2ID()));
        tParameters.add(new TParameter<>("Center3ID", invVoucherDefault.getCenter3ID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ImportExport", invVoucherDefault.getImportExport()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("IsLevelVoucherDefault", invVoucherDefault.getIsLevelVoucherDefault()));
        updSP("InvUpdVoucherDefault", tParameters);
        InvVoucherDefault temp = new InvVoucherDefault();
        temp.setVoucherDefaultID(voucherDefaultID);
        return invShowVoucherDefault(temp).get(0);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null,"voucherDefaultID", "voucherDefaultID", Type.DECIMAL, 0, false, false,  true));
        cols.add(new Col(null,"userLoginName", "نام کاربری", Type.STRING, 60, true, true,  false));
        cols.add(new Col(null,"voucherTypeDesc", "نوع سند", Type.STRING, 60, true, true,  false));
        cols.add(new Col(null,"refTypeDesc", "نوع مرجع ", Type.STRING, 60, true, true,  false));
        cols.add(new Col(null,"importExportDesc", "ماهیت سند ", Type.STRING, 65, true, true,  false));
        cols.add(new Col(null,"storeCode", "انبار|کد", Type.STRING, 60, true, true,  false));
        cols.add(new Col(null,"storeName", "انبار|شرح", Type.STRING, 149, true, true,  false));
        cols.add(new Col(null,"tafsilicode", "تفصیلی|کد", Type.STRING, 65, true, true,  false));
        cols.add(new Col(null,"tafsiliDesc", "تفصیلی|شرح", Type.STRING, 115, true, true,  false));
        cols.add(new Col(null,"accountCode", "معین بدهکار/بستانکار|کد", Type.STRING, 60, true, true,  false));
        cols.add(new Col(null,"accountDesc", "معین بدهکار/بستانکار|شرح", Type.STRING, 162, true, true,  false));
        cols.add(new Col(null,"center1Code", "سطح 5|کد", Type.STRING, 60, true, true,  false));
        cols.add(new Col(null,"center1Desc", "سطح 5|شرح", Type.STRING, 147, true, true,  false));
        cols.add(new Col(null,"center2Code", "سطح 6|کد", Type.STRING, 60, true, true,  false));
        cols.add(new Col(null,"center2Desc", "سطح 6|شرح", Type.STRING, 135, true, true,  false));
        cols.add(new Col(null,"center3Code", "سطح 7|کد", Type.STRING, 60, true, true,  false));
        cols.add(new Col(null,"center3Desc", "سطح 7|شرح", Type.STRING, 175, true, true,  false));
        cols.add(new Col(null,"isLevelVoucherDefault", "اولویت ثبت با اطلاعات پیش فرض اسناد", Type.BOOLEAN, 50, true, true,  false));
        cols.add(new Col(null,"voucherDefaultID", "voucherDefaultID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"userID", "userID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"voucherTypeID", "voucherTypeID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"refTypeID", "refTypeID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"accountID", "accountID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"storeID", "storeID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"tafsiliID", "tafsiliID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"center2ID", "center2ID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"center3ID", "center3ID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"createDate", "createDate", Type.DATE, 0, false, false,  false));
        cols.add(new Col(null,"modifyDate", "modifyDate", Type.DATE, 0, false, false,  false));
        cols.add(new Col(null,"creatorID", "creatorID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"modifierID", "modifierID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"serverID", "serverID", Type.DECIMAL, 0, false, false,  false));

        return new Meta(cols);
    }

}
