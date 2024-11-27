package com.tarazgroup.tws.dao.tkt;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.tkt.TktTimeZone;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/***
 * @author A.Farahani
 * @date Mar-09, 2022
 ***/

public interface TktTimeZoneRepository extends TCrudRepository<TktTimeZone>, CrudRepository<TktTimeZone, BigDecimal> {
    default List<TktTimeZone> tktShowTimeZone(TktTimeZone tktTimeZone) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", tktTimeZone._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", tktTimeZone._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", tktTimeZone._pageFilter()));
        return showSP("TktShowTimeZone", tParameters, true);
    }

    default TktTimeZone tktShowTimeZoneByID(BigDecimal timeZoneID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.TimeZoneID = " + timeZoneID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("TktShowTmeZone", tParameters, true).get(0);
    }

    default Meta meta(){
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "timeZoneID",     "timeZoneID",     Type.DECIMAL, 0,   false, false, true ));
        cols.add(new Col(null, "timeZoneTitle",   "منطقه زمانی",        Type.STRING,  100, true,  true,  false));
        cols.add(new Col(null, "creatorID",  "creatorID",  Type.DECIMAL, 0,   false, false, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE,    0,   false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 0,   false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE,    0,   false, false, false));
        cols.add(new Col(null, "serverID",   "serverID",   Type.DECIMAL, 0,   false, false, false));

        return new Meta(cols);
    }
}
