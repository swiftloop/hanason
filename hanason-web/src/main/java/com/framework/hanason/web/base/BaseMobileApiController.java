package com.framework.hanason.web.base;


import com.framework.hanason.web.users.UserHolder;

/**
 * @author sorata 2020-03-26 15:56
 *
 * 提供给app端的接口
 */
public abstract class BaseMobileApiController implements BaseApiController{

    /**
     * 这个方法只能在使用{@link com.framework.hanason.web.auth.AuthorizationApi}的方法中使用，只有在aop获取
     * @return 用户的唯一id
     */
    protected String getUserId(){
        return UserHolder.getUserId();
    }
    
    
    
    
    
}
