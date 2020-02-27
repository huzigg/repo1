package cn.cduestc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard    //开启Hystrix的Dashboard监控
public class DashboardDeptConsumer_9001 {
    public static void main(String[] args) {
        SpringApplication.run(DashboardDeptConsumer_9001.class,args);
    }
}
