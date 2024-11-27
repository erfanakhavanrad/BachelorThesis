package com.tarazgroup.tws.model.pub;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
@NamedStoredProcedureQuery(
        name = "PubShowUsersGroups",
        procedureName = "PubShowUsersGroups",
        resultClasses = {PubUsersGroups.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@Entity
public class PubUsersGroups extends TParams implements Serializable {
    @Id
    @Column(name = "UserGroupID", columnDefinition = "decimal")
    private BigDecimal userGroupID;

    @Column(name = "UserGroupCode", columnDefinition = "nvarchar")
    private String userGroupCode;

    @Column(name = "UserGroupFName", columnDefinition = "nvarchar")
    private String userGroupFName;

    @Column(name = "UserGroupEName", columnDefinition = "nvarchar")
    private String userGroupEName;

    @Column(name = "UserGroupBriefName", columnDefinition = "nvarchar")
    private String userGroupBriefName;

    @Column(name = "ServerID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal serverID;

    @Column(name = "CreateDate", columnDefinition = "datetime")
    @Parameter(hidden = true)
    private Date createDate;

    @Column(name = "ModifyDate", columnDefinition = "datetime")
    @Parameter(hidden = true)
    private Date modifyDate;

    @Column(name = "CreatorID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal creatorID;

    @Column(name = "ModifierID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal modifierID;

    public BigDecimal getUserGroupID() {
        return userGroupID;
    }

    public void setUserGroupID(BigDecimal userGroupID) {
        this.userGroupID = userGroupID;
    }

    public String getUserGroupCode() {
        return userGroupCode;
    }

    public void setUserGroupCode(String userGroupCode) {
        this.userGroupCode = userGroupCode;
    }

    public String getUserGroupFName() {
        return userGroupFName;
    }

    public void setUserGroupFName(String userGroupFName) {
        this.userGroupFName = userGroupFName;
    }

    public String getUserGroupEName() {
        return userGroupEName;
    }

    public void setUserGroupEName(String userGroupEName) {
        this.userGroupEName = userGroupEName;
    }

    public String getUserGroupBriefName() {
        return userGroupBriefName;
    }

    public void setUserGroupBriefName(String userGroupBriefName) {
        this.userGroupBriefName = userGroupBriefName;
    }

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public java.util.Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }

    public BigDecimal getModifierID() {
        return modifierID;
    }

    public void setModifierID(BigDecimal modifierID) {
        this.modifierID = modifierID;
    }
}

