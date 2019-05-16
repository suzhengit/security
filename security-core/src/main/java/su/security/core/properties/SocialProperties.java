package su.security.core.properties;

import lombok.Data;

/**
 * 苏征
 * 2019/4/29
 */
@Data
public class SocialProperties {

    private String filterProcessesUrl = "/auth";

    private QQProperties qq = new QQProperties();

    private WeixinProperties weixin = new WeixinProperties();

    private String appId;

    private String appSecret;
}
