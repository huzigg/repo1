package cn.cduestc.springcloud.mapper;

import cn.cduestc.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptMapper {

    //添加
    boolean addDept(Dept dept);

    //查询单个
    Dept selectById(Long id);

    //查询所有
    List<Dept> selectAll();

}
