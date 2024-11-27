package com.tarazgroup.tws.controller.crm;

import com.tarazgroup.tws.dao.crm.CrmCommentRepository;
import com.tarazgroup.tws.model.crm.CrmComment;
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
 * 10/16/22
 *
 * @author Erfan Akhavan
 */

@RestController
@RequestMapping("crm/comments")
@Validated
@Tag(name = "Comment")
public class CrmCommentController {

    private final CrmCommentRepository crmCommentRepository;

    public CrmCommentController(CrmCommentRepository crmCommentRepository) {
        this.crmCommentRepository = crmCommentRepository;
    }

    @Operation(
            summary = "Retrieve all comments",
            description = "<code>Retrieve</code> all <i><b>comments</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<CrmComment>> comments(@ParameterObject CrmComment crmComment) {
        return ResponseEntity.ok().body(crmCommentRepository.crmShowComments(crmComment));
    }


    @Operation(
            summary = "Retrieve all comments path variable",
            description = "<code>Retrieve</code> all <i><b>comments with path variable</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(path = "/{formID}/{recordID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<List<CrmComment>> commentsWithPathVariable(@PathVariable BigDecimal formID, @PathVariable BigDecimal recordID, @ParameterObject CrmComment crmComment) {
        return ResponseEntity.ok().body(crmCommentRepository.crmShowCommentsWithPathVariable(formID, recordID, crmComment));
    }


    @Operation(
            summary = "Retrieve specific comment",
            description = "<code>Retrieve</code> specific <i><b>comment</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{commentID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<CrmComment> comment(@PathVariable BigDecimal commentID) {
        return ResponseEntity.ok().body(crmCommentRepository.crmShowCommentsByID(commentID));
    }


    @Operation(
            summary = "Create comment",
            description = "<code>Create</code> <i><b>comment</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(value = "/{formID}/{recordID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmComment> commentInsSP(@PathVariable BigDecimal formID, @PathVariable BigDecimal recordID,
                                                   @Valid
                                                   @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                           content = @Content(
                                                                   schema = @Schema(
                                                                           example = "{\n" +
                                                                                   "  \"commentDesc\": \"Testing from Swagger\",\n" +
                                                                                   "  \"refCommentID\": 0\n" +
                                                                                   "}"
                                                                   )
                                                           )
                                                   )
                                                   @RequestBody CrmComment crmComment

    ) {
        return ResponseEntity.ok(crmCommentRepository.crmInsComment(crmComment, formID, recordID));
    }


    @Operation(
            summary = "Update comment",
            description = "<code>Update</code> <i><b>comment<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{commentID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmComment> commentUpdSP(@PathVariable BigDecimal commentID,
                                                   @Valid
                                                   @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                           content = @Content(
                                                                   schema = @Schema(
                                                                           example = ""
                                                                   )
                                                           )
                                                   )
                                                   @RequestBody CrmComment crmComment) {
        return ResponseEntity.ok(crmCommentRepository.crmUpdComment(commentID, crmComment));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete comment",
            description = "<code>Delete</code> <i><b>comment<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{commentID}", produces = "application/json")
    public ResponseEntity<?> commentDelSP(@PathVariable BigDecimal commentID) {
        crmCommentRepository.crmDelComment(commentID);
        return ResponseEntity.noContent().build();
    }


    @Operation(
            summary = "Change comment toggle status",
            description = "<code>Change</code> comment toggle <i><b>status</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/togglestatus/{commentID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<CrmComment> commentToggleStatus(@PathVariable BigDecimal commentID) {
        return ResponseEntity.ok().body(crmCommentRepository.crmCommentToggleStatus(commentID));
    }


    @Operation(
            summary = "Retrieve Form meta",
            description = "<code>Retrieve</code> <i><b>Form</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(crmCommentRepository.meta());
    }


}
