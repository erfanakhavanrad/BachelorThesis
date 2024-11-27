package com.tarazgroup.tws.controller.tkt;

import com.tarazgroup.tws.dao.tkt.TktLanguageRepository;
import com.tarazgroup.tws.model.tkt.TktLanguage;
import com.tarazgroup.tws.util.global.responseheader.Meta;
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

/***
 * @author A.Farahani
 * @date Mar-09, 2022
 ***/
@RestController
@RequestMapping("tkt/languages")
@Validated
@Tag(name = "Language")

public class TktLanguageController {
    final private TktLanguageRepository tktLanguageRepository;

    public TktLanguageController(TktLanguageRepository tktLanguageRepository) {
        this.tktLanguageRepository = tktLanguageRepository;
    }

    @Operation(
            summary = "Retrieve all languages",
            description = "<code>Retrieve</code> all <i><b>languages</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<TktLanguage>> languages(@ParameterObject TktLanguage tktLanguage) {
        return ResponseEntity
                .ok()
                .body(tktLanguageRepository.tktShowLanguage(tktLanguage));
    }

    @Operation(
            summary = "Retrieve specific language",
            description = "<code>Retrieve</code> specific <i><b>language</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{languageID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<TktLanguage> language(@PathVariable BigDecimal languageID) {
        return ResponseEntity
                .ok()
                .body(tktLanguageRepository.tktShowLanguageByID(languageID));
    }

    @Operation(
            summary = "Retrieve language meta",
            description = "<code>Retrieve</code> <i><b>language</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(tktLanguageRepository.meta());
    }

}
