package com.tarazgroup.tws.model.tkt;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/***
 * @author A.Farahani
 * @date Mar-09, 2022
 ***/
@NamedStoredProcedureQuery(
        name = "TktShowLanguage",
        procedureName = "TktShowLanguage",
        resultClasses = {TktLanguage.class},
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
public class TktLanguage extends TParams implements Serializable {
    @Id
    @Column(name = "LanguageID")
    private BigDecimal languageID;

    @Column(name = "LanguageName")
    private String languageName;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    @Column(name = "ModifyDate")
    private Date modifyDate;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    public BigDecimal getLanguageID() {
        return languageID;
    }

    public void setLanguageID(BigDecimal languageID) {
        this.languageID = languageID;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public BigDecimal getModifierID() {
        return modifierID;
    }

    public void setModifierID(BigDecimal modifierID) {
        this.modifierID = modifierID;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }
}
