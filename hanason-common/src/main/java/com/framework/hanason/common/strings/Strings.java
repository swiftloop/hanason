package com.framework.hanason.common.strings;

/**
 * @author sorata 2020-03-16 14:55
 */
public final class Strings {

    public Strings(){
        throw new AssertionError("工具类不能使用构造函数，请使用静态方法");
    }


    public static boolean isNullOrEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isNotBlack(String str){
        return !isNullOrEmpty(str);
    }

}
