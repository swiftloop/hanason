package com.framework.hanason.web.users;

import com.framework.hanason.common.exception.ExceptionUtils;
import com.framework.hanason.web.jwt.JwtMaker;
import com.framework.hanason.web.session.SessionManager;
import com.framework.hanason.web.vo.BaseUserInfo;
import com.framework.hanason.web.vo.UserSessionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * @author sorata 2020-03-27 18:35
 *
 * 这个类主要是为了屏蔽多个user pojo之间的转换
 *
 *
 */
@Service
public class UserManager {

    @Autowired private SessionManager<UserSessionDto> sessionManager;


    /**
     * 得到经过身份验证拦截后的用户的身份信息
     * {@link com.framework.hanason.web.auth.AuthorizationControllerAop}
     * {@link com.framework.hanason.web.auth.AuthorizationApi}
     * @return 当前验证完毕的用户的id
     */
    public String getCurrThreadUserId(){
        return UserHolder.getUserId();
    }

    /**
     * 使用jwt生成用户的token信息
     * @param userInfo BaseUserInfo
     * @return 带签名的jwt
     */
    public String getToken(BaseUserInfo userInfo){
       return JwtMaker.create(userInfo);
    }

    public  String login(BaseUserInfo userInfo, HttpSession session){
        ExceptionUtils.isTrue(userInfo != null,"登录的用户信息不能为空");
        UserSessionDto userSessionDto = new UserSessionDto().setBaseUserInfo(userInfo)
                .setSessionId(session.getId());
        sessionManager.put(userSessionDto);
        return getToken(userInfo);
    }

}
