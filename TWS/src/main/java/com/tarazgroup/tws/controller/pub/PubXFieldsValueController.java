package com.tarazgroup.tws.controller.pub;

import com.tarazgroup.tws.dao.pub.PubXFieldsValueRepository;
import com.tarazgroup.tws.model.pub.PubXFieldsValue;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author salman majidi
 * @since 2.0.0
 */

@RestController
@RequestMapping("pub/xfieldsvalues")
@Validated
@Tag(name = "XFieldsValue")
public class PubXFieldsValueController {

    private final PubXFieldsValueRepository pubXFieldsValueRepository;

    public PubXFieldsValueController(PubXFieldsValueRepository pubXFieldsValueRepository) {
        this.pubXFieldsValueRepository = pubXFieldsValueRepository;
    }

    @Operation(
            summary = "Retrieve all XFieldsValue",
            description = "<code>Retrieve</code> all <i><b>XFieldsValue</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<PubXFieldsValue>> xFieldsValue(@RequestParam int fieldNumber, @RequestParam String tableName) {
        return ResponseEntity.ok(pubXFieldsValueRepository.pubShowXFieldsValue(fieldNumber, tableName));
    }

    @Operation(
            summary = "Retrieve XFieldsValue meta",
            description = "<code>Retrieve</code> <i><b>XFieldsValue</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> goodsMeta() {
        return ResponseEntity
                .ok()
                .body(pubXFieldsValueRepository.meta());
    }
}
