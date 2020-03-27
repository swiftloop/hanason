package com.framework.hanason.web.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author sorata 2020-03-27 11:48
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class UserLogin extends BaseSignRequestBody {
    private String name;

    private Long sid;

    private String phone;

    private String platform;


    public static void main(String[] args) {
        BaseSignRequestBody body = new UserLogin().setName("name").setPhone("18279407507").setPlatform("baidu").setSid(22L)
                .setSign("dd").setEtx("ec").setTx(System.currentTimeMillis());
        System.out.println(body.getSingChar());

    }
}
