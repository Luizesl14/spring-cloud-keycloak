package crm.health;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping(value = "/health")
public class HealthCheckResource {


    @GetMapping
    public ResponseEntity<String> health(){
        LocalDate date = LocalDate.now();
        String msg = "OK - CRM " + date;
        return ResponseEntity.ok().body(msg);
    }
}
