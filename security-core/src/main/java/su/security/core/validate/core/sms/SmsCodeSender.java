package su.security.core.validate.core.sms;

/**
 * @author 苏征
 * @date 2018-12-21
 */
public interface SmsCodeSender {

    void send(String mobile, String code);
}
