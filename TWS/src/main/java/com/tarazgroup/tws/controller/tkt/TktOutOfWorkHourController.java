package com.tarazgroup.tws.controller.tkt;

import com.tarazgroup.tws.dao.tkt.TktOutOfWorkHourRepository;
import com.tarazgroup.tws.model.acc.AccBank;
import com.tarazgroup.tws.model.inv.InvActuary;
import com.tarazgroup.tws.model.tkt.TktOutOfWorkHour;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 5/30/22
 *
 * @author Erfan Akhavan
 */

@Validated
@RequestMapping("tkt/outofworkhour")
@RestController
@Tag(name = "OutOfWorkHour")
public class TktOutOfWorkHourController {

    public TktOutOfWorkHourController(TktOutOfWorkHourRepository tktOutOfWorkHourRepository) {
        this.tktOutOfWorkHourRepository = tktOutOfWorkHourRepository;
    }

    private final TktOutOfWorkHourRepository tktOutOfWorkHourRepository;


    @Operation(
            summary = "Retrieve OutOfWorkHour",
            description = "<code>Retrieve</code> <i><b>OutOfWorkHour</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<TktOutOfWorkHour>> outOfWorkHours() {
        return ResponseEntity.ok(tktOutOfWorkHourRepository.tktShowOutOfWorkHour());
    }

}
