package com.hr.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    private int id;
    private Date ordertime;
    private Double total;
    //订单属于哪一个用户
    private User user;

}
