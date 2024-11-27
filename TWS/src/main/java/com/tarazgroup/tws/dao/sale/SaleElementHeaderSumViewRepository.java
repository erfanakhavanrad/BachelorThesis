package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.inv.InvActuaryStore;
import com.tarazgroup.tws.model.sale.SaleCrystalRepVoucher;
import com.tarazgroup.tws.model.sale.SaleElementHeaderSumView;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 5/7/22
 *
 * @author Erfan Akhavan
 */
public interface SaleElementHeaderSumViewRepository extends TCrudRepository<SaleElementHeaderSumView>, CrudRepository<SaleElementHeaderSumView, BigDecimal> {

    //    GET BY ID
    default SaleElementHeaderSumView saleShowElementHeaderSumViewByVoucherHeaderID(BigDecimal voucherHeaderID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("VoucherHeaderID", voucherHeaderID));
        return showSP("SaleShowElementHeaderSumView", tParameters, true).get(0);
    }



}
