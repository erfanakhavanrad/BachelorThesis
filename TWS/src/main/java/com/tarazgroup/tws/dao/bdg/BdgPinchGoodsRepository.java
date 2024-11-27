package com.tarazgroup.tws.dao.bdg;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.bdg.BdgPinchGoods;
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
public interface BdgPinchGoodsRepository extends TCrudRepository<BdgPinchGoods>, CrudRepository<BdgPinchGoods, BigDecimal> {
    default List<BdgPinchGoods> bdgShowPinchGoods(BigDecimal masterGoodsID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter("Filter", null));
        tParameters.add(new TParameter("OtherFilter", "and main.MasterGoodsID = " + masterGoodsID));
        tParameters.add(new TParameter("ServerFilter", null));
        tParameters.add(new TParameter("YearFilter", null));
        tParameters.add(new TParameter("UserAccessFilter", null));
        tParameters.add(new TParameter("PageFilter", null));
        return showSP("BdgShowPinchGoods", tParameters, true);
    }

    default void bdgInsPinchGoods(BdgPinchGoods bdgPinchGoods) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("MasterGoodsID", bdgPinchGoods.getMasterGoodsID()));
        tParameters.add(new TParameter<>("pinchGoodsID", bdgPinchGoods.getPinchGoodsID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("BdgInsPinchGoods", tParameters);//todo the insert sp does not return any NewID (dual grid)
    }

    default void bdgDelPinchGoods(BigDecimal masterGoodID, BigDecimal pinchGoodsID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("MasterGoodsID", masterGoodID));
        tParameters.add(new TParameter<>("PinchGoodsID", pinchGoodsID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("BdgDelPinchGoods", tParameters);
    }

}
