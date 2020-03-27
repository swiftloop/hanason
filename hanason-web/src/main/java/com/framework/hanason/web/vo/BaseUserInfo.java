package com.framework.hanason.web.vo;

import lombok.Data;

/**
 * @author sorata 2020-03-27 18:42
 */
@Data
public class BaseUserInfo implements UserDto {

    private static final long serialVersionUID = 5506545109877777894L;

    private String userId;

    private String platform;

    private String tag;

    private String version;

    private int type;
}
