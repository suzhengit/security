package su.security.core.validate.core;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 校验码处理器,封装不同校验码的处理逻辑(如果是另一个处理逻辑,实现这个接口即可)
 * @author 苏征
 * @date 2018-12-21
 */
public interface ValidateCodeProcessor {

    String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";

    void create(ServletWebRequest request) throws Exception;
}
