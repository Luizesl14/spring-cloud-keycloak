package risk.health;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/health")
public class HealthCheckResource {


    @GetMapping
    public ResponseEntity<String> health(){
        String msg = "OK";
        return ResponseEntity.ok().body(msg);
    }
}
