package su.security.core.validate.core;

import lombok.Data;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @author 苏征
 * @date 2018-12-19
 */
@Data
public class ImageCode {

    private BufferedImage image;

    private String code;

    private LocalDateTime expireTime;

    public ImageCode(BufferedImage image, String code, int expireIm) {
        this.image = image;
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIm);
    }

    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
        this.image = image;
        this.code = code;
        this.expireTime = expireTime;
    }
    public boolean isExpried() {
        return LocalDateTime.now().isAfter(expireTime);
    }
}
