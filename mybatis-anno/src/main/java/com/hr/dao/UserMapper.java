package com.hr.dao;

import com.hr.domain.Order;
import com.hr.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Insert("insert into user values(#{id},#{username}, #{password}, #{birthday})")
    void save(User user);

    @Update("update user set username=#{username}, password=#{password},birthday=#{birthday} where id=#{id}")
    void update(User user);

    @Delete("delete from user where id = #{id}")
    void delete(int id);

    @Select("select * from user where id = #{id}")
    void findById(int id);

    @Select("select * from user")
    List<User> findAll();


    @Select("select * from user")
    @Results({
            @Result(id = true, column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(column = "birthday",property = "birthday"),
            @Result(
                    property = "orderList",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "com.hr.dao.OrderMapper.findByUid")

            )
    })
    List<User> findUserAndOrderAll();


//    多对多
    @Select("select * from user")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(column = "birthday", property = "birthday"),
            @Result(
                    property = "roleList",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "com.hr.dao.RoleMapper.findByUid")
            )
    })
    List<User> findUserAndRole();
}
