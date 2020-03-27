package com.framework.hanason.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.context.request.async.TimeoutCallableProcessingInterceptor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author sorata 2020-03-19 16:28
 */
@Configuration
public class AsyncConfig implements WebMvcConfigurer {

    @Autowired private ThreadPoolTaskExecutor executor;

    /**
     * Configure asynchronous request handling options.
     *
     * @param configurer
     */
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        configurer.setDefaultTimeout(1000);
        configurer.setTaskExecutor(executor);
        configurer.registerCallableInterceptors(callableProcessingInterceptor());
    }


    @Bean
    public TimeoutCallableProcessingInterceptor callableProcessingInterceptor(){
        return new TimeoutCallableProcessingInterceptor();
    }
}
