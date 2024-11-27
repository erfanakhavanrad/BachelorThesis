//package com.tarazgroup.tws.model.sale;
//
//import javax.persistence.*;
//import java.math.BigDecimal;
//import java.util.Date;
//
///**
// * 1/13/22
// *
// * @author Erfan Akhavan
// */
//
//@NamedStoredProcedureQuery(
//        name = "SaleShowAllowableCustomerSell",
//        procedureName = "SaleShowAllowableCustomerSell",
//        resultClasses = {SaleAllowableCustomerSell.class},
//        parameters = {
//                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "RefTypeID", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "StoreID", type = String.class, mode = ParameterMode.IN)
//        }
//)
//
//
//@NamedStoredProcedureQuery(
//        name = "SaleInsAllowableCustomerSell",
//        procedureName = "SaleInsAllowableCustomerSell",
//        resultClasses = {SaleAllowableCustomerSell.class},
//        parameters = {
//                @StoredProcedureParameter(name = "VoucherDate", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "VoucherDateG", type = Date.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "CustomerID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "GoodsID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "SecUnitID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "ComputeValue", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "AllocatedQuantity", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "OverAllocatedQuantity", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "DReferID", type = BigDecimal.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "StoreID", type = BigDecimal.class, mode = ParameterMode.IN)
//        }
//)
//
//
//@NamedStoredProcedureQuery(
//        name = "SaleUpdAllowableCustomerSell",
//        procedureName = "SaleUpdAllowableCustomerSell",
//        resultClasses = {SaleAllowableCustomerSell.class},
//        parameters = {
//                @StoredProcedureParameter(name = "SellID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "VoucherDate", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "VoucherDateG", type = Date.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "CustomerID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "StoreID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "GoodsID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "SecUnitID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "ComputeValue", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "AllocatedQuantity", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "OverAllocatedQuantity", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "DReferID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
//        }
//)
//
//
//@NamedStoredProcedureQuery(
//        name = "SaleDelAllowableCustomerSell",
//        procedureName = "SaleDelAllowableCustomerSell",
//        resultClasses = {SaleAllowableCustomerSell.class},
//        parameters = {
//                @StoredProcedureParameter(name = "CustomerID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "VoucherDate", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "DReferID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "StoreID", type = BigDecimal.class, mode = ParameterMode.IN)
//        }
//)
//
//@Entity
//public class SaleAllowableCustomerSell {
//
//        @Id
//        @Column(name = "")
//
//
//}
