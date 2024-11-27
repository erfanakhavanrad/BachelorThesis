package com.tarazgroup.tws.dao.inv;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.inv.InvGoodsElements;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
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
public interface InvGoodsElementsRepository extends TCrudRepository<InvGoodsElements>, CrudRepository<InvGoodsElements, BigDecimal> {

    default List<InvGoodsElements> invShowGoodsElement(InvGoodsElements invGoodsElements) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", invGoodsElements._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", invGoodsElements._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", invGoodsElements._pageFilter()));
        return showSP("InvShowGoodsElements", tParameters, true);
    }

    default InvGoodsElements invInsGoodsElement(InvGoodsElements invGoodsElements) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("ElementsCode", invGoodsElements.getElementsCode()));
        tParameters.add(new TParameter<>("ElementName", invGoodsElements.getElementName()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getCreatorID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("InvInsGoodsElements", tParameters);
        InvGoodsElements temp = new InvGoodsElements();
        temp.setgElementsID(newID);
        return invShowGoodsElement(temp).get(0);
    }

    default void invDelGoodsElement(BigDecimal gElementID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("GElementsID", gElementID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("InvDelGoodsElements", tParameters);
    }

    default InvGoodsElements invUpdGoodsElement(BigDecimal gElementsID, InvGoodsElements invGoodsElements) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("GElementsID", gElementsID));
        tParameters.add(new TParameter<>("ElementsCode", invGoodsElements.getElementsCode()));
        tParameters.add(new TParameter<>("ElementName", invGoodsElements.getElementName()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("ElementType", invGoodsElements.getElementType()));
        updSP("InvUpdGoodsElements", tParameters);
        InvGoodsElements temp = new InvGoodsElements();
        temp.setgElementsID(gElementsID);
        return invShowGoodsElement(temp).get(0);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "gElementsID", "gElementsID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "elementsCode", "کد", Type.STRING, 80, true, true, false));
        cols.add(new Col(null, "elementName", "شرح", Type.STRING, 80, true, true, false));
        cols.add(new Col(null, "elementTypeDesc", "نوع", Type.STRING, 106, true, true, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 0, false, false, false));
        return new Meta(cols);
    }
}
