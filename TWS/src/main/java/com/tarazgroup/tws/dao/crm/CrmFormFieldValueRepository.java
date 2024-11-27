package com.tarazgroup.tws.dao.crm;

import com.tarazgroup.tws.dao.ShowSPReturnType;
import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.crm.*;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.DynamicFields;
import com.tarazgroup.tws.util.global.TChip;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.repository.CrudRepository;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

/**
 * 9/11/22
 *
 * @author Erfan Akhavan
 */
public interface CrmFormFieldValueRepository extends TCrudRepository<CrmFormFieldValue>, CrudRepository<CrmFormFieldValue, BigDecimal> {


    default List<Map<String, Object>> crmShowFormFieldValue(BigDecimal formID, CrmFormFieldValue crmFormFieldValue) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();

        tParameters.add(new TParameter<>("FormID", formID));
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("PageFilter", crmFormFieldValue._pageFilter()));
//        tParameters.add(new TParameter<>("PageFilter", crmFormFieldValue._pageFilterAk()));
//        tParameters.add(new TParameter<>("PageFilter", " ?" + tktTicket.getPageNumber() + "," + tktTicket.getRecordCount() + "? "));

        tParameters.add(new TParameter<>("ServerFilter", crmFormFieldValue._serverFilter()));
        List<Map<String, Object>> rows = execSPNativeQuery(CrmFormFieldValue.class, "CrmShowFormFieldValue", tParameters, ShowSPReturnType.MAP);
        return rows;
    }

    default List<Map<String, Object>> crmShowFormFieldValueNew(BigDecimal formID, CrmFormFieldValue crmFormFieldValue, ArrayList<String> names, ArrayList<String> values, ArrayList<Integer> types) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();

        tParameters.add(new TParameter<>("FormID", formID));
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
//        tParameters.add(new TParameter<>("PageFilter", crmFormFieldValue._pageFilter()));
        if (names.size() > 0 && values.size() > 0 && types.size() > 0)
            tParameters.add(new TParameter<>("PageFilter", crmFormFieldValue._pageFilterAK3(names, values, types)));
        tParameters.add(new TParameter<>("PageFilter", null));
//        tParameters.add(new TParameter<>("PageFilter", crmFormFieldValue._pageFilter()));
//        tParameters.add(new TParameter<>("PageFilter", " ?" + tktTicket.getPageNumber() + "," + tktTicket.getRecordCount() + "? "));
        tParameters.add(new TParameter<>("ServerFilter", crmFormFieldValue._serverFilter()));
        List<Map<String, Object>> rows = execSPNativeQuery(CrmFormFieldValue.class, "CrmShowFormFieldValue", tParameters, ShowSPReturnType.MAP);
        return rows;
    }


    default List<Map<String, Object>> crmShowFormFieldValueNewArchive(BigDecimal formID, CrmFormFieldValue crmFormFieldValue, String queryParams, List<CrmFormBuilder> crmFormBuilderList, ArrayList<Integer> types33) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
//        System.out.println("httpServletRequest.getQueryString() " + queryParams);

//        for (int i = 0; i < types33.size(); i++) {
//            System.out.println("AWDAWDAWDADADAWDAWDAWDAWD " + types33.get(i));
//        }
        System.out.println();
//meta();
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> names2 = new ArrayList<>();


        ArrayList<String> names3 = new ArrayList<>();
        ArrayList<String> values3 = new ArrayList<String>();
        ArrayList<String> types3 = new ArrayList<String>();
//        List<String> values3 = new ArrayList<String>();


        ArrayList<Type> types = new ArrayList<>();
//        ArrayList<String> values = new ArrayList<>();
//        ArrayList<String> values2 = new ArrayList<>();
//        ArrayList<String> values3 = new ArrayList<>();


//        String[] out = queryParams.split("&");
//        int size = out.length;
//
//        for (int i = 0; i < size; i++) {
//            values.add(queryParams.split("&"));
//        }

        List<String> list = new ArrayList<String>(Arrays.asList(queryParams.split("&")));

        String[] split;

        for (int i = 0; i < list.size(); i++) {
//            System.out.println("list.get(i) " + list.get(i));
//            System.out.println();
        }

//        System.out.println();
//        System.out.println("WELCOME TO SECOND LOOP");

        List<String> values = new ArrayList<String>();
//        StringBuilder trimmed = new StringBuilder();
//        StringBuilder trimmed = new StringBuilder(new String());

        for (int i = 0; i < list.size(); i++) {
//            trimmed.append(list.get(i));
//            trimmed = trimmed + list.get(i).toString();
//            trimmed.append(list.get(i).toString());
//            List<String> list3 = new ArrayList<String>(Collections.singletonList(list.toString().substring(list.get(i).lastIndexOf("=") + 1)));
            values.add(list.get(i).substring(list.get(i).lastIndexOf("=") + 1));
//                        System.out.println("HEYYYYYYYYYYYYYYYYYYYYYYYY " + Arrays.toString(list.get(i).split("=")));
            names2.add(list.get(i));
            split = names2.get(i).toString().split("=");
//            System.out.println("names2 " + names2.get(i));
//            System.out.println();
//            System.out.println("split[0] " + split[0]);
//            System.out.println("split[1] " + split[1]);
            names3.add(split[0]);
            values3.add(split[1]);

//            System.out.println("split[0] " +split[2]);
//         names2.add(list.get(i)..split("=")));
//
//list.get(i).split("=");
//            System.out.println("HEYYYYYYYYYYYYYYYYY " + names2.get(i));

//            System.out.println();
//            System.out.println("values.get(i) " + values.get(i));
//            System.out.println("split.length " + split.length);
        }
//        System.out.println("The trimmed list is: " + trimmed);

//        for (int i = 0; i < crmFormBuilderList.size(); i++) {
//            if (Objects.equals(crmFormBuilderList.get(i).getFieldName(), names3.get(i))) {
//                types3.add(crmFormBuilderList.get(i).getFieldName());
//            }
//
//        }
//
//
//        for (int i = 0; i < types3.size(); i++) {
//            System.out.println("TYPES ARE " + types3.get(i).toString());
//        }

        //
//        System.out.println();
//        System.out.println("WELCOME TO THIRD LOOP");
//        for (int i = 0; i < list.size(); i++) {
////            System.out.println("list.get(i) " + list3.get(i));
////            System.out.println("list.get(i) " + list2.get(i));
//            System.out.println();
//        }


//        String[] outTrimmed = new String[out.length];
//        for (int i = 0; i < out.length; i++) {
//            outTrimmed[i] = String.valueOf(out[i].split("="));
//            values.add(String.valueOf(out[i].split("=")));
//            System.out.println("HEYYYYYYYYYYYYYYYYYYYYYYYY " + Arrays.toString(out[i].split("=")));
//            System.out.println("efsefssfsefsefesfef "+values.get(i));
//        }

//        for (int i = 0; i < out.length; i++) {
//            System.out.println("Concated Value is: ");
//            if (i <= out.length)
//            System.out.println(out[i] += out[i + 1]);
////            System.out.println(out[i] += out[i + 1]);
//
//        }

//        String path = "/abc/def/ghfj.doc";
//// Split path into segments
//        String segments[] = path.split("/");
//// Grab the last segment
//        String document = segments[segments.length - 1];


//        final Type type = intToType(crmFormBuilderList.get(i).getFieldType());
        for (int i = 0; i < names3.size(); i++) {
//            System.out.println("FINAL NAMES ARE " + names3.get(i));
//            System.out.println("FINAL VALUES ARE " + values3.get(i));
        }

        for (int i = 0; i < crmFormBuilderList.size(); i++) {
//            System.out.println(crmFormBuilderList.get(i).getFieldName());
//            System.out.println(crmFormBuilderList.get(i).getFieldType());


            final Type type = intToType(crmFormBuilderList.get(i).getFieldType());
            types.add(type);
            names.add(crmFormBuilderList.get(i).getFieldName());

        }


        tParameters.add(new TParameter<>("FormID", formID));
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("PageFilter", crmFormFieldValue._pageFilter()));
//        tParameters.add(new TParameter<>("PageFilter", crmFormFieldValue._pageFilterAk()));
//        tParameters.add(new TParameter<>("PageFilter", " ?" + tktTicket.getPageNumber() + "," + tktTicket.getRecordCount() + "? "));

        tParameters.add(new TParameter<>("ServerFilter", crmFormFieldValue._serverFilter()));
        List<Map<String, Object>> rows = execSPNativeQuery(CrmFormFieldValue.class, "CrmShowFormFieldValue", tParameters, ShowSPReturnType.MAP);
        return rows;
    }


    default List<Map<String, Object>> crmShowFormFieldValueWithString(BigDecimal formID, String crmFormFieldValue) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();

        tParameters.add(new TParameter<>("FormID", formID));
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("PageFilter", crmFormFieldValue));
//        tParameters.add(new TParameter<>("PageFilter", crmFormFieldValue._pageFilterAk()));
//        tParameters.add(new TParameter<>("PageFilter", " ?" + tktTicket.getPageNumber() + "," + tktTicket.getRecordCount() + "? "));

        tParameters.add(new TParameter<>("ServerFilter", crmFormFieldValue));
        List<Map<String, Object>> rows = execSPNativeQuery(CrmFormFieldValue.class, "CrmShowFormFieldValue", tParameters, ShowSPReturnType.MAP);
        return rows;
    }


    default List<Map<String, Object>> crmShowFormFieldValueWithPageFilter(BigDecimal formID, CrmFormFieldValue crmFormFieldValue, List<CrmFormBuilder> crmFormBuilderList) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
