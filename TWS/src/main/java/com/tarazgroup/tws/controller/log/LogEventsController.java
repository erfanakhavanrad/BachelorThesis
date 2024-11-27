//package com.tarazgroup.tws.controller.log;
//
//import com.tarazgroup.tws.dao.log.LogEventsRepository;
//import com.tarazgroup.tws.model.log.LogEvents;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.security.SecurityRequirement;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import org.springdoc.api.annotations.ParameterObject;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.math.BigDecimal;
//import java.util.List;
//
///**
// * @author A.Farahani
// * @date Dec-27, 2021
// */
//@RestController
//@RequestMapping("log/events")
//@Validated
//@Tag(name = "Events")
//public class LogEventsController {
//    final private LogEventsRepository logEventsRepository;
//
//    public LogEventsController(LogEventsRepository logEventsRepository) {
//        this.logEventsRepository = logEventsRepository;
//    }
//
//    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
//    @Operation(
//            summary = "Retrieve all Events",
//            description = "<code>Retrieve</code> all <i><b>Events</b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @GetMapping(produces = "application/json;charset=utf-8")
//    public ResponseEntity<List<LogEvents>> events(@ParameterObject LogEvents logEvents) {
//        return ResponseEntity
//                .ok()
//                .body(logEventsRepository.logShowEvents(logEvents));
//    }
//
//    @Operation(
//            summary = "Retrieve specific Event",
//            description = "<code>Retrieve</code> specific <i><b>Event</b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @GetMapping(value = "/{eventID}", produces = "application/json;charset=utf-8")
//    public ResponseEntity<LogEvents> event(@PathVariable BigDecimal eventID) {
//        return ResponseEntity
//                .ok()
//                .body(logEventsRepository.logShowEventsByID(eventID));
//    }
//
//    @Operation(
//            summary = "Create Event",
//            description = "<code>Create</code> <i><b>Event</b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @PostMapping(produces = "application/json", consumes = "application/json")
//    public ResponseEntity<LogEvents> eventInsSP(
//            @Valid
//            @io.swagger.v3.oas.annotations.parameters.RequestBody
//            @RequestBody LogEvents logEvents
//    ) {
//        return ResponseEntity.ok(logEventsRepository.logInsEvents(logEvents));
//    }
//
//    //</editor-fold>
//}
