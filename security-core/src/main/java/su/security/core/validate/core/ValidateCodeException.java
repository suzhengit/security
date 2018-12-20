package su.security.core.validate.core;


import org.springframework.security.core.AuthenticationException;

/**
 * @author 苏征
 * @date 2018-12-19
 */
public class ValidateCodeException extends AuthenticationException {
    public ValidateCodeException(String explanation) {
        super(explanation);
    }
}
