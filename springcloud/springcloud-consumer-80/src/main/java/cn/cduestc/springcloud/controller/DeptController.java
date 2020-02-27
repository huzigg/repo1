package cn.cduestc.springcloud.controller;

import cn.cduestc.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@RestController
public class DeptController {

    /**
     *  分析：消费者不能有service层，所以使用restTemplate进行远程调用，需要将restTemplate的bean注册到容器中
     */
    @Autowired
    private RestTemplate restTemplate;

    //当进行远程调用时，url的前缀是固定的，所有我们可以设置一个常量

    /**这里不应该使用"http://localhost:8081"，因为这里写死了，直接去访问8081端口下的服务，而我们使用
     * Eureka做了注册中心，且做了注册中心集群，使用了Ribbon做负载均衡，所以不应该将服务地址写死，这里的
     * 服务地址应该是一个变量
     */
    //private static final String REST_URL_PREFIX = "http://localhost:8081";
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";

    @RequestMapping("/consumer/dept/add")
    public boolean addDept(Dept dept){
        System.out.println(dept);
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,Boolean.class);
    }

    @RequestMapping("/consumer/dept/select/{id}")
    public Dept selectOne(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/select/"+id,Dept.class);
    }

    @RequestMapping("/consumer/dept/selectAll")
    public List<Dept> selectAll(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/selectAll",List.class);
    }

}
