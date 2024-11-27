package com.tarazgroup.tws.model.pub;

import com.tarazgroup.tws.util.global.ITParams;
import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

/**
 * @author Salman Majidi
 * @since 2.0.0
 */
@NamedStoredProcedureQuery(
        name = "PubShowSystems",
        procedureName = "PubShowSystems",
        resultClasses = {PubSystems.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)


@Entity
@Table(name = "PubSystems")
public class PubSystems extends TParams implements Serializable, ITParams {

    @Id
    @Column(name = "SystemID", columnDefinition = "decimal")
    private BigDecimal systemID;

    @Column(name = "SystemFName", columnDefinition = "nvarchar")
    private String systemFName;

    @Column(name = "SystemGroupID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal systemGroupID;

    @Column(name = "SystemEName", columnDefinition = "nvarchar")
    @Parameter(hidden = true)
    private String systemEName;

    @Column(name = "SysBriefName", columnDefinition = "nvarchar")
    private String sysBriefName;

    @Column(name = "IsShownFlag", columnDefinition = "bit")
    @Parameter(hidden = true)
    private Boolean shownFlag;

    @Column(name = "IsActivatedFlag", columnDefinition = "bit")
    @Parameter(hidden = true)
    private Boolean activatedFlag;

    @Column(name = "SysOrder", columnDefinition = "tinyint")
    @Transient
    @Parameter(hidden = true)
    private Integer sysOrder;

    @Schema(accessMode = READ_ONLY)
    public BigDecimal getSystemID() {
        return systemID;
    }

    public void setSystemID(BigDecimal systemID) {
        this.systemID = systemID;
    }

    @NotBlank(message = "systemFName is mandatory")
    @Schema(
            required = true,
            example = "systemFName1"
    )
    public String getSystemFName() {
        return systemFName;
    }

    public void setSystemFName(String systemFName) {
        this.systemFName = systemFName;
    }

    @NotNull(message = "systemGroupID is mandatory")
    @Schema(
            required = true,
            example = "1"
    )
    public BigDecimal getSystemGroupID() {
        return systemGroupID;
    }

    public void setSystemGroupID(BigDecimal systemGroupID) {
        this.systemGroupID = systemGroupID;
    }

    @Schema(
            example = "systemEName1"
    )
    public String getSystemEName() {
        return systemEName;
    }

    public void setSystemEName(String systemEName) {
        this.systemEName = systemEName;
    }

    @NotBlank(message = "sysBriefName is mandatory")
    @Schema(
            required = true,
            example = "sysBriefName"
    )
    public String getSysBriefName() {
        return sysBriefName;
    }

    public void setSysBriefName(String sysBriefName) {
        this.sysBriefName = sysBriefName;
    }

    @NotNull(message = "isShownFlag is mandatory")
    @Schema(
            required = true,
            example = "true"
    )
    public Boolean isShownFlag() {
        return shownFlag;
    }

    public void setShownFlag(Boolean shownFlag) {
        this.shownFlag = shownFlag;
    }

    @NotNull(message = "isActivatedFlag is mandatory")
    @Schema(
            required = true,
            example = "false"
    )
    public Boolean isActivatedFlag() {
        return activatedFlag;
    }

    public void setActivatedFlag(Boolean activatedFlag) {
        this.activatedFlag = activatedFlag;
    }

    @NotNull(message = "sysOrder is mandatory")
    @Schema(
            required = true,
            example = "1"
    )
    public Integer getSysOrder() {
        return sysOrder;
    }

    public void setSysOrder(Integer sysOrder) {
        this.sysOrder = sysOrder;
    }
}
