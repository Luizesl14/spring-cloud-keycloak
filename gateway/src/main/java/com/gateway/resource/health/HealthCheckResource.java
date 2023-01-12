package com.gateway.resource.health;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
@RequestMapping(value = "/health")
public class HealthCheckResource {


    @GetMapping
    public ResponseEntity<String> health(){
        LocalDateTime date = LocalDateTime.now();
        String msg = "OK - GATEWAY " + date;
        return ResponseEntity.ok().body(msg);
    }
}
