package register.health;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.UUID;

@Controller
@RequestMapping(value = "/health")
public class HealthCheckResource {


    @Getter
    @Setter
    public static class Resp{
        private String signature = UUID.randomUUID().toString();
        private LocalDateTime date = LocalDateTime.now();
        private String request = "HEALTH-CHECK";
        private String status = "UP";
        private String type = "PRIVATE";
        private String application = "REGISTER MODULE";
    }


    @GetMapping
    public ResponseEntity<Resp> health(){
        return ResponseEntity.ok().body(new Resp());
    }
}
