package com.tarazgroup.tws.model.pub;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

/**
 * @author Abbas Ashrafi
 * @since v2.0.0
 */

@NamedStoredProcedureQuery(
        name = "PubInsDocumentsFlow",
        procedureName = "PubInsDocumentsFlow",
        parameters = {
                @StoredProcedureParameter(name = "DocumentID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ControllerID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OrgChartControllerID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ControlDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ControlDateG", type = Date.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ParafDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherStatID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ReceiverID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OrgChartReceiverID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "SchemeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ScrID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RefrenceID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "PubDelDocumentsFlow",
        procedureName = "PubDelDocumentsFlow",
        parameters = {
                @StoredProcedureParameter(name = "mID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "PubUpdDocumentsFlow",
        procedureName = "PubUpdDocumentsFlow",
        parameters = {
                @StoredProcedureParameter(name = "mID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ControllerID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OrgchartControllerID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ControlDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ControlDateG", type = Date.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ParafDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherStatID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RefrenceID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
        }
)

@Entity
@Table(name = "PubDocumentsFlow")
public class PubDocumentsFlow implements Serializable {

    @Id
    @Column(name = "mID")
    private BigDecimal mID;

    @Column(name = "DocumentID")
    private BigDecimal documentID;

    @Column(name = "VoucherTypeID")
    private BigDecimal voucherTypeID;

    @Column(name = "ControllerID")
    private BigDecimal controllerID;

    @Column(name = "OrgChartControllerID")
    private BigDecimal orgChartControllerID;

    @Column(name = "ControlDate")
    private String controlDate;

    @Column(name = "ControlDateG")
    private Date controlDateG;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    @Column(name = "ParafDesc")
    private String parafDesc;

    @Column(name = "VoucherStatID")
    private String voucherStatID;

    @Column(name = "ReceiverID")
    private BigDecimal receiverID;

    @Column(name = "OrgChartReceiverID")
    private BigDecimal orgChartReceiverID;

    @Column(name = "SchemeID")
    private BigDecimal schemeID;

    @Column(name = "ScrID")
    private BigDecimal scrID;

    @Column(name = "RefrenceID")
    private String refrenceID;

    @Schema(accessMode = READ_ONLY)
    public BigDecimal getmID() {
        return mID;
    }

    public void setmID(BigDecimal mID) {
        this.mID = mID;
    }

    @NotNull(message = "documentID is mandatory")
    @Schema(
            required = true,
            example = "1000206"
    )
    public BigDecimal getDocumentID() {
        return documentID;
    }

    public void setDocumentID(BigDecimal documentID) {
        this.documentID = documentID;
    }

    @NotNull(message = "voucherTypeID is mandatory")
    @Schema(
            example = "voucherTypeID"
    )
    public BigDecimal getVoucherTypeID() {
        return voucherTypeID;
    }

    public void setVoucherTypeID(BigDecimal voucherTypeID) {
        this.voucherTypeID = voucherTypeID;
    }


    public BigDecimal getOrgChartControllerID() {
        return orgChartControllerID;
    }

    public void setOrgChartControllerID(BigDecimal orgChartControllerID) {
        this.orgChartControllerID = orgChartControllerID;
    }


    @NotNull(message = "controllerID is mandatory")
    @Schema(
            example = "controllerID"
    )
    public BigDecimal getControllerID() {
        return controllerID;
    }

    public void setControllerID(BigDecimal controllerID) {
        this.controllerID = controllerID;
    }


    @Schema(hidden = true)
    public String getControlDate() {
        return controlDate;
    }

    public void setControlDate(String controlDate) {
        this.controlDate = controlDate;
    }

    @Schema(hidden = true)
    public Date getControlDateG() {
        return controlDateG;
    }

    public void setControlDateG(Date controlDateG) {
        this.controlDateG = controlDateG;
    }

    @Schema(hidden = true)
    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    @Schema(
            example = "کنترل خودکار"
    )
    public String getParafDesc() {
        return parafDesc;
    }

    public void setParafDesc(String parafDesc) {
        this.parafDesc = parafDesc;
    }

    @NotNull(message = "voucherStatID is mandatory")
    @Schema(
            example = "4"
    )
    public String getVoucherStatID() {
        return voucherStatID;
    }

    public void setVoucherStatID(String voucherStatID) {
        this.voucherStatID = voucherStatID;
    }


    @Schema(
            example = "receiverID"
    )
    public BigDecimal getReceiverID() {
        return receiverID;
    }

    public void setReceiverID(BigDecimal receiverID) {
        this.receiverID = receiverID;
    }


    public BigDecimal getOrgChartReceiverID() {
        return orgChartReceiverID;
    }

    public void setOrgChartReceiverID(BigDecimal orgChartReceiverID) {
        this.orgChartReceiverID = orgChartReceiverID;
    }

    public BigDecimal getSchemeID() {
        return schemeID;
    }

    public void setSchemeID(BigDecimal schemeID) {
        this.schemeID = schemeID;
    }

    public BigDecimal getScrID() {
        return scrID;
    }

    public void setScrID(BigDecimal scrID) {
        this.scrID = scrID;
    }

    @Schema(
            example = "refrenceID"
    )
    public String getRefrenceID() {
        return refrenceID;
    }

    public void setRefrenceID(String refrenceID) {
        this.refrenceID = refrenceID;
    }
}
