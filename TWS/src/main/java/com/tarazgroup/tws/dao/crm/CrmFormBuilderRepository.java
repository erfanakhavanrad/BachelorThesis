package com.tarazgroup.tws.dao.crm;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.crm.CrmFormBuilder;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.exception.TConflictException;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 9/6/22
 *
 * @author Aref Azizi
 */
public interface CrmFormBuilderRepository extends TCrudRepository<CrmFormBuilder>, CrudRepository<CrmFormBuilder, BigDecimal> {

    //    GET All
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

    //    GET BY ID
    default CrmFormBuilder crmShowFormBuilderByID(BigDecimal fieldID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND [Main].[FieldID] =" + fieldID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("CrmShowFormBuilder", tParameters, true).get(0);
    }

    //    GET BY ID
    default List<CrmFormBuilder> crmShowFormBuilderSelectorFields(BigDecimal formID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND [Main].[FieldType] = 6 AND [Main].[FormID] =" + formID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("CrmShowFormBuilder", tParameters, true);
    }

    default List<CrmFormBuilder> crmShowCategoryFormID(BigDecimal formID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND [Main].[formID] =" + formID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("CrmShowFormBuilder", tParameters, true);
    }

    default List<CrmFormBuilder> crmShowFormBuilderByFormID(BigDecimal formID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND [Main].[FormID] =" + formID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("CrmShowFormBuilder", tParameters, true);
    }

    //    POST
    default CrmFormBuilder crmInsFormBuilder(CrmFormBuilder crmFormBuilder) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
//        boolean condition = false;

        tParameters.add(new TParameter<>("FormID", crmFormBuilder.getFormID()));
        tParameters.add(new TParameter<>("CategoryID", crmFormBuilder.getCategoryID()));
        tParameters.add(new TParameter<>("FieldType", crmFormBuilder.getFieldType()));
        tParameters.add(new TParameter<>("FieldTitle", crmFormBuilder.getFieldTitle()));
        tParameters.add(new TParameter<>("FieldTitleLatin", crmFormBuilder.getFieldTitleLatin()));
        tParameters.add(new TParameter<>("FieldGridPosition", crmFormBuilder.getFieldGridPosition()));
        tParameters.add(new TParameter<>("FieldGridWidth", crmFormBuilder.getFieldGridWidth()));
        tParameters.add(new TParameter<>("FieldDataEntryColPosition", crmFormBuilder.getFieldDataEntryColPosition()));
        tParameters.add(new TParameter<>("FieldDataEntryRowPosition", crmFormBuilder.getFieldDataEntryRowPosition()));
        tParameters.add(new TParameter<>("FieldDataEntryRowSpan", crmFormBuilder.getFieldDataEntryRowSpan()));
        tParameters.add(new TParameter<>("FieldDataEntryColSpan", crmFormBuilder.getFieldDataEntryColSpan()));
        tParameters.add(new TParameter<>("CssStyle", crmFormBuilder.getCssStyle()));
        tParameters.add(new TParameter<>("IsRequired", crmFormBuilder.getIsRequired()));
        tParameters.add(new TParameter<>("IsQuick", crmFormBuilder.getIsQuick()));
        tParameters.add(new TParameter<>("visibility", crmFormBuilder.getVisibility()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("QKeyID", crmFormBuilder.getqKeyID()));
        tParameters.add(new TParameter<>("WhereCondition", crmFormBuilder.getWhereCondition()));
        BigDecimal newID = insSP("CrmInsFormBuilder", tParameters);
        return crmShowFormBuilderByID(newID);

//        try {
//            CrmFormBuilder crmFormBuilder2 = new CrmFormBuilder();
//            crmFormBuilder2.setFormID(crmFormBuilder.getFormID());
//            final List<CrmFormBuilder> crmFormBuilders2 = crmShowFormBuilder(crmFormBuilder2);
//
//            Integer visibilityCount = 0;
//
//            for (int i = 0; i < crmFormBuilders2.size(); i++) {
//                if (crmFormBuilders2.get(i).getVisibility() == true) visibilityCount++;
//            }
//            if (visibilityCount >= 8)
//                throw new TConflictException(205, "نمیتوانید بیش از 8 فیلد را جهت نمایش در لیست انتخاب کنید. جهت ادامه، مقدار قابل مشاهده فیلدهای قبلی را عوض کرده و مجددا تلاش کنید.");
//        } catch (Exception e) {
//            System.out.println(e.toString());
//        }

//        try {
//            do {
//
//                CrmFormBuilder crmFormBuilder2 = new CrmFormBuilder();
//                crmFormBuilder2.setFormID(crmFormBuilder.getFormID());
//                final List<CrmFormBuilder> crmFormBuilders2 = crmShowFormBuilder(crmFormBuilder2);
//
//                Integer visibilityCount = 0;
//
//                for (int i = 0; i < crmFormBuilders2.size(); i++) {
//                    if (crmFormBuilders2.get(i).getVisibility() == true) visibilityCount++;
//                }
//
//
//                if (visibilityCount >= 8) {
//                    condition = false;
//                    throw new TConflictException(205, "نمیتوانید بیش از 8 فیلد را جهت نمایش در لیست انتخاب کنید. جهت ادامه، مقدار قابل مشاهده فیلدهای قبلی را عوض کرده و مجددا تلاش کنید.");
//                }


//                tParameters.add(new TParameter<>("visibility", crmFormBuilder.getVisibility()));
//                tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
//                tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
//                tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
//                BigDecimal newID = insSP("CrmInsFormBuilder", tParameters);
//                condition = false;
//                return crmShowFormBuilderByID(newID);

//            } while (condition);
//        } catch (Exception e) {
//            System.out.println(e.toString());
//        }
//
    }

