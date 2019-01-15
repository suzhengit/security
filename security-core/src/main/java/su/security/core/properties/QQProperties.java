package su.security.core.properties;

import lombok.Data;
import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * @author 苏征
 * @date 2019-01-15
 */
@Data
public class QQProperties extends SocialProperties {

    private String providerId = "qq";
}
