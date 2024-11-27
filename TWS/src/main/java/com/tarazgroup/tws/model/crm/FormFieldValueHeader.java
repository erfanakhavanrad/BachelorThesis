package com.tarazgroup.tws.model.crm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * 9/26/22
 *
 * @author Erfan Akhavan
 */
@Entity
public class FormFieldValueHeader {
    @Id
    @Column(name = "RecordID", columnDefinition = "decimal")
    private BigDecimal recordID;

    public BigDecimal getRecordID() {
        return recordID;
    }

    public void setRecordID(BigDecimal recordID) {
        this.recordID = recordID;
    }
}
