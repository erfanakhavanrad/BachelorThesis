package com.tarazgroup.tws.model.inv;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
@NamedStoredProcedureQuery(
        name = "InvShowGoodsElementsValues",
        procedureName = "InvShowGoodsElementsValues",
        resultClasses = {InvGoodsElementsValues.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@Entity
public class InvGoodsElementsValues extends TParams implements Serializable {

    @Parameter(hidden = true)
    @Id
    @Column(name = "RowNumber")
    private BigDecimal rowNumber;

    @Column(name = "GElementsID", columnDefinition = "decimal")
    private BigDecimal gElementsID;

    @Column(name = "GElementsValues", columnDefinition = "nvarchar")
    private String gElementsValues;

    @Column(name = "GoodsID", columnDefinition = "decimal")
    private BigDecimal goodsID;

    @Column(name = "UnitID", columnDefinition = "decimal")
    private BigDecimal unitID;

    @Column(name = "UnitDesc")
    private String unitDesc;

    @Column(name = "ElementName")
    private String elementName;

    @Column(name = "ElementSCode")
    private String elementSCode;


    public BigDecimal getgElementsID() {
        return gElementsID;
    }

    public void setgElementsID(BigDecimal gElementsID) {
        this.gElementsID = gElementsID;
    }

    public String getgElementsValues() {
        return gElementsValues;
    }

    public void setgElementsValues(String gElementsValues) {
        this.gElementsValues = gElementsValues;
    }

    public BigDecimal getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(BigDecimal goodsID) {
        this.goodsID = goodsID;
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

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getElementSCode() {
        return elementSCode;
    }

    public void setElementSCode(String elementSCode) {
        this.elementSCode = elementSCode;
    }
}
