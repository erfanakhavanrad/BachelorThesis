package com.tarazgroup.tws.model.crm;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Salman Majidi
 * @since 2.0.0
 */

@Entity
public class CrmDashboard extends TParams implements Serializable {
    // این مدل تستی است و فقط برای این که ریپو و کنترلر را بسازیم ساختهشده است
    @Id
    @Column(name = "ID")
    private BigDecimal id;

    @Column(name = "Desc")
    @Parameter
    private String desc;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
