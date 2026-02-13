package upec.episen.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "services")
public class PropertiesService {

    private static Map<String, Map<String, String>> env;

    public Map<String, Map<String, String>> getEnv() {
        return env;
    }

    public void setEnv(Map<String, Map<String, String>> env) {
        this.env = env;
    }

    public static String getIp(String environment, String serviceName) {
        Map<String, String> services = env.get(environment);
        return services == null ? null : services.get(serviceName);
    }
}
