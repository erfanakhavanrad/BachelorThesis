package com.tarazgroup.tws.model.pub;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

/**
 * @author Salman Majidi
 * @since 2.0.0
 */

@SuppressWarnings("JpaDataSourceORMInspection")
@NamedStoredProcedureQuery(
        name = "PubGetButtonAccess",
        procedureName = "PubGetButtonAccess",
        resultClasses = {PubButton.class},
        parameters = {
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SystemID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FatherID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ButtonID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CanView", type = Boolean.class, mode = ParameterMode.IN)
        }
)

@Entity
@Table(name = "PubButton")
public class PubButton extends TParams implements Serializable {

    @Id
    @Column(name = "ButtonID")
    private BigDecimal buttonID;

    @Column(name = "ButtonCode")
    private String buttonCode;

    @Column(name = "ButtonDesc")
    @Parameter(hidden = true)
    private String buttonDesc;

    @Column(name = "FatherID")
    private BigDecimal fatherID;

    @Column(name = "SystemID")
    private BigDecimal systemID;

    @Column(name = "RefSystemID")
    private BigDecimal refSystemID;

    @Column(name = "WebAddress")
    @Parameter(hidden = true)
    private String webAddress;

    @Column(name = "CanView")
    @Parameter(hidden = true)
    private Boolean canView;

    @Column(name = "CanAdd")
    @Parameter(hidden = true)
    private Boolean canAdd;

    @Column(name = "CanEdit")
    @Parameter(hidden = true)
    private Boolean canEdit;

    @Column(name = "CanDel")
    @Parameter(hidden = true)
    private Boolean canDel;

    @Column(name = "CanPrint")
    @Parameter(hidden = true)
    private Boolean canPrint;

    @Parameter(hidden = true)
    @Transient
    private String query;

    @Column(name = "IsLeaf")
    @Parameter(hidden = true)
    private Boolean isLeaf;


    @Schema(accessMode = READ_ONLY)
    public BigDecimal getButtonID() {
        return buttonID;
    }

    public void setButtonID(BigDecimal buttonID) {
        this.buttonID = buttonID;
    }

    @Schema(
            example = "23"
    )
    public BigDecimal getSystemID() {
        return systemID;
    }

    public void setSystemID(BigDecimal systemID) {
        this.systemID = systemID;
    }

    @Schema(
            example = "4"
    )
    public BigDecimal getRefSystemID() {
        return refSystemID;
    }

    public void setRefSystemID(BigDecimal refSystemID) {
        this.refSystemID = refSystemID;
    }

    @Schema(
            example = "WebAddress"
    )
    public String getWebAddress() {
        return webAddress;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    @Schema(
            example = "FatherID1"
    )
    public BigDecimal getFatherID() {
        return fatherID;
    }

    public void setFatherID(BigDecimal fatherID) {
        this.fatherID = fatherID;
    }

    @Schema(
            example = "002500"
    )
    public String getButtonCode() {
        return buttonCode;
    }

    public void setButtonCode(String buttonCode) {
        this.buttonCode = buttonCode;
    }

    @Schema(
            example = "CanView1"
    )
    public Boolean isCanView() {
        return canView;
    }

    public void setCanView(Boolean canView) {
        this.canView = canView;
    }

    @Schema(
            example = "true"
    )
    public Boolean isCanAdd() {
        return canAdd;
    }

    public void setCanAdd(Boolean canAdd) {
        this.canAdd = canAdd;
    }

    @Schema(
            example = "true"
    )
    public Boolean isCanEdit() {
        return canEdit;
    }

    public void setCanEdit(Boolean canEdit) {
        this.canEdit = canEdit;
    }

    @Schema(
            example = "false"
    )
    public Boolean isCanDel() {
        return canDel;
    }

    public void setCanDel(Boolean canDel) {
        this.canDel = canDel;
    }

    @Schema(
            example = "false"
    )
    public Boolean isCanPrint() {
        return canPrint;
    }

    public void setCanPrint(Boolean canPrint) {
        this.canPrint = canPrint;
    }

    @Schema(
            example = "ButtonDesc1"
    )
    public String getButtonDesc() {
        return buttonDesc;
    }

    public void setButtonDesc(String buttonDesc) {
        this.buttonDesc = buttonDesc;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Boolean getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(Boolean isLeaf) {
        this.isLeaf = isLeaf;
    }
}
