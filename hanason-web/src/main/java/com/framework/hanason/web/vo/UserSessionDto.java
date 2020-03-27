package com.framework.hanason.web.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author sorata 2020-03-27 18:18
 */
@Data
@Accessors(chain = true)
public class UserSessionDto implements UserDto,IUserSession {

    private static final long serialVersionUID = 4650356302708413023L;

    private String sessionId;

    private BaseUserInfo baseUserInfo;


    @Override
    public String getHttpSessionId() {
        return sessionId;
    }

    @Override
    public String getId() {
        return baseUserInfo == null ? null : baseUserInfo.getUserId();
    }
}
