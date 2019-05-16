package su.security.core.social.qq.connet;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import su.security.core.social.qq.api.QQ;
import su.security.core.social.qq.api.QQImpl;

/**
 * 苏征
 * 2019/4/29
 */
public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQ> {

    private String appId;

    private static final String URL_AUTHORIZE  = "https://graph.qq.com/oauth2.0/authorize";

    private static final String URL_ACCESS_TOKEN = "https://graph.qq.com/oauth2.0/token";

    /**
     * Create a new {@link OAuth2ServiceProvider}.
     *
     * @param oauth2Operations the OAuth2Operations template for conducting the OAuth 2 flow with the provider.
     */
    public QQServiceProvider(String appId, String appSecret) {
        super(new QQOAuth2Template(appId, appSecret, URL_AUTHORIZE, URL_ACCESS_TOKEN));
        this.appId = appId;
    }

    @Override
    public QQ getApi(String accessToken) {
        return new QQImpl(accessToken, appId);
    }
}
