package com.tarazgroup.tws.dao.tkt;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.tkt.TktAttachment;
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
 * @date Jan-23, 2022
 ***/
public interface TktAttachmentRepository extends TCrudRepository<TktAttachment>, CrudRepository<TktAttachment, BigDecimal> {
    default List<TktAttachment> tktShowAttachment(TktAttachment tktAttachment) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", tktAttachment._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", tktAttachment._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", tktAttachment._pageFilter()));
        return showSP("TktShowAttachment", tParameters, true);
    }

    default TktAttachment tktShowAttachmentByID(BigDecimal attachmentID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.AttachmentID = "  + attachmentID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("TktShowAttachment", tParameters, true).get(0);
    }

    default TktAttachment tktInsAttachment(TktAttachment tktAttachment) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("AttachmentFile", tktAttachment.getAttachmentFile()));
        tParameters.add(new TParameter<>("FileName", tktAttachment.getFileName()));
        tParameters.add(new TParameter<>("FileType", tktAttachment.getFileType()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("TktInsAttachment", tParameters);
        return tktShowAttachmentByID(newID);
    }

    default TktAttachment tktUpdAttachment(BigDecimal attachmentID, TktAttachment tktAttachment) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("AttachmentID", attachmentID));
        tParameters.add(new TParameter<>("FileName", tktAttachment.getFileName()));
        tParameters.add(new TParameter<>("FileType", tktAttachment.getFileType()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("TktUpdAttachment", tParameters);
        return tktShowAttachmentByID(attachmentID);
    }

    default void tktDelAttachment(BigDecimal attachmentID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("AttachmentID", attachmentID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("TktDelAttachment", tParameters);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null,"attachmentID",  "attachmentID",    Type.DECIMAL,   0,   false, false, true ));
        cols.add(new Col(null,"serverID",      "serverID",        Type.DECIMAL,   0,   false, false, false));
//        cols.add(new Col(null,"attachmentFile","فایل های الحاقی:",Type.VARBINARY, 100, true,  true,  false));
        cols.add(new Col(null,"createDate",    "createDate",      Type.DATE,      0,   false, false, false));
        cols.add(new Col(null,"creatorID",     "creatorID",       Type.DECIMAL,   0,   false, false, false));
        cols.add(new Col(null,"modifyDate",    "modifyDate",      Type.DATE,      0,   false, false, false));
        cols.add(new Col(null,"modifierID",    "modifierID",      Type.DECIMAL,   0,   false, false, false));
        return new Meta(cols);
    }
}
