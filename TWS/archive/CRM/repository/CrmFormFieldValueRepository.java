package com.tarazgroup.tws.dao.crm;

import com.tarazgroup.tws.dao.ResultErrMsgNewID;
import com.tarazgroup.tws.dao.ShowSPReturnType;
import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.dto.crm.CrmFormFieldValueTO;
import com.tarazgroup.tws.model.crm.*;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.exception.TConflictException;
import com.tarazgroup.tws.util.global.TChip;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.*;
import com.tarazgroup.tws.util.tabletype.crm.CrmFormFieldValueType;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * @author Salman Majidi
 * @since 2.0.0
 */

@SuppressWarnings("Duplicates")
public interface CrmFormFieldValueRepository
        extends TCrudRepository<CrmFormFieldValue>, CrudRepository<CrmFormFieldValue, BigDecimal> {

    static Type intToType(int fieldType) {
        //convert FieldType Integer Format To Type Enum
        switch (fieldType) {
            case 1:// String
                return Type.STRING;
            case 2:// Number
                return Type.INTEGER;
            case 3:// Date Shamsi
            case 8:// Date Gregorian
                return Type.DATE;
            case 4:// TODO Time -> extend later
            case 5:// Boolean
                return Type.BOOLEAN;
            case 6:// Selector
                return Type.CHIP;
            case 7:// Memo / Text Area
                return Type.STRINGLONG;
            case 10:// QKEY
                return Type.QKEY;
            case 11:// ارجاع به
                return Type.REFERTO;
            default:
                return null;
        }
    }

    List<CrmFormFieldValue> findByRecordID(BigDecimal recordID);

    default String pageFilter(BigDecimal formID, Map<String, String> params,
                              CrmFormBuilderRepository crmFormBuilderRepository,
                              CrmQKeyMapFieldRepository crmQKeyMapFieldRepository) {
        CrmFormFieldValue crmFormFieldValue = new CrmFormFieldValue();
        StringBuilder filters = new StringBuilder();
        if (params.get("pageNumber") != null) {
            BigDecimal pageNumber = new BigDecimal(params.get("pageNumber"));
            params.remove("pageNumber");
            crmFormFieldValue.setPageNumber(pageNumber);
        }
        if (params.get("recordCount") != null) {
            BigDecimal recordCount = new BigDecimal(params.get("recordCount"));
            params.remove("recordCount");
            crmFormFieldValue.setRecordCount(recordCount);
        }

        List<CrmFormBuilder> crmFormBuilders = crmFormBuilderRepository.crmShowFormBuilderByFormID(formID);
        for (CrmFormBuilder crmFormBuilder : crmFormBuilders) {
            // این قسمت مربوط به سرچ سرستون است
            BigDecimal fieldID = crmFormBuilder.getFieldID();
            String name = crmFormBuilder.getFieldName();
            Type type = intToType(crmFormBuilder.getFieldType().intValue());
            switch (type) {
                case QKEY:
                    CrmQKeyMapField crmQKeyMapField = crmQKeyMapFieldRepository.crmShowQKeyMapFieldByFieldID(fieldID);
                    String qKeyDesc = name.replaceFirst("FieldName", crmQKeyMapField.getDescName());// نام فیلد شرح در ستون گرید
                    String valueQkey = params.get(qKeyDesc);
                    if (valueQkey != null) {
                        filters
                                .append(" CAST(")
                                .append(qKeyDesc)
                                .append(" AS NVARCHAR)")
                                .append(" LIKE ")
                                .append("'%")
                                .append(valueQkey)
                                .append("%'")
                                .append(" AND ");
                    }
                    break;
                case REFERTO:
                    String referToDesc = name.replaceFirst("FieldName", "PercomName");// نام فیلد ارجاع به در ستون گرید
                    String valueReferTo = params.get(referToDesc);
                    if (valueReferTo != null) {
                        filters
                                .append(" CAST(")
                                .append(referToDesc)
                                .append(" AS NVARCHAR)")
                                .append(" LIKE ")
                                .append("'%")
                                .append(valueReferTo)
                                .append("%'")
                                .append(" AND ");
                    }
                    break;
                case BOOLEAN:
                    String valueBoolean = params.get(name);
                    if (valueBoolean != null) {
                        filters
                                .append(name)
                                .append(" = ")
                                .append(Boolean.valueOf(valueBoolean) ? "1" : "0")
                                .append(" AND ");
                    }
                    break;

                case CHIP:
                    // AND ( charindex (''30000002'', cast ( FieldName_30000001_30000007 as nvarchar(max)) ) > 0  or charindex (''30000007'', cast ( FieldName_30000001_30000007 as nvarchar(max)) ) > 0 )
                    String valueChip = params.get(name);
                    if (valueChip != null) {
                        String[] valueChips = valueChip.split(",");
                        filters.append(" ( ");
                        for (int i = 0; i < valueChips.length; i++) {
                            filters.append(" CHARINDEX ('").append(valueChips[i]).append("',CAST ( ").append(name).append(" AS NVARCHAR(MAX)").append(" )) > 0 ").append(" AND ");
                        }
                        if (filters.length() > 0) {
                            filters.delete(filters.length() - " AND".length(),
                                    filters.length()
                            );
                        }
                        filters.append(" ) AND ");
                    }
                    break;
                default:
                    String value = params.get(name);
                    if (value != null) {
                        filters
                                .append(" CAST(")
                                .append(name)
                                .append(" AS NVARCHAR)")
                                .append(" LIKE ")
                                .append("'%")
                                .append(value)
                                .append("%'")
                                .append(" AND ");
                    }
                    break;
            }
        }

        if (filters.length() > 0) {
            filters.delete(filters.length() - " AND".length(),
                    filters.length()
            );

        }
        String filter = null;
        if (params.get("filter") != null) {
            filter = params.get("filter");

        }
        if (!filters.toString().equals("")) {
            if (filter == null) {
                filter = filters.toString();
            } else {
                filter += " AND " + filters.toString();
            }
        }
        crmFormFieldValue.setFilter(filter);

        return crmFormFieldValue._pageFilter();
    }

    default int recordsCount(Map<String, String> params,
                             CrmFormBuilderRepository crmFormBuilderRepository,
                             CrmQKeyMapFieldRepository crmQKeyMapFieldRepository) {
        BigDecimal formID = new BigDecimal(params.get("formID"));
        params.remove("formID");
        params.remove("pageNumber");
        params.remove("recordCount");
        LogLogins logLogins = fetchUserDetail();
        String pageFilter = pageFilter(formID, params, crmFormBuilderRepository, crmQKeyMapFieldRepository);
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("FormID", formID));
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("PageFilter", pageFilter));
        List<Map<String, Object>> rows = execSPNativeQuery(CrmFormFieldValue.class, "CrmShowFormFieldValue", tParameters, ShowSPReturnType.MAP);
        return rows.size();
    }

    default List<Map<String, Object>> crmShowFormFieldValue(
            Map<String, String> params,
            CrmFormBuilderRepository crmFormBuilderRepository,
            CrmSelectorRepository crmSelectorRepository,
            CrmQKeyMapFieldRepository crmQKeyMapFieldRepository) {
        BigDecimal formID = new BigDecimal(params.get("formID"));
        params.remove("formID");
        LogLogins logLogins = fetchUserDetail();
        String pageFilter = pageFilter(formID, params, crmFormBuilderRepository, crmQKeyMapFieldRepository);
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("FormID", formID));
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("PageFilter", pageFilter));
        List<Map<String, Object>> rows = execSPNativeQuery(CrmFormFieldValue.class, "CrmShowFormFieldValue", tParameters, ShowSPReturnType.MAP);
        return convertCommaValuesToTChips(rows, formID, crmFormBuilderRepository, crmSelectorRepository);
    }


    default Map<String, Object> crmShowFormFieldValueByRecordID(
            BigDecimal formID,
            BigDecimal recordID,
            CrmFormBuilderRepository crmFormBuilderRepository,
            CrmSelectorRepository crmSelectorRepository) {
        LogLogins logLogins = fetchUserDetail();
        CrmFormFieldValue crmFormFieldValue = new CrmFormFieldValue();
        crmFormFieldValue.setFilter("recordID = " + recordID);
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("FormID", formID));
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("PageFilter", crmFormFieldValue._pageFilter()));
        List<Map<String, Object>> rows = execSPNativeQuery(CrmFormFieldValue.class, "CrmShowFormFieldValue", tParameters, ShowSPReturnType.MAP);
        return convertCommaValuesToTChips(rows, formID, crmFormBuilderRepository, crmSelectorRepository).get(0);
    }

    default Map<String, Object> crmInsFormFieldValue(
            CrmFormFieldValueTO crmFormFieldValueTO,
            CrmFormBuilderRepository crmFormBuilderRepository,
            CrmSelectorRepository crmSelectorRepository) {
        List<CrmFormFieldValueType> formFieldValues = crmFormFieldValueTO.getFormFieldValues();
//        // فیلد های غیر نال را فیلتر میکنیم
//        List<CrmFormFieldValueType> formFieldValuesNotNull = formFieldValues.stream()
//                .filter(ffv -> ffv.getFieldValue()!=null)
//                .collect(Collectors.toList());

        List<CrmFormFieldValueType> crmFormFieldValueTypes = new ArrayList<>();
        for (int i = 0; i < formFieldValues.size(); i++) {
            CrmFormFieldValueType crmFormFieldValueType = new CrmFormFieldValueType();
            crmFormFieldValueType.setFieldID(formFieldValues.get(i).getFieldID());
            crmFormFieldValueType.setFieldValue(formFieldValues.get(i).getFieldValue());
            crmFormFieldValueType.setValueID(null);// because of insert
            crmFormFieldValueTypes.add(crmFormFieldValueType);

        }
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("RecordID", null));// because of insert
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("TValue", "CrmFormFieldValueType", crmFormFieldValueTypes));
        ResultErrMsgNewID resultErrMsgNewID = execSPNativeQuery(CrmFormFieldValue.class, "CrmInsUpdFormFieldValue", tParameters);
        if (resultErrMsgNewID.getResult().intValue() == 0) {
            return crmShowFormFieldValueByRecordID(resultErrMsgNewID.getFormID(), resultErrMsgNewID.getNewID(), crmFormBuilderRepository, crmSelectorRepository);
        } else {
            throw new TConflictException(resultErrMsgNewID.getResult().intValue(), resultErrMsgNewID.getErrMsg());
        }
    }

    default Map<String, Object> crmUpdFormFieldValue(
            BigDecimal recordID,
            CrmFormFieldValueTO crmFormFieldValueTO,
            CrmFormBuilderRepository crmFormBuilderRepository,
            CrmSelectorRepository crmSelectorRepository) {
        List<CrmFormFieldValueType> formFieldValues = crmFormFieldValueTO.getFormFieldValues();
        List<CrmFormFieldValue> crmFormFieldValues = findByRecordID(recordID);
        for (int i = 0; i < formFieldValues.size(); i++) {
            CrmFormFieldValueType formFieldValue = formFieldValues.get(i);
            CrmFormFieldValue crmFormFieldValue = crmFormFieldValues.stream()
                    .filter(cffv -> cffv.getFieldID().toString().equals(formFieldValue.getFieldID().toString()))
                    .findAny()
                    .orElse(null);
            if (crmFormFieldValue != null) {
                formFieldValue.setValueID(crmFormFieldValue.getValueID());
            } else {
                formFieldValue.setValueID(null);
            }
        }

        List<CrmFormFieldValueType> crmFormFieldValueTypes = new ArrayList<>();
        for (int i = 0; i < formFieldValues.size(); i++) {
            CrmFormFieldValueType crmFormFieldValueType = new CrmFormFieldValueType();
            crmFormFieldValueType.setFieldID(formFieldValues.get(i).getFieldID());
            crmFormFieldValueType.setFieldValue(formFieldValues.get(i).getFieldValue());
            crmFormFieldValueType.setValueID(formFieldValues.get(i).getValueID());
            crmFormFieldValueTypes.add(crmFormFieldValueType);
        }
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("RecordID", recordID));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("TValue", "CrmFormFieldValueType", crmFormFieldValueTypes));
        ResultErrMsgNewID resultErrMsgNewID = execSPNativeQuery(CrmFormFieldValue.class, "CrmInsUpdFormFieldValue", tParameters);
        if (resultErrMsgNewID.getResult().intValue() == 0) {
            return crmShowFormFieldValueByRecordID(resultErrMsgNewID.getFormID(), resultErrMsgNewID.getNewID(), crmFormBuilderRepository, crmSelectorRepository);
        } else {
            throw new TConflictException(resultErrMsgNewID.getResult().intValue(), resultErrMsgNewID.getErrMsg());
        }
    }

    default void crmDelFormFieldValue(BigDecimal recordID, BigDecimal formID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("RecordID", recordID));
        tParameters.add(new TParameter<>("FormID", formID));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("CrmDelFormFieldValue", tParameters);
    }

    default MetaDynamic meta(BigDecimal formID, CrmFormBuilderRepository crmFormBuilderRepository, CrmFormRepository crmFormRepository, CrmQKeyMapFieldRepository crmQKeyMapFieldRepository) {
        List<CrmFormBuilder> crmFormBuilders = crmFormBuilderRepository.crmShowFormBuilderByFormID(formID);
        CrmForm crmForm = crmFormRepository.crmShowFormByID(formID);
        int dataEntryHeight = crmForm.getDataEntryHeight();
        //************************************** فیلد های دیتا انتری **************************************
        // فیلد ها را بر اساس کتگوری آی دی گروپ بای میزنیم تا معلوم شود چند تا کتگوری یکتا داریم
        ArrayList<CtgDynamic> ctgDynamics = new ArrayList<>();
        Map<BigDecimal, List<CrmFormBuilder>> categories = crmFormBuilders.stream()
                .collect(groupingBy(CrmFormBuilder::getCategoryID));
        for (Map.Entry<BigDecimal, List<CrmFormBuilder>> category : categories.entrySet()) {
            CrmFormBuilder crmFormBuilder = category.getValue().get(0);
            BigDecimal categoryID = crmFormBuilder.getCategoryID();
            String categoryName = crmFormBuilder.getCategoryName();
            Integer categoryPosition = crmFormBuilder.getCategoryPosition();
            ctgDynamics.add(new CtgDynamic(categoryID, categoryName, categoryPosition));
        }

        // به ازای تک تک کتگوری ها فیلد های آن کتگوری را پیدا میکنیم
        ArrayList<ArrayList<ArrayList>> fieldDynamicCtgs = new ArrayList<>();
        for (CtgDynamic ctgDynamic : ctgDynamics) {
            List<CrmFormBuilder> fieldsForCat = crmFormBuilders.stream()
                    .filter(cffv -> cffv.getCategoryID().toString().equals(ctgDynamic.getCategoryID().toString()))
                    .collect(Collectors.toList());

            ArrayList<ArrayList> fieldDynamicRows = new ArrayList<>();
            // فیلد های این کتگوری را بر اساس رو پوزیشن گروپ بای میزنیم تا معلوم شود چند تا سطر داریم
            Map<Integer, List<CrmFormBuilder>> fieldsForCatMap = fieldsForCat.stream()
                    .collect(groupingBy(CrmFormBuilder::getFieldDataEntryRowPosition));
            for (Map.Entry<Integer, List<CrmFormBuilder>> fieldsForCatGroupedByRowPositionMap : fieldsForCatMap.entrySet()) {
                // تا اینجا فیلد های این کتگوری برای هر سطر تفکیک شده اند
                ArrayList fieldDynamicCells = new ArrayList<>();
                List<CrmFormBuilder> fieldsInRow = fieldsForCatGroupedByRowPositionMap.getValue();
                for (CrmFormBuilder fieldInCell : fieldsInRow) {
                    BigDecimal fieldID = fieldInCell.getFieldID();
                    String name = fieldInCell.getFieldName();
                    String title = fieldInCell.getFieldTitle();
                    Type type = intToType(fieldInCell.getFieldType().intValue());

                    boolean visibility = fieldInCell.getVisibility() == null ? false : fieldInCell.getVisibility();
                    boolean isRequired = fieldInCell.getIsRequired() == null ? false : fieldInCell.getIsRequired();
                    boolean canDelete = fieldInCell.getCanDelete() == null ? false : fieldInCell.getCanDelete();
                    ;
                    String cssStyle = fieldInCell.getCssStyle();
                    int rowSpan = fieldInCell.getFieldDataEntryRowSpan();
                    int colSpan = fieldInCell.getFieldDataEntryColSpan();
                    // این فیلد را به لیست سلول ها اضافه میکنیم
                    switch (type) {
                        case QKEY:
                            CrmQKeyMapField crmQKeyMapField = crmQKeyMapFieldRepository.crmShowQKeyMapFieldByFieldID(fieldID);
                            String qKeyCode = name.replaceFirst("FieldName", crmQKeyMapField.getCodeName());// نام فیلد کد در دیتا انتری مدل
                            String qKeyDesc = name.replaceFirst("FieldName", crmQKeyMapField.getDescName());// نام فیلد شرح در دیتا انتری مدل
                            String qKeyCodeField = crmQKeyMapField.getCodeName(); // نام ستون کد در جدول مودال
                            String qKeyDescField = crmQKeyMapField.getDescName(); // نام ستون شرح در جدول مودال

                            fieldDynamicCells.add(
                                    new FieldDynamicQKey(
                                            fieldID,
                                            name,
                                            title,
                                            type,
                                            visibility,
                                            isRequired,
                                            canDelete,
                                            true,
                                            cssStyle,
                                            rowSpan,
                                            colSpan,
                                            qKeyCode,
                                            qKeyDesc,
                                            qKeyCodeField,
                                            qKeyDescField
                                    ));
                            break;

                        case REFERTO:
                            String referToCode = name.replaceFirst("FieldName", "PercomCode");// نام فیلد کد در دیتا انتری مدل
                            String referToDesc = name.replaceFirst("FieldName", "PercomName");// نام فیلد شرح در دیتا انتری مدل

                            fieldDynamicCells.add(
                                    new FieldDynamicReferTo(
                                            fieldID,
                                            name,
                                            title,
                                            type,
                                            visibility,
                                            isRequired,
                                            canDelete,
                                            true,
                                            cssStyle,
                                            rowSpan,
                                            colSpan,
                                            referToCode,
                                            referToDesc
                                    ));
                            break;
                        default:
                            fieldDynamicCells.add(
                                    new FieldDynamic(
                                            fieldID,
                                            name,
                                            title,
                                            type,
                                            visibility,
                                            isRequired,
                                            canDelete,
                                            true,
                                            cssStyle,
                                            rowSpan,
                                            colSpan
                                    ));
                            break;
                    }
                }
                // این سلول ها را به لیست سطر ها اضافه میکنیم
                fieldDynamicRows.add(fieldDynamicCells);
            }
            // این سطر ها را به لیست کتگوری ها اضافه میکنیم
            fieldDynamicCtgs.add(fieldDynamicRows);
        }

        //************************************** ستون های گرید **************************************
        ArrayList<Col> cols = new ArrayList<>();
        // کلید اصلی - همواره ثابت است
        cols.add(new Col(null, "RecordID", "RecordID", Type.DECIMAL, 0, false, false, true));
        crmFormBuilders.sort(Comparator.comparing(CrmFormBuilder::getFieldGridPosition));
        for (CrmFormBuilder crmFormBuilder : crmFormBuilders) {
            BigDecimal fieldID = crmFormBuilder.getFieldID();
            String name = crmFormBuilder.getFieldName();
            String title = crmFormBuilder.getFieldTitle();
            Type type = intToType(crmFormBuilder.getFieldType().intValue());
            int width = crmFormBuilder.getFieldGridWidth();
            boolean visibility = crmFormBuilder.getVisibility() == null ? false : crmFormBuilder.getVisibility();
            boolean visibilityDefault = crmFormBuilder.getVisibility() == null ? false : crmFormBuilder.getVisibility();
            ;

            switch (type) {
                case QKEY:
                    // اگر این فیلد کیوکی است باید ستون دسک هم اضافه شود
                    CrmQKeyMapField crmQKeyMapField = crmQKeyMapFieldRepository.crmShowQKeyMapFieldByFieldID(fieldID);
                    // ستون آی دی کیوکی
                    cols.add(new Col(fieldID, name, name, Type.DECIMAL, 0, false, false, false));
                    // ستون شرح کیوکی
                    String nameDesc = name.replaceFirst("FieldName", crmQKeyMapField.getDescName());
                    cols.add(new Col(fieldID, nameDesc, title, Type.STRING, width, visibility, visibilityDefault, false));
                    break;
                case REFERTO:
                    // اگر این فیلد ارجاع به است باید ستون دسک هم اضافه شود
                    // ستون آی دی ارجاع به
                    cols.add(new Col(fieldID, name, name, Type.DECIMAL, 0, false, false, false));
                    // ستون شرح ارجاع به
                    String referToDesc = name.replaceFirst("FieldName", "PercomName");
                    cols.add(new Col(fieldID, referToDesc, title, Type.STRING, width, visibility, visibilityDefault, false));
                    break;
                default:
                    cols.add(new Col(fieldID, name, title, type, width, visibility, visibilityDefault, false));
                    break;
            }
        }
        return new MetaDynamic(cols, ctgDynamics, fieldDynamicCtgs, dataEntryHeight);
    }

    default InputStreamResource reportPDF(
            Map<String, String> params,
            CrmFormBuilderRepository crmFormBuilderRepository,
            CrmQKeyMapFieldRepository crmQKeyMapFieldRepository) {
        BigDecimal formID = new BigDecimal(params.get("formID"));
        params.remove("formID");
        String pageFilter = pageFilter(formID, params, crmFormBuilderRepository, crmQKeyMapFieldRepository);
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("FormID", formID));
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("PageFilter", pageFilter));
        HashMap<String, Object> parameterFields = new HashMap();
        return exportCrystalReportToPDF(CrmFormFieldValue.class, "formFieldValues", parameterFields, tParameters, ShowSPReturnType.MAP);
    }

    default InputStreamResource excel(
            Map<String, String> params,
            CrmFormBuilderRepository crmFormBuilderRepository,
            CrmSelectorRepository crmSelectorRepository,
            CrmFormRepository crmFormRepository,
            CrmQKeyMapFieldRepository crmQKeyMapFieldRepository) {
        BigDecimal formID = new BigDecimal(params.get("formID"));
        params.remove("formID");
        String pageFilter = pageFilter(formID, params, crmFormBuilderRepository, crmQKeyMapFieldRepository);
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("FormID", formID));
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("PageFilter", pageFilter));
        List<Map<String, Object>> rows = execSPNativeQuery(CrmFormFieldValue.class, "CrmShowFormFieldValue", tParameters, ShowSPReturnType.MAP);
        return exportToExcel(convertCommaValuesToTChips(rows, formID, crmFormBuilderRepository, crmSelectorRepository), meta(formID, crmFormBuilderRepository, crmFormRepository, crmQKeyMapFieldRepository).getCols(), "فرصت ها");
    }

    default List<Map<String, Object>> convertCommaValuesToTChips(
            List<Map<String, Object>> rows,
            BigDecimal formID,
            CrmFormBuilderRepository crmFormBuilderRepository,
            CrmSelectorRepository crmSelectorRepository
    ) {
        List<CrmFormBuilder> crmFormBuilders = crmFormBuilderRepository.crmShowFormBuilderByFormID(formID);
        List<CrmFormBuilder> fieldsSelec<tor = crmFormBuilders.stream()
                .filter(cffv -> cffv.getFieldType().intValue() == 6)
                .collect(Collectors.toList());

        HashMap<String, List<CrmSelector>> crmSelectorsMap = new HashMap();
        for (CrmFormBuilder fieldSelector : fieldsSelector) {
            List<CrmSelector> crmSelectors = crmSelectorRepository.crmShowSelectorByFieldID(fieldSelector.getFieldID());
            crmSelectorsMap.put(fieldSelector.getFieldName(), crmSelectors);
            // در اینجا میدانیم فیلد های از جنس سلکتور این گرید چه مقادیر و رنگ هایی میتوانند داشته باشند
        }

        // کد های زیر تک تک سلکتور ها را به صورت لیستی از مقدار و رنگ به فیلد مربوطه اضافه میکند
        for (Map<String, Object> row :
                rows) {
            for (Map.Entry<String, List<CrmSelector>> crmSelectorMap : crmSelectorsMap.entrySet()) {
                String selectorIDsByComma = (String) row.get(crmSelectorMap.getKey());
                if (selectorIDsByComma == null) {
                    continue;
                }
                List<TChip> tChips = new ArrayList();
                for (String selectorID : selectorIDsByComma.split(",")) {
                    CrmSelector crmSelector = crmSelectorMap.getValue().stream()
                            .filter(cs -> cs.getSelectorID().toString().equals(selectorID))
                            .findAny()
                            .orElse(null);

                    if (crmSelector != null) {
                        TChip tChip = new TChip();
                        tChip.setId(crmSelector.getSelectorID());
                        tChip.setColor(crmSelector.getColor());
                        tChip.setValue(crmSelector.getSelectorValue());
                        tChips.add(tChip);
                    }
                }
                row.put(crmSelectorMap.getKey(), tChips);
            }
        }
        return rows;
    }
}
