package com.framework.hanason.common.exception;

/**
 * @author sorata 2020-03-16 11:37
 *
 * 包装null异常
 */
public class NullDataException extends RootRuntimeException {

    public NullDataException(Integer code, String message) {
        super(code, message);
    }
}
