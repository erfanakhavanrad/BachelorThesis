package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.sale.SaleBonusDetail;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Salehi
 */
public interface SaleBonusDetailRepository extends TCrudRepository<SaleBonusDetail>, CrudRepository<SaleBonusDetail, BigDecimal> {

    default List<SaleBonusDetail> saleShowBonusDetail(SaleBonusDetail saleBonusDetail) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", saleBonusDetail._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", saleBonusDetail._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        // TODO در این اس پی باید پیج فیلتر اضافه شود
        //
        return showSP("SaleShowBonusDetail", tParameters, true);
    }

    default SaleBonusDetail saleShowBonusDetailByID(BigDecimal voucherDetailID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        tParameters.add(new TParameter<>("Filter", "And Det.VoucherDetailID=" + voucherDetailID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        //
        return showSP("SaleShowBonusDetail", tParameters, true).get(0);
    }

    default SaleBonusDetail saleInsBonusDetail(SaleBonusDetail saleBonusDetail) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        LogLogins logLogins = fetchUserDetail();
        //
        tParameters.add(new TParameter<>("VoucherHeaderID", saleBonusDetail.getVoucherHeaderID()));
        tParameters.add(new TParameter<>("Amount", saleBonusDetail.getAmount()));
        tParameters.add(new TParameter<>("FromNum", saleBonusDetail.getFromNum()));
        tParameters.add(new TParameter<>("ToNum", saleBonusDetail.getToNum()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("GoodsID", saleBonusDetail.getGoodsID()));
        tParameters.add(new TParameter<>("SecUnitID", saleBonusDetail.getSecUnitID()));
        //
        BigDecimal newID = insSP("SaleInsBonusDetail", tParameters);
        //
        return saleShowBonusDetailByID(newID);
    }

    default SaleBonusDetail saleUpdBonusDetail(BigDecimal voucherDetailID, SaleBonusDetail saleBonusDetail) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        LogLogins logLogins = fetchUserDetail();
        //
        tParameters.add(new TParameter<>("VoucherDetailID", voucherDetailID));
        tParameters.add(new TParameter<>("Amount", saleBonusDetail.getAmount()));
        tParameters.add(new TParameter<>("FromNum", saleBonusDetail.getFromNum()));
        tParameters.add(new TParameter<>("ToNum", saleBonusDetail.getToNum()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("GoodsID", saleBonusDetail.getGoodsID()));
        tParameters.add(new TParameter<>("SecUnitID", saleBonusDetail.getSecUnitID()));
        //
        updSP("SaleUpdBonusDetail", tParameters);
        //
        return saleShowBonusDetailByID(voucherDetailID);
    }

    default void saleDelBonusDetail(BigDecimal voucherDetailID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        LogLogins logLogins = fetchUserDetail();
        //
        tParameters.add(new TParameter<>("VoucherDetailID", voucherDetailID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        //
        delSP("SaleDelBonusDetail", tParameters);
    }

}
