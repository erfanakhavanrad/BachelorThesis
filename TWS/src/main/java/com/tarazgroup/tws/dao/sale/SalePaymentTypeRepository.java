package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.sale.SalePaymentType;
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

public interface SalePaymentTypeRepository extends TCrudRepository<SalePaymentType>, CrudRepository<SalePaymentType, BigDecimal> {

    default List<SalePaymentType> saleShowPaymentType(SalePaymentType salePaymentType) {
        //
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", salePaymentType._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", salePaymentType._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        // TODO در این اس پی باید پیج فیلتر اضافه شود
        //
        return showSP("SaleShowPaymentType", tParameters, true);
    }

    default SalePaymentType saleShowPaymentTypeByID(BigDecimal paymentTypeID) {
        //
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        tParameters.add(new TParameter<>("Filter", "And PaymentTypeID=" + paymentTypeID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        //
        return showSP("SaleShowPaymentType", tParameters, true).get(0);
    }

    default SalePaymentType saleInsPaymentType(SalePaymentType salePaymentType) {
        //
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        LogLogins logLogins = fetchUserDetail();
        //
        tParameters.add(new TParameter<>("PaymentTypeCode", salePaymentType.getPaymentTypeCode()));
        tParameters.add(new TParameter<>("PaymentTypeDesc", salePaymentType.getPaymentTypeDesc()));
        tParameters.add(new TParameter<>("FormulaText", salePaymentType.getFormulaText()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        //
        BigDecimal newID = insSP("SaleInsPaymentType", tParameters);
        //
        return saleShowPaymentTypeByID(newID);
    }

    default SalePaymentType saleUpdPaymentType(BigDecimal paymentTypeID, SalePaymentType salePaymentType) {
        //
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        LogLogins logLogins = fetchUserDetail();
        //
        tParameters.add(new TParameter<>("PaymentTypeID", paymentTypeID));
        tParameters.add(new TParameter<>("PaymentTypeCode", salePaymentType.getPaymentTypeCode()));
        tParameters.add(new TParameter<>("PaymentTypeDesc", salePaymentType.getPaymentTypeDesc()));
        tParameters.add(new TParameter<>("FormulaText", salePaymentType.getFormulaText()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        //
        updSP("SaleUpdPaymentType", tParameters);
        //
        return saleShowPaymentTypeByID(paymentTypeID);
    }

    default void saleDelPaymentType(BigDecimal paymentTypeID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        LogLogins logLogins = fetchUserDetail();
        //
        tParameters.add(new TParameter<>("PaymentTypeID", paymentTypeID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        //
        delSP("SaleDelPaymentType", tParameters);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        //
        cols.add(new Col(null, "paymentTypeID", "paymentTypeID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "paymentTypeCode", "کد", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "paymentTypeDesc", "شرح", Type.STRING, 130, true, true, false));
        cols.add(new Col(null, "formulaText", "فرمول|لاتین", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 120, false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 100, false, false, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 120, false, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "formulaTextFA", "فرمول|فارسی", Type.STRING, 100, true, true, false));
        //
        return new Meta(cols);
    }
}
