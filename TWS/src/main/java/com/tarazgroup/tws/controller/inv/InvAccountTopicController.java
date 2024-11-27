package com.tarazgroup.tws.controller.inv;

import com.tarazgroup.tws.dao.inv.InvAccountTopicRepository;
import com.tarazgroup.tws.model.inv.InvAccountTopic;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
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
 * @author Erfan Akhavan
 */

@Validated
@RequestMapping("inv/accounttopic")
@RestController
@Tag(name = "AccountTopic")
public class InvAccountTopicController {
    private final InvAccountTopicRepository invAccountTopicRepository;

    public InvAccountTopicController(InvAccountTopicRepository invAccountTopicRepository) {
        this.invAccountTopicRepository = invAccountTopicRepository;
    }

    @Operation(
            summary = "Retrieve all AccountTopics",
            description = "<code>Retrieve</code> all <i><b>AccountTopics</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<InvAccountTopic>> AccountTopics(@ParameterObject InvAccountTopic invAccountTopic) {
        return ResponseEntity
                .ok()
                .body(invAccountTopicRepository.invShowAccountTopics(invAccountTopic));
    }


    @Operation(
            summary = "Retrieve specific AccountTopic",
            description = "<code>Retrieve</code> specific <i><b>AccountTopic</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{topicID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<InvAccountTopic> AccountTopicByID(@PathVariable BigDecimal topicID) {
        return ResponseEntity
                .ok()
                .body(invAccountTopicRepository.invShowAccountTopicByID(topicID));
    }


    @Operation(
            summary = "Create AccountTopics",
            description = "<code>Create</code> <i><b>AccountTopics</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<InvAccountTopic> accountTopicInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
                    @Content(
                            schema = @Schema(
                                    example = "{\n" +
                                            "    \"topicID\": 10000004,\n" +
                                            "    \"voucherTypeID\": 1217,\n" +
                                            "    \"bedAccountID\": 10000261,\n" +
                                            "    \"besAccountID\": 10000070,\n" +
                                            "    \"bedTafsiliTypeID\": null,\n" +
                                            "    \"besTafsiliTypeID\": 10000019,\n" +
                                            "    \"bedCenter1TypeID\": null,\n" +
                                            "    \"besCenter1TypeID\": null,\n" +
                                            "    \"bedCenter2TypeID\": null,\n" +
                                            "    \"besCenter2TypeID\": null,\n" +
                                            "    \"bedCenter3TypeID\": null,\n" +
                                            "    \"besCenter3TypeID\": null,\n" +
                                            "    \"bedVoucherDesc\": \" #VN# #VT# #DX#\",\n" +
                                            "    \"besVoucherDesc\": \" #VN# #VT# #DS#\",\n" +
                                            "    \"storeID\": null,\n" +
                                            "    \"createDate\": \"2021-05-24T08:53:12.267+00:00\",\n" +
                                            "    \"creatorID\": 10000000,\n" +
                                            "    \"modifyDate\": \"2021-05-24T08:53:12.267+00:00\",\n" +
                                            "    \"modifierID\": 10000000,\n" +
                                            "    \"serverID\": 1,\n" +
                                            "    \"customVTypeDesc\": \"حواله فروش\",\n" +
                                            "    \"bedAccountCode\": \"0803001\",\n" +
                                            "    \"besAccountCode\": \"0104001\",\n" +
                                            "    \"bedAccountDesc\": \"بهاي تمام شده کالاي درجريان ساخت \",\n" +
                                            "    \"besAccountDesc\": \"موجودي مواد اوليه\",\n" +
                                            "    \"storeName\": null,\n" +
                                            "    \"bedTafsiliTypeDesc\": null,\n" +
                                            "    \"besTafsiliTypeDesc\": \"انبارها\",\n" +
                                            "    \"bedCenter1TypeDesc\": null,\n" +
                                            "    \"besCenter1TypeDesc\": null,\n" +
                                            "    \"bedCenter2TypeDesc\": null,\n" +
                                            "    \"besCenter2TypeDesc\": \"سطح 5\",\n" +
                                            "    \"bedCenter3TypeDesc\": null,\n" +
                                            "    \"besCenter3TypeDesc\": null,\n" +
                                            "    \"bedTypes\": \"0000\",\n" +
                                            "    \"besTypes\": \"0010\",\n" +
                                            "    \"groupID\": null,\n" +
                                            "    \"groupCode\": null,\n" +
                                            "    \"groupDesc\": null,\n" +
                                            "    \"hVTypeID\": 1217,\n" +
                                            "    \"hVTypeDesc\": \"حواله فروش\"\n" +
                                            "  }\n"
                            )
                    )
            })
            @RequestBody InvAccountTopic invAccountTopic
    ) {
        return ResponseEntity.ok(invAccountTopicRepository.invInsAccountTopic(invAccountTopic));
    }

    @Operation(
            summary = "Update AccountTopics",
            description = "<code>Update</code> <i><b>AccountTopics<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{topicID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<InvAccountTopic> accountTopicUpdSP(
            @PathVariable BigDecimal topicID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody InvAccountTopic invAccountTopic) {
        return ResponseEntity.ok(invAccountTopicRepository.invUpdAccountTopic(topicID, invAccountTopic));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete AccountTopics",
            description = "<code>Delete</code> <i><b>AccountTopics<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{topicID}", produces = "application/json")
    public ResponseEntity<?> accountTopicDelSP(
            @PathVariable BigDecimal topicID) {
        invAccountTopicRepository.invDelAccountTopic(topicID);
        return ResponseEntity.noContent().build();
    }


    @Operation(
            summary = "Retrieve AccountTopics meta",
            description = "<code>Retrieve</code> <i><b>AccountTopics</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(invAccountTopicRepository.meta());
    }

}