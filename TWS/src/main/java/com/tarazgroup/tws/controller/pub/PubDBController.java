package com.tarazgroup.tws.controller.pub;


import com.tarazgroup.tws.model.pub.PubDB;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Salman Majidi
 * @since 2.0.0
 */

@Validated
@RequestMapping("pub/db")
@RestController
@Tag(name = "DB")
public class PubDBController {

    private final Environment environment;

    public PubDBController(Environment environment) {
        this.environment = environment;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve database information",
            description = "<code>Retrieve</code> <i><b>database information</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<PubDB> pubDB() {
//        try {
//            TimeUnit.SECONDS.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        String dbUrl = environment.getProperty("spring.datasource.url");
        PubDB pubDB = new PubDB(dbUrl.split(";")[1].split("=")[1]);
        return ResponseEntity.ok(pubDB);
    }
    //</editor-fold>
}
