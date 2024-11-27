package com.tarazgroup.tws.dao.inv;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.inv.InvGoodElements;
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
 * @author Erfan Akhavan
 */
public interface InvGoodElementsRepository extends TCrudRepository<InvGoodElements>, CrudRepository<InvGoodElements, BigDecimal> {
    default List<InvGoodElements> invShowGoodElements(InvGoodElements invGoodElements) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", invGoodElements._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", invGoodElements._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", invGoodElements._pageFilter()));
        return showSP("InvShowGoodElements", tParameters, true);
    }

    default InvGoodElements invShowGoodElementByID(BigDecimal gElementsID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " And main.gElementsID= " + gElementsID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("InvShowGoodElements", tParameters, true).get(0);
    }


//   this method should use this SP, DO NOT change it
default InvGoodElements invInsGoodsElement(InvGoodElements invGoodsElements) {
    List<TParameter<?>> tParameters = new ArrayList<>();
    LogLogins logLogins = fetchUserDetail();
    tParameters.add(new TParameter<>("ElementsCode", invGoodsElements.getElementsCode()));
    tParameters.add(new TParameter<>("ElementName", invGoodsElements.getElementName()));
    tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getCreatorID()));
    tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
    BigDecimal newID = insSP("InvInsGoodsElements", tParameters);
    InvGoodElements temp = new InvGoodElements();
    temp.setgElementsID(newID);
    return invShowGoodElements(temp).get(0);
}


    default void invDelGoodsElement(BigDecimal gElementID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("GElementsID", gElementID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("InvDelGoodsElements", tParameters);
    }

    default InvGoodElements invUpdGoodsElement(BigDecimal gElementsID, InvGoodElements invGoodsElements) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("GElementsID", gElementsID));
        tParameters.add(new TParameter<>("ElementsCode", invGoodsElements.getElementsCode()));
        tParameters.add(new TParameter<>("ElementName", invGoodsElements.getElementName()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("ElementType", invGoodsElements.getElementType()));
        updSP("InvUpdGoodsElements", tParameters);
        InvGoodElements temp = new InvGoodElements();
        temp.setgElementsID(gElementsID);
        return invShowGoodElements(temp).get(0);
    }


    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "gElementsID", "gElementsID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "elementName", "شرح", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "elementTypeDesc", "نوع", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "elementsCode", "کد", Type.STRING, 100, true, true, false));
        return new Meta(cols);
    }

//    default Meta meta() {
//        ArrayList<Col> cols = new ArrayList<>();
//        cols.add(new Col(null, "bankId", "bankId", Type.DECIMAL, 0, false, false, true));
//        cols.add(new Col(null, "bankCode", "کد بانک", Type.STRING, 100, true, true, false));
//        cols.add(new Col(null, "taxCode", "کد مالیاتی", Type.STRING, 130, true, true, false));
//        cols.add(new Col(null, "bankName", "نام بانک", Type.STRING, 100, true, true, false));
//        cols.add(new Col(null, "bankLatinName", "نام لاتین بانک", Type.STRING, 120, true, true, false));
//        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 100, false, false, false));
//        cols.add(new Col(null, "serverID", "serverID", Type.INTEGER, 100, false, false, false));
//        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 120, false, false, false));
//        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 100, false, false, false));
//        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 100, false, false, false));
//        return new Meta(cols);
//    }


}
