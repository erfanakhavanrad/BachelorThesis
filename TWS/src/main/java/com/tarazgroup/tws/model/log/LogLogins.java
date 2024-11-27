package com.tarazgroup.tws.model.log;


import com.tarazgroup.tws.model.pub.PubUser;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author Salman Majidi
 * @since 2.0.0
 */

@NamedStoredProcedureQuery(
        name = "LogInsLogins",
        procedureName = "LogInsLogins",
        parameters = {
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "WindowsLoginName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ComputerName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "WindowsVersion", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsActive", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LoginTimeStr", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SystemID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IpNumber", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "DeviceType", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "JAX_RS_Token", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "JAX_RS_Token_Expire_Time", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)
@NamedStoredProcedureQuery(
        name = "LogShowLogins",
        procedureName = "LogShowLogins",
        resultClasses = {LogLogins.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RepType", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@Entity
@Table(name = "LogLogins")
public class LogLogins implements Serializable {

    @Id
    @Column(name = "LoginID")
    private BigDecimal loginId;

    //there is no relation in DB
    @JoinColumn(name = "UserID")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private PubUser pubUser;

    @Column(name = "WindowsLoginName")
    private String windowsLoginName;

    @Column(name = "ComputerName")
    private String computerName;

    @Column(name = "WindowsVersion")
    private String windowsVersion;

    @Column(name = "ServerID")
    private BigDecimal serverId;

    @Column(name = "IsActive")
    private String isActive;

    @Column(name = "LoginTime")
    private java.sql.Timestamp loginTime;

    @Column(name = "LoginTimeStr")
    private String loginTimeStr;

    @Column(name = "IPNumber")
    private String ipNumber;

    @Column(name = "SystemID")
    private BigDecimal systemId;

    @Column(name = "ClientID")
    private BigDecimal clientId;

    @Column(name = "Host_Process_ID")
    private BigDecimal hostProcessId;

    @Column(name = "JAX_RS_Token")
    private String jaxRsToken;

    @Column(name = "JAX_RS_Token_Expire_Time")
    private BigDecimal jaxRsTokenExpireTime;

    @Column(name = "JAX_RS_LoginTime")
    private java.sql.Timestamp jaxRsLoginTime;

    public BigDecimal getLoginId() {
        return loginId;
    }

    public void setLoginId(BigDecimal loginId) {
        this.loginId = loginId;
    }


    public String getWindowsLoginName() {
        return windowsLoginName;
    }

    public void setWindowsLoginName(String windowsLoginName) {
        this.windowsLoginName = windowsLoginName;
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public String getWindowsVersion() {
        return windowsVersion;
    }

    public void setWindowsVersion(String windowsVersion) {
        this.windowsVersion = windowsVersion;
    }

    public BigDecimal getServerId() {
        return serverId;
    }

    public void setServerId(BigDecimal serverId) {
        this.serverId = serverId;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public Timestamp getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Timestamp loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginTimeStr() {
        return loginTimeStr;
    }

    public void setLoginTimeStr(String loginTimeStr) {
        this.loginTimeStr = loginTimeStr;
    }

    public String getIpNumber() {
        return ipNumber;
    }

    public void setIpNumber(String ipNumber) {
        this.ipNumber = ipNumber;
    }

    public BigDecimal getSystemId() {
        return systemId;
    }

    public void setSystemId(BigDecimal systemId) {
        this.systemId = systemId;
    }

    public BigDecimal getClientId() {
        return clientId;
    }

    public void setClientId(BigDecimal clientId) {
        this.clientId = clientId;
    }

    public BigDecimal getHostProcessId() {
        return hostProcessId;
    }

    public void setHostProcessId(BigDecimal hostProcessId) {
        this.hostProcessId = hostProcessId;
    }

    public String getJaxRsToken() {
        return jaxRsToken;
    }

    public void setJaxRsToken(String jaxRsToken) {
        this.jaxRsToken = jaxRsToken;
    }

    public BigDecimal getJaxRsTokenExpireTime() {
        return jaxRsTokenExpireTime;
    }

    public void setJaxRsTokenExpireTime(BigDecimal jaxRsTokenExpireTime) {
        this.jaxRsTokenExpireTime = jaxRsTokenExpireTime;
    }

    public Timestamp getJaxRsLoginTime() {
        return jaxRsLoginTime;
    }

    public void setJaxRsLoginTime(Timestamp jaxRsLoginTime) {
        this.jaxRsLoginTime = jaxRsLoginTime;
    }


    public PubUser getPubUser() {
        return pubUser;
    }

    public void setPubUser(PubUser pubUser) {
        this.pubUser = pubUser;
    }
}
