package com.example.demo.service.impl;

import com.example.demo.bean.TbCityData;
import com.example.demo.mapper.TbCityDataMapper;
import com.example.demo.service.TbCityDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbCityDataServiceImpl implements TbCityDataService {

    @Autowired
    private TbCityDataMapper tbCityDataMapper;

//    查询
    @Override
    public List<TbCityData> cityDataList(String startTime, String endTime){
        return tbCityDataMapper.cityDataList(startTime,endTime);
    }

    @Override
    public Boolean insertCityData(TbCityData tbCityData) {
        return tbCityDataMapper.insertCityData(tbCityData);
    }
}
