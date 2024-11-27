package com.tarazgroup.tws.model.pub;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

/**
 * @author alireza_bayat
 * @since 2.0.0
 */


@NamedStoredProcedureQuery(
        name = "PubShowServer",
        procedureName = "PubShowServer",
        resultClasses = {PubServer.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
        }
)

@Entity
@Table(name = "PubServer")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class PubServer extends TParams {

    @Id
    @Column(name = "ServerID", columnDefinition = "decimal")
    private BigDecimal serverID;

    @Column(name = "ServerDesc", columnDefinition = "nvarchar")
    private String serverDesc;

    @Column(name = "CompanyID", columnDefinition = "decimal")
    private BigDecimal companyID;

    @Column(name = "ServerIP", columnDefinition = "nvarchar")
    private String serverIP;

    @Column(name = "ServerName", columnDefinition = "nvarchar")
    private String serverName;

    @Transient
    @Column(name = "ServerAddress", columnDefinition = "nvarchar")
    private String serverAddress;

    @Schema(accessMode = READ_ONLY)
    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    @NotNull(message = "serverDesc is mandatory")
    @Schema(
            required = true,
            example = "serverDesc1"
    )
    public String getServerDesc() {
        return serverDesc;
    }

    public void setServerDesc(String serverDesc) {
        this.serverDesc = serverDesc;
    }

    @Schema(
            required = true,
            example = "127.0.0.1"
    )
    public String getServerIP() {
        return serverIP;
    }

    public void setServerIP(String serverIP) {
        this.serverIP = serverIP;
    }

    @Schema(
            required = true,
            example = "serverName1"
    )
    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    @Schema(hidden = true)
    public String getServerAddress() {
        return serverAddress;
    }

    public void setServerAddress(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    @Schema(
            required = true,
            example = "companyID1"
    )
    public BigDecimal getCompanyID() {
        return companyID;
    }

    public void setCompanyID(BigDecimal company) {
        this.companyID = company;
    }

    @Override
    public String toString() {
        return "PubServer{" +
                "serverID=" + serverID +
                ", serverDesc='" + serverDesc + '\'' +
                ", serverName='" + serverName + '\'' +
                '}';
    }

}

