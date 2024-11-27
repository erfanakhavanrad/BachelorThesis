package com.tarazgroup.tws.controller.crm;


import com.tarazgroup.tws.dao.crm.CrmQKeyExecuteQueryRepository;
import com.tarazgroup.tws.dao.crm.CrmQKeyMapFieldRepository;
import com.tarazgroup.tws.model.crm.CrmQKeyMapField;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */

@Validated
@RequestMapping("crm/qkeyexecutequery")
@RestController
@Tag(name = "QKeyExecuteQuery")
public class CrmQKeyExecuteQueryController {

    final CrmQKeyMapFieldRepository crmQKeyMapFieldRepository;

    final private CrmQKeyExecuteQueryRepository crmQKeyExecuteQueryRepository;

    public CrmQKeyExecuteQueryController(CrmQKeyExecuteQueryRepository crmQKeyExecuteQueryRepository, CrmQKeyMapFieldRepository crmQKeyMapFieldRepository) {
        this.crmQKeyExecuteQueryRepository = crmQKeyExecuteQueryRepository;
        this.crmQKeyMapFieldRepository = crmQKeyMapFieldRepository;
    }

    @Operation(
            summary = "Retrieve QKey Query",
            description = "<code>Retrieve</code> QKey <i><b>Query</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
            /*
{
  "fieldID": 10000003,
  "pageNumber": 1,
  "recordCount": 2,
"CustomQKeyCode": 1
}
             */
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<Map<String, Object>>> qKeyExecuteQuery(@RequestParam Map<String, String> params) {
        return ResponseEntity.ok(crmQKeyExecuteQueryRepository.qKeyExecuteQuery(params));
//        @RequestParam BigDecimal fieldID,@ParameterObject CrmQKeyExecuteQuery crmQKeyExecuteQuery
    }

    @Operation(
            summary = "Retrieve qkeys meta",
            description = "<code>Retrieve</code> <i><b>qkeys</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta/{fieldID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta(@PathVariable BigDecimal fieldID) {
        CrmQKeyMapField crmQKeyMapField = crmQKeyMapFieldRepository.crmShowQKeyMapFieldByFieldID(fieldID);
        return ResponseEntity
                .ok()
                .body(crmQKeyExecuteQueryRepository.meta(crmQKeyMapField));
    }
}
