package com.tarazgroup.tws.model.sale;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author A.Salehi
 */

@NamedStoredProcedureQuery(
        name = "SaleShowAdditiveReducerElementsValue",
        procedureName = "SaleShowAdditiveReducerElementsValue",
        resultClasses = {SaleAdditiveReducerElementsValue.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "SaleInsAdditiveReducerElementsValue",
        procedureName = "SaleInsAdditiveReducerElementsValue",
        parameters = {
                @StoredProcedureParameter(name = "ElementID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FromDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ToDate",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CoEfficient",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result",type = BigDecimal.class,mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg",type = String.class,mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "NewID",type = BigDecimal.class,mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "SaleUpdAdditiveReducerElementsValue",
        procedureName = "SaleUpdAdditiveReducerElementsValue",
        parameters = {
                @StoredProcedureParameter(name = "ValueID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ElementID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FromDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ToDate",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CoEfficient",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result",type = BigDecimal.class,mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg",type = String.class,mode = ParameterMode.OUT),
        }
)

@NamedStoredProcedureQuery(
        name = "SaleDelAdditiveReducerElementsValue",
        procedureName = "SaleDelAdditiveReducerElementsValue",
        parameters = {
                @StoredProcedureParameter(name = "ValueID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result",type = BigDecimal.class,mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg",type = String.class,mode = ParameterMode.IN)
        }
)

@Entity
public class SaleAdditiveReducerElementsValue extends TParams implements Serializable {

        @Id
        @Column(name = "ValueID")
        private BigDecimal valueID;

        @Column(name = "ElementID")
        private BigDecimal elementID;

        @Column(name = "FromDate")
        private String fromDate;

        @Column(name = "ToDate")
        private String toDate;

        @Parameter(hidden = true)
        @Column(name = "CreatorID")
        private BigDecimal creatorID;

        @Parameter(hidden = true)
        @Column(name = "CreateDate")
        private Date createDate;

        @Parameter(hidden = true)
        @Column(name = "ModifyDate")
        private Date modifyDate;

        @Parameter(hidden = true)
        @Column(name = "ModifierID")
        private BigDecimal modifierID;

        @Parameter(hidden = true)
        @Column(name = "ServerID")
        private BigDecimal serverID;

        @Column(name = "CoEfficient")
        private BigDecimal coEfficient;

        public BigDecimal getValueID() {
                return valueID;
        }

        public void setValueID(BigDecimal valueID) {
                this.valueID = valueID;
        }

        public BigDecimal getElementID() {
                return elementID;
        }

        public void setElementID(BigDecimal elementID) {
                this.elementID = elementID;
        }

        public String getFromDate() {
                return fromDate;
        }

        public void setFromDate(String fromDate) {
                this.fromDate = fromDate;
        }

        public String getToDate() {
                return toDate;
        }

        public void setToDate(String toDate) {
                this.toDate = toDate;
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

        public BigDecimal getServerID() {
                return serverID;
        }

        public void setServerID(BigDecimal serverID) {
                this.serverID = serverID;
        }

        public BigDecimal getCoEfficient() {
                return coEfficient;
        }

        public void setCoEfficient(BigDecimal coEfficient) {
                this.coEfficient = coEfficient;
        }
}
