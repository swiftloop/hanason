package com.framework.hanason.web.session;

import com.framework.hanason.common.exception.ExceptionUtils;
import com.framework.hanason.common.strings.Strings;
import com.framework.hanason.web.vo.IUserSession;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author sorata 2020-03-27 18:14
 */
public class InMemorySessionManagerImpl<T extends IUserSession> implements SessionManager<T> {

    private final ConcurrentHashMap<String, T> MAP = new ConcurrentHashMap<>(16);


    @Override
    public T getUser(String userId) {
        ExceptionUtils.isTrue(Strings.isNotBlack(userId), "获取session用户时，用户id不能为空");
        return MAP.get(userId);
    }

    @Override
    public void put(T user) {
        if (user == null) {
            return;
        }
        remove(user.getId());
        MAP.put(user.getId(), user);
    }

    @Override
    public void remove(HttpSession session) {
        if (session == null) {
            return;
        }
        for (Map.Entry<String, T> entry : MAP.entrySet()) {
            if (entry.getValue().getHttpSessionId().equals(session.getId())) {
                remove(entry.getKey());
                break;
            }
        }
    }

    @Override
    public void remove(String userId) {
        if (Strings.isNullOrEmpty(userId)) {
            return;
        }
        MAP.remove(userId);
    }
}
