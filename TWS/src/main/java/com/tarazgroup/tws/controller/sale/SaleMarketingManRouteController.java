package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.sale.SaleMarketingManRouteByNameRepository;
import com.tarazgroup.tws.dao.sale.SaleMarketingManRouteRepository;
import com.tarazgroup.tws.model.sale.SaleMarketingManRoute;
import com.tarazgroup.tws.model.sale.SaleMarketingManRouteByName;
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

/*
import io.swagger.v3.oas.annotations.parameters.RequestBody;
*/

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
@RestController
@RequestMapping("sale/coordinates")
@Validated
@Tag(name = "Coordinate")
public class SaleMarketingManRouteController {

    final private SaleMarketingManRouteRepository saleMarketingManRouteRepository;
    final private SaleMarketingManRouteByNameRepository saleMarketingManRouteByNameRepository;

    public SaleMarketingManRouteController(SaleMarketingManRouteRepository saleMarketingManRouteRepository, SaleMarketingManRouteByNameRepository saleMarketingManRouteByNameRepository) {
        this.saleMarketingManRouteRepository = saleMarketingManRouteRepository;
        this.saleMarketingManRouteByNameRepository = saleMarketingManRouteByNameRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all coordinates",
            description = "<code>Retrieve</code> all <i><b>coordinates</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<SaleMarketingManRoute>> Coordinates(
            @RequestParam() BigDecimal marketingManID,
            @RequestParam() String createDate

    ) {
        return ResponseEntity.ok(saleMarketingManRouteRepository.showSaleMarketingManRoute(marketingManID, createDate));
    }


    @Operation(
            summary = "Retrieve all coordinates",
            description = "<code>Retrieve</code> all <i><b>coordinates</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(path = "/byname",produces = "application/json;charset=utf-8")
    public ResponseEntity<List<SaleMarketingManRouteByName>> CoordinatesByName(
            @ParameterObject SaleMarketingManRouteByName marketingManRouteByName,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate

    ) {
        return ResponseEntity.ok(saleMarketingManRouteByNameRepository.showSaleMarketingManRouteByName(marketingManRouteByName, startDate, endDate));
    }


    @Operation(
            summary = "Create coordinate",
            description = "<code>Create</code> <i><b>coordinate</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
//                    "\n" +
//                    "### Body Example Value" +
//                    "\n" +
//                    "```" +
//                    "\n" +
//                    "{\n" +
//                    "   \"marketingMan\":{\n" +
//                    "      \"accPerComID\":\"10000005\"\n" +
//                    "   },\n" +
//                    "   \"customer\":{\n" +
//                    "      \"accPerComID\":\"10000000\"\n" +
//                    "   },\n" +
//                    "   \"endTime\":\"2020-07-05 11:20:01.000\",\n" +
//                    "   \"latitude\":\"35.754242\",\n" +
//                    "   \"longitude\":\"51.410005\",\n" +
//                    "}\n" +
//                    "```"
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<SaleMarketingManRoute> indCoordinate(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
                    @Content(
                            schema = @Schema(
                                    example = "{\n" +
                                            "\n" +
                                            "    \"latitude\":15.754242,\n" +
                                            "    \"longitude\":11.410005,\n" +
                                            "    \"customerID\":10000000\n" +
                                            "\n" +
                                            "}"
                            )
                    )
            })
            @RequestBody SaleMarketingManRoute saleMarketingManRoute
    ) {
        return ResponseEntity.ok(saleMarketingManRouteRepository.insSaleMarketingManRoute(saleMarketingManRoute));
    }

    //</editor-fold>

}
