package com.framework.hanason.common.exception;

/**
 * @author sorata 2020-03-16 11:44
 *
 * api接口的异常
 */
public class ApiException extends RootRuntimeException {

    public ApiException(Integer code, String message) {
        super(code, message);
    }
}
