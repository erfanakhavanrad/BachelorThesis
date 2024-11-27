package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.sale.SaleClassRepository;
import com.tarazgroup.tws.model.sale.SaleClass;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
@RequestMapping("sale/classes")
@Validated

@Tag(name = "Class")
public class SaleClassController {
    private final SaleClassRepository saleClassRepository;

    public SaleClassController(SaleClassRepository saleClassRepository) {
        this.saleClassRepository = saleClassRepository;
    }

    @Operation(
            summary = "Retrieve all classes",
            description = "<code>Retrieve</code> all <i><b>classes</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<SaleClass>> saleClasses(@ParameterObject SaleClass saleClass) {
        return ResponseEntity.ok(saleClassRepository.saleShowClass(saleClass));
    }

    @Operation(
            summary = "Create class",
            description = "<code>Create</code> <i><b>class</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<SaleClass> saleInsClassSP(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content =
            @Content(
                    schema = @Schema(
                            example = "{\n" +
                                    "  \"classCode\": \"11\",\n" +
                                    "  \"classDesc\": \"مشتریان درجه سه\",\n" +
                                    "  \"otherDesc\": null,\n" +
                                    "  \"fatherID\": 10000001,\n" +
                                    "  \"classLevel\": 2,\n" +
                                    "  \"classType\": 4,\n" +
                                    "  \"priorityAddress\": 0,\n" +
                                    "  \"quatoPercentage\": 0.00\n" +
                                    "}"
                    )
            ))
            @RequestBody @Valid SaleClass saleClass) {
        return ResponseEntity.ok(saleClassRepository.saleInsClass(saleClass));
    }


    @Operation(
            summary = "Retrieve class meta",
            description = "<code>Retrieve</code> <i><b>class</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json")
    public ResponseEntity<?> meta() {
        return ResponseEntity.ok().body(saleClassRepository.meta());
    }
}
