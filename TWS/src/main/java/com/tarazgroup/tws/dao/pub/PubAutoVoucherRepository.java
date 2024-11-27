package com.tarazgroup.tws.dao.pub;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.pub.PubAutoVoucher;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Erfan Akhavan
 */
public interface PubAutoVoucherRepository extends TCrudRepository<PubAutoVoucher>, CrudRepository<PubAutoVoucher, BigDecimal> {

    default List<PubAutoVoucher> pubShowAutoVouchers(PubAutoVoucher pubAutoVoucher) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", pubAutoVoucher._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", pubAutoVoucher._serverFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", pubAutoVoucher._pageFilter()));
        return showSP("PubShowAutoVoucher", tParameters, true);
    }

    default PubAutoVoucher pubShowAutoVoucherByID(BigDecimal voucherTypeID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", " AND VoucherTypeID= " + voucherTypeID + "?,?"));
        return showSP("PubShowAutoVoucher", tParameters, true).get(0);
    }

    default PubAutoVoucher pubInsAutoVoucher(PubAutoVoucher pubAutoVoucher) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("IsAutoVoucher", pubAutoVoucher.getIsAutoVoucher()));
        tParameters.add(new TParameter<>("IsAutoDelVoucher", pubAutoVoucher.getIsAutoDelVoucher()));
        tParameters.add(new TParameter<>("IsAutoControlVoucher", pubAutoVoucher.getIsAutoControlVoucher()));
        tParameters.add(new TParameter<>("IsViewVoucher", pubAutoVoucher.getIsViewVoucher()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("PubInsAutoVoucher", tParameters);
        return pubShowAutoVoucherByID(newID);
    }

    // TODO: 11/9/21 Upd method doesn't work. Checked in sp by Admin and Sp was ok. Must be asked from CEO. 
    default PubAutoVoucher pubUpdAutoVoucher(PubAutoVoucher pubAutoVoucher, BigDecimal voucherTypeID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("VoucherTypeID", voucherTypeID));
        tParameters.add(new TParameter<>("IsAutoVoucher", pubAutoVoucher.getIsAutoVoucher()));
        tParameters.add(new TParameter<>("IsAutoDelVoucher", pubAutoVoucher.getIsAutoDelVoucher()));
        tParameters.add(new TParameter<>("IsAutoControlVoucher", pubAutoVoucher.getIsAutoControlVoucher()));
        tParameters.add(new TParameter<>("IsViewVoucher", pubAutoVoucher.getIsViewVoucher()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("PubUpdAutoVoucher", tParameters);
        return pubShowAutoVoucherByID(voucherTypeID);
    }

    default void pubDelAutoVoucher(BigDecimal voucherTypeID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("UserID", voucherTypeID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("PubDelAutoVoucher", tParameters);
    }


    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "voucherTypeID", "", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "customVTypeDesc", "", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "isAutoVoucher", "", Type.BOOLEAN, 100, true, true, false));
        cols.add(new Col(null, "isAutoDelVoucher", "", Type.BOOLEAN, 100, true, true, false));
        cols.add(new Col(null, "isAutoControlVoucher", "", Type.BOOLEAN, 100, true, true, false));
        cols.add(new Col(null, "systemFName", "", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "isViewVoucher", "", Type.BOOLEAN, 100, true, true, false));
        return new Meta(cols);
    }


}
