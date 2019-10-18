package su.security.core.properties;

import lombok.Data;

/**
 * @Author:苏征
 * @Date: 2019/10/18
 */
@Data
public class OAuth2Properties {

    private String jwtSigningKey = "su";

    private Oauth2ClientProperties[] clients = {};


}