//        String pageFilter = pageFilter(formID, params, crmFormBuilderRepository, crmQKeyMapFieldRepository);

        ArrayList<String> names = new ArrayList<>();
        ArrayList<Type> types = new ArrayList<>();

//        final Type type = intToType(crmFormBuilderList.get(i).getFieldType());


        for (int i = 0; i < crmFormBuilderList.size(); i++) {
            System.out.println(crmFormBuilderList.get(i).getFieldName());
            System.out.println(crmFormBuilderList.get(i).getFieldType());


            final Type type = intToType(crmFormBuilderList.get(i).getFieldType());
            types.add(type);
            names.add(crmFormBuilderList.get(i).getFieldName());


        }


        tParameters.add(new TParameter<>("FormID", formID));
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
//        tParameters.add(new TParameter<>("PageFilter", crmFormFieldValue._pageFilterAk(names, types)));
        tParameters.add(new TParameter<>("PageFilter", crmFormFieldValue._pageFilter()));
//        tParameters.add(new TParameter<>("PageFilter", " ?" + tktTicket.getPageNumber() + "," + tktTicket.getRecordCount() + "? "));

        tParameters.add(new TParameter<>("ServerFilter", crmFormFieldValue._serverFilter()));
        List<Map<String, Object>> rows = execSPNativeQuery(CrmFormFieldValue.class, "CrmShowFormFieldValue", tParameters, ShowSPReturnType.MAP);
        return rows;
    }

    default List<Map<String, Object>> crmShowFormFieldValueMajidi(
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

    default List<Map<String, Object>> convertCommaValuesToTChips(
            List<Map<String, Object>> rows,
            BigDecimal formID,
            CrmFormBuilderRepository crmFormBuilderRepository,
            CrmSelectorRepository crmSelectorRepository
    ) {
        List<CrmFormBuilder> crmFormBuilders = crmFormBuilderRepository.crmShowFormBuilderByFormID(formID);
        List<CrmFormBuilder> fieldsSelector = crmFormBuilders.stream()
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


    default List<Map<String, Object>> crmShowFormFieldValueByID(BigDecimal formID, BigDecimal recordID, CrmFormFieldValue crmFormFieldValue) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();

        tParameters.add(new TParameter<>("FormID", formID));
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("PageFilter", "And main.recordID = " + recordID + "?,?"));
        tParameters.add(new TParameter<>("ServerFilter", crmFormFieldValue._serverFilter()));

        List<Map<String, Object>> rows = execSPNativeQuery(CrmFormFieldValue.class, "CrmShowFormFieldValue", tParameters, ShowSPReturnType.MAP);

        List<Map<String, Object>> rows2 = rows;
        if (!rows2.isEmpty()) {
            for (int i = 0; i < rows2.size(); i++) {
                return rows2;
            }
        } else {
            throw new RuntimeException(formID.toString());
        }
        return null;
    }

    default Map<String, Object> crmShowFormFieldValueByIDObject(BigDecimal formID, BigDecimal recordID, CrmFormFieldValue crmFormFieldValue) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();

        tParameters.add(new TParameter<>("FormID", formID));
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("PageFilter", "And main.recordID = " + recordID + "?,?"));
        tParameters.add(new TParameter<>("ServerFilter", crmFormFieldValue._serverFilter()));

        List<Map<String, Object>> rows = execSPNativeQuery(CrmFormFieldValue.class, "CrmShowFormFieldValue", tParameters, ShowSPReturnType.MAP);
        return rows.get(0);
    }


    default List<Map<String, Object>> crmInsFormFieldValueWithRecordID(BigDecimal formId,
                                                                       CrmFormFieldValueWithMulti crmFormFieldValueWithMulti) {

        final BigDecimal lastRecordId = lastRecordId(formId);
        System.out.println("LastRecordID " + lastRecordId.toString());
        BigDecimal lastRecordIdWithOne = lastRecordId.add(BigDecimal.valueOf(1));
//        crmFormFieldValueWithMulti.setHeader().setRecordID(lastRecordIdWithOne);
        List<CrmFormFieldValueTypeAk> crmFormFieldValueTypeAkList = crmFormFieldValueWithMulti.getDetails();
        List<CrmFormFieldValueTypeAk> crmFormFieldValueTypes = new ArrayList<>();
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();

        for (int i = 0; i < crmFormFieldValueTypeAkList.size(); i++) {
            CrmFormFieldValueTypeAk crmFormFieldValueType = new CrmFormFieldValueTypeAk();
            crmFormFieldValueType.setFieldID(crmFormFieldValueTypeAkList.get(i).getFieldID());
            crmFormFieldValueType.setFieldValue(crmFormFieldValueTypeAkList.get(i).getFieldValue());
            crmFormFieldValueType.setValueID(null);
            crmFormFieldValueTypes.add(crmFormFieldValueType);
        }


        tParameters.add(new TParameter<>("RecordID", null));
        tParameters.add(new TParameter<>("NewRecordID", lastRecordIdWithOne));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("TValue", crmFormFieldValueTypes));

        ArrayList<BigDecimal> arrayList = new ArrayList<>();
        arrayList = execSPNativeQueryAk(CrmFormFieldValue.class, "CrmInsUpdFormFieldValueweb", tParameters);

        CrmFormFieldValue crmFormFieldValue = new CrmFormFieldValue();
        return crmShowFormFieldValueByID(arrayList.get(1), arrayList.get(0), crmFormFieldValue);
    }


    default List<Map<String, Object>> crmInsFormFieldValueWithRecordIDStaticForms(BigDecimal formId,
                                                                                  CrmFormFieldValueWithMulti crmFormFieldValueWithMulti) {

        final BigDecimal lastRecordId = lastRecordId(formId);
        BigDecimal lastRecordIdWithOne = lastRecordId.add(BigDecimal.valueOf(1));
//        crmFormFieldValueWithMulti.setHeader().setRecordID(lastRecordIdWithOne);
        List<CrmFormFieldValueTypeAk> crmFormFieldValueTypeAkList = crmFormFieldValueWithMulti.getDetails();
        List<CrmFormFieldValueTypeAk> crmFormFieldValueTypes = new ArrayList<>();
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();

        for (int i = 0; i < crmFormFieldValueTypeAkList.size(); i++) {
            CrmFormFieldValueTypeAk crmFormFieldValueType = new CrmFormFieldValueTypeAk();
            crmFormFieldValueType.setFieldID(crmFormFieldValueTypeAkList.get(i).getFieldID());
            crmFormFieldValueType.setFieldValue(crmFormFieldValueTypeAkList.get(i).getFieldValue());
            crmFormFieldValueType.setValueID(null);
            crmFormFieldValueTypes.add(crmFormFieldValueType);
        }


        tParameters.add(new TParameter<>("RecordID", lastRecordIdWithOne));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("TValue", crmFormFieldValueTypes));

        ArrayList<BigDecimal> arrayList = new ArrayList<>();
        arrayList = execSPNativeQueryAk2(CrmFormFieldValue.class, "CrmInsUpdFormFieldValueweb", tParameters);

        CrmFormFieldValue crmFormFieldValue = new CrmFormFieldValue();
        return crmShowFormFieldValueByID(arrayList.get(1), arrayList.get(0), crmFormFieldValue);
    }

