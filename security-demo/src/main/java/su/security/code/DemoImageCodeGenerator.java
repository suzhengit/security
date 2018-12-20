package su.security.code;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;
import su.security.core.validate.core.ImageCode;
import su.security.core.validate.core.ValidateCodeGenerator;

/**
 * 以增量的方式适应变化
 * @author 苏征
 * @date 2018-12-20
 */
//@Component("imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {
    @Override
    public ImageCode generate(ServletWebRequest request) {
        System.out.println("更高级的图形验证码生成代码");
        return null;
    }
}
