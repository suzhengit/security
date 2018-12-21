package su.security.core.validate.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import su.security.core.properties.SecurityProperties;
import su.security.core.validate.core.sms.DefaultSmsCodeSender;
import su.security.core.validate.core.sms.SmsCodeSender;

/**
 * @author 苏征
 * @date 2018-12-20
 */
@Configuration
public class ValidateCodeBeanConfig {
@Autowired
private SecurityProperties securityProperties;
    @Bean
    @ConditionalOnMissingBean(name = "imageCodeGenerator")
    public ValidateCodeGenerator imageCodeGenerator() {
        ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
        codeGenerator.setSecurityProperties(securityProperties);
        return codeGenerator;
    }

    @Bean
    @ConditionalOnMissingBean(SmsCodeSender.class)
    public SmsCodeSender smsCodeSender() {
        return new DefaultSmsCodeSender();
    }
}