//    default List<Map<String, Object>> crmUpdFormFieldValueWithRecordID(BigDecimal formId, BigDecimal recordId,
//                                                                       CrmFormFieldValueWithMulti crmFormFieldValueWithMulti) {
//
//        List<CrmFormFieldValueTypeAk> crmFormFieldValueTypeAkList = crmFormFieldValueWithMulti.getDetails();
//        List<CrmFormFieldValueTypeAk> crmFormFieldValueTypes = new ArrayList<>();
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        LogLogins logLogins = fetchUserDetail();
//
//        for (int i = 0; i < crmFormFieldValueTypeAkList.size(); i++) {
//            CrmFormFieldValueTypeAk crmFormFieldValueType = new CrmFormFieldValueTypeAk();
//            crmFormFieldValueType.setFieldID(crmFormFieldValueTypeAkList.get(i).getFieldID());
//            crmFormFieldValueType.setFieldValue(crmFormFieldValueTypeAkList.get(i).getFieldValue());
//            crmFormFieldValueType.setValueID(null);
//            crmFormFieldValueTypes.add(crmFormFieldValueType);
//        }
//
//
//        tParameters.add(new TParameter<>("RecordID", lastRecordIdUpd(formId, recordId)));
//        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
//        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
//        tParameters.add(new TParameter<>("TValue", crmFormFieldValueTypes));
//
//        ArrayList<BigDecimal> arrayList = new ArrayList<>();
//        arrayList = execSPNativeQueryAk(CrmFormFieldValue.class, "CrmInsUpdFormFieldValueweb", tParameters);
//
//        CrmFormFieldValue crmFormFieldValue = new CrmFormFieldValue();
//        return crmShowFormFieldValueByID(arrayList.get(1), arrayList.get(0), crmFormFieldValue);
//    }

    default Map<String, Object> crmUpdFormFieldValueWithRecordID(BigDecimal formId, BigDecimal recordId,
                                                                 CrmFormFieldValueWithMulti crmFormFieldValueWithMulti) {


        List<CrmFormFieldValueTypeAk> crmFormFieldValueTypeAkList = crmFormFieldValueWithMulti.getDetails();
        List<CrmFormFieldValueTypeAk> crmFormFieldValueTypes = new ArrayList<>();
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();

        for (int i = 0; i < crmFormFieldValueTypeAkList.size(); i++) {
            CrmFormFieldValueTypeAk crmFormFieldValueType = new CrmFormFieldValueTypeAk();
            crmFormFieldValueType.setFieldID(crmFormFieldValueTypeAkList.get(i).getFieldID());
            crmFormFieldValueType.setFieldValue(crmFormFieldValueTypeAkList.get(i).getFieldValue());
            crmFormFieldValueType.setValueID(null);
            crmFormFieldValueTypes.add(crmFormFieldValueType);
        }


        tParameters.add(new TParameter<>("RecordID", recordId));
        tParameters.add(new TParameter<>("NewRecordID", null));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("TValue", crmFormFieldValueTypes));

        ArrayList<BigDecimal> arrayList = new ArrayList<>();
        arrayList = execSPNativeQueryAk(CrmFormFieldValue.class, "CrmInsUpdFormFieldValueweb", tParameters);

        CrmFormFieldValue crmFormFieldValue = new CrmFormFieldValue();
