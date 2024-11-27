package com.tarazgroup.tws.dao.tkt;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.tkt.TktKnowledgeBaseCategory;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Icon;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/***
 * @author A.Farahani
 * @date Jan-22, 2022
 ***/
public interface TktKnowledgeBaseCategoryRepository extends TCrudRepository<TktKnowledgeBaseCategory>, CrudRepository<TktKnowledgeBaseCategory, BigDecimal> {
    default List<TktKnowledgeBaseCategory> tktShowKnowledgeBaseCategory(TktKnowledgeBaseCategory tktKnowledgeBaseCategory) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", tktKnowledgeBaseCategory._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", tktKnowledgeBaseCategory._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", tktKnowledgeBaseCategory._pageFilter()));
        return showSP("TktShowKnowledgeBaseCategory", tParameters,true);
    }

    default TktKnowledgeBaseCategory tktShowKnowledgeBaseCategoryByID(BigDecimal knowledgeBaseCategoryID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.knowledgeBaseCategoryID = " + knowledgeBaseCategoryID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("TktShowKnowledgeBaseCategory", tParameters,true).get(0);
    }

    default TktKnowledgeBaseCategory tktInsKnowledgeBaseCategory(TktKnowledgeBaseCategory tktKnowledgeBaseCategory) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("KnowledgeBaseCategoryName", tktKnowledgeBaseCategory.getKnowledgeBaseCategoryName()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("TktInsKnowledgeBaseCategory", tParameters);
        return tktShowKnowledgeBaseCategoryByID(newID);
    }

    default TktKnowledgeBaseCategory tktUpdKnowledgeBaseCategory(BigDecimal knowledgeBaseCategoryID, TktKnowledgeBaseCategory tktKnowledgeBaseCategory) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("KnowledgeBaseCategoryID", knowledgeBaseCategoryID));
        tParameters.add(new TParameter<>("KnowledgeBaseCategoryName", tktKnowledgeBaseCategory.getKnowledgeBaseCategoryName()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("TktUpdKnowledgeBaseCategory", tParameters);
        return tktShowKnowledgeBaseCategoryByID(knowledgeBaseCategoryID);
    }

    default void tktDelKnowledgeBaseCategory(BigDecimal knowledgeBaseCategoryID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("KnowledgeBaseCategoryID", knowledgeBaseCategoryID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("TktDelKnowledgeBaseCategory", tParameters);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null,"knowledgeBaseCategoryID", "knowledgeBaseCategoryID", Type.DECIMAL, 50, false, false,false, Icon.none,  true));
        cols.add(new Col(null,"knowledgeBaseCategoryName", "عنوان", Type.STRING, 730, true, true,true, Icon.none,  false));
        cols.add(new Col(null,"serverID", "serverID", Type.DECIMAL, 100, false, false,false, Icon.none,  false));
        cols.add(new Col(null,"createDate", "createDate", Type.DATE, 200, false, false,false, Icon.none,  false));
        cols.add(new Col(null,"creatorID", "creatorID", Type.DECIMAL, 300, false, false,false, Icon.none,  false));
        cols.add(new Col(null,"modifyDate", "modifyDate", Type.DATE, 100, false, false,false, Icon.none,  false));
        cols.add(new Col(null,"modifierID", "modifierID", Type.DECIMAL, 100, false, false,false, Icon.none,  false));
        cols.add(new Col(null,"createDateS", "createDateS", Type.STRING, 200, false, false,false, Icon.none,  false));
        cols.add(new Col(null,"modifyDateS", "modifyDateS", Type.STRING, 200, false, false,false, Icon.none,  false));
        return new Meta(cols);
    }
}
