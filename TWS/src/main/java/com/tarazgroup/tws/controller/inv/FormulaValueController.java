package com.tarazgroup.tws.controller.inv;


import com.tarazgroup.tws.dao.inv.FormulaValueRepository;
import com.tarazgroup.tws.model.inv.FormulaValue;
import com.tarazgroup.tws.model.inv.InvFormulaValue;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */

@Validated
@RequestMapping("inv/formulavalues")
@RestController
@Tag(name = "FormulaValue")
public class FormulaValueController {

    final private FormulaValueRepository formulaValueRepository;

    public FormulaValueController(FormulaValueRepository formulaValueRepository) {
        this.formulaValueRepository = formulaValueRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Compute FormulaValue",
            description = "<code>Compute</code> <i><b>FormulaValue</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<FormulaValue> invGetFormulaValue(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    examples = {
                                            @ExampleObject(
                                                    name = "<code>Novin Choob</code> example for compute <i><b>FormulaValue</b></i>",
                                                    value = "{\n" +
                                                            "\n" +
                                                            "    \"quantity\":10,\n" +
                                                            "    \"quantity2\":0,\n" +
                                                            "    \"quantity3\":0,\n" +
                                                            "    \"fee\":20,\n" +
                                                            "    \"groupID\":10000026,\n" +
                                                            "    \"invGroupFormulaTblTypes\":[\n" +
                                                            "        {\n" +
                                                            "            \"fcode\":\"@F1001\",\n" +
                                                            "            \"fval\":\"30\"\n" +
                                                            "        },\n" +
                                                            "        {\n" +
                                                            "            \"fcode\":\"@F1002\",\n" +
                                                            "            \"fval\":\"40\"\n" +
                                                            "        },\n" +
                                                            "        {\n" +
                                                            "            \"fcode\":\"@F1003\",\n" +
                                                            "            \"fval\":\"0\"\n" +
                                                            "        },\n" +
                                                            "        {\n" +
                                                            "            \"fcode\":\"@F1004\",\n" +
                                                            "            \"fval\":\"0\"\n" +
                                                            "        },\n" +
                                                            "        {\n" +
                                                            "            \"fcode\":\"@F1006\",\n" +
                                                            "            \"fval\":\"0\"\n" +
                                                            "        },\n" +
                                                            "        {\n" +
                                                            "            \"fcode\":\"@F1008\",\n" +
                                                            "            \"fval\":\"0\"\n" +
                                                            "        },\n" +
                                                            "        {\n" +
                                                            "            \"fcode\":\"@F1009\",\n" +
                                                            "            \"fval\":\"0\"\n" +
                                                            "        },\n" +
                                                            "        {\n" +
                                                            "            \"fcode\":\"@F1011\",\n" +
                                                            "            \"fval\":\"0\"\n" +
                                                            "        },\n" +
                                                            "        {\n" +
                                                            "            \"fcode\":\"@F1014\",\n" +
                                                            "            \"fval\":\"0\"\n" +
                                                            "        },\n" +
                                                            "        {\n" +
                                                            "            \"fcode\":\"@F1015\",\n" +
                                                            "            \"fval\":\"0\"\n" +
                                                            "        }\n" +
                                                            "    ]\n" +
                                                            "\n" +
                                                            "}" ,

                                                    summary = "Novin Choob"
                                            )



                                    }
                            )
                    }
            )
            @Valid @RequestBody InvFormulaValue invFormulaValue
    ) {
        return ResponseEntity.ok(formulaValueRepository.invGetFormulaValue(invFormulaValue));
    }
    //</editor-fold>
}

