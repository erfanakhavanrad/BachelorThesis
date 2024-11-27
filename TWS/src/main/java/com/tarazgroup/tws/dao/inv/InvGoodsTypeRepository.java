/**
 * @author Abbas Ashrafi
 * @since v2.0.0
 */

package com.tarazgroup.tws.dao.inv;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.inv.InvGoodsType;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public interface InvGoodsTypeRepository extends CrudRepository<InvGoodsType, BigDecimal>, TCrudRepository<InvGoodsType> {

    default List<InvGoodsType> invShowGoodsType(InvGoodsType invGoodsType) {
        List<TParameter<?>> parameters = new ArrayList<>();
        parameters.add(new TParameter<>("Filter", null));
        parameters.add(new TParameter<>("OtherFilter", null));
        parameters.add(new TParameter<>("ServerFilter", null));
        parameters.add(new TParameter<>("YearFilter", null));
        parameters.add(new TParameter<>("UserAccessFilter", null));
        parameters.add(new TParameter<>("PageFilter", invGoodsType._pageFilter()));
        return showSP("InvShowGoodsType", parameters, true);
    }

    default InvGoodsType invShowGoodsTypeByID(BigDecimal typeID) {
        List<TParameter<?>> parameters = new ArrayList<>();
        parameters.add(new TParameter<>("Filter", " AND main.TypeID=" + typeID));
        parameters.add(new TParameter<>("OtherFilter", null));
        parameters.add(new TParameter<>("ServerFilter", null));
        parameters.add(new TParameter<>("YearFilter", null));
        parameters.add(new TParameter<>("UserAccessFilter", null));
        parameters.add(new TParameter<>("PageFilter", null));

        return showSP("InvShowGoodsType", parameters, true).get(0);
    }

    default InvGoodsType invInsGoodsType(InvGoodsType invGoodsType) {
        LogLogins logins = fetchUserDetail();
        List<TParameter<?>> parameters = new ArrayList<>();
        parameters.add(new TParameter<>("TypeCode", invGoodsType.getTypeCode()));
        parameters.add(new TParameter<>("TypeDesc", invGoodsType.getTypeDesc()));
        parameters.add(new TParameter<>("CreatorID", logins.getPubUser().getUserID()));
        parameters.add(new TParameter<>("ModifierID", logins.getPubUser().getUserID()));
        parameters.add(new TParameter<>("LoginID", logins.getLoginId()));
        parameters.add(new TParameter<>("TaxCode", invGoodsType.getTaxCode()));
        parameters.add(new TParameter<>("GoodsType", invGoodsType.getGoodsType()));
        BigDecimal newID = insSP("InvInsGoodsType", parameters);
        return invShowGoodsTypeByID(newID);
    }

    default void invDelGoodsType(BigDecimal typeID) {
        LogLogins logins = fetchUserDetail();
        List<TParameter<?>> parameters = new ArrayList<>();
        parameters.add(new TParameter<>("TypeID", typeID));
        parameters.add(new TParameter<>("LoginID", logins.getLoginId()));
        delSP("InvDelGoodsType", parameters);
    }

    default InvGoodsType invUpdGoodsType(BigDecimal typeID, InvGoodsType invGoodsType) {
        LogLogins logins = fetchUserDetail();
        List<TParameter<?>> parameters = new ArrayList<>();
        parameters.add(new TParameter<>("TypeID", typeID));
        parameters.add(new TParameter<>("TypeCode", invGoodsType.getTypeCode()));
        parameters.add(new TParameter<>("TypeDesc", invGoodsType.getTypeDesc()));
        parameters.add(new TParameter<>("ModifierID", logins.getPubUser().getUserID()));
        parameters.add(new TParameter<>("LoginID", logins.getLoginId()));
        parameters.add(new TParameter<>("TaxCode", invGoodsType.getTaxCode()));
        parameters.add(new TParameter<>("GoodsType", invGoodsType.getGoodsType()));
        updSP("InvUpdGoodsType", parameters);
        return invShowGoodsTypeByID(typeID);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null,"typeID", "typeID", Type.DECIMAL, 0, false, false,  true));
        cols.add(new Col(null,"typeCode", "کد نوع کالا", Type.STRING, 63, true, true,  false));
        cols.add(new Col(null,"taxCode", "کد مالیاتی", Type.STRING, 78, true, true,  false));
        cols.add(new Col(null,"typeDesc", "شرح نوع کالا", Type.STRING, 78, true, true,  false));
        cols.add(new Col(null,"goodsTypeDesc", "نوع", Type.STRING, 78, true, true,  false));
        cols.add(new Col(null,"serverID", "serverID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"createDate", "createDate", Type.DATE, 0, false, false,  false));
        cols.add(new Col(null,"creatorID", "creatorID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"modifyDate", "modifyDate", Type.DATE, 0, false, false,  false));
        cols.add(new Col(null,"modifierID", "modifierID", Type.DECIMAL, 0, false, false,  false));
        return new Meta(cols);
    }

}
