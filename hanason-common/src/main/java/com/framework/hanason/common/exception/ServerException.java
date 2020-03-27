package com.framework.hanason.common.exception;

/**
 * @author sorata 2020-03-16 11:43
 *
 * 服务器端异常
 */
public class ServerException extends RootRuntimeException {

    public ServerException(Integer code, String message) {
        super(code, message);
    }
}
