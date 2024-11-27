package com.tarazgroup.tws.dao.crm;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.crm.CrmAudience;
import com.tarazgroup.tws.model.crm.CrmCategory;
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

    default CrmCategory crmShowCategoryByID(BigDecimal categoryID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.categoryID=" + categoryID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("CrmShowCategory", tParameters, true).get(0);
    }

    default CrmCategory crmInsCategory(CrmCategory crmCategory) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("FormID", crmCategory.getFormID()));
        tParameters.add(new TParameter<>("CategoryName", crmCategory.getCategoryName()));
        tParameters.add(new TParameter<>("CategoryPosition", crmCategory.getCategoryPosition()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("CrmInsCategory", tParameters);
        return crmShowCategoryByID(newID);
    }

    default void crmDelCategory(BigDecimal categoryID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("CategoryID", categoryID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("CrmDelCategory", tParameters);
    }

    default CrmCategory crmUpdCategory(BigDecimal categoryID, CrmCategory crmCategory) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("CategoryID", categoryID));
        tParameters.add(new TParameter<>("FormID", crmCategory.getFormID()));
        tParameters.add(new TParameter<>("CategoryName", crmCategory.getCategoryName()));
        tParameters.add(new TParameter<>("CategoryPosition", crmCategory.getCategoryPosition()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("CrmUpdCategory", tParameters);
        return crmShowCategoryByID(categoryID);
    }

    default InputStreamResource excel(CrmCategory crmCategory) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmCategory._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmCategory._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmCategory._pageFilter()));
        List<CrmCategory> rows = showSP("CrmShowCategory", tParameters, false);
        return exportToExcel(rows, meta().getCols(), "فرم ها");
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null,"categoryID", "categoryID", Type.DECIMAL, 0, false, false,  true));
        cols.add(new Col(null,"formID", "formID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"formName", "نام فرم", Type.STRING, 200, true, true,  false));
        cols.add(new Col(null,"categoryName", "نام دسته بندی", Type.STRING, 200, true, true,  false));
        cols.add(new Col(null,"categoryPosition", "ترتیب نمایش", Type.DECIMAL, 120, true, true,  false));
        cols.add(new Col(null,"modifyDate", "modifyDate", Type.DATE, 100, false, false,  false));
        cols.add(new Col(null,"serverID", "serverID", Type.INTEGER, 100, false, false,  false));
        cols.add(new Col(null,"createDate", "createDate", Type.DATE, 120, false, false,  false));
        cols.add(new Col(null,"modifierID", "modifierID", Type.DECIMAL, 100, false, false,  false));
        cols.add(new Col(null,"creatorID", "creatorID", Type.DECIMAL, 100, false, false,  false));
        return new Meta(cols);
    }

    default Meta meta1() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null,"categoryID", "categoryID", Type.DECIMAL, 0, false, false,  true));
        cols.add(new Col(null,"formID", "formID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"formName", "نام فرم", Type.STRING, 200, false, false,  false));
        cols.add(new Col(null,"categoryName", "نام دسته بندی", Type.STRING, 200, true, true,  false));
        cols.add(new Col(null,"categoryPosition", "ترتیب نمایش", Type.DECIMAL, 120, true, true,  false));
        cols.add(new Col(null,"modifyDate", "modifyDate", Type.DATE, 100, false, false,  false));
        cols.add(new Col(null,"serverID", "serverID", Type.INTEGER, 100, false, false,  false));
        cols.add(new Col(null,"createDate", "createDate", Type.DATE, 120, false, false,  false));
        cols.add(new Col(null,"modifierID", "modifierID", Type.DECIMAL, 100, false, false,  false));
        cols.add(new Col(null,"creatorID", "creatorID", Type.DECIMAL, 100, false, false,  false));
        return new Meta(cols);
    }
}
