package com.hr.service.impl;

import com.hr.domain.Account;
import com.hr.mapper.AccountMapper;
import com.hr.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {



    @Override
    public void save(Account account) {
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession session = sqlSessionFactory.openSession(true);
            AccountMapper accountMapper = session.getMapper(AccountMapper.class);
            accountMapper.save(account);
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Account> findAll() {
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession session = sqlSessionFactory.openSession(true);
            AccountMapper accountMapper = session.getMapper(AccountMapper.class);
            List<Account> accountList = accountMapper.findAll();
            session.close();
            return accountList;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
