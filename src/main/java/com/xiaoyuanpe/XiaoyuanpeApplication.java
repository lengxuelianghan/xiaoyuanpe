package com.xiaoyuanpe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xiaoyuanpe.mapper")//指定扫描接口与配置文件的包名
public class XiaoyuanpeApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiaoyuanpeApplication.class, args);
    }

}