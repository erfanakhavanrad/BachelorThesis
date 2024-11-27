package com.tarazgroup.tws.dao.trs;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.trs.TrsRecieptType;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Farahani
 */
public interface TrsRecieptTypeRepository extends TCrudRepository<TrsRecieptType>, CrudRepository<TrsRecieptType, BigDecimal> {
    default List<TrsRecieptType> trsShowRecieptType(TrsRecieptType trsRecieptType) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", trsRecieptType._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", trsRecieptType._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", trsRecieptType._pageFilter()));
        return showSP("TrsShowRecieptType", tParameters, true);
    }

    default TrsRecieptType trsShowRecieptTypeByID(BigDecimal recieptTypeID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.RecieptTypeID = " + recieptTypeID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("TrsShowRecieptType", tParameters, true).get(0);
    }

    default TrsRecieptType trsInsRecieptType(TrsRecieptType trsRecieptType) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("RecieptTypeCode", trsRecieptType.getRecieptTypeCode()));
        tParameters.add(new TParameter<>("RecieptTypeDesc", trsRecieptType.getRecieptTypeDesc()));
        tParameters.add(new TParameter<>("AccountID", trsRecieptType.getAccountID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("RecieptType", trsRecieptType.getRecieptType()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("IsSaleRefer", trsRecieptType.getIsSaleRefer()));
        tParameters.add(new TParameter<>("IsMandate", trsRecieptType.getIsMandate()));
        tParameters.add(new TParameter<>("IsWarranty", trsRecieptType.getIsWarranty()));
        tParameters.add(new TParameter<>("IsSettle", trsRecieptType.getIsSettle()));
        tParameters.add(new TParameter<>("IsNotInTankhah", trsRecieptType.getIsNotInTankhah()));
        tParameters.add(new TParameter<>("OperationType", trsRecieptType.getOperationType()));
        tParameters.add(new TParameter<>("IsNotActive", trsRecieptType.getIsNotActive()));
        BigDecimal newID = insSP("TrsInsRecieptType", tParameters);
        return trsShowRecieptTypeByID(newID);
    }

    default TrsRecieptType trsUpdRecieptType(BigDecimal recieptTypeID, TrsRecieptType trsRecieptType) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("RecieptTypeID", recieptTypeID));
        tParameters.add(new TParameter<>("RecieptTypeCode", trsRecieptType.getRecieptTypeCode()));
        tParameters.add(new TParameter<>("RecieptTypeDesc", trsRecieptType.getRecieptTypeDesc()));
        tParameters.add(new TParameter<>("AccountID", trsRecieptType.getAccountID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("RecieptType", trsRecieptType.getRecieptType()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("IsSaleRefer", trsRecieptType.getIsSaleRefer()));
        tParameters.add(new TParameter<>("IsMandate", trsRecieptType.getIsMandate()));
        tParameters.add(new TParameter<>("IsWarranty", trsRecieptType.getIsWarranty()));
        tParameters.add(new TParameter<>("IsSettle", trsRecieptType.getIsSettle()));
        tParameters.add(new TParameter<>("IsNotInTankhah", trsRecieptType.getIsNotInTankhah()));
        tParameters.add(new TParameter<>("OperationType", trsRecieptType.getOperationType()));
        tParameters.add(new TParameter<>("IsNotActive", trsRecieptType.getIsNotActive()));
        updSP("TrsUpdRecieptType", tParameters);
        return trsShowRecieptTypeByID(recieptTypeID);
    }

    default void trsDelRecieptType(BigDecimal recieptTypeID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("RecieptTypeID", recieptTypeID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("TrsDelRecieptType", tParameters);
    }
}

