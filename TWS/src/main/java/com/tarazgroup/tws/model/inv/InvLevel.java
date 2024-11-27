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
        name = "InvShowLevel",
        procedureName = "InvShowLevel",
        resultClasses = {InvLevel.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GroupID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN),
        }
)

@NamedStoredProcedureQuery(
        name = "InvInsLevel",
        procedureName = "InvInsLevel",
        resultClasses = {InvLevel.class},
        parameters = {
                @StoredProcedureParameter(name = "LevelCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LevelDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LevelLatinDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LevelNumber", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "IsForceInputLevel", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LevelCodeLen", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CoEff", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsActiveInGoodsDesc", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsActiveInFormula", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UnitID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DefaultValue", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "XFieldNo", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsActiveLabelInGoodsDesc", type = Boolean.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "InvDelLevel",
        procedureName = "InvDelLevel",
        resultClasses = {InvLevel.class},
        parameters = {
                @StoredProcedureParameter(name = "LevelID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "InvUpdLevel",
        procedureName = "InvUpdLevel",
        resultClasses = {InvLevel.class},
        parameters = {
                @StoredProcedureParameter(name = "LevelID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LevelCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LevelDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LevelNumber", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "IsForceInputLevel", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LevelCodeLen", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LevelLatinDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CoEff", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsActiveInGoodsDesc", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsActiveInFormula", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UnitID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DefaultValue", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "XFieldNo", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsActiveLabelInGoodsDesc", type = Boolean.class, mode = ParameterMode.IN)
        }
)

@Entity
public class InvLevel extends TParams implements Serializable {

    @Id
    @Column(name = "LevelID", columnDefinition = "decimal")
    private BigDecimal levelID;

    @Column(name = "LevelCode", columnDefinition = "nvarchar")
    @Parameter
    private String levelCode;

    @Column(name = "FormulaCode", columnDefinition = "nvarchar")
    @Parameter
    private String formulaCode;

    @Column(name = "LevelDesc", columnDefinition = "nvarchar")
    @Parameter
    private String levelDesc;

    @Column(name = "LevelLatinDesc", columnDefinition = "nvarchar")
    @Parameter
    private String levelLatinDesc;

    @Column(name = "LevelNumber", columnDefinition = "decimal")
    @Parameter
    private BigDecimal levelNumber;

    @Column(name = "ServerID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal serverID;

    @Column(name = "CreateDate", columnDefinition = "datetime")
    @Parameter(hidden = true)
    private Date createDate;

    @Column(name = "ModifyDate", columnDefinition = "datetime")
    @Parameter(hidden = true)
    private Date modifyDate;

    @Column(name = "ModifierID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal modifierID;

    @Column(name = "CreatorID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal creatorID;

    @Column(name = "IsForceInputLevel", columnDefinition = "bit")
    @Parameter
    private Boolean isForceInputLevel;

    @Column(name = "LevelCodeLen", columnDefinition = "decimal")
    @Parameter
    private BigDecimal levelCodeLen;

    @Column(name = "DetailLevelID")
    @Parameter
    private BigDecimal detailLevelID;

    @Column(name = "DetailLevelCode")
    @Parameter
    private String detailLevelCode;

    @Column(name = "DetailLevelName")
    @Parameter
    private String detailLevelName;

    @Column(name = "CoEff", columnDefinition = "decimal")
    @Parameter
    private BigDecimal coEff;

    @Column(name = "IsActiveInGoodsDesc", columnDefinition = "bit")
    @Parameter
    private Boolean isActiveInGoodsDesc;

    @Column(name = "IsActiveInFormula", columnDefinition = "bit")
    @Parameter
    private Boolean isActiveInFormula;

    @Column(name = "UnitID", columnDefinition = "decimal")
    @Parameter
    private BigDecimal unitID;

    @Column(name = "DefaultValue", columnDefinition = "decimal")
    @Parameter
    private BigDecimal defaultValue;

    @Column(name = "UnitDesc")
    @Parameter
    private String unitDesc;

    @Column(name = "IsActiveLabelInGoodsDesc", columnDefinition = "bit")
    @Parameter
    private Boolean isActiveLabelInGoodsDesc;

    @Column(name = "IsActiveLabelInGoodsDescDsc")
    @Parameter
    private String isActiveLabelInGoodsDescDsc;

    @Column(name = "XFieldNo", columnDefinition = "tinyint")
    @Parameter
    private Integer xFieldNo;

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

    public String getFormulaCode() {
        return formulaCode;
    }

    public void setFormulaCode(String formulaCode) {
        this.formulaCode = formulaCode;
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

    public BigDecimal getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(BigDecimal levelNumber) {
        this.levelNumber = levelNumber;
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

    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }

    public Boolean getIsForceInputLevel() {
        return isForceInputLevel;
    }

    public void setIsForceInputLevel(Boolean forceInputLevel) {
        isForceInputLevel = forceInputLevel;
    }

    public BigDecimal getLevelCodeLen() {
        return levelCodeLen;
    }

    public void setLevelCodeLen(BigDecimal levelCodeLen) {
        this.levelCodeLen = levelCodeLen;
    }

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

    public BigDecimal getCoEff() {
        return coEff;
    }

    public void setCoEff(BigDecimal coEff) {
        this.coEff = coEff;
    }

    public Boolean getIsActiveInGoodsDesc() {
        return isActiveInGoodsDesc;
    }

    public void setIsActiveInGoodsDesc(Boolean activeInGoodsDesc) {
        isActiveInGoodsDesc = activeInGoodsDesc;
    }

    public Boolean getIsActiveInFormula() {
        return isActiveInFormula;
    }

    public void setIsActiveInFormula(Boolean activeInFormula) {
        isActiveInFormula = activeInFormula;
    }

    public BigDecimal getUnitID() {
        return unitID;
    }

    public void setUnitID(BigDecimal unitID) {
        this.unitID = unitID;
    }

    public BigDecimal getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(BigDecimal defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getUnitDesc() {
        return unitDesc;
    }

    public void setUnitDesc(String unitDesc) {
        this.unitDesc = unitDesc;
    }

    public Boolean getIsActiveLabelInGoodsDesc() {
        return isActiveLabelInGoodsDesc;
    }

    public void setIsActiveLabelInGoodsDesc(Boolean activeLabelInGoodsDesc) {
        isActiveLabelInGoodsDesc = activeLabelInGoodsDesc;
    }

    public String getIsActiveLabelInGoodsDescDsc() {
        return isActiveLabelInGoodsDescDsc;
    }

    public void setIsActiveLabelInGoodsDescDsc(String isActiveLabelInGoodsDescDsc) {
        this.isActiveLabelInGoodsDescDsc = isActiveLabelInGoodsDescDsc;
    }

    public Integer getxFieldNo() {
        return xFieldNo;
    }

    public void setxFieldNo(Integer xFieldNo) {
        this.xFieldNo = xFieldNo;
    }
}

