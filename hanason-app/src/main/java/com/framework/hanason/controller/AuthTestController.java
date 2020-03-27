package com.framework.hanason.controller;

import com.framework.hanason.common.domain.ResultData;
import com.framework.hanason.web.auth.AuthorizationApi;
import com.framework.hanason.web.auth.SignParam;
import com.framework.hanason.web.base.BaseMobileApiController;
import com.framework.hanason.web.vo.UserLogin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sorata 2020-03-26 17:07
 */
@RestController
@RequestMapping("/api/v1")
public class AuthTestController extends BaseMobileApiController {

    @AuthorizationApi
    @GetMapping("/auth")
    @SignParam
    public ResultData auth(@RequestBody UserLogin login ){
        System.out.println("方法执行了");
        String user = getUserId();
       // int a = 1 /0 ;
        return ResultData.ok( "当前登录的用户是:" + user);
    }

}
