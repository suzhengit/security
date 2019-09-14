package su.security.core.social.weixin.connect;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.social.oauth2.AccessGrant;

/**
 * 苏征
 * 2019/5/16
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WeiXinAccessGrant extends AccessGrant {

    private static final long serialVersionUID = -7243374526633186782L;

    private String openId;

    public WeiXinAccessGrant() {
        super("");
    }
    public WeiXinAccessGrant(String accessToken, String scope, String refreshToken, Long expiresIn) {
        super(accessToken, scope, refreshToken, expiresIn);
    }
}
