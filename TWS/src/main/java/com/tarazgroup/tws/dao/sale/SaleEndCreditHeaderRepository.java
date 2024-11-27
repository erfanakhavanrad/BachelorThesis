package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.sale.SaleEndCreditHeader;
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
public interface SaleEndCreditHeaderRepository extends TCrudRepository<SaleEndCreditHeader>, CrudRepository<SaleEndCreditHeader, BigDecimal> {

    default List<SaleEndCreditHeader> saleShowEndCreditHeader(SaleEndCreditHeader saleEndCreditHeader) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", saleEndCreditHeader._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", saleEndCreditHeader._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        // TODO در این اس پی باید پیج فیلتر اضافه شود
        //
        return showSP("SaleShowEndCreditHeader", tParameters, true);
    }

    default SaleEndCreditHeader saleShowEndCreditHeaderByID(BigDecimal voucherHeaderID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        tParameters.add(new TParameter<>("Filter", "And Main.VoucherHeaderID=" + voucherHeaderID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        //
        return showSP("SaleShowEndCreditHeader", tParameters, true).get(0);
    }

    default SaleEndCreditHeader saleInsEndCreditHeader(SaleEndCreditHeader saleEndCreditHeader) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        LogLogins logLogins = fetchUserDetail();
        //
        tParameters.add(new TParameter<>("VoucherNumber", saleEndCreditHeader.getVoucherNumber()));
        tParameters.add(new TParameter<>("VoucherDate", saleEndCreditHeader.getVoucherDate()));
        tParameters.add(new TParameter<>("VoucherDesc", saleEndCreditHeader.getVoucherDesc()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getCreatorID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("YearID", saleEndCreditHeader.getYearID()));
        //
        BigDecimal newID = insSP("SaleInsEndCreditHeader", tParameters);
        //
        return saleShowEndCreditHeaderByID(newID);
    }

    default SaleEndCreditHeader saleUpdEndCreditHeader(BigDecimal voucherHeaderID, SaleEndCreditHeader saleEndCreditHeader) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        LogLogins logLogins = fetchUserDetail();
        //
        tParameters.add(new TParameter<>("VoucherHeaderID", voucherHeaderID));
        tParameters.add(new TParameter<>("VoucherNumber", saleEndCreditHeader.getVoucherNumber()));
        tParameters.add(new TParameter<>("VoucherDate", saleEndCreditHeader.getVoucherDate()));
        tParameters.add(new TParameter<>("VoucherDesc", saleEndCreditHeader.getVoucherDesc()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        //
        updSP("SaleUpdEndCreditHeader", tParameters);
        //
        return saleShowEndCreditHeaderByID(voucherHeaderID);
    }

    default void saleDelEndCreditHeader(BigDecimal voucherHeaderID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        LogLogins logLogins = fetchUserDetail();
        //
        tParameters.add(new TParameter<>("VoucherHeaderID", voucherHeaderID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        //
        delSP("SaleDelEndCreditHeader", tParameters);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "voucherHeaderID", "voucherHeaderID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "voucherNumber", "شماره سند", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "voucherDate", "تاریخ سند", Type.STRING, 130, true, true, false));
        cols.add(new Col(null, "voucherDesc", "توضیحات", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 120, false, true, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 100, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 120, false, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "yearID", "yearID", Type.DECIMAL, 100, false, false, false));
        return new Meta(cols);
    }
}
