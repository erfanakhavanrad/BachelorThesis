package com.tarazgroup.tws.model.crm;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/***
 * @author A.Farahani
 * @date Sep-06, 2022
 ***/
@NamedStoredProcedureQuery(
        name = "CrmShowSysSetup",
        procedureName = "CrmShowSysSetup",
        resultClasses = {CrmSysSetup.class},
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
        name = "CrmUpdSysSetup",
        procedureName = "CrmUpdSysSetup",
        parameters = {
                @StoredProcedureParameter(name = "SysSetupID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SystemTitle", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SystemLogoImage", type = byte[].class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SystemFavIcon", type = byte[].class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class CrmSysSetup extends TParams implements Serializable {
        @Id
        @Column(name = "SysSetupID")
        private BigDecimal sysSetupID;

        @Column(name = "SystemTitle")
        private String systemTitle;

        @Column(name = "SystemLogoImage")
        private byte[] systemLogoImage;

        @Column(name = "SystemFavIcon")
        private byte[] systemFavIcon;

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

        public BigDecimal getSysSetupID() {
                return sysSetupID;
        }

        public void setSysSetupID(BigDecimal sysSetupID) {
                this.sysSetupID = sysSetupID;
        }

        public String getSystemTitle() {
                return systemTitle;
        }

        public void setSystemTitle(String systemTitle) {
                this.systemTitle = systemTitle;
        }

        public byte[] getSystemLogoImage() {
                return systemLogoImage;
        }

        public void setSystemLogoImage(byte[] systemLogoImage) {
                this.systemLogoImage = systemLogoImage;
        }

        public byte[] getSystemFavIcon() {
                return systemFavIcon;
        }

        public void setSystemFavIcon(byte[] systemFavIcon) {
                this.systemFavIcon = systemFavIcon;
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
