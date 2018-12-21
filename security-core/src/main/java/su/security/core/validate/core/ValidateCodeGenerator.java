package su.security.core.validate.core;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author 苏征
 * @date 2018-12-20
 */
public interface ValidateCodeGenerator {

    ValidateCode generate(ServletWebRequest request);
}
