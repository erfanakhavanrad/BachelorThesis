package com.tarazgroup.tws.model.scr;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Abbas Ashrafi
 * @since v2.0.0
 */

@NamedStoredProcedureQuery(
        name = "ScrShowSecretariat",
        procedureName = "ScrShowSecretariat",
        resultClasses = {ScrSecretariat.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsWebUser", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "ScrInsSecretariat",
        procedureName = "ScrInsSecretariat",
        parameters = {
                @StoredProcedureParameter(name = "SecretariatCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SecretariatName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OrganizationChartID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "A4Letter", type = byte[].class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "A5Letter", type = byte[].class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "A4Sample", type = byte[].class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "A5Sample", type = byte[].class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsMyNote", type = Boolean.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "ScrDelSecretariat",
        procedureName = "ScrDelSecretariat",
        parameters = {
                @StoredProcedureParameter(name = "SecretariatID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
        }
)

@NamedStoredProcedureQuery(
        name = "ScrUpdSecretariat",
        procedureName = "ScrUpdSecretariat",
        parameters = {
                @StoredProcedureParameter(name = "SecretariatID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SecretariatCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SecretariatName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OrganizationChartID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "A4Letter", type = byte[].class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "A5Letter", type = byte[].class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "A4Sample", type = byte[].class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "A5Sample", type = byte[].class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsMyNote", type = Boolean.class, mode = ParameterMode.IN)
        }
)

@Entity
//@Table(name = "ScrSecretariat")
public class ScrSecretariat extends TParams implements Serializable {

    @Id
    @Column(name = "SecretariatID")
    private BigDecimal secretariatID;

    @Column(name = "SecretariatCode")
    private String secretariatCode;

    @Column(name = "SecretariatName")
    private String secretariatName;

    @Column(name = "OrganizationChartID")
    private BigDecimal organizationChartID;

    @Column(name = "UserID")
    private BigDecimal userID;

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

    @Column(name = "OrganizationChartCode")
    private String organizationChartCode;

    @Column(name = "OrganizationChartName")
    private String organizationChartName;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "TafsiliTypeIDs")
    private String tafsiliTypeIDs;

    @Parameter(hidden = true)
    @Column(name = "A4Letter")
    private byte[] a4Letter;

    @Parameter(hidden = true)
    @Column(name = "A5Letter")
    private byte[] a5Letter;

    @Parameter(hidden = true)
    @Column(name = "A4Sample")
    private byte[] a4Sample;

    @Parameter(hidden = true)
    @Column(name = "A5Sample")
    private byte[] a5Sample;

    @Column(name = "IsMyNote")
    private Boolean isMyNote;

    //    @Schema(accessMode = READ_ONLY)
    public BigDecimal getSecretariatID() {
        return secretariatID;
    }

    public void setSecretariatID(BigDecimal secretariatID) {
        this.secretariatID = secretariatID;
    }

    //    @Schema(
//            example = "secretariatCode"
//    )
    public String getSecretariatCode() {
        return secretariatCode;
    }

    public void setSecretariatCode(String secretariatCode) {
        this.secretariatCode = secretariatCode;
    }

    //    @Schema(
//            example = "secretariatName"
//    )
    public String getSecretariatName() {
        return secretariatName;
    }

    public void setSecretariatName(String secretariatName) {
        this.secretariatName = secretariatName;
    }

    //    @Schema(
//            example = "organizationChartID"
//    )
    public BigDecimal getOrganizationChartID() {
        return organizationChartID;
    }

    public void setOrganizationChartID(BigDecimal organizationChartID) {
        this.organizationChartID = organizationChartID;
    }

    //    @Schema(
//            example = "userID"
//    )
    public BigDecimal getUserID() {
        return userID;
    }

    public void setUserID(BigDecimal userID) {
        this.userID = userID;
    }

    //    @Schema(hidden = true)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    //    @Schema(hidden = true)
    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }

    //    @Schema(hidden = true)
    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    //    @Schema(hidden = true)
    public BigDecimal getModifierID() {
        return modifierID;
    }

    public void setModifierID(BigDecimal modifierID) {
        this.modifierID = modifierID;
    }

    //    @Schema(hidden = true)
    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    public Boolean getIsMyNote() {
        return isMyNote;
    }

    public void setIsMyNote(Boolean isMyNote) {
        this.isMyNote = isMyNote;
    }

    public String getOrganizationChartCode() {
        return organizationChartCode;
    }

    public void setOrganizationChartCode(String organizationChartCode) {
        this.organizationChartCode = organizationChartCode;
    }

    public String getOrganizationChartName() {
        return organizationChartName;
    }

    public void setOrganizationChartName(String organizationChartName) {
        this.organizationChartName = organizationChartName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTafsiliTypeIDs() {
        return tafsiliTypeIDs;
    }

    public void setTafsiliTypeIDs(String tafsiliTypeIDs) {
        this.tafsiliTypeIDs = tafsiliTypeIDs;
    }

    public byte[] getA4Letter() {
        return a4Letter;
    }

    public void setA4Letter(byte[] a4Letter) {
        this.a4Letter = a4Letter;
    }

    public byte[] getA5Letter() {
        return a5Letter;
    }

    public void setA5Letter(byte[] a5Letter) {
        this.a5Letter = a5Letter;
    }

    public byte[] getA4Sample() {
        return a4Sample;
    }

    public void setA4Sample(byte[] a4Sample) {
        this.a4Sample = a4Sample;
    }

    public byte[] getA5Sample() {
        return a5Sample;
    }

    public void setA5Sample(byte[] a5Sample) {
        this.a5Sample = a5Sample;
    }
}


