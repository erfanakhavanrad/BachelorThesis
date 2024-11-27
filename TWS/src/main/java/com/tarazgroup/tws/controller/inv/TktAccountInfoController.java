package com.tarazgroup.tws.controller.inv;

import com.tarazgroup.tws.dao.tkt.TktAccountInfoRepository;
import com.tarazgroup.tws.model.tkt.TktAccountInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

/**
 * 7/20/22
 *
 * @author Erfan Akhavan
 */

@RestController
@RequestMapping("tkt/accountinfo")
@Validated
@Tag(name = "AccountInfo")
public class TktAccountInfoController {

    private final TktAccountInfoRepository tktAccountInfoRepository;

    public TktAccountInfoController(TktAccountInfoRepository tktAccountInfoRepository) {
        this.tktAccountInfoRepository = tktAccountInfoRepository;
    }


    @Operation(
            summary = "Retrieve all TktAccountInfo",
            description = "<code>Retrieve</code> all <i><b>TktAccountInfo</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<TktAccountInfo>> accountInfo(@ParameterObject TktAccountInfo tktAccountInfo) {
        return ResponseEntity.ok(tktAccountInfoRepository.tktShowAccountInfo(tktAccountInfo));
    }

    //    GET by ID
    @Operation(
            summary = "Retrieve specific TktAccountInfo",
            description = "<code>Retrieve</code> specific <i><b>TktAccountInfo</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{accountInfoID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<TktAccountInfo> oneAccountInfo(@PathVariable BigDecimal accountInfoID) {
        return ResponseEntity.ok().body(tktAccountInfoRepository.tktShowAccountInfoID(accountInfoID));
    }


    @Operation(
            summary = "Create TktAccountInfo",
            description = "<code>Create</code> <i><b>TktAccountInfo</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktAccountInfo> accountInfoInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(
                    schema = @Schema(
                            example = "{\n" +
                                    "  \"organizationID\": 10000002,\n" +
                                    "  \"licenseID\": 10000004,\n" +
                                    "  \"supportExpirationDate\": \"2023-06-14 09:39:38.003\",\n" +
                                    "  \"licenseExpirationDate\": \"2023-06-14 09:39:38.003\",\n" +
                                    "  \"registeredURL\": \"www.customersite.com\"\n" +
                                    "}"
                    )
            ))
            @RequestBody TktAccountInfo tktAccountInfo
    ) {
        return ResponseEntity.ok(tktAccountInfoRepository.tktInsAccountInfo(tktAccountInfo));
    }


    @Operation(
            summary = "Update DecToken",
            description = "<code>Update</code> <i><b>DecToken<b></i>"
//            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(path = "/token")
    public ResponseEntity<String> decTokenUpdSP(@RequestParam  String token) {
        return ResponseEntity.ok(tktAccountInfoRepository.tktDecToken(token));
    }
}
