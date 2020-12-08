package com.hr.service;

import com.hr.domain.Account;

import java.util.List;

public interface AccountService {

    void save(Account account);

    List<Account> findAll();
}
