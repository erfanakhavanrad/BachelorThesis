package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.sale.SaleGradeCustomers;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Salehi
 */

public interface SaleGradeCustomersRepository extends TCrudRepository<SaleGradeCustomers>, CrudRepository<SaleGradeCustomers, BigDecimal> {
    default List<SaleGradeCustomers> saleShowGradeCustomers(SaleGradeCustomers saleGradeCustomers) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", saleGradeCustomers._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", saleGradeCustomers._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", saleGradeCustomers._pageFilter()));
        //
        return showSP("SaleShowGradeCustomers", tParameters, true);
    }

    default SaleGradeCustomers saleShowGradeCustomersByID(BigDecimal gradeID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        tParameters.add(new TParameter<>("Filter", "And Main.GradeID=" + gradeID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        //
        return showSP("SaleShowGradeCustomers", tParameters, true).get(0);
    }

    default SaleGradeCustomers saleInsGradeCustomers(SaleGradeCustomers saleGradeCustomers) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        LogLogins logLogins = fetchUserDetail();
        //
        tParameters.add(new TParameter<>("GradeCode", saleGradeCustomers.getGradeCode()));
        tParameters.add(new TParameter<>("GradeDesc", saleGradeCustomers.getGradeDesc()));
        tParameters.add(new TParameter<>("GradeProminence", saleGradeCustomers.getGradeProminence()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        //
        BigDecimal newID = insSP("SaleInsGradeCustomers", tParameters);
        return saleShowGradeCustomersByID(newID);
    }

    default SaleGradeCustomers saleUpdGradeCustomers(BigDecimal gradeID, SaleGradeCustomers saleGradeCustomers) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        LogLogins logLogins = fetchUserDetail();
        //
        tParameters.add(new TParameter<>("GradeID", gradeID));
        tParameters.add(new TParameter<>("GradeCode", saleGradeCustomers.getGradeCode()));
        tParameters.add(new TParameter<>("GradeDesc", saleGradeCustomers.getGradeDesc()));
        tParameters.add(new TParameter<>("GradeProminence", saleGradeCustomers.getGradeProminence()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        //
        updSP("SaleUpdGradeCustomers", tParameters);
        //
        return saleShowGradeCustomersByID(gradeID);
    }

    default void SaleDelGradeCustomers(BigDecimal gradeID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        LogLogins logLogins = fetchUserDetail();
        //
        tParameters.add(new TParameter<>("GradeID", gradeID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        //
        delSP("SaleDelGradeCustomers", tParameters);
    }
}
