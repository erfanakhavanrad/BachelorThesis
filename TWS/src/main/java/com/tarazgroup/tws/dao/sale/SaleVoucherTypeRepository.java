package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.sale.SaleVoucherType;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Farahani
 */

// TODO: 12/11/21 Doesn't have page filter

public interface SaleVoucherTypeRepository extends TCrudRepository<SaleVoucherType>, CrudRepository<SaleVoucherType, BigDecimal> {
    default List<SaleVoucherType> saleShowVoucherType(SaleVoucherType saleVoucherType) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", saleVoucherType._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", saleVoucherType._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("SaleShowVoucherType", tParameters, true);
    }

    default SaleVoucherType saleShowVoucherTypeByID(BigDecimal voucherTypeID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.VoucherTypeID = " + voucherTypeID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("SaleShowVoucherType", tParameters, true).get(0);
    }

    default SaleVoucherType saleUpdVoucherType(BigDecimal voucherTypeID, SaleVoucherType saleVoucherType) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("VoucherTypeID", voucherTypeID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("IsContinueNum", saleVoucherType.getIsContinueNum()));
        tParameters.add(new TParameter<>("IsAutoNumber", saleVoucherType.getIsAutoNumber()));
        tParameters.add(new TParameter<>("FromNum", saleVoucherType.getFromNum()));
        updSP("SaleUpdVoucherType", tParameters);
        return saleShowVoucherTypeByID(voucherTypeID);
    }
}
