package com.framework.hanason.config;

/**
 * @author sorata 2020-03-27 17:20
 *
 * 系统常量
 *
 */
public final class SysContants {
    /**
     * 系统是否是在开发模式 控制一些需要打印调试的地方
     */
    private static boolean DEBUG = true;

    public static boolean isDEBUG() {
        return DEBUG;
    }

    public static void setDEBUG(boolean DEBUG) {
        SysContants.DEBUG = DEBUG;
    }
}
