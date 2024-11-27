package com.tarazgroup.tws.controller.acc;

import com.tarazgroup.tws.dao.acc.AccPerComRepository;
import com.tarazgroup.tws.model.acc.AccPerCom;
import com.tarazgroup.tws.model.acc.AccPerComBody;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@RequestMapping("acc/percoms")
@RestController
@Validated

@Tag(name = "PerCom")
public class AccPerComController {

    final private AccPerComRepository accPerComRepository;

    public AccPerComController(AccPerComRepository accPerComRepository) {
        this.accPerComRepository = accPerComRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve specific perComs",
            description = "<code>Retrieve</code> specific <i><b>perComes</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{perComID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<AccPerCom> accPerCom(@PathVariable BigDecimal perComID) {
        return ResponseEntity.ok(accPerComRepository.accShowPerComByID(perComID));
    }

    @Operation(
            summary = "Retrieve all perComs that not user",
            description = "<code>Retrieve</code> all <i><b>perComes that not user</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/notuser",produces = "application/json;charset=utf-8")
    public ResponseEntity<List<AccPerCom>> accPerComNotUser(@RequestParam BigDecimal pageNumber, @RequestParam BigDecimal recordCount) {
        return ResponseEntity.ok(accPerComRepository.accShowPerComNotUser(pageNumber,recordCount));
    }

    @Operation(
            summary = "Retrieve all perComs",
            description = "<code>Retrieve</code> all <i><b>perComes</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<AccPerCom>> accPerCom(@ParameterObject AccPerCom accPerCom) {
        return ResponseEntity.ok(accPerComRepository.accShowPerCom(accPerCom));
    }

    @Operation(
            summary = "Delete perCom",
            description = "<code>Delete</code> <i><b>perCome</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{perComID}", produces = "application/json")
    public ResponseEntity<?> perComDelSP(@PathVariable BigDecimal perComID) {
        accPerComRepository.accDelPerCom(perComID);
        return ResponseEntity.noContent().build();
    }


