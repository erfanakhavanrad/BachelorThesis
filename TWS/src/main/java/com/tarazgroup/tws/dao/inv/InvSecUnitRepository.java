package com.tarazgroup.tws.dao.inv;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.inv.InvSecUnit;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Farahani
 */

// TODO: 12/8/21 doesn't have page filter

public interface InvSecUnitRepository extends TCrudRepository<InvSecUnit>, CrudRepository<InvSecUnit, BigDecimal> {
    default List<InvSecUnit> invShowSecUnit(InvSecUnit invSecUnit) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", invSecUnit._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", invSecUnit._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("InvShowSecUnit", tParameters, true);
    }

    default InvSecUnit invShowSecUnitByID(BigDecimal secUnitID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.SecUnitID = " + secUnitID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("InvShowSecUnit", tParameters, true).get(0);
    }

    default InvSecUnit invInsSecUnit(InvSecUnit invSecUnit) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("UnitID", invSecUnit.getUnitID()));
        tParameters.add(new TParameter<>("GoodsID", invSecUnit.getGoodsID()));
        tParameters.add(new TParameter<>("ComputeType", invSecUnit.getComputeType()));
        tParameters.add(new TParameter<>("ComputeValue", invSecUnit.getComputeValue()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("IsDefault", invSecUnit.getIsDefault()));
        tParameters.add(new TParameter<>("IsSec2Active", invSecUnit.getIsSec2Active()));
        tParameters.add(new TParameter<>("IsSec3Active", invSecUnit.getIsSec3Active()));
        tParameters.add(new TParameter<>("Quantity23Type", invSecUnit.getQuantity23Type()));
        BigDecimal newID = insSP("InvInsSecUnit", tParameters);
        return invShowSecUnitByID(newID);
    }

    default InvSecUnit invUpdSecUnit(BigDecimal secUnitID, InvSecUnit invSecUnit) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("SecUnitID", secUnitID));
        tParameters.add(new TParameter<>("UnitID", invSecUnit.getUnitID()));
        tParameters.add(new TParameter<>("GoodsID", invSecUnit.getGoodsID()));
        tParameters.add(new TParameter<>("ComputeType", invSecUnit.getComputeType()));
        tParameters.add(new TParameter<>("ComputeValue", invSecUnit.getComputeValue()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("IsDefault", invSecUnit.getIsDefault()));
        tParameters.add(new TParameter<>("IsSec2Active", invSecUnit.getIsSec2Active()));
        tParameters.add(new TParameter<>("IsSec3Active", invSecUnit.getIsSec3Active()));
        tParameters.add(new TParameter<>("Quantity23Type", invSecUnit.getQuantity23Type()));
        updSP("InvUpdSecUnit", tParameters);
        return invShowSecUnitByID(secUnitID);
    }

    default void invDelSecUnit(BigDecimal secUnitID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("SecUnitID", secUnitID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("InvDelSecUnit", tParameters);
    }
}
