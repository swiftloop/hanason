package com.framework.hanason.web;

import com.framework.hanason.common.domain.ResultData;
import com.framework.hanason.common.exception.RootRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author sorata 2020-03-26 19:25
 */
@RestControllerAdvice
@Slf4j
public class ExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public ResultData resultData(Exception e){
        if (e instanceof RootRuntimeException){
            return ResultData.err(((RootRuntimeException) e).getCode(),((RootRuntimeException) e).getMsg());
        }
        log.error("当前异常为:",e);
        return ResultData.err(e.getMessage());
    }

}
