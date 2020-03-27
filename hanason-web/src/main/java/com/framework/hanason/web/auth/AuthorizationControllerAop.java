package com.framework.hanason.web.auth;

import com.framework.hanason.common.exception.WebServerException;
import com.framework.hanason.common.strings.Strings;
import com.framework.hanason.web.enums.ErrorCodeEnum;
import com.framework.hanason.web.jwt.JwtMaker;
import com.framework.hanason.web.users.UserHolder;
import com.framework.hanason.web.utils.WebUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sorata 2020-03-26 18:28
 */
@Aspect
@Component
@Order(2)
public class AuthorizationControllerAop {


    @Pointcut(value = "@annotation(com.framework.hanason.web.auth.AuthorizationApi)")
    public void point(){}


    @Around(value = "point()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = WebUtil.getRequest();
        if (request == null){
            return ErrorCodeEnum.err(ErrorCodeEnum.NOT_FOUND_REQUEST);
        }
        String authorization = request.getHeader("Authorization");
        if (Strings.isNullOrEmpty(authorization)){
            return ErrorCodeEnum.err(ErrorCodeEnum.NOT_FOUND_AUTH_HEADER);
        }
        try {
            String verify = JwtMaker.verify(authorization);
            UserHolder.setUser(verify);
        } catch (WebServerException e) {
            return e.toResult();
        }

        try {
            System.out.println("执行了身份验证");
          return joinPoint.proceed();
        } finally {
            System.out.println("执行了finally");
            UserHolder.remove();
        }
    }
}
