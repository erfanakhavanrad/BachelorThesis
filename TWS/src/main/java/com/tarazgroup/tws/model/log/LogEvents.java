//package com.tarazgroup.tws.model.log;
//
//import com.tarazgroup.tws.util.global.TParams;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.math.BigDecimal;
//import java.util.Date;
//
///**
// * @author A.Farahani
// * @date Dec-27, 2021
// */
//@NamedStoredProcedureQuery(
//        name = "LogShowEvents",
//        procedureName = "LogShowEvents",
//        resultClasses = {LogEvents.class},
//        parameters = {
//                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
//        }
//)
//
//@NamedStoredProcedureQuery(
//        name = "LogInsEvents",
//        procedureName = "LogInsEvents",
//        parameters = {
//                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "InputID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "EventType", type = Integer.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "TableName", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "mCode", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "mDate", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "mDesc", type = String.class, mode = ParameterMode.IN)
//        }
//)
//
//@Entity
//public class LogEvents extends TParams implements Serializable {
//    @Id
//    @Column(name = "EventID")
//    private BigDecimal eventID;
//
//    @Column(name = "LoginID")
//    private BigDecimal loginID;
//
//    @Column(name = "InputID")
//    private BigDecimal inputID;
//
//    @Column(name = "EventType")
//    private Integer eventType;
//
//    @Column(name = "TableID")
//    private BigDecimal tableID;
//
//    @Column(name = "EventTime")
//    private Date eventTime;
//
//    @Column(name = "mCode")
//    private String mCode;
//
//    @Column(name = "mDate")
//    private String mDate;
//
//    @Column(name = "mDesc")
//    private String mDesc;
//
//    @Column(name = "LoginTime")
//    private Date loginTime;
//
//    @Column(name = "LastBatch")
//    private Date lastBatch;
//
//    @Column(name = "HostName")
//    private String hostName;
//
//    @Column(name = "ProgramName")
//    private String programName;
//
//    @Column(name = "CommandType")
//    private String commandType;
//
//    @Column(name = "NT_Domain")
//    private String nT_Domain;
//
//    @Column(name = "NT_UserName")
//    private String nT_UserName;
//
//    @Column(name = "NetAddress")
//    private String netAddress;
//
//    @Column(name = "LoginName")
//    private String loginName;
//
//    @Column(name = "TableName")
//    private String tableName;
//
//    @Column(name = "UserFName")
//    private String userFName;
//
//    @Column(name = "UserLName")
//    private String userLName;
//
//    @Column(name = "UserLoginName")
//    private String userLoginName;
//
//    @Column(name = "TableDesc")
//    private String tableDesc;
//
//    @Column(name = "SystemFName")
//    private String systemFName;
//
//    @Column(name = "EventTypeDesc")
//    private String eventTypeDesc;
//
//    @Column(name = "EventTimeStr")
//    private String eventTimeStr;
//
//    @Column(name = "LoginTimeStr")
//    private String loginTimeStr;
//
//    @Column(name = "LastBatchStr")
//    private String lastBatchStr;
//
//    public BigDecimal getEventID() {
//        return eventID;
//    }
//
//    public void setEventID(BigDecimal eventID) {
//        this.eventID = eventID;
//    }
//
//    public BigDecimal getLoginID() {
//        return loginID;
//    }
//
//    public void setLoginID(BigDecimal loginID) {
//        this.loginID = loginID;
//    }
//
//    public BigDecimal getInputID() {
//        return inputID;
//    }
//
//    public void setInputID(BigDecimal inputID) {
//        this.inputID = inputID;
//    }
//
//    public Integer getEventType() {
//        return eventType;
//    }
//
//    public void setEventType(Integer eventType) {
//        this.eventType = eventType;
//    }
//
//    public BigDecimal getTableID() {
//        return tableID;
//    }
//
//    public void setTableID(BigDecimal tableID) {
//        this.tableID = tableID;
//    }
//
//    public Date getEventTime() {
//        return eventTime;
//    }
//
//    public void setEventTime(Date eventTime) {
//        this.eventTime = eventTime;
//    }
//
//    public String getmCode() {
//        return mCode;
//    }
//
//    public void setmCode(String mCode) {
//        this.mCode = mCode;
//    }
//
//    public String getmDate() {
//        return mDate;
//    }
//
//    public void setmDate(String mDate) {
//        this.mDate = mDate;
//    }
//
//    public String getmDesc() {
//        return mDesc;
//    }
//
//    public void setmDesc(String mDesc) {
//        this.mDesc = mDesc;
//    }
//
//    public Date getLoginTime() {
//        return loginTime;
//    }
//
//    public void setLoginTime(Date loginTime) {
//        this.loginTime = loginTime;
//    }
//
//    public Date getLastBatch() {
//        return lastBatch;
//    }
//
//    public void setLastBatch(Date lastBatch) {
//        this.lastBatch = lastBatch;
//    }
//
//    public String getHostName() {
//        return hostName;
//    }
//
//    public void setHostName(String hostName) {
//        this.hostName = hostName;
//    }
//
//    public String getProgramName() {
//        return programName;
//    }
//
//    public void setProgramName(String programName) {
//        this.programName = programName;
//    }
//
//    public String getCommandType() {
//        return commandType;
//    }
//
//    public void setCommandType(String commandType) {
//        this.commandType = commandType;
//    }
//
//    public String getnT_Domain() {
//        return nT_Domain;
//    }
//
//    public void setnT_Domain(String nT_Domain) {
//        this.nT_Domain = nT_Domain;
//    }
//
//    public String getnT_UserName() {
//        return nT_UserName;
//    }
//
//    public void setnT_UserName(String nT_UserName) {
//        this.nT_UserName = nT_UserName;
//    }
//
//    public String getNetAddress() {
//        return netAddress;
//    }
//
//    public void setNetAddress(String netAddress) {
//        this.netAddress = netAddress;
//    }
//
//    public String getLoginName() {
//        return loginName;
//    }
//
//    public void setLoginName(String loginName) {
//        this.loginName = loginName;
//    }
//
//    public String getTableName() {
//        return tableName;
//    }
//
//    public void setTableName(String tableName) {
//        this.tableName = tableName;
//    }
//
//    public String getUserFName() {
//        return userFName;
//    }
//
//    public void setUserFName(String userFName) {
//        this.userFName = userFName;
//    }
//
//    public String getUserLName() {
//        return userLName;
//    }
//
//    public void setUserLName(String userLName) {
//        this.userLName = userLName;
//    }
//
//    public String getUserLoginName() {
//        return userLoginName;
//    }
//
//    public void setUserLoginName(String userLoginName) {
//        this.userLoginName = userLoginName;
//    }
//
//    public String getTableDesc() {
//        return tableDesc;
//    }
//
//    public void setTableDesc(String tableDesc) {
//        this.tableDesc = tableDesc;
//    }
//
//    public String getSystemFName() {
//        return systemFName;
//    }
//
//    public void setSystemFName(String systemFName) {
//        this.systemFName = systemFName;
//    }
//
//    public String getEventTypeDesc() {
//        return eventTypeDesc;
//    }
//
//    public void setEventTypeDesc(String eventTypeDesc) {
//        this.eventTypeDesc = eventTypeDesc;
//    }
//
//    public String getEventTimeStr() {
//        return eventTimeStr;
//    }
//
//    public void setEventTimeStr(String eventTimeStr) {
//        this.eventTimeStr = eventTimeStr;
//    }
//
//    public String getLoginTimeStr() {
//        return loginTimeStr;
//    }
//
//    public void setLoginTimeStr(String loginTimeStr) {
//        this.loginTimeStr = loginTimeStr;
//    }
//
//    public String getLastBatchStr() {
//        return lastBatchStr;
//    }
//
//    public void setLastBatchStr(String lastBatchStr) {
//        this.lastBatchStr = lastBatchStr;
//    }
//}
