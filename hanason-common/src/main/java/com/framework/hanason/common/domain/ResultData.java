package com.framework.hanason.common.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author sorata 2020-03-16 11:45
 */
public class ResultData<T> implements Serializable {

    private static final long serialVersionUID = 7547822757028033816L;

    private final Integer code;

    private final String message;

    private final T data;

    private static final Integer OK_CODE = 200;
    private static final Integer ERROR_CODE = 500;


    private ResultData(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ResultData<T> ok(Integer code, String message, T data) {
        return new ResultData<>(code, message, data);
    }

    public static <T> ResultData<T> ok(Integer code, T data) {
        return ok(code, "OK", data);
    }

    public static <T> ResultData<T> ok(T data) {
        return ok(OK_CODE, data);
    }

    public static ResultData ok() {
        return ok(null);
    }

    public static <K,V> ResultData ok(Result<K,V> result){
        HashMap<K, V> map = new HashMap<>(8);
        result.action(map);
        return ok(map);
    }


    public static ResultData okMsg(String message) {
        return new ResultData<>(OK_CODE, message, null);
    }

    public static ResultData err(Integer code,String message){
        return new ResultData<>(code,message,null);
    }

    public static ResultData err(String message) {
        return err(ERROR_CODE,message);
    }

    public static ResultData err() {
        return err("ERROR");
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    @FunctionalInterface
    public interface Result<S,V>{
       void action(Map<S,V> map);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ResultData<?> that = (ResultData<?>) o;
        return code.equals(that.code) &&
                message.equals(that.message) &&
                data.equals(that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message, data);
    }

    @Override
    public String toString() {
        return "ResultData{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
