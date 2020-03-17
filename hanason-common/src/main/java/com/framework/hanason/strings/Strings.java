package com.framework.hanason.strings;

/**
 * @author sorata 2020-03-16 14:55
 */
public final class Strings {

    public Strings(){
        throw new AssertionError("工具类不能使用构造函数，请使用静态方法");
    }


    public static boolean isBlack(String str){
        return str == null || str.isEmpty();
    }




}
