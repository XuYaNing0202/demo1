package com.example.demo.mapper;

import com.example.demo.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

//    登录
    User logIn(@Param("account") String account, @Param("password") String password);

    //节点查询
    List<User> ztreeShowAll(long id);

    //用户添加
    Boolean insertUser(User user);

}
