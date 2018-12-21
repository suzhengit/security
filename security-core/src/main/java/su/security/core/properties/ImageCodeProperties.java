package su.security.core.properties;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 苏征
 * @date 2018-12-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ImageCodeProperties extends SmsCodeProperties{
    private int width = 67;

    private int height = 23;

    public ImageCodeProperties() {
       setLength(4);
    }
}
