package com.tarazgroup.tws.controller.tkt;

import com.tarazgroup.tws.dao.tkt.TktProfileRepository;
import com.tarazgroup.tws.model.tkt.TktProfile;
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
import java.util.List;

/***
 * @author A.Farahani
 * @date Mar-12, 2022
 ***/
@RestController
@RequestMapping("tkt/profile")
@Validated
@Tag(name = "Profile")
public class TktProfileController {
    final private TktProfileRepository tktProfileRepository;

    public TktProfileController(TktProfileRepository tktProfileRepository) {
        this.tktProfileRepository = tktProfileRepository;
    }

    @Operation(
            summary = "Retrieve all profiles",
            description = "<code>Retrieve</code> all <i><b>profiles</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<TktProfile>> profiles(@ParameterObject TktProfile tktProfile) {
        return ResponseEntity
                .ok()
                .body(tktProfileRepository.tktShowProfile(tktProfile));
    }

    @Operation(
            summary = "Retrieve specific profile",
            description = "<code>Retrieve</code> specific <i><b>profile</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/userID", produces = "application/json;charset=utf-8")
    public ResponseEntity<TktProfile> profile() {
        return ResponseEntity
                .ok()
                .body(tktProfileRepository.tktShowProfileByID());
    }

    @Operation(
            summary = "Update profile",
            description = "<code>Update</code> <i><b>profile<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(/*value = "/{userID}",*/ produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktProfile> profileUpdSP(
//            @PathVariable BigDecimal userID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            schema = @Schema(
                                    example = "{\n" +
                                            "  \"userID\": 10000001,\n" +
                                            "  \"userLoginName\": \"email\",\n" +
                                            "  \"userMobileNumber\": null,\n" +
                                            "  \"anyDeskID\": null,\n" +
                                            "  \"userImage\": null,\n" +
                                            "  \"staffSignature\": \"customSign.\",\n" +
                                            "  \"creatorID\": 10000000,\n" +
                                            "  \"createDate\": \"2022-06-28T09:01:48.980+00:00\",\n" +
                                            "  \"modifierID\": 10000000,\n" +
                                            "  \"modifyDate\": \"2022-06-28T09:01:48.980+00:00\",\n" +
                                            "  \"serverID\": 1\n" +
                                            "}"
                            )
                    )
            )
            @RequestBody TktProfile tktProfile) {
        return ResponseEntity.ok(tktProfileRepository.tktUpdProfile(tktProfile));
    }
}
