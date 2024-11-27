package com.tarazgroup.tws.dao.pub;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.pub.PubSystems;
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
public interface PubSystemsRepository extends TCrudRepository<PubSystems>, CrudRepository<PubSystems, BigDecimal> {

    default List<PubSystems> pubShowSystems(PubSystems pubSystems) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", pubSystems._pageFilter()));
        return showSP("PubShowSystems", tParameters, true);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "systemID", "systemID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "systemFName", "نام نرم افزار", Type.STRING, 250, true, true, false));
        cols.add(new Col(null, "sysBriefName", "نام اختصاری", Type.STRING, 80, true, true, false));
        return new Meta(cols);
    }

}
