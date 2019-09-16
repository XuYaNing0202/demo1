package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

//    Log In
    @RequestMapping("/userLogIn")
    public @ResponseBody
    Boolean logIn(String account, String password, HttpSession session){

        User user = userService.logIn(account, password);

        if (user==null){
            return false;
        }else{
            session.setAttribute("userLogIn",user);
            return true;
        }
    }

//    权限
    @RequestMapping("/permission")
    public @ResponseBody
    Long permission(HttpSession session){

        User userLogIn = (User) session.getAttribute("userLogIn");

        return userLogIn.getPermission();

    }

    @RequestMapping("/ztreeAll")
    public @ResponseBody
    List<User> ztreeAll(String id){
        List<User> users = userService.ztreeAll(Long.parseLong(id));
        return users;
    }

//    add user
    @RequestMapping("/insertUser")
    public @ResponseBody
    Boolean insertUser(User user){
        return userService.insertUser(user);
    }
}
