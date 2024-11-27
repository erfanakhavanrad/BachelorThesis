package com.tarazgroup.tws.model.inv;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author Abbas Ashrafi
 * @since v2.0.0
 */

@SuppressWarnings("JpaDataSourceORMInspection")
@NamedStoredProcedureQuery(
        name = "InvShowSerialsFields",
        procedureName = "InvShowSerialsFields",
        resultClasses = {InvSerialsFields.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "InvUpdSerialsFields",
        procedureName = "InvUpdSerialsFields",
        resultClasses = {InvSerialsFields.class},
        parameters = {
                @StoredProcedureParameter(name = "Field1", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Field2", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Field3", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Field4", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Field5", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Field6", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Field7", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Field8", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Field9", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Field10", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Field1Type", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Field2Type", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Field3Type", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Field4Type", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Field5Type", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Field6Type", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Field7Type", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Field8Type", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Field9Type", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Field10Type", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "QuantityField", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Formula1", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Formula2", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Formula3", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Formula4", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Formula5", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Formula6", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Formula7", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Formula8", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Formula9", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Formula10", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SerialType", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "XF1", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "XF2", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "XF3", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "XF4", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "XF5", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "XF6", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "XF7", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "XF8", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "XF9", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "XF10", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "MaxAllowedQuantity", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "MaxRemainQuantity", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsAutoSerialNo", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RemainSecondFieldNo", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AgrType1", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AgrType2", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AgrType3", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AgrType4", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AgrType5", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AgrType6", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AgrType7", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AgrType8", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AgrType9", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AgrType10", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
@Table(name = "InvSerialsFields")
public class InvSerialsFields implements Serializable {

    @Id
    @Column(name = "_id", columnDefinition = "BINARY(16)")
    private UUID _id = UUID.randomUUID();

    @Column(name = "Field1")
    private String field1;

    @Column(name = "Field2")
    private String field2;

    @Column(name = "Field3")
    private String field3;

    @Column(name = "Field4")
    private String field4;

    @Column(name = "Field5")
    private String field5;

    @Column(name = "Field6")
    private String field6;

    @Column(name = "Field7")
    private String field7;

    @Column(name = "Field8")
    private String field8;

    @Column(name = "Field9")
    private String field9;

    @Column(name = "Field10")
    private String field10;

    @Column(name = "Field1Type")
    private Integer field1Type;

    @Column(name = "Field2Type")
    private Integer field2Type;

    @Column(name = "Field3Type")
    private Integer field3Type;

    @Column(name = "Field4Type")
    private Integer field4Type;

    @Column(name = "Field5Type")
    private Integer field5Type;

    @Column(name = "Field6Type")
    private Integer field6Type;

    @Column(name = "Field7Type")
    private Integer field7Type;

    @Column(name = "Field8Type")
    private Integer field8Type;

    @Column(name = "Field9Type")
    private Integer field9Type;

    @Column(name = "Field10Type")
    private Integer field10Type;

    @Column(name = "QuantityField")
    private Integer quantityField;

    @Column(name = "Formula1")
    private String formula1;

    @Column(name = "Formula2")
    private String formula2;

    @Column(name = "Formula3")
    private String formula3;

    @Column(name = "Formula4")
    private String formula4;

    @Column(name = "Formula5")
    private String formula5;

    @Column(name = "Formula6")
    private String formula6;

    @Column(name = "Formula7")
    private String formula7;

    @Column(name = "Formula8")
    private String formula8;

    @Column(name = "Formula9")
    private String formula9;

    @Column(name = "Formula10")
    private String formula10;

    @Column(name = "SerialType")
    private Integer serialType;

    @Column(name = "XF1")
    private Integer xF1;

    @Column(name = "XF2")
    private Integer xF2;

    @Column(name = "XF3")
    private Integer xF3;

    @Column(name = "XF4")
    private Integer xF4;

    @Column(name = "XF5")
    private Integer xF5;

    @Column(name = "XF6")
    private Integer xF6;

    @Column(name = "XF7")
    private Integer xF7;

    @Column(name = "XF8")
    private Integer xF8;

    @Column(name = "XF9")
    private Integer xF9;

    @Column(name = "XF10")
    private Integer xF10;

    @Column(name = "MaxAllowedQuantity")
    private Integer maxAllowedQuantity;

    @Column(name = "MaxRemainQuantity")
    private Integer maxRemainQuantity;

    @Column(name = "IsAutoSerialNo")
    private Integer isAutoSerialNo;

    @Column(name = "RemainSecondFieldNo")
    private Integer remainSecondFieldNo;

    @Column(name = "AgrType1")
    private Integer agrType1;

    @Column(name = "AgrType2")
    private Integer agrType2;

    @Column(name = "AgrType3")
    private Integer agrType3;

    @Column(name = "AgrType4")
    private Integer agrType4;

    @Column(name = "AgrType5")
    private Integer agrType5;

    @Column(name = "AgrType6")
    private Integer agrType6;

    @Column(name = "AgrType7")
    private Integer agrType7;

    @Column(name = "AgrType8")
    private Integer agrType8;

    @Column(name = "AgrType9")
    private Integer agrType9;

    @Column(name = "AgrType10")
    private Integer agrType10;

    public UUID get_id() {
        return _id;
    }

    public void set_id(UUID _id) {
        this._id = _id;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    public String getField4() {
        return field4;
    }

    public void setField4(String field4) {
        this.field4 = field4;
    }

    public String getField5() {
        return field5;
    }

    public void setField5(String field5) {
        this.field5 = field5;
    }

    public String getField6() {
        return field6;
    }

    public void setField6(String field6) {
        this.field6 = field6;
    }

    public String getField7() {
        return field7;
    }

    public void setField7(String field7) {
        this.field7 = field7;
    }

    public String getField8() {
        return field8;
    }

    public void setField8(String field8) {
        this.field8 = field8;
    }

    public String getField9() {
        return field9;
    }

    public void setField9(String field9) {
        this.field9 = field9;
    }

    public String getField10() {
        return field10;
    }

    public void setField10(String field10) {
        this.field10 = field10;
    }

    public Integer getField1Type() {
        return field1Type;
    }

    public void setField1Type(Integer field1Type) {
        this.field1Type = field1Type;
    }

    public Integer getField2Type() {
        return field2Type;
    }

    public void setField2Type(Integer field2Type) {
        this.field2Type = field2Type;
    }

    public Integer getField3Type() {
        return field3Type;
    }

    public void setField3Type(Integer field3Type) {
        this.field3Type = field3Type;
    }

    public Integer getField4Type() {
        return field4Type;
    }

    public void setField4Type(Integer field4Type) {
        this.field4Type = field4Type;
    }

    public Integer getField5Type() {
        return field5Type;
    }

    public void setField5Type(Integer field5Type) {
        this.field5Type = field5Type;
    }

    public Integer getField6Type() {
        return field6Type;
    }

    public void setField6Type(Integer field6Type) {
        this.field6Type = field6Type;
    }

    public Integer getField7Type() {
        return field7Type;
    }

    public void setField7Type(Integer field7Type) {
        this.field7Type = field7Type;
    }

    public Integer getField8Type() {
        return field8Type;
    }

    public void setField8Type(Integer field8Type) {
        this.field8Type = field8Type;
    }

    public Integer getField9Type() {
        return field9Type;
    }

    public void setField9Type(Integer field9Type) {
        this.field9Type = field9Type;
    }

    public Integer getField10Type() {
        return field10Type;
    }

    public void setField10Type(Integer field10Type) {
        this.field10Type = field10Type;
    }

    public Integer getQuantityField() {
        return quantityField;
    }

    public void setQuantityField(Integer quantityField) {
        this.quantityField = quantityField;
    }

    public String getFormula1() {
        return formula1;
    }

    public void setFormula1(String formula1) {
        this.formula1 = formula1;
    }

    public String getFormula2() {
        return formula2;
    }

    public void setFormula2(String formula2) {
        this.formula2 = formula2;
    }

    public String getFormula3() {
        return formula3;
    }

    public void setFormula3(String formula3) {
        this.formula3 = formula3;
    }

    public String getFormula4() {
        return formula4;
    }

    public void setFormula4(String formula4) {
        this.formula4 = formula4;
    }

    public String getFormula5() {
        return formula5;
    }

    public void setFormula5(String formula5) {
        this.formula5 = formula5;
    }

    public String getFormula6() {
        return formula6;
    }

    public void setFormula6(String formula6) {
        this.formula6 = formula6;
    }

    public String getFormula7() {
        return formula7;
    }

    public void setFormula7(String formula7) {
        this.formula7 = formula7;
    }

    public String getFormula8() {
        return formula8;
    }

    public void setFormula8(String formula8) {
        this.formula8 = formula8;
    }

    public String getFormula9() {
        return formula9;
    }

    public void setFormula9(String formula9) {
        this.formula9 = formula9;
    }

    public String getFormula10() {
        return formula10;
    }

    public void setFormula10(String formula10) {
        this.formula10 = formula10;
    }

    public Integer getSerialType() {
        return serialType;
    }

    public void setSerialType(Integer serialType) {
        this.serialType = serialType;
    }

    public Integer getxF1() {
        return xF1;
    }

    public void setxF1(Integer xF1) {
        this.xF1 = xF1;
    }

    public Integer getxF2() {
        return xF2;
    }

    public void setxF2(Integer xF2) {
        this.xF2 = xF2;
    }

    public Integer getxF3() {
        return xF3;
    }

    public void setxF3(Integer xF3) {
        this.xF3 = xF3;
    }

    public Integer getxF4() {
        return xF4;
    }

    public void setxF4(Integer xF4) {
        this.xF4 = xF4;
    }

    public Integer getxF5() {
        return xF5;
    }

    public void setxF5(Integer xF5) {
        this.xF5 = xF5;
    }

    public Integer getxF6() {
        return xF6;
    }

    public void setxF6(Integer xF6) {
        this.xF6 = xF6;
    }

    public Integer getxF7() {
        return xF7;
    }

    public void setxF7(Integer xF7) {
        this.xF7 = xF7;
    }

    public Integer getxF8() {
        return xF8;
    }

    public void setxF8(Integer xF8) {
        this.xF8 = xF8;
    }

    public Integer getxF9() {
        return xF9;
    }

    public void setxF9(Integer xF9) {
        this.xF9 = xF9;
    }

    public Integer getxF10() {
        return xF10;
    }

    public void setxF10(Integer xF10) {
        this.xF10 = xF10;
    }

    public Integer getMaxAllowedQuantity() {
        return maxAllowedQuantity;
    }

    public void setMaxAllowedQuantity(Integer maxAllowedQuantity) {
        this.maxAllowedQuantity = maxAllowedQuantity;
    }

    public Integer getMaxRemainQuantity() {
        return maxRemainQuantity;
    }

    public void setMaxRemainQuantity(Integer maxRemainQuantity) {
        this.maxRemainQuantity = maxRemainQuantity;
    }

    public Integer getIsAutoSerialNo() {
        return isAutoSerialNo;
    }

    public void setIsAutoSerialNo(Integer isAutoSerialNo) {
        this.isAutoSerialNo = isAutoSerialNo;
    }

    public Integer getRemainSecondFieldNo() {
        return remainSecondFieldNo;
    }

    public void setRemainSecondFieldNo(Integer remainSecondFieldNo) {
        this.remainSecondFieldNo = remainSecondFieldNo;
    }

    public Integer getAgrType1() {
        return agrType1;
    }

    public void setAgrType1(Integer agrType1) {
        this.agrType1 = agrType1;
    }

    public Integer getAgrType2() {
        return agrType2;
    }

    public void setAgrType2(Integer agrType2) {
        this.agrType2 = agrType2;
    }

    public Integer getAgrType3() {
        return agrType3;
    }

    public void setAgrType3(Integer agrType3) {
        this.agrType3 = agrType3;
    }

    public Integer getAgrType4() {
        return agrType4;
    }

    public void setAgrType4(Integer agrType4) {
        this.agrType4 = agrType4;
    }

    public Integer getAgrType5() {
        return agrType5;
    }

    public void setAgrType5(Integer agrType5) {
        this.agrType5 = agrType5;
    }

    public Integer getAgrType6() {
        return agrType6;
    }

    public void setAgrType6(Integer agrType6) {
        this.agrType6 = agrType6;
    }

    public Integer getAgrType7() {
        return agrType7;
    }

    public void setAgrType7(Integer agrType7) {
        this.agrType7 = agrType7;
    }

    public Integer getAgrType8() {
        return agrType8;
    }

    public void setAgrType8(Integer agrType8) {
        this.agrType8 = agrType8;
    }

    public Integer getAgrType9() {
        return agrType9;
    }

    public void setAgrType9(Integer agrType9) {
        this.agrType9 = agrType9;
    }

    public Integer getAgrType10() {
        return agrType10;
    }

    public void setAgrType10(Integer agrType10) {
        this.agrType10 = agrType10;
    }
}
