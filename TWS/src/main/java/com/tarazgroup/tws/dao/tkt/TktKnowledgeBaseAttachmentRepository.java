package com.tarazgroup.tws.dao.tkt;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.tkt.TktKnowledgeBaseAttachment;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
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
public interface TktKnowledgeBaseAttachmentRepository extends TCrudRepository<TktKnowledgeBaseAttachment>, CrudRepository<TktKnowledgeBaseAttachment, BigDecimal> {
    default List<TktKnowledgeBaseAttachment> tktShowKnowledgeBaseAttachment(TktKnowledgeBaseAttachment tktKnowledgeBaseAttachment) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", tktKnowledgeBaseAttachment._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", tktKnowledgeBaseAttachment._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", tktKnowledgeBaseAttachment._pageFilter()));
        return showSP("TktShowKnowledgeBaseAttachment", tParameters, true);
    }

    default TktKnowledgeBaseAttachment tktShowKnowledgeBaseAttachmentByID(BigDecimal knowledgeBaseAttachmentID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.knowledgeBaseAttachmentID = " + knowledgeBaseAttachmentID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("TktShowKnowledgeBaseAttachment", tParameters, true).get(0);
    }

    default TktKnowledgeBaseAttachment tktInsKnowledgeBaseAttachment(TktKnowledgeBaseAttachment tktKnowledgeBaseAttachment) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("KnowledgeBaseID", tktKnowledgeBaseAttachment.getKnowledgeBaseID()));
        tParameters.add(new TParameter<>("AttachmentID", tktKnowledgeBaseAttachment.getAttachmentID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("TktInsKnowledgeBaseAttachment", tParameters);
        return tktShowKnowledgeBaseAttachmentByID(newID);
    }

    default void tktDelKnowledgeBaseAttachment(BigDecimal knowledgeBaseAttachmentID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("KnowledgeBaseAttachmentID", knowledgeBaseAttachmentID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("TktDelKnowledgeBaseAttachment", tParameters);
    }

    default Meta meta(){
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "knowledgeBaseAttachmentID", "knowledgeBaseAttachmentID", Type.DECIMAL,   0,   false, false, true ));
        cols.add(new Col(null, "serverID",                  "serverID",                  Type.DECIMAL,   0,   false, false, false));
        cols.add(new Col(null, "knowledgeBaseID",           "knowledgeBaseID",           Type.DECIMAL,   0,   false, false, false));
        cols.add(new Col(null, "attachmentID",              "attachmentID",              Type.DECIMAL,   0,   false, false, false));
//        cols.add(new Col(null, "AttachmentFile",            "فایل های الحاقی",           Type.VARBINARY, 100, true,  true,  false));
        cols.add(new Col(null, "createDate",                "createDate",                Type.DATE,      0,   false, false, false));
        cols.add(new Col(null, "creatorID",                 "creatorID",                 Type.DECIMAL,   0,   false, false, false));
        cols.add(new Col(null, "modifyDate",                "modifyDate",                Type.DATE,      0,   false, false, false));
        cols.add(new Col(null, "modifierID",                "modifierID",                Type.DECIMAL,   0,   false, false, false));

        return new Meta(cols);
    }
}
