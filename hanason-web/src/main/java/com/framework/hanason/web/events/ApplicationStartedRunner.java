package com.framework.hanason.web.events;

import com.framework.hanason.config.SysContants;
import com.framework.hanason.config.properties.SystemProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author sorata 2020-03-27 17:37
 */
@Configuration
@Slf4j
public class ApplicationStartedRunner implements CommandLineRunner {


    private final SystemProperties systemProperties;
    private final ServerProperties serverProperties;
    public ApplicationStartedRunner(SystemProperties systemProperties, ServerProperties serverProperties) {
        this.systemProperties = systemProperties;
        this.serverProperties = serverProperties;
    }

    @Override
    public void run(String... args) throws Exception {
        SysContants.setDEBUG(systemProperties.isDebug());
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        log.info("程序启动                                        完成");
        log.info("程序监听在                                      {}",serverProperties.getPort());
        log.info("程序启动环境                                     {}", SysContants.isDEBUG()? "开发" : "生产");
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }
}
