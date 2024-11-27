package com.tarazgroup.tws.controller.acc;

import com.tarazgroup.tws.dao.acc.AccBscRepository;
import com.tarazgroup.tws.model.acc.AccBsc;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Erfan Akhavan Edited by Salman Majidi
 */

@RestController
@RequestMapping("acc/bsc")
@Validated
@Tag(name = "Bsc")
public class AccBscController {
    private final AccBscRepository accBscRepository;
    public AccBscController(AccBscRepository accBscRepository) {
        this.accBscRepository = accBscRepository;
    }

    @Operation(
            summary = "Retrieve all Bscs",
            description = "<i><b> Bscs </b></i>"
                    + "<br/>"
                    + "<br/>"
                    + "ــــــــــــــــــــــــــــــ"
                    + "<br/>"
                    + "<br/>"
                    + "ورودی ها"
                    + "<br/>"
                    + "<br/>"
                    + "<code>fromDate</code> : <i><b> تاریخ شروع </b></i>"
                    + "<br/>"
                    + "<br/>"
                    + "<code>toDate</code> : <i><b> تاریخ پایان </b></i>"
                    + "<br/>"
                    + "<br/>"
                    + "<code>costType</code> : <i><b> نوع هزینه </b></i>"
                    + "<br/>"
                    + "<code>costType=NULL</code> یعنی <i><b>کل هزینه ها</b></i>"
                    + "<br/>"
                    + "<code>costType=1</code> یعنی <i><b>هزینه پرسنلی</b></i>"
                    + "<br/>"
                    + "<code>costType=2</code> یعنی <i><b>هزینه قراردادها</b></i>"
                    + "<br/>"
                    + "<code>costType=3</code> یعنی <i><b>هزینه بازنشستگی</b></i>"
                    + "<br/>"
                    + "<code>costType=4</code> یعنی <i><b>جاری هزینه</b></i>"
                    + "<br/>"
                    + "<br/>"
                    + "<code>repType</code> : <i><b> نوع گزارش </b></i>"
                    + "<br/>"
                    + "<code>repType = 0</code> یعنی <i><b>فقط این نوع هزینه بیاید</b></i>"
                    + "<br/>"
                    + "<code>repType = 1</code> یعنی <i><b>یعنی همه انواع هزینه ها بیاید</b></i>"
                    + "<br/>"
                    + "<br/>"
                    + "خروجی ها"
                    + "<br/>"
                    + "<br/>"
                    + "<code>price</code> : <i><b> هزینه </b></i>"
                    + "<br/>"
                    + "<br/>"
                    + "<code>serverID</code> : <i><b> آی-دی سرور </b></i>"
                    + "<br/>"
                    + "<br/>"
                    + "<code>serverName</code> : <i><b> نام سرور </b></i>"
                    + "<br/>"
                    + "<br/>"
                    + "<code>costType</code> : <i><b> نوع هزینه </b></i>"
                    + "<br/>"
                    + "<br/>"
                    + "<code>costDesc</code> : <i><b> شرح هزینه </b></i>"
                    + "<br/>"
                    + "<br/>"
            ,
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<AccBsc>> bscs(@RequestParam String fromDate,
                                             @RequestParam String toDate,
                                             @RequestParam(required = false) Integer costType,
                                             @RequestParam(required = false) Integer repType) {
        return ResponseEntity.ok(accBscRepository.accShowBscs(fromDate, toDate, costType, repType));

    }

//    @Operation(
//            summary = "Export all banks to Excel",
//            description = "<code>Export</code> all <i><b>banks</b></i> to <code>Excel</code>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @GetMapping(value = "/excel", produces = "application/octet-stream")
//    public ResponseEntity<InputStreamResource> exportToExcel() {
//        return ResponseEntity
//                .ok()
//                .headers(THttpHeaders.httpHeadersExcel("accbank"))
//                .body(accBscRepository.excel());
//    }
}
