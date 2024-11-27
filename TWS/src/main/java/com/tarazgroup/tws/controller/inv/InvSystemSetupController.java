//package com.tarazgroup.tws.controller.inv;
//
//import com.tarazgroup.tws.dao.inv.InvSystemSetupRepository;
//import com.tarazgroup.tws.model.inv.InvSystemSetup;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.security.SecurityRequirement;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import org.springdoc.api.annotations.ParameterObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//
///**
// * @author A.Farahani
// */
//
//@Validated
//@RestController
//@RequestMapping(value = "/inv/systemsetups")
//@Tag(name = "SystemSetup")
//public class InvSystemSetupController {
//    final private InvSystemSetupRepository invSystemSetupRepository;
//
//    @Autowired
//    public InvSystemSetupController(InvSystemSetupRepository invSystemSetupRepository) {
//        this.invSystemSetupRepository = invSystemSetupRepository;
//    }
//
//    @Operation(
//            summary = "Retrieve all systemSetups",
//            description = "<code>Retrieve</code> all <i><b>systemSetups</b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @GetMapping(produces = "application/json;charset=utf-8")
//    public ResponseEntity<List<InvSystemSetup>> systemSetups(
//            @ParameterObject
//            InvSystemSetup invSystemSetup
//    ) {
//        return ResponseEntity.ok(invSystemSetupRepository.invShowSystemSetup(invSystemSetup));
//    }
//
//    @Operation(
//            summary = "Create systemSetup",
//            description = "<code>Create</code> <i><b>systemSetup</b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @PostMapping(produces = "application/json", consumes = "application/json")
//    public ResponseEntity<InvSystemSetup> systemSetupInsSP(
//            @Valid
//            @io.swagger.v3.oas.annotations.parameters.RequestBody
//            @RequestBody InvSystemSetup invSystemSetup
//    ) {
//        return ResponseEntity.ok(invSystemSetupRepository.invInsSystemSetup(invSystemSetup));
//    }
//}
