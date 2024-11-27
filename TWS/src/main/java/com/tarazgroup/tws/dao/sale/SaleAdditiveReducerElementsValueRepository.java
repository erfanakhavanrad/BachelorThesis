package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.sale.SaleAdditiveReducerElementsValue;
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
public interface SaleAdditiveReducerElementsValueRepository extends TCrudRepository<SaleAdditiveReducerElementsValue>, CrudRepository<SaleAdditiveReducerElementsValue, BigDecimal> {

    default List<SaleAdditiveReducerElementsValue> saleShowAdditiveReducerElementsValue(SaleAdditiveReducerElementsValue saleAdditiveReducerElementsValue) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        // TODO در این اس پی باید پیج فیلتر اضافه شود
        return showSP("SaleShowAdditiveReducerElementsValue", tParameters, true);
    }

    default SaleAdditiveReducerElementsValue saleShowAdditiveReducerElementsValueByID(BigDecimal valueID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        tParameters.add(new TParameter<>("Filter", "And ValueID=" + valueID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        //
        return showSP("SaleShowAdditiveReducerElementsValue", tParameters, true).get(0);
    }

    default SaleAdditiveReducerElementsValue saleInsAdditiveReducerElementsValue(SaleAdditiveReducerElementsValue saleAdditiveReducerElementsValue) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        LogLogins logLogins = fetchUserDetail();
        //
        tParameters.add(new TParameter<>("ElementID", saleAdditiveReducerElementsValue.getElementID()));
        tParameters.add(new TParameter<>("FromDate", saleAdditiveReducerElementsValue.getFromDate()));
        tParameters.add(new TParameter<>("ToDate", saleAdditiveReducerElementsValue.getToDate()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("CoEfficient", saleAdditiveReducerElementsValue.getCoEfficient()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        //
        BigDecimal newID = insSP("SaleInsAdditiveReducerElementsValue", tParameters);
        //
        return saleShowAdditiveReducerElementsValueByID(newID);
    }

    default SaleAdditiveReducerElementsValue saleUpdAdditiveReducerElementsValue(BigDecimal valueID, SaleAdditiveReducerElementsValue saleAdditiveReducerElementsValue) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        LogLogins logLogins = fetchUserDetail();
        //
        tParameters.add(new TParameter<>("ValueID", valueID));
        tParameters.add(new TParameter<>("ElementID", saleAdditiveReducerElementsValue.getElementID()));
        tParameters.add(new TParameter<>("FromDate", saleAdditiveReducerElementsValue.getFromDate()));
        tParameters.add(new TParameter<>("ToDate", saleAdditiveReducerElementsValue.getToDate()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("CoEfficient", saleAdditiveReducerElementsValue.getCoEfficient()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        //
        updSP("SaleUpdAdditiveReducerElementsValue", tParameters);
        //
        return saleShowAdditiveReducerElementsValueByID(valueID);
    }

    default void saleDelAdditiveReducerElementsValue(BigDecimal valueID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        LogLogins logLogins = fetchUserDetail();
        //
        tParameters.add(new TParameter<>("ValueID", valueID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        //
        delSP("SaleDelAdditiveReducerElementsValue", tParameters);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        //
        cols.add(new Col(null, "valueID", "valueID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "elementID", "elementID", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "fromDate", "شروع", Type.STRING, 130, true, true, false));
        cols.add(new Col(null, "toDate", "پایان", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 120, true, true, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 120, false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 100, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 120, false, false, false));
        cols.add(new Col(null, "coEfficient", "ضریب", Type.DECIMAL, 100, true, true, false));
        //
        return new Meta(cols);
    }
}
