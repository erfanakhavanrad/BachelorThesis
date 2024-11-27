package com.tarazgroup.tws.dao.tkt;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.tkt.TktKnowledgeBase;
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
 * @date Jan-24, 2022
 ***/
public interface TktKnowledgeBaseRepository extends TCrudRepository<TktKnowledgeBase>, CrudRepository<TktKnowledgeBase, BigDecimal> {
    default List<TktKnowledgeBase> tktShowKnowledgeBase(TktKnowledgeBase tktKnowledgeBase) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", tktKnowledgeBase._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", tktKnowledgeBase._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", tktKnowledgeBase._pageFilter()));
        return showSP("TktShowKnowledgeBase", tParameters, true);
    }

//    default TktKnowledgeBase tktShowKnowledgeBaseByID(BigDecimal knowledgeBaseID) {
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter<>("Filter", " AND Main.knowledgeBaseID = " + knowledgeBaseID));
//        tParameters.add(new TParameter<>("OtherFilter", null));
//        tParameters.add(new TParameter<>("ServerFilter", null));
//        tParameters.add(new TParameter<>("YearFilter", null));
//        tParameters.add(new TParameter<>("UserAccessFilter", null));
//        tParameters.add(new TParameter<>("PageFilter", null));
//        return showSP("TktShowKnowledgeBase", tParameters, true).get(0);
//    }

    default TktKnowledgeBase tktShowKnowledgeBaseByID(BigDecimal knowledgeBaseID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.knowledgeBaseID = " + knowledgeBaseID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("TktShowKnowledgeBase", tParameters, true).get(0);
    }

    default TktKnowledgeBase tktInsKnowledgeBase(TktKnowledgeBase tktKnowledgeBase) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("KnowledgeBaseName", tktKnowledgeBase.getKnowledgeBaseName()));
        tParameters.add(new TParameter<>("KnowledgeBaseDesc", tktKnowledgeBase.getKnowledgeBaseDesc()));
        tParameters.add(new TParameter<>("KnowledgeBaseCategoryID", tktKnowledgeBase.getKnowledgeBaseCategoryID()));
        tParameters.add(new TParameter<>("Attachment", tktKnowledgeBase.getAttachment()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("TktInsKnowledgeBase", tParameters);
        return tktShowKnowledgeBaseByID(newID);
    }

//    default TktKnowledgeBaseDto tktInsKnowledgeBase(TktKnowledgeBaseDto tktKnowledgeBaseDto, TktKnowledgeBaseAttachmentRepository tktKnowledgeBaseAttachmentRepository) {
//        LogLogins logLogins = fetchUserDetail();
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter<>("KnowledgeBaseName", tktKnowledgeBaseDto.getKnowledgeBaseName()));
//        tParameters.add(new TParameter<>("KnowledgeBaseDesc", tktKnowledgeBaseDto.getKnowledgeBaseDesc()));
//        tParameters.add(new TParameter<>("KnowledgeBaseCategoryID", tktKnowledgeBaseDto.getKnowledgeBaseCategoryID()));
//        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
//        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
//        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
//        BigDecimal kbID = insSP("TktInsKnowledgeBase", tParameters);
//
//        for (int i = 0; i < tktKnowledgeBaseDto.getAttachments().length; i++) {
//            TktKnowledgeBaseAttachment tktKnowledgeBaseAttachment = new TktKnowledgeBaseAttachment();
//            tktKnowledgeBaseAttachment.setKnowledgeBaseID(kbID);
//            tktKnowledgeBaseAttachment.setAttachmentID(tktKnowledgeBaseDto.getAttachments()[i]);
//            tktKnowledgeBaseAttachmentRepository.tktInsKnowledgeBaseAttachment(tktKnowledgeBaseAttachment);
//        }
//
//        return tktShowKnowledgeBaseByID(newID);
//    }

    default TktKnowledgeBase tktUpdKnowledgeBase(BigDecimal knowledgeBaseID, TktKnowledgeBase tktKnowledgeBase) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("KnowledgeBaseID", knowledgeBaseID));
        tParameters.add(new TParameter<>("KnowledgeBaseName", tktKnowledgeBase.getKnowledgeBaseName()));
        tParameters.add(new TParameter<>("Attachment", tktKnowledgeBase.getAttachment()));
        tParameters.add(new TParameter<>("KnowledgeBaseDesc", tktKnowledgeBase.getKnowledgeBaseDesc()));
        tParameters.add(new TParameter<>("KnowledgeBaseCategoryID", tktKnowledgeBase.getKnowledgeBaseCategoryID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("TktUpdKnowledgeBase", tParameters);
        return tktShowKnowledgeBaseByID(knowledgeBaseID);
    }

    default void tktDelKnowledgeBase(BigDecimal knowledgeBaseID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("KnowledgeBaseID", knowledgeBaseID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("TktDelKnowledgeBase", tParameters);
    }
    // this is true
    default Meta meta(){
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "knowledgeBaseID",           "knowledgeBaseID",            Type.DECIMAL,  0,   false, false,false, Icon.none, true ));
        cols.add(new Col(null, "knowledgeBaseCategoryID",   "knowledgeBaseCategoryID",   Type.DECIMAL,   0,   false, false,false, Icon.none, false));
        cols.add(new Col(null, "knowledgeBaseName",         "عنوان",                     Type.STRING,    100, true,  true, true, Icon.none, false));
        cols.add(new Col(null, "knowledgeBaseCategoryName", "دسته بندی",                 Type.STRING,    100,   true,  true, true, Icon.bank, false));
        cols.add(new Col(null, "serverID",                  "serverID",                  Type.DECIMAL,   0,   false, false, false, Icon.none,false));
        cols.add(new Col(null, "knowledgeBaseDesc",         "توضیحات",                   Type.STRING,    100, false,  false,false, Icon.none,  false));
        cols.add(new Col(null, "watches",                   "بازدیدها",                   Type.INTEGER,    100, true,  true, false, Icon.eye, false));
        cols.add(new Col(null, "knowledgeBaseAttachmentID", "knowledgeBaseAttachmentID", Type.DECIMAL,   0,   false, false,false, Icon.none, false));
        cols.add(new Col(null, "attachmentID",              "attachmentID",              Type.DECIMAL,   0,   false, false,false, Icon.none, false));
//        cols.add(new Col(null, "attachmentFile",            "فایل های الحاقی",           Type.VARBINARY, 100, true,  true,  false));
        cols.add(new Col(null, "createDate",                "createDate",                Type.DATE,      0,   false, false,false, Icon.none, false));
        cols.add(new Col(null, "creatorID",                 "creatorID",                 Type.DECIMAL,   0,   false, false, false, Icon.none,false));
        cols.add(new Col(null, "modifyDate",                "modifyDate",                Type.DATE,      0,   false, false, false, Icon.none,false));
        cols.add(new Col(null, "modifierID",                "modifierID",                Type.DECIMAL,   0,   false, false, false, Icon.none,false));

        return new Meta(cols);
    }
}
