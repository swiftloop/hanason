package com.framework.hanason.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sorata 2020-03-17 09:34
 */
public final class FastTool {

    public FastTool(){
        throw new AssertionError("工具类不能使用构造函数，请使用静态方法");
    }

    public static <K,V> Map<K,V> ofMap(){
        return new HashMap<K,V>(16);
    }

    public static <T> List<T> ofList(){
        return new ArrayList<T>(16);
    }




}
