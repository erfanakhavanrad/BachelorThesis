package com.tarazgroup.tws.controller.inv;

import com.tarazgroup.tws.dao.DriveType;
import com.tarazgroup.tws.dao.inv.InvExportImageRepository;
import com.tarazgroup.tws.model.inv.InvExportImage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/***
 * @author A.Farahani
 * @date Apr-26, 2022
 ***/
@RestController
@RequestMapping("inv/exportimages")
@Validated
@Tag(name = "ExportImage")
public class InvExportImageController {
    private final InvExportImageRepository invExportImageRepository;


    public InvExportImageController(InvExportImageRepository invExportImageRepository) {
        this.invExportImageRepository = invExportImageRepository;
    }

    @Operation(
            summary = "Export image",
            description = "<code>Export</code> <i><b>image</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json")
    public ResponseEntity<InvExportImage> exportImage(
            @RequestParam() String fromDate,
            @RequestParam() String toDate,
            @RequestParam() DriveType driveName) throws IOException {
//        int g=0;
//        return ResponseEntity.ok(invExportImageRepository.invExportImage(fromDate, toDate, driveName));

        return ResponseEntity
                .ok()
                .body(invExportImageRepository.invExportImage(fromDate, toDate, driveName));
    }
}
