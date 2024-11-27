package com.tarazgroup.tws.model.acc;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

/**
 * @author Abbas Ashrafi
 * @since v2.0.0
 */

@NamedStoredProcedureQuery(
        name = "AccShowTafsiliKind",
        procedureName = "AccShowTafsiliKind",
        resultClasses = {AccTafsiliKind.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@Entity
@Table(name = "AccTafsiliKind")
public class AccTafsiliKind extends TParams implements Serializable {

    @Id
    @Column(name = "TafsiliKindID")
    @Parameter(hidden = true)
    private BigDecimal tafsiliKindID;

    @Column(name = "TafsiliKindDesc")
    @Parameter
    private String tafsiliKindDesc;

    @Column(name = "RowCnt")
    private Integer rowCnt;

    @Column(name = "PgCnt")
    private Integer pgCnt;

    @Schema(accessMode = READ_ONLY)
    public BigDecimal getTafsiliKindID() {
        return tafsiliKindID;
    }

    public void setTafsiliKindID(BigDecimal tafsiliKindID) {
        this.tafsiliKindID = tafsiliKindID;
    }

    @NotNull(message = "accountCode is mandatory")
    @Schema(
            required = true,
            example = "مشتری"
    )
    public String getTafsiliKindDesc() {
        return tafsiliKindDesc;
    }

    public void setTafsiliKindDesc(String tafsiliKindDesc) {
        this.tafsiliKindDesc = tafsiliKindDesc;
    }

    public Integer getRowCnt() {
        return rowCnt;
    }

    public void setRowCnt(Integer rowCnt) {
        this.rowCnt = rowCnt;
    }

    public Integer getPgCnt() {
        return pgCnt;
    }

    public void setPgCnt(Integer pgCnt) {
        this.pgCnt = pgCnt;
    }
}
