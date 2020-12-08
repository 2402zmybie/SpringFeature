package com.hr.test;

import com.hr.dao.OrderMapper;
import com.hr.dao.UserMapper;
import com.hr.domain.Order;
import com.hr.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MyBatisTest {

    //多对多(一对多)
    @Test
    public void test3() throws IOException {
        InputStream stream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession session = sqlSessionFactory.openSession();
        //mybatis帮我们进行动态代理实现
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> userList = mapper.findUserAndRoleAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    //一对多
    @Test
    public void test2() throws IOException {
        InputStream stream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession session = sqlSessionFactory.openSession();
        //mybatis帮我们进行动态代理实现
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> userList = mapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    //多对一 (一对一)
    @Test
    public void test1() throws IOException {
        InputStream stream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession session = sqlSessionFactory.openSession();
        //mybatis帮我们进行动态代理实现
        OrderMapper mapper = session.getMapper(OrderMapper.class);
        List<Order> orderList = mapper.findAll();
        for (Order order : orderList) {
            System.out.println(order);
        }
    }


}
