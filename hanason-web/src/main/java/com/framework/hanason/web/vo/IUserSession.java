package com.framework.hanason.web.vo;

/**
 * @author sorata 2020-03-27 19:26
 */
public interface IUserSession {

    /**
     * 存储的sessionId
     * @return sessionId
     */
    String getHttpSessionId();

    /**
     * 得到唯一的用户id
     * @return id
     */
    String getId();


}
