package com.tarazgroup.tws.controller.acc;

import com.tarazgroup.tws.dao.acc.AccTafsiliKindRepository;
import com.tarazgroup.tws.model.acc.AccTafsiliKind;
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
 * @author A.Farahani
 */
@RestController
@RequestMapping("acc/tafsilikinds")
@Validated
@Tag(name = "TafsiliKind")

// pageNumber = 1
// recordCount = 10

public class AccTafsiliKindController {
    final private AccTafsiliKindRepository accTafsiliKindRepository;
    public AccTafsiliKindController(AccTafsiliKindRepository accTafsiliKindRepository) {
        this.accTafsiliKindRepository = accTafsiliKindRepository;
    }

    @Operation(
            summary = "Retrieve all tafsiliKinds",
            description = "<code>Retrieve</code> all <i><b>tafsiliKinds</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<AccTafsiliKind>> tafsiliKinds(@ParameterObject AccTafsiliKind accTafsiliKind) {
        return ResponseEntity.ok(accTafsiliKindRepository.accShowTafsiliKind(accTafsiliKind));
    }

    @Operation(
            summary = "Retrieve specific tafsiliKind",
            description = "<code>Retrieve</code> specific <i><b>tafsiliType</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{tafsiliKindID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<AccTafsiliKind> tafsiliKindByID(@PathVariable BigDecimal tafsiliKindID) {
        return ResponseEntity.ok().body(accTafsiliKindRepository.accShowTafsiliKindByID(tafsiliKindID));
    }
}
