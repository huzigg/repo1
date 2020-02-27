package cn.cduestc.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration   //加上该注解，将该类标记为配置类，可以在该类中配置springboot的相关配置
public class ConfigBean {

    @Bean    //将该方法返回的bean注册到容器中
    @LoadBalanced   //因为做远程调用的是RestTemplate，所以负载均衡也应该在RestTemplate上面做，所以在注册Bean时添加@LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
