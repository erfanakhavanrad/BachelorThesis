package com.tarazgroup.tws.controller.acc;


import com.tarazgroup.tws.dao.acc.AccBankRepository;
import com.tarazgroup.tws.dto.AccBankDto;
import com.tarazgroup.tws.model.acc.AccBank;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.THttpHeaders;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */

@Validated
@RequestMapping("acc/banks")
@RestController
@Tag(name = "Bank")
public class AccBankController {

    final private AccBankRepository accBankRepository;

    public AccBankController(AccBankRepository accBankRepository) {
        this.accBankRepository = accBankRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve Records Count",
            description = "<code>Retrieve</code> Records <i><b>Count</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/count")
    public ResponseEntity<Integer> recordsCount(@RequestParam Map<String, String> params) {
        return ResponseEntity
                .ok()
                .body(accBankRepository.recordsCount(params));
    }

    @Operation(
            summary = "Retrieve all banks",
            description = "<code>Retrieve</code> all <i><b>banks</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<AccBankDto>> banks(@ParameterObject AccBankDto accBankDto) {

//        try {
//            TimeUnit.SECONDS.sleep(4);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        ModelMapper modelMapper = new ModelMapper();
        AccBank accBank = modelMapper.map(accBankDto, AccBank.class);
        List<AccBank> accBanks = accBankRepository.accShowBank(accBank);
        List<AccBankDto> accBankDtos = accBanks.stream()
                .map(accBank1 -> modelMapper.map(accBank1, AccBankDto.class)) //lambda expression that return accBankDto
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(accBankDtos);

    }

    @Operation(
            summary = "Retrieve all banks",
            description = "showSPNativeQueryNative",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/native", produces = "application/json;charset=utf-8")
    public ResponseEntity<List<AccBank>> banksNative(@ParameterObject AccBank accBank) {
        return ResponseEntity
                .ok()
                .body(accBankRepository.accShowBankNative(accBank));
    }

    @Operation(
            summary = "Retrieve all banks",
            description = "showSPNativeQueryMap",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/map", produces = "application/json;charset=utf-8")
    public ResponseEntity<List<Map<String, Object>>> banksMap(@ParameterObject AccBank accBank) {
        return ResponseEntity
                .ok()
                .body(accBankRepository.accShowBankMap(accBank));
    }

    @Operation(
            summary = "Retrieve all banks",
            description = "این متد برای تست خروجی چند تایی از اس پی نوشته شده است",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/maptest", produces = "application/json;charset=utf-8")
    public ResponseEntity<?> banksMapTest() {
        return ResponseEntity
                .ok()
                .body(accBankRepository.accShowBankMapTest());
    }

    @Operation(
            summary = "Retrieve all banks Akhavan",
            description = "این متد برای تست خروجی چند تایی از اس پی نوشته شده است",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/maptest/akhavan", produces = "application/json;charset=utf-8")
    public ResponseEntity<?> banksMapTestAk(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content =
            @Content(
                    schema = @Schema(
                            example = " SELECT *  FROM AccBank as bank SELECT BankBranchCode  ,BankBranchDesc  FROM AccBankBranch "
                    )
            ))
            @RequestParam String query) {
        return ResponseEntity
                .ok()
                .body(accBankRepository.accShowBankMapTestAk(query));
    }

    @Operation(
            summary = "Retrieve bank meta",
            description = "<code>Retrieve</code> <i><b>bank</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return ResponseEntity
                .ok()
                .body(accBankRepository.meta());
    }

    @Operation(
            summary = "Export all banks to pdf",
            description = "<code>Export</code> all <i><b>banks</b></i> to <code>pdf</code>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/pdf", produces = "application/pdf")
    public ResponseEntity<InputStreamResource> exportToPDF() {
        return ResponseEntity
                .ok()
                .headers(THttpHeaders.httpHeadersPdf("accbank"))
                .body(accBankRepository.reportPDF());
    }

    @Operation(
            summary = "Export all banks to Excel",
            description = "<code>Export</code> all <i><b>banks</b></i> to <code>Excel</code>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/excel", produces = "application/octet-stream")
    public ResponseEntity<InputStreamResource> exportToExcel() {
        return ResponseEntity
                .ok()
                .headers(THttpHeaders.httpHeadersExcel("accbank"))
                .body(accBankRepository.excel());
    }

    @Operation(
            summary = "Retrieve specific bank",
            description = "<code>Retrieve</code> specific <i><b>bank</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{bankID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<AccBank> bank(@PathVariable BigDecimal bankID) {
        return ResponseEntity
                .ok()
                .body(accBankRepository.accShowBankByID(bankID));
    }

    @Operation(
            summary = "Create bank",
            description = "<code>Create</code> <i><b>bank</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<AccBank> bankInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody AccBank accBank
    ) {
//        try {
//            TimeUnit.SECONDS.sleep(3);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return ResponseEntity.ok(accBankRepository.accInsBank(accBank));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete bank",
            description = "<code>Delete</code> <i><b>bank<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{bankID}", produces = "application/json")
    public ResponseEntity<?> bankDelSP(
            @PathVariable BigDecimal bankID) {
        accBankRepository.accDelBank(bankID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Update bank",
            description = "<code>Update</code> <i><b>bank<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{bankID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<AccBank> bankUpdSP(
            @PathVariable BigDecimal bankID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody AccBank accBank) {
        return ResponseEntity.ok(accBankRepository.accUpdBank(bankID, accBank));
    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="CRUD SD">
    @Operation(
            hidden = true
    )
    @GetMapping(value = "/sd", produces = "application/json")

    public ResponseEntity<List<AccBank>> banksCR() {
        List<AccBank> result = new ArrayList<>();
        Iterable<AccBank> accBanks = accBankRepository.findAll();
        accBanks.forEach(result::add);
        return ResponseEntity.ok(result);
    }


    @Operation(
            hidden = true
    )
    @PostMapping(value = "/sd", produces = "application/json", consumes = "application/json")
    public ResponseEntity<AccBank> bankInsCR(@RequestBody AccBank accBank) {
        return ResponseEntity.ok(accBankRepository.save(accBank));
    }
    //</editor-fold>

}
