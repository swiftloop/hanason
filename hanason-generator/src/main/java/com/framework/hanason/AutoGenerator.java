package com.framework.hanason;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.FileType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.HashMap;

/**
 * @author sorata 2020-03-16 16:01
 */
public class AutoGenerator {


    public static void main(String[] args) {
        generator();
    }


    private static void generator(){
        com.baomidou.mybatisplus.generator.AutoGenerator generator = new com.baomidou.mybatisplus.generator.AutoGenerator();
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(System.getProperty("user.dir")+"/hanason-app/src/main/java");
        globalConfig.setAuthor("auto generator");
        globalConfig.setOpen(true);
        globalConfig.setEntityName("%sPo");
        globalConfig.setMapperName("%sDao");
        globalConfig.setDateType(DateType.ONLY_DATE);
        globalConfig.setBaseResultMap(true);
        //直接会覆盖更改的代码
        globalConfig.setFileOverride(false);
        globalConfig.setIdType(IdType.AUTO);
        globalConfig.setSwagger2(true);


        generator.setGlobalConfig(globalConfig);


        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUrl("jdbc:mysql://192.168.1.202:6535/monitor_simple?useUnicode=true&useSSL=false&characterEncoding=utf8");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("12345678");
        dataSourceConfig.setDbType(DbType.MYSQL);

        generator.setDataSource(dataSourceConfig);

        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.framework.hanason");
        packageConfig.setMapper("dao");
        HashMap<String, String> map = new HashMap<>(4);
        map.put(ConstVal.SERVICE_PATH,globalConfig.getOutputDir()+"/"+packageConfig.getParent().replace(".","/")+"/service");
        map.put(ConstVal.SERVICE_IMPL_PATH,globalConfig.getOutputDir()+"/"+packageConfig.getParent().replace(".","/")+"/service/impl");
        map.put(ConstVal.MAPPER_PATH,globalConfig.getOutputDir()+"/"+packageConfig.getParent().replace(".","/")+"/dao");
        map.put(ConstVal.ENTITY_PATH,globalConfig.getOutputDir()+"/"+packageConfig.getParent().replace(".","/")+"/entity");
        map.put(ConstVal.CONTROLLER_PATH,globalConfig.getOutputDir()+"/"+packageConfig.getParent().replace(".","/")+"/controller");
        map.put(ConstVal.XML_PATH,System.getProperty("user.dir")+"/hanason-app/src/main/resources/mapper");
        packageConfig.setPathInfo(map);

        generator.setPackageInfo(packageConfig);

        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setEntityBuilderModel(true);

        generator.setStrategy(strategyConfig);


        InjectionConfig injectionConfig = new InjectionConfig(){
            /**
             * 注入自定义 Map 对象，针对所有表的全局参数
             */
            @Override
            public void initMap() {

            }
        };
        injectionConfig.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                return !fileType.equals(FileType.CONTROLLER);
            }
        });

        generator.setCfg(injectionConfig);


        generator.execute();


    }




}
