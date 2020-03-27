package com.framework.hanason.common.exception;

/**
 * @author sorata 2020-03-24 15:22
 *
 * 数字异常
 */
public class NumberAccessException extends RootRuntimeException {

    public NumberAccessException(Integer code, String message) {
        super(code, message);
    }
}
