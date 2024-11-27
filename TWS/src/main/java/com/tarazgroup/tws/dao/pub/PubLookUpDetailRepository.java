package com.tarazgroup.tws.dao.pub;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.pub.PubLookUpDetail;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Salman Majidi
 * @since 2.0.0
 */

public interface PubLookUpDetailRepository extends TCrudRepository<PubLookUpDetail>, CrudRepository<PubLookUpDetail, BigDecimal> {

    default List<PubLookUpDetail> pubShowLookUpDetail(PubLookUpDetail pubLookUpDetail) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", pubLookUpDetail._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", pubLookUpDetail._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", pubLookUpDetail._pageFilter()));
        return showSP("PubShowLookUpDetail", tParameters, true);
    }

    default PubLookUpDetail pubShowLookUpDetailByID(BigDecimal lookUpID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND main.lookUpID=" + lookUpID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("PubShowLookUpDetail", tParameters, true).get(0);
    }

    default List<PubLookUpDetail> showPaymentWay() {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " and Main.LookUpID = 28"));
//      tParameters.add(new TParameter<>("Filter", "and Main.RefrenceID = 12 and  Charindex('',''+Cast(Main.LookUpID as nvarchar(50))+'','','',28,'') > 0"));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("PubShowLookUpDetail", tParameters, true);
    }

    default Meta meta() {
        //for costCenter qq
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null,"lookUpID", "lookUpID", Type.DECIMAL, 0, false, false,  true));
        cols.add(new Col(null,"lookUpCode", "کد", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"subjectDesc", "نوع مرکز هزینه", Type.STRING, 300, true, true,  false));
        return new Meta(cols);
    }
}
