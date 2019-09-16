package com.example.demo.service.impl;

import com.example.demo.bean.TbDataManagement;
import com.example.demo.mapper.TbDataManagementMapper;
import com.example.demo.service.TbDataManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbDataManagementSeviceImpl implements TbDataManagementService {

    @Autowired
    private TbDataManagementMapper tbDataManagementMapper;

    @Override
    public Boolean forecastData(TbDataManagement tbDataManagement) {
        tbDataManagement.setWhetherReport(0);
        return tbDataManagementMapper.forecastData(tbDataManagement);
    }

    @Override
    public List<TbDataManagement> listDataManagement() {
        return tbDataManagementMapper.listDataManagement();
    }

    @Override
    public void report(Integer id) {
        tbDataManagementMapper.report(id);
    }
}
