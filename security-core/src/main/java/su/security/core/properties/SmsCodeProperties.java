package su.security.core.properties;

import lombok.Data;

/**
 * @author 苏征
 * @date 2018-12-21
 */
@Data
public class SmsCodeProperties {

    private int length = 6;

    private int expireIn = 60;

    private String url;
}
