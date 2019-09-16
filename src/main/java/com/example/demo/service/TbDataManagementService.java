package com.example.demo.service;

import com.example.demo.bean.TbDataManagement;

import java.util.List;

public interface TbDataManagementService {

    Boolean forecastData(TbDataManagement tbDataManagement);

    List<TbDataManagement> listDataManagement();

    void report(Integer id);
}
