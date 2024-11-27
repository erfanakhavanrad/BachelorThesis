/**
 * @author Abbas Ashrafi
 * @since v2.0.0
 */

package com.tarazgroup.tws.dao.inv;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.inv.InvGetGoodsUnit;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public interface InvGetGoodsUnitRepository extends CrudRepository<InvGetGoodsUnit, BigDecimal>, TCrudRepository<InvGetGoodsUnit> {

    default List<InvGetGoodsUnit> invGetGoodsUnit(InvGetGoodsUnit invGetGoodsUnit, BigDecimal goodsID) {
        List<TParameter<?>> parameters = new ArrayList<>();
        parameters.add(new TParameter<>("GoodsID", goodsID));
        parameters.add(new TParameter<>("Filter", null));
        parameters.add(new TParameter<>("PageFilter", invGetGoodsUnit._pageFilter()));
        List<InvGetGoodsUnit> invGetGoodsUnits = showSP("InvGetGoodsUnit", parameters, true);
        for (int i = 0; i <invGetGoodsUnits.size() ; i++) {
            if(invGetGoodsUnits.get(i).getSecUnitID().intValue()==1){
                invGetGoodsUnits.get(i).setIsMainUnitID(true);
            }else{
                invGetGoodsUnits.get(i).setIsMainUnitID(false);
            }
            if(invGetGoodsUnits.get(i).getDefaultSecUnitID()==null){
                invGetGoodsUnits.get(i).setIsDefaultSecUnitID(false);
            }else{
                invGetGoodsUnits.get(i).setIsDefaultSecUnitID(true);
            }
        }
        return invGetGoodsUnits;
    }
}
