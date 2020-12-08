package com.hr.test;


import com.hr.dao.OrderMapper;
import com.hr.dao.UserMapper;
import com.hr.domain.Order;
import com.hr.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MyBatisTest {

    private SqlSession session;

    @Before
    public void before() throws IOException {
        InputStream stream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        session = sqlSessionFactory.openSession(true);
    }

//    多对多
    @Test
    public void testUserFindUserAndRole() {
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<User> userList = userMapper.findUserAndRole();
        for (User user : userList) {
            System.out.println(user);
        }
    }


    @Test
    public void testUserFindUserAndOrderAll() {
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<User> userList = userMapper.findUserAndOrderAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }


    @Test
    public void testOrderFindAll() {
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);
        List<Order> orderList = orderMapper.findAll();
        for (Order order : orderList) {
            System.out.println(order);
        }

    }


    @Test
    public void testFindAll() {
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<User> userList = userMapper.findAll();
        System.out.println(userList);
    }

    @Test
    public void testFindById() {
        UserMapper userMapper = session.getMapper(UserMapper.class);
        userMapper.findById(3);
    }



    @Test
    public void testDelete() {
        UserMapper userMapper = session.getMapper(UserMapper.class);
        userMapper.delete(4);
    }

    @Test
    public void testUpdate() {
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setPassword("111");
        user.setId(2);
        user.setBirthday(new Date());
        userMapper.update(user);

    }

    @Test
    public void testSave() throws IOException {
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("小莉");
        user.setPassword("4");
        user.setBirthday(new Date());
        userMapper.save(user);
    }


}
