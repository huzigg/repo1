package cn.cduestc.springcloud.controller;

import cn.cduestc.springcloud.pojo.Dept;
import cn.cduestc.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    //获取单个数据
    @GetMapping("/dept/select/{id}")
    @HystrixCommand(fallbackMethod = "hystrixSelectOne")  //添加该注解后，表示对该服务添加了hystrix熔断机制，在该服务挂掉时，会调用备用服务
    public Dept selectOne(@PathVariable("id") Long id){
        Dept dept = deptService.selectById(id);
        //判断如果输入错误id，没有查询到数据，那么抛出一个运行时异常
        if (dept == null){
            throw new RuntimeException("您输入的id没有对应的值哦！！！");
        }
        return dept;
    }


    //该方法是在服务挂掉后，启用hystrix熔断机制调用的备用方法
    public Dept hystrixSelectOne(@PathVariable("id") Long id){
        return new Dept()
                .setId(id)
                .setName("对不起，"+id+"没有对应的数据")
                .setDb_source("没有对应的信息，当然没有数据库哦");
    }

}