    default CrmFormBuilder crmUpdFormBuilder(BigDecimal fieldID, CrmFormBuilder crmFormBuilder) {
        LogLogins logLogins = fetchUserDetail();

        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("FieldID", crmFormBuilder.getFieldID()));
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
        tParameters.add(new TParameter<>("visibility", crmFormBuilder.getVisibility()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("QKeyID", crmFormBuilder.getqKeyID()));
        tParameters.add(new TParameter<>("WhereCondition", crmFormBuilder.getWhereCondition()));
        updSP("CrmUpdFormBuilder", tParameters);
        return crmShowFormBuilderByID(fieldID);
    }

    //    DELETE
    default void crmDelFormBuilder(BigDecimal fieldID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("FieldID", fieldID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("CrmDelFormBuilder", tParameters);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "fieldID", "fieldID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "formID", "formID", Type.DECIMAL, 0, true, false, false));
        cols.add(new Col(null, "categoryID", "categoryID", Type.DECIMAL, 0, true, true, false));
        cols.add(new Col(null, "fieldType", "fieldType", Type.INTEGER, 0, true, false, false));
        cols.add(new Col(null, "fieldName", "fieldName", Type.STRING, 0, true, true, false));
        cols.add(new Col(null, "fieldTitle", "fieldTitle", Type.STRING, 0, true, true, false));
        cols.add(new Col(null, "fieldTitleLatin", "fieldTitleLatin", Type.STRING, 0, true, true, false));
        cols.add(new Col(null, "fieldGridPosition", "fieldGridPosition", Type.INTEGER, 0, true, true, false));
        cols.add(new Col(null, "fieldGridWidth", "fieldGridWidth", Type.INTEGER, 0, true, true, false));
        cols.add(new Col(null, "fieldDataEntryRowPosition", "fieldDataEntryRowPosition", Type.INTEGER, 0, true, true, false));
        cols.add(new Col(null, "fieldDataEntryColPosition", "fieldDataEntryColPosition", Type.INTEGER, 0, true, true, false));
        cols.add(new Col(null, "fieldDataEntryRowSpan", "fieldDataEntryRowSpan", Type.INTEGER, 0, true, true, false));
        cols.add(new Col(null, "fieldDataEntryColSpan", "fieldDataEntryColSpan", Type.INTEGER, 0, true, true, false));
        cols.add(new Col(null, "cssStyle", "cssStyle", Type.STRING, 0, true, true, false));
        cols.add(new Col(null, "isRequired", "isRequired", Type.BOOLEAN, 0, true, true, false));
        cols.add(new Col(null, "isQuick", "isQuick", Type.BOOLEAN, 0, true, false, false));
        cols.add(new Col(null, "canDelete", "canDelete", Type.BOOLEAN, 0, true, false, false));
        cols.add(new Col(null, "visibility", "visibility", Type.BOOLEAN, 0, true, false, false));
        cols.add(new Col(null, "formName", "formName", Type.STRING, 0, true, false, false));
        cols.add(new Col(null, "categoryName", "categoryName", Type.STRING, 0, true, false, false));
        cols.add(new Col(null, "CategoryPosition", "CategoryPosition", Type.INTEGER, 0, true, false, false));
        cols.add(new Col(null, "fieldTypeDesc", "fieldTypeDesc", Type.STRING, 0, true, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 0, true, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 0, false, false, false));
        return new Meta(cols);
    }
}
