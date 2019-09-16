package com.example.demo.service;

import com.example.demo.bean.User;

import java.util.List;

public interface UserService {

//    登录
    User logIn(String account, String password);

//    子节点查询
    List<User> ztreeAll(long id);

    Boolean insertUser(User user);

}
