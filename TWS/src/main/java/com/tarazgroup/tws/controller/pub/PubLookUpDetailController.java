package com.tarazgroup.tws.controller.pub;


import com.tarazgroup.tws.dao.pub.PubLookUpDetailRepository;
import com.tarazgroup.tws.dao.pub.PubSystemsRepository;
import com.tarazgroup.tws.model.pub.PubLookUpDetail;
import com.tarazgroup.tws.model.pub.PubSystems;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;


/**
 * @author Salman Majidi
 * @since 2.0.0
 */

@Validated
@RequestMapping("pub/lookupdetails")
@RestController
@Tag(name = "LookUpDetail")
public class PubLookUpDetailController {

    private final PubLookUpDetailRepository pubLookUpDetailRepository;
    private final PubSystemsRepository pubSystemsRepository;

    public PubLookUpDetailController(PubLookUpDetailRepository pubLookUpDetailRepository, PubSystemsRepository pubSystemsRepository) {
        this.pubLookUpDetailRepository = pubLookUpDetailRepository;
        this.pubSystemsRepository = pubSystemsRepository;
    }


    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all lookUpDetails",
            description = "<code>Retrieve</code> all <i><b>lookUpDetails</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<PubLookUpDetail>> pubLookUpDetails(@ParameterObject PubLookUpDetail pubLookUpDetail) {
        return ResponseEntity.ok(pubLookUpDetailRepository.pubShowLookUpDetail(pubLookUpDetail));
    }

    @Operation(
            summary = "Retrieve specific lookUpDetail",
            description = "<code>Retrieve</code> specific <i><b>lookUpDetail</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{lookUpID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<PubLookUpDetail> pubLookUpDetail(
            @PathVariable BigDecimal lookUpID
    ) {
        return ResponseEntity.ok(pubLookUpDetailRepository.pubShowLookUpDetailByID(lookUpID));
    }


    @Operation(
            summary = "Retrieve system of this lookUpDetail",
            description = "<code>Retrieve</code> <i><b>system</b></i> of this <i><b>lookUpDetail</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{lookUpID}/system", produces = "application/json;charset=utf-8")
    public ResponseEntity<PubSystems> system(
            @PathVariable BigDecimal lookUpID
    ) {
        PubSystems temp = new PubSystems();
        temp.setSystemID(pubLookUpDetailRepository.pubShowLookUpDetailByID(lookUpID).getSystemID());
        return ResponseEntity.ok(pubSystemsRepository.pubShowSystems(temp).get(0));
    }

    @Operation(
            summary = "Retrieve all paymentWays",
            description = "<code>Retrieve</code> all <i><b>paymentWays</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/paymentWay",produces = "application/json;charset=utf-8")
    public ResponseEntity<List<PubLookUpDetail>> paymentWays(){
        return ResponseEntity.ok(pubLookUpDetailRepository.showPaymentWay());
    }
    //</editor-fold>


    @Operation(
            summary = "Retrieve lookUpDetail meta",
            description = "<code>Retrieve</code> <i><b>lookUpDetail</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta",produces = "application/json")
    public ResponseEntity<?> meta(){
        return ResponseEntity.ok().body(pubLookUpDetailRepository.meta());
    }
}
