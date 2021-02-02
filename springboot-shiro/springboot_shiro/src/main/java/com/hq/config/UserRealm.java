package com.hq.config;

import com.hq.mapper.UserMapper;
import com.hq.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Subject subject = SecurityUtils.getSubject();
        User currentuser = (User) subject.getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //设置每个用户对应他们的权限
        info.addStringPermission(currentuser.getPerm());

        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        User user = userMapper.queryByName(userToken.getUsername());
        if (user == null) {
            //比对失败会抛出用户不存在错误
            return null;
        }
        //密码可以加密  md5  md5盐值加密
        //shiro 不做密码认证 防止密码泄露
//        SimpleAuthenticationInfo  simple = new SimpleAuthenticationInfo();
//        //将user 放进去 以便上面授权时进行取值
//        simple.setPrincipals(new SimplePrincipalCollection(user,""));
//        simple.setCredentials(user.getPassword());
//        return  simple;
        //以上可以简写为一句
        return new SimpleAuthenticationInfo(user, user.getPassword(), "");
    }
}
