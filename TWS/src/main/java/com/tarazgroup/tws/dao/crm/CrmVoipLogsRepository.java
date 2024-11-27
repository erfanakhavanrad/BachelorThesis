package com.tarazgroup.tws.dao.crm;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.crm.CrmVoipLogs;
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
 * @author Aref Azizi
 * @date 12/1/22
 */
public  interface CrmVoipLogsRepository extends TCrudRepository<CrmVoipLogs>, CrudRepository<CrmVoipLogs, BigDecimal> {

    public static  String internalID = null;
    // GET ALL
    default List<CrmVoipLogs> crmShowVoipLogs(CrmVoipLogs crmVoipLogs) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter",crmVoipLogs._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmVoipLogs._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmVoipLogs._pageFilter()));
        tParameters.add(new TParameter<>("UserID",logLogins.getPubUser().getUserID() ));
        return showSP("CrmShowVoipLogs", tParameters, true);
    }

//   // POST
//
//    default CrmVoipLogs crmInsVoipLogger(CrmVoipLogs crmVoipLogs) {
//        LogLogins logLogins = fetchUserDetail();
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter<>("CallerName", crmVoipLogs.getCallerName()));
//        tParameters.add(new TParameter<>("CallerNumber", crmVoipLogs.getCallerNumber()));
//        tParameters.add(new TParameter<>("ConnectedLineName", crmVoipLogs.getConnectedLineName()));
//        tParameters.add(new TParameter<>("ConnectedLineNumber", crmVoipLogs.getConnectedLineNumber()));
//        tParameters.add(new TParameter<>("ChannelState", crmVoipLogs.getChannelState()));
//        tParameters.add(new TParameter<>("ChannelStateDesc", crmVoipLogs.getChanelStateDesc()));
//        tParameters.add(new TParameter<>("DateReceived", crmVoipLogs.getDateReceived()));
//        tParameters.add(new TParameter<>("Priority", crmVoipLogs.getPriority()));
//        tParameters.add(new TParameter<>("Server", crmVoipLogs.getServer()));
//        tParameters.add(new TParameter<>("SequenceNumber", crmVoipLogs.getSequenceNumber()));
//        tParameters.add(new TParameter<>("SystemName", crmVoipLogs.getSystemName()));
//        tParameters.add(new TParameter<>("Context", crmVoipLogs.getContext()));
//        tParameters.add(new TParameter<>("Exten", crmVoipLogs.getExten()));
//        tParameters.add(new TParameter<>("CallFile", crmVoipLogs.getCallFile()));
//        tParameters.add(new TParameter<>("Func", crmVoipLogs.getFunc()));
//        tParameters.add(new TParameter<>("Line", crmVoipLogs.getLine()));
//        tParameters.add(new TParameter<>("Privilege", crmVoipLogs.getPrivilege()));
//        tParameters.add(new TParameter<>("Timestamp", crmVoipLogs.getTimeStamp()));
//        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
//        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
//        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
//        BigDecimal newID = insSP("CrmInsVoipLogs", tParameters);
//        return  null;
//    }
//    default  void crmInsVoipLogger(ManagerEvent event) {
//        event = setEventManager(event);
//        LogLogins logLogins = fetchUserDetail();
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter<>("CallerName", event.getCallerIdName()));
//        tParameters.add(new TParameter<>("CallerNumber", event.getCallerIdNum()));
//        tParameters.add(new TParameter<>("ConnectedLineName", event.getConnectedLineName()));
//        tParameters.add(new TParameter<>("ConnectedLineNumber", event.getConnectedLineNum()));
//        tParameters.add(new TParameter<>("ChannelState", event.getChannelState()));
//        tParameters.add(new TParameter<>("ChannelStateDesc", event.getChannelStateDesc()));
//        tParameters.add(new TParameter<>("DateReceived", event.getDateReceived()));
//        tParameters.add(new TParameter<>("Priority", event.getPriority()));
//        tParameters.add(new TParameter<>("Server", event.getServer()));
//        tParameters.add(new TParameter<>("SequenceNumber", event.getSequenceNumber()));
//        tParameters.add(new TParameter<>("SystemName", event.getSystemName()));
//        tParameters.add(new TParameter<>("Context", event.getContext()));
//        tParameters.add(new TParameter<>("Exten", event.getExten()));
//        tParameters.add(new TParameter<>("CallFile", event.getFile()));
//        tParameters.add(new TParameter<>("Func", event.getFunc()));
//        tParameters.add(new TParameter<>("Line", event.getLine()));
//        tParameters.add(new TParameter<>("Privilege", event.getPrivilege()));
//        tParameters.add(new TParameter<>("Timestamp", event.getTimestamp()));
//        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
//        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
//        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
//        BigDecimal newID = insSP("CrmInsVoipLogs", tParameters);
//    }


    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "voipLogID", "voipLogID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "callerID", "تماس گیرنده", Type.STRING, 120, true, true, false));
        cols.add(new Col(null, "destination", "مخاطب", Type.STRING, 120, true, true, false));
        cols.add(new Col(null, "disposition", "وضعیت تماس", Type.STRING, 120, true, true, false));
        cols.add(new Col(null, "destinationContext", "destinationContext", Type.STRING, 100, false, false, false));
        cols.add(new Col(null, "destinationChannel", "destinationChannel", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "duration", "مدت زمان (ثانیه)  ", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "amaFlags", "", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "src", "src", Type.STRING, 100, false, false, false));
        cols.add(new Col(null, "lastApplication", "lastApplication", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "uniqueId", "uniqueId", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "userField", "userField", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "billableSeconds", "billableSeconds", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "recordfile", "recordfile", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "accountCode", "accountCode", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "answerTimeAsDate", "answerTimeAsDate", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "lastData", "lastData", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "channel", "channel", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "startTime", "زمان شروع", Type.DATE, 120, true, true, false));
        cols.add(new Col(null, "startTimeAsDate", "زمان پاسخ", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "answerTime", "زمان پاسخ", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "endTime", "زمان پایان", Type.DATE, 120, true, true, false));
        cols.add(new Col(null, "endTimeAsDate", "زمان پایان", Type.STRING, 0,false, false, false));
        cols.add(new Col(null, "userInternalNumber", "userInternalNumber", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "callDateAsShamsi", "تاریخ تماس", Type.STRING, 120, true, true, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "createDate", "زمان برقراری", Type.STRING, 0, false, true, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.STRING, 0, false, false, false));
        return new Meta(cols);
    }
}
