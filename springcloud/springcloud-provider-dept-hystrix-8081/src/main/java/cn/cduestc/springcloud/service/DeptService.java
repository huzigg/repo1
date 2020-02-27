package cn.cduestc.springcloud.service;

import cn.cduestc.springcloud.pojo.Dept;

import java.util.List;

public interface DeptService {

    //添加
    boolean addDept(Dept dept);

    //查询单个
    Dept selectById(Long id);

    //查询所有
    List<Dept> selectAll();

}
