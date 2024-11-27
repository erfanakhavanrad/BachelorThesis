package com.tarazgroup.tws.dao.pub;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.pub.PubTheme;
import com.tarazgroup.tws.model.tkt.TktSatisfaction;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public interface PubThemeRepository extends TCrudRepository<PubTheme>, CrudRepository<PubTheme, BigDecimal> {
    default List<PubTheme> pubShowTheme(PubTheme pubTheme) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", pubTheme._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", pubTheme._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", pubTheme._pageFilter()));
        return showSP("PubShowTheme", tParameters, true);
    }

    default Meta meta(){
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "themeID",   "themeID", Type.DECIMAL, 0,   false, false, true ));
        cols.add(new Col(null, "themeDesc", "عنوان تم",      Type.STRING,  100, true,  true,  false));
        cols.add(new Col(null, "creatorID",        "creatorID",      Type.DECIMAL, 0,   false, false, false));
        cols.add(new Col(null, "createDate",       "createDate",     Type.DATE,    0,   false, false, false));
        cols.add(new Col(null, "modifierID",       "modifierID",     Type.DECIMAL, 0,   false, false, false));
        cols.add(new Col(null, "modifyDate",       "modifyDate",     Type.DATE,    0,   false, false, false));
        cols.add(new Col(null, "serverID",         "serverID",       Type.DECIMAL, 0,   false, false, false));

        return new Meta(cols);
    }
}
