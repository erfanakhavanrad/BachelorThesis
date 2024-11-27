package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.sale.SaleNoPurchase;
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
public interface SaleNoPurchaseRepository extends TCrudRepository<SaleNoPurchase>, CrudRepository<SaleNoPurchase, BigDecimal> {

    default List<SaleNoPurchase> saleShowNoPurchase(SaleNoPurchase saleNoPurchase) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", saleNoPurchase._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", saleNoPurchase._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        //
        return showSP("SaleShowNoPurchase", tParameters, true);
    }

    default SaleNoPurchase saleShowNoPurchaseByID(BigDecimal noPurchaseID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        tParameters.add(new TParameter<>("Filter", "And Main.NoPurchaseID =" + noPurchaseID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        // TODO در این اس پی پیج فیلتر وجود نداشت
        //
        return showSP("SaleShowNoPurchase", tParameters, true).get(0);
    }

    default SaleNoPurchase saleInsNoPurchase(SaleNoPurchase saleNoPurchase) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        LogLogins logLogins = fetchUserDetail();
        //
        tParameters.add(new TParameter<>("NoPurchaseCode", saleNoPurchase.getNoPurchaseCode()));
        tParameters.add(new TParameter<>("NoPurchaseDesc", saleNoPurchase.getNoPurchaseDesc()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        //
        BigDecimal newID = insSP("SaleInsNoPurchase", tParameters);
        return saleShowNoPurchaseByID(newID);
    }

    default SaleNoPurchase saleUpdNoPurchase(BigDecimal noPurchaseID, SaleNoPurchase saleNoPurchase) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        LogLogins logLogins = fetchUserDetail();
        //
        tParameters.add(new TParameter<>("NoPurchaseID", noPurchaseID));
        tParameters.add(new TParameter<>("NoPurchaseCode", saleNoPurchase.getNoPurchaseCode()));
        tParameters.add(new TParameter<>("NoPurchaseDesc", saleNoPurchase.getNoPurchaseDesc()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        //
        updSP("SaleUpdNoPurchase", tParameters);
        return saleShowNoPurchaseByID(noPurchaseID);
    }

    default void saleDelNoPurchase(BigDecimal noPurchaseID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        LogLogins logLogins = fetchUserDetail();
        //
        tParameters.add(new TParameter<>("NoPurchaseID", noPurchaseID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        //
        delSP("SaleDelNoPurchase", tParameters);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        //
        cols.add(new Col(null, "noPurchaseID", "noPurchaseID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "noPurchaseCode", "کد", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "noPurchaseDesc", "دلیل عدم رضایت", Type.STRING, 130, true, true, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 100, true, true, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 120, true, true, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 100, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 100, false, false, false));
        //
        return new Meta(cols);
    }
}
