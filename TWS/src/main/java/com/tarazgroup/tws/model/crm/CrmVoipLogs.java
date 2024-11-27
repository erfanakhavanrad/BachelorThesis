package com.tarazgroup.tws.model.crm;

import com.tarazgroup.tws.util.global.TParams;

import javax.annotation.Nullable;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Aref Azizi
 * @date 12/1/22
 */


@NamedStoredProcedureQuery(
        name = "CrmShowVoipLogs",
        procedureName = "CrmShowVoipLogs",
        resultClasses = {CrmVoipLogs.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
        }

)
@NamedStoredProcedureQuery(
        name = "CrmInsVoipLogs",
        procedureName = "CrmInsVoipLogs",
        resultClasses = {CrmVoipLogs.class},
        parameters = {

                @StoredProcedureParameter(name = "CallerID", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Destination", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DestinationChannel", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DestinationContext", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Disposition", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Duration", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AmaFlags", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Src", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LastApplication", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UniqueId", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserField", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BillableSeconds", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Recordfile", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AccountCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AnswerTime", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AnswerTimeAsDate", type = Date.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Channel", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StartTime", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StartTimeAsDate", type = Date.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "EndTime", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "EndTimeAsDate", type = Date.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LastData", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CallDateAsShamsi", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)


@Entity
public class CrmVoipLogs extends TParams implements Serializable {

    @Id
    @Column(name = "VoipLogID")
    private BigDecimal voipLogID;

    @Nullable
    @Column(name = "CallerID")
    private String callerID;
    @Nullable
    @Column(name = "Destination")
    private String destination;
    @Nullable
    @Column(name = "DestinationChannel")
    private String destinationChannel;
    @Nullable
    @Column(name = "DestinationContext")
    private String destinationContext;
    @Nullable
    @Column(name = "Disposition")
    private String disposition;
    @Nullable
    @Column(name = "Duration")
    private BigDecimal duration;
    @Nullable
    @Column(name = "AmaFlags")
    private String amaFlags;
    @Nullable
    @Column(name = "Src")
    private String src;
    @Nullable
    @Column(name = "LastApplication")
    private String lastApplication;
    @Nullable
    @Column(name = "UniqueId")
    private String uniqueId;
    @Nullable
    @Column(name = "UserField")
    private String userField;
    @Nullable
    @Column(name = "BillableSeconds")
    private BigDecimal billableSeconds;
    @Nullable
    @Column(name = "Recordfile")
    private String recordfile;
    @Nullable
    @Column(name = "AccountCode")
    private String accountCode;
    @Nullable
    @Column(name = "AnswerTime")
    private String answerTime;
    @Nullable
    @Column(name = "AnswerTimeAsDate")
    private Date answerTimeAsDate;
    @Nullable
    @Column(name = "LastData")
    private String lastData;
    @Nullable
    @Column(name = "Channel")
    private String channel;
    @Nullable
    @Column(name = "StartTime")
    private String startTime;
    @Nullable
    @Column(name = "StartTimeAsDate")
    private Date startTimeAsDate;
    @Nullable
    @Column(name = "EndTime")
    private String endTime;
    @Nullable
    @Column(name = "EndTimeAsDate")
    private Date endTimeAsDate;
    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    @Column(name = "UserInternalNumber")
    private String userInternalNumber;

    @Column(name = "CallDateAsShamsi")
    private String callDateAsShamsi;


    public BigDecimal getVoipLogID() {
        return voipLogID;
    }

    public void setVoipLogID(BigDecimal voipLogID) {
        this.voipLogID = voipLogID;
    }


    public String getCallerID() {
        return callerID;
    }

    public void setCallerID(String callerID) {
        this.callerID = callerID;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }


    public String getDestinationChannel() {
        return destinationChannel;
    }

    public void setDestinationChannel(String destinationChannel) {
        this.destinationChannel = destinationChannel;
    }

    public String getDestinationContext() {
        return destinationContext;
    }

    public void setDestinationContext(String destinationContext) {
        this.destinationContext = destinationContext;
    }

    public String getDisposition() {
        return disposition;
    }

    public void setDisposition(String disposition) {
        this.disposition = disposition;
    }


    public BigDecimal getDuration() {
        return duration;
    }

    public void setDuration(BigDecimal duration) {
        this.duration = duration;
    }


    public String getAmaFlags() {
        return amaFlags;
    }

    public void setAmaFlags(String amaFlags) {
        this.amaFlags = amaFlags;
    }


    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }


    public String getLastApplication() {
        return lastApplication;
    }

    public void setLastApplication(String lastApplication) {
        this.lastApplication = lastApplication;
    }


    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }


    public String getUserField() {
        return userField;
    }

    public void setUserField(String userField) {
        this.userField = userField;
    }


    public BigDecimal getBillableSeconds() {
        return billableSeconds;
    }

    public void setBillableSeconds(BigDecimal billableSeconds) {
        this.billableSeconds = billableSeconds;
    }


    public String getRecordfile() {
        return recordfile;
    }

    public void setRecordfile(String recordfile) {
        this.recordfile = recordfile;
    }


    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }


    public String getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(String answerTime) {
        this.answerTime = answerTime;
    }


    public Date getAnswerTimeAsDate() {
        return answerTimeAsDate;
    }

    public void setAnswerTimeAsDate(Date answerTimeAsDate) {
        this.answerTimeAsDate = answerTimeAsDate;
    }


    public String getLastData() {
        return lastData;
    }

    public void setLastData(String lastData) {
        this.lastData = lastData;
    }


    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }


    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }


    public Date getStartTimeAsDate() {
        return startTimeAsDate;
    }

    public void setStartTimeAsDate(Date startTimeAsDate) {
        this.startTimeAsDate = startTimeAsDate;
    }


    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }


    public Date getEndTimeAsDate() {
        return endTimeAsDate;
    }

    public void setEndTimeAsDate(Date endTimeAsDate) {
        this.endTimeAsDate = endTimeAsDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    public String getUserInternalNumber() {
        return userInternalNumber;
    }

    public void setUserInternalNumber(String userInternalNumber) {
        this.userInternalNumber = userInternalNumber;
    }

    public String getCallDateAsShamsi() {
        return callDateAsShamsi;
    }

    public void setCallDateAsShamsi(String callDateAsShamsi) {
        this.callDateAsShamsi = callDateAsShamsi;
    }
}

