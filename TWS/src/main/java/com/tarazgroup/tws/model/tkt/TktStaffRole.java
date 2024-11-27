package com.tarazgroup.tws.model.tkt;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/***
 * @author A.Farahani
 * @date Jan-27, 2022
 ***/

@NamedStoredProcedureQuery(
        name = "TktShowStaffRole",
        procedureName = "TktShowStaffRole",
        resultClasses = {TktStaffRole.class},
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
        name = "TktInsStaffRole",
        procedureName = "TktInsStaffRole",
        parameters = {
                @StoredProcedureParameter(name = "StaffID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RoleID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "TktDelStaffRole",
        procedureName = "TktDelStaffRole",
        parameters = {
                @StoredProcedureParameter(name = "StaffRoleID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "TktUpdStaffRole",
        procedureName = "TktUpdStaffRole",
        parameters = {
                @StoredProcedureParameter(name = "StaffRoleID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RoleID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class TktStaffRole extends TParams implements Serializable {
        @Id
        @Column(name = "StaffRoleID")
        private BigDecimal staffRoleID;

        @Column(name = "RoleID")
        private BigDecimal roleID;

        @Column(name = "RoleName")
        private String roleName;

        @Column(name = "StaffID")
        private BigDecimal staffID;

        @Column(name = "PerComFName")
        private String perComFName;

        @Column(name = "PerComLName")
        private String perComLName;

        @Column(name = "CreatorID")
        private BigDecimal creatorID;

        @Column(name = "CreateDate")
        private Date createDate;

        @Column(name = "ModifierID")
        private BigDecimal modifierID;

        @Column(name = "ModifyDate")
        private Date modifyDate;

        @Column(name  = "ServerID")
        private BigDecimal serverID;

        @Transient
        private BigDecimal loginID;

        public BigDecimal getStaffRoleID() {
                return staffRoleID;
        }

        public void setStaffRoleID(BigDecimal staffRoleID) {
                this.staffRoleID = staffRoleID;
        }

        public BigDecimal getRoleID() {
                return roleID;
        }

        public void setRoleID(BigDecimal roleID) {
                this.roleID = roleID;
        }

        public String getRoleName() {
                return roleName;
        }

        public void setRoleName(String roleName) {
                this.roleName = roleName;
        }

        public BigDecimal getStaffID() {
                return staffID;
        }

        public void setStaffID(BigDecimal staffID) {
                this.staffID = staffID;
        }

        public String getPerComFName() {
                return perComFName;
        }

        public void setPerComFName(String perComFName) {
                this.perComFName = perComFName;
        }

        public String getPerComLName() {
                return perComLName;
        }

        public void setPerComLName(String perComLName) {
                this.perComLName = perComLName;
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

        public BigDecimal getLoginID() {
                return loginID;
        }

        public void setLoginID(BigDecimal loginID) {
                this.loginID = loginID;
        }
}
