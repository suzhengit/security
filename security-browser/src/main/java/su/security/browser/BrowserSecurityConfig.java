package su.security.browser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import su.security.core.properties.SecurityProperties;
import su.security.core.validate.core.ValidateCodeFilter;

/**
 * @author 苏征
 * @date 2018-12-18
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;
    @Autowired
    private AuthenticationSuccessHandler suAuthenticationSuccessHandler;
    @Autowired
    private AuthenticationFailureHandler suAuthenticationFailureHandler;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
        validateCodeFilter.setAuthenticationFailureHandler(suAuthenticationFailureHandler);
        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                .loginPage("/authentication/require")
                .loginProcessingUrl("/authentication/form")
                .successHandler(suAuthenticationSuccessHandler)
                .failureHandler(suAuthenticationFailureHandler)
                .and()
                .authorizeRequests()
                .antMatchers("/authentication/require", securityProperties.getBrowser().getLoginPage(), "/code/image").permitAll()//登录页面一定要这个配置,不然系统会不停地跳转到这个页面,导致死循环
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();
    }

}
