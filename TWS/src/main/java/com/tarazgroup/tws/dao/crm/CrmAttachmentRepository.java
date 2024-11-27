package com.tarazgroup.tws.dao.crm;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.crm.CrmAttachment;
import com.tarazgroup.tws.model.log.LogLogins;
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
 * @date Dec-31, 2022
 ***/
public interface CrmAttachmentRepository extends TCrudRepository<CrmAttachment>, CrudRepository<CrmAttachment, BigDecimal>  {

    default List<CrmAttachment> crmShowAttachment(CrmAttachment crmAttachment) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("FormID", crmAttachment.getFormID()));
        tParameters.add(new TParameter<>("FieldID", crmAttachment.getFieldID()));
        tParameters.add(new TParameter<>("RecordID", crmAttachment.getRecordID()));
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmAttachment._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmAttachment._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmAttachment._pageFilter()));
        return showSP("CrmShowAttachment", tParameters, true);
    }

    default List<CrmAttachment> crmShowAttachmentsWithPathVariable(BigDecimal formID, BigDecimal recordID, CrmAttachment crmAttachment) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("FormID", formID));
        tParameters.add(new TParameter<>("FieldID", null));
        tParameters.add(new TParameter<>("RecordID", recordID));
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmAttachment._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmAttachment._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmAttachment._pageFilter()));
        return showSP("CrmShowAttachment", tParameters, true);
    }

    default CrmAttachment crmShowAttachmentByID(BigDecimal attachmentID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("FormID", null));
        tParameters.add(new TParameter<>("FieldID", null));
        tParameters.add(new TParameter<>("RecordID", null));
        tParameters.add(new TParameter<>("Filter", " AND Main.AttachmentID = "  + attachmentID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("CrmShowAttachment", tParameters, true).get(0);
    }

    default CrmAttachment crmInsAttachment(BigDecimal formID, BigDecimal recordID, CrmAttachment crmAttachment) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("FormID", formID));
        tParameters.add(new TParameter<>("FieldID", crmAttachment.getFieldID()));
        tParameters.add(new TParameter<>("RecordID", recordID));
        tParameters.add(new TParameter<>("AttachmentFile", crmAttachment.getAttachmentFile()));
        tParameters.add(new TParameter<>("FileName", crmAttachment.getFileName()));
        tParameters.add(new TParameter<>("FileType", crmAttachment.getFileType()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("CrmInsAttachment", tParameters);
        return crmShowAttachmentByID(newID);
    }

    default void crmDelAttachment(BigDecimal attachmentID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("AttachmentID", attachmentID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("CrmDelAttachment", tParameters);
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
