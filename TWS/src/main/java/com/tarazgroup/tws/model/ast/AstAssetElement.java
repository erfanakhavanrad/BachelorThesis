package com.tarazgroup.tws.model.ast;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 1/1/22
 *
 * @author Erfan Akhavan
 */

@NamedStoredProcedureQuery(
        name = "AstShowAssetElement",
        procedureName = "AstShowAssetElement",
        resultClasses = {AstAssetElement.class},
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
        name = "AstInsAssetElement",
        procedureName = "AstInsAssetElement",
        resultClasses = {AstAssetElement.class},
        parameters = {
                @StoredProcedureParameter(name = "AssetElementCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AssetElementDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)}
)


@NamedStoredProcedureQuery(
        name = "AstUpdAssetElement",
        procedureName = "AstUpdAssetElement",
        resultClasses = {AstAssetElement.class},
        parameters = {
                @StoredProcedureParameter(name = "AssetElementID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AssetElementCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AssetElementDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)


@NamedStoredProcedureQuery(
        name = "AstDelAssetElement",
        procedureName = "AstDelAssetElement",
        resultClasses = {AstAssetElement.class},
        parameters = {
                @StoredProcedureParameter(name = "AssetElementID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class AstAssetElement extends TParams implements Serializable {

    @Id
    @Column(name = "AssetElementID")
    private BigDecimal assetElementID;

    @Column(name = "AssetElementCode")
    private String assetElementCode;

    @Column(name = "AssetElementDesc")
    private String assetElementDesc;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "ModifyDate")
    private Date modifyDate;

    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    public BigDecimal getAssetElementID() {
        return assetElementID;
    }

    public void setAssetElementID(BigDecimal assetElementID) {
        this.assetElementID = assetElementID;
    }

    public String getAssetElementCode() {
        return assetElementCode;
    }

    public void setAssetElementCode(String assetElementCode) {
        this.assetElementCode = assetElementCode;
    }

    public String getAssetElementDesc() {
        return assetElementDesc;
    }

    public void setAssetElementDesc(String assetElementDesc) {
        this.assetElementDesc = assetElementDesc;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public BigDecimal getModifierID() {
        return modifierID;
    }

    public void setModifierID(BigDecimal modifierID) {
        this.modifierID = modifierID;
    }

    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }
}
