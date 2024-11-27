package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.sale.SaleGetEndCreditRepository;
import com.tarazgroup.tws.model.sale.SaleGetEndCredit;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@RequestMapping("sale/endcredits")

@Tag(name = "EndCredit")
public class SaleEndCreditController {

    public final SaleGetEndCreditRepository saleGetEndCreditRepository;

    public SaleEndCreditController(SaleGetEndCreditRepository saleGetEndCreditRepository) {
        this.saleGetEndCreditRepository = saleGetEndCreditRepository;
    }

//    @Operation(
//            summary = "Retrieve credits",
//            description = "<code>Retrieve</code> <i><b>credits</b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @GetMapping(produces = "application/json;charset=utf-8")
//    public ResponseEntity<List<SaleGetEndCreditDto>> saleGetCredit(@ParameterObject SaleGetEndCreditDto saleGetEndCreditDto) {
//        //
//        ModelMapper modelMapper = new ModelMapper();
//        SaleGetEndCredit saleGetEndCredit = modelMapper.map(saleGetEndCreditDto, SaleGetEndCredit.class);
//        List<SaleGetEndCredit> saleGetEndCredits = saleGetEndCreditRepository.saleShowGetEndCredit(saleGetEndCredit);
//        //
//        List<SaleGetEndCreditDto> saleGetEndCreditDtos = saleGetEndCredits.stream()
//                .map(saleGetEndCredit1 -> modelMapper.map(saleGetEndCreditDto, SaleGetEndCreditDto.class))
//                .collect(Collectors.toList());
//        //
//        return ResponseEntity.ok().body(saleGetEndCreditDtos);
//    }

    @Operation(
            summary = "Retrieve credits",
            description = "<code>Retrieve</code> <i><b>credits</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<SaleGetEndCredit>> getCredit(
            @RequestParam(required = false) BigDecimal voucherHeaderID,
            @RequestParam(required = true) String voucherDate,
            @RequestParam(required = true) BigDecimal customerID,
            @RequestParam(required = true) BigDecimal personTypeID,
            @RequestParam(required = false) BigDecimal pageNumber,
            @RequestParam(required = false) BigDecimal recordCount
    ) {
        //
        return ResponseEntity.ok(saleGetEndCreditRepository.saleGetEndCredit(voucherHeaderID, voucherDate, customerID, personTypeID, pageNumber, recordCount));
    }


}
