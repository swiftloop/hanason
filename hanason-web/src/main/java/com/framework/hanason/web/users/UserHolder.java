package com.framework.hanason.web.users;

/**
 * @author sorata 2020-03-26 19:09
 * <p>
 * 基于线程的独立存储，因而存储的值应当尽量小，从而减少线程内存的占用
 */
public class UserHolder {

    private static final ThreadLocal<String> USERS = new ThreadLocal<>();

    /**
     * 这里只存储当前用户的userId 拿到userId也就能确定是哪个用户
     *
     * @param userId 用户的id 可以是手机号、随机的uuid
     */
    public static void setUser(String userId) {
        USERS.set(userId);
    }

    /**
     * 将信息从当前线程中移除
     */
    public static void remove() {
        USERS.remove();
    }

    /**
     * 得到用户的id
     *
     * @return userId
     */
    public static String getUserId() {
        return USERS.get();
    }


}
