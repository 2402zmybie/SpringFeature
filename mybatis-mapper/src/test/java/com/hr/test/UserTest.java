package com.hr.test;

import com.hr.dao.UserMapper;
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

public class UserTest {

    @Test
    public void test1() throws IOException {
        InputStream stream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession session = sqlSessionFactory.openSession();
        //mybatis帮我们进行动态代理实现
        UserMapper mapper = session.getMapper(UserMapper.class);
        // null
//        User user = new User();
//        user.setId(2);
//        user.setUsername("hr");
//        user.setPassword("123456");

        User user = new User();
        user.setUsername("hr");
        user.setPassword("123456");
        User userResult = mapper.findByCondition(user);
        System.out.println(userResult);
    }


    @Test
    public void test2() throws IOException {
        InputStream stream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);

        List<User> userList = mapper.findByIds(ids);
        System.out.println(userList);
    }
}
