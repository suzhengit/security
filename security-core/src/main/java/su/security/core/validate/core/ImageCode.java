package su.security.core.validate.core;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @author 苏征
 * @date 2018-12-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ImageCode extends ValidateCode {

    private BufferedImage image;


    public ImageCode(BufferedImage image, String code, int expireIm) {
        super(code, expireIm);
        this.image = image;
    }

    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
        super(code, expireTime);
        this.image = image;
    }

}
