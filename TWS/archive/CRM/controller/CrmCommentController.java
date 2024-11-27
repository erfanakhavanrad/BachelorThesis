package com.tarazgroup.tws.controller.crm;


import com.tarazgroup.tws.dao.crm.CrmCommentRepository;
import com.tarazgroup.tws.model.crm.CrmAudience;
import com.tarazgroup.tws.model.crm.CrmComment;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

@Validated
@RequestMapping("crm/comments")
@RestController
@Tag(name = "Comment")
public class CrmCommentController {

    final private CrmCommentRepository crmCommentRepository;

    public CrmCommentController(CrmCommentRepository crmCommentRepository) {
        this.crmCommentRepository = crmCommentRepository;
    }

    @Operation(
            summary = "Retrieve all comments",
            description = "<code>Retrieve</code> all <i><b>comments</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<CrmComment>> commentsShow(@RequestParam Map<String, String> params) {
        return ResponseEntity.ok(crmCommentRepository.crmShowComment(params));
    }

    @Operation(
            summary = "Retrieve comment meta",
            description = "<code>Retrieve</code> <i><b>comment</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(crmCommentRepository.meta());
    }

    @Operation(
            summary = "Retrieve specific comment",
            description = "<code>Retrieve</code> specific <i><b>comment</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{commentID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<CrmComment> commentShow(@PathVariable BigDecimal commentID) {
        return ResponseEntity
                .ok()
                .body(crmCommentRepository.crmShowCommentByID(commentID));
    }

    @Operation(
            summary = "Create comment",
            description = "<code>Create</code> <i><b>comment</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmComment> commentInsert(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody CrmComment crmComment
    ) {
        return ResponseEntity.ok(crmCommentRepository.crmInsComment(crmComment));
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
    public ResponseEntity<?> commentDelete(
            @PathVariable BigDecimal commentID) {
        crmCommentRepository.crmDelComment(commentID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Update comment",
            description = "<code>Update</code> <i><b>comment<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{commentID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmComment> commentUpdate(
            @PathVariable BigDecimal commentID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody CrmComment crmComment) {
        return ResponseEntity.ok(crmCommentRepository.crmUpdComment(commentID, crmComment));
    }

    @Operation(
            summary = "Export all forms to Excel",
            description = "<code>Export</code> all <i><b>forms</b></i> to <code>Excel</code>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/excel")
    public ResponseEntity<InputStreamResource> exportToExcel(@ParameterObject CrmComment crmComment) {
        return ResponseEntity
                .ok()
                .body(crmCommentRepository.excel(crmComment));
    }

}
