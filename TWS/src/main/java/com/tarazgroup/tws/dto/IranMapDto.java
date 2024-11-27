package com.tarazgroup.tws.dto;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */
public class IranMapDto {

    public List<Map<String, Object>> Convert(List<Map<String, Object>> rows){
        List<Map<String, Object>> states = states();
        for (Map<String, Object> state : states) {
            Map<String, Object> row = rows.stream()
                    .filter(_row -> ((BigDecimal) _row.get("mID")).intValue() == ((BigDecimal) state.get("geoLocationID")).intValue())
                    .findAny()
                    .orElse(null);

            if (row == null) {
                // یعنی برای این استان هیچ مقداری در دیتابیس موجود نیست
                state.put("color", null);
                state.put("desc", "بدون فروش");
            } else {
                BigDecimal sumPrice = (BigDecimal) row.get("SumPrice");
                if (sumPrice.compareTo(new BigDecimal("0")) >= 0 && sumPrice.compareTo(new BigDecimal("10000000")) < 0) {
                    state.put("color", "#72ba9d");
                } else if (sumPrice.compareTo(new BigDecimal("10000000")) >= 0 && sumPrice.compareTo(new BigDecimal("10000000000")) < 0) {
                    state.put("color", "#4e806c");
                } else if (sumPrice.compareTo(new BigDecimal("10000000000")) >= 0 && sumPrice.compareTo(new BigDecimal("10000000000000")) < 0) {
                    state.put("color", "#4e806c");
                } else if (sumPrice.compareTo(new BigDecimal("10000000000000")) >= 0 && sumPrice.compareTo(new BigDecimal("10000000000000000")) < 0) {
                    state.put("color", "#35574a");
                } else {
                    state.put("color", "#1c2e27");
                }
                state.put("desc", sumPrice);
            }
        }
        return states;
    }

