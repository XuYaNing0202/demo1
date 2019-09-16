package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@RequestMapping("/PageJump")
@Controller
public class PageJump {

    @RequestMapping("/logIn")
    public String logIn(HttpSession session){
        if (session.getAttribute("userLogIn")!=null){
            session.removeAttribute("userLogIn");
        }
        return "LogIn";
    }

    @RequestMapping("/show")
    public String show(){

        return "show";
    }

}
