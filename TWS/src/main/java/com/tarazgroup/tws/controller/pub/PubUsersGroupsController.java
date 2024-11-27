package com.tarazgroup.tws.controller.pub;

import com.tarazgroup.tws.dao.pub.PubUsersGroupsRepository;
import com.tarazgroup.tws.model.pub.PubUsersGroups;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
@RestController
@RequestMapping("pub/usersgroups")

@Tag(name = "UsersGroups")
public class PubUsersGroupsController {

    private final PubUsersGroupsRepository pubUsersGroupsRepository;

    public PubUsersGroupsController(PubUsersGroupsRepository pubUsersGroupsRepository) {
        this.pubUsersGroupsRepository = pubUsersGroupsRepository;
    }


    @Operation(
            summary = "Retrieve all usersGroups",
            description = "<code>Retrieve</code> all <i><b>usersGroups</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<PubUsersGroups>> usersGroups(@ParameterObject PubUsersGroups pubUsersGroups){
        return ResponseEntity.ok(pubUsersGroupsRepository.pubShowUsersGroups(pubUsersGroups));
    }

    @Operation(
            summary = "Retrieve usersGroups meta",
            description = "<code>Retrieve</code> <i><b>usersGroups</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta",produces = "application/json")
    public ResponseEntity<Meta> meta(){
        return ResponseEntity.ok().body(pubUsersGroupsRepository.meta());
    }
}

