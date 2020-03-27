package com.framework.hanason.web.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author sorata 2020-03-27 14:14
 */
@Data
@Accessors(chain = true)
public class UserTokenVo implements UserDto {

    private String phone;

    private String platform;

    private String tag;

}
