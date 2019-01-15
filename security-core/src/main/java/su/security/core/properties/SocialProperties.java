package su.security.core.properties;

import lombok.Data;

/**
 * @author 苏征
 * @date 2019-01-15
 */
@Data
public  class SocialProperties {

    private QQProperties qq = new QQProperties();

    private String appId;

    private String appSecret;
}