//        return crmShowFormFieldValueByID(arrayList.get(1), arrayList.get(0), crmFormFieldValue);
        return crmShowFormFieldValueByIDObject(formId, recordId, crmFormFieldValue);
    }

    default void crmDelFormFieldValue(BigDecimal formID, BigDecimal recordID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("RecordID", recordID));
        tParameters.add(new TParameter<>("FormID", formID));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getModifierID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("CrmDelFormFieldValue", tParameters);
    }


    default Meta metaAlpha(BigDecimal formID, CrmFormFieldValue crmFormFieldValue, List<CrmFormBuilder> crmFormBuilderList, List<CrmFormBuilder> crmCategoryList, List<CrmFormBuilder> crmFormBuilderListForEmptyForms) {
        final Map<String, Object> stringObjectMap = crmShowFormFieldValue(formID, crmFormFieldValue).get(0);
        ArrayList<Col> cols = new ArrayList<>();
        ArrayList<String> keys = new ArrayList<>();
        ArrayList<String> keysWithOriginal = new ArrayList<>();
        ArrayList<Type> types = new ArrayList<>();
        ArrayList<String> titles = new ArrayList<>();
        ArrayList<String> titles2 = new ArrayList<>();
        ArrayList<String> filedCategories = new ArrayList<>();
        stringObjectMap.remove("RecordID");
        stringObjectMap.keySet().remove("RecordID");

        keysWithOriginal.addAll(stringObjectMap.keySet());

        for (int i = 0; i < crmFormBuilderListForEmptyForms.size(); i++) {
            crmFormBuilderListForEmptyForms.get(i).getFormName();
            crmFormBuilderListForEmptyForms.get(i).getCategoryName();
            System.out.println("HEYYYYYYYYYYYYYYYY" + crmFormBuilderListForEmptyForms.get(i).getCategoryName().toString());
            System.out.println("HEYYYYYYYYYYYYYYYY" + crmFormBuilderListForEmptyForms.get(i).getFormName().toString());


        }

        for (int i = 0; i < crmFormBuilderList.size(); i++) {
            System.out.println("In crmFormBuilderList loop is " + crmFormBuilderList.get(i).getFieldTitle());
        }

        for (int i = 0; i < crmFormBuilderList.size(); i++) {
            final Integer fieldType = crmFormBuilderList.get(i).getFieldType();
            final CrmFormBuilder crmFormBuilder = crmFormBuilderList.get(i);
            final Type type = intToType(crmFormBuilderList.get(i).getFieldType());
            titles.add(crmFormBuilderList.get(i).getFieldTitle());
            titles2.add(crmFormBuilderList.get(i).getFieldName());
            types.add(type);

//            System.out.println("Number " + i + " is " + crmFormBuilderList.get(i).getFieldID());
//            System.out.println("Number " + i + " is " + crmFormBuilderList.get(i).getFieldName());
//            System.out.println("Number " + i + " is " + crmFormBuilderList.get(i).getFieldType());
//            System.out.println("Number " + i + " is " + crmFormBuilderList.get(i).getFormID());
//            System.out.println("Number " + i + " is " + crmFormBuilderList.get(i).getFieldTitle());
//            System.out.println("Number " + i + " is " + crmFormBuilderList.get(i).getFormName());

            if (Objects.equals(crmCategoryList.get(i).getFieldID().toString(), crmFormBuilderList.get(i).getFieldID().toString())) {
//                System.out.println(crmCategoryList.get(i).getFieldID().toString() + " Equals " + crmFormBuilderList.get(i).getFieldName());
                filedCategories.add(crmCategoryList.get(i).getCategoryID().toString());
                System.out.println("crmCategoryList is: " + crmCategoryList.get(i).getCategoryID().toString());
                System.out.println();
            } else {
                System.out.println();
                System.out.println(crmCategoryList.get(i).getFieldID().toString() + " Doesn't equal " + crmFormBuilderList.get(i).getFieldName());
            }
        }
        cols.add(new Col(null, "RecordID", "RecordID", Type.DECIMAL, 0, false, false, true));
        for (int i = 0; i < stringObjectMap.keySet().size(); i++) {
            cols.add(new Col(null, titles2.get(i), titles.get(i), types.get(i), 150, true, true, false, filedCategories.get(i)));
        }

        return new Meta(cols);
    }


    default Meta metaTesting(BigDecimal formID, CrmFormFieldValue crmFormFieldValue, List<CrmFormBuilder> crmFormBuilderList, List<CrmFormBuilder> crmCategoryList, List<CrmFormBuilder> crmFormBuilderListForEmptyForms) {
//        final Map<String, Object> stringObjectMap = crmShowFormFieldValue(formID, crmFormFieldValue).get(0);
//        ArrayList<Col> cols = new ArrayList<>();
//        ArrayList<String> keys = new ArrayList<>();
//        ArrayList<String> keysWithOriginal = new ArrayList<>();
//        ArrayList<Type> types = new ArrayList<>();
//        ArrayList<String> titles = new ArrayList<>();
//        ArrayList<String> titles2 = new ArrayList<>();
//        ArrayList<String> filedCategories = new ArrayList<>();
//        stringObjectMap.remove("RecordID");
//        stringObjectMap.keySet().remove("RecordID");

//        keysWithOriginal.addAll(stringObjectMap.keySet());
        try {
            final Map<String, Object> stringObjectMap = crmShowFormFieldValue(formID, crmFormFieldValue).get(0);
            if (stringObjectMap.size() == 0) {
                System.out.println("NULL");
            } else {
                System.out.println("NOT NULL");
            }
        } catch (Exception e) {
//            System.out.println(e.toString());
            e.printStackTrace();
        }

        System.out.println("EWHKEFKJEFSKJEFSEKJFSEKJFSFKJFKJEFKSJFKJSEFSEKJFESJFKJSEJFSEJFSELJFESLFSEJFSEFSEF");

        System.out.println("crmFormBuilderListForEmptyForms.size()" + crmFormBuilderListForEmptyForms.size());
        System.out.println("crmFormBuilderList.size() " + crmFormBuilderList.size());
        for (int i = 0; i < crmFormBuilderListForEmptyForms.size(); i++) {
            crmFormBuilderListForEmptyForms.get(i).getFormName();
            crmFormBuilderListForEmptyForms.get(i).getCategoryName();
            System.out.println("HEYYYYYYYYYYYYYYYY " + crmFormBuilderListForEmptyForms.get(i).getCategoryName().toString());
            System.out.println("HEYYYYYYYYYYYYYYYY " + crmFormBuilderListForEmptyForms.get(i).getFormName().toString());
        }

        for (int i = 0; i < crmFormBuilderList.size(); i++) {
            System.out.println("In crmFormBuilderList loop is " + crmFormBuilderList.get(i).getFieldTitle());
        }


//        cols.add(new Col(null, "RecordID", "RecordID", Type.DECIMAL, 0, false, false, true));
//        for (int i = 0; i < stringObjectMap.keySet().size(); i++) {
//            cols.add(new Col(null, titles2.get(i), titles.get(i), types.get(i), 150, true, true, false, filedCategories.get(i)));
//        }

        return null;
    }


    default Meta meta(BigDecimal formID, CrmFormFieldValue crmFormFieldValue, List<CrmFormBuilder> crmFormBuilderList, List<CrmFormBuilder> crmCategoryList, List<CrmFormBuilder> crmFormBuilderListForEmptyForms) {
        ArrayList<Col> cols = new ArrayList<>();
//        ArrayList<String> keys = new ArrayList<>();
        ArrayList<String> keysWithOriginal = new ArrayList<>();
        ArrayList<Type> types = new ArrayList<>();
        ArrayList<String> titles = new ArrayList<>();
        ArrayList<String> titles2 = new ArrayList<>();
        ArrayList<String> filedCategories = new ArrayList<>();


        try {
            final Map<String, Object> stringObjectMap = crmShowFormFieldValue(formID, crmFormFieldValue).get(0);
            stringObjectMap.remove("RecordID");
            stringObjectMap.keySet().remove("RecordID");
            keysWithOriginal.addAll(stringObjectMap.keySet());


            for (int i = 0; i < crmFormBuilderList.size(); i++) {
//                final Integer fieldType = crmFormBuilderList.get(i).getFieldType();
//                final CrmFormBuilder crmFormBuilder = crmFormBuilderList.get(i);
                final Type type = intToType(crmFormBuilderList.get(i).getFieldType());
                titles.add(crmFormBuilderList.get(i).getFieldTitle());
                titles2.add(crmFormBuilderList.get(i).getFieldName());
                types.add(type);

                if (Objects.equals(crmCategoryList.get(i).getFieldID().toString(), crmFormBuilderList.get(i).getFieldID().toString())) {
                    filedCategories.add(crmCategoryList.get(i).getCategoryID().toString());
                }
            }
            cols.add(new Col(null, "RecordID", "RecordID", Type.DECIMAL, 0, false, false, true));
            for (int i = 0; i < stringObjectMap.keySet().size(); i++) {
                cols.add(new Col(null, titles2.get(i), titles.get(i), types.get(i), 150, true, true, false, filedCategories.get(i)));
            }
            return new Meta(cols);
        } catch (Exception e) {
//            System.out.println(e.toString());
            e.printStackTrace();
        }

        cols.add(new Col(null, "RecordID", "RecordID", Type.DECIMAL, 0, false, false, true));
//        System.out.println("crmFormBuilderListForEmptyForms.size() " + crmFormBuilderListForEmptyForms.size());
//        System.out.println("crmFormBuilderList.size()" + crmFormBuilderList.size());
        for (int i = 0; i < crmFormBuilderListForEmptyForms.size(); i++) {
            final Type type = intToType(crmFormBuilderList.get(i).getFieldType());
            types.add(type);

            if (Objects.equals(crmCategoryList.get(i).getFieldID().toString(), crmFormBuilderList.get(i).getFieldID().toString())) {
                filedCategories.add(crmCategoryList.get(i).getCategoryID().toString());
            }

            cols.add(new Col(null, crmFormBuilderList.get(i).getFieldName(), crmFormBuilderList.get(i).getFieldTitle(), types.get(i), 150, true, true, false, filedCategories.get(i)));
        }
        return new Meta(cols);

    }


    default BigDecimal lastRecordId(BigDecimal formId) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();

        tParameters.add(new TParameter<>("FormID", formId));
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("PageFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));

        BigDecimal lastRecordID;
        try {
            List<Map<String, Object>> rows = execSPNativeQuery(CrmFormFieldValue.class, "CrmShowFormFieldValue", tParameters, ShowSPReturnType.MAP);


            if (rows.size() > 0) {
                int rowsCount = rows.size() - 1;
                lastRecordID = (BigDecimal) rows.get(rowsCount).get("RecordID");
                return lastRecordID;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        lastRecordID = BigDecimal.valueOf(10000000);
//        else {
//            lastRecordID = BigDecimal.valueOf(10000000);
//        }

        return lastRecordID;
    }


    default String lastRecordIdUpd(BigDecimal formId, BigDecimal recordID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();

        tParameters.add(new TParameter<>("FormID", formId));
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("PageFilter", "And main.recordID = " + recordID + "?,?"));
        tParameters.add(new TParameter<>("ServerFilter", null));
        List<Map<String, Object>> rows = execSPNativeQuery(CrmFormFieldValue.class, "CrmShowFormFieldValue", tParameters, ShowSPReturnType.MAP);

        String recordID1 = rows.get(0).get("RecordID").toString();

//        int rowsCount = rows.size() - 1;
//        BigDecimal lastRecordID;
//        lastRecordID = recordID1;

        return recordID1;
    }


    static Type intToType(int fieldType) {
        //convert FieldType Integer Format To Type Enum
        switch (fieldType) {
            case 1:// String
                return Type.STRING;
            case 2:// Number
                return Type.DECIMAL;
            case 3:// Date Shamsi
                return Type.DATE;
            case 4:// TODO Time -> extend later
                return Type.TIME;
            case 5:// Boolean
                return Type.BOOLEAN;
            case 6:// Selector
                return Type.CHIP;
            case 7:// Memo / Text Area
                return Type.STRINGLONG;
            case 8:// Date Gregorian
                return Type.DATEG;
            case 9:// QKEY
                return Type.QKEY;
            case 10:// ارجاع به
                return Type.REFERTO;
            case 11: //فایل
                return Type.IMAGE;
            default:
                return null;
        }
    }


    /**
     * Testing block
     * Testing block
     * Testing block
     * Testing block
     * Testing block
     * Testing block
     * Testing block
     * Testing block
     */


//    default List<Map> fieldsName() {
//        return null;
//    }
//
//    default List<Map<String, Object>> crmShowFormFieldValueTest(BigDecimal formID, CrmFormFieldValue crmFormFieldValue) {
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        LogLogins logLogins = fetchUserDetail();
//
////        BigDecimal formID, userID;
////        formID = BigDecimal.valueOf(10000001);
////        userID = BigDecimal.valueOf(10000000);
//        tParameters.add(new TParameter<>("FormID", formID));
//        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
//        tParameters.add(new TParameter<>("PageFilter", crmFormFieldValue._pageFilter()));
//        tParameters.add(new TParameter<>("ServerFilter", crmFormFieldValue._serverFilter()));
////        return showSP("CrmShowFormFieldValue", tParameters, true);
//        List<Map<String, Object>> rows = execSPNativeQuery(CrmFormFieldValue.class, "CrmShowFormFieldValue", tParameters, ShowSPReturnType.MAP);
////        for (int i = 0; i < rows.size(); i++) {
//////            System.out.println(rows.get(i));
////        }
////        System.out.println(crmFormFieldValue.getRecordID());
////        CrmFormBuilderRepository crmFormBuilderRepository = null;
//
////        private final CrmFormBuilderRepository crmFormBuilderRepository;
////
////    public CrmFormBuilderController(CrmFormBuilderRepository crmFormBuilderRepository) {
////            this.crmFormBuilderRepository = crmFormBuilderRepository;
////        }
//
////        crmFormBuilderRepository.crmShowFormBuilderByFormID(formID);
////        System.out.println("Record id is: " + crmFormFieldValue1.getRecordID());
////        List<Map> allRecordsIds = new ArrayList<>();
////        for (int i = 0; i < rows.size(); i++) {
////            System.out.println(rows.get(i));
////            System.out.println(i);
////            allRecordsIds.add(rows.get(i));
////            System.out.println("Number " + i + " is " + allRecordsIds.get(i)
////            );
////            allRecordsIds.get(i);
////                allRecordsIds
////            String newshit = allRecordsIds.toString().substring(allRecordsIds.toString().indexOf("RecordID") + 3, allRecordsIds.size());
////            System.out.println(newshit);
////        }
//        return rows;
//    }


//    default List<Map<String, Object>> crmShowFormFieldValueTestByID(BigDecimal formID, BigDecimal recordID, CrmFormFieldValue crmFormFieldValue) {
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        LogLogins logLogins = fetchUserDetail();
//
////        BigDecimal formID, userID;
////        formID = BigDecimal.valueOf(10000001);
////        userID = BigDecimal.valueOf(10000000);
//        tParameters.add(new TParameter<>("FormID", formID));
//        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
//        tParameters.add(new TParameter<>("PageFilter", "And main.recordID = " + recordID + "?,?"));
//        tParameters.add(new TParameter<>("ServerFilter", crmFormFieldValue._serverFilter()));
////        return showSP("CrmShowFormFieldValue", tParameters, true);
//        List<Map<String, Object>> rows = execSPNativeQuery(CrmFormFieldValue.class, "CrmShowFormFieldValue", tParameters, ShowSPReturnType.MAP);
////        for (int i = 0; i < rows.size(); i++) {
//////            System.out.println(rows.get(i));
////        }
////        System.out.println(crmFormFieldValue.getRecordID());
////        CrmFormBuilderRepository crmFormBuilderRepository = null;
//
////        private final CrmFormBuilderRepository crmFormBuilderRepository;
////
////    public CrmFormBuilderController(CrmFormBuilderRepository crmFormBuilderRepository) {
////            this.crmFormBuilderRepository = crmFormBuilderRepository;
////        }
//
////        crmFormBuilderRepository.crmShowFormBuilderByFormID(formID);
////        for (int i = 0; i < rows.size(); i++) {
////            System.out.println(rows.get(i));
////            System.out.println(i);
////        }
//
//        List<Map<String, Object>> rows2 = rows;
//        for (int i = 0; i < rows2.size(); i++) {
//            return rows2;
////            break;
//        }
//        return null;
////        rows2.get(0).get(0);
////row
//
////        return rows2.;
//    }

    // Old classes which got edited list: TCrudRepositoryImpl, SQLServerDataRecordCrmFormFieldValueType, TParameter, CrmFormFieldValueType

//    default CrmFormFieldValueWithMulti crmInsFormFieldValueTest(
//            CrmFormFieldValueWithMulti crmFormFieldValueWithMulti) {
////        CrmFormFieldValueWithMulti crmFormFieldValueWithMulti = new CrmFormFieldValueWithMulti();
//        List<CrmFormFieldValueTypeAk> crmFormFieldValueTypeAkList = crmFormFieldValueWithMulti.getDetails();
//        List<CrmFormFieldValueTypeAk> crmFormFieldValueTypes = new ArrayList<>();
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        LogLogins logLogins = fetchUserDetail();
//
////        BigDecimal formID, userID;
////        formID = BigDecimal.valueOf(10000001);
////        userID = BigDecimal.valueOf(10000000);
////        formID = ;
//
//
//        for (int i = 0; i < crmFormFieldValueTypeAkList.size(); i++) {
//            CrmFormFieldValueTypeAk crmFormFieldValueType = new CrmFormFieldValueTypeAk();
//            crmFormFieldValueType.setFieldID(crmFormFieldValueTypeAkList.get(i).getFieldID());
//            crmFormFieldValueType.setFieldValue(crmFormFieldValueTypeAkList.get(i).getFieldValue());
//            crmFormFieldValueType.setValueID(null);
//            crmFormFieldValueTypes.add(crmFormFieldValueType);
//        }
//
//
//        tParameters.add(new TParameter<>("RecordID", crmFormFieldValueWithMulti.getHeader().getRecordID()));
//        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
//        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
//        tParameters.add(new TParameter<>("TValue", crmFormFieldValueTypes));
//
////        return null;
//
//        ResultErrMsgNewID resultErrMsgNewID = execSPNativeQuery(CrmFormFieldValue.class, "CrmInsUpdFormFieldValueweb", tParameters);
////return resultErrMsgNewID
//
//
//        System.out.println("newID is: " + resultErrMsgNewID.getNewID());
//
////        return crmShowFormFieldValueTestByID();
//        return null;
//    }
//
//    default List<Map<String, Object>> crmInsFormFieldValueTestDecimal(
//            CrmFormFieldValueWithMulti crmFormFieldValueWithMulti) {
////        CrmFormFieldValueWithMulti crmFormFieldValueWithMulti = new CrmFormFieldValueWithMulti();
//        List<CrmFormFieldValueTypeAk> crmFormFieldValueTypeAkList = crmFormFieldValueWithMulti.getDetails();
//        List<CrmFormFieldValueTypeAk> crmFormFieldValueTypes = new ArrayList<>();
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        LogLogins logLogins = fetchUserDetail();
//
////        BigDecimal formID, userID;
////        formID = BigDecimal.valueOf(10000001);
////        userID = BigDecimal.valueOf(10000000);
////        formID = ;
//
//
//        for (int i = 0; i < crmFormFieldValueTypeAkList.size(); i++) {
//            CrmFormFieldValueTypeAk crmFormFieldValueType = new CrmFormFieldValueTypeAk();
//            crmFormFieldValueType.setFieldID(crmFormFieldValueTypeAkList.get(i).getFieldID());
//            crmFormFieldValueType.setFieldValue(crmFormFieldValueTypeAkList.get(i).getFieldValue());
//            crmFormFieldValueType.setValueID(null);
//            crmFormFieldValueTypes.add(crmFormFieldValueType);
//        }
//
//
//        tParameters.add(new TParameter<>("RecordID", crmFormFieldValueWithMulti.getHeader().getRecordID()));
//        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
//        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
//        tParameters.add(new TParameter<>("TValue", crmFormFieldValueTypes));
//
////        System.out.println("OK");
////        return null;
//        ArrayList<BigDecimal> arrayList = new ArrayList<>();
//        arrayList = execSPNativeQueryAk(CrmFormFieldValue.class, "CrmInsUpdFormFieldValueweb", tParameters);
////return resultErrMsgNewID
//
//        System.out.println("arrayList was: " + arrayList.get(0));
//        for (int i = 0; i < arrayList.size(); i++) {
//            System.out.println("Number " + i + " is");
//
////            FieldName_10000098_10000021
////                    NULL
//            System.out.println("aaaaaaaa " + arrayList.get(i));
//        }
////        System.out.println("newID is: " + resultErrMsgNewID.getNewID());
//        CrmFormFieldValue crmFormFieldValue = new CrmFormFieldValue();
//        return crmShowFormFieldValueTestByID(arrayList.get(1), arrayList.get(0), crmFormFieldValue);
////        return null;
//    }
//
//    // START HERE ########################################################################################################################################
//    default List<Map<String, Object>> crmShowFormFieldValueTestByID2(BigDecimal formID, BigDecimal recordID, CrmFormFieldValue crmFormFieldValue, List<CrmFormBuilder> crmFormBuilderList) {
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        LogLogins logLogins = fetchUserDetail();
//        final List<Map<String, Object>> maps = crmShowFormFieldValue(formID, crmFormFieldValue);
//        ArrayList<String> titles = new ArrayList<>(); // NEW VALUE: Name
//        ArrayList<String> titlesKeyset = new ArrayList<>(); // OLD VALUE: FieldName_10000002_10000005
//        Map<Set<String>, Collection<Object>> valuesWithNewKeys = new HashMap<>();
//
//
//        tParameters.add(new TParameter<>("FormID", formID));
//        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
//        tParameters.add(new TParameter<>("PageFilter", "And main.recordID = " + recordID + "?,?"));
//        tParameters.add(new TParameter<>("ServerFilter", crmFormFieldValue._serverFilter()));
//        List<Map<String, Object>> rows = execSPNativeQuery(CrmFormFieldValue.class, "CrmShowFormFieldValue", tParameters, ShowSPReturnType.MAP);
//
//        List<Map<String, Object>> rows2 = rows;
//
//        for (int i = 0; i < crmFormBuilderList.size(); i++) {
//            titles.add(crmFormBuilderList.get(i).getFieldTitleLatin());
//            titles.get(i);
//        }
//
//        for (int i = 0; i < rows2.size(); i++) {
//            titlesKeyset.add(String.valueOf(rows2.get(i).keySet()));
//            titlesKeyset.get(i);
//        }
//
////        for (int i = 0; i < titles.size(); i++) {
//////            rows2.get(i).replace(String.valueOf(titlesKeyset.get(i)), rows.get(i).keySet(), titlesKeyset);
//////            System.out.println(rows2.get(i).replace(String.valueOf(titlesKeyset.get(i)), rows.get(i).keySet(), titlesKeyset));
////            rows2.get(i).remove(titlesKeyset);
////            int b = 13;
//////        }
////        for (int i = 0; i < rows.size(); i++) {
////            System.out.println("HERE");
////            rows2.get(i).keySet().remove(titlesKeyset.get(0));
////            System.out.println("HERE 2");
////            rows2.get(i).keySet().remove(titlesKeyset.get(i));
////            System.out.println("HERE 3");
////
////
////        }
//
////        for (int i = 0; i < titles.size(); i++) {
//////            rows2.get(i).replace(String.valueOf(titlesKeyset.get(i)), rows.get(i).keySet(), titlesKeyset);
//////            System.out.println(rows2.get(i).replace(String.valueOf(titlesKeyset.get(i)), rows.get(i).keySet(), titlesKeyset));
////            rows2.get(i).keySet().remove(i);
////            rows2.get(i).remove(titlesKeyset);
////            int b = 13;
////        }
//        int size2 = rows2.size();
//        System.out.println(size2);
//        for (int i = 0; i < rows2.size(); i++) {
//            rows2.get(i).keySet().remove(titles);
//            rows2.get(i).keySet().remove(titlesKeyset);
//
//            final Set<String> strings = rows2.get(i).keySet();
//            rows2.get(i).remove(strings);
//
////            System.out.println("HERE 1");
//            rows2.get(i).keySet().removeAll(titles);
//            titles.forEach(rows2.get(i).keySet()::remove);
////            System.out.println(rows2.get(i).keySet());
////            System.out.println("HERE 2");
//            rows2.get(i).keySet().removeAll(titlesKeyset);
//            titlesKeyset.forEach(rows2.get(i).keySet()::remove);
////            System.out.println(rows2.get(i).keySet());
////            System.out.println("HERE 3");
////rows2.get(i).keySet(titles.get(i));
////rows2.get(i).keySet(titlesKeyset);
////            System.out.println("#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@ " + titles);
////            System.out.println(titlesKeyset);
////            System.out.println("Values are: " + rows2.get(i).get(rows2.get(i).keySet()));
//            System.out.println();
//            System.out.println("Values 2 are: " + rows2.get(i).keySet());
//            System.out.println();
//            System.out.println("Values 3 are: " + rows2.get(i).values()); // *** RETURNS VALUES CORRECTLY
//            rows2.get(i).keySet().removeAll(rows2.get(i).keySet());
//            rows2.get(i).get(rows2.get(i).keySet());
//            System.out.println();
//            System.out.println("KEY WERE:" + rows2.get(i));
//
//            Object obj = rows.get(i).remove(titlesKeyset);
//            rows2.get(i).put(String.valueOf(titles), obj);
//            System.out.println();
//            System.out.println("KEY SETS ARE NOW: " + rows2.get(i).keySet());
//
//        }
//
//        int size = rows2.size();
//        System.out.println(size);
//        for (int i = 0; i < rows2.size(); i++) {
//            valuesWithNewKeys.put(rows2.get(i).keySet(), rows2.get(i).values());
////            valuesWithNewKeys.put(rows2.get(i + 1).keySet(), rows2.get(i + 1).values());
////            valuesWithNewKeys.put(rows2.get(i + 2).keySet(), rows2.get(i + 2).values());
//        }
//
////            public static void printRandomMapKeyValueElement() {
////        map.put("A", 1);
////        map.put("B", 2);
////        map.put("C", 3);
////        map.put("D", 4);
////        map.put("E", 5);
////
////        Set<String> keySet = map.keySet();
////        List<String> keyList = new ArrayList<>(keySet);
////
////        int size = keyList.size();
////        int randIdx = new Random().nextInt(size);
////
////        String randomKey = keyList.get(randIdx);
////        Integer randomValue = map.get(randomKey);
////
////        System.out.println("key: " + randomKey + ", value: " + randomValue);
////    }
//
//
//        for (int i = 0; i < titlesKeyset.size(); i++) {
////            rows2.get(i).keySet(titles.get(i));
////            rows2.get(i).keySet().addAll(titles);
////            rows2.get(i).keySet().add(String.valueOf(titles.get(i)));
//
//            //            int iwa = 3;
//        }
//
////        for (int i = 0; i < crmFormBuilderList.size() - 1; i++) {
////            final String s = titles.get(i);
//////            rows2.get(i).keySet().add(titles.get(i));
////            rows2.get(i).replace(String.valueOf(titlesKeyset.get(i)), rows.get(i).keySet(), titlesKeyset);
////            System.out.println(rows2.get(i).replace(String.valueOf(titlesKeyset.get(i)), rows.get(i).keySet(), titlesKeyset));
////        }
//
//
//        for (int i = 0; i < rows2.size(); i++) {
//            System.out.println("TODAY IS A HOLLY DAY");
//            System.out.println(valuesWithNewKeys.toString());
////            return valuesWithNewKeys;
//            return rows2;
////            break;
//        }
//
//
//        return null;
////        rows2.get(0).get(0);
////row
//
////        return rows2.;
//    }
//
//    /////////////////////////////////////////////////////////////////////////////////////////////////
//    default List<Map<String, Object>> crmShowFormFieldValueTestByID3(BigDecimal formID, BigDecimal recordID, CrmFormFieldValue crmFormFieldValue, List<CrmFormBuilder> crmFormBuilderList) {
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        LogLogins logLogins = fetchUserDetail();
//        final List<Map<String, Object>> maps = crmShowFormFieldValue(formID, crmFormFieldValue);
//        ArrayList<String> titles = new ArrayList<>(); // NEW VALUE: Name
//        ArrayList<String> titlesKeyset = new ArrayList<>(); // OLD VALUE: FieldName_10000002_10000005
////        Map<Set<String>, Collection<Object>> valuesList = new HashMap<>();
//        ArrayList<String> valuesList = new ArrayList<>(); // NEW VALUE: Name
////        Map<Set<String>, Collection<Object>> valuesWithNewKeys = new HashMap<>();
//        Map<ArrayList<String>, ArrayList<String>> valuesWithNewKeys = new HashMap<>();
//
//
//        tParameters.add(new TParameter<>("FormID", formID));
//        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
//        tParameters.add(new TParameter<>("PageFilter", "And main.recordID = " + recordID + "?,?"));
//        tParameters.add(new TParameter<>("ServerFilter", crmFormFieldValue._serverFilter()));
//        List<Map<String, Object>> rows = execSPNativeQuery(CrmFormFieldValue.class, "CrmShowFormFieldValue", tParameters, ShowSPReturnType.MAP);
//
//        List<Map<String, Object>> rows2 = rows;
//
//        final Map<String, Object> stringObjectMap = crmShowFormFieldValue(formID, crmFormFieldValue).get(0);
//        System.out.println();
//
//        System.out.println(stringObjectMap);
//
//
//        // Get original titles
//        for (int i = 0; i < crmFormBuilderList.size(); i++) {
//            titles.add(crmFormBuilderList.get(i).getFieldTitleLatin());
////            titles.get(i);
//        }
//        System.out.println();
//
//        System.out.println("titles " + titles);
//
//        // Get original values
//        for (int i = 0; i < rows.size(); i++) {
//            rows2.get(i).values();
//            valuesList.add(String.valueOf(rows2.get(i).values()));
//            System.out.println();
//
//            System.out.println("Values " + rows2.get(i).values());
//        }
//
//        for (int i = 0; i < rows2.size(); i++) {
//            valuesWithNewKeys.put(titles, valuesList);
//        }
//
//        for (int i = 0; i < rows2.size(); i++) {
//            System.out.println();
//            System.out.println("in for: " + valuesWithNewKeys.toString());
//        }
//        System.out.println();
//        System.out.println(valuesWithNewKeys);
//
//        return rows;
//    }

// END HERE ########################################################################################################################################


//
//    default CrmFormBuilder crmShowFormBuilderByFormID(BigDecimal formID) {
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter<>("Filter", " AND [Main].[FieldID] =" + fieldID));
//        tParameters.add(new TParameter<>("OtherFilter", null));
//        tParameters.add(new TParameter<>("ServerFilter", null));
//        tParameters.add(new TParameter<>("YearFilter", null));
//        tParameters.add(new TParameter<>("UserAccessFilter", null));
//        tParameters.add(new TParameter<>("PageFilter", null));
//        return showSP("CrmShowFormBuilder", tParameters, true).get(0);
//    }


