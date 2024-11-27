package com.tarazgroup.tws.dao.ast;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.ast.AstLoc;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Erfan Akhavan
 */
public interface AstLocRepository extends TCrudRepository<AstLoc>, CrudRepository<AstLoc, BigDecimal> {

    default List<AstLoc> astShowLoc(AstLoc astLoc) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", astLoc._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", astLoc._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", astLoc._pageFilter()));
        return showSP("AstShowLoc", tParameters, true);
    }

    default AstLoc astShowLocByID(BigDecimal locID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " And main.locID= " + locID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("AstShowLoc", tParameters, true).get(0);
    }

    default AstLoc astInsLoc(AstLoc astLoc) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("LocFatherID", astLoc.getLocFatherID()));
        tParameters.add(new TParameter<>("LocCode", astLoc.getLocCode()));
        tParameters.add(new TParameter<>("LocName", astLoc.getLocName()));
        tParameters.add(new TParameter<>("LocDesc", astLoc.getLocDesc()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("AstInsLoc", tParameters);
        return astShowLocByID(newID);
    }

    default AstLoc astUpdLoc(AstLoc astLoc, BigDecimal locID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("LocID", locID));
        tParameters.add(new TParameter<>("LocFatherID", astLoc.getLocFatherID()));
        tParameters.add(new TParameter<>("LocCode", astLoc.getLocCode()));
        tParameters.add(new TParameter<>("LocName", astLoc.getLocName()));
        tParameters.add(new TParameter<>("LocDesc", astLoc.getLocDesc()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getModifierID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("AstUpdLoc", tParameters);
        return astShowLocByID(locID);
    }

    default void astDelLoc(BigDecimal locID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("LocID", locID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("AstDelLoc", tParameters);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "locID", "locID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "locCode", "کد محل استقرار", Type.STRING, 150, true, true, false));
        cols.add(new Col(null, "locName", "شرح", Type.STRING, 150, true, true, false));
        cols.add(new Col(null, "locDesc", "نام محل استقرار", Type.STRING, 150, true, true, false));
        cols.add(new Col(null, "locFatherID", "locFatherID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "rowCnt", "rowCnt", Type.INTEGER, 100, false, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 100, false, false, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 100, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 100, false, false, false));
        return new Meta(cols);
    }

}
