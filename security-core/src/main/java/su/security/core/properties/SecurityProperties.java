package su.security.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 苏征
 * @date 2018-12-18
 */
@Data
@ConfigurationProperties(prefix = "su.security")
public class SecurityProperties {
    private BrowserProperties browser = new BrowserProperties();

    private OAuth2Properties oauth2 = new OAuth2Properties();

    private ValidateCodeProperties code = new ValidateCodeProperties();

    private SocialProperties social = new SocialProperties();


}
