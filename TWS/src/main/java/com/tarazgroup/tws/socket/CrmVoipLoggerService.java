package com.tarazgroup.tws.socket;

import com.tarazgroup.tws.dao.TCrudRepositoryImpl;
import com.tarazgroup.tws.model.crm.CrmVoipLogs;
import com.tarazgroup.tws.util.exception.TConflictException;
import com.tarazgroup.tws.util.global.TParameter;
import org.asteriskjava.manager.event.ManagerEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Aref Azizi
 * @date 12/6/22
 */
@Service
public class  CrmVoipLoggerService {
    @Autowired
    private  static EntityManager  entityManager;
    public static   void crmInsVoipLogger(ManagerEvent event) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("CallerName", event.getCallerIdName()));
        tParameters.add(new TParameter<>("CallerNumber", event.getCallerIdNum()));
        tParameters.add(new TParameter<>("ConnectedLineName", event.getConnectedLineName()));
        tParameters.add(new TParameter<>("ConnectedLineNumber", event.getConnectedLineNum()));
        tParameters.add(new TParameter<>("ChannelState", event.getChannelState()));
        tParameters.add(new TParameter<>("ChannelStateDesc", event.getChannelStateDesc()));
        tParameters.add(new TParameter<>("DateReceived", event.getDateReceived()));
        tParameters.add(new TParameter<>("Priority", event.getPriority()));
        tParameters.add(new TParameter<>("Server", event.getServer()));
        tParameters.add(new TParameter<>("SequenceNumber", event.getSequenceNumber()));
        tParameters.add(new TParameter<>("SystemName", event.getSystemName()));
        tParameters.add(new TParameter<>("Context", event.getContext()));
        tParameters.add(new TParameter<>("Exten", event.getExten()));
        tParameters.add(new TParameter<>("CallFile", event.getFile()));
        tParameters.add(new TParameter<>("Func", event.getFunc()));
        tParameters.add(new TParameter<>("Line", event.getLine()));
        tParameters.add(new TParameter<>("Privilege", event.getPrivilege()));
        tParameters.add(new TParameter<>("Timestamp", event.getTimestamp()));
        BigDecimal newID = insSP("CrmInsVoipLogs", tParameters);

    }
    public CrmVoipLoggerService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //    public static   void crmInsVoipLogger(ManagerEvent event) {
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
//        BigDecimal newID = insSP("CrmInsVoipLogs", tParameters);
//
//    }
    public static   void crmInsVoipLogger(CrmVoipLogs crmVoipLogs) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("CallerID", crmVoipLogs.getCallerID()));
        tParameters.add(new TParameter<>("Destination", crmVoipLogs.getDestination()));
        tParameters.add(new TParameter<>("DestinationChannel", crmVoipLogs.getDestinationChannel()));
        tParameters.add(new TParameter<>("DestinationContext", crmVoipLogs.getDestinationContext()));
        tParameters.add(new TParameter<>("Disposition", crmVoipLogs.getDisposition()));
        tParameters.add(new TParameter<>("Duration", crmVoipLogs.getDuration()));
        tParameters.add(new TParameter<>("AmaFlags", crmVoipLogs.getAmaFlags()));
        tParameters.add(new TParameter<>("Src", crmVoipLogs.getSrc()));
        tParameters.add(new TParameter<>("LastApplication", crmVoipLogs.getLastApplication()));
        tParameters.add(new TParameter<>("UniqueId", crmVoipLogs.getUniqueId()));
        tParameters.add(new TParameter<>("UserField", crmVoipLogs.getUserField()));
        tParameters.add(new TParameter<>("BillableSeconds", crmVoipLogs.getBillableSeconds()));
        tParameters.add(new TParameter<>("Recordfile", crmVoipLogs.getRecordfile()));
        tParameters.add(new TParameter<>("AccountCode", crmVoipLogs.getAccountCode()));
        tParameters.add(new TParameter<>("AnswerTime", crmVoipLogs.getAnswerTime()));
        tParameters.add(new TParameter<>("AnswerTimeAsDate", crmVoipLogs.getAnswerTimeAsDate()));
        tParameters.add(new TParameter<>("Channel", crmVoipLogs.getChannel()));
        tParameters.add(new TParameter<>("StartTime", crmVoipLogs.getStartTime()));
        tParameters.add(new TParameter<>("StartTimeAsDate", crmVoipLogs.getStartTimeAsDate()));
        tParameters.add(new TParameter<>("EndTime", crmVoipLogs.getEndTime()));
        tParameters.add(new TParameter<>("EndTimeAsDate", crmVoipLogs.getEndTimeAsDate()));
        tParameters.add(new TParameter<>("LastData", crmVoipLogs.getLastData()));
        tParameters.add(new TParameter<>("CallDateAsShamsi", crmVoipLogs.getCallDateAsShamsi()));
        BigDecimal newID = insSP("CrmInsVoipLogs", tParameters);

    }
    public  static BigDecimal insSP(String storedProcedureName, List<TParameter<?>> tParameters) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery(storedProcedureName);
        for (TParameter tparameter : tParameters) {
            storedProcedureQuery.setParameter(tparameter.getName(), tparameter.getValue());
        }
        storedProcedureQuery.execute();
        BigDecimal result = (BigDecimal) storedProcedureQuery.getOutputParameterValue("Result");
        if (result.intValue() != 0) {
            throw new TConflictException(result.intValue(), (String) storedProcedureQuery.getOutputParameterValue("ErrMsg"));
        }
        try {
            storedProcedureQuery.getOutputParameterValue("NewID");
            return (BigDecimal) storedProcedureQuery.getOutputParameterValue("NewID");
        } catch (Exception e) {
            return new BigDecimal(-1);
        }
    }
}
