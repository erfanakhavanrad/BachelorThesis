package com.tarazgroup.tws.model.crm;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/***
 * @author A.Farahani
 * @date Feb-12, 2023
 ***/
@NamedStoredProcedureQuery(
        name = "CrmShowActivityIdentity",
        procedureName = "CrmShowActivityIdentity",
        resultClasses = {CrmActivityIdentity.class},
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
public class CrmActivityIdentity extends TParams implements Serializable {
    @Id
    @Column(name = "IdentityID")
    private BigDecimal identityID;

    @Column(name = "IdentityDesc")
    private String identityDesc;

    @Column(name = "IdentityLatinDesc")
    private String identityLatinDesc;

    public BigDecimal getIdentityID() {
        return identityID;
    }

    public void setIdentityID(BigDecimal identityID) {
        this.identityID = identityID;
    }

    public String getIdentityDesc() {
        return identityDesc;
    }

    public void setIdentityDesc(String identityDesc) {
        this.identityDesc = identityDesc;
    }

    public String getIdentityLatinDesc() {
        return identityLatinDesc;
    }

    public void setIdentityLatinDesc(String identityLatinDesc) {
        this.identityLatinDesc = identityLatinDesc;
    }
}
