package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.sale.SaleSDCenter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
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
public interface SaleSDCenterRepository extends TCrudRepository<SaleSDCenter>, CrudRepository<SaleSDCenter, BigDecimal> {

    default List<SaleSDCenter> saleSelectSDCenter(String namedNativeQuery) {
        return findAllByNamedQuery(namedNativeQuery);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        //
        cols.add(new Col(null, "sDCenterID", "sDCenterID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "sDCode", "کد", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "sDDesc", "شرح", Type.STRING, 130, true, true, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 100, false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 120, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 120, false, false, false));
        cols.add(new Col(null, "isSaleCenter", "مرکز فروش", Type.BOOLEAN, 100, true, true, false));
        cols.add(new Col(null, "isDeliveryCenter", "مرکز تحویل", Type.BOOLEAN, 100, true, true, false));
        cols.add(new Col(null, "isNotActive", "غیر فعال", Type.BOOLEAN, 100, true, true, false));
        //
        return new Meta(cols);
    }
}
