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
}
