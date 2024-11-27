package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccManifestHeader;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
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
public interface AccManifestHeaderRepository extends TCrudRepository<AccManifestHeader>, CrudRepository<AccManifestHeader, BigDecimal> {
    default List<AccManifestHeader> accShowManifestHeader(AccManifestHeader accManifestHeader) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter("Filter", null));
        tParameters.add(new TParameter("OtherFilter", null));
        tParameters.add(new TParameter("ServerFilter", accManifestHeader._serverFilter()));
        tParameters.add(new TParameter("YearFilter", accManifestHeader._yearFilter()));
        tParameters.add(new TParameter("UserAccessFilter", null));
        tParameters.add(new TParameter("PageFilter", accManifestHeader._pageFilter()));
        return showSP("AccShowManifestHeader", tParameters, true);
    }

    default AccManifestHeader accShowManifestHeaderByID(BigDecimal voucherHeaderID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter("Filter", "Main.VoucherHeaderID = " + voucherHeaderID));
        tParameters.add(new TParameter("OtherFilter", null));
        tParameters.add(new TParameter("ServerFilter", null));
        tParameters.add(new TParameter("YearFilter", null));
        tParameters.add(new TParameter("UserAccessFilter", null));
        tParameters.add(new TParameter("PageFilter", null));
        return showSP("AccShowManifestHeader", tParameters, true).get(0);
    }

    default AccManifestHeader accInsManifestHeader(AccManifestHeader accManifestHeader) {
        LogLogins logLogins  = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("VoucherNumber", accManifestHeader.getVoucherNumber()));
        tParameters.add(new TParameter<>("VoucherDate", accManifestHeader.getVoucherDate()));
        tParameters.add(new TParameter<>("ManifestType", accManifestHeader.getManifestType()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("YearID", accManifestHeader.getYearID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getPubUser()));
        tParameters.add(new TParameter<>("AccountID", accManifestHeader.getAccountID()));
        tParameters.add(new TParameter<>("TafsiliID", accManifestHeader.getTafsiliID()));
        tParameters.add(new TParameter<>("ManifestDesc", accManifestHeader.getManifestDesc()));
        tParameters.add(new TParameter<>("Center1ID", accManifestHeader.getCenter1ID()));
        BigDecimal newID = insSP("AccInsManifestHeader", tParameters);
        return accShowManifestHeaderByID(newID);
    }

    default void accDelManifestHeader(BigDecimal voucherHeaderID) {
        LogLogins logLogins  = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("voucherHeaderID", voucherHeaderID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("AccDelManifestHeader", tParameters);
    }
}
