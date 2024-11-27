package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.sale.SalePercentDetail;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Salehi
 */
public interface SalePercentDetailRepository extends TCrudRepository<SalePercentDetail>, CrudRepository<SalePercentDetail, BigDecimal> {


    default List<SalePercentDetail> saleShowPercentDetail(SalePercentDetail salePercentDetail) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", salePercentDetail._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", salePercentDetail._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        // TODO در این اس پی باید پیج فیلتر اضافه شود
        //
        return showSP("SaleShowPercentDetail", tParameters, true);
    }


    default SalePercentDetail saleShowPercentDetailByID(BigDecimal voucherDetailID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        tParameters.add(new TParameter<>("Filter", "And Det.VoucherDetailID =" + voucherDetailID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        //
        return showSP("SaleShowPercentDetail", tParameters, true).get(0);
    }


    default SalePercentDetail saleInsPercentDetail(SalePercentDetail salePercentDetail) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        LogLogins logLogins = fetchUserDetail();
        //
        tParameters.add(new TParameter<>("VoucherHeaderID", salePercentDetail.getVoucherHeaderID()));
        tParameters.add(new TParameter<>("Amount", salePercentDetail.getAmount()));
        tParameters.add(new TParameter<>("FromNum", salePercentDetail.getFromNum()));
        tParameters.add(new TParameter<>("ToNum", salePercentDetail.getToNum()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        //
        BigDecimal newID = insSP("SaleInsPercentDetail", tParameters);
        //

        return saleShowPercentDetailByID(newID);
    }


    default SalePercentDetail saleUpdPercentDetail(BigDecimal voucherDetailID, SalePercentDetail salePercentDetail) {
        LogLogins logLogins = fetchUserDetail();
        //
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        tParameters.add(new TParameter<>("VoucherDetailID", voucherDetailID));
        tParameters.add(new TParameter<>("Amount", salePercentDetail.getAmount()));
        tParameters.add(new TParameter<>("FromNum", salePercentDetail.getFromNum()));
        tParameters.add(new TParameter<>("ToNum", salePercentDetail.getToNum()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        //
        updSP("SaleUpdPercentDetail", tParameters);
        //
        return saleShowPercentDetailByID(voucherDetailID);
    }

    default void saleDelPercentDetail(BigDecimal voucherDetailID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("VoucherDetailID", voucherDetailID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("SaleDelPercentDetail", tParameters);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        //
        cols.add(new Col(null, "voucherDetailID", "voucherDetailID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "voucherHeaderID", "voucherHeaderID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "amount", "مقدار", Type.DECIMAL, 130, true, true, false));
        cols.add(new Col(null, "fromNum", "از", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "toNum", "تا", Type.DECIMAL, 120, true, true, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 100, false, false, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 120, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 100, false, false, false));
        //
        return new Meta(cols);
    }
}
