package com.tarazgroup.tws.util.global;

import com.tarazgroup.tws.util.global.responseheader.Type;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */
public interface ITParams {

    // کد های زیر دیگر استفاده ای ندارند چون ما باید همیشه فیلتر های خود را به پیج فیلتر پاس بدهیم
    // ولی محض اطمینان پاک نشده اند
//    default String _filter1(String filter) {
//        // برای مواقعی که یک فیلتر از پیش تعیین شده داریم از این متد استفاده می شود
//        String combinateFilter = createCombinateFilter("main",filter).toString();
//        if (filter == null) {
//            filter = "";
//        } else {
//            filter = " AND " + filter;
//        }
//        return combinateFilter.isEmpty() ? filter : combinateFilter + filter;
//    }
//
//    default String _filter() {
//        String combinateFilter = createCombinateFilter("main",null).toString();
//        return combinateFilter.isEmpty() ? null : combinateFilter;
//    }

    default StringBuilder createCombinateFilter(String preFix, String filter) {
        StringBuilder stringBuilder = new StringBuilder();
        if (filter != null) {
            stringBuilder.append(" AND ").append(filter);
        }

        if (preFix != null) {
            preFix += ".";
        } else {
            preFix = "";
        }
        for (Field field : this.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (filter != null && filter.toLowerCase().contains(field.getName().toLowerCase())) {
                // برای مواقعی که یک فیلتر از پیش تعیین شده داریم اولویت با فیلتر از پیش تعیین شده است
                // و از فیلد هایی که در فبلتر از پیش تعیین شده وجود دارند صرف نظر مبشود
                continue;
            }

            if (field.getName() == "serverID" || field.getName() == "yearID") {
                continue;
            }
            try {
                Object value = field.get(this);
                if (field.getType() == String.class) {
                    if (value != null) {
                        stringBuilder.append(" AND ").append(preFix).append(field.getName()).append(" LIKE N'%").append(value).append("%'");
                    }
                } else if (field.getType() == BigDecimal.class) {
                    if (value != null) {
                        if (field.getAnnotation(javax.persistence.Id.class) != null) {
                            // کلید اصلی باید بدون لایک باشد
                            stringBuilder.append(" AND ").append(preFix).append(field.getName()).append(" =").append(value);
                        } else {
                            // تصمیم بر این شد که همه فیلد های جستجو بر اساس like
                            stringBuilder.append(" AND ").append(preFix).append(field.getName()).append(" LIKE N'%").append(value).append("%'");
                        }
                    }
                } else if (field.getType() == Boolean.class) {
                    if (value != null) {
                        if ((Boolean) value) {
                            stringBuilder.append(" AND ").append(preFix).append(field.getName()).append(" = 1");
                        } else {
                            stringBuilder.append(" AND ").append(preFix).append(field.getName()).append(" = 0");
                        }
                    }
                } else if (field.getType() == Integer.class) {
                    if (value != null) {
                        // تصمیم بر این شد که همه فیلد های جستجو بر اساس like
//                        stringBuilder.append(" AND main.").append(field.getName()).append(" =").append(value);
                        stringBuilder.append(" AND ").append(preFix).append(field.getName()).append(" LIKE N'%").append(value).append("%'");
                    }
                } else if (field.getType() == byte[].class) {
                    //
                }
                else if (field.getType() == BigDecimal[].class) {
//                        [10000001, 1000000002, 100000003]
//                    stringBuilder.append(" AND ").append(preFix).append(field.getName()).append(" LIKE N'%").append(value).append("%'");
                }
                else if (field.getType().getPackage().getName().contains("com.tarazgroup.tws.model")) {
                    if (value != null) {
                        for (Field field1 : value.getClass().getDeclaredFields()) {
                            field1.setAccessible(true);
                            Object value1 = field1.get(value);
                            if (field1.getType() == String.class) {
                                if (value1 != null) {
                                    stringBuilder.append(" AND ").append(preFix).append(field1.getName()).append(" LIKE N'%").append(value1).append("%'");
                                }
                            } else if (field1.getType() == BigDecimal.class) {
                                if (value1 != null) {
                                    // تصمیم بر این شد که همه فیلد های جستجو بر اساس like
//                                    stringBuilder.append(" AND main.").append(field1.getName()).append(" =").append(value1);
                                    stringBuilder.append(" AND ").append(preFix).append(field.getName()).append(" LIKE N'%").append(value).append("%'");
                                }
                            } else if (field1.getType() == Integer.class) {
                                if (value1 != null) {
                                    // تصمیم بر این شد که همه فیلد های جستجو بر اساس like
//                                    stringBuilder.append(" AND main.").append(field1.getName()).append(" =").append(value1);
                                    stringBuilder.append(" AND ").append(preFix).append(field.getName()).append(" LIKE N'%").append(value).append("%'");
                                }
                            } else if (field1.getType() == Boolean.class) {
                                if (value1 != null) {
                                    if ((Boolean) value1) {
                                        stringBuilder.append(" AND ").append(preFix).append(field1.getName()).append(" = 1");
                                    } else {
                                        stringBuilder.append(" AND ").append(preFix).append(field1.getName()).append(" = 0");
                                    }
                                }
                            }
                        }
                    }

                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return stringBuilder;
    }


//    default StringBuilder createCombinateFilterAk(String preFix, String filter,  ArrayList<String> fieldNames, ArrayList<Type> fieldTypes) {
//
//        StringBuilder stringBuilder = new StringBuilder();
//        if (filter != null) {
//            stringBuilder.append(" AND ").append(filter);
//        }
//
//        if (preFix != null) {
//            preFix += ".";
//        } else {
//            preFix = "";
//        }
//
//        for (int i = 0; i < fieldNames.size(); i++) {
//            if (filter != null && filter.toLowerCase().contains(fieldNames.get(i).toLowerCase())) continue;
//
//            if (fieldNames.get(i) == "serverID" || fieldNames.get(i) == "yearID") continue;
//
//            try {
//                Object value = fieldNames.get(i).getClass().get();
//
//
//if (fieldTypes.get(i) == Type.STRING){
//    if (fieldNames.get(i) != null) {
//        stringBuilder.append(" AND ").append(preFix).append(fieldNames.get(i)).append(" LIKE N'%").append("TESTING");
//    }
//}
//
//            } catch (IllegalAccessException e){
//                e.printStackTrace();
//            }
//
//
//
//        }
//
//        return stringBuilder;
//
//    }

//    default StringBuilder createCombinateFilterAk2(String preFix, String filter,  ArrayList<String> fieldNames, ArrayList<Type> fieldTypes) {
//
//        StringBuilder stringBuilder = new StringBuilder();
//        if (filter != null) {
//            stringBuilder.append(" AND ").append(filter);
//        }
//
//        if (preFix != null) {
//            preFix += ".";
//        } else {
//            preFix = "";
//        }
//        this.getClass().field
//        for (Field field: this.getClass().getDeclaredFields())
//
//        for (int i = 0; i < fieldNames.size(); i++) {
//            if (filter != null && filter.toLowerCase().contains(fieldNames.get(i).toLowerCase())) continue;
//
//            if (fieldNames.get(i) == "serverID" || fieldNames.get(i) == "yearID") continue;
//
//            try {
//                Object value = fieldNames.get(i).getClass().get();
//
//
//                if (fieldTypes.get(i) == Type.STRING){
//                    if (fieldNames.get(i) != null) {
//                        stringBuilder.append(" AND ").append(preFix).append(fieldNames.get(i)).append(" LIKE N'%").append("TESTING");
//                    }
//                }
//
//            } catch (IllegalAccessException e){
//                e.printStackTrace();
//            }
//
//
//
//        }
//
//        return stringBuilder;
//
//    }

    default StringBuilder createCombinateFilterAk2(String preFix, String filter, ArrayList<String> fieldsName, ArrayList<Type> fieldsType, ArrayList<String> fieldsValue) {
        StringBuilder stringBuilder = new StringBuilder();
        if (filter != null) {
            stringBuilder.append(" AND ").append(filter);
        }

        if (preFix != null) {
            preFix += ".";
        } else {
            preFix = "";
        }
        for (int i = 0; i < fieldsName.size(); i++) {

            if (filter != null && filter.toLowerCase().contains(fieldsName.get(i).toLowerCase())) continue;

            if (fieldsName.get(i) == "serverID" || fieldsName.get(i) == "yearID") continue;

//            try {
//                if (fieldsType == Type.STRING){
//
//                }
//            } catch (IllegalAccessException e) {e.printStackTrace();}

        }


        return stringBuilder;
    }


    default StringBuilder createCombinateFilterAk3(String preFix, String filter, ArrayList<String> fieldsName, ArrayList<String> fieldsValue, ArrayList<Integer> fieldsType) {


        StringBuilder stringBuilder = new StringBuilder();
        if (filter != null) {
            stringBuilder.append(" AND ").append(filter);
        }

        if (preFix != null) {
            preFix += ".";
        } else {
            preFix = "";
        }
        for (int i = 0; i < fieldsName.size(); i++) {


            if (filter != null && filter.toLowerCase().contains(fieldsName.get(i).toLowerCase())) {
                // برای مواقعی که یک فیلتر از پیش تعیین شده داریم اولویت با فیلتر از پیش تعیین شده است
                // و از فیلد هایی که در فبلتر از پیش تعیین شده وجود دارند صرف نظر مبشود
                continue;
            }

            if (fieldsName.get(i) == "serverID" || fieldsName.get(i) == "yearID") {
                continue;
            }

            try {
                // String
                if (fieldsType.get(0) == 1 || fieldsType.get(0) == 3 || fieldsType.get(0) == 8) {
                    if (fieldsValue.get(i) != null && !fieldsName.get(i).equals("pageNumber") && !fieldsName.get(i).equals("recordCount")) {
                        stringBuilder.append(" AND ").append(preFix).append(fieldsName.get(i)).append(" LIKE N''%").append(fieldsValue.get(i)).append("%''");
                        System.out.println("String Builder is: " + stringBuilder.toString());
                    }
                    // Decimal
                } else if (fieldsType.get(0) == 2) {
                    if (fieldsValue.get(i) != null && !fieldsName.get(i).equals("pageNumber") && !fieldsName.get(i).equals("recordCount")) {
                        stringBuilder.append(" AND ").append(preFix).append(fieldsName.get(i)).append(" LIKE N''%").append(fieldsValue.get(i)).append("%''");
                        System.out.println("String Builder is: " + stringBuilder.toString());

                    }
                }
                // Boolean
                else if (fieldsType.get(i) == 5) {
                    if (fieldsValue.get(i) != null) {
                        if (fieldsValue.get(i).equals("true") || fieldsValue.get(i).equals("1")) {
                            stringBuilder.append(" AND ").append(preFix).append(fieldsName.get(i)).append(" = 1");
                        } else if (fieldsValue.get(i).equals("false") || fieldsValue.get(i).equals("0")) {
                            stringBuilder.append(" AND ").append(preFix).append(fieldsName.get(i)).append(" = 0");
                        }
                    }
                }
                // Integer
                else if (fieldsType.get(i) == 11) {
                    if (fieldsValue.get(i) != null)
                        stringBuilder.append(" AND ").append(preFix).append(fieldsName.get(i)).append(" LIKE N'%").append(fieldsValue.get(i)).append("%'");
                }
                // byte[]
                else if (fieldsType.get(i) == 12) {
                    if (fieldsValue.get(i) != null) {
                        //
                    }
                } else if (fieldsType.get(i).getClass().getPackage().getName().contains("com.tarazgroup.tws.model")) {
                    if (fieldsValue.get(i) != null) {
                        for (Field field1 : fieldsValue.get(i).getClass().getDeclaredFields()) {
                            field1.setAccessible(true);
                            Object value1 = field1.get(fieldsValue.get(i));
                            if (field1.getType() == String.class) {
                                if (value1 != null) {
                                    stringBuilder.append(" AND ").append(preFix).append(field1.getName()).append(" LIKE N'%").append(value1).append("%'");
                                }
                            } else if (field1.getType() == BigDecimal.class) {
                                if (value1 != null) {
                                    // تصمیم بر این شد که همه فیلد های جستجو بر اساس like
//                                    stringBuilder.append(" AND main.").append(field1.getName()).append(" =").append(value1);
                                    stringBuilder.append(" AND ").append(preFix).append(fieldsName.get(i)).append(" LIKE N'%").append(fieldsValue.get(i)).append("%'");
                                }
                            } else if (field1.getType() == Integer.class) {
                                if (value1 != null) {
                                    // تصمیم بر این شد که همه فیلد های جستجو بر اساس like
//                                    stringBuilder.append(" AND main.").append(field1.getName()).append(" =").append(value1);
                                    stringBuilder.append(" AND ").append(preFix).append(fieldsName.get(i)).append(" LIKE N'%").append(fieldsValue.get(i)).append("%'");
                                }
                            } else if (field1.getType() == Boolean.class) {
                                if (value1 != null) {
                                    if ((Boolean) value1) {
                                        stringBuilder.append(" AND ").append(preFix).append(field1.getName()).append(" = 1");
                                    } else {
                                        stringBuilder.append(" AND ").append(preFix).append(field1.getName()).append(" = 0");
                                    }
                                }
                            }

                        }
                    }

                }
//                case 1:// String
//                    return Type.STRING;
//                case 2:// Number
//                    return Type.DECIMAL;
//                case 3:// Date Shamsi
//                case 8:// Date Gregorian
//                    return Type.DATE;
//                case 4:// TODO Time -> extend later
//                case 5:// Boolean
//                    return Type.BOOLEAN;
//                case 6:// Selector
//                    return Type.CHIP;
//                case 7:// Memo / Text Area
//                    return Type.STRINGLONG;
//                case 9:// QKEY
//                    return Type.QKEY;
//                case 10:// ارجاع به
//                    return Type.REFERTO;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return stringBuilder;
    }
}
