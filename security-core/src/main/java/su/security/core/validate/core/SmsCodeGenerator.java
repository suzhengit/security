package su.security.core.validate.core;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;
import su.security.core.properties.SecurityProperties;

/**
 * @author 苏征
 * @date 2018-12-21
 */
@Component("smsCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {
    @Autowired
    private SecurityProperties securityProperties;
    @Override
    public ValidateCode generate(ServletWebRequest request) {

        String code = RandomStringUtils.randomNumeric(securityProperties.getSms().getLength());
        return new ValidateCode(code, securityProperties.getSms().getExpireIn());
    }

    public SecurityProperties getSecurityProperties() {
        return securityProperties;
    }

    public void setSecurityProperties(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }
}
