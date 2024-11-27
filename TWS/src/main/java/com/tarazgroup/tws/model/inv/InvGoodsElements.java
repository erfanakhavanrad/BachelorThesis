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
        name = "InvShowGoodsElements",
        procedureName = "InvShowGoodsElements",
        resultClasses = {InvGoodsElements.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter",type = String.class,mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "InvInsGoodsElements",
        procedureName = "InvInsGoodsElements",
        resultClasses = {InvGoodsElements.class},
        parameters = {
                @StoredProcedureParameter(name = "ElementsCode",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ElementName",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result",type = BigDecimal.class,mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg",type = String.class,mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID",type = BigDecimal.class,mode = ParameterMode.OUT)
        }
)
@NamedStoredProcedureQuery(
        name = "InvDelGoodsElements",
        procedureName = "InvDelGoodsElements",
        resultClasses = {InvGoodsElements.class},
        parameters = {
                @StoredProcedureParameter(name = "GElementsID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result",type = BigDecimal.class,mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg",type = String.class,mode = ParameterMode.OUT)
        }
)
@NamedStoredProcedureQuery(
        name = "InvUpdGoodsElements",
        procedureName = "InvUpdGoodsElements",
        resultClasses = {InvGoodsElements.class},
        parameters = {
                @StoredProcedureParameter(name = "GElementsID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ElementsCode",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ElementName",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result",type = BigDecimal.class,mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg",type = String.class,mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ElementType",type = Integer.class,mode = ParameterMode.IN)
        }
)
@Entity
public class InvGoodsElements extends TParams implements Serializable {

    @Id
    @Column(name = "GElementsID")
    private BigDecimal gElementsID;

    @Column(name = "ElementsCode")
    private String elementsCode;

    @Column(name = "ElementName")
    private String elementName;

    @Column(name = "CreateDate")
    @Parameter(hidden = true)
    private Date createDate;

    @Column(name = "ModifyDate")
    @Parameter(hidden = true)
    private Date modifyDate;

    @Column(name = "ModifierID")
    @Parameter(hidden = true)
    private BigDecimal modifierID;

    @Column(name = "CreatorID")
    @Parameter(hidden = true)
    private BigDecimal creatorID;

    @Column(name = "ElementType")
    private Integer elementType;

    @Column(name = "ElementTypeDesc")
    private String elementTypeDesc;

    @Column(name = "ServerID")
    @Parameter(hidden = true)
    private BigDecimal serverID;

    @Column(name = "GoodsID")
    private BigDecimal goodsID;

    @Column(name = "GElementsValues")
    private String gElementsValues;

    @Column(name = "UnitID")
    private BigDecimal unitID;

    @Column(name = "UnitDesc")
    private String unitDesc;


    public BigDecimal getgElementsID() {
        return gElementsID;
    }

    public void setgElementsID(BigDecimal gElementsID) {
        this.gElementsID = gElementsID;
    }

    public String getElementsCode() {
        return elementsCode;
    }

    public void setElementsCode(String elementsCode) {
        this.elementsCode = elementsCode;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
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

    public Integer getElementType() {
        return elementType;
    }

    public void setElementType(Integer elementType) {
        this.elementType = elementType;
    }

    public String getElementTypeDesc() {
        return elementTypeDesc;
    }

    public void setElementTypeDesc(String elementTypeDesc) {
        this.elementTypeDesc = elementTypeDesc;
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

    public String getgElementsValues() {
        return gElementsValues;
    }

    public void setgElementsValues(String gElementsValues) {
        this.gElementsValues = gElementsValues;
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
}
