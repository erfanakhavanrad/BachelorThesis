package com.tarazgroup.tws.model.acc;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Salman Majidi
 * @since 2.0.0
 */

@NamedStoredProcedureQuery(
        name = "_AccShowBank",
        procedureName = "_AccShowBank",
        resultClasses = {AccBank1.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@Entity
@Table(name = "_AccBank")
public class AccBank1 extends TParams implements Serializable {

    @Id
    @Column(name = "BankID")
    private BigDecimal bankId;

    @Column(name = "ColDecimal1")
    private BigDecimal colDecimal1;

    @Column(name = "ColHidden1")
    private String colHidden1;

    @Column(name = "ColHidden2")
    private BigDecimal colHidden2;

    @Column(name = "ColDecimal2")
    private BigDecimal colDecimal2;

    @Column(name = "ColNVarChar3")
    private String colNVarChar3;

    @Column(name = "ColDecimal4")
    private BigDecimal colDecimal4;

    @Column(name = "ColBit5")
    private Boolean colBit5;

    @Column(name = "ColDecimal6")
    private BigDecimal colDecimal6;

    @Column(name = "ColNVarChar7")
    private String colNVarChar7;

    @Column(name = "ColDecimal8")
    private BigDecimal colDecimal8;

    @Column(name = "ColDateTime9")
    private Date colDateTime9;

    @Column(name = "ColDateTime10")
    private Date colDateTime10;

    @Column(name = "ColDecimal11")
    private BigDecimal colDecimal11;

    @Column(name = "colNVarChar12")
    private String colNVarChar12;

    @Column(name = "ColDecimal13")
    private BigDecimal colDecimal13;

    @Column(name = "ColBit14")
    private Boolean colBit14;

    @Column(name = "ColDecimal15")
    private BigDecimal colDecimal15;

    @Column(name = "ColNVarChar16")
    private String colNVarChar16;

    @Column(name = "ColDecimal17")
    private BigDecimal colDecimal17;

    @Column(name = "ColNVarChar18")
    private String colNVarChar18;

    @Column(name = "ColNVarChar19")
    private String colNVarChar19;

    @Column(name = "ColNVarChar20")
    private String colNVarChar20;

    @Column(name = "ColHidden4")
    private String colHidden4;

    public BigDecimal getBankId() {
        return bankId;
    }

    public void setBankId(BigDecimal bankId) {
        this.bankId = bankId;
    }

    public BigDecimal getColDecimal1() {
        return colDecimal1;
    }

    public void setColDecimal1(BigDecimal colDecimal1) {
        this.colDecimal1 = colDecimal1;
    }

    public String getColHidden1() {
        return colHidden1;
    }

    public void setColHidden1(String colHidden1) {
        this.colHidden1 = colHidden1;
    }

    public BigDecimal getColHidden2() {
        return colHidden2;
    }

    public void setColHidden2(BigDecimal colHidden2) {
        this.colHidden2 = colHidden2;
    }

    public BigDecimal getColDecimal2() {
        return colDecimal2;
    }

    public void setColDecimal2(BigDecimal colDecimal2) {
        this.colDecimal2 = colDecimal2;
    }

    public String getColNVarChar3() {
        return colNVarChar3;
    }

    public void setColNVarChar3(String colNVarChar3) {
        this.colNVarChar3 = colNVarChar3;
    }

    public BigDecimal getColDecimal4() {
        return colDecimal4;
    }

    public void setColDecimal4(BigDecimal colDecimal4) {
        this.colDecimal4 = colDecimal4;
    }

    public Boolean getColBit5() {
        return colBit5;
    }

    public void setColBit5(Boolean colBit5) {
        this.colBit5 = colBit5;
    }

    public BigDecimal getColDecimal6() {
        return colDecimal6;
    }

    public void setColDecimal6(BigDecimal colDecimal6) {
        this.colDecimal6 = colDecimal6;
    }

    public String getColNVarChar7() {
        return colNVarChar7;
    }

    public void setColNVarChar7(String colNVarChar7) {
        this.colNVarChar7 = colNVarChar7;
    }

    public BigDecimal getColDecimal8() {
        return colDecimal8;
    }

    public void setColDecimal8(BigDecimal colDecimal8) {
        this.colDecimal8 = colDecimal8;
    }

    public Date getColDateTime9() {
        return colDateTime9;
    }

    public void setColDateTime9(Date colDateTime9) {
        this.colDateTime9 = colDateTime9;
    }

    public Date getColDateTime10() {
        return colDateTime10;
    }

    public void setColDateTime10(Date colDateTime10) {
        this.colDateTime10 = colDateTime10;
    }

    public BigDecimal getColDecimal11() {
        return colDecimal11;
    }

    public void setColDecimal11(BigDecimal colDecimal11) {
        this.colDecimal11 = colDecimal11;
    }

    public String getColNVarChar12() {
        return colNVarChar12;
    }

    public void setColNVarChar12(String colNVarChar12) {
        this.colNVarChar12 = colNVarChar12;
    }

    public BigDecimal getColDecimal13() {
        return colDecimal13;
    }

    public void setColDecimal13(BigDecimal colDecimal13) {
        this.colDecimal13 = colDecimal13;
    }

    public Boolean getColBit14() {
        return colBit14;
    }

    public void setColBit14(Boolean colBit14) {
        this.colBit14 = colBit14;
    }

    public BigDecimal getColDecimal15() {
        return colDecimal15;
    }

    public void setColDecimal15(BigDecimal colDecimal15) {
        this.colDecimal15 = colDecimal15;
    }

    public String getColNVarChar16() {
        return colNVarChar16;
    }

    public void setColNVarChar16(String colNVarChar16) {
        this.colNVarChar16 = colNVarChar16;
    }

    public BigDecimal getColDecimal17() {
        return colDecimal17;
    }

    public void setColDecimal17(BigDecimal colDecimal17) {
        this.colDecimal17 = colDecimal17;
    }

    public String getColNVarChar18() {
        return colNVarChar18;
    }

    public void setColNVarChar18(String colNVarChar18) {
        this.colNVarChar18 = colNVarChar18;
    }

    public String getColNVarChar19() {
        return colNVarChar19;
    }

    public void setColNVarChar19(String colNVarChar19) {
        this.colNVarChar19 = colNVarChar19;
    }

    public String getColNVarChar20() {
        return colNVarChar20;
    }

    public void setColNVarChar20(String colNVarChar20) {
        this.colNVarChar20 = colNVarChar20;
    }

    public String getColHidden4() {
        return colHidden4;
    }

    public void setColHidden4(String colHidden4) {
        this.colHidden4 = colHidden4;
    }
}
