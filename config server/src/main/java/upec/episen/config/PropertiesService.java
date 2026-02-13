package upec.episen.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties(prefix = "services")
public class PropertiesService {

    public Map<String, String> dev;
    public Map<String, String> prod;

    public Map<String, String> getDev() { return dev; }
    public void setDev(Map<String, String> dev) { this.dev = dev; }

    public Map<String, String> getProd() { return prod; }
    public void setProd(Map<String, String> prod) { this.prod = prod; }

    public String getIp(String environment, String serviceName) {
        Map<String, String> services =
                "prod".equalsIgnoreCase(environment) ? prod : dev;
        return services == null ? null : services.get(serviceName);
    }
}
