//package com.tarazgroup.tws.model.pub;
//
//import javax.persistence.*;
//import java.math.BigDecimal;
//
///**
// * @author Erfan Akhavan
// */
//
//@NamedStoredProcedureQuery(
//        name = "PubReport_Matrix",
//        procedureName = "PubReport_Matrix",
//        resultClasses = {PubReportMa.class},
//        parameters = {
//                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "VoucherReportID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "RepType", type = Integer.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "FromDate", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "ToDate", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "CustomFormulaIDs", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "RunningTotalField", type = String.class, mode = ParameterMode.IN)
//        }
//)
//
//@Entity
//public class PubReportMatrix {
//
//    @Id
//    @Column(name = "mID")
//    private String mID;
//
//    @Column(name = "کد")
//    private String code;
//
//    @Column(name = "شرح")
//    private String desc;
//
//    @Column(name = "اول دوره|مبلغ")
//    private String initialPeriodSum;
//
//    @Column(name = "وارده|مقدار")
//    private String incomingAmount;
//
//    @Column(name = "وارده|مبلغ")
//    private String incomingSum;
//
//    @Column(name = "اول دوره|فی")
//    private String initialPeriodFee;
//
//    @Column(name = "اول دوره|مقدار")
//    private String initialPeriodAmount;
//
//    @Column(name = "صادره|مقدار")
//    private String outGoingAmount;
//
//    @Column(name = "صادره|مبلغ")
//    private String outGoingSum;
//
//    @Column(name = "فروش|مقدار")
//    private String sellAmount;
//
//    @Column(name = "فروش|مبلغ")
//    private String sellSum;
//
//    @Column(name = "فروش|فی")
//    private String sellFee;
//
//    @Column(name = "برگشت از فروش|مقدار")
//    private String amountOfSellReturnal;
//
//    @Column(name = "برگشت از فروش|مبلغ")
//    private String sumOfSellReturnal;
//
//    @Column(name = "برگشت از فروش|فی")
//    private String feeOfSellReturnal;
//
//    @Column(name = "موجودی انبار|مبلغ")
//    private String sumInvStock;
//
//    @Column(name = "موجودی انبار|مقدار")
//    private String amountInvStock;
//
//    @Column(name = "موجودی انبار|فی")
//    private String feeInvStock;
//
//    @Column(name = "خالص فروش|مقدار")
//    private String amountPureSell;
//
//    @Column(name = "")
//    private String;
//
//    @Column(name = "")
//    private String;
//
//    @Column(name = "")
//    private String;
//
//    @Column(name = "")
//    private String;
//
//    @Column(name = "")
//    private String;
//
//    @Column(name = "")
//    private String;
//
//}
