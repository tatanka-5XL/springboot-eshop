package cz.petrpribil.ita.rest;

import cz.petrpribil.ita.configuration.SecurityConfiguration;
import cz.petrpribil.ita.configuration.SecurityConfigurationProperties;
import org.springframework.context.annotation.Import;

@Import({SecurityConfiguration.class, SecurityConfigurationProperties.class})
public class AbstractControllerTest {
}
