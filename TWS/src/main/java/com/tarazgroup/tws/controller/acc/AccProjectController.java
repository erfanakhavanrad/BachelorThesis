package com.tarazgroup.tws.controller.acc;

import com.tarazgroup.tws.dao.acc.AccProjectRepository;
import com.tarazgroup.tws.model.acc.AccProject;
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
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */

@RestController
@RequestMapping("acc/projects")
@Validated

@Tag(name = "Project")
public class AccProjectController {

    final private AccProjectRepository accProjectRepository;

    public AccProjectController(AccProjectRepository accProjectRepository) {
        this.accProjectRepository = accProjectRepository;
    }

    @Operation(
            summary = "Retrieve all projects",
            description = "<code>Retrieve</code> all <i><b>projects</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<AccProject>> projects(@ParameterObject AccProject accProject) {
//        try {
//            TimeUnit.SECONDS.sleep(115);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return ResponseEntity.ok(accProjectRepository.accShowProject(accProject));
    }

    @Operation(
            summary = "Retrieve project meta",
            description = "<code>Retrieve</code> <i><b>project</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
        return ResponseEntity
                .ok()
                .body(accProjectRepository.meta());
    }

    @Operation(
            summary = "Retrieve all projects",
            description = "<code>Retrieve</code> all <i><b>projects</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<AccProject> projectInsSP(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
                    @Content(
                            schema = @Schema(
                                    example = "{\n" +
                                            "   \"projectCode\":\"781\",\n" +
                                            "   \"projectDesc\":\" سازی\",\n" +
                                            "   \"tafsiliTypeID\":10000016\n" +
                                            "}"
                            )
                    )
            })
            @Valid @RequestBody AccProject accProject) {

        return ResponseEntity.ok(accProjectRepository.accInsProject(accProject));
    }

    @Operation(
            summary = "Retrieve specific project",
            description = "<code>Retrieve</code> specific <i><b>project</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{projectID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<AccProject> project(@PathVariable BigDecimal projectID) {
        return ResponseEntity.ok(accProjectRepository.accShowProjectByID(projectID));
    }

    @Operation(
            summary = "Update project",
            description = "<code>Update</code> <i><b>project<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{projectID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<AccProject> projectUpdSP(
            @PathVariable BigDecimal projectID,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
                    @Content(
                            schema = @Schema(
                                    example = "{\n" +
                                            "   \"projectCode\":\"781\",\n" +
                                            "   \"projectDesc\":\" سازی\",\n" +
                                            "   \"tafsiliTypeID\":10000016\n" +
                                            "}"
                            )
                    )
            })
            @RequestBody @Valid AccProject accProject
    ) {
        return ResponseEntity.ok(accProjectRepository.accUpdProject(projectID, accProject));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete project",
            description = "<code>Delete</code> <i><b>project<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{projectID}", produces = "application/json")
    public ResponseEntity<?> projectDelSP(@PathVariable BigDecimal projectID) {
        accProjectRepository.accDelProject(projectID);
        return ResponseEntity.noContent().build();
    }
}
