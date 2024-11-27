package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccStandardDesc;
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
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
public interface AccStandardDescRepository extends TCrudRepository<AccStandardDesc>, CrudRepository<AccStandardDesc, BigDecimal> {

    default List<AccStandardDesc> accShowStandardDesc(AccStandardDesc accStandardDesc) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", accStandardDesc._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", accStandardDesc._yearFilter()));
        tParameters.add(new TParameter<>("PageFilter", accStandardDesc._pageFilter()));
        return showSP("AccShowStandardDesc", tParameters, true);
    }

    default AccStandardDesc accShowStandardDesc‌ByID(BigDecimal standardDescID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.StandardDescID = " + standardDescID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("AccShowStandardDesc", tParameters, true).get(0);
    }

    default AccStandardDesc accInsStandardDesc(AccStandardDesc accStandardDesc) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("AccountID", accStandardDesc.getAccountID()));
        tParameters.add(new TParameter<>("StandardDesc", accStandardDesc.getStandardDesc()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getCreatorID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("AccInsStandardDesc", tParameters);
        return accShowStandardDesc‌ByID(newID);
    }

    default void accDelStandardDesc(BigDecimal standardDescID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("StandardDescID", standardDescID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("AccDelStandardDesc", tParameters);
    }

    default AccStandardDesc accUpdStandardDesc(BigDecimal standardDescID, AccStandardDesc accStandardDesc) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("StandardDescID", standardDescID));
        tParameters.add(new TParameter<>("AccountID", accStandardDesc.getAccountID()));
        tParameters.add(new TParameter<>("StandardDesc", accStandardDesc.getStandardDesc()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("AccUpdStandardDesc", tParameters);
        return accShowStandardDesc‌ByID(standardDescID);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null,"standardDescID", "standardDescID", Type.DECIMAL, 100, false, false,  true));
        cols.add(new Col(null,"accountID", "accountID", Type.DECIMAL, 100, false, false,  false));
        cols.add(new Col(null,"accountCode", "accountCode", Type.DECIMAL, 100, false, false,  false));
        cols.add(new Col(null,"accountDesc", "شرح حساب", Type.STRING, 300, true, true,  false));
        cols.add(new Col(null,"standardDesc", "شرح استاندارد", Type.STRING, 300, true, true,  false));
        cols.add(new Col(null,"serverID", "serverID", Type.DECIMAL, 130, false, false,  false));
        cols.add(new Col(null,"createDate", "createDate", Type.DATE, 200, false, false,  false));
        cols.add(new Col(null,"creatorID", "creatorID", Type.DECIMAL, 80, false, false,  false));
        cols.add(new Col(null,"modifyDate", "modifyDate", Type.DATE, 0, false, false,  false));
        cols.add(new Col(null,"modifierID", "modifierID", Type.DECIMAL, 0, false, false,  false));
        return new Meta(cols);
    }
}
