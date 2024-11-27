package com.tarazgroup.tws.model.pub;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

/**
 * @author Salman Majidi
 * @since 2.0.0
 */

@Entity
@Table(name = "PubLookUpIdentity")
public class PubLookUpIdentity {

    @Id
    @Column(name = "LookUpIdentity", columnDefinition = "decimal")
    private BigDecimal lookUpIdentity;

    @Column(name = "LookUpIdentityDesc", columnDefinition = "nvarchar")
    private String lookUpIdentityDesc;

    @Schema(accessMode = READ_ONLY)
    public BigDecimal getLookUpIdentity() {
        return lookUpIdentity;
    }

    public void setLookUpIdentity(BigDecimal lookUpIdentity) {
        this.lookUpIdentity = lookUpIdentity;
    }

    @Schema(
            required = true,
            example = "lookUpIdentityDesc1"
    )
    public String getLookUpIdentityDesc() {
        return lookUpIdentityDesc;
    }

    public void setLookUpIdentityDesc(String lookUpIdentityDesc) {
        this.lookUpIdentityDesc = lookUpIdentityDesc;
    }
}
