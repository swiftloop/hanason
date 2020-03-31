package com.framework.hanason.web.vo;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;

/**
 * @author sorata 2020-03-19 14:37
 */

@Data
@Accessors(chain = true)
@ApiModel(value = "签名父类")
@Slf4j
public abstract class BaseSignRequestBody {

    @ApiModelProperty(value = "额外的随机字符串长度在4-10位")
    private String etx;

    @ApiModelProperty(value = "签名,签名方式采用hmac256")
    public String sign;
    /**
     * 签名的时间，该时间不能小于当前时间的前5分钟，也不能大于当前时间的后五分钟
     */
    @ApiModelProperty(value = "时间戳")
    public Long tx;


    public String getSingChar(){
        Field[] fields = FieldUtils.getAllFields(this.getClass());
        HashMap<String, Object> map = new LinkedHashMap<>(16);
        boolean hasException = false;
        Exception ex = null;
        for (Field field : fields) {
            if (Objects.equals("sign",field.getName()) || Objects.equals("log",field.getName()) ){
                continue;
            }
            try {
                map.put(field.getName(), FieldUtils.readField(this,field.getName(),true));
            } catch (IllegalAccessException e) {
                ex = e;
                hasException = true;
                break;
            }
        }
        if (hasException){
            log.error("获取签名参数失败",ex);
            return "-1$" + ex.getMessage();
        }
        StringBuilder builder = new StringBuilder();
        map.forEach((k,v)-> builder.append(k).append(v));
        return JSON.toJSONString(builder.toString());
    }

}
