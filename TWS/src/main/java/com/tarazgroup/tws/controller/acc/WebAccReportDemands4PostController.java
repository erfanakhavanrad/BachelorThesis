package com.tarazgroup.tws.controller.acc;

import com.tarazgroup.tws.dao.acc.WebAccReportDemands4PostRepository;
import com.tarazgroup.tws.model.acc.WebAccReportDemands4Post;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.THttpHeaders;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Erfan Akhavan
 */

@RestController
@RequestMapping("acc/webreportdemands4post")
@Validated
@Tag(name = "WebReportDemands4Post")
public class WebAccReportDemands4PostController {
    private final WebAccReportDemands4PostRepository webAccReportDemands4PostRepository;

    public WebAccReportDemands4PostController(WebAccReportDemands4PostRepository webAccReportDemands4PostRepository) {
        this.webAccReportDemands4PostRepository = webAccReportDemands4PostRepository;
    }


    @Operation(
            summary = "Retrieve all webAccReportDemands4PostRepository",
            description = "<code>Retrieve</code> all <i><b>webAccReportDemands4PostRepository</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<WebAccReportDemands4Post>> actuaryStores(@RequestParam Integer yearNo, @RequestParam Integer monthNo) {
        return ResponseEntity.ok(webAccReportDemands4PostRepository.accWebShowReportDemands(yearNo, monthNo));
    }


    @Operation(
            summary = "Retrieve webAccReportDemands4PostRepository meta",
            description = "<code>Retrieve</code> <i><b>webAccReportDemands4PostRepository</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(webAccReportDemands4PostRepository.meta());
    }



    @Operation(
            summary = "Export all webAccReportDemands4PostRepository to Excel",
            description = "<code>Export</code> all <i><b>webAccReportDemands4PostRepository</b></i> to <code>Excel</code>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/excel", produces = "application/octet-stream")
    public ResponseEntity<InputStreamResource> exportToExcel(@RequestParam Integer yearNo, @RequestParam Integer monthNo) {
        StringBuilder stringBuilderFileName=new StringBuilder("motalebat");
        stringBuilderFileName.append("_").append(yearNo).append("_").append(monthNo);
        return ResponseEntity
                .ok()
                .headers(THttpHeaders.httpHeadersExcel(stringBuilderFileName.toString()))
                .body(webAccReportDemands4PostRepository.excel(yearNo, monthNo));
    }

}
