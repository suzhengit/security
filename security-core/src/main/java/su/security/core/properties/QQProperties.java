package su.security.core.properties;

import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * 苏征
 * 2019/4/29
 */
public class QQProperties extends SocialProperties {

    private String providerId = "qq";

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }
}
