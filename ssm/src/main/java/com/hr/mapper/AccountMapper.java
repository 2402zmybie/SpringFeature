package com.hr.mapper;

import com.hr.domain.Account;

import java.util.List;

public interface AccountMapper {

    void save(Account account);

    List<Account> findAll();
}
