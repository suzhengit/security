package su.security.core.validate.core.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.context.request.ServletWebRequest;
import su.security.core.validate.core.ValidateCode;
import su.security.core.validate.core.ValidateCodeGenerator;
import su.security.core.validate.core.ValidateCodeProcessor;

import java.util.Map;

/**
 * 分级概念
 * @author 苏征
 * @date 2018-12-21
 */
public abstract class AbstractValidateCodeProcessor<T extends ValidateCode> implements ValidateCodeProcessor {

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
    /**
     * 收集系统中所有的ValidateCodeGenerator接口的实现
     */
    @Autowired
    private Map<String, ValidateCodeGenerator> validateCodeGenerators;

    /**
     * 验证码功能逻辑
     * @param request
     * @throws Exception
     */
    @Override
    public void create(ServletWebRequest request) throws Exception {
        T validateCode = generate(request); //1.生成
        save(request, validateCode); //2.保存
        send(request, validateCode); //3.发送
    }

    /**
     * 发送校验码, 由子类实现
     * @param request
     * @param validateCode
     */
    protected abstract void send(ServletWebRequest request, T validateCode) throws Exception;

    /**
     * 保存校验码的逻辑
     * @param request
     * @param validateCode
     */
    private void save(ServletWebRequest request, T validateCode) {
        sessionStrategy.setAttribute(request, SESSION_KEY_PREFIX + getProcessorType(request).toUpperCase(), validateCode);
    }

    /**
     * 生成校验码
     * @param request
     * @return
     */
    @SuppressWarnings("unchecked")
    private T generate(ServletWebRequest request) {
        String type = getProcessorType(request);
        ValidateCodeGenerator validateCodeGenerator = validateCodeGenerators.get(type + "CodeGenerator");
        return (T) validateCodeGenerator.generate(request);
    }

    /**
     * 根据请求的url获取校验码的类型
     * @param request
     * @return
     */
    private String getProcessorType(ServletWebRequest request) {
        return StringUtils.substringAfter(request.getRequest().getRequestURI(), "/code/");
    }
}
