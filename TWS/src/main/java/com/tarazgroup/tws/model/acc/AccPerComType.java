package com.tarazgroup.tws.model.acc;


import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import java.io.Serializable;

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
        name = "AccShowPerComType",
        procedureName = "AccShowPerComType",
        resultClasses = {AccPerComType.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@Entity
@Table(name = "AccPerComType")
public class AccPerComType extends TParams implements Serializable {
    @Id
    @Column(name = "PerComTypeID", columnDefinition = "tinyint")
    private Integer perComTypeID;

    @Column(name = "PerComTypeDesc", columnDefinition = "nvarchar")
    private String perComTypeDesc;

    @Schema(accessMode = READ_ONLY)
    public Integer getPerComTypeID() {
        return perComTypeID;
    }

    public void setPerComTypeID(Integer perComTypeID) {
        this.perComTypeID = perComTypeID;
    }

    public String getPerComTypeDesc() {
        return perComTypeDesc;
    }

    public void setPerComTypeDesc(String perComTypeDesc) {
        this.perComTypeDesc = perComTypeDesc;
    }
}
