package com.tarazgroup.tws.dao.inv;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.inv.InvAnalysis;
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
public interface InvAnalysisRepositoty extends TCrudRepository<InvAnalysis>, CrudRepository<InvAnalysis, BigDecimal> {
    default List<InvAnalysis> invShowAnalysis (InvAnalysis invAnalysis){
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("Filter",null));
        tParameters.add(new TParameter<>("OtherFilter",null));
        tParameters.add(new TParameter<>("ServerFilter",null));
        tParameters.add(new TParameter<>("YearFilter",null));
        tParameters.add(new TParameter<>("UserAccessFilter",null));
        tParameters.add(new TParameter<>("PageFilter",invAnalysis._pageFilter()));
        tParameters.add(new TParameter<>("CreatorID",logLogins.getPubUser().getUserID()));
        return showSP("InvShowAnalysis",tParameters, true);
    }

    default InvAnalysis invInsAnalysis(InvAnalysis invAnalysis){
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("GoodsID",invAnalysis.getGoodsID()));
        tParameters.add(new TParameter<>("LoginID",logLogins.getLoginId()));
        tParameters.add(new TParameter<>("FromDate",invAnalysis.getFromDate()));
        tParameters.add(new TParameter<>("ToDate",invAnalysis.getToDate()));
        tParameters.add(new TParameter<>("AnalysisNo",invAnalysis.getAnalysisNo()));
        tParameters.add(new TParameter<>("AnalysisDesc",invAnalysis.getAnalysisDesc()));
        tParameters.add(new TParameter<>("IsDefault",invAnalysis.getIsDefault()));
        tParameters.add(new TParameter<>("AnalysisInfo",invAnalysis.getAnalysisInfo()));
        tParameters.add(new TParameter<>("CreatorID",logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID",logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("AnalysisID",invAnalysis.getAnalysisID()));
        tParameters.add(new TParameter<>("AnalysisValueField",invAnalysis.getAnalysisValueField()));
        tParameters.add(new TParameter<>("LinkedAnalysis",invAnalysis.getLinkedAnalysis()));
        BigDecimal newID = insSP("InvInsAnalysis",tParameters);
        InvAnalysis temp = new InvAnalysis();
        temp.setAnalysisID(newID);
        return invShowAnalysis(temp).get(0);
    }
}
