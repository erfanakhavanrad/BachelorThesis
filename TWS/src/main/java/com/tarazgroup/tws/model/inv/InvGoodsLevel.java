package com.tarazgroup.tws.model.inv;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author salman majidi
 * @since v2.0.0
 */

@NamedStoredProcedureQuery(
        name = "InvShowGoodsLevel",
        procedureName = "InvShowGoodsLevel",
        resultClasses = {InvGoodsLevel.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GroupID", type = BigDecimal.class, mode = ParameterMode.IN),
        }
)

@Entity
public class InvGoodsLevel extends TParams implements Serializable {

    @Id
    @Column(name = "LevelID")
    private BigDecimal levelID;

    @Column(name = "LevelCode")
    private String levelCode;

    @Column(name = "LevelDesc")
    private String levelDesc;

    @Column(name = "LevelNumber")
    private BigDecimal levelNumber;

    @Column(name = "XFieldNo")
    private int xFieldNo;

    @Column(name = "FormulaCode")
    private String formulaCode;

    @Column(name = "IsActiveInFormula")
    private Boolean isActiveInFormula;

    @Column(name = "DetailLevelID")
    private BigDecimal detailLevelID;

    @Column(name = "DetailLevelCode")
    private String detailLevelCode;

    @Column(name = "DetailLevelName")
    private String detailLevelName;

    @Column(name = "DetailLevelValue")
    private String detailLevelValue;

    @Column(name = "UnitID")
    private BigDecimal unitID;

    @Column(name = "UnitDesc")
    private String unitDesc;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "ModifyDate")
    private Date modifyDate;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    @Column(name = "GoodsID")
    private BigDecimal goodsID;

    @Column(name = "IsForceInputLevel")
    private Boolean isForceInputLevel;

    @Column(name = "IsActiveInGoodsDesc")
    private Boolean isActiveInGoodsDesc;

    @Column(name = "IsActiveLabelInGoodsDesc")
    private Boolean isActiveLabelInGoodsDesc;

    @Column(name = "IsActiveInGoodsDescDsc")
    private String isActiveInGoodsDescDsc;

    @Column(name = "IsActiveInFormulaDesc")
    private String isActiveInFormulaDesc;

    @Column(name = "IsActiveLabelInGoodsDescDsc")
    private String isActiveLabelInGoodsDescDsc;

    @Column(name = "LevelCodeLen")
    private BigDecimal levelCodeLen;

    @Column(name = "CoEff")
    private BigDecimal coEff;

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

    public BigDecimal getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(BigDecimal levelNumber) {
        this.levelNumber = levelNumber;
    }

    public int getxFieldNo() {
        return xFieldNo;
    }

    public void setxFieldNo(int xFieldNo) {
        this.xFieldNo = xFieldNo;
    }

    public String getFormulaCode() {
        return formulaCode;
    }

    public void setFormulaCode(String formulaCode) {
        this.formulaCode = formulaCode;
    }

    public Boolean getIsActiveInFormula() {
        return isActiveInFormula;
    }

    public void setActiveInFormula(Boolean isActiveInFormula) {
        this.isActiveInFormula = isActiveInFormula;
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

    public String getDetailLevelValue() {
        return detailLevelValue;
    }

    public void setDetailLevelValue(String detailLevelValue) {
        this.detailLevelValue = detailLevelValue;
    }

    public BigDecimal getUnitID() {
        return unitID;
    }

    public void setUnitID(BigDecimal unitID) {
        this.unitID = unitID;
    }

    public String getUnitDesc() {
        return unitDesc;
    }

    public void setUnitDesc(String unitDesc) {
        this.unitDesc = unitDesc;
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

    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }

    public BigDecimal getModifierID() {
        return modifierID;
    }

    public void setModifierID(BigDecimal modifierID) {
        this.modifierID = modifierID;
    }

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    public BigDecimal getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(BigDecimal goodsID) {
        this.goodsID = goodsID;
    }

    public Boolean getIsForceInputLevel() {
        return isForceInputLevel;
    }

    public void setForceInputLevel(Boolean isForceInputLevel) {
        this.isForceInputLevel = isForceInputLevel;
    }

    public Boolean getIsActiveInGoodsDesc() {
        return isActiveInGoodsDesc;
    }

    public void setActiveInGoodsDesc(Boolean isActiveInGoodsDesc) {
        this.isActiveInGoodsDesc = isActiveInGoodsDesc;
    }

    public Boolean getIsActiveLabelInGoodsDesc() {
        return isActiveLabelInGoodsDesc;
    }

    public void setActiveLabelInGoodsDesc(Boolean isActiveLabelInGoodsDesc) {
        this.isActiveLabelInGoodsDesc = isActiveLabelInGoodsDesc;
    }

    public String getIsActiveInGoodsDescDsc() {
        return isActiveInGoodsDescDsc;
    }

    public void setIsActiveInGoodsDescDsc(String isActiveInGoodsDescDsc) {
        this.isActiveInGoodsDescDsc = isActiveInGoodsDescDsc;
    }

    public String getIsActiveInFormulaDesc() {
        return isActiveInFormulaDesc;
    }

    public void setIsActiveInFormulaDesc(String isActiveInFormulaDesc) {
        this.isActiveInFormulaDesc = isActiveInFormulaDesc;
    }

    public String getIsActiveLabelInGoodsDescDsc() {
        return isActiveLabelInGoodsDescDsc;
    }

    public void setIsActiveLabelInGoodsDescDsc(String isActiveLabelInGoodsDescDsc) {
        this.isActiveLabelInGoodsDescDsc = isActiveLabelInGoodsDescDsc;
    }

    public BigDecimal getLevelCodeLen() {
        return levelCodeLen;
    }

    public void setLevelCodeLen(BigDecimal levelCodeLen) {
        this.levelCodeLen = levelCodeLen;
    }

    public BigDecimal getCoEff() {
        return coEff;
    }

    public void setCoEff(BigDecimal coEff) {
        this.coEff = coEff;
    }
}
