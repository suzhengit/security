package su.security.core.properties;


import lombok.Data;

/**
 * @Author:苏征
 * @Date: 2019/10/18
 */
@Data
public class Oauth2ClientProperties {

    private String clientId;

    private String clientSecret;

    private int accessTokenValiditySecond;


}
