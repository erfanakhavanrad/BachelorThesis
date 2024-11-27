package com.tarazgroup.tws.dao.ast;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.ast.AstAssetElement;
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
 * 1/1/22
 *
 * @author Erfan Akhavan
 */
public interface AstAssetElementRepository extends TCrudRepository<AstAssetElement>, CrudRepository<AstAssetElement, BigDecimal> {

    default List<AstAssetElement> astShowAssetElement(AstAssetElement astAssetElement) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", astAssetElement._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", astAssetElement._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", astAssetElement._pageFilter()));
        return showSP("AstShowAssetElement", tParameters, true);
    }

    default AstAssetElement astShowAssetElementByID(BigDecimal assetElementID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " And main.assetElementID= " + assetElementID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("AstShowAssetElement", tParameters, true).get(0);
    }


    default AstAssetElement astInsAssetElement(AstAssetElement astAssetElement) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("AssetElementCode", astAssetElement.getAssetElementCode()));
        tParameters.add(new TParameter<>("AssetElementDesc", astAssetElement.getAssetElementDesc()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("AstInsAssetElement", tParameters);
        return astShowAssetElementByID(newID);
    }


    default AstAssetElement astUpdAssetElement(AstAssetElement astAssetElement, BigDecimal assetElementID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("AssetElementID", assetElementID));
        tParameters.add(new TParameter<>("AssetElementCode", astAssetElement.getAssetElementCode()));
        tParameters.add(new TParameter<>("AssetElementDesc", astAssetElement.getAssetElementDesc()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("AstUpdAssetElement", tParameters);
        return astShowAssetElementByID(assetElementID);
    }


    default void astDelAssetElement(BigDecimal assetElementID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("AssetElementID", assetElementID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("AstDelAssetElement", tParameters);
    }


    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "assetElementID", "assetElementID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "assetElementCode", "کد عامل", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "assetElementDesc", "نام عامل", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 100, false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 100, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 100, false, false, false));
        return new Meta(cols);
    }


}
