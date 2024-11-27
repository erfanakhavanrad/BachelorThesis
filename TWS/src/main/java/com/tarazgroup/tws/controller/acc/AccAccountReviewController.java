package com.tarazgroup.tws.controller.acc;

import com.tarazgroup.tws.dao.acc.AccReportAccountFlowRepository;
import com.tarazgroup.tws.dao.acc.AccReportAccountReviewRepository;
import com.tarazgroup.tws.dao.acc.WebAccReportAccountReview4PostRepository;
import com.tarazgroup.tws.dto.chart.TChart;
import com.tarazgroup.tws.model.acc.AccReportAccountFlow;
import com.tarazgroup.tws.model.acc.AccReportAccountReview;
import com.tarazgroup.tws.model.acc.WebAccReportAccountReview4Post;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
@RestController
@RequestMapping(value = "acc/accountreviews")

@Tag(name = "AccountReview")
public class AccAccountReviewController {
    private final WebAccReportAccountReview4PostRepository webAccReportAccountReview4PostRepository;

    private final AccReportAccountReviewRepository accReportaccountReviewRepository;

    private final AccReportAccountFlowRepository accReportAccountFlowRepository;

    public AccAccountReviewController(WebAccReportAccountReview4PostRepository webAccReportAccountReview4PostRepository,
                                      AccReportAccountReviewRepository accReportaccountReviewRepository,
                                      AccReportAccountFlowRepository accReportAccountFlowRepository) {
        this.webAccReportAccountReview4PostRepository = webAccReportAccountReview4PostRepository;
        this.accReportaccountReviewRepository = accReportaccountReviewRepository;
        this.accReportAccountFlowRepository = accReportAccountFlowRepository;
    }

    @Operation(
            summary = "Retrieve all costs",
            description = "<i><b>هزینه ها</b></i>"
                    + "<br/>"
                    + "<br/>"
                    + "ــــــــــــــــــــــــــــــ"
                    + "<br/>"
                    + "<br/>"
                    + "ورودی ها"
                    + "<br/>"
                    + "<br/>"
                    + "<code>fromBujCode</code> : <i><b>از کد بودجه</b></i>"
                    + "<br/>"
                    + "<br/>"
                    + "<code>toBujCode</code> : <i><b>تا کد بودجه</b></i>"
                    + "<br/>"
                    + "<br/>"
                    + "<code>fromDate</code> : <i><b>از تاریخ</b></i>"
                    + "<br/>"
                    + "<br/>"
                    + "<code>toDate</code> : <i><b>تا تاریخ</b></i>"
                    + "<br/>"
                    + "<br/>"
                    + "<code>compCode</code> : <i><b>عنوان لاتین دفتر پستی</b></i>"
                    + "<br/>"
                    + "<br/>"
                    + "<br/>"
                    + "ــــــــــــــــــــــــــــــ"
                    + "<br/>"
                    + "<br/>"
                    + "<br/>"
                    + "خروجی ها"
                    + "<br/>"
                    + "<br/>"
                    + "<code>accountId</code> : <i><b>آی دی حساب</b></i>"
                    + "<br/>"
                    + "<br/>"
                    + "<code>accountDesc</code> : <i><b>شرح حساب</b></i>"
                    + "<br/>"
                    + "<br/>"
                    + "<code>sbed</code> : <i><b>بدهکار</b></i>"
                    + "<br/>"
                    + "<br/>"
                    + "<code>sbes</code> : <i><b>بستانکار</b></i>"
                    + "<br/>"
                    + "<br/>"
                    + "<code>remainBed</code> : <i><b>مانده بدهکار</b></i>"
                    + "<br/>"
                    + "<br/>"
                    + "<code>remainBes</code> : <i><b>مانده بستانکار</b></i>"
                    + "<br/>"
                    + "<br/>"
                    + "<code>sumBed</code> : <i><b>جمع بدهکار</b></i>"
                    + "<br/>"
                    + "<br/>"
                    + "<code>sumBes</code> : <i><b>جمع بستانکار</b></i>"
                    + "<br/>"
                    + "<br/>"
                    + "<code>relatedLevels</code> : <i><b>سطوح مرتبط حسابداری</b></i>"
                    + "<br/>"
                    + "<br/>"
                    + "<code>serverName</code> : <i><b>عنوان لاتین دفتر پستی</b></i>"
                    + "<br/>"
                    + "<br/>"
                    + "<code>serverDesc</code> : <i><b>عنوان فارسی دفتر پستی</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/costs", produces = "application/json;charset=utf-8")
    public ResponseEntity<List<WebAccReportAccountReview4Post>> costs(
            @RequestParam(required = false) String fromBujCode,
            @RequestParam(required = false) String toBujCode,
            @RequestParam String fromDate,
            @RequestParam String toDate,
            @RequestParam(required = false) String compCode) {
        return ResponseEntity.ok(
                webAccReportAccountReview4PostRepository.accountReview4Post(
                        fromBujCode,
                        toBujCode,
                        fromDate,
                        toDate,
                        compCode,
                        null,
                        true,
                        null)
        );
    }


