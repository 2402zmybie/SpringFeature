package com.hr.dao;

import com.hr.domain.Order;

import java.util.List;

public interface OrderMapper {

    List<Order> findAll();
}
