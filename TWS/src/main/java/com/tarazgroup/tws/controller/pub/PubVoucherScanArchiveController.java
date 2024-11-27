package com.tarazgroup.tws.controller.pub;

import com.tarazgroup.tws.dao.pub.PubVoucherScanArchiveRepository;
import com.tarazgroup.tws.dto.AttachmentModel;
import com.tarazgroup.tws.model.pub.PubVoucherScanArchive;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import javax.validation.Valid;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * @authors A.Farahani, Erfan Akhavan
 * @date 12/13/21
 */
@RestController
@RequestMapping("pub/voucherscanarchives")
@Validated
@Tag(name = "VoucherScanArchive")
public class PubVoucherScanArchiveController {
    final private PubVoucherScanArchiveRepository pubVoucherScanArchiveRepository;

    public PubVoucherScanArchiveController(PubVoucherScanArchiveRepository pubVoucherScanArchiveRepository) {
        this.pubVoucherScanArchiveRepository = pubVoucherScanArchiveRepository;
    }

    @Operation(
            summary = "Retrieve all voucherScanArchives",
            description = "<code>Retrieve</code> all <i><b>voucherScanArchives</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<PubVoucherScanArchive>> voucherScanArchives(@ParameterObject PubVoucherScanArchive pubVoucherScanArchive) {
        return ResponseEntity
                .ok()
                .body(pubVoucherScanArchiveRepository.pubShowVoucherScanArchive(pubVoucherScanArchive));
    }

    @Operation(
            summary = "Retrieve specific voucherScanArchive",
            description = "<code>Retrieve</code> specific <i><b>voucherScanArchive</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{imageID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<PubVoucherScanArchive> voucherScanArchive(@PathVariable BigDecimal imageID) {
        return ResponseEntity
                .ok()
                .body(pubVoucherScanArchiveRepository.pubShowVoucherScanArchiveByID(imageID));
    }


    @Operation(
            summary = "Retrieve specific voucherScanArchive",
            description = "<code>Retrieve</code> specific <i><b>voucherScanArchive</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/file/{imageID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<PubVoucherScanArchive> voucherScanArchiveFile(@PathVariable BigDecimal imageID) {
        PubVoucherScanArchive pubVoucherScanArchive = pubVoucherScanArchiveRepository.pubShowVoucherScanArchiveByID(imageID);
        System.out.println(pubVoucherScanArchive.getVoucherHeaderID());

        return ResponseEntity
                .ok()
                .body(pubVoucherScanArchiveRepository.pubShowVoucherScanArchiveByIDFile(imageID));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete voucherScanArchive",
            description = "<code>Delete</code> <i><b>voucherScanArchive<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{imageID}", produces = "application/json")
    public ResponseEntity<?> voucherScanArchiveDelSP(
            @PathVariable BigDecimal voucherHeaderID, @PathVariable BigDecimal voucherTypeID, @PathVariable Integer delType, @PathVariable BigDecimal imageID) {
        pubVoucherScanArchiveRepository.pubDelVoucherScanArchive(voucherHeaderID, voucherTypeID, delType, imageID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Post attachment base64",
            description = "<code>Post</code> all <i><b>attachment base64</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(value = "/attachmentstring/{voucherHeaderID}", produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> attachmentVoucherString(@PathVariable BigDecimal voucherHeaderID,
                                                     @Valid
                                                     @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                             content = {
                                                                     @Content(
                                                                             schema = @Schema(
                                                                                     example = "{\n" +
                                                                                             "  \"photoString\": \"photoString\",\n" +
                                                                                             "  \"voucherTypeID\": 6000\n" +
                                                                                             "}"
                                                                             )
                                                                     )
                                                             }
                                                     )
                                                     @RequestBody AttachmentModel attachmentModel

    ) {
        //TODO get the id from the flutter
        System.out.println("***** voucherHeaderID: " + voucherHeaderID);
        System.out.println("***** VoucherTypeID: " + attachmentModel.getVoucherTypeID());
        System.out.println("***** photo:  " + attachmentModel.getPhotoString());
//        pubVoucherScanArchiveRepository.pubInsVoucherAttachmentString(voucherHeaderID, attachmentModel);
        return ResponseEntity.ok("عکس انتخاب شده با موفقیت به سند پیوست شد.");
    }


    @Operation(
            summary = "Post attachment bye[]",
            description = "<code>Post</code> all <i><b>attachment bye[]</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(value = "/attachmentbyte/{voucherHeaderID}", produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> attachmentVoucherByte(@PathVariable BigDecimal voucherHeaderID,
                                                   @Valid
                                                   @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                           content = {
                                                                   @Content(
                                                                           schema = @Schema(
                                                                                   example = "{\n" +
                                                                                           "  \"photoByteArray\": [\n" +
                                                                                           "    5,21,32,42,12,36\n" +
                                                                                           "  ],\n" +
                                                                                           "  \"voucherTypeID\": 6000\n" +
                                                                                           "}"
                                                                           )
                                                                   )
                                                           }
                                                   )
                                                   @RequestBody AttachmentModel attachmentModel) {

        return ResponseEntity.ok("عکس انتخاب شده با موفقیت به سند پیوست شد.");
    }


    @Operation(
            summary = "Post attachment",
            description = "<code>Post</code> all <i><b>attachment</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(value = "/attachment/{voucherHeaderID}", produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> attachmentVoucher(@PathVariable BigDecimal voucherHeaderID,
                                               @Valid
                                               @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                       content = {
                                                               @Content(
                                                                       schema = @Schema(
                                                                               example = "{\n" +
                                                                                       " \"photoByteArray\":[255, 216, 255, 224, 0, 16, 74, 255, 217],\n" +
                                                                                       "  \"voucherTypeID\": 6000\n" +
                                                                                       "}"
                                                                       )
                                                               )
                                                       }
                                               )
                                               @RequestBody AttachmentModel attachmentModel) throws SQLException {
        pubVoucherScanArchiveRepository.pubInsVoucherAttachment(voucherHeaderID, attachmentModel);
        return ResponseEntity.ok("عکس انتخاب شده با موفقیت به سند پیوست شد.");
    }


    @Operation(
            summary = "Retrieve specific voucherScanArchive",
            description = "<code>Retrieve</code> specific <i><b>voucherScanArchive</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "voucherHeaderID/{voucherHeaderID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<PubVoucherScanArchive> voucherScanArchiveByVoucherHeaderID(@PathVariable BigDecimal voucherHeaderID) throws IOException {
        return ResponseEntity
                .ok()
                .body(pubVoucherScanArchiveRepository.pubShowVoucherScanArchiveByVoucherHeaderID(voucherHeaderID));
    }

}
