package com.framework.hanason.web.jwt;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.framework.hanason.common.date.DateTool;
import com.framework.hanason.common.exception.WebServerException;
import com.framework.hanason.web.enums.ErrorCodeEnum;
import com.framework.hanason.web.vo.UserDto;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

/**
 * @author sorata 2020-03-17 11:59
 * <p>
 * 这里只保证了签名的不可改 但是没有对subject数据进行加密 实质上subject的数据是base64加密的，跟明文一样，不能保存私密的数据
 */
@Slf4j
public final class JwtMaker {

    /**
     * 签发者
     */
    private static final String ISSUER = "V1";
    /**
     * 3个小时
     */
    private static final int EXPIRE_INTERVAL = 3;


    public static String create(UserDto userDto) {
        LocalDateTime now = LocalDateTime.now();
        return JWT.create().withExpiresAt(DateTool.toDate(now.plusDays(EXPIRE_INTERVAL)))
                .withSubject(JSON.toJSONString(userDto)).withNotBefore(DateTool.toDate(now.minusMinutes(5))).sign(Algorithm.HMAC256(KeyProvider.getKey()));
    }

    public static String verify(String sign) {
        try {
            DecodedJWT decode = JWT.require(Algorithm.HMAC256(KeyProvider.getKey())).build().verify(sign);
            return decode.getSubject();
        } catch (JWTVerificationException | IllegalArgumentException e) {
            if (log.isDebugEnabled()) {
                log.debug("验证jwt失败", e);
            }
            if (e instanceof InvalidClaimException | e instanceof TokenExpiredException) {
                throw new WebServerException(ErrorCodeEnum.TOKEN_TIME_OUT.getCode(), ErrorCodeEnum.TOKEN_TIME_OUT.getMsg());
            }
            throw new WebServerException(ErrorCodeEnum.TOKEN_VALID_ERROR.getCode(), ErrorCodeEnum.TOKEN_VALID_ERROR.getMsg());
        }
    }


}
