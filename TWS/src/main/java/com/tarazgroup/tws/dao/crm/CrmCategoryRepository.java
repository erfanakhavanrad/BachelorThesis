package com.tarazgroup.tws.dao.crm;


import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.crm.CrmCategory;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/***
 * @author A.Farahani
 * @date Sep-19, 2022
 ***/
public interface CrmCategoryRepository extends TCrudRepository<CrmCategory>, CrudRepository<CrmCategory, BigDecimal> {

    default List<CrmCategory> crmShowCategory(CrmCategory crmCategory) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmCategory._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmCategory._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmCategory._pageFilter()));
        return showSP("CrmShowCategory", tParameters, true);
    }

    //    GET BY ID
    default CrmCategory crmShowCategoryByID(BigDecimal categoryID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.CategoryID = " + categoryID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("CrmShowCategory", tParameters, true).get(0);
    }

    //    POST
    default CrmCategory crmInsCategory(CrmCategory crmCategory) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter("FormID", crmCategory.getFormID()));
        tParameters.add(new TParameter("CategoryName", crmCategory.getCategoryName()));
        tParameters.add(new TParameter("CategoryPosition", crmCategory.getCategoryPosition()));
        tParameters.add(new TParameter("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("CrmInsCategory", tParameters);
        return crmShowCategoryByID(newID);
    }


    default CrmCategory crmUpdCategory(BigDecimal categoryID, CrmCategory crmCategory) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("CategoryID", categoryID));
        tParameters.add(new TParameter("FormID", crmCategory.getFormID()));
        tParameters.add(new TParameter("CategoryName", crmCategory.getCategoryName()));
        tParameters.add(new TParameter("CategoryPosition", crmCategory.getCategoryPosition()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getModifierID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("CrmUpdCategory", tParameters);
        return crmShowCategoryByID(categoryID);
    }

    //    DELETE
    default void crmDelCategory(BigDecimal categoryID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("CategoryID", categoryID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("CrmDelCategory", tParameters);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "categoryID", "categoryID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "formID", "formID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "formName", "نام فرم", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "categoryName", "نام بلوک", Type.STRING, 100, false, false, false));
        cols.add(new Col(null, "categoryPosition", "موقعیت بلوک", Type.INTEGER, 100, true, true, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 0, false, false, false));
        return new Meta(cols);
    }
}
