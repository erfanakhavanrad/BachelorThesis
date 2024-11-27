package com.tarazgroup.tws.controller.acc;

import com.tarazgroup.tws.dao.acc.AccPerComTypeRepository;
import com.tarazgroup.tws.model.acc.AccPerComType;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("acc/percomtypes")

@Tag(name = "PerComType")
public class AccPerComTypeController {

    private final AccPerComTypeRepository accPerComTypeRepository;

    AccPerComTypeController(AccPerComTypeRepository accPerComTypeRepository) {
        this.accPerComTypeRepository = accPerComTypeRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="SP">
    @Operation(
            summary = "Retrieve all perComTypes",
            description = "<code>Retrieve</code> all <i><b>perComTypes</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<AccPerComType>> AccPerComType(@ParameterObject AccPerComType accPerComType) {
        return ResponseEntity.ok(accPerComTypeRepository.accShowPerComtype(accPerComType));
    }


    @Operation(
            summary = "Retrieve perComTypes meta",
            description = "<code>Retrieve</code> <i><b>perComTypes</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity.ok().body(accPerComTypeRepository.meta());
    }
    //</editor-fold>


//    //<editor-fold defaultstate="collapsed" desc="h">
//    @GetMapping(value = "/h", produces = "application/json")
//    public ResponseEntity<Iterable<AccPerComType>> AccPerComTypeH() {
//        return ResponseEntity.ok(accPerComTypeRepository.findAll());
//    }
//    //</editor-fold>

}
