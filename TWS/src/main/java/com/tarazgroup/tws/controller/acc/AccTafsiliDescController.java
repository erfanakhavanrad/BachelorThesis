package com.tarazgroup.tws.controller.acc;

import com.tarazgroup.tws.dao.acc.AccGetTafsiliDescRepository;
import com.tarazgroup.tws.model.acc.AccGetTafsiliDesc;
import com.tarazgroup.tws.util.global.responseheader.Meta;
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

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
@RestController
@RequestMapping("acc")

@Tag(name = "TafsiliDesc")
public class AccTafsiliDescController {

    private final AccGetTafsiliDescRepository accGetTafsiliDescRepository;

    public AccTafsiliDescController(AccGetTafsiliDescRepository accGetTafsiliDescRepository) {
        this.accGetTafsiliDescRepository = accGetTafsiliDescRepository;
    }

    @Operation(
            summary = "Get all tafsiliDesc",
            description = "<code>Get</code> all <i><b>tafsiliDesc</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/tafsilidescs", produces = "application/json")
    public ResponseEntity<List<AccGetTafsiliDesc>> accGetTafslisDescs(@ParameterObject AccGetTafsiliDesc accGetTafsiliDesc, @RequestParam(required = false) BigDecimal accID,
                                                                      @RequestParam(required = false) BigDecimal tafsiliLevel, @RequestParam(required = false) String center1Code,
                                                                      @RequestParam(required = false) String center2Code, @RequestParam(required = false) String center3Code,
                                                                      @RequestParam(required = false) String dCenter1Code, @RequestParam(required = false) String dCenter2Code,
                                                                      @RequestParam(required = false) String dCenter3Code) {
        return ResponseEntity.ok(accGetTafsiliDescRepository.accGetTafsiliDesc(
                accGetTafsiliDesc, accID, tafsiliLevel, center1Code, center2Code,
                center3Code, dCenter1Code, dCenter2Code, dCenter3Code));
    }
    @Operation(
            summary = "Retrieve account4Vouchers meta",
            description = "<code>Retrieve</code> <i><b>account4Vouchers</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(accGetTafsiliDescRepository.meta());
    }

    @Operation(
            summary = "Get all tafsiliDesc by VoucherTypeID",
            description = "<code>Get</code> all <i><b>tafsiliDesc by VoucherTypeID</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/tafsilidescs1", produces = "application/json")
    public ResponseEntity<List<AccGetTafsiliDesc>> accGetTafslisDescsByVoucherTypeID(
            @RequestParam() BigDecimal voucherTypeID,
            @RequestParam(required = false) BigDecimal tafsiliID,
            @RequestParam(required = false) String tafsiliCode,
            @RequestParam(required = false) String tafsiliDesc
    ) {
        return ResponseEntity.ok(accGetTafsiliDescRepository.accGetTafslisDescsByVoucherTypeID(
                voucherTypeID,
                tafsiliID,
                tafsiliCode,
                tafsiliDesc
        ));
    }

    @Operation(
            summary = "Get all tafsiliDesc by VoucherTypeID for CRM",
            description = "<code>Get</code> all <i><b>tafsiliDesc by VoucherTypeID for CRM</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "crm/tafsilidescs1", produces = "application/json")
    public ResponseEntity<List<AccGetTafsiliDesc>> accGetTafslisDescsByVoucherTypeIDCrm(
            @RequestParam() BigDecimal voucherTypeID,
            @RequestParam(required = false) BigDecimal tafsiliID,
            @RequestParam(required = false) String tafsiliCode,
            @RequestParam(required = false) String tafsiliDesc,
            @RequestParam(required = false) BigDecimal levelCenter
    ) {
        return ResponseEntity.ok(accGetTafsiliDescRepository.accGetTafslisDescsByVoucherTypeIDCrm(
                voucherTypeID,
                tafsiliID,
                tafsiliCode,
                tafsiliDesc,
                levelCenter
        ));
    }

}
