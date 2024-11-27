package com.tarazgroup.tws.dao.inv;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.inv.InvReportSecUnitGoodsSimple;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Erfan Akhavan
 */
public interface InvReportSecUnitGoodsSimpleRepository extends TCrudRepository<InvReportSecUnitGoodsSimple>, CrudRepository<InvReportSecUnitGoodsSimple, BigDecimal> {
    default List<InvReportSecUnitGoodsSimple> invShowReportSecUnitGoodsSimple(InvReportSecUnitGoodsSimple invReportSecUnitGoodsSimple) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", invReportSecUnitGoodsSimple._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", invReportSecUnitGoodsSimple._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("FromDate", null));
        tParameters.add(new TParameter<>("ToDate", null));
        tParameters.add(new TParameter<>("OutFilter", null));
        tParameters.add(new TParameter<>("IsPriceList", null));
        tParameters.add(new TParameter<>("UserID", null));
        // TODO: 10/18/21 Doesn't have page filter
        return showSP("InvReport_SecUnitGoods_Simple", tParameters, true);
    }

    default InvReportSecUnitGoodsSimple invShowReportSecUnitGoodsSimpleByID(BigDecimal GoodsID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " And main.GoodsID= " + GoodsID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("FromDate", null));
        tParameters.add(new TParameter<>("ToDate", null));
        tParameters.add(new TParameter<>("OutFilter", null));
        tParameters.add(new TParameter<>("IsPriceList", null));
        tParameters.add(new TParameter<>("UserID", null));
        return showSP("InvReport_SecUnitGoods_Simple", tParameters, true).get(0);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "goodsID", "goodsID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "goodCode", "کالا|کد", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "goodBarcode", "کالا|بارکد", Type.STRING, 130, true, true, false));
        cols.add(new Col(null, "goodDesc", "کالا|شرح", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "goodDescEn", "کالا|شرح لاتین", Type.STRING, 120, true, true, false));
        cols.add(new Col(null, "goodGroupCode", "گروه کالا|کد", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "goodGroupDesc", "گروه کالا|شرح", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "countStockBasedOnMainUnit", "موجودی بر اساس واحد اصلی|تعداد", Type.STRING, 120, true, true, false));
        cols.add(new Col(null, "unitStockBasedOnMainUnit", "موجودی بر اساس واحد اصلی|واحد", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "otherUnit1Title", "واحدفرعی 1|عنوان", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "otherUnit1Multiple", "واحدفرعی 1|ضریب", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "otherUnit1Stock", "واحدفرعی 1|موجودی", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "otherUnit1AndPortionCount", "واحدفرعی 1|موجودی.و.تعدادجزء", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "otherUnit1PortionCount", "واحدفرعی 1|تعدادجزء", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "otherUnit2Title", "واحدفرعی 2|عنوان", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "otherUnit2Multiple", "واحدفرعی 2|ضریب", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "otherUnit2Stock", "واحدفرعی 2|موجودی", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "otherUnit2AndPortionCount", "واحدفرعی 2|موجودی.و.تعدادجزء", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "otherUnit2PortionCount", "واحدفرعی 2|تعدادجزء", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "otherUnit3Title", "واحدفرعی 3|عنوان", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "otherUnit3Multiple", "واحدفرعی 3|ضریب", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "otherUnit3Stock", "واحدفرعی 3|موجودی", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "otherUnit3AndPortionCount", "واحد فرعی 3|موجودی و تعداد جزء", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "otherUnit3PortionCount", "واحد فرعی 3|تعداد جزء", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "otherUnit4Title", "واحد فرعی 4|عنوان", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "otherUnit4Multiple", "واحد فرعی 4|ضریب", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "otherUnit4Stock", "واحد فرعی 4|موجودی", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "otherUnit4AndPortionCount", "واحد فرعی 4|موجودی و تعداد جزء", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "otherUnit4PortionCount", "واحد فرعی 4|تعداد جزء", Type.STRING, 100, true, true, false));
        return new Meta(cols);
    }

}
