package com.hr.service.impl;

import com.hr.dao.UserDao;
import com.hr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public void save() {
        userDao.save();
    }
}
