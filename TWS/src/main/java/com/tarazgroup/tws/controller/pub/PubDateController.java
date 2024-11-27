package com.tarazgroup.tws.controller.pub;

import com.tarazgroup.tws.util.global.TCalendar;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author salman majidi
 * @since 2.0.0
 */

@RestController
@RequestMapping("pub/date")
@Validated


@Tag(name = "Date")
public class PubDateController {

    @Operation(
            summary = "Retrieve current Jalali Date",
            description = "<code>Retrieve</code> current <i><b>Jalali Date</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/jalali", produces = "application/json;charset=utf-8")
    public ResponseEntity<String> currentJalaliDate() {
        TCalendar tCalendar = new TCalendar();
        tCalendar.setGregorianDate(new Date());
        return ResponseEntity.ok("{\"date\":\""+tCalendar.getIranianDateBySlashZero()+"\"}");
    }


}