//    default CrmFormFieldValueWithMulti crmShowFormFieldValue(
//            SaleVoucherHeaderRepository saleVoucherHeaderRepository,
//            SaleVoucherDetailLightRepository saleVoucherDetailLightRepository,
//            BigDecimal voucherHeaderID) {
//
//        SaleVoucherHeader saleVoucherHeader = saleVoucherHeaderRepository.saleShowVoucherHeaderByID(voucherHeaderID);
//        List<SaleVoucherDetailLight> saleVoucherDetailLights = saleVoucherDetailLightRepository.saleShowVoucherDetailLightByID(voucherHeaderID);
//        SaleVoucher saleVoucher = new SaleVoucher();
//        saleVoucher.setHeader(saleVoucherHeader);
//        saleVoucher.setDetails(saleVoucherDetailLights);
//        return saleVoucher;
//    }


//    default List<CrmFormFieldValue> crmShowFormFieldValue(CrmFormFieldValue crmFormFieldValue, BigDecimal formID, BigDecimal userID) {
//        List<TParameter<?>> tParameters = new ArrayList<>();
//
////        BigDecimal formID, userID;
////        formID = BigDecimal.valueOf(10000001);
////        userID = BigDecimal.valueOf(10000000);
//        tParameters.add(new TParameter<>("FormID", formID));
//        tParameters.add(new TParameter<>("UserID", userID));
//        tParameters.add(new TParameter<>("PageFilter", crmFormFieldValue._pageFilter()));
//        tParameters.add(new TParameter<>("ServerFilter", crmFormFieldValue._serverFilter()));
//        return showSP("CrmShowFormFieldValue", tParameters, true);
//    }
//
//    default CrmFormFieldValue crmShowFormFieldValueByID(BigDecimal campaignID) {
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter<>("Filter", " AND [Main].[CampaignID] = " + campaignID));
//        tParameters.add(new TParameter<>("OtherFilter", null));
//        tParameters.add(new TParameter<>("ServerFilter", null));
//        tParameters.add(new TParameter<>("YearFilter", null));
//        tParameters.add(new TParameter<>("UserAccessFilter", null));
//        tParameters.add(new TParameter<>("PageFilter", null));
//        return showSP("CrmShowCampaign", tParameters, true).get(0);
//    }
//
//
//    //    default Meta meta() {
//    default CrmFormFieldValue convert(BigDecimal campaignID) {
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter<>("Filter", " AND [Main].[CampaignID] = " + campaignID));
//        tParameters.add(new TParameter<>("OtherFilter", null));
//        tParameters.add(new TParameter<>("ServerFilter", null));
//        tParameters.add(new TParameter<>("YearFilter", null));
//        tParameters.add(new TParameter<>("UserAccessFilter", null));
//        tParameters.add(new TParameter<>("PageFilter", null));
//        return showSP("CrmShowCampaign", tParameters, true).get(0);
//    }
//        ArrayList<Col> cols = new ArrayList<>();
//        cols.add(new Col(null, "", "", Type.DECIMAL, 0, false, false, true));
//        cols.add(new Col(null, "", "", Type.DECIMAL, 100, true, true, false));
//        return new Meta(cols);
//    }


    /**
     * META SECTION
     * META SECTION
     * * META SECTION
     * * META SECTION
     * * META SECTION
     * META SECTION
     */
