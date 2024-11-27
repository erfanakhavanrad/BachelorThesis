package com.tarazgroup.tws.model.sale;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/***
 * @author A.Farahani
 * @date Jan-04, 2022
 ***/
@NamedStoredProcedureQuery(
        name = "SaleShowNumberingSetup",
        procedureName = "SaleShowNumberingSetup",
        resultClasses = {SaleNumberingSetup.class},
        parameters = {
                @StoredProcedureParameter(name = "NumberingMethod", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherTypeID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "SaleUpdNumberingSetup",
        procedureName = "SaleUpdNumberingSetup",
        parameters = {
                @StoredProcedureParameter(name = "VoucherTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type= BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "FromNum", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "mID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)

@Entity
public class SaleNumberingSetup extends TParams implements Serializable {
        @Id
        @Column(name = "mID")
        private BigDecimal mID;


        @Column(name = "VoucherTypeID")
        private BigDecimal voucherTypeID;

        @Column(name = "FromNum")
        private Integer fromNum;


        @Column(name = "SPName")
        private String sPName;

        public BigDecimal getmID() {
                return mID;
        }

        public void setmID(BigDecimal mID) {
                this.mID = mID;
        }

        public Integer getFromNum() {
                return fromNum;
        }

        public void setFromNum(Integer fromNum) {
                this.fromNum = fromNum;
        }

        public BigDecimal getVoucherTypeID() {
                return voucherTypeID;
        }

        public void setVoucherTypeID(BigDecimal voucherTypeID) {
                this.voucherTypeID = voucherTypeID;
        }

        public String getsPName() {
                return sPName;
        }

        public void setsPName(String sPName) {
                this.sPName = sPName;
        }
}
