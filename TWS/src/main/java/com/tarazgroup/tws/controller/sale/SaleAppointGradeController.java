package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.sale.SaleAppointGradeRepository;
import com.tarazgroup.tws.model.sale.SaleAppointGrade;
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
@RequestMapping("sale/appointgrades")

@Tag(name = "AppointGrade")
public class SaleAppointGradeController {
    private final SaleAppointGradeRepository saleAppointGradeRepository;

    public SaleAppointGradeController(SaleAppointGradeRepository saleAppointGradeRepository) {
        this.saleAppointGradeRepository = saleAppointGradeRepository;
    }

    @Operation(
            summary = "Retrieve appointGrades",
            description = "<code>Retrieve</code> <i><b>appointGrades</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<SaleAppointGrade>> saleAppointGrades(@ParameterObject SaleAppointGrade saleAppointGrade) {
        return ResponseEntity.ok(saleAppointGradeRepository.saleShowAppointGrade(saleAppointGrade));
    }
}
