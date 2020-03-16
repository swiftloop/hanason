package com.framework.hanason.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return "tom";
    }


}
