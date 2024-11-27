package com.tarazgroup.tws.dao.inv;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.inv.InvReportGetCardex;
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
public interface InvReportGetCardexRepository extends TCrudRepository<InvReportGetCardex>, CrudRepository<InvReportGetCardex, BigDecimal> {
    //    InvReport_GetCardex
    default List<InvReportGetCardex> invShowBanks(InvReportGetCardex invReportGetCardex) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("FromDate", null));
        tParameters.add(new TParameter<>("ToDate", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("StoreId", null));
        tParameters.add(new TParameter<>("GoodsID", null));
        tParameters.add(new TParameter<>("ServerFilter", invReportGetCardex._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", invReportGetCardex._yearFilter()));
        tParameters.add(new TParameter<>("LCReferID", null));
        tParameters.add(new TParameter<>("IsOtherSystem", null));
        tParameters.add(new TParameter<>("QuantityType", null));
        tParameters.add(new TParameter<>("PageFilter", invReportGetCardex._pageFilter()));
        tParameters.add(new TParameter<>("UserID", null));
        return showSP("InvReport_GetCardex", tParameters, true);
    }

    default InvReportGetCardex invShowBankByID(BigDecimal storeId) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " And main.storeId=" + storeId));
        tParameters.add(new TParameter<>("FromDate", null));
        tParameters.add(new TParameter<>("ToDate", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("StoreId", null));
        tParameters.add(new TParameter<>("GoodsID", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("LCReferID", null));
        tParameters.add(new TParameter<>("IsOtherSystem", null));
        tParameters.add(new TParameter<>("QuantityType", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        tParameters.add(new TParameter<>("UserID", null));
        return showSP("InvReport_GetCardex", tParameters, true).get(0);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "StoreID", "", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "voucherDetailID", "", Type.STRING, 130, true, true, false));
        cols.add(new Col(null, "voucherDateG", "", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "goodsID", "", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "firstPeriod", "", Type.STRING, 120, true, true, false));
        cols.add(new Col(null, "importColumn", "", Type.DATE, 100, true, false, false));
        cols.add(new Col(null, "export", "", Type.INTEGER, 100, true, false, false));
        cols.add(new Col(null, "remain", "", Type.DATE, 120, true, false, false));
        cols.add(new Col(null, "feeF", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "feeFNew", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "feeI", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "feeINew", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "feeE", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "feeENew", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "feeR", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "feeRNew", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "firstPeriodR", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "firstPeriodRNew", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "importR", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "importRNew", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "exportR", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "exportRNew", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "remainR", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "remainRNew", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "voucherDate", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "voucherNumber", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "customVTypeDesc", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "voucherTypeDesc", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "center1Code", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "center1Desc", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "center2Code", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "center2Desc", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "center3Code", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "center3Desc", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "goodsCode", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "barCode", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "goodsDesc", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "latinDesc", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "techInfo", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "storeCode", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "storeName", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "unitName", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "voucherIdentity", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "voucherHeaderID", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "voucherTypeID", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "importExport", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "accNumber", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "refTypeDesc", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "referNumber", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "referDate", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "tafsiliCode", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "tafsiliDesc", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "systemID", "", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "groupCode", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "groupDesc", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "goodsTypeCode", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "goodsTypeDesc", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "defCompVal", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "defUntName", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "printOrder", "", Type.DECIMAL, 100, true, false, false));
        return new Meta(cols);
    }

}
