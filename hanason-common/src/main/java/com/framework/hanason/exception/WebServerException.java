package com.framework.hanason.exception;

/**
 * @author sorata 2020-03-16 11:42
 *
 * web类的异常
 */
public class WebServerException extends RootRuntimeException  {

    public WebServerException(Integer code, String message) {
        super(code, message);
    }
}