    @Operation(
            summary = "Retrieve all incomes",
            description = "<i><b>درآمد ها</b></i>"
                    + "<br/>"
                    + "<br/>"
                    + "ــــــــــــــــــــــــــــــ"
                    + "<br/>"
                    + "<br/>"
                    + "ورودی ها"
                    + "<br/>"
                    + "<br/>"
                    + "<code>fromBujCode</code> : <i><b>از کد بودجه</b></i>"
                    + "<br/>"
                    + "<br/>"
                    + "<code>toBujCode</code> : <i><b>تا کد بودجه</b></i>"
                    + "<br/>"
                    + "<br/>"
                    + "<code>fromDate</code> : <i><b>از تاریخ</b></i>"
                    + "<br/>"
                    + "<br/>"
                    + "<code>toDate</code> : <i><b>تا تاریخ</b></i>"
                    + "<br/>"
                    + "<br/>"
                    + "<code>compCode</code> : <i><b>عنوان لاتین دفتر پستی</b></i>"
                    + "<br/>"
                    + "<br/>"
                    + "<br/>"
                    + "ــــــــــــــــــــــــــــــ"
                    + "<br/>"
                    + "<br/>"
                    + "<br/>"
                    + "خروجی ها"
                    + "<br/>"
                    + "<br/>"
                    + "<code>accountId</code> : <i><b>آی دی حساب</b></i>"
                    + "<br/>"
                    + "<br/>"
                    + "<code>accountDesc</code> : <i><b>شرح حساب</b></i>"
                    + "<br/>"
                    + "<br/>"
                    + "<code>sbed</code> : <i><b>بدهکار</b></i>"
                    + "<br/>"
                    + "<br/>"
                    + "<code>sbes</code> : <i><b>بستانکار</b></i>"
                    + "<br/>"
                    + "<br/>"
                    + "<code>remainBed</code> : <i><b>مانده بدهکار</b></i>"
                    + "<br/>"
                    + "<br/>"
                    + "<code>remainBes</code> : <i><b>مانده بستانکار</b></i>"
                    + "<br/>"
                    + "<br/>"
                    + "<code>sumBed</code> : <i><b>جمع بدهکار</b></i>"
                    + "<br/>"
                    + "<br/>"
                    + "<code>sumBes</code> : <i><b>جمع بستانکار</b></i>"
                    + "<br/>"
                    + "<br/>"
                    + "<code>relatedLevels</code> : <i><b>سطوح مرتبط حسابداری</b></i>"
                    + "<br/>"
                    + "<br/>"
                    + "<code>serverName</code> : <i><b>عنوان لاتین دفتر پستی</b></i>"
                    + "<br/>"
                    + "<br/>"
                    + "<code>serverDesc</code> : <i><b>عنوان فارسی دفتر پستی</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/incomes", produces = "application/json;charset=utf-8")
    public ResponseEntity<List<WebAccReportAccountReview4Post>> incomes(
            @RequestParam(required = false) String fromBujCode,
            @RequestParam(required = false) String toBujCode,
            @RequestParam String fromDate,
            @RequestParam String toDate,
            @RequestParam(required = false) String compCode) {
        return ResponseEntity.ok(
                webAccReportAccountReview4PostRepository.accountReview4Post(
                        fromBujCode,
                        toBujCode,
                        fromDate,
                        toDate,
                        compCode,
                        null,
                        false,
                        null)
        );
    }

