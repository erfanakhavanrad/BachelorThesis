package com.tarazgroup.tws.model.acc;

import com.tarazgroup.tws.util.global.TParams;

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
        name = "AccGetTafsiliDesc",
        procedureName = "AccGetTafsiliDesc",
        resultClasses = {AccGetTafsiliDesc.class},
        parameters = {
                @StoredProcedureParameter(name = "AccID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TafsiliLevel",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Filter",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TafsiliID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LoginID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TafsiliCode",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Center1Code",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Center2Code",type = String.class,mode =ParameterMode.IN),
                @StoredProcedureParameter(name = "Center3Code",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DCenter1Code",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DCenter2Code",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DCenter3Code",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter",type = String.class,mode = ParameterMode.IN)
        }
)

@Entity
public class AccGetTafsiliDesc extends TParams implements Serializable {

    @Id
    @Column(name = "TafsiliID")
    private BigDecimal tafsiliID;

    @Column(name = "TafsiliCode")
    private String tafsiliCode;

    @Column(name = "TafsiliDesc")
    private String tafsiliDesc;


    public BigDecimal getTafsiliID() {
        return tafsiliID;
    }

    public void setTafsiliID(BigDecimal accTafsiliID) {

        this.tafsiliID = accTafsiliID;
    }

    public String getTafsiliCode() {
        return tafsiliCode;
    }

    public void setTafsiliCode(String accTafsiliCode) {
        this.tafsiliCode = accTafsiliCode;
    }

    public String getTafsiliDesc() {
        return tafsiliDesc;
    }

    public void setTafsiliDesc(String accTafsiliDesc) {
        this.tafsiliDesc = accTafsiliDesc;
    }
}
