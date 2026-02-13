package upec.episen.config;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ip")
public class PropertiesController {

    @GetMapping("/{env}/{property}")
    public ResponseEntity getIp(@PathVariable String env, @PathVariable String property) {
        if (env == null || property == null) {
            return ResponseEntity.badRequest().body(Map.of("msg", "Please provide both an environment and a property"));
        }
        String ip = PropertiesService.getIp(env, property);
        if (ip == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ip);
    }
}
