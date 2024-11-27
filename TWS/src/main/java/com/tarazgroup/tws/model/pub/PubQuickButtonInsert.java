package com.tarazgroup.tws.model.pub;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@SuppressWarnings("JpaDataSourceORMInspection")
@NamedStoredProcedureQuery(name = "CrmShowQuickButtonInsert", procedureName = "CrmShowQuickButtonInsert", resultClasses = {
        PubQuickButtonInsert.class }, parameters = {
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SystemID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ButtonID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CanView", type = Boolean.class, mode = ParameterMode.IN)
        })
@NamedStoredProcedureQuery(
        name = "CrmToggleFavorite",
        procedureName = "CrmToggleFavorite",
        resultClasses = {PubButton.class},
        parameters = {
                @StoredProcedureParameter(name = "ButtonID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)
@Entity
@Table(name = "CrmButtonExtension")
public class PubQuickButtonInsert extends TParams implements Serializable {
    @Id
    @Column(name = "ButtonID")
    private BigDecimal buttonID;

    // @Column(name = "IsQuick")
    // private BigDecimal isQuick;

    @Column(name = "ButtonDesc")
    private String buttonDesc;

    @Column(name = "IconName")
    private String iconName;

    @Column(name = "IsFavorite")
    private Boolean isFavorite;

    @Column(name = "ResourceData")
    private String resourceData;

    @Column(name = "ResourceMeta")
    private String resourceMeta;

    @Column(name = "Title")
    private String title;

    public BigDecimal getButtonID() {
        return buttonID;
    }

    public void setButtonID(BigDecimal buttonID) {
        this.buttonID = buttonID;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public String getResourceData() {
        return resourceData;
    }

    public Boolean getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(Boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public void setResourceData(String resourceData) {
        this.resourceData = resourceData;
    }

    public String getResourceMeta() {
        return resourceMeta;
    }

    public void setResourceMeta(String resourceMeta) {
        this.resourceMeta = resourceMeta;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getButtonDesc() {
        return buttonDesc;
    }

    public void setButtonDesc(String buttonDesc) {
        this.buttonDesc = buttonDesc;
    }
}
