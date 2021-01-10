package com.kapcb.ccc.commons.realm;

import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import sun.security.provider.MD5;

import java.util.Objects;

/**
 * <a>Title: UserRealm </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/10 21:53
 */
@Slf4j
@RequiredArgsConstructor
public class UserRealm extends AuthorizingRealm {

    private final UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        User user = userService.getUserByUserName(username);
        if (Objects.equals(null, user) && Objects.equals(null, user.getPassword())) {

        }
        return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), new Md5Hash(user.getPassword(), "salt", 2), getName());
    }
}
