package com.framework.hanason.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sorata 2020-03-17 17:11
 */
@Configuration
@ConditionalOnClass(PaginationInterceptor.class)
public class MybatisPlusConfig {

    @Bean
    public PaginationInterceptor interceptor(){
        PaginationInterceptor interceptor = new PaginationInterceptor();
        //设置最大的请求条数
        interceptor.setLimit(200);
        //对left join进行优化
        interceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
        return interceptor;
    }

}
