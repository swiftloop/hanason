package com.framework.hanason.domain.users;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author sorata 2020-03-17 15:35
 *
 *  这个类是记录登录用户的信息
 */
@Data
@Accessors(chain = true)
public class UserTokenVo implements UserDto {

    /**
     * 用户的手机号
     */
    private String phone;

    /**
     * 用户所在的平台 baidu、tencent
     */
    private String platform;

    /**
     *  应用的标识 DS_IA DM_AA  所有应用在区分标识的使用 I代表苹果 A代表安卓 也即是所有的标识下划线后的第一个字符必须是I或者是A（在仅有android、ios的情况下）
     */
    private String tag;


    /**
     * 是否是安卓
     *
     * @return {@code true}表示是android的系统
     */
    private boolean isAndroid() {
        return tag != null && tag.charAt(tag.lastIndexOf("_") + 1) == 'A';
    }

    /**
     * 得到系统的字符串
     * @return android、ios
     */
    public String toSystem() {
        if (isAndroid()) {
            return "android";
        } else {
            return "ios";
        }
    }
}
