package su.security.core.social.qq;

import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * 苏征
 * 2019/5/6
 */
public class SuSpringSocialConfigurer extends SpringSocialConfigurer {
    private String filterProcessesUrl;

    public SuSpringSocialConfigurer(String filterProcessesUrl) {
        this.filterProcessesUrl = filterProcessesUrl;
    }

    @Override
    protected <T> T postProcess(T object) {
        SocialAuthenticationFilter process = (SocialAuthenticationFilter) super.postProcess(object);
        process.setFilterProcessesUrl(filterProcessesUrl);
        return (T)process;
    }
}
