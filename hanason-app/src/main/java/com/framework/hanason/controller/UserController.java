package com.framework.hanason.controller;

import com.framework.hanason.domain.users.UserTokenVo;
import com.framework.hanason.jwt.JwtMaker;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author sorata 2020-03-16 18:11
 */
@Api("用户信息接口")
@RestController
@RequestMapping("/api/v1")
public class UserController {

    @ApiOperation("获取名字")
    @GetMapping("name")
    public String name(){
        UserTokenVo tokenVo = new UserTokenVo().setPhone("19111011101").setPlatform("baidu").setTag("CA_IA");
        return JwtMaker.create(tokenVo);
    }


    @ApiOperation("解析")
    @PostMapping("/fix")
    public String nameFix(@RequestParam String token){
        return JwtMaker.verify(token);
    }



}
