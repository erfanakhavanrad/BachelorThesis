package com.tarazgroup.tws.model.crm;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author Salman Majidi
 * @since 2.0.0
 */
@NamedStoredProcedureQuery(
        name = "CrmQKeyExecuteQuery",
        procedureName = "CrmQKeyExecuteQuery",
        parameters = {
                @StoredProcedureParameter(name = "FieldID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)
@Entity
public class CrmQKeyExecuteQuery extends TParams implements Serializable {
    @Id
    @Column(name = "_id", columnDefinition = "BINARY(16)")
    @Parameter(hidden = true)
    private UUID _id = UUID.randomUUID();

    public UUID get_id() {
        return _id;
    }

    public void set_id(UUID _id) {
        this._id = _id;
    }
}
