package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccManifestDetail;
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
public interface AccManifestDetailRepository extends TCrudRepository<AccManifestDetail>, CrudRepository<AccManifestDetail, BigDecimal> {
    default List<AccManifestDetail> accShowManifestDetail(AccManifestDetail accManifestDetail) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", accManifestDetail._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", accManifestDetail._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", accManifestDetail._pageFilter()));
        return showSP("AccShowManifestDetail", tParameters, true);
    }

    default AccManifestDetail accShowManifestDetailByID(BigDecimal voucherDetailID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Det.VoucherDetailID = " + voucherDetailID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("AccShowManifestDetail", tParameters, true).get(0);
    }

    default AccManifestDetail accInsManifestDetail(AccManifestDetail accManifestDetail) {
        LogLogins logLogins= fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("VoucherHeaderID", accManifestDetail.getVoucherHeaderID()));
        tParameters.add(new TParameter<>("VoucherDetailID", accManifestDetail.getVoucherDetailID()));
        tParameters.add(new TParameter<>("AccountID", accManifestDetail.getAccountID()));
        tParameters.add(new TParameter<>("TafsiliID", accManifestDetail.getTafsiliID()));
        tParameters.add(new TParameter<>("Center1ID", accManifestDetail.getCenter1ID()));
        tParameters.add(new TParameter<>("Center2ID", accManifestDetail.getCenter2ID()));
        tParameters.add(new TParameter<>("Center3ID", accManifestDetail.getCenter3ID()));
        tParameters.add(new TParameter<>("Bed", accManifestDetail.getBed()));
        tParameters.add(new TParameter<>("Bes", accManifestDetail.getBes()));
        tParameters.add(new TParameter<>("DetailXDesc", accManifestDetail.getDetailXDesc()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("AccInsManifestDetail", tParameters);
        return accShowManifestDetailByID(newID);
    }

    default void accDelManifestDetail(BigDecimal voucherDetailID) {
        LogLogins logLogins= fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("VoucherDetailID", voucherDetailID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("AccDelManifestDetail", tParameters);
    }

}
