package su.security.core.properties;

import lombok.Data;

/**
 * @author 苏征
 * @date 2018-12-19
 */
@Data
public class ValidateCodeProperties {
    private ImageCodeProperties image = new ImageCodeProperties();
    private SmsCodeProperties sms = new SmsCodeProperties();


}
