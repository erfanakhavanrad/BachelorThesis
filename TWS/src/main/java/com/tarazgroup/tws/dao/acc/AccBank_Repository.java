package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccBank1;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Salman Majidi
 * @since 2.0.0
 */

@SuppressWarnings("Duplicates")
public interface AccBank_Repository extends TCrudRepository<AccBank1>, CrudRepository<AccBank1, BigDecimal> {
//NEW12

    default List<AccBank1> accShowBank(AccBank1 accBank) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", accBank._pageFilter()));
        tParameters.add(new TParameter<>("YearFilter", accBank._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", accBank._pageFilter()));
        return showSP("_AccShowBank", tParameters, true);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
//        cols.add(new Col("bankId",  "bankId", 100, false, false, Type.DECIMAL, null, false, false, false, false, true));
//        cols.add(new Col("colDecimal1",  "colDecimal1", 100, true, false, Type.DECIMAL, null, false, false, false, false, false));//1
//        cols.add(new Col("colHidden1",  "colHidden1", 150, false, false, Type.STRING, null, false, false, false, false, false));
//        cols.add(new Col("colHidden2",  "colHidden2", 100, false, false, Type.DECIMAL, null, false, false, false, false, false));
//        cols.add(new Col("colDecimal2",  "colDecimal2", 130, true, false, Type.DECIMAL, null, false, false, false, false, false));//4
//        cols.add(new Col("colNVarChar3",  "colNVarChar3", 150, true, false, Type.STRING, null, false, false, false, false, false));//5
//        cols.add(new Col("colDecimal4",  "colDecimal4", 120, true, false, Type.DECIMAL, null, false, false, false, false, false));//6
//        cols.add(new Col("colBit5",  "colBit5", 100, true, false, Type.BOOLEAN, null, false, false, false, false, false));//7
//        cols.add(new Col("colDecimal6",  "colDecimal6", 100, true, false, Type.DECIMAL, null, false, false, false, false, false));//8
//        cols.add(new Col("colNVarChar7",  "colNVarChar7", 130, true, false, Type.STRING, null, false, false, false, false, false));
//        cols.add(new Col("colDecimal8",  "colDecimal8", 100, true, false, Type.DECIMAL, null, false, false, false, false, false));
//        cols.add(new Col("colDate9",  "colDate9", 100, true, false, Type.DATE, null, false, false, false, false, false));
//        cols.add(new Col("colDate10",  "colDate10", 100, true, false, Type.DATE, null, false, false, false, false, false));
//        cols.add(new Col("colDecimal11",  "colDecimal11", 100, true, false, Type.DECIMAL, null, false, false, false, false, false));//13
//        cols.add(new Col("colNVarChar12",  "colNVarChar12", 100, true, false, Type.STRING, null, false, false, false, false, false));//14
//        cols.add(new Col("colDecimal13",  "colDecimal13", 150, true, false, Type.DECIMAL, null, false, false, false, false, false));
//        cols.add(new Col("colBit14",  "colBit14", 100, true, false, Type.BOOLEAN, null, false, false, false, false, false));
//        cols.add(new Col("colDecimal15",  "colDecimal15", 100, true, false, Type.DECIMAL, null, false, false, false, false, false));
//        cols.add(new Col("colNVarChar16",  "colNVarChar16", 100, true, false, Type.STRING, null, false, false, false, false, false));
//        cols.add(new Col("colDecimal17",  "colDecimal17", 120, true, false, Type.DECIMAL, null, false, false, false, false, false));
//        cols.add(new Col("colNVarChar18",  "colNVarChar18", 80, true, false, Type.STRING, null, false, false, false, false, false));
//        cols.add(new Col("colNVarChar19",  "colNVarChar19", 100, true, false, Type.STRING, null, false, false, false, false, false));
//        cols.add(new Col("colNVarChar20",  "colNVarChar20", 130, true, false, Type.STRING, null, false, false, false, false, false));
//        cols.add(new Col("colHidden4",  "colHidden4", 130, true, false, Type.STRING, null, false, false, false, false, false));
        return new Meta(cols);
    }
}

