package su.security.core.validate.core.sms;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 苏征
 * @date 2018-12-21
 */
@Slf4j
public class DefaultSmsCodeSender implements SmsCodeSender {

    @Override
    public void send(String mobile, String code) {
        log.info("向手机{}发送短信验证码{}", mobile, code);
    }
}
