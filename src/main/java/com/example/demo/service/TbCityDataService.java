package com.example.demo.service;

import com.example.demo.bean.TbCityData;

import java.util.List;

public interface TbCityDataService {

    List<TbCityData> cityDataList(String startTime, String endTime);

    Boolean insertCityData(TbCityData tbCityData);

}
