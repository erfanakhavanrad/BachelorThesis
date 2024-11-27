//package com.tarazgroup.tws.controller.inv;
//
//import com.tarazgroup.tws.dao.inv.InvGroupImageRepository;
//import com.tarazgroup.tws.model.inv.InvGroupImage;
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
///**
// * @author A.Farahani
// * Dec-20, 2021
// */
//@RestController
//@RequestMapping("inv/groupimages")
//@Validated
//@Tag(name = "GroupImage")
//public class InvGroupImageController {
//    final private InvGroupImageRepository invGroupImageRepository;
//
//    public InvGroupImageController(InvGroupImageRepository invGroupImageRepository) {
//        this.invGroupImageRepository = invGroupImageRepository;
//    }
//
//    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
//    @Operation(
//            summary = "Retrieve all groupimages",
//            description = "<code>Retrieve</code> all <i><b>groupimages</b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @GetMapping(produces = "application/json;charset=utf-8")
//    public ResponseEntity<List<InvGroupImage>> groupimages(@ParameterObject InvGroupImage invGroupImage) {
//        return ResponseEntity
//                .ok()
//                .body(invGroupImageRepository.invShowGroupImage(invGroupImage));
//    }
//
//    @Operation(
//            summary = "Retrieve specific groupimage",
//            description = "<code>Retrieve</code> specific <i><b>groupimage</b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @GetMapping(value = "/{groupID}", produces = "application/json;charset=utf-8")
//    public ResponseEntity<InvGroupImage> groupimage(@PathVariable BigDecimal groupID) {
//        return ResponseEntity
//                .ok()
//                .body(invGroupImageRepository.invShowGroupImageByID(groupID));
//    }
//
//    @Operation(
//            summary = "Create groupimage",
//            description = "<code>Create</code> <i><b>groupimage</b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @PostMapping(produces = "application/json", consumes = "application/json")
//    public ResponseEntity<InvGroupImage> groupimageInsSP(
//            @Valid
//            @io.swagger.v3.oas.annotations.parameters.RequestBody
//            @RequestBody InvGroupImage invGroupImage
//    ) {
//        return ResponseEntity.ok(invGroupImageRepository.invInsGroupImage(invGroupImage));
//    }
//
//
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "204", description = "deleted successfully.")
//    })
//    @ResponseStatus(value = HttpStatus.NO_CONTENT)
//    @Operation(
//            summary = "Delete groupimage",
//            description = "<code>Delete</code> <i><b>groupimage<b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @DeleteMapping(value = "/{groupID}", produces = "application/json")
//    public ResponseEntity<?> groupimageDelSP(
//            @PathVariable BigDecimal groupID) {
//        invGroupImageRepository.invDelGroupImage(groupID);
//        return ResponseEntity.noContent().build();
//    }
//    //</editor-fold>
//}
