package com.tarazgroup.tws.controller.acc;


import com.tarazgroup.tws.dao.acc.AccBank_Repository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */

@Validated
@RequestMapping("acc/banks_")
@RestController
@Tag(name = "Bank_")
public class AccBank_Controller {

    final private AccBank_Repository accBank_Repository;

    public AccBank_Controller(AccBank_Repository accBank_Repository) {
        this.accBank_Repository = accBank_Repository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
//    @Operation(
//            summary = "Retrieve all banks_",
//            description = "<code>Retrieve</code> all <i><b>banks_</b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @GetMapping(produces = "application/json;charset=utf-8")
//    public ResponseEntity<List<AccBank1>> banks(@ParameterObject AccBank1 accBank_) {
//
////        try {
////            TimeUnit.SECONDS.sleep(10);
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
//        return ResponseEntity
//                .ok()
//                .header("meta", accBank_Repository.meta())
//                .body(accBank_Repository.accShowBank(accBank_));
//    }

    //</editor-fold>


}
