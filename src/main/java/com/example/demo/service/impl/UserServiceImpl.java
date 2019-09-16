package com.example.demo.service.impl;

import com.example.demo.bean.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

//    登录
    @Override
    public User logIn(String account, String password) {

        return userMapper.logIn(account,password);
    }

    @Override
    public List<User> ztreeAll(long id) {
        return userMapper.ztreeShowAll(id);
    }

//    add user
    @Override
    public Boolean insertUser(User user) {
        return userMapper.insertUser(user);
    }
}
