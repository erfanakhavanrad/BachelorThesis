package com.tarazgroup.tws.model.inv;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

/**
 *
 * @author Abbas Ashrafi
 * @since v2.0.0
 */

@Entity
@Table(name = "InvDifferentialGoods")
public class InvDifferentialGoods implements Serializable {

    @Id
    @Column(name = "DifferentialID")
    private BigDecimal differentialID;

    @Column(name = "GoodsID")
    private BigDecimal goodsID;

    @Column(name = "DifferentialCode")
    private String differentialCode;

    @Column(name = "DifferentialDesc")
    private String differentialDesc;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "ModifyDate")
    private Date modifyDate;

    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    @Schema(accessMode = READ_ONLY)
    public BigDecimal getDifferentialID() {
        return differentialID;
    }

    public void setDifferentialID(BigDecimal differentialID) {
        differentialID = differentialID;
    }

    public BigDecimal getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(BigDecimal goodsID) {
        this.goodsID = goodsID;
    }

    @NotBlank(message = "differentialCode is mandatory")
    @Schema(
            required = true,
            example = "1"
    )
    public String getDifferentialCode() {
        return differentialCode;
    }

    public void setDifferentialCode(String differentialCode) {
        differentialCode = differentialCode;
    }

    @NotBlank(message = "differentialDesc is mandatory")
    @Schema(
            required = true,
            example = "نشاسته"
    )
    public String getDifferentialDesc() {
        return differentialDesc;
    }

    public void setDifferentialDesc(String differentialDesc) {
        differentialDesc = differentialDesc;
    }

    @Schema(hidden = true)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        createDate = createDate;
    }

    @Schema(hidden = true)
    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        creatorID = creatorID;
    }

    @Schema(hidden = true)
    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        modifyDate = modifyDate;
    }

    @Schema(hidden = true)
    public BigDecimal getModifierID() {
        return modifierID;
    }

    public void setModifierID(BigDecimal modifierID) {
        modifierID = modifierID;
    }

    @Schema(hidden = true)
    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        serverID = serverID;
    }
}
