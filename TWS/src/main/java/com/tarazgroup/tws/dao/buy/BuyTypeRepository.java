package com.tarazgroup.tws.dao.buy;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.buy.BuyType;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Farahani
 * @date 12/13/21
 */
public interface BuyTypeRepository extends TCrudRepository<BuyType>, CrudRepository<BuyType, BigDecimal> {
    default List<BuyType> buyShowType(BuyType buyType) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", buyType._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", buyType._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("BuyShowType", tParameters, true);
    }

    default BuyType buyShowTypeByID(BigDecimal buyTypeID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.BuyTypeID = " + buyTypeID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("BuyShowType", tParameters, true).get(0);
    }

    default BuyType buyInsType(BuyType buyType) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("BuyTypeCode", buyType.getBuyTypeCode()));
        tParameters.add(new TParameter<>("BuyTypeDesc", buyType.getBuyTypeDesc()));
        tParameters.add(new TParameter<>("IsCurrency", buyType.getIsCurrency()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("BuyInsType", tParameters);
        return buyShowTypeByID(newID);
    }

    default BuyType buyUpdType(BigDecimal buyTypeID, BuyType buyType) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("BuyTypeID", buyTypeID));
        tParameters.add(new TParameter<>("BuyTypeCode", buyType.getBuyTypeCode()));
        tParameters.add(new TParameter<>("BuyTypeDesc", buyType.getBuyTypeDesc()));
        tParameters.add(new TParameter<>("IsCurrency", buyType.getIsCurrency()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("BuyUpdType", tParameters);
        return buyShowTypeByID(buyTypeID);
    }

    default void buyDelType(BigDecimal buyTypeID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("BuyTypeID", buyTypeID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("BuyDelType", tParameters);
    }

}
