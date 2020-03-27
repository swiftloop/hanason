package com.framework.hanason.web.session;

import javax.servlet.http.HttpSession;

/**
 * @author sorata 2020-03-27 17:52
 */
public interface SessionManager<T> {

    /**
     * 得到存储在session中的用户实例
     * @param userId 用户的唯一标识
     * @return T
     */
    T getUser(String userId);

    /**
     * 存储 user 与 session
     * @param user 用户
     */
    void put(T user);



    void remove(HttpSession session);

    void remove(String userId);

}
