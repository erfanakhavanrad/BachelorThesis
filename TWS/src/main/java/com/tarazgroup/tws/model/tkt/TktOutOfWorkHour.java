package com.tarazgroup.tws.model.tkt;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;


/**
 * 5/30/22
 *
 * @author Erfan Akhavan
 */

@NamedStoredProcedureQuery(
        name = "TktShowOutOfWorkHour",
        procedureName = "TktShowOutOfWorkHour",
        resultClasses = {TktOutOfWorkHour.class
        }
)


@Entity
public class TktOutOfWorkHour extends TParams implements Serializable {

    @Id
    @Column(name = "TID")
    private BigDecimal tID;

    @Column(name = "TStatus")
    private Boolean tStatus;

    public BigDecimal gettID() {
        return tID;
    }

    public Boolean gettStatus() {
        return tStatus;
    }
}
