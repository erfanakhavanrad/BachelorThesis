package com.tarazgroup.tws.dao.ast;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.ast.AstKind;
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
 * 12/29/21
 *
 * @author Erfan Akhavan
 */
public interface AstKindRepository extends TCrudRepository<AstKind>, CrudRepository<AstKind, BigDecimal> {

    default List<AstKind> astShowKind(AstKind astKind) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", astKind._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", astKind._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", astKind._pageFilter()));
        return showSP("AstShowKind", tParameters, true);
    }


    default AstKind astShowKindByID(BigDecimal kindID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " And main.kindID= " + kindID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("AstShowKind", tParameters, true).get(0);
    }

    default AstKind astInsKind(AstKind astKind) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("KindCode", astKind.getKindCode()));
        tParameters.add(new TParameter<>("KindName", astKind.getKindName()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("AstInsKind", tParameters);
        return astShowKindByID(newID);
    }


    default AstKind astUpdKind(AstKind astKind, BigDecimal kindID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("KindID", kindID));
        tParameters.add(new TParameter<>("KindCode", astKind.getKindCode()));
        tParameters.add(new TParameter<>("KindName", astKind.getKindName()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("AstUpdKind", tParameters);
        return astShowKindByID(kindID);
    }

    default void astDelKind(BigDecimal kindID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("KindID", kindID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("AstDelKind", tParameters);
    }


    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "kindID", "kindID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "kindCode", "کد", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "kindName", "شرح", Type.STRING, 150, true, true, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 0, false, false, false));
        return new Meta(cols);
    }


}
