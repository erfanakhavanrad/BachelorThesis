package com.tarazgroup.tws.dao.tkt;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.tkt.TktSettingAttachment;
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
 * @date Jan-30, 2022
 ***/
public interface TktSettingAttachmentRepository extends TCrudRepository<TktSettingAttachment>, CrudRepository<TktSettingAttachment, BigDecimal> {
    default List<TktSettingAttachment> tktShowSettingAttachment(TktSettingAttachment tktSettingAttachment) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", tktSettingAttachment._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", tktSettingAttachment._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", tktSettingAttachment._pageFilter()));
        return showSP("TktShowSettingAttachment", tParameters, true);
    }

    default TktSettingAttachment tktShowSettingAttachmentByID(BigDecimal settingAttachmentID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.SettingAttachmentID = " + settingAttachmentID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("TktShowSettingAttachment", tParameters, true).get(0);
    }

    default TktSettingAttachment tktInsSettingAttachment(TktSettingAttachment tktSettingAttachment) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("SettingID", tktSettingAttachment.getSettingID()));
        tParameters.add(new TParameter<>("AttachmentID", tktSettingAttachment.getAttachmentID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("TktInsSettingAttachment", tParameters);
        return tktShowSettingAttachmentByID(newID);
    }

    default void tktDelSettingAttachment(BigDecimal settingAttachmentID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("SettingAttachmentID", settingAttachmentID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("TktDelSettingAttachment", tParameters);
    }

    default Meta meta(){
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "settingAttachmentID", "settingAttachmentID", Type.DECIMAL,   0,   false, false, true ));
        cols.add(new Col(null, "settingID",           "settingID",           Type.DECIMAL,   0,   false, false, false));
        cols.add(new Col(null, "attachmentID",        "attachmentID",        Type.DECIMAL,   0,   false, false, false));
//        cols.add(new Col(null, "attachmentFile",      "attachmentFile",      Type.VARBINARY, 100, true,  true,  false));
        cols.add(new Col(null, "creatorID",           "creatorID",           Type.DECIMAL,   0,   false, false, false));
        cols.add(new Col(null, "createDate",          "createDate",          Type.DATE,      0,   false, false, false));
        cols.add(new Col(null, "modifierID",          "modifierID",          Type.DECIMAL,   0,   false, false, false));
        cols.add(new Col(null, "modifyDate",          "modifyDate",          Type.DATE,      0,   false, false, false));
        cols.add(new Col(null, "serverID",            "serverID",            Type.DECIMAL,   0,   false, false, false));

        return new Meta(cols);
    }
}
