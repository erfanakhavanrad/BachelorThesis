package com.tarazgroup.tws.model.pub;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */

@NamedStoredProcedureQuery(
        name = "PubShowYears",
        procedureName = "PubShowYears",
        resultClasses = {PubYears.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsWebUser", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)
@NamedStoredProcedureQuery(
        name = "PubInsYears",
        procedureName = "PubInsYears",
        resultClasses = {PubYears.class},
        parameters = {
                @StoredProcedureParameter(name = "ShamsiYear", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StartShamsiDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "EndShamsiDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "PubDelYears",
        procedureName = "PubDelYears",
        resultClasses = {PubYears.class},
        parameters = {
                @StoredProcedureParameter(name = "YearID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "YrID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "PubUpdYears",
        procedureName = "PubUpdYears",
        resultClasses = {PubYears.class},
        parameters = {
                @StoredProcedureParameter(name = "YearID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ShamsiYear",type = Integer.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "EndShamsiDate",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StartShamsiDate",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearDesc",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID",type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LoginID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result",type = BigDecimal.class,mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg",type = String.class,mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "YRID",type = BigDecimal.class,mode = ParameterMode.IN)
        }
)

@Entity
@Table(name = "PubYears")
public class PubYears extends TParams implements Serializable {

    @Id
    @Column(name = "YearID")
    private BigDecimal yearID;

    @Column(name = "CreateDate")
    @Parameter(hidden = true)
    private Date createDate;

    @Column(name = "CreatorID")
    @Parameter(hidden = true)
    private BigDecimal creatorID;

    @Column(name = "ModifyDate")
    @Parameter(hidden = true)
    private Date modifyDate;

    @Column(name = "ModifierID")
    @Parameter(hidden = true)
    private BigDecimal modifierID;

    @Column(name = "ServerID")
    @Parameter(hidden = true)
    private BigDecimal serverID;

    @Column(name = "ShamsiYear")
    @Parameter(hidden = true)
    private Integer shamsiYear;

    @Column(name = "StartShamsiDate")
    @Parameter(hidden = true)
    private String startShamsiDate;

    @Column(name = "EndShamsiDate")
    @Parameter(hidden = true)
    private String endShamsiDate;

    @Column(name = "YearDesc")
    private String yearDesc;

    @Schema(accessMode = READ_ONLY)
    public BigDecimal getYearID() {
        return yearID;
    }

    public void setYearID(BigDecimal yearID) {
        this.yearID = yearID;
    }

    @Schema(hidden = true)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Schema(hidden = true)
    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }

    @Schema(hidden = true)
    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Schema(hidden = true)
    public BigDecimal getModifierID() {
        return modifierID;
    }

    public void setModifierID(BigDecimal modifierID) {
        this.modifierID = modifierID;
    }

    @Schema(hidden = true)
    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    @Schema(
            required = true,
            example = "1387"
    )
    public Integer getShamsiYear() {
        return shamsiYear;
    }

    public void setShamsiYear(Integer shamsiYear) {
        this.shamsiYear = shamsiYear;
    }

    @Schema(
            required = true,
            example = "1387/01/01"
    )
    public String getStartShamsiDate() {
        return startShamsiDate;
    }

    public void setStartShamsiDate(String startShamsiDate) {
        this.startShamsiDate = startShamsiDate;
    }

    @Schema(
            example = "1387/12/30"
    )
    public String getEndShamsiDate() {
        return endShamsiDate;
    }

    public void setEndShamsiDate(String endShamsiDate) {
        this.endShamsiDate = endShamsiDate;
    }

    @Schema(
            required = true,
            example = "سال مالی 87"
    )
    public String getYearDesc() {
        return yearDesc;
    }

    public void setYearDesc(String yearDesc) {
        this.yearDesc = yearDesc;
    }
}
