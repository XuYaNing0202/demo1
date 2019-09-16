package com.example.demo.controller;

import com.example.demo.bean.TbDataManagement;
import com.example.demo.service.TbDataManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/TbDataManagement")
@RestController
public class ForecastController {

    @Autowired
    private TbDataManagementService tbDataManagementService;

    @RequestMapping("/forecastData")
    public Boolean forecastData(TbDataManagement tbDataManagement){
        return tbDataManagementService.forecastData(tbDataManagement);
    }

    @RequestMapping("/listDataManagement")
    public List<TbDataManagement> listDataManagement(){
        return tbDataManagementService.listDataManagement();
    }

}
