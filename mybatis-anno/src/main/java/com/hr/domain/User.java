package com.hr.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class User {

    private int id;
    private String username;
    private String password;
    private Date birthday;
//    //描述的是当前用户存在哪些订单   一对多
    private List<Order> orderList;
//    //描述当前用户具备哪些角色   多对多(实际上也是一对多)
    private List<Role> roleList;

}
