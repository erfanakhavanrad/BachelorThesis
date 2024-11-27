package com.tarazgroup.tws.controller.pub;

import com.tarazgroup.tws.dao.pub.PubMonthRepository;
import com.tarazgroup.tws.dao.pub.PubThemeRepository;
import com.tarazgroup.tws.model.pub.PubMonth;
import com.tarazgroup.tws.model.pub.PubTheme;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

    @RestController
    @RequestMapping("pub/themes")
    @Validated
    @Tag(name = "Theme")
    public class PubThemeController {
        final private PubThemeRepository pubThemeRepository;

        public PubThemeController(PubThemeRepository pubThemeRepository) {
            this.pubThemeRepository = pubThemeRepository;
        }

        //<editor-fold defaultstate="collapsed" desc="CRUD SP">
        @Operation(
                summary = "Retrieve all Themes",
                description = "<code>Retrieve</code> all <i><b>Themes</b></i>",
                security = @SecurityRequirement(name = "bearerAuth")
        )
        @GetMapping(produces = "application/json;charset=utf-8")
        public ResponseEntity<List<PubTheme>> themes(@ParameterObject PubTheme pubTheme) {
            return ResponseEntity
                    .ok()
                    .body(pubThemeRepository.pubShowTheme(pubTheme));
        }
        @Operation(
                summary = "Retrieve meta of Themes",
                security = @SecurityRequirement(name = "bearerAuth")
        )
        @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
        public ResponseEntity<Meta> meta() {
            return ResponseEntity
                    .ok()
                    .body(pubThemeRepository.meta());
        }

    }
