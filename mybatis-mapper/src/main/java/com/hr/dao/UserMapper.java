package com.hr.dao;

import com.hr.domain.User;

import java.io.IOException;
import java.util.List;

public interface UserMapper {

    User findByCondition(User user);

    List<User> findByIds(List<Integer> ids);
}
