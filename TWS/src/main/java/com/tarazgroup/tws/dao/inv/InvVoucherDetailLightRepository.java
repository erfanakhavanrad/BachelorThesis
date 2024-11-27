package com.tarazgroup.tws.dao.inv;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.inv.InvVoucherDetailLight;
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
public interface InvVoucherDetailLightRepository extends TCrudRepository<InvVoucherDetailLight>, CrudRepository<InvVoucherDetailLight, BigDecimal> {
    default List<InvVoucherDetailLight> invShowVoucherDetailLights(InvVoucherDetailLight invVoucherDetailLight) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("VoucherHeaderID", null));
        tParameters.add(new TParameter<>("DReferID", null));
        tParameters.add(new TParameter<>("IsPricing", null));
        tParameters.add(new TParameter<>("PageFilter", invVoucherDetailLight._pageFilter()));
        return showSP("InvShowVoucherDetail_Light", tParameters, true);
    }

    //    GET BY ID
    default InvVoucherDetailLight invShowVoucherDetailLightByID(BigDecimal voucherHeaderID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("VoucherHeaderID", " And main.voucherHeaderID=" + voucherHeaderID));
        tParameters.add(new TParameter<>("DReferID", null));
        tParameters.add(new TParameter<>("IsPricing", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("InvShowVoucherDetail_Light", tParameters, true).get(0);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "voucherHeaderID", "voucherHeaderID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "voucherDetailID", "voucherDetailID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "secUnitID", "secUnitID", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "quantity", "تعداد", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "fee", "هزینه", Type.INTEGER, 100, true, true, false));
        cols.add(new Col(null, "feeTest", "هزینه تست", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "rowPri", "ردیف", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "rowPriceOLD", "قیمت قدیم", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "detailXDesc", "شرح توضیحات", Type.INTEGER, 100, true, true, false));
        cols.add(new Col(null, "dReferID", "dReferID", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.STRING, 0, false, false, false));
        return new Meta(cols);
    }

}
