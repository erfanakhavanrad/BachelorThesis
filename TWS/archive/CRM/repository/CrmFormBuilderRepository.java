package com.tarazgroup.tws.dao.crm;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.crm.CrmAudience;
import com.tarazgroup.tws.model.crm.CrmFormBuilder;
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
public interface CrmFormBuilderRepository extends TCrudRepository<CrmFormBuilder>, CrudRepository<CrmFormBuilder, BigDecimal> {

    default List<CrmFormBuilder> crmShowFormBuilder(CrmFormBuilder crmFormBuilder) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmFormBuilder._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmFormBuilder._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmFormBuilder._pageFilter()));
        return showSP("CrmShowFormBuilder", tParameters, true);
    }

    default CrmFormBuilder crmShowFormBuilderByID(BigDecimal fieldID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.fieldID=" + fieldID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("CrmShowFormBuilder", tParameters, true).get(0);
    }

    default List<CrmFormBuilder> crmShowFormBuilderByFormID(BigDecimal formID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.formID=" + formID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("CrmShowFormBuilder", tParameters, true);
    }

    default CrmFormBuilder crmInsFormBuilder(CrmFormBuilder crmFormBuilder) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("FormID", crmFormBuilder.getFormID()));
        tParameters.add(new TParameter<>("CategoryID", crmFormBuilder.getCategoryID()));
        tParameters.add(new TParameter<>("FieldType", crmFormBuilder.getFieldType()));
        tParameters.add(new TParameter<>("FieldTitle", crmFormBuilder.getFieldTitle()));
        tParameters.add(new TParameter<>("FieldTitleLatin", crmFormBuilder.getFieldTitleLatin()));
        tParameters.add(new TParameter<>("FieldGridPosition", crmFormBuilder.getFieldGridPosition()));
        tParameters.add(new TParameter<>("FieldGridWidth", crmFormBuilder.getFieldGridWidth()));
        tParameters.add(new TParameter<>("FieldDataEntryRowPosition", crmFormBuilder.getFieldDataEntryRowPosition()));
        tParameters.add(new TParameter<>("FieldDataEntryColPosition", crmFormBuilder.getFieldDataEntryColPosition()));
        tParameters.add(new TParameter<>("FieldDataEntryRowSpan", crmFormBuilder.getFieldDataEntryRowSpan()));
        tParameters.add(new TParameter<>("FieldDataEntryColSpan", crmFormBuilder.getFieldDataEntryColSpan()));
        tParameters.add(new TParameter<>("CssStyle", crmFormBuilder.getCssStyle()));
        tParameters.add(new TParameter<>("IsRequired", crmFormBuilder.getIsRequired()));
        tParameters.add(new TParameter<>("IsQuick", crmFormBuilder.getIsQuick()));
        tParameters.add(new TParameter<>("Visibility", crmFormBuilder.getVisibility()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("CrmInsFormBuilder", tParameters);
        return crmShowFormBuilderByID(newID);
    }

    default void crmDelFormBuilder(BigDecimal fieldID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("FieldID", fieldID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("CrmDelFormBuilder", tParameters);
    }

    default CrmFormBuilder crmUpdFormBuilder(BigDecimal fieldID, CrmFormBuilder crmFormBuilder) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("FieldID", crmFormBuilder.getFieldID()));
        tParameters.add(new TParameter<>("FormID", crmFormBuilder.getFormID()));
        tParameters.add(new TParameter<>("CategoryID", (crmFormBuilder.getCategoryID() == null || crmFormBuilder.getCategoryID().intValue() == 0) ? null : crmFormBuilder.getCategoryID()));
        tParameters.add(new TParameter<>("FieldType", crmFormBuilder.getFieldType()));
        tParameters.add(new TParameter<>("FieldTitle", crmFormBuilder.getFieldTitle()));
        tParameters.add(new TParameter<>("FieldTitleLatin", crmFormBuilder.getFieldTitleLatin()));
        tParameters.add(new TParameter<>("FieldGridPosition", crmFormBuilder.getFieldGridPosition()));
        tParameters.add(new TParameter<>("FieldGridWidth", crmFormBuilder.getFieldGridWidth()));
        tParameters.add(new TParameter<>("FieldDataEntryRowPosition", crmFormBuilder.getFieldDataEntryRowPosition()));
        tParameters.add(new TParameter<>("FieldDataEntryColPosition", crmFormBuilder.getFieldDataEntryColPosition()));
        tParameters.add(new TParameter<>("FieldDataEntryRowSpan", crmFormBuilder.getFieldDataEntryRowSpan()));
        tParameters.add(new TParameter<>("FieldDataEntryColSpan", crmFormBuilder.getFieldDataEntryColSpan()));
        tParameters.add(new TParameter<>("CssStyle", crmFormBuilder.getCssStyle()));
        tParameters.add(new TParameter<>("IsRequired", crmFormBuilder.getIsRequired()));
        tParameters.add(new TParameter<>("IsQuick", crmFormBuilder.getIsQuick()));
        tParameters.add(new TParameter<>("Visibility", crmFormBuilder.getVisibility()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("CrmUpdFormBuilder", tParameters);
        return crmShowFormBuilderByID(fieldID);
    }
    default InputStreamResource excel(CrmFormBuilder crmFormBuilder) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmFormBuilder._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmFormBuilder._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmFormBuilder._pageFilter()));
        List<CrmFormBuilder> rows = showSP("CrmShowFormBuilder", tParameters, false);
        return exportToExcel(rows, meta().getCols(), "فرم ها");
    }


    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null,"fieldID", "fieldID", Type.DECIMAL, 0, false, false,  true));
        cols.add(new Col(null,"formID", "formID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"categoryID", "categoryID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"fieldType", "fieldType", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"fieldName", "fieldName", Type.STRING, 0, false, false,  false));
        cols.add(new Col(null,"fieldTitle", "نام فیلد", Type.STRING, 150, true, true,  false));
        cols.add(new Col(null,"fieldTitleLatin", "نام لاتین فیلد", Type.STRING, 150, true, true,  false));
        cols.add(new Col(null,"formName", "نام فرم", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"fieldGridPosition", "جایگاه ستون", Type.TINYINTEGER, 100, true, true,  false));
        cols.add(new Col(null,"fieldGridWidth", "عرض ستون", Type.INTEGER, 100, true, true,  false));
        cols.add(new Col(null,"fieldDataEntryRowPosition", "جایگاه سطر ورود اطلاعات", Type.TINYINTEGER, 200, true, true,  false));
        cols.add(new Col(null,"fieldDataEntryColPosition", "جایگاه ستون ورود اطلاعات", Type.TINYINTEGER, 200, true, true,  false));
        cols.add(new Col(null,"fieldDataEntryRowSpan", "پیشروی در سطر", Type.TINYINTEGER, 150, true, true,  false));
        cols.add(new Col(null,"fieldDataEntryColSpan", "پیشروی در ستون", Type.TINYINTEGER, 150, true, true,  false));
        cols.add(new Col(null,"cssStyle", "css", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"isRequired", "اجباری", Type.BOOLEAN, 60, true, true,  false));
        cols.add(new Col(null,"isQuick", "ایجاد سریع", Type.BOOLEAN, 100, true, true,  false));
        cols.add(new Col(null,"canDelete", "فیلد کاربر", Type.BOOLEAN, 100, true, true,  false));
        cols.add(new Col(null,"visibility", "نمایش", Type.BOOLEAN, 100, true, true,  false));
        cols.add(new Col(null,"categoryName", "نام دسته بندی", Type.STRING, 120, true, true,  false));
        cols.add(new Col(null,"fieldTypeDesc", "نوع", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"creatorID", "creatorID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"createDate", "createDate", Type.DATE, 0, false, false,  false));
        cols.add(new Col(null,"modifierID", "modifierID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"modifyDate", "modifyDate", Type.DATE, 0, false, false,  false));
        cols.add(new Col(null,"serverID", "serverID", Type.INTEGER, 0, false, false,  false));
        return new Meta(cols);
    }

    default Meta meta1() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null,"fieldID", "fieldID", Type.DECIMAL, 0, false, false,  true));
        cols.add(new Col(null,"fieldTitle", "نام فیلد", Type.STRING, 200, true, true,  false));
        cols.add(new Col(null,"serverID", "serverID", Type.INTEGER, 0, false, false,  false));
        return new Meta(cols);
    }
}
