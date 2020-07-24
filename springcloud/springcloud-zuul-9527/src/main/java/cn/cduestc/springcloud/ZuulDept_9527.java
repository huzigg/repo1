package cn.cduestc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy   //开启路由代理
public class ZuulDept_9527 {
    public static void main(String[] args) {
        SpringApplication.run(ZuulDept_9527.class,args);
    }

}
