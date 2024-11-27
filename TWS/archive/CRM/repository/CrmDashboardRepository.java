package com.tarazgroup.tws.dao.crm;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.crm.CrmDashboard;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Salman Majidi
 * @since 2.0.0
 */

@SuppressWarnings("Duplicates")
public interface CrmDashboardRepository extends TCrudRepository<CrmDashboard>, CrudRepository<CrmDashboard, BigDecimal> {

    default List<Map<String, Object>> chartMap() {
        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> map1 = new HashMap<>();
        map1.put("id", "IR_01");
        map1.put("color", "#1c2e27");
        map1.put("desc", "19 میلیون تومان");

        Map<String, Object> map2 = new HashMap<>();
        map2.put("id", "IR_02");
        map2.put("color", "#6db398");
        map2.put("desc", "20 میلیون تومان");

        Map<String, Object> map3 = new HashMap<>();
        map3.put("id", "IR_03");
        map3.put("color", "#1c2e27");
        map3.put("desc", "83 میلیون تومان");

        Map<String, Object> map4 = new HashMap<>();
        map4.put("id", "IR_04");
        map4.put("color", "#6db398");
        map4.put("desc", "49 میلیون تومان");

        Map<String, Object> map5 = new HashMap<>();
        map5.put("id", "IR_05");
        map5.put("color", "#6db398");
        map5.put("desc", "15 میلیون تومان");

        Map<String, Object> map6 = new HashMap<>();
        map6.put("id", "IR_06");
        map6.put("color", "#1c2e27");
        map6.put("desc", "24 میلیون تومان");

        Map<String, Object> map7 = new HashMap<>();
        map7.put("id", "IR_07");
        map7.put("color", "#1c2e27");
        map7.put("desc", "94 میلیون تومان");

        Map<String, Object> map8 = new HashMap<>();
        map8.put("id", "IR_08");
        map8.put("color", "#6db398");
        map8.put("desc", "34 میلیون تومان");

        Map<String, Object> map9 = new HashMap<>();
        map9.put("id", "IR_10");
        map9.put("color", "#1c2e27");
        map9.put("desc", "82 میلیون تومان");

        Map<String, Object> map10 = new HashMap<>();
        map10.put("id", "IR_11");
        map10.put("color", "#1c2e27");
        map10.put("desc", "57 میلیون تومان");

        Map<String, Object> map11 = new HashMap<>();
        map11.put("id", "IR_12");
        map11.put("color", "#6db398");
        map11.put("desc", "47 میلیون تومان");

        Map<String, Object> map12 = new HashMap<>();
        map12.put("id", "IR_13");
        map12.put("color", "#6db398");
        map12.put("desc", "76 میلیون تومان");

        Map<String, Object> map13 = new HashMap<>();
        map13.put("id", "IR_14");
        map13.put("color", "#436e5d");
        map13.put("desc", "56 میلیون تومان");

        Map<String, Object> map14 = new HashMap<>();
        map14.put("id", "IR_15");
        map14.put("color", "#436e5d");
        map14.put("desc", "43 میلیون تومان");

        Map<String, Object> map15 = new HashMap<>();
        map15.put("id", "IR_16");
        map15.put("color", "#436e5d");
        map15.put("desc", "45 میلیون تومان");

        Map<String, Object> map16 = new HashMap<>();
        map16.put("id", "IR_17");
        map16.put("color", "#436e5d");
        map16.put("desc", "12 میلیون تومان");

        Map<String, Object> map17 = new HashMap<>();
        map17.put("id", "IR_18");
        map17.put("color", null);
        map17.put("desc", "بدون فروش");

        Map<String, Object> map18 = new HashMap<>();
        map18.put("id", "IR_19");
        map18.put("color", null);
        map18.put("desc", "بدون فروش");

        Map<String, Object> map19 = new HashMap<>();
        map19.put("id", "IR_20");
        map19.put("color", null);
        map19.put("desc", "بدون فروش");

        Map<String, Object> map20 = new HashMap<>();
        map20.put("id", "IR_21");
        map20.put("color", null);
        map20.put("desc", "بدون فروش");

        Map<String, Object> map21 = new HashMap<>();
        map21.put("id", "IR_22");
        map21.put("color", null);
        map21.put("desc", "بدون فروش");

        Map<String, Object> map22 = new HashMap<>();
        map22.put("id", "IR_23");
        map22.put("color", null);
        map22.put("desc", "بدون فروش");

        Map<String, Object> map23 = new HashMap<>();
        map23.put("id", "IR_24");
        map23.put("color", null);
        map23.put("desc", "بدون فروش");

        Map<String, Object> map24 = new HashMap<>();
        map24.put("id", "IR_25");
        map24.put("color", null);
        map24.put("desc", "بدون فروش");

        Map<String, Object> map25 = new HashMap<>();
        map25.put("id", "IR_26");
        map25.put("color", null);
        map25.put("desc", "بدون فروش");

        Map<String, Object> map26 = new HashMap<>();
        map26.put("id", "IR_27");
        map26.put("color", null);
        map26.put("desc", "بدون فروش");

        Map<String, Object> map27 = new HashMap<>();
        map27.put("id", "IR_28");
        map27.put("color", null);
        map27.put("desc", "بدون فروش");

        Map<String, Object> map28 = new HashMap<>();
        map28.put("id", "IR_29");
        map28.put("color", null);
        map28.put("desc", "بدون فروش");

        Map<String, Object> map29 = new HashMap<>();
        map29.put("id", "IR_30");
        map29.put("color", null);
        map29.put("desc", "بدون فروش");

        Map<String, Object> map30 = new HashMap<>();
        map30.put("id", "IR_31");
        map30.put("color", null);
        map30.put("desc", "بدون فروش");

        Map<String, Object> map31 = new HashMap<>();
        map31.put("id", "IR_32");
        map31.put("color", null);
        map31.put("desc", "بدون فروش");

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
