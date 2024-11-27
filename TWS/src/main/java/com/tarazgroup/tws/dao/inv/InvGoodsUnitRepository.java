/**
 * @author Abbas Ashrafi
 * @since v2.0.0
 */

package com.tarazgroup.tws.dao.inv;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.inv.InvGoodsUnit;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public interface InvGoodsUnitRepository extends CrudRepository<InvGoodsUnit, BigDecimal>, TCrudRepository<InvGoodsUnit> {

    default List<InvGoodsUnit> invShowGoodsUnit(InvGoodsUnit invGoodsUnit) {
        List<TParameter<?>> parameters = new ArrayList<>();
        parameters.add(new TParameter<>("Filter", null));
        parameters.add(new TParameter<>("OtherFilter", null));
        parameters.add(new TParameter<>("ServerFilter", null));
        parameters.add(new TParameter<>("YearFilter", null));
        parameters.add(new TParameter<>("UserAccessFilter", null));
        parameters.add(new TParameter<>("PageFilter", invGoodsUnit._pageFilter()));
        return showSP("InvShowGoodsUnit", parameters, true);
    }

    default InvGoodsUnit invShowGoodsUnitByID(BigDecimal unitID) {
        List<TParameter<?>> parameters = new ArrayList<>();
        parameters.add(new TParameter<>("Filter", " AND main.unitID=" + unitID));
        parameters.add(new TParameter<>("OtherFilter", null));
        parameters.add(new TParameter<>("ServerFilter", null));
        parameters.add(new TParameter<>("YearFilter", null));
        parameters.add(new TParameter<>("UserAccessFilter", null));
        parameters.add(new TParameter<>("PageFilter", null));
        return showSP("InvShowGoodsUnit", parameters, true).get(0);
    }

    default InvGoodsUnit invInsGoodsUnit(InvGoodsUnit invGoodsUnit) {
        LogLogins logins = fetchUserDetail();
        List<TParameter<?>> parameters = new ArrayList<>();
        parameters.add(new TParameter<>("UnitDesc", invGoodsUnit.getUnitDesc()));
        parameters.add(new TParameter<>("UnitCode", invGoodsUnit.getUnitCode()));
        parameters.add(new TParameter<>("ModifierID", logins.getPubUser().getUserID()));
        parameters.add(new TParameter<>("CreatorID", logins.getPubUser().getUserID()));
        parameters.add(new TParameter<>("LoginID", logins.getLoginId()));
        BigDecimal newID = insSP("InvInsGoodsUnit", parameters);
        return invShowGoodsUnitByID(newID);
    }

    default void invDelGoodsUnit(BigDecimal unitID) {
        LogLogins logins = fetchUserDetail();
        List<TParameter<?>> parameters = new ArrayList<>();
        parameters.add(new TParameter<>("UnitID", unitID));
        parameters.add(new TParameter<>("LoginID", logins.getLoginId()));
        delSP("InvDelGoodsUnit", parameters);
    }

    default InvGoodsUnit invUpdGoodsUnit(BigDecimal unitID, InvGoodsUnit invGoodsUnit) {
        LogLogins logins = fetchUserDetail();
        List<TParameter<?>> parameters = new ArrayList<>();
        parameters.add(new TParameter<>("UnitID", unitID));
        parameters.add(new TParameter<>("ModifierID", logins.getPubUser().getModifierID()));
        parameters.add(new TParameter<>("UnitDesc", invGoodsUnit.getUnitDesc()));
        parameters.add(new TParameter<>("UnitCode", invGoodsUnit.getUnitCode()));
        parameters.add(new TParameter<>("LoginID", logins.getLoginId()));
        updSP("InvUpdGoodsUnit", parameters);
        return invShowGoodsUnitByID(unitID);
    }


    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "unitID", "unitID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "unitCode", "کد", Type.STRING, 80, true, true, false));
        cols.add(new Col(null, "unitDesc", "شرح", Type.STRING, 206, true, true, false));
        cols.add(new Col(null, "isQuantitative", "قابل شمارش (تعدادی)", Type.BOOLEAN, 50, true, true, false));
        cols.add(new Col(null, "isQuantitativeDesc", "نوع", Type.STRING, 82, true, true, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 0, false, false, false));
        return new Meta(cols);
    }
}
