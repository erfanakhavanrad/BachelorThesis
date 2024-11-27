package com.tarazgroup.tws.dao.pub;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.pub.PubGeoLocation;
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

public interface PubGeoLocationRepository extends TCrudRepository<PubGeoLocation>, CrudRepository<PubGeoLocation, BigDecimal> {

    default List<PubGeoLocation> pubShowGeoLocation(PubGeoLocation pubGeoLocation) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("PageFilter", pubGeoLocation._pageFilter()));
        return showSP("PubShowGeoLocation", tParameters, true);
    }


    default PubGeoLocation pubShowGeoLocationByID(BigDecimal geoLocationID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND main.geoLocationID=" + geoLocationID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("PubShowGeoLocation", tParameters, true).get(0);
    }


    default List<PubGeoLocation> pubShowGeoLocationTypeByID(BigDecimal geoLocationTypeID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND main.geoLocationTypeID=" + geoLocationTypeID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("PubShowGeoLocation", tParameters, true);
    }




    default List<PubGeoLocation> pubShowGeoFatherLocationByID(BigDecimal geoFatherLocationID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND main.geoFatherLocationID=" + geoFatherLocationID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("PubShowGeoLocation", tParameters, true);
    }




    default PubGeoLocation pubInsGeoLocation(PubGeoLocation pubGeoLocation) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("GeoFatherLocationID", pubGeoLocation.getGeoFatherLocationID()));
        tParameters.add(new TParameter<>("GeoLocationTypeID", pubGeoLocation.getGeoLocationID()));
        tParameters.add(new TParameter<>("GeoLocationAbbr", pubGeoLocation.getGeoLocationAbbr()));
        tParameters.add(new TParameter<>("GeoLocationCode", pubGeoLocation.getGeoLocationCode()));
        tParameters.add(new TParameter<>("GeoLocationExt", pubGeoLocation.getGeoLocationExt()));
        tParameters.add(new TParameter<>("GeoLocationDesc", pubGeoLocation.getGeoLocationDesc()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("PubInsGeoLocation", tParameters);
        return pubShowGeoLocationByID(newID);
    }

    default void pubDelGeoLocation(BigDecimal geoLocationID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("GeoLocationID", geoLocationID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("PubDelGeoLocation", tParameters);
    }

    default PubGeoLocation pubUpdGeoLocation(BigDecimal geoLocationID, PubGeoLocation pubGeoLocation) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("GeoLocationID", geoLocationID));
        tParameters.add(new TParameter<>("GeoLocationTypeID", pubGeoLocation.getGeoLocationID()));
        tParameters.add(new TParameter<>("GeoLocationAbbr", pubGeoLocation.getGeoLocationAbbr()));
        tParameters.add(new TParameter<>("GeoLocationCode", pubGeoLocation.getGeoLocationCode()));
        tParameters.add(new TParameter<>("GeoLocationExt", pubGeoLocation.getGeoLocationExt()));
        tParameters.add(new TParameter<>("GeoLocationDesc", pubGeoLocation.getGeoLocationDesc()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("iGeoLocationID", geoLocationID));
        updSP("PubUpdGeoLocation", tParameters);
        return pubShowGeoLocationByID(geoLocationID);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "geoLocationID", "geoLocationID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "geoFatherLocationID", "geoFatherLocationID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "geoLocationTypeID", "geoLocationTypeID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "geoLocationCode", "کد", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "geoLocationAbbr", "geoLocationAbbr", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "geoLocationExt", "geoLocationExt", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "geoLocationDesc", "عنوان", Type.STRING, 200, true, true, false));
        return new Meta(cols);
    }
}
