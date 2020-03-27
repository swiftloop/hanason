package com.framework.hanason.controller;

import com.alibaba.fastjson.JSON;
import com.framework.hanason.common.random.IdGenerator;
import com.framework.hanason.service.AsyncTestService;
import com.framework.hanason.web.jwt.JwtMaker;
import com.framework.hanason.web.vo.UserTokenVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.WebAsyncTask;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Base64;
import java.util.Enumeration;
import java.util.concurrent.Callable;

/**
 * @author sorata 2020-03-16 18:11
 */
@Api("用户信息接口")
@RestController
@RequestMapping("/api/v1")
public class UserController {

    private static String COPY_RAN = "";
    private static String COPY_RAN2 = "";

    @Autowired private AsyncTestService service;

    @ApiOperation("获取名字")
    @GetMapping("name")
    public String name(HttpServletRequest request) {
        UserTokenVo tokenVo = new UserTokenVo().setPhone("19111011101").setPlatform("baidu").setTag("CA_IA");
        System.out.println(JSON.toJSONString(request.getHeaderNames()));
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String element = headerNames.nextElement();
            System.out.println("name=" + element + "   values:" + request.getHeader(element));
        }
     //   service.name();
      //  int a = 1 /0;
        return JwtMaker.create(tokenVo);
    }


    @ApiOperation("解析")
    @PostMapping("/fix")
    public String nameFix(@RequestParam String token) {
        return JwtMaker.verify(token);
    }



    @GetMapping("some")
    public void asyncRequest(HttpServletRequest request){
        AsyncContext asyncContext = request.startAsync();
        asyncContext.setTimeout(10 * 1000);
        asyncContext.addListener(new AsyncListener() {
            @Override
            public void onComplete(AsyncEvent event) throws IOException {
                System.out.println("onComplete");
            }

            @Override
            public void onTimeout(AsyncEvent event) throws IOException {
                System.out.println("onTimeout");
            }

            @Override
            public void onError(AsyncEvent event) throws IOException {
                System.out.println("onError");
            }

            @Override
            public void onStartAsync(AsyncEvent event) throws IOException {
                System.out.println("onStartAsync");
            }
        });

        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                Enumeration<String> headerNames = request.getHeaderNames();
                while (headerNames.hasMoreElements()) {
                    String element = headerNames.nextElement();
                    System.out.println("name=" + element + "   values:" + request.getHeader(element));
                }
                service.name();
                asyncContext.complete();
            }
        });


    }



    @GetMapping("/hello")
    public Callable<String> callable(){
        return new Callable<String>() {
            @Override
            public String call() throws Exception {

                Thread.sleep(20000);
                System.out.println(Thread.currentThread().getName());
                return "hello callable";
            }
        };
    }




    @GetMapping("/hello2")
    public WebAsyncTask<String> webAsyncTask(){
        System.out.println("执行异步任务");
        WebAsyncTask<String> stringWebAsyncTask = new WebAsyncTask<>(2000, new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(20000);
                System.out.println(Thread.currentThread().getName());
                return "hello callable";
            }
        });
        System.out.println("忽略实质任务继续执行");
        stringWebAsyncTask.onTimeout(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "超时了";
            }
        });
        System.out.println("返回结果，等待异步处理");
        return stringWebAsyncTask;
    }


    @GetMapping("/bytes")
    public String anc(){
        byte[] bytes = new byte[1024 * 1024];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte)( (int)(Math.random() * Math.pow(10,2)) & 0xFF);
        }
        String s = Base64.getUrlEncoder().encodeToString(bytes);
        return s;
    }


    @GetMapping("/rand")
    public String rand(){
        long  l = System.nanoTime();
        String s = IdGenerator.randStr(50);
        if (COPY_RAN.equals(s)){
            return "随机重复了";
        }
        COPY_RAN = s;
        System.out.println(String.format("执行了%fs",(System.nanoTime()- l) / 1000000000f));
        return s;
    }

    @GetMapping("/rand2")
    public String rand2(){
        long  l = System.nanoTime();
        String s = IdGenerator.randStr2(50);
        if (COPY_RAN2.equals(s)){
            return "随机重复了";
        }
        COPY_RAN2 = s;
        System.out.println(String.format("执行了%fs",(System.nanoTime()- l) / 1000000000f));
        return s;
    }

}
