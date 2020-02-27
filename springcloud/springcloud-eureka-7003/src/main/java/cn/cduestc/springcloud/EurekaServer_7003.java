package cn.cduestc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer     //配置该注解，表示该启动类是eureka的服务端启动类，可以接收其他服务注册进来
public class EurekaServer_7003 {

    public static void main(String[] args) {

        SpringApplication.run(EurekaServer_7003.class,args);

    }

}
