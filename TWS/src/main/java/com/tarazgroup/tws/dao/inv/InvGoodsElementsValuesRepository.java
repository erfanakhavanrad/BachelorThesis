package com.tarazgroup.tws.dao.inv;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.inv.InvGoodsElementsValues;
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
public interface InvGoodsElementsValuesRepository extends TCrudRepository<InvGoodsElementsValues>, CrudRepository<InvGoodsElementsValues, BigDecimal> {

    default List<InvGoodsElementsValues> invShowGoodsElementsValues(InvGoodsElementsValues invGoodsElementsValues) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", invGoodsElementsValues._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", invGoodsElementsValues._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("InvShowGoodsElementsValues", tParameters, true);
    }

    default List<InvGoodsElementsValues> invShowGoodsElementsValuesByWeight(BigDecimal goodsID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        String filter=null;

        filter =  goodsID == null ?" and GEl.ElementType = 1":
                " and GEl.ElementType = 1 and GoodsID = " + goodsID;
        tParameters.add(new TParameter<>("Filter", filter));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("InvShowGoodsElementsValues", tParameters, true);
    }
}
