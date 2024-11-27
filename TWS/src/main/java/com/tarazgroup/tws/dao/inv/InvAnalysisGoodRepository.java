package com.tarazgroup.tws.dao.inv;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.inv.InvAnalysisGood;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
public interface InvAnalysisGoodRepository extends TCrudRepository<InvAnalysisGood>, CrudRepository<InvAnalysisGood, BigDecimal> {

    default List<InvAnalysisGood> invShowAnalysisGood(InvAnalysisGood invAnalysisGood) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", invAnalysisGood._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", invAnalysisGood._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", invAnalysisGood._pageFilter()));
        return showSP("InvShowAnalysisGood", tParameters, true);
    }

    default void invInsAnalysisGood(InvAnalysisGood invAnalysisGood) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("GoodsID",invAnalysisGood.getGoodsID()));
        tParameters.add(new TParameter<>("GoodsIDSecond",invAnalysisGood.getGoodsIDSecond()));
        tParameters.add(new TParameter<>("GElementsID",invAnalysisGood.getGElementsID()));
        tParameters.add(new TParameter<>("AnalysisValue",invAnalysisGood.getAnalysisValue()));
        tParameters.add(new TParameter<>("LoginID",logLogins.getLoginId()));
        tParameters.add(new TParameter<>("AnalysisType",invAnalysisGood.getIsAnalysisType()));
        tParameters.add(new TParameter<>("SecUnitId",invAnalysisGood.getSecUnitID()));
        tParameters.add(new TParameter<>("FromDate",invAnalysisGood.getFromDate()));
        tParameters.add(new TParameter<>("ToDate",invAnalysisGood.getToDate()));
        tParameters.add(new TParameter<>("AnalysisNo",invAnalysisGood.getAnalysisNo()));
        tParameters.add(new TParameter<>("AnalysisMode",invAnalysisGood.getAnalysisMode()));
        tParameters.add(new TParameter<>("FeePercent",invAnalysisGood.getFeePercent()));
        tParameters.add(new TParameter<>("AnalysisDesc",invAnalysisGood.getAnalysisDesc()));
        tParameters.add(new TParameter<>("IsDefault",invAnalysisGood.getIsDefault()));
        insSP("InvInsAnalysisGood",tParameters);
        // TODO: 3/7/21 there is no pk on InvAnalysisGood table therefore we cannot return any entity.
    }
}
