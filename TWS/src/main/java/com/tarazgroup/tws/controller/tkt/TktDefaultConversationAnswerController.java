package com.tarazgroup.tws.controller.tkt;

import com.tarazgroup.tws.dao.tkt.TktDefaultConversationAnswerRepository;
import com.tarazgroup.tws.model.tkt.TktDefaultConversationAnswer;
import com.tarazgroup.tws.util.global.responseheader.Meta;
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

/***
 * @author A.Farahani
 * @date May-24, 2022
 ***/
@RestController
@RequestMapping("tkt/defaultconversationanswers")
@Validated
@Tag(name = "DefaultConversationAnswer")
public class TktDefaultConversationAnswerController {
    final private TktDefaultConversationAnswerRepository tktDefaultConversationAnswerRepository;

    public TktDefaultConversationAnswerController(TktDefaultConversationAnswerRepository tktDefaultConversationAnswerRepository) {
        this.tktDefaultConversationAnswerRepository = tktDefaultConversationAnswerRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all defaultConversationAnswers",
            description = "<code>Retrieve</code> all <i><b>defaultConversationAnswers</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<TktDefaultConversationAnswer>> defaultConversationAnswers(@ParameterObject TktDefaultConversationAnswer tktDefaultConversationAnswer) {
        return ResponseEntity
                .ok()
                .body(tktDefaultConversationAnswerRepository.tktShowDefaultConversationAnswer(tktDefaultConversationAnswer));
    }

    @Operation(
            summary = "Retrieve specific defaultConversationAnswer",
            description = "<code>Retrieve</code> specific <i><b>defaultConversationAnswer</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{answerID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<TktDefaultConversationAnswer> defaultConversationAnswer(@PathVariable BigDecimal answerID) {
        return ResponseEntity
                .ok()
                .body(tktDefaultConversationAnswerRepository.tktShowDefaultConversationAnswerByID(answerID));
    }

    @Operation(
            summary = "Create defaultConversationAnswer",
            description = "<code>Create</code> <i><b>defaultConversationAnswer</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktDefaultConversationAnswer> defaultConversationAnswerInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
//                    (
//                    content = {
//                            @Content(
//                                    schema = @Schema(
//                                            example =
//                                                    "{\n" +
//                                                            "  \"priorityName\": \"name\"\n" +
//                                                            "}"
//                                    )
//                            )
//                    }
//            )
            @RequestBody TktDefaultConversationAnswer tktDefaultConversationAnswer
    ) {
        return ResponseEntity.ok(tktDefaultConversationAnswerRepository.tktInsDefaultConversationAnswer(tktDefaultConversationAnswer));
    }


    @Operation(
            summary = "Update defaultConversationAnswer",
            description = "<code>Update</code> <i><b>defaultConversationAnswer<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{answerID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktDefaultConversationAnswer> defaultConversationAnswerUpdSP(
            @PathVariable BigDecimal answerID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
//                    (
//                    content = {
//                            @Content(
//                                    schema = @Schema(
//                                            example =
//                                                    "{\n" +
//                                                            "  \"priorityID\": 10000001,\n" +
//                                                            "  \"priorityName\": \"name\"\n" +
//                                                            "}"
//                                    )
//                            )
//                    }
//            )
            @RequestBody TktDefaultConversationAnswer tktDefaultConversationAnswer) {
        return ResponseEntity.ok(tktDefaultConversationAnswerRepository.tktUpdDefaultConversationAnswer(answerID, tktDefaultConversationAnswer));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete defaultConversationAnswer",
            description = "<code>Delete</code> <i><b>defaultConversationAnswer<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{answerID}", produces = "application/json")
    public ResponseEntity<?> defaultConversationAnswerDelSP(
            @PathVariable BigDecimal answerID) {
        tktDefaultConversationAnswerRepository.tktDelDefaultConversationAnswer(answerID);
        return ResponseEntity.noContent().build();
    }


    @Operation(
            summary = "Retrieve defaultConversationAnswer meta",
            description = "<code>Retrieve</code> <i><b>defaultConversationAnswer</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(tktDefaultConversationAnswerRepository.meta());
    }
    //</editor-fold>
}
