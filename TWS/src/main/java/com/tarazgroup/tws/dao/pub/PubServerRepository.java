package com.tarazgroup.tws.dao.pub;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.pub.PubServer;
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

@SuppressWarnings("Duplicates")
public interface PubServerRepository extends TCrudRepository<PubServer>, CrudRepository<PubServer, BigDecimal> {

    default List<PubServer> pubShowServers() {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("OtherFilter", ""));
        tParameters.add(new TParameter<>("ServerFilter", ""));
        tParameters.add(new TParameter<>("YearFilter", ""));
        tParameters.add(new TParameter<>("UserAccessFilter", ""));
        tParameters.add(new TParameter<>("Filter", ""));
        return showSP("PubShowServer", tParameters, true);
    }


    default PubServer pubShowServersByID(BigDecimal serverID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("OtherFilter", ""));
        tParameters.add(new TParameter<>("ServerFilter", ""));
        tParameters.add(new TParameter<>("YearFilter", ""));
        tParameters.add(new TParameter<>("UserAccessFilter", ""));
        tParameters.add(new TParameter<>("Filter", " AND main.serverID=" + serverID));
        return showSP("PubShowServer", tParameters, true).get(0);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null,"serverID", "serverID", Type.DECIMAL, 0, false, false,  true));
        cols.add(new Col(null,"serverDesc", "عنوان", Type.STRING, 150, true, true,  false));
        return new Meta(cols);
    }

}
