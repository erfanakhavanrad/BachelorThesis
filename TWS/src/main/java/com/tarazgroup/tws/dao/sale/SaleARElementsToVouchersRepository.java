package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.sale.SaleARElementsToVouchers;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Salehi
 */


public interface SaleARElementsToVouchersRepository extends TCrudRepository<SaleARElementsToVouchers>, CrudRepository<SaleARElementsToVouchers, BigDecimal> {

    default List<SaleARElementsToVouchers> saleShowARElementsToVouchers(SaleARElementsToVouchers saleARElementsToVouchers, String inFilter, Boolean isRound) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("InFilter", inFilter));//TODO مقدار در مدل نیست
        tParameters.add(new TParameter<>("IsRound", isRound));//TODO مقدار در مدل نیست
        return showSP("SaleShowARElementsToVouchers", tParameters, true);
    }

    default SaleARElementsToVouchers saleShowARElementsToVouchersByID(BigDecimal mID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", "And Main.mID=" + mID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("InFilter", null));//TODO مقدار در مدل نیست
        tParameters.add(new TParameter<>("IsRound", false));//TODO مقدار در مدل نیست
        return showSP("SaleShowARElementsToVouchers", tParameters, true).get(0);
    }

    default SaleARElementsToVouchers saleInsARElementsToVouchers(SaleARElementsToVouchers saleARElementsToVouchers, Integer computePriority, Integer rowNo) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("ElementID", saleARElementsToVouchers.getElementID()));
        tParameters.add(new TParameter<>("ElementMab", saleARElementsToVouchers.getElementMab()));
        tParameters.add(new TParameter<>("VoucherTypeID", saleARElementsToVouchers.getVoucherTypeID()));
        tParameters.add(new TParameter<>("VoucherHeaderID", saleARElementsToVouchers.getVoucherHeaderID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("IsActive", saleARElementsToVouchers.getIsActive()));
        tParameters.add(new TParameter<>("PrintPriority", saleARElementsToVouchers.getPrintPriority()));
        tParameters.add(new TParameter<>("ComputePriority", computePriority));//این مقدار در مدل وجود ندارد
        tParameters.add(new TParameter<>("CoEfficient", saleARElementsToVouchers.getCoEfficient()));
        tParameters.add(new TParameter<>("RowNo", rowNo));//این مقدار در مدل وجود ندارد
        BigDecimal newID = insSP("SaleInsARElementsToVouchers", tParameters);
        return saleShowARElementsToVouchersByID(newID);
    }

    default void saleDelARElementsToVouchers(BigDecimal mID, BigDecimal voucherHeaderID, BigDecimal voucherTypeID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("ElementID", mID));
        tParameters.add(new TParameter<>("VoucherHeaderID", voucherHeaderID));
        tParameters.add(new TParameter<>("VoucherTypeID", voucherTypeID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("SaleDelARElementsToVouchers", tParameters);
    }
}
