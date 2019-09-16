package com.example.demo.controller;

import com.example.demo.bean.TbCityData;
import com.example.demo.service.TbCityDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/TbCityData")
@RestController
public class TbCityDataController {

    @Autowired
    private TbCityDataService tbCityDataService;

//    查询
    @RequestMapping("/cityDataList")
    public List<TbCityData> cityDataList(String startTime, String endTime){

        List<TbCityData> tbCityData = tbCityDataService.cityDataList(startTime,endTime);

        return tbCityData;
    }

}