//    default Meta metaTest(BigDecimal formID, CrmFormFieldValue crmFormFieldValue, List<CrmFormBuilder> crmFormBuilderList) {
//        final List<Map<String, Object>> maps = crmShowFormFieldValue(formID, crmFormFieldValue);
//        final Map<String, Object> stringObjectMap = crmShowFormFieldValue(formID, crmFormFieldValue).get(0);
//        List<Map<String, Object>> cols = new ArrayList<>();
////        cols = maps.get();
////        for (int i = 0; i < maps.size(); i++) {
////            cols.set(i) = maps.get(i);
////        }
//        cols = Collections.singletonList(maps.get(1));
//
//
////        for (int i = 0; i < maps.size(); i++) {
////            System.out.println("Number: " + i);
////            System.out.println(maps.get(i));
////        }
//
////        System.out.println(stringObjectMap);
////        System.out.println(stringObjectMap.values());
////        final Object o = stringObjectMap.get(0);
//
////        System.out.println(stringObjectMap.entrySet().iterator());
//        //System.out.println(stringObjectMap.keySet()); // let me see
////        stringObjectMap.keySet().;
//
//        ArrayList<String> keys = new ArrayList<>();
//        for (String key : stringObjectMap.keySet()) {
//            int i = 0;
//            i++;
//            System.out.println(key);// let me see
////            key.split()
////            keys.add()
////        key.lastIndexOf("_")
//            keys.add(key.substring(key.lastIndexOf("_") + 1));
//
//
//        }
//
//
//        for (int i = 0; i < keys.size(); i++) {
//            System.out.println(keys.get(i));
//        }
//
//        for (int i = 0; i < crmFormBuilderList.size(); i++) {
////            Type type = new Type();
//            final Type type = intToType(crmFormBuilderList.get(i).getFieldType());
////            switch (crmFormBuilderList.get(i).getFieldType()) {
////                case 1:
//////                            cols.add((Map<String, Object>) new Col(null, "actuaryID", "actuaryID", Type.DECIMAL, 0, false, false, true));
////                case 2:
////                    intToType(2);
////                case 3:
////                    System.out.println("String **********************");
////                case 4:
////                    System.out.println("String **********************");
////                case 5:
////                    System.out.println("String **********************");
////                case 6:
////                    System.out.println("String **********************");
////                case 7:
////                    System.out.println("String **********************");
////                case 8:
////                    System.out.println("String **********************");
////                case 9:
////                    System.out.println("String **********************");
////                case 10:
////                    System.out.println("String **********************");
////
////            }
//            System.out.println(type);
////            ArrayList<Col> cols2 = new ArrayList<>();
////            cols2.add(new Col(null, "fieldType", "fieldType", Type.DECIMAL, 0, true, false, true));
////            cols2.add(new Col(null, ke, "fieldType", Type.DECIMAL, 0, true, false, true));
//
//
//        }
//
////        cols.add(new Col(null, "actuaryID", "actuaryID", Type.DECIMAL, 0, false, false, true));
////        cols.add(new Col(null, "actuaryCode", "کد", Type.STRING, 100, true, false, false));
////        return new Meta((ArrayList) cols);
//        return null;
//    }
//
//    default Meta meta2() {
//        ArrayList<Col> cols = new ArrayList<>();
//        cols.add(new Col(null, "fieldType", "fieldType", Type.DECIMAL, 0, true, false, true));
//        cols.add(new Col(null, "fieldTypeDesc", "fieldTypeDesc", Type.STRING, 0, true, false, false));
//        cols.add(new Col(null, "fieldTypeDescLatin", "fieldTypeDescLatin", Type.STRING, 0, true, false, false));
//        return new Meta(cols);
//    }
//
//    default Meta meta3(BigDecimal formID, CrmFormFieldValue crmFormFieldValue, List<CrmFormBuilder> crmFormBuilderList) {
//        final Map<String, Object> stringObjectMap = crmShowFormFieldValue(formID, crmFormFieldValue).get(0);
//        final Map<String, Object> stringObjectMap2 = crmShowFormFieldValue(formID, crmFormFieldValue).get(0);
//        final Map<String, Object> stringObjectMap3 = crmShowFormFieldValue(formID, crmFormFieldValue).get(0);
////String adwad = "sfesf";
////        final Object o = stringObjectMap.get(0);
////        stringObjectMap2.get(1);
////        stringObjectMap3.replace("RecordID",stringObjectMap2.get(1) = o;
//        ArrayList<Col> cols = new ArrayList<>();
//        ArrayList<String> keys = new ArrayList<>();
//        ArrayList<Type> types = new ArrayList<>();
//        ArrayList<String> titles = new ArrayList<>();
////        String key2 = "";
//        stringObjectMap.keySet().remove("RecordID");
//        for (String key : stringObjectMap.keySet()) {
//            int i = 0;
//            i++;
//            System.out.println(key);// let me see
//
//            keys.add(key.substring(key.lastIndexOf("_") + 1));
//
////            cols.add(new Col(null, key, key, Type.DECIMAL, 0, true, false, true));
//        }
//
//
//        for (int i = 0; i < keys.size(); i++) {
//            System.out.println(keys.get(i));
//        }
//
//        for (int i = 0; i < crmFormBuilderList.size(); i++) {
//            final Type type = intToType(crmFormBuilderList.get(i).getFieldType());
//            titles.add(crmFormBuilderList.get(i).getFieldTitleLatin());
//
//            System.out.println(type);
//            types.add(type);
//        }
//        cols.add(new Col(null, "RecordID", "RecordID", Type.DECIMAL, 0, false, false, true));
//        for (int i = 0; i < stringObjectMap.keySet().size(); i++) {
////            if (titles.get(i).equals("RecordID")) {
////                cols.add(new Col(null, titles.get(i), titles.get(i), types.get(i), 0, false, false, true));
////            }
//            cols.add(new Col(null, titles.get(i), titles.get(i), types.get(i), 0, true, true, false));
////            cols.add(new Col(null, titles.get(i), keys.get(i), types.get(i), 0, true, true, false));
//        }
//
//        return new Meta(cols);
//    }
//
//    default Meta metaWithNewField(BigDecimal formID, CrmFormFieldValue crmFormFieldValue, List<CrmFormBuilder> crmFormBuilderList) {
//        final Map<String, Object> stringObjectMap = crmShowFormFieldValue(formID, crmFormFieldValue).get(0);
//        ArrayList<Col> cols = new ArrayList<>();
//        ArrayList<String> keys = new ArrayList<>();
//        ArrayList<Type> types = new ArrayList<>();
//        ArrayList<String> titles = new ArrayList<>();
//        stringObjectMap.keySet().remove("RecordID");
//
//        for (String key : stringObjectMap.keySet()) {
//            keys.add(key.substring(key.lastIndexOf("_") + 1));
//
//        }
//
//        for (int i = 0; i < crmFormBuilderList.size(); i++) {
//            final Type type = intToType(crmFormBuilderList.get(i).getFieldType());
//            titles.add(crmFormBuilderList.get(i).getFieldTitleLatin());
//            types.add(type);
//        }
//        cols.add(new Col(null, "RecordID", "RecordID", Type.DECIMAL, 0, false, false, true));
//        for (int i = 0; i < stringObjectMap.keySet().size(); i++) {
//            cols.add(new Col(null, titles.get(i), titles.get(i), types.get(i), 0, true, true, false));
//        }
//
//        return new Meta(cols);
//    }
//
//
//    default Meta metaexample(BigDecimal formID, CrmFormFieldValue crmFormFieldValue, List<CrmFormBuilder> crmFormBuilderList) {
//        final Map<String, Object> stringObjectMap = crmShowFormFieldValue(formID, crmFormFieldValue).get(0);
//        ArrayList<Col> cols = new ArrayList<>();
//        ArrayList<String> keys = new ArrayList<>();
//        ArrayList<Type> types = new ArrayList<>();
//        ArrayList<String> titles = new ArrayList<>();
//        stringObjectMap.keySet().remove("RecordID");
//
//        for (String key : stringObjectMap.keySet()) {
//            keys.add(key.substring(key.lastIndexOf("_") + 1));
//
//        }
//
//        for (int i = 0; i < crmFormBuilderList.size(); i++) {
//            final Type type = intToType(crmFormBuilderList.get(i).getFieldType());
//            titles.add(crmFormBuilderList.get(i).getFieldTitleLatin());
//            types.add(type);
//        }
//        cols.add(new Col(null, "RecordID", "RecordID", Type.DECIMAL, 0, false, false, true));
//        for (int i = 0; i < stringObjectMap.keySet().size(); i++) {
//            cols.add(new Col(null, titles.get(i), titles.get(i), types.get(i), 0, true, true, false));
//        }
//
//        return new Meta(cols);
//    }
//
//
//    default Meta metaOriginalTest(BigDecimal formID, CrmFormFieldValue crmFormFieldValue, List<CrmFormBuilder> crmFormBuilderList) {
//        final Map<String, Object> stringObjectMap = crmShowFormFieldValue(formID, crmFormFieldValue).get(0);
//        ArrayList<Col> cols = new ArrayList<>();
//        ArrayList<String> keys = new ArrayList<>();
//        ArrayList<String> keysWithOriginal = new ArrayList<>();
//        ArrayList<Type> types = new ArrayList<>();
//        ArrayList<String> titles = new ArrayList<>();
//        stringObjectMap.keySet().remove("RecordID");
//
//        for (String key : stringObjectMap.keySet()) {
//            keys.add(key.substring(key.lastIndexOf("_") + 1));
//
//        }
//
////        for (String key2 : stringObjectMap.keySet()) {
//////            keys.add(key2.substring(key.lastIndexOf("_") + 1));
////            keysWithOriginal.add(key2);
////        }
//
//        //            keys.add(key2.substring(key.lastIndexOf("_") + 1));
//        keysWithOriginal.addAll(stringObjectMap.keySet());
//
//
//        for (int i = 0; i < crmFormBuilderList.size(); i++) {
//            final Type type = intToType(crmFormBuilderList.get(i).getFieldType());
//            titles.add(crmFormBuilderList.get(i).getFieldTitle());
//            types.add(type);
//        }
//        cols.add(new Col(null, "RecordID", "RecordID", Type.DECIMAL, 0, false, false, true));
//        for (int i = 0; i < stringObjectMap.keySet().size(); i++) {
//            cols.add(new Col(null, keysWithOriginal.get(i), titles.get(i), types.get(i), 0, true, true, false));
//        }
//
//        return new Meta(cols);
//    }

