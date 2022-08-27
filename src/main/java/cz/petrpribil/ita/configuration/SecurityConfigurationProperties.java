package cz.petrpribil.ita.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "app.security")
@Data
public class SecurityConfigurationProperties {
    private String frontendUrl;
    private List<String> allowedMethods;
}
