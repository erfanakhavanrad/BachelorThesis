package com.tarazgroup.tws.dao.inv;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.inv.InvReportCompare;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Erfan Akhavan
 */
public interface InvReportCompareRepository extends TCrudRepository<InvReportCompare>, CrudRepository<InvReportCompare, BigDecimal> {


    // TODO: 11/10/21 Doesn't have page filter
    default List<InvReportCompare> invShowReportVouchers(InvReportCompare invReportCompare) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("FromDate", null));
        tParameters.add(new TParameter<>("ToDate", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", invReportCompare._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", invReportCompare._yearFilter()));
        tParameters.add(new TParameter<>("OutFilter", null));
        tParameters.add(new TParameter<>("IsRiali", null));
        tParameters.add(new TParameter<>("YearStr", null));
        tParameters.add(new TParameter<>("MonthStr", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("UserID", null));
        tParameters.add(new TParameter<>("RepType", null));
        return showSP("InvReport_Compare", tParameters, true);
    }

    default InvReportCompare invShowReportVoucherByID(BigDecimal goodsID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND main.goodsID=" + goodsID));
        tParameters.add(new TParameter<>("FromDate", null));
        tParameters.add(new TParameter<>("ToDate", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("OutFilter", null));
        tParameters.add(new TParameter<>("IsRiali", null));
        tParameters.add(new TParameter<>("YearStr", null));
        tParameters.add(new TParameter<>("MonthStr", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("UserID", null));
        tParameters.add(new TParameter<>("RepType", null));
        return showSP("InvReport_Compare", tParameters, true).get(0);
    }

}
