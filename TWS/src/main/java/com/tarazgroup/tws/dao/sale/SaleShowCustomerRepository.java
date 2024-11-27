package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.sale.SaleCustomer;
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

public interface SaleShowCustomerRepository extends TCrudRepository<SaleCustomer>, CrudRepository<SaleCustomer, BigDecimal> {

    default List<SaleCustomer> customers(SaleCustomer saleCustomer) {
        saleCustomer.setFilter("PersonTypeID = 1");
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter("Filter", " AND main.PersonTypeID = 1"));
        tParameters.add(new TParameter("OtherFilter", null));
        tParameters.add(new TParameter("ServerFilter", null));
        tParameters.add(new TParameter("YearFilter", null));
        tParameters.add(new TParameter("UserAccessFilter", null));
        tParameters.add(new TParameter("PageFilter", saleCustomer._pageFilter()));
        return showSP("SaleShowCustomer", tParameters, true);
    }

    default List<SaleCustomer> marketingMen() {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter("Filter", " AND main.PersonTypeID = 2 AND main.isActive=1"));
        tParameters.add(new TParameter("OtherFilter", null));
        tParameters.add(new TParameter("ServerFilter", null));
        tParameters.add(new TParameter("YearFilter", null));
        tParameters.add(new TParameter("UserAccessFilter", null));
        tParameters.add(new TParameter("PageFilter", null));
        return showSP("SaleShowCustomer", tParameters, true);
    }

    default List<SaleCustomer> sellers() {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter("Filter", " AND main.PersonTypeID = 3"));
        tParameters.add(new TParameter("OtherFilter", null));
        tParameters.add(new TParameter("ServerFilter", null));
        tParameters.add(new TParameter("YearFilter", null));
        tParameters.add(new TParameter("UserAccessFilter", null));
        tParameters.add(new TParameter("PageFilter", null));
        return showSP("SaleShowCustomer", tParameters, true);
    }

    default Meta meta(){
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "customerID", "customerID", Type.DECIMAL, false,0, false, false, true));
        cols.add(new Col(null, "customerCode", "customerCode", Type.DECIMAL, false,0, false, false, false));
        cols.add(new Col(null, "customerDesc", "customerDesc", Type.STRING, false,100, true, false, false));
        cols.add(new Col(null, "customerName", "نام فروشنده", Type.STRING, true,100, true, false, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, false,0, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, false,0, false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, false,0, false, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, false,0, false, false, false));
        return new Meta(cols);
    }
}