    private List<Map<String, Object>> states() {
        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> map1 = new HashMap<>();
        map1.put("id", "IR_01");
        map1.put("title", "آذربایجان شرقی");
        map1.put("geoLocationID", new BigDecimal(10000005));

        Map<String, Object> map2 = new HashMap<>();
        map2.put("id", "IR_02");
        map2.put("title", "آذربایجان غربی");
        map2.put("geoLocationID", new BigDecimal(10000006));

        Map<String, Object> map3 = new HashMap<>();
        map3.put("id", "IR_03");
        map3.put("title", "اردبیل");
        map3.put("geoLocationID", new BigDecimal(10000026));

        Map<String, Object> map4 = new HashMap<>();
        map4.put("id", "IR_04");
        map4.put("title", "اصفهان");
        map4.put("geoLocationID", new BigDecimal(10000012));

        Map<String, Object> map5 = new HashMap<>();
        map5.put("id", "IR_05");
        map5.put("title", "ایلام");
        map5.put("geoLocationID", new BigDecimal(10000019));

        Map<String, Object> map6 = new HashMap<>();
        map6.put("id", "IR_06");
        map6.put("title", "بوشهر");
        map6.put("geoLocationID", new BigDecimal(10000032));

        Map<String, Object> map7 = new HashMap<>();
        map7.put("id", "IR_07");
        map7.put("title", "تهران");
        map7.put("geoLocationID", new BigDecimal(10000003));

        Map<String, Object> map8 = new HashMap<>();
        map8.put("id", "IR_08");
        map8.put("title", "چهارمحال و بختیاری");
        map8.put("geoLocationID", new BigDecimal(10000017));

        Map<String, Object> map9 = new HashMap<>();
        map9.put("id", "IR_10");
        map9.put("title", "خوزستان");
        map9.put("geoLocationID", new BigDecimal(10000008));

        Map<String, Object> map10 = new HashMap<>();
        map10.put("id", "IR_11");
        map10.put("title", "زنجان");
        map10.put("geoLocationID", new BigDecimal(10000021));

        Map<String, Object> map11 = new HashMap<>();
        map11.put("id", "IR_12");
        map11.put("title", "سمنان");
        map11.put("geoLocationID", new BigDecimal(10000034));

        Map<String, Object> map12 = new HashMap<>();
        map12.put("id", "IR_13");
        map12.put("title","سیستان و بلوچستان" );
        map12.put("geoLocationID", new BigDecimal(10000030));

        Map<String, Object> map13 = new HashMap<>();
        map13.put("id", "IR_14");
        map13.put("title", "فارس");
        map13.put("geoLocationID", new BigDecimal(10000009));

        Map<String, Object> map14 = new HashMap<>();
        map14.put("id", "IR_15");
        map14.put("title", "کرمان");
        map14.put("geoLocationID", new BigDecimal(10000010));

        Map<String, Object> map15 = new HashMap<>();
        map15.put("id", "IR_16");
        map15.put("title", "کردستان");
        map15.put("geoLocationID", new BigDecimal(10000014));

        Map<String, Object> map16 = new HashMap<>();
        map16.put("id", "IR_17");
        map16.put("title", "کرمانشاه");
        map16.put("geoLocationID", new BigDecimal(10000007));

        Map<String, Object> map17 = new HashMap<>();
        map17.put("id", "IR_18");
        map17.put("title", "کهگیلویه و بویراحمد");
        map17.put("geoLocationID", new BigDecimal(10000020));

        Map<String, Object> map18 = new HashMap<>();
        map18.put("id", "IR_19");
        map18.put("title", "گیلان");
        map18.put("geoLocationID", new BigDecimal(10000025));

        Map<String, Object> map19 = new HashMap<>();
        map19.put("id", "IR_20");
        map19.put("title","لرستان" );
        map19.put("geoLocationID", new BigDecimal(10000018));

        Map<String, Object> map20 = new HashMap<>();
        map20.put("id", "IR_21");
        map20.put("title", "مازندران");
        map20.put("geoLocationID", new BigDecimal(10000004));

        Map<String, Object> map21 = new HashMap<>();
        map21.put("id", "IR_22");
        map21.put("title", "مرکزی");
        map21.put("geoLocationID", new BigDecimal(10000023));

        Map<String, Object> map22 = new HashMap<>();
        map22.put("id", "IR_23");
        map22.put("title","هرمزگان" );
        map22.put("geoLocationID", new BigDecimal(10000015));

        Map<String, Object> map23 = new HashMap<>();
        map23.put("id", "IR_24");
        map23.put("title","همدان" );
        map23.put("geoLocationID", new BigDecimal(10000016));

        Map<String, Object> map24 = new HashMap<>();
        map24.put("id", "IR_25");
        map24.put("title","یزد" );
        map24.put("geoLocationID", new BigDecimal(10000031));

        Map<String, Object> map25 = new HashMap<>();
        map25.put("id", "IR_26");
        map25.put("title","قم" );
        map25.put("geoLocationID", new BigDecimal(10000027));

        Map<String, Object> map26 = new HashMap<>();
        map26.put("id", "IR_27");
        map26.put("title", "گلستان");
        map26.put("geoLocationID", new BigDecimal(10000029));

        Map<String, Object> map27 = new HashMap<>();
        map27.put("id", "IR_28");
        map27.put("title", "قزوین");
        map27.put("geoLocationID", new BigDecimal(10000028));

        Map<String, Object> map28 = new HashMap<>();
        map28.put("id", "IR_29");
        map28.put("title","خراسان جنوبی" );
        map28.put("geoLocationID", new BigDecimal(10000022));

        Map<String, Object> map29 = new HashMap<>();
        map29.put("id", "IR_30");
        map29.put("title", "خراسان رضوی");
        map29.put("geoLocationID", new BigDecimal(10000011));

        Map<String, Object> map30 = new HashMap<>();
        map30.put("id", "IR_31");
        map30.put("title", "خراسان شمالی");
        map30.put("geoLocationID", new BigDecimal(10000013));

        Map<String, Object> map31 = new HashMap<>();
        map31.put("id", "IR_32");
        map31.put("title", "البرز");
        map31.put("geoLocationID", new BigDecimal(10000024));

        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);
        list.add(map5);
        list.add(map6);
        list.add(map7);
        list.add(map8);
        list.add(map9);
        list.add(map10);
        list.add(map11);
        list.add(map12);
        list.add(map13);
        list.add(map14);
        list.add(map15);
        list.add(map16);
        list.add(map17);
        list.add(map18);
        list.add(map19);
        list.add(map20);
        list.add(map21);
        list.add(map22);
        list.add(map23);
        list.add(map24);
        list.add(map25);
        list.add(map26);
        list.add(map27);
        list.add(map28);
        list.add(map29);
        list.add(map30);
        list.add(map31);

        return list;
    }
}

