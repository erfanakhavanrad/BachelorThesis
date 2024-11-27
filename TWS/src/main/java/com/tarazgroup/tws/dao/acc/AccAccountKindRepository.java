package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccAccountKind;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public interface AccAccountKindRepository extends TCrudRepository<AccAccountKind>, CrudRepository<AccAccountKind, BigDecimal> {

    default List<AccAccountKind> showSPDefault(AccAccountKind accAccountKind) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", ""));
        tParameters.add(new TParameter<>("ServerFilter", accAccountKind._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", accAccountKind._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", ""));
        tParameters.add(new TParameter<>("PageFilter", accAccountKind._pageFilter()));
        return showSP("AccShowAccountKind", tParameters, true);
    }

    default AccAccountKind showSPByID(BigDecimal accountKindID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND main.AccountKindID=" + accountKindID));
        tParameters.add(new TParameter<>("OtherFilter", ""));
        tParameters.add(new TParameter<>("ServerFilter", ""));
        tParameters.add(new TParameter<>("YearFilter", ""));
        tParameters.add(new TParameter<>("UserAccessFilter", ""));
        tParameters.add(new TParameter<>("PageFilter", ""));
        return showSP("AccShowAccountKind", tParameters, true).get(0);
    }

    default AccAccountKind accInsAccountKind(AccAccountKind accAccountKind) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter("AccountKindCode", accAccountKind.getAccountKindCode()));
        tParameters.add(new TParameter("AccountKindDesc", accAccountKind.getAccountKindDesc()));
        tParameters.add(new TParameter("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("AccInsAccountKind", tParameters);
        return showSPByID(newID);
    }

    default AccAccountKind accUpdAccountKind(AccAccountKind accAccountKind, BigDecimal accountKindID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter("AccountKindID", accountKindID));
        tParameters.add(new TParameter("AccountKindCode", accAccountKind.getAccountKindCode()));
        tParameters.add(new TParameter("AccountKindDesc", accAccountKind.getAccountKindDesc()));
        tParameters.add(new TParameter("ModifierID", logLogins.getPubUser().getCreatorID()));
        tParameters.add(new TParameter("LoginID", logLogins.getLoginId()));
        updSP("AccUpdAccountKind", tParameters);
        return showSPByID(accountKindID);
    }

    default void accDelAccountKind(BigDecimal accountKindID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter("AccountKindID", accountKindID));
        tParameters.add(new TParameter("LoginID", logLogins.getLoginId()));
        delSP("AccDelAccountKind", tParameters);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null,"accountKindID", "accountKindID", Type.DECIMAL, 100, false, false,  true));
        cols.add(new Col(null,"accountKindCode", "نوع", Type.STRING, 150, true, true,  false));
        cols.add(new Col(null,"accountKindDesc", "شرح نوع حساب", Type.STRING, 300, true, true,  false));
        return new Meta(cols);
    }
}
