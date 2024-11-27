package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.sale.SalePaymentElement;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Salehi
 */
public interface SalePaymentElementRepository extends TCrudRepository<SalePaymentElement>, CrudRepository<SalePaymentElement, BigDecimal> {

    default List<SalePaymentElement> saleShowPaymentElement() {
        //
        List<TParameter<?>> tParameters = new ArrayList<>();
        //این اس پی هیچ پارامتری دریافت نمی کرد
        return showSP("SaleShowPaymentElement", tParameters, true);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        //
        cols.add(new Col(null, "mID", "mID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "mCode", "کد", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "mDesc", "شرح", Type.STRING, 130, true, true, false));
        //
        return new Meta(cols);
    }
}
