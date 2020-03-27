package com.framework.hanason.common.exception;

/**
 * @author sorata 2020-03-16 11:38
 * 参数错误
 */
public class ParamErrorException extends RootRuntimeException {

    public ParamErrorException(Integer code, String message) {
        super(code, message);
    }
}
