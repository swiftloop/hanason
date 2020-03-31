package com.framework.hanason.web.session;

import com.framework.hanason.config.SysContants;
import com.framework.hanason.web.vo.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author sorata 2020-03-30 09:44
 */
@Component
@WebListener
@Slf4j
public class SessionListener implements HttpSessionListener {

    private final SessionManager<UserDto> sessionManager;

    public SessionListener(SessionManager<UserDto> sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        if (SysContants.isDEBUG()){
            log.info("当前有session创建: {}",se.getSession().getId());
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        if (SysContants.isDEBUG()){
            log.info("当前有session销毁: {}",se.getSession().getId());
        }
        sessionManager.remove(se.getSession());
    }
}
