/**
 * @author Abbas Ashrafi
 * @since v2.0.0
 */

package com.tarazgroup.tws.dao.inv;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.inv.InvGoodsLevel;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public interface InvGoodsLevelRepository extends CrudRepository<InvGoodsLevel, BigDecimal>, TCrudRepository<InvGoodsLevel> {

    default List<InvGoodsLevel> invShowGoodsLevel(BigDecimal goodsID, BigDecimal groupID) {
        List<TParameter<?>> parameters = new ArrayList<>();
        parameters.add(new TParameter<>("Filter", " AND Main.GoodsID=" + goodsID));
        parameters.add(new TParameter<>("OtherFilter", " AND L.LevelID IN (SELECT LevelID FROM InvAllocateLevelGoods WHERE GroupID = " + groupID + ")"));
        parameters.add(new TParameter<>("ServerFilter", null));
        parameters.add(new TParameter<>("YearFilter", null));
        parameters.add(new TParameter<>("UserAccessFilter", null));
        parameters.add(new TParameter<>("GroupID", groupID));
        return showSP("InvShowGoodsLevel", parameters, true);
    }
}
