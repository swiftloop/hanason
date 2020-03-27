package com.framework.hanason.web.jwt;

import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

/**
 * @author sorata 2020-03-17 11:34
 *
 * 创建一个密钥以便完成签名
 */
@Slf4j
class KeyProvider {

    private static final String KEY;


    static {
        KEY = UUID.randomUUID().toString() + "_" + System.currentTimeMillis();
        log.info("token-key:{}",KEY);
    }



    static String getKey(){
        return KEY;
    }

}
