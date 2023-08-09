package com.nadeit.mj;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@MapperScan({"com.nadeit.mj.mapper"})
public class MjAppCenterApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MjAppCenterApiApplication.class, args);
        log.info("宝贝的项目启动成功");
    }

}
