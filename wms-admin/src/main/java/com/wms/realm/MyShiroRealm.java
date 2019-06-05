package com.wms.realm;

import com.wms.service.AucctService;
import com.wms.util.JWTToken;
import com.wms.util.JwtUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by cyh on 2019/3/26.
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private AucctService userService;

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {


        System.out.println("————身份认证方法————");
        String token = (String) authenticationToken.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JwtUtil.getUsername(token);
        if (username == null || !JwtUtil.verify(token, username)) {
            throw new AuthenticationException("token认证失败！");
        }
        String password = userService.getPassWordByUserName(username);
        if (password == null) {
            throw new AuthenticationException("该用户不存在！");
        }
        return new SimpleAuthenticationInfo(token, token, "MyRealm");
    }

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("————授权方法————");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Object o = principalCollection.getPrimaryPrincipal();
        if(o instanceof String){
            String username = JwtUtil.getUsername(o.toString());
            authorizationInfo.addRoles(userService.getRolesByUsername(username));
            authorizationInfo.addStringPermissions(userService.getPermissionsByUsername(username));
        }
        return authorizationInfo;
    }


    /**
     * 大坑！，必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }



}
