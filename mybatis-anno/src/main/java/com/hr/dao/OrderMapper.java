package com.hr.dao;

import com.hr.domain.Order;
import com.hr.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {

//    联表查
   /* @Select("SELECT *,o.id oid FROM orders o,USER u WHERE o.uid = u.id")
    @Results({
            @Result(column = "oid", property = "id"),
            @Result(column = "ordertime", property = "ordertime"),
            @Result(column = "total", property = "total"),
            @Result(column = "uid", property = "user.id"),
            @Result(column = "username", property = "user.username"),
            @Result(column = "password", property = "user.password"),
            @Result(column = "birthday", property = "user.birthday")
    })
    List<Order> findAll();*/



    @Select("select * from orders")
    @Results({
            @Result(id = true,column = "id", property = "id"),
            @Result(column = "ordertime", property = "ordertime"),
            @Result(column = "total", property = "total"),
            @Result(
                    //要封装的属性名称
                    property = "user",
                    //根据哪个字段去查询user表的数据
                    column = "uid",
                    //要封装的实体类型
                    javaType = User.class,
                    //select属性, 代表查询那个接口的方法获得数据
                    one = @One(select = "com.hr.dao.UserMapper.findById")
            )
    })
    List<Order> findAll();


    @Select("select * from orders where uid = #{uid}")
    List<Order> findByUid(int uid);

}