//    default List<Map<String, Object>> crmInsFormFieldValue(
//            CrmFormFieldValueWithMulti crmFormFieldValueWithMulti) {
//        List<CrmFormFieldValueTypeAk> crmFormFieldValueTypeAkList = crmFormFieldValueWithMulti.getDetails();
//        List<CrmFormFieldValueTypeAk> crmFormFieldValueTypes = new ArrayList<>();
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        LogLogins logLogins = fetchUserDetail();
//
//        for (int i = 0; i < crmFormFieldValueTypeAkList.size(); i++) {
//            CrmFormFieldValueTypeAk crmFormFieldValueType = new CrmFormFieldValueTypeAk();
//            crmFormFieldValueType.setFieldID(crmFormFieldValueTypeAkList.get(i).getFieldID());
//            crmFormFieldValueType.setFieldValue(crmFormFieldValueTypeAkList.get(i).getFieldValue());
//            crmFormFieldValueType.setValueID(null);
//            crmFormFieldValueTypes.add(crmFormFieldValueType);
//        }
//
//
//        tParameters.add(new TParameter<>("RecordID", crmFormFieldValueWithMulti.getHeader().getRecordID()));
//        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
//        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
//        tParameters.add(new TParameter<>("TValue", crmFormFieldValueTypes));
//
//        ArrayList<BigDecimal> arrayList = new ArrayList<>();
//        arrayList = execSPNativeQueryAk(CrmFormFieldValue.class, "CrmInsUpdFormFieldValueweb", tParameters);
//
//        CrmFormFieldValue crmFormFieldValue = new CrmFormFieldValue();
//        return crmShowFormFieldValueByID(arrayList.get(1), arrayList.get(0), crmFormFieldValue);
//    }


}
