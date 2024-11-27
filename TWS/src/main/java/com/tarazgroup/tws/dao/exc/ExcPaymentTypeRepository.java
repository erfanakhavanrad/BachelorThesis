package com.tarazgroup.tws.dao.exc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.exc.ExcPaymentType;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Farahani
 */
public interface ExcPaymentTypeRepository extends TCrudRepository<ExcPaymentType>, CrudRepository<ExcPaymentType, BigDecimal> {
    default List<ExcPaymentType> excShowPaymentType(ExcPaymentType excPaymentType) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", excPaymentType._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", excPaymentType._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", excPaymentType._pageFilter()));
        return showSP("ExcShowPaymentType", tParameters, true);
    }

    default ExcPaymentType excShowPaymentTypeByID(BigDecimal paymentTypeID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.PaymentTypeID = " + paymentTypeID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("ExcShowPaymentType", tParameters, true).get(0);
    }

    default ExcPaymentType excInsPaymentType(ExcPaymentType excPaymentType) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("PaymentTypeDesc", excPaymentType.getPaymentTypeDesc()));
        tParameters.add(new TParameter<>("TafsiliID", excPaymentType.getTafsiliID()));
        tParameters.add(new TParameter<>("VoucherTypeID", excPaymentType.getVoucherTypeID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("IsAdder", excPaymentType.getIsAdder()));
        tParameters.add(new TParameter<>("RecieptTypeID", excPaymentType.getRecieptTypeId()));
        tParameters.add(new TParameter<>("VoucherTypeIDs", excPaymentType.getVoucherTypeIDs()));
        BigDecimal newID = insSP("ExcInsPaymentType", tParameters);
        return excShowPaymentTypeByID(newID);
    }

    default ExcPaymentType excUpdPaymentType(BigDecimal paymentTypeID, ExcPaymentType excPaymentType) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("PaymentTypeID", paymentTypeID));
        tParameters.add(new TParameter<>("VoucherTypeID", excPaymentType.getVoucherTypeID()));
        tParameters.add(new TParameter<>("PaymentTypeDesc", excPaymentType.getPaymentTypeDesc()));
        tParameters.add(new TParameter<>("TafsiliID", excPaymentType.getTafsiliID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("IsAdder", excPaymentType.getIsAdder()));
        tParameters.add(new TParameter<>("RecieptTypeID", excPaymentType.getRecieptTypeId()));
        tParameters.add(new TParameter<>("VoucherTypeIDs", excPaymentType.getVoucherTypeIDs()));
        updSP("ExcUpdPaymentType", tParameters);
        return excShowPaymentTypeByID(paymentTypeID);
    }

    default void excDelPaymentType(BigDecimal paymentTypeID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("PaymentTypeID", paymentTypeID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("ExcDelPaymentType", tParameters);
    }
}
