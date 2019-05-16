package su.security.core.social.weixin.api;

/**
 * 苏征
 * 2019/5/16
 */
public interface Weixin {
    WeixinUserInfo getUserInfo(String openId);
}
