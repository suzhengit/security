package su.security.app.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.social.security.SpringSocialConfigurer;
import su.security.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import su.security.core.properties.SecurityConstants;
import su.security.core.properties.SecurityProperties;

/**
 * @Author:苏征
 * @Date: 2019/10/17
 */
@Configuration
@EnableResourceServer
public class SuAuthorizationServerConfig extends ResourceServerConfigurerAdapter {
    @Autowired
    private SecurityProperties securityProperties;
    @Autowired
    private AuthenticationSuccessHandler suAuthenticationSuccessHandler;
    @Autowired
    private AuthenticationFailureHandler suAuthenticationFailureHandler;
    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;
    @Autowired
    private SpringSocialConfigurer suSocialConfig;
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.formLogin()
              //  .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
                .loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
                .successHandler(suAuthenticationSuccessHandler)
                .failureHandler(suAuthenticationFailureHandler);
        http //.apply(validateCodeSecurityConfig)
               // .and()
                .apply(smsCodeAuthenticationSecurityConfig)
                .and()
                .apply(suSocialConfig)
                .and()

                .authorizeRequests()
                .antMatchers(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
                        SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
                        securityProperties.getBrowser().getLoginPage(),
                        SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/*",
                        securityProperties.getBrowser().getSignUpUrl(),
                        "/user/register")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();
    }
}
