package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccPercomContact;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Farahani
 * @date 12/13/21
 */
public interface AccPercomContactRepository extends TCrudRepository<AccPercomContact>, CrudRepository<AccPercomContact, BigDecimal> {
    default List<AccPercomContact> accShowPercomContact(AccPercomContact accPercomContact) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", accPercomContact._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", accPercomContact._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", accPercomContact._pageFilter()));
        return showSP("AccShowPercomContact", tParameters, true);
    }

    default AccPercomContact accShowPercomContactByID(BigDecimal contactID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.ContactID = " + contactID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("AccShowPercomContact", tParameters, true).get(0);
    }

//    default AccPercomContact accInsPercomContact(AccPercomContact accPercomContact) {
//        LogLogins logLogins = fetchUserDetail();
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter<>("ContactTypeID", accPercomContact.getContactTypeID()));
//        tParameters.add(new TParameter<>("PercomID", accPercomContact.getPercomID()));
//        tParameters.add(new TParameter<>("PercomContactDesc", accPercomContact.getPercomContactDesc()));
//        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
//        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
//        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
//        BigDecimal newID = insSP("AccInsPercomContact", tParameters);
//        return accShowPercomContactByID(newID);
//    }

    default AccPercomContact accUpdPercomContact(BigDecimal contactID, AccPercomContact accPercomContact) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("ContactID", contactID));
        tParameters.add(new TParameter<>("ContactTypeID", accPercomContact.getContactTypeID()));
        tParameters.add(new TParameter<>("PercomID", accPercomContact.getPercomID()));
        tParameters.add(new TParameter<>("PercomContactDesc", accPercomContact.getPercomContactDesc()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("AccUpdPercomContact", tParameters);
        return accShowPercomContactByID(contactID);
    }

    default void accDelPercomContact(BigDecimal contactID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("ContactID", contactID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("PercomID", null));
        delSP("AccDelPercomContact", tParameters);
    }
}
