package cn.cduestc.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)  //开启该类的链式写法
public class Dept implements Serializable{   //实体类必须实现Serializable接口，保证在微服务架构项目模块之间进行通信时可以序列化

    private Long id;
    private String name;
    //微服务架构一个服务对应一个数据库，不同信息可能存在不同数据库，该字段表示存在哪个数据库
    private String db_source;

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", db_source='" + db_source + '\'' +
                '}';
    }
}
