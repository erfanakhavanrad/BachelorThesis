package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.sale.SaleClass;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
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
public interface SaleClassRepository extends TCrudRepository<SaleClass>, CrudRepository<SaleClass, BigDecimal> {

    default List<SaleClass> saleShowClass(SaleClass saleClass) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", saleClass._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", saleClass._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", saleClass._pageFilter()));
        return showSP("SaleShowClass", tParameters, true);
    }

    default SaleClass saleShowClassByID(BigDecimal classID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND main.classID=" + classID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("SaleShowClass", tParameters, true).get(0);
    }

    default SaleClass saleInsClass(SaleClass saleClass) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("ClassCode", saleClass.getClassCode()));
        tParameters.add(new TParameter<>("ClassDesc", saleClass.getClassDesc()));
        tParameters.add(new TParameter<>("OtherDesc", saleClass.getOtherDesc()));
        tParameters.add(new TParameter<>("FatherID", saleClass.getFatherID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ClassLevel", saleClass.getClassLevel()));
        tParameters.add(new TParameter<>("ClassType", saleClass.getClassType()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("PriorityAddress", saleClass.getPriorityAddress()));
        tParameters.add(new TParameter<>("QuatoPercentage", saleClass.getQuatoPercentage()));
        BigDecimal newID = insSP("SaleInsClass", tParameters);
        return saleShowClassByID(newID);
    }

    default Meta meta() {
        //qq for perCom
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null,"classID","classID", Type.DECIMAL,0, false,false,    true));
        cols.add(new Col(null,"classCode", "کد", Type.STRING,50, true,true,   false));
        cols.add(new Col(null,"classDesc", "شرح", Type.STRING,200, true,true,   false));
        return new Meta(cols);
    }
}
