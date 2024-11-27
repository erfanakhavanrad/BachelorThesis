package com.tarazgroup.tws.dao.crm;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.crm.CrmAudience;
import com.tarazgroup.tws.model.crm.CrmSelector;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Salman Majidi
 * @since 2.0.0
 */

@SuppressWarnings("Duplicates")
public interface CrmSelectorRepository extends TCrudRepository<CrmSelector>, CrudRepository<CrmSelector, BigDecimal> {

    default List<CrmSelector> crmShowSelector(CrmSelector crmSelector) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmSelector._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmSelector._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmSelector._pageFilter()));
        return showSP("CrmShowSelector", tParameters, true);
    }

    default List<CrmSelector> crmShowSelectorByFieldID(BigDecimal fieldID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.fieldID=" + fieldID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("CrmShowSelector", tParameters, true);
    }

    default CrmSelector crmShowSelectorByID(BigDecimal selectorID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.selectorID=" + selectorID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("CrmShowSelector", tParameters, true).get(0);
    }

    default CrmSelector crmInsSelector(CrmSelector crmSelector) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("FieldID", crmSelector.getFieldID()));
        tParameters.add(new TParameter<>("SelectorValue", crmSelector.getSelectorValue()));
        tParameters.add(new TParameter<>("Color", crmSelector.getColor()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("CrmInsSelector", tParameters);
        return crmShowSelectorByID(newID);
    }

    default void crmDelSelector(BigDecimal selectorID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("SelectorID", selectorID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("CrmDelSelector", tParameters);
    }

    default CrmSelector crmUpdSelector(BigDecimal selectorID, CrmSelector crmSelector) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("SelectorID", selectorID));
        tParameters.add(new TParameter<>("FieldID", crmSelector.getFieldID()));
        tParameters.add(new TParameter<>("SelectorValue", crmSelector.getSelectorValue()));
        tParameters.add(new TParameter<>("Color", crmSelector.getColor()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("CrmUpdSelector", tParameters);
        return crmShowSelectorByID(selectorID);
    }

    default InputStreamResource excel(CrmSelector crmSelector) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmSelector._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmSelector._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmSelector._pageFilter()));
        List<CrmSelector> rows = showSP("CrmShowSelector", tParameters, false);
        return exportToExcel(rows, meta().getCols(), "فرم ها");
    }


    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "selectorID", "selectorID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "fieldID", "fieldID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "fieldTitle", "نام فیلد", Type.STRING, 200, true, true, false));
        cols.add(new Col(null, "selectorValue", "مقدار", Type.STRING, 200, true, true, false));
        cols.add(new Col(null, "color", "رنگ", Type.COLOR, 120, true, true, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.INTEGER, 0, false, false, false));
        return new Meta(cols);
    }
}
