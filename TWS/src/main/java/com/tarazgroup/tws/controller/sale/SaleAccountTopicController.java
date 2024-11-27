package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.sale.SaleAccountTopicRepository;
import com.tarazgroup.tws.model.sale.SaleAccountTopic;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author A.Farahani
 * @date Dec-25, 2021
 */
@RestController
@RequestMapping("sale/accounttopics")
@Validated
@Tag(name = "AccountTopic")
public class SaleAccountTopicController {
    final private SaleAccountTopicRepository saleAccountTopicRepository;

    public SaleAccountTopicController(SaleAccountTopicRepository saleAccountTopicRepository) {
        this.saleAccountTopicRepository = saleAccountTopicRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all accountTopics",
            description = "<code>Retrieve</code> all <i><b>accountTopics</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<SaleAccountTopic>> accountTopics(@ParameterObject SaleAccountTopic saleAccountTopic) {
        return ResponseEntity
                .ok()
                .body(saleAccountTopicRepository.saleShowAccountTopic(saleAccountTopic));
    }

    @Operation(
            summary = "Retrieve specific accountTopic",
            description = "<code>Retrieve</code> specific <i><b>accountTopic</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{topicID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<SaleAccountTopic> accountTopic(@PathVariable BigDecimal topicID) {
        return ResponseEntity
                .ok()
                .body(saleAccountTopicRepository.saleShowAccountTopicByID(topicID));
    }

    @Operation(
            summary = "Create accountTopic",
            description = "<code>Create</code> <i><b>accountTopic</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<SaleAccountTopic> accountTopicInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody SaleAccountTopic saleAccountTopic
    ) {
        return ResponseEntity.ok(saleAccountTopicRepository.saleInsAccountTopic(saleAccountTopic));
    }


    @Operation(
            summary = "Update accountTopic",
            description = "<code>Update</code> <i><b>accountTopic<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{topicID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<SaleAccountTopic> accountTopicUpdSP(
            @PathVariable BigDecimal topicID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody SaleAccountTopic saleAccountTopic) {
        return ResponseEntity.ok(saleAccountTopicRepository.saleUpdAccountTopic(topicID, saleAccountTopic));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete accountTopic",
            description = "<code>Delete</code> <i><b>accountTopic<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{topicID}", produces = "application/json")
    public ResponseEntity<?> accountTopicDelSP(
            @PathVariable BigDecimal topicID) {
        saleAccountTopicRepository.saleDelAccountTopic(topicID);
        return ResponseEntity.noContent().build();
    }
    //</editor-fold>
}
