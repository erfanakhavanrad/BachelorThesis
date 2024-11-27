package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.sale.SaleCrystalRepVoucherRepository;
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

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */
@RestController
@RequestMapping("sale/salecrystalrepvoucher")
@Validated

@Tag(name = "SaleCrystalRepVoucher")
public class SaleCrystalRepVoucherController {
    private final SaleCrystalRepVoucherRepository saleCrystalRepVoucherRepository;

    public SaleCrystalRepVoucherController(SaleCrystalRepVoucherRepository saleCrystalRepVoucherRepository) {
        this.saleCrystalRepVoucherRepository = saleCrystalRepVoucherRepository;
    }

    @Operation(
            summary = "SaleCrystalRepVoucher",
            description = "<code>SaleCrystalRepVoucher</code>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<Map<String, Object>>> saleCrystalRepVoucher(
            @RequestParam(required = false) String filter,
            @RequestParam(required = false) String otherFilter,
            @RequestParam(required = false) String serverFilter,
            @RequestParam(required = false) String yearFilter,
            @RequestParam(required = false) String userAccessFilter,
            @RequestParam() BigDecimal voucherTypeID) {
        return ResponseEntity
                .ok()
                .body(saleCrystalRepVoucherRepository.saleCrystalRepVoucher(
                        filter, otherFilter, serverFilter, yearFilter, userAccessFilter, voucherTypeID));
    }

    @Operation(
            summary = "Export SaleCrystalRepVoucher to pdf",
            description = "<code>Export</code>  <i><b>SaleCrystalRepVoucher</b></i> to <code>pdf</code>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/pdf", produces = "application/pdf")
    public ResponseEntity<InputStreamResource> exportToPDF(@RequestParam() BigDecimal voucherHeaderID) {
        return ResponseEntity
                .ok()
                .headers(THttpHeaders.httpHeadersPdf("salecrystalrepvoucher"))
                .body(saleCrystalRepVoucherRepository.reportPDF(voucherHeaderID));
    }

    @Operation(
            summary = "Export SaleCrystalRepVoucher to Excel",
            description = "<code>Export</code> all <i><b>SaleCrystalRepVoucher</b></i> to <code>Excel</code>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/excel", produces = "application/octet-stream")
    public ResponseEntity<InputStreamResource> exportToExcel(@RequestParam() BigDecimal voucherHeaderID) {
        return ResponseEntity
                .ok()
                .headers(THttpHeaders.httpHeadersExcel("salecrystalrepvoucher"))
                .body(saleCrystalRepVoucherRepository.excel(voucherHeaderID));
    }
}
