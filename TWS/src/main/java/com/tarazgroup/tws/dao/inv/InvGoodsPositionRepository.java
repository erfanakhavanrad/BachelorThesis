package com.tarazgroup.tws.dao.inv;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.inv.InvGoodsPosition;
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

public interface InvGoodsPositionRepository extends TCrudRepository<InvGoodsPosition>, CrudRepository<InvGoodsPosition, BigDecimal> {
    default List<InvGoodsPosition> invShowGoodsPosition(InvGoodsPosition invGoodsPosition) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", invGoodsPosition._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", invGoodsPosition._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", invGoodsPosition._pageFilter()));
        return showSP("InvShowGoodsPosition", tParameters, true);
    }

    default InvGoodsPosition invInsGoodsPosition(InvGoodsPosition invGoodsPosition) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("GoodspositionCode", invGoodsPosition.getGoodspositionCode()));
        tParameters.add(new TParameter<>("GoodsPositionDesc", invGoodsPosition.getGoodsPositionDesc()));
        tParameters.add(new TParameter<>("GoodsPositionFatherID", invGoodsPosition.getGoodsPositionFatherID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getCreatorID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("InvInsGoodsPosition", tParameters);
        InvGoodsPosition temp = new InvGoodsPosition();
        temp.setGoodsPositionID(newID);
        return invShowGoodsPosition(temp).get(0);
    }

    default void invDelGoodsPosition(BigDecimal goodsPositionID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("GoodsPositionID", goodsPositionID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("InvDelGoodsPosition", tParameters);
    }

    default InvGoodsPosition invUpdGoodsPosition(BigDecimal goodsPositionID, InvGoodsPosition invGoodsPosition) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("GoodsPositionID", goodsPositionID));
        tParameters.add(new TParameter<>("GoodspositionCode", invGoodsPosition.getGoodspositionCode()));
        tParameters.add(new TParameter<>("GoodsPositionDesc", invGoodsPosition.getGoodsPositionDesc()));
        tParameters.add(new TParameter<>("GoodsPositionFatherID", invGoodsPosition.getGoodsPositionID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("InvUpdGoodsPosition", tParameters);
        InvGoodsPosition temp = new InvGoodsPosition();
        temp.setGoodsPositionID(goodsPositionID);
        return invShowGoodsPosition(temp).get(0);
    }
}
