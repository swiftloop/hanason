package com.framework.hanason.common.exception;

/**
 * @author sorata 2020-03-27 18:24
 */
public class IllegalArgumentException extends RootRuntimeException {

    private static final long serialVersionUID = 7780116506472365696L;

    public IllegalArgumentException(Integer code, String message) {
        super(code, message);
    }
}
