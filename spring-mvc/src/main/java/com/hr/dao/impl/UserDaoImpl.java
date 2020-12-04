package com.hr.dao.impl;

import com.hr.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component("userDao")
public class UserDaoImpl implements UserDao {
    public void save() {
        System.out.println("userdao save.....");
    }
}
