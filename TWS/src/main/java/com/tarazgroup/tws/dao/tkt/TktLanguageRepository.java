package com.tarazgroup.tws.dao.tkt;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.tkt.TktLanguage;
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
public interface TktLanguageRepository extends TCrudRepository<TktLanguage>, CrudRepository<TktLanguage, BigDecimal> {
    default List<TktLanguage> tktShowLanguage(TktLanguage tktLanguage) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", tktLanguage._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", tktLanguage._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", tktLanguage._pageFilter()));
        return showSP("TktShowLanguage", tParameters, true);
    }

    default TktLanguage tktShowLanguageByID(BigDecimal languageID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.LanguageID = " + languageID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("TktShowLanguage", tParameters, true).get(0);
    }

    default Meta meta(){
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "languageID",     "languageID",     Type.DECIMAL, 0,   false, false, true ));
        cols.add(new Col(null, "languageName",   "زبان",        Type.STRING,  100, true,  true,  false));
        cols.add(new Col(null, "creatorID",  "creatorID",  Type.DECIMAL, 0,   false, false, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE,    0,   false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 0,   false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE,    0,   false, false, false));
        cols.add(new Col(null, "serverID",   "serverID",   Type.DECIMAL, 0,   false, false, false));

        return new Meta(cols);
    }
}
