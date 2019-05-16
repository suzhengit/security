package su.security.browser;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;

/**
 * @author 苏征
 * @date 2018-12-18
 */
@Slf4j
@Component
public class MyUserDetailsService implements UserDetailsService, SocialUserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return buildUser(username);
    }

    @Override
    public SocialUserDetails loadUserByUserId(String userID) throws UsernameNotFoundException {
        return buildUser(userID);
    }

    private SocialUserDetails buildUser(String userID) {
        log.info("登录用户ID:{{}}", userID);
        //User的构造函数中, password直接放加密后的密文, enabled是否删除, accountNonExpired账号是否过期,credentialsNonExpired密码是否过期, accountNonLocked账号是否被锁了
        return new SocialUser(userID,
                passwordEncoder.encode("123456"),
                true,
                true,
                true,
                true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
