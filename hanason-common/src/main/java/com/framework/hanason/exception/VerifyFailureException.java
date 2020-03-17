package com.framework.hanason.exception;

/**
 * @author sorata 2020-03-16 11:39
 *
 * 验证类的异常
 */
public class VerifyFailureException extends RootRuntimeException {

    public VerifyFailureException(Integer code, String message) {
        super(code, message);
    }
}
