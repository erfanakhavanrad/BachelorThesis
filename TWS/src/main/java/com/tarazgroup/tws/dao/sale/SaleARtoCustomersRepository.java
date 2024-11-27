package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.sale.SaleARtoCustomers;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Farahani
 * Dec-21, 2021
 */
// TODO: 12/21/21 doesn't have page filter

public interface SaleARtoCustomersRepository extends TCrudRepository<SaleARtoCustomers>, CrudRepository<SaleARtoCustomers, BigDecimal> {
    default List<SaleARtoCustomers> saleShowARtoCustomers(SaleARtoCustomers saleARtoCustomers) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", saleARtoCustomers._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", saleARtoCustomers._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("SaleShowARtoCustomers", tParameters, true);
    }

    default SaleARtoCustomers saleShowARtoCustomersByID(BigDecimal voucherHeaderID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.voucherHeaderID = " + voucherHeaderID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("SaleShowARtoCustomers", tParameters, true).get(0);
    }

    default SaleARtoCustomers saleInsARtoCustomers(SaleARtoCustomers saleARtoCustomers) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("CustomerID", saleARtoCustomers.getCustomerID()));
        tParameters.add(new TParameter<>("VoucherNumber", saleARtoCustomers.getVoucherNumber()));
        tParameters.add(new TParameter<>("VoucherDate", saleARtoCustomers.getVoucherDate()));
        tParameters.add(new TParameter<>("VoucherPrice", saleARtoCustomers.getVoucherPrice()));
        tParameters.add(new TParameter<>("ElementID", saleARtoCustomers.getElementID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("YearID", saleARtoCustomers.getYearID()));
        tParameters.add(new TParameter<>("VoucherDesc", saleARtoCustomers.getVoucherDesc()));
        tParameters.add(new TParameter<>("Center1ID", saleARtoCustomers.getCenter1ID()));
        tParameters.add(new TParameter<>("Center2ID", saleARtoCustomers.getCenter2ID()));
        tParameters.add(new TParameter<>("Center3ID", saleARtoCustomers.getCenter3ID()));
        tParameters.add(new TParameter<>("SaleReferID", saleARtoCustomers.getSaleReferID()));
        tParameters.add(new TParameter<>("IsAuto", saleARtoCustomers.getIsAuto()));
        tParameters.add(new TParameter<>("CurrencyID", saleARtoCustomers.getCurrencyID()));
        BigDecimal newID = insSP("SaleInsARtoCustomers", tParameters);
        return saleShowARtoCustomersByID(newID);
    }

    default SaleARtoCustomers saleUpdARtoCustomers(BigDecimal voucherHeaderID, SaleARtoCustomers saleARtoCustomers) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("VoucherHeaderID", voucherHeaderID));
        tParameters.add(new TParameter<>("CustomerID", saleARtoCustomers.getCustomerID()));
        tParameters.add(new TParameter<>("VoucherNumber", saleARtoCustomers.getVoucherNumber()));
        tParameters.add(new TParameter<>("VoucherDate", saleARtoCustomers.getVoucherDate()));
        tParameters.add(new TParameter<>("VoucherPrice", saleARtoCustomers.getVoucherPrice()));
        tParameters.add(new TParameter<>("ElementID", saleARtoCustomers.getElementID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("YearID", saleARtoCustomers.getYearID()));
        tParameters.add(new TParameter<>("VoucherDesc", saleARtoCustomers.getVoucherDesc()));
        tParameters.add(new TParameter<>("Center1ID", saleARtoCustomers.getCenter1ID()));
        tParameters.add(new TParameter<>("Center2ID", saleARtoCustomers.getCenter2ID()));
        tParameters.add(new TParameter<>("Center3ID", saleARtoCustomers.getCenter3ID()));
        tParameters.add(new TParameter<>("SaleReferID", saleARtoCustomers.getSaleReferID()));
        tParameters.add(new TParameter<>("CurrencyID", saleARtoCustomers.getCurrencyID()));
        updSP("SaleUpdARtoCustomers", tParameters);
        return saleShowARtoCustomersByID(voucherHeaderID);
    }

    default void saleDelARtoCustomers(BigDecimal voucherHeaderID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("VoucherHeaderID", voucherHeaderID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("SaleDelARtoCustomers", tParameters);
    }

}
