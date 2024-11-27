package com.tarazgroup.tws.model.inv;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */

@NamedStoredProcedureQuery(
        name = "InvShowDetailLevel",
        procedureName = "InvShowDetailLevel",
        resultClasses = {InvDetailLevel.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)
@NamedStoredProcedureQuery(
        name = "InvDelDetailLevel",
        procedureName = "InvDelDetailLevel",
        resultClasses = {InvDetailLevel.class},
        parameters = {
                @StoredProcedureParameter(name = "DetailLevelID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)
@NamedStoredProcedureQuery(
        name = "InvInsDetailLevel",
        procedureName = "InvInsDetailLevel",
        resultClasses = {InvDetailLevel.class},
        parameters = {
                @StoredProcedureParameter(name = "DetailLevelCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DetailLevelName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DetailLevelLatinName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LevelID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)
@NamedStoredProcedureQuery(
        name = "InvUpdDetailLevel",
        procedureName = "InvUpdDetailLevel",
        resultClasses = {InvDetailLevel.class},
        parameters = {
                @StoredProcedureParameter(name = "DetailLevelID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DetailLevelCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DetailLevelName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LevelID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "DetailLevelLatinName", type = String.class, mode = ParameterMode.IN)
        }
)

@Entity
@Table(name = "InvDetailLevel")
public class InvDetailLevel extends TParams implements Serializable {

    @Id
    @Column(name = "DetailLevelID", columnDefinition = "decimal")
    private BigDecimal detailLevelID;

    @Column(name = "DetailLevelCode", columnDefinition = "nvarchar")
    private String detailLevelCode;

    @Column(name = "DetailLevelName", columnDefinition = "nvarchar")
    private String detailLevelName;

    @Column(name = "DetailLevelLatinName", columnDefinition = "nvarchar")
    private String detailLevelLatinName;

    @Column(name = "ModifyDate", columnDefinition = "datetime")
    @Parameter(hidden = true)
    private Date modifyDate;

    @Column(name = "ServerID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal serverID;

    @Column(name = "CreateDate", columnDefinition = "datetime")
    @Parameter(hidden = true)
    private Date createDate;

    @Column(name = "ModifierID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal modifierID;

    @Column(name = "CreatorID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal creatorID;

    @Column(name = "LevelID", columnDefinition = "decimal")
    private BigDecimal levelID;

    @Column(name = "LevelCode")
    private String levelCode;

    @Column(name = "LevelDesc")
    private String levelDesc;

    @Column(name = "LevelLatinDesc")
    private String levelLatinDesc;

    public BigDecimal getDetailLevelID() {
        return detailLevelID;
    }

    public void setDetailLevelID(BigDecimal detailLevelID) {
        this.detailLevelID = detailLevelID;
    }

    public String getDetailLevelCode() {
        return detailLevelCode;
    }

    public void setDetailLevelCode(String detailLevelCode) {
        this.detailLevelCode = detailLevelCode;
    }

    public String getDetailLevelName() {
        return detailLevelName;
    }

    public void setDetailLevelName(String detailLevelName) {
        this.detailLevelName = detailLevelName;
    }

    public String getDetailLevelLatinName() {
        return detailLevelLatinName;
    }

    public void setDetailLevelLatinName(String detailLevelLatinName) {
        this.detailLevelLatinName = detailLevelLatinName;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
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

    public BigDecimal getModifierID() {
        return modifierID;
    }

    public void setModifierID(BigDecimal modifierID) {
        this.modifierID = modifierID;
    }

    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }

    public BigDecimal getLevelID() {
        return levelID;
    }

    public void setLevelID(BigDecimal levelID) {
        this.levelID = levelID;
    }

    public String getLevelCode() {
        return levelCode;
    }

    public void setLevelCode(String levelCode) {
        this.levelCode = levelCode;
    }

    public String getLevelDesc() {
        return levelDesc;
    }

    public void setLevelDesc(String levelDesc) {
        this.levelDesc = levelDesc;
    }

    public String getLevelLatinDesc() {
        return levelLatinDesc;
    }

    public void setLevelLatinDesc(String levelLatinDesc) {
        this.levelLatinDesc = levelLatinDesc;
    }

}

