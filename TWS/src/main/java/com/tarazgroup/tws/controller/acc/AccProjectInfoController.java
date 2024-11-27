//package com.tarazgroup.tws.controller.acc;
//
//import com.tarazgroup.tws.dao.acc.AccProjectInfoRepository;
//import com.tarazgroup.tws.model.acc.AccProjectInfo;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import io.swagger.v3.oas.annotations.security.SecurityRequirement;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import org.springdoc.api.annotations.ParameterObject;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.math.BigDecimal;
//import java.util.List;
//
///***
// * @author A.Farahani
// * @date Jan-17, 2022
// ***/
// TODO: 1/18/22 insupd

//@RestController
//@RequestMapping("acc/projectinfos")
//@Validated
//@Tag(name = "ProjectInfo")
//public class AccProjectInfoController {
//    final private AccProjectInfoRepository accProjectInfoRepository;
//
//    public AccProjectInfoController(AccProjectInfoRepository accProjectInfoRepository) {
//        this.accProjectInfoRepository = accProjectInfoRepository;
//    }
//
//    @Operation(
//            summary = "Retrieve all projectInfos",
//            description = "<code>Retrieve</code> all <i><b>projectInfos</b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @GetMapping(produces = "application/json;charset=utf-8")
//    public ResponseEntity<List<AccProjectInfo>> projectInfos(@ParameterObject AccProjectInfo accProjectInfo) {
//        return ResponseEntity
//                .ok()
//                .body(accProjectInfoRepository.accShowProjectInfo(accProjectInfo));
//    }
//
//    @Operation(
//            summary = "Retrieve specific projectInfo",
//            description = "<code>Retrieve</code> specific <i><b>projectInfo</b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @GetMapping(value = "/{projectid}", produces = "application/json;charset=utf-8")
//    public ResponseEntity<AccProjectInfo> projectInfo(@PathVariable BigDecimal projectid) {
//        return ResponseEntity
//                .ok()
//                .body(accProjectInfoRepository.accShowProjectInfoByID(projectid));
//    }
//
//    @Operation(
//            summary = "Create projectInfo",
//            description = "<code>Create</code> <i><b>projectInfo</b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @PostMapping(produces = "application/json", consumes = "application/json")
//    public ResponseEntity<AccProjectInfo> projectInfoInsSP(
//            @Valid
//            @io.swagger.v3.oas.annotations.parameters.RequestBody
//            @RequestBody AccProjectInfo accProjectInfo
//    ) {
//        return ResponseEntity.ok(accProjectInfoRepository.accInsProjectInfo(accProjectInfo));
//    }
//
//    @Operation(
//            summary = "Update projectInfo",
//            description = "<code>Update</code> <i><b>projectInfo<b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @PutMapping(value = "/{projectId}", produces = "application/json", consumes = "application/json")
//    public ResponseEntity<AccProjectInfo> projectInfoUpdSP(
//            @PathVariable BigDecimal projectId,
//            @Valid
//            @io.swagger.v3.oas.annotations.parameters.RequestBody
//            @RequestBody AccProjectInfo accProjectInfo) {
//        return ResponseEntity.ok(accProjectInfoRepository.accUpdProjectInfo(projectId, accProjectInfo));
//    }
//
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "204", description = "deleted successfully.")
//    })
//    @ResponseStatus(value = HttpStatus.NO_CONTENT)
//    @Operation(
//            summary = "Delete projectInfo",
//            description = "<code>Delete</code> <i><b>projectInfo<b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @DeleteMapping(value = "/{projectId}", produces = "application/json")
//    public ResponseEntity<?> projectInfoDelSP(
//            @PathVariable BigDecimal projectid) {
//        accProjectInfoRepository.accDelProjectInfo(projectid);
//        return ResponseEntity.noContent().build();
//    }
//}
