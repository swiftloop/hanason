package com.framework.hanason.common.exception;

/**
 * @author sorata 2020-03-27 18:21
 */
public final class ExceptionUtils {
    private ExceptionUtils(){}


    public static void isTrue(boolean b,String message){
        if (!b){
            throw new IllegalArgumentException(500,message);
        }
    }



}
