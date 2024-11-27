package com.tarazgroup.tws.dao.tkt;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.tkt.TktStaffAttachment;
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
 * @date Feb-17, 2022
 ***/
public interface TktStaffAttachmentRepository extends TCrudRepository<TktStaffAttachment>, CrudRepository<TktStaffAttachment, BigDecimal> {
    default List<TktStaffAttachment> tktShowStaffAttachment(TktStaffAttachment tktStaffAttachment) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", tktStaffAttachment._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", tktStaffAttachment._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", tktStaffAttachment._pageFilter()));
        return showSP("TktShowStaffAttachment", tParameters, true);
    }

    default TktStaffAttachment tktShowStaffAttachmentByID(BigDecimal staffAttachmentID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.staffAttachmentID = " + staffAttachmentID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("TktShowStaffAttachment", tParameters, true).get(0);
    }

    default TktStaffAttachment tktInsStaffAttachment(TktStaffAttachment tktStaffAttachment) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("StaffID", tktStaffAttachment.getStaffID()));
        tParameters.add(new TParameter<>("AttachmentID", tktStaffAttachment.getAttachmentID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("TktInsStaffAttachment", tParameters);
        return tktShowStaffAttachmentByID(newID);
    }

    default void tktDelStaffAttachment(BigDecimal staffAttachmentID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("StaffAttachmentID", staffAttachmentID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("TktDelStaffAttachment", tParameters);
    }

    default Meta meta(){
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "staffAttachmentID", "staffAttachmentID", Type.DECIMAL,   0,   false, false, true ));
        cols.add(new Col(null, "staffID",           "staffID",           Type.DECIMAL,   0,   false, false, false));
        cols.add(new Col(null, "attachmentID",      "attachmentID",      Type.DECIMAL,   0,   false, false, false));
//        cols.add(new Col(null, "attachmentFile",      "attachmentFile",      Type.VARBINARY, 100, true,  true,  false));
        cols.add(new Col(null, "creatorID",         "creatorID",         Type.DECIMAL,   0,   false, false, false));
        cols.add(new Col(null, "createDate",        "createDate",        Type.DATE,      0,   false, false, false));
        cols.add(new Col(null, "modifierID",        "modifierID",        Type.DECIMAL,   0,   false, false, false));
        cols.add(new Col(null, "modifyDate",        "modifyDate",        Type.DATE,      0,   false, false, false));
        cols.add(new Col(null, "serverID",          "serverID",          Type.DECIMAL,   0,   false, false, false));

        return new Meta(cols);
    }
}
