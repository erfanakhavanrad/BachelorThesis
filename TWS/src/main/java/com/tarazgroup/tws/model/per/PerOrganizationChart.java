package com.tarazgroup.tws.model.per;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

/**
 * @author Abbas Ashrafi
 * @since v2.0.0
 */

@NamedStoredProcedureQuery(
        name = "PerShowOrganizationChart",
        procedureName = "PerShowOrganizationChart",
        resultClasses = {PerOrganizationChart.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsWebUser", type = Boolean.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "PerInsOrganizationChart",
        procedureName = "PerInsOrganizationChart",
        parameters = {
                @StoredProcedureParameter(name = "OrganizationChartFatherID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OrganizationChartCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OrganizationChartName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ClassLevel", type = Integer.class, mode = ParameterMode.OUT)

        }
)

@NamedStoredProcedureQuery(
        name = "PerDelOrganizationChart",
        procedureName = "PerDelOrganizationChart",
        parameters = {
                @StoredProcedureParameter(name = "OrganizationChartID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)

        }
)

@NamedStoredProcedureQuery(
        name = "PerUpdOrganizationChart",
        procedureName = "PerUpdOrganizationChart",
        parameters = {
                @StoredProcedureParameter(name = "OrganizationChartID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OrganizationChartFatherID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OrganizationChartCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OrganizationChartName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "iOrganizationChartID", type = BigDecimal.class, mode = ParameterMode.OUT)

        }
)

@Entity
@Table(name = "PerOrganizationChart")
public class PerOrganizationChart implements Serializable {

    @Id
    @Column(name = "OrganizationChartID")
    @Schema(accessMode = READ_ONLY)
    private BigDecimal organizationChartID;

    @Column(name = "OrganizationChartCode")
    @Schema(
            example = "organizationChartCode"
    )
    private String organizationChartCode;

    @Column(name = "OrganizationChartName")
    @Schema(
            example = "organizationChartName"
    )
    private String organizationChartName;

    @Column(name = "ServerID")
    @Schema(hidden = true)
    private BigDecimal serverID;

    @Column(name = "CreateDate")
    @Schema(hidden = true)
    private Date createDate;

    @Column(name = "CreatorID")
    @Schema(hidden = true)
    private BigDecimal creatorID;

    @Column(name = "ModifyDate")
    @Schema(hidden = true)
    private Date modifyDate;

    @Column(name = "ModifierID")
    @Schema(hidden = true)
    private BigDecimal modifierID;

    @Column(name = "ClassLevel")
    @Schema(
            example = "classLevel"
    )
    private Integer classLevel;

    public BigDecimal getOrganizationChartID() {
        return organizationChartID;
    }

    public void setOrganizationChartID(BigDecimal organizationChartID) {
        this.organizationChartID = organizationChartID;
    }

    public String getOrganizationChartCode() {
        return organizationChartCode;
    }

    public void setOrganizationChartCode(String organizationChartCode) {
        this.organizationChartCode = organizationChartCode;
    }

    public String getOrganizationChartName() {
        return organizationChartName;
    }

    public void setOrganizationChartName(String organizationChartName) {
        this.organizationChartName = organizationChartName;
    }

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public BigDecimal getModifierID() {
        return modifierID;
    }

    public void setModifierID(BigDecimal modifierID) {
        this.modifierID = modifierID;
    }

    public Integer getClassLevel() {
        return classLevel;
    }

    public void setClassLevel(Integer classLevel) {
        this.classLevel = classLevel;
    }
}