    @Operation(
            summary = "Create perCom",
            description = "<code>Create</code> <i><b>perCom</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<AccPerCom> accPerComInsSp(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    examples = {
                                            @ExampleObject(
                                                    name = "example for create <i><b>اشخاص حقیقی</b></i>",
                                                    value = "{\n" +
                                                            "  \"accPerCom\": {\n" +
                                                            "    \"perComCode\": \"1\",\n" +
                                                            "    \"perComTitle\": \"دفتردار\",\n" +
                                                            "    \"perComFName\": \"حسین\",\n" +
                                                            "    \"perComLName\": \"نوری\",\n" +
                                                            "    \"perComNameLatin\": \"Nouri\",\n" +
                                                            "    \"sexID\": true,\n" +
                                                            "    \"perComAddress\": \"تهران، خیابان ولیعصر، نرسیده به میدان ونک، کوچه فوزی، پلاک 4، طبقه ششم\",\n" +
                                                            "    \"tafsiliTypeID\": 10000003,\n" +
                                                            "    \"perComTypeID\": 0,\n" +
                                                            "    \"isMPerson\": false,\n" +
                                                            "    \"fatherName\": \"ناصر\",\n" +
                                                            "    \"isNotActive\": true,\n" +
                                                            "    \"isMpp\": true,\n" +
                                                            "    \"percomName\": \"معدن شکافان تهران \",\n" +
                                                            "    \"mpp\": false\n" +
                                                            "  },\n" +
                                                            "  \"accPerComOther\": {\n" +
                                                            "    \"percomTel\": null,\n" +
                                                            "    \"percomMobile\": null,\n" +
                                                            "    \"nationalCode\": \"8877965\",\n" +
                                                            "    \"customerCode\": null,\n" +
                                                            "    \"salesManCode\": null,\n" +
                                                            "    \"marketingManCode\": null,\n" +
                                                            "    \"providerCode\": null,\n" +
                                                            "    \"customerClassID\": null,\n" +
                                                            "    \"marketingManClassID\": null,\n" +
                                                            "    \"customerGeoID\": null,\n" +
                                                            "    \"salesManGeoID\": null,\n" +
                                                            "    \"marketingManGeoID\": null,\n" +
                                                            "    \"providerGeoID\": null,\n" +
                                                            "    \"iSProviderManNotActive\": false,\n" +
                                                            "    \"iSStockerNotActive\": true,\n" +
                                                            "    \"birthDateStocker\": null,\n" +
                                                            "    \"numberMemberStocker\": null,\n" +
                                                            "    \"identityCodeStocker\": null,\n" +
                                                            "    \"webUserType\": 0,\n" +
                                                            "    \"isSaleCustomer\": true,\n" +
                                                            "    \"isSaleMan\": true,\n" +
                                                            "    \"isMarketingMan\": true,\n" +
                                                            "    \"providerMan\": false,\n" +
                                                            "    \"isPerson\": true,\n" +
                                                            "    \"isStocker\": true,\n" +
                                                            "    \"salesManClassID\": 0,\n" +
                                                            "    \"isForeignProvider\": true,\n" +
                                                            "    \"isCustomerNotActive\": true,\n" +
                                                            "    \"isSalesManNotActive\": true,\n" +
                                                            "    \"isMarketingManNotActive\": true,\n" +
                                                            "    \"isAllowDuplicate\": false\n" +
                                                            "  }\n" +
                                                            "}",
                                                    summary = "حقیقی"
                                            ),
                                            @ExampleObject(
                                                    name = "example for create <i><b>اشخاص حقوقی</b></i>",
                                                    value = "{\n" +
                                                            "  \"accPerCom\": {\n" +
                                                            "    \"perComCode\": \"1\",\n" +
                                                            "    \"perComTitle\": \"دفتردار\",\n" +
                                                            "    \"perComFName\": \"شرکت\",\n" +
                                                            "    \"perComLName\": \"تراز\",\n" +
                                                            "    \"perComNameLatin\": \"Taraz\",\n" +
                                                            "    \"sexID\": null,\n" +
                                                            "    \"perComAddress\": \"تهران، خیابان ولیعصر، نرسیده به میدان ونک، کوچه فوزی، پلاک 4، طبقه ششم\",\n" +
                                                            "    \"tafsiliTypeID\": 10000003,\n" +
                                                            "    \"perComTypeID\": 0,\n" +
                                                            "    \"isMPerson\": false,\n" +
                                                            "    \"fatherName\": \"null\",\n" +
                                                            "    \"isNotActive\": true,\n" +
                                                            "    \"isMpp\": true,\n" +
                                                            "    \"percomName\": \"ترازسامانه \",\n" +
                                                            "    \"mpp\": false\n" +
                                                            "  },\n" +
                                                            "  \"accPerComOther\": {\n" +
                                                            "    \"percomTel\": null,\n" +
                                                            "    \"percomMobile\": null,\n" +
                                                            "    \"nationalCode\": \"null\",\n" +
                                                            "    \"customerCode\": null,\n" +
                                                            "    \"salesManCode\": null,\n" +
                                                            "    \"marketingManCode\": null,\n" +
                                                            "    \"providerCode\": null,\n" +
                                                            "    \"customerClassID\": null,\n" +
                                                            "    \"marketingManClassID\": null,\n" +
                                                            "    \"customerGeoID\": null,\n" +
                                                            "    \"salesManGeoID\": null,\n" +
                                                            "    \"marketingManGeoID\": null,\n" +
                                                            "    \"providerGeoID\": null,\n" +
                                                            "    \"iSProviderManNotActive\": false,\n" +
                                                            "    \"iSStockerNotActive\": true,\n" +
                                                            "    \"birthDateStocker\": null,\n" +
                                                            "    \"numberMemberStocker\": null,\n" +
                                                            "    \"identityCodeStocker\": null,\n" +
                                                            "    \"webUserType\": 0,\n" +
                                                            "    \"isSaleCustomer\": true,\n" +
                                                            "    \"isSaleMan\": true,\n" +
                                                            "    \"isMarketingMan\": true,\n" +
                                                            "    \"providerMan\": false,\n" +
                                                            "    \"isPerson\": true,\n" +
                                                            "    \"isStocker\": true,\n" +
                                                            "    \"salesManClassID\": 0,\n" +
                                                            "    \"isForeignProvider\": true,\n" +
                                                            "    \"isCustomerNotActive\": true,\n" +
                                                            "    \"isSalesManNotActive\": true,\n" +
                                                            "    \"isMarketingManNotActive\": true,\n" +
                                                            "    \"isAllowDuplicate\": false\n" +
                                                            "  }\n" +
                                                            "}",
                                                    summary = "حقوقی"
                                            )
                                    }


                            )
                    }
            )
            @RequestBody @Valid AccPerComBody accPerComBody) {
        return ResponseEntity.ok(accPerComRepository.accInsPerCom(accPerComBody));
    }

    @Operation(
            summary = "Update perCom",
            description = "<code>Update</code> <i><b>perCom</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{perComID}",produces = "application/json", consumes = "application/json")
    public ResponseEntity<AccPerCom> bankUpdSP(
            @PathVariable BigDecimal perComID,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
                    @Content(
                            schema = @Schema(
                                    example = "{\n" +
                                            "   \"accPerCom\":{\n" +
                                            "      \"perComCode\":\"1\",\n" +
                                            "      \"perComTitle\":\"دفتردار\",\n" +
                                            "      \"perComFName\":\"مرتضی\",\n" +
                                            "      \"perComLName\":\"نوری\",\n" +
                                            "      \"perComNameLatin\":\"Nouri\",\n" +
                                            "      \"sexID\":true,\n" +
                                            "      \"perComAddress\":\"تهران، خیابان ولیعصر، نرسیده به میدان ونک، کوچه فوزی، پلاک 4، طبقه ششم\",\n" +
                                            "      \"tafsiliTypeID\":10000003,\n" +
                                            "      \"PerComTypeID\":\"0\",\n" +
                                            "      \"isMPerson\":false,\n" +
                                            "      \"fatherName\":\"ناصر\",\n" +
                                            "      \"isNotActive\":true,\n" +
                                            "      \"isMpp\":true,\n" +
                                            "      \"percomName\":\"معدن شکافان تهران \",\n" +
                                            "      \"mpp\":false\n" +
                                            "   },\n" +
                                            "   \"accPerComOther\":{\n" +
                                            "      \"percomTel\":\"string\",\n" +
                                            "      \"percomMobile\":\"string\",\n" +
                                            "      \"nationalCode\":\"0016383769\",\n" +
                                            "      \"customerCode\":\"string\",\n" +
                                            "      \"salesManCode\":\"string\",\n" +
                                            "      \"marketingManCode\":\"string\",\n" +
                                            "      \"providerCode\":\"string\",\n" +
                                            "      \"customerClassID\":null,\n" +
                                            "      \"marketingManClassID\":null,\n" +
                                            "      \"customerGeoID\":null,\n" +
                                            "      \"salesManGeoID\":null,\n" +
                                            "      \"marketingManGeoID\":null,\n" +
                                            "      \"providerGeoID\":null,\n" +
                                            "      \"iSProviderManNotActive\":true,\n" +
                                            "      \"iSStockerNotActive\":true,\n" +
                                            "      \"birthDateStocker\":\"string\",\n" +
                                            "      \"numberMemberStocker\":\"string\",\n" +
                                            "      \"identityCodeStocker\":\"string\",\n" +
                                            "      \"webUserType\":0,\n" +
                                            "      \"isSaleCustomer\":true,\n" +
                                            "      \"isSaleMan\":true,\n" +
                                            "      \"isMarketingMan\":true,\n" +
                                            "      \"providerMan\":true,\n" +
                                            "      \"isPerson\":true,\n" +
                                            "      \"isStocker\":true,\n" +
                                            "      \"salesManClassID\":0,\n" +
                                            "      \"isForeignProvider\":true,\n" +
                                            "      \"isCustomerNotActive\":true,\n" +
                                            "      \"isSalesManNotActive\":true,\n" +
                                            "      \"isMarketingManNotActive\":true,\n" +
                                            "      \"isAllowDuplicate\":true\n" +
                                            "   }\n" +
                                            "}"
                            )
                    )
            }
            )
            @RequestBody @Valid AccPerComBody accPerComBody) {
        return ResponseEntity.ok(accPerComRepository.accUpdPerCom(perComID, accPerComBody));
    }

    @Operation(
            summary = "Retrieve perCom meta",
            description = "<code>Retrieve</code> <i><b>perCom</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json")
    public ResponseEntity<Meta> meta(){
        return ResponseEntity.ok().body(accPerComRepository.meta());
    }

    @Operation(
            summary = "Retrieve perCom nameFamilyMeta",
            description = "<code>Retrieve</code> <i><b>perCom</b></i> nameFamilyMeta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/namefamilymeta", produces = "application/json")
    public ResponseEntity<Meta> nameFamilyMeta(){
        return ResponseEntity.ok().body(accPerComRepository.nameFamilyMeta());
    }


    @Operation(
            summary = "Retrieve perCom personMeta",
            description = "<code>Retrieve</code> <i><b>perCom</b></i> personMeta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/personmeta", produces = "application/json")
    public ResponseEntity<?> personMeta(){
        return ResponseEntity.ok().body(accPerComRepository.personMeta());
    }


    @Operation(
            summary = "Retrieve perCom companyMeta",
            description = "<code>Retrieve</code> <i><b>perCom</b></i> companyMeta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/companymeta", produces = "application/json")
    public ResponseEntity<?> companyMeta (){
        return ResponseEntity.ok().body(accPerComRepository.companyMeta());
    }

    //</editor-fold>
}
