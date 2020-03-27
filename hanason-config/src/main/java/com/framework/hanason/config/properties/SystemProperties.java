package com.framework.hanason.config.properties;

import com.framework.hanason.common.strings.Strings;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author sorata 2020-03-27 10:27
 */
@Configuration
@ConfigurationProperties(prefix = "hanason")
@Slf4j
public class SystemProperties implements InitializingBean {

    private boolean debug = true;

    private System system = new System();

    @Data
    public static class System {
        private String apiSignKey;

    }


    @Override
    public void afterPropertiesSet() throws Exception {
        if (Strings.isNullOrEmpty(system.getApiSignKey())) {
            String md5Hex = DigestUtils.md5Hex("hanason" + DigestUtils.md5Hex("2020-03-27 10:27") + "v1");
            system.setApiSignKey(md5Hex);
            if (debug) {
                log.warn("当前应用未配置参数签名密钥,将使用默认密钥:{}", system.getApiSignKey());
            }
        }
    }


    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }


    public System getSystem() {
        return system;
    }
}
