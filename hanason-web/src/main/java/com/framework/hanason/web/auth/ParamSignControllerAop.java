package com.framework.hanason.web.auth;

import com.framework.hanason.common.exception.WebServerException;
import com.framework.hanason.common.strings.Strings;
import com.framework.hanason.config.properties.SystemProperties;
import com.framework.hanason.web.enums.ErrorCodeEnum;
import com.framework.hanason.web.vo.BaseSignRequestBody;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author sorata 2020-03-27 10:20
 * <p>
 * 这个是针对需要验证加密参数的接口，主要是针对登录这种一开始没有获取到token不能进行token认证的接口
 */
@Component
@Aspect
@Order(1)
@ConditionalOnBean(SystemProperties.class)
public class ParamSignControllerAop {

    private final SystemProperties systemProperties;

    public ParamSignControllerAop(SystemProperties systemProperties) {
        this.systemProperties = systemProperties;
    }

    @Pointcut(value = "@annotation(com.framework.hanason.web.auth.SignParam)")
    public void point() {
    }


    @Before(value = "point()")
    public void around(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        boolean done = false;
        for (Object arg : args) {
            if (arg instanceof BaseSignRequestBody) {
                if (Strings.isNullOrEmpty(((BaseSignRequestBody) arg).getSign())) {
                    throw new WebServerException(ErrorCodeEnum.NOT_FOUND_SIGN_PARAM.getCode(),
                            ErrorCodeEnum.NOT_FOUND_SIGN_PARAM.getMsg());
                }
                if (((BaseSignRequestBody) arg).getTx() < (System.currentTimeMillis() / 1000L - 300)) {
                    throw new WebServerException(ErrorCodeEnum.PARAM_SIGN_TIMEOUT.getCode(),
                            ErrorCodeEnum.PARAM_SIGN_TIMEOUT.getMsg());
                }
                String singChar = ((BaseSignRequestBody) arg).getSingChar();
                byte[] doFinal = HmacUtils.getInitializedMac(HmacAlgorithms.HMAC_SHA_256,
                        systemProperties.getSystem().getApiSignKey().getBytes()).doFinal(singChar.getBytes());
                if (!((BaseSignRequestBody) arg).getSign().equals(Hex.encodeHexString(doFinal))) {
                    throw new WebServerException(ErrorCodeEnum.PARAM_SIGN_ERROR.getCode(),
                            ErrorCodeEnum.PARAM_SIGN_ERROR.getMsg());
                }
                done = true;
            }
        }
        if (!done) {
            throw new WebServerException(ErrorCodeEnum.NOT_FOUND_SIGN_PARAM.getCode(),
                    ErrorCodeEnum.NOT_FOUND_SIGN_PARAM.getMsg());
        }
    }

}
