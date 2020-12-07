package com.hr.test;


import com.hr.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    //查询一个数据
    @Test
    public void test5() throws IOException {
        //加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session会话对象
        SqlSession session = sqlSessionFactory.openSession();
        //执行操作 namespace+id
        User user = session.selectOne("userMapper.findById", 1);
        System.out.println(user);
        //释放资源
        session.close();
    }


    @Test
    public void test4() throws IOException {
        //加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session会话对象
        SqlSession session = sqlSessionFactory.openSession();
        //执行操作 namespace+id
        session.delete("userMapper.delete",3);
        //提交事务
        session.commit();
        //释放资源
        session.close();
    }

    @Test
    public void test3() throws IOException {
        //加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session会话对象
        SqlSession session = sqlSessionFactory.openSession();
        User user = new User();
        user.setId(3);
        user.setUsername("xiaoli");
        user.setPassword("xxxxx");
        //执行操作 namespace+id
        session.update("userMapper.update",user);
        //提交事务
        session.commit();
        //释放资源
        session.close();
    }



    @Test
    public void test2() throws IOException {
        //加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session会话对象
        SqlSession session = sqlSessionFactory.openSession();
        User user = new User();
        user.setUsername("小李");
        user.setPassword("123456");
        //执行操作 namespace+id
        session.insert("userMapper.save",user);
        //提交事务
        session.commit();
        //释放资源
        session.close();
    }

    @Test
    public void test1() throws IOException {
        //加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session会话对象
        SqlSession session = sqlSessionFactory.openSession();
        //执行操作 namespace+id
        List<Object> list = session.selectList("userMapper.findAll");
        System.out.println(list);
        //释放资源
        session.close();
    }
}
