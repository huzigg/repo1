package cn.cduestc.springcloud.controller;

import cn.cduestc.springcloud.pojo.Dept;
import cn.cduestc.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    //该接口用于发现服务，其实现类中存储了服务的一些信息
    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/select/{id}")
    public Dept selectOne(@PathVariable("id") Long id){
        return deptService.selectById(id);
    }


    @GetMapping("/dept/selectAll")
    public List<Dept> selectAll(){
        return deptService.selectAll();
    }


    //输出eureka的服务发现信息（用来获取注册进来的服务的一些信息）
    @GetMapping("/dept/discovery")
    public Object discovery(){
        //获取哪些服务已经注册
        List<String> services = discoveryClient.getServices();
        System.out.println("discovery===>service===>"+services);
        //根据某个服务名获取该服务的实例
        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost()+"\t"+
                    instance.getPort()+"\t"+
                    instance.getUri()+"\t"+
                    instance.getServiceId()+"\t"
            );
        }
        return this.discoveryClient;
    }


}

