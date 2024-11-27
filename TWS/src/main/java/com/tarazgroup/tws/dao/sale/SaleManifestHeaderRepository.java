package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.sale.SaleManifestHeader;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Farahani
 * Dec-20, 2021
 */
// TODO: 12/20/21 doesn't have page filter

public interface SaleManifestHeaderRepository extends TCrudRepository<SaleManifestHeader>, CrudRepository<SaleManifestHeader, BigDecimal> {
    default List<SaleManifestHeader> saleShowManifestHeader(SaleManifestHeader saleManifestHeader) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", saleManifestHeader._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", saleManifestHeader._yearFilter()));
        tParameters.add(new TParameter<>("UserSaleessFilter", null));
        return showSP("SaleShowManifestHeader", tParameters, true);
    }

    default SaleManifestHeader saleShowManifestHeaderByID(BigDecimal voucherHeaderID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.voucherHeaderID = " + voucherHeaderID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserSaleessFilter", null));
        return showSP("SaleShowManifestHeader", tParameters, true).get(0);
    }

    default SaleManifestHeader saleInsManifestHeader(SaleManifestHeader saleManifestHeader) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("VoucherNumber", saleManifestHeader.getVoucherNumber()));
        tParameters.add(new TParameter<>("VoucherDate", saleManifestHeader.getVoucherDate()));
        tParameters.add(new TParameter<>("SaleManID", saleManifestHeader.getSaleManID()));
        tParameters.add(new TParameter<>("DriverID", saleManifestHeader.getDriverID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("YearID", saleManifestHeader.getYearID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("SecondNumber", saleManifestHeader.getSecondNumber()));
        tParameters.add(new TParameter<>("DistNameID", saleManifestHeader.getDistNameID()));
        BigDecimal newID = insSP("SaleInsManifestHeader", tParameters);
        return saleShowManifestHeaderByID(newID);
    }

    default SaleManifestHeader saleUpdManifestHeader(BigDecimal voucherHeaderID, SaleManifestHeader saleManifestHeader) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("VoucherHeaderID", voucherHeaderID));
        tParameters.add(new TParameter<>("VoucherDate", saleManifestHeader.getVoucherDate()));
        tParameters.add(new TParameter<>("SaleManID", saleManifestHeader.getSaleManID()));
        tParameters.add(new TParameter<>("DriverID", saleManifestHeader.getDriverID()));
        tParameters.add(new TParameter<>("DistNameID", saleManifestHeader.getDistNameID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("SaleUpdManifestHeader", tParameters);
        return saleShowManifestHeaderByID(voucherHeaderID);
    }

    default void saleDelManifestHeader(BigDecimal voucherHeaderID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("VoucherHeaderID", voucherHeaderID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("SaleDelManifestHeader", tParameters);
    }

}
