package com.hr.dao;

import com.hr.domain.User;

import java.util.List;

public interface UserMapper {

    List<User> findAll();

    List<User> findUserAndRoleAll();
}