    @Operation(
            summary = "Report accountReview",
            description = "<code>Report</code> <i><b>accountReview</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<AccReportAccountReview>> reportAccountReview(@ParameterObject AccReportAccountReview accReport_accountReview, @RequestParam(required = true) Integer reportLvl, @RequestParam(required = false) Boolean remain,
                                                                            @RequestParam(required = true) BigDecimal colNum, @RequestParam(required = true) String fromDate, @RequestParam(required = true) String toDate,
                                                                            @RequestParam(required = false) String accountFilter, @RequestParam(required = false) Boolean isCurrency, @RequestParam(required = false) Boolean isTemp,
                                                                            @RequestParam(required = false) String filterTypeVoucher, @RequestParam(required = false) Boolean isShowContactInfo, @RequestParam(required = false) Boolean isByServer,
                                                                            @RequestParam(required = false) Boolean isShowLastActivity) {

        return ResponseEntity.ok(accReportaccountReviewRepository.accReport_AccountReview(accReport_accountReview, reportLvl, remain, colNum,
                fromDate, toDate, accountFilter, isCurrency, isTemp, filterTypeVoucher, isShowContactInfo, isByServer, isShowLastActivity));
    }

    @Operation(
            summary = "Report accountFlow",
            description = "<code>Report</code> <i><b>accountFlow</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/accountflow", produces = "application/json")
    public ResponseEntity<List<AccReportAccountFlow>> reportAccountFlow(@ParameterObject AccReportAccountFlow accReportAccountFlow, @RequestParam(required = false) Boolean preRemain,
                                                                        @RequestParam(required = false) Boolean nextRemain, @RequestParam(required = false) String fromDate, @RequestParam(required = false) String toDate,
                                                                        @RequestParam(required = false) Boolean isMonthRep, @RequestParam(required = false) String accountFilter, @RequestParam(required = false) Boolean isRemainByCurrency,
                                                                        @RequestParam(required = false) String filterTypeVoucher, @RequestParam(required = false) BigDecimal voucherConflictID, @RequestParam(required = false) Boolean isSortByNature) {
        return ResponseEntity.ok(accReportAccountFlowRepository.accReportAccountFlow(accReportAccountFlow, preRemain, nextRemain, fromDate, toDate,
                isMonthRep, accountFilter, isRemainByCurrency, filterTypeVoucher, voucherConflictID,
                isSortByNature));
    }

    @Operation(
            summary = "گزارشات حساب",
            description = "<code>گزارشات حساب</code>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/chart", produces = "application/json;charset=utf-8")
    public ResponseEntity<TChart> accReportAccountReviewChart(
            @RequestParam() String[] srIDs,
            @RequestParam() BigDecimal yearID,
            @RequestParam() String fromDate,
            @RequestParam() String toDate,
            @RequestParam() String xFieldName,
            @RequestParam() String[] yFieldNames,
            @RequestParam() String[] yFieldTitles) {
        return ResponseEntity
                .ok()
                .body(accReportaccountReviewRepository.accReportAccountReview(srIDs, yearID, fromDate, toDate, xFieldName, yFieldNames, yFieldTitles));
    }


    @Operation(
            summary = "گزارشات مانده حساب",
            description = "<code>گزارشات مانده حساب</code>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/customercredit", produces = "application/json;charset=utf-8")
    public ResponseEntity<List<Map<String, Object>>> accReportAccountReviewChart3(
//            @Value("${customerID:#{null}}") BigDecimal customerID,
            @RequestParam(required = false) BigDecimal TafsiliID,
            @RequestParam() String[] srIDs,
            @RequestParam() BigDecimal yearID,
            @RequestParam() String fromDate,
            @RequestParam() String toDate,
            @RequestParam() BigDecimal reportLevel,
            @RequestParam() Boolean remain
    ) {
        return ResponseEntity
                .ok()
                .body(accReportaccountReviewRepository.accReportAccountReview3(TafsiliID, srIDs, yearID, fromDate, toDate, reportLevel, remain));
    }


}
