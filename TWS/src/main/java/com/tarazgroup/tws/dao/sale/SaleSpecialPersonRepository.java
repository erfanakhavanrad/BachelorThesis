package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.sale.SaleSpecialPerson;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Salehi
 */

public interface SaleSpecialPersonRepository extends TCrudRepository<SaleSpecialPerson>, CrudRepository<SaleSpecialPerson, BigDecimal> {
    default List<SaleSpecialPerson> saleShowSpecialPerson(SaleSpecialPerson saleSpecialPerson) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", saleSpecialPerson._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", saleSpecialPerson._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", saleSpecialPerson._pageFilter()));
        //
        return showSP("SaleShowSpecialPerson", tParameters, true);
    }

    default SaleSpecialPerson saleShowSpecialPersonByID(BigDecimal specialManID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        tParameters.add(new TParameter<>("Filter", "And Main.SpecialManID=" + specialManID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        //
        return showSP("SaleShowSpecialPerson", tParameters, true).get(0);
    }

    default SaleSpecialPerson saleInsSpecialPerson(SaleSpecialPerson saleSpecialPerson) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        LogLogins logLogins = fetchUserDetail();
        //
        tParameters.add(new TParameter<>("ManID", saleSpecialPerson.getManID()));
        tParameters.add(new TParameter<>("LookUPID", saleSpecialPerson.getLookUPID()));
        tParameters.add(new TParameter<>("VoucherDesc", saleSpecialPerson.getVoucherDesc()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        //
        BigDecimal newID = insSP("SaleInsSpecialPerson", tParameters);
        return saleShowSpecialPersonByID(newID);
    }

    default SaleSpecialPerson saleUpdSpecialPerson(BigDecimal specialManID, SaleSpecialPerson saleSpecialPerson) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        LogLogins logLogins = fetchUserDetail();
        //
        tParameters.add(new TParameter<>("SpecialManID", specialManID));
        tParameters.add(new TParameter<>("ManID", saleSpecialPerson.getManID()));
        tParameters.add(new TParameter<>("LookUPID", saleSpecialPerson.getLookUPID()));
        tParameters.add(new TParameter<>("VoucherDesc", saleSpecialPerson.getVoucherDesc()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        //
        updSP("SaleUpdSpecialPerson", tParameters);
        return saleShowSpecialPersonByID(specialManID);
    }

    default void saleDelSpecialPerson(BigDecimal specialManID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        LogLogins logLogins = fetchUserDetail();
        //
        tParameters.add(new TParameter<>("SpecialManID", specialManID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        //
        delSP("SaleDelSpecialPerson", tParameters);
    }

}
