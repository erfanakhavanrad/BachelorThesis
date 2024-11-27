package com.tarazgroup.tws.model.inv;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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
        name = "InvShowGoodsPosition",
        procedureName = "InvShowGoodsPosition",
        resultClasses = {InvGoodsPosition.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)
@NamedStoredProcedureQuery(
        name = "InvInsGoodsPosition",
        procedureName = "InvInsGoodsPosition",
        resultClasses = {InvGoodsPosition.class},
        parameters = {
                @StoredProcedureParameter(name = "GoodspositionCode",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GoodsPositionDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GoodsPositionFatherID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)
@NamedStoredProcedureQuery(
        name = "InvDelGoodsPosition",
        procedureName = "InvDelGoodsPosition",
        resultClasses = {InvGoodsPosition.class},
        parameters = {
                @StoredProcedureParameter(name = "GoodsPositionID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)
@NamedStoredProcedureQuery(
        name = "InvUpdGoodsPosition",
        procedureName = "InvUpdGoodsPosition",
        resultClasses = {InvGoodsPosition.class},
        parameters = {
                @StoredProcedureParameter(name = "GoodsPositionID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GoodspositionCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GoodsPositionDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GoodsPositionFatherID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result",type = BigDecimal.class,mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg",type = String.class,mode = ParameterMode.OUT)
        }
)

@Entity
public class InvGoodsPosition extends TParams implements Serializable {

    @Id
    @Column(name = "GoodsPositionID")
    private BigDecimal goodsPositionID;

    @Column(name = "GoodsPositionCode")
    @Parameter
    private String goodspositionCode;

    @Column(name = "GoodsPositionDesc")
    @Parameter
    private String goodsPositionDesc;

    @Column(name = "GoodsPositionFatherID")
//    @NotNull(message = "goodsPositionFatherID is mandatory")
    @Parameter
    private BigDecimal goodsPositionFatherID;

    @Column(name = "ServerID")
    @Parameter(hidden = true)
    private BigDecimal serverID;

    @Column(name = "CreateDate")
    @Parameter(hidden = true)
    private Date createDate;

    @Column(name = "CreatorID")
    @Parameter(hidden = true)
    private BigDecimal creatorID;

    @Column(name = "ModifyDate")
    @Parameter(hidden = true)
    private Date modifyDate;

    @Column(name = "ModifierID")
    @Parameter(hidden = true)
    private BigDecimal modifierID;

    @Schema(accessMode = READ_ONLY)
    public BigDecimal getGoodsPositionID() {
        return goodsPositionID;
    }

    public void setGoodsPositionID(BigDecimal goodsPositionID) {
        this.goodsPositionID = goodsPositionID;
    }

    @NotBlank(message = "goodsPositionCode is mandatory")
    @Schema(
            required = true,
            example = "A1-1-R1-G2"
    )
    public String getGoodspositionCode() {
        return goodspositionCode;
    }

    public void setGoodspositionCode(String goodspositionCode) {
        this.goodspositionCode = goodspositionCode;
    }

    @NotBlank(message = "goodsPositionDesc is mandatory")
    @Schema(
            required = true,
            example = "قفسه دوم"
    )
    public String getGoodsPositionDesc() {
        return goodsPositionDesc;
    }

    public void setGoodsPositionDesc(String goodsPositionDesc) {
        this.goodsPositionDesc = goodsPositionDesc;
    }


    @Schema(
            required = false
    )
    public BigDecimal getGoodsPositionFatherID() {
        return goodsPositionFatherID;
    }

    public void setGoodsPositionFatherID(BigDecimal goodsPositionFatherID) {
        this.goodsPositionFatherID = goodsPositionFatherID;
    }

    @Schema(hidden = true)
    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    @Schema(hidden = true)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Schema(hidden = true)
    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }

    @Schema(hidden = true)
    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Schema(hidden = true)
    public BigDecimal getModifierID() {
        return modifierID;
    }

    public void setModifierID(BigDecimal modifierID) {
        this.modifierID = modifierID;
    }
}
