package su.security.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import su.security.model.User;

import javax.servlet.http.HttpServletRequest;

/**
 * 苏征
 * 2019/5/14
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private ProviderSignInUtils providerSignInUtils;
    @PostMapping("/register")
    public void register(User user, HttpServletRequest request) {
        String userId = user.getUsername();
        providerSignInUtils.doPostSignUp(userId, new ServletWebRequest(request));
        //注册用户
    }
}
