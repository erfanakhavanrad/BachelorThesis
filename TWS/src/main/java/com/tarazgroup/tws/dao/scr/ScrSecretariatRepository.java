package com.tarazgroup.tws.dao.scr;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.scr.ScrSecretariat;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Farahani
 * @date Dec-22, 2021
 */
public interface ScrSecretariatRepository extends TCrudRepository<ScrSecretariat>, CrudRepository<ScrSecretariat, BigDecimal> {
    default List<ScrSecretariat> scrShowSecretariat(ScrSecretariat scrSecretariat) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", scrSecretariat._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", scrSecretariat._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("IsWebUser", null));
        tParameters.add(new TParameter<>("PageFilter", scrSecretariat._pageFilter()));
        return showSP("ScrShowSecretariat", tParameters, true);
    }

    default ScrSecretariat scrShowSecretariatByID(BigDecimal secretariatID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.secretariatID = " + secretariatID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("IsWebUser", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("ScrShowSecretariat", tParameters, true).get(0);
    }

    default ScrSecretariat scrInsSecretariat(ScrSecretariat scrSecretariat) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("SecretariatCode", scrSecretariat.getSecretariatCode()));
        tParameters.add(new TParameter<>("SecretariatName", scrSecretariat.getSecretariatName()));
        tParameters.add(new TParameter<>("OrganizationChartID", scrSecretariat.getOrganizationChartID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
//        tParameters.add(new TParameter<>("A4Letter", scrSecretariat.getA4Letter()));
//        tParameters.add(new TParameter<>("A5Letter", scrSecretariat.getA5Letter()));
//        tParameters.add(new TParameter<>("A4Sample", scrSecretariat.getA4Sample()));
//        tParameters.add(new TParameter<>("A5Sample", scrSecretariat.getA5Sample()));
        tParameters.add(new TParameter<>("IsMyNote", scrSecretariat.getIsMyNote()));
        BigDecimal newID = insSP("ScrInsSecretariat", tParameters);
        return scrShowSecretariatByID(newID);
    }

    default void scrDelSecretariat(BigDecimal secretariatID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("SecretariatID", secretariatID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("ScrDelSecretariat", tParameters);
    }

    default ScrSecretariat scrUpdSecretariat(BigDecimal secretariatID, ScrSecretariat scrSecretariat) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("SecretariatID", secretariatID));
        tParameters.add(new TParameter<>("SecretariatCode", scrSecretariat.getSecretariatCode()));
        tParameters.add(new TParameter<>("SecretariatName", scrSecretariat.getSecretariatName()));
        tParameters.add(new TParameter<>("OrganizationChartID", scrSecretariat.getOrganizationChartID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
//        tParameters.add(new TParameter<>("A4Letter", scrSecretariat.getA4Letter()));
//        tParameters.add(new TParameter<>("A5Letter", scrSecretariat.getA5Letter()));
//        tParameters.add(new TParameter<>("A4Sample", scrSecretariat.getA4Sample()));
//        tParameters.add(new TParameter<>("A5Sample", scrSecretariat.getA5Sample()));
        tParameters.add(new TParameter<>("IsMyNote", scrSecretariat.getIsMyNote()));
        updSP("ScrUpdSecretariat", tParameters);
        return scrShowSecretariatByID(secretariatID);
    }

}
