package su.security.core.properties;

import lombok.Data;

/**
 * @author 苏征
 * @date 2018-12-19
 */
@Data
public class ImageCodeProperties {
    private int width = 67;

    private int height = 23;

    private int length = 4;

    private int expireIn = 60;



}
