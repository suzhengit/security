package su.security.core.properties;

import lombok.Data;

/**
 * @author 苏征
 * @date 2018-12-18
 */
@Data
public class BrowserProperties {

    private String loginPage = "/su-signIn.html";

    private LoginType loginType = LoginType.JSON;

}
