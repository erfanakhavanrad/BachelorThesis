package com.tarazgroup.tws.controller.pub;

import com.tarazgroup.tws.dao.pub.PubUsersRepository;
import com.tarazgroup.tws.dto.pub.PubUsersDto;
import com.tarazgroup.tws.model.pub.PubUsers;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.security.JWTTokenUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
@RestController
@RequestMapping("pub/users")
@Validated

@Tag(name = "Users")
public class PubUsersController {

    private final PubUsersRepository usersRepository;

    private final JWTTokenUtil jwtTokenUtil;

    public PubUsersController(PubUsersRepository usersRepository, JWTTokenUtil jwtTokenUtil) {
        this.usersRepository = usersRepository;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Operation(
            summary = "Retrieve all users",
            description = "<code>Retrieve</code> all <i><b>users</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<PubUsers>> pubUsers(@ParameterObject PubUsers pubUsers) {
        return ResponseEntity.ok(usersRepository.pubShowUsers(pubUsers));
    }


    @Operation(
            summary = "Update specific user activeYearID",
            description = "<code>Update specific </code> <i><b>user activeYearID<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{activeYearID}")
    public PubUsers pubUpdUserActiveYear(
            @PathVariable BigDecimal activeYearID
    ) {
        return usersRepository.pubUpdUserActiveYearByID(activeYearID);
    }

    //    @PutMapping(value = "/{userID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<PubUsers> pubUpdUsers(
            @PathVariable BigDecimal userID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody PubUsersDto pubUsersDto
    ) {
        return null;
//        return ResponseEntity.ok(usersRepository.pubUpdUsers(
//                userID,
//                userGroupID,
//                userLoginName,
//                userPassWord,
//                resetPassWord,
//                isActive,
//                activeYearID,
//                isBackUpOperator,
//                standByTime,
//                deleteLogDays,
//                isFullSearch,
//                defaultServerID,
//                activeMonthID,
//                androidUser,
//                androidPass,
//                grid1Color,
//                grid2Color,
//                gridFont,
//                colorType,
//                isChangeColor,
//                isDelGridConfig,
//                isMasterUser,
//                isRecovery,
//                macAddresses,
//                isPopUp,
//                calendarType,
//                webUserType,
//                isNotOtherInfoByDefault,
//                themeStyle,
//                alertPosition,
//                alertStyle));
    }

    @Operation(
            summary = "Retrieve users meta for Refer To",
            description = "<code>Retrieve</code> <i><b>users</b></i> meta for Refer To",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/metareferto", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> metaReferTo() {
        return ResponseEntity
                .ok()
                .body(usersRepository.metaReferTo());
    }

    @Operation(
            summary = "Retrieve Records Count",
            description = "<code>Retrieve</code> Records <i><b>Count</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/count")
    public ResponseEntity<Integer> recordsCount(@RequestParam Map<String, String> params) {
        return ResponseEntity
                .ok()
                .body(usersRepository.recordsCount(params));
    }

    @Operation(
            summary = "Retrieve users meta",
            description = "<code>Retrieve</code> <i><b>users</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(usersRepository.meta());
    }

    @Operation(
            summary = "Retrieve users meta",
            description = "<code>Retrieve</code> <i><b>users</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta1", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta1() {
        return ResponseEntity
                .ok()
                .body(usersRepository.meta1());
    }

    @Operation(
            summary = "Retrieve specific user",
            description = "<code>Retrieve</code> specific <i><b>user</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{pubUsersID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<PubUsers> pubUser(@PathVariable BigDecimal pubUsersID) {
        return ResponseEntity.ok(usersRepository.pubShowUsersByID(pubUsersID));
    }

    @Operation(
            summary = "Retrieve login user",
            description = "<code>Retrieve</code> login <i><b>user</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/this", produces = "application/json;charset=utf-8")
    public ResponseEntity<PubUsers> pubUserThis(HttpServletRequest request) {
        String authentication = request.getHeader("Authorization");
        String token = authentication.substring(7);
        return ResponseEntity.ok(usersRepository.pubShowUsersByID(new BigDecimal(jwtTokenUtil.getUserIDFromToken(token))));
    }

    @ApiResponses(
            @ApiResponse(responseCode = "204", description = "deleted successfully")
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete user",
            description = "<code>Delete</code> <i><b>user</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{userID}", produces = "application/json")
    public ResponseEntity<?> pubDelUserSP(@PathVariable BigDecimal userID) {
        usersRepository.pubDelUser(userID);
        return ResponseEntity.noContent().build();
    }
}
