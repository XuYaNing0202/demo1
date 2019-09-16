package com.example.demo.service.impl;

import com.example.demo.bean.Area;
import com.example.demo.mapper.AreaMapper;
import com.example.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaMapper areaMapper;


    @Override
    public List<Area> areaList() {
        return areaMapper.areaList();
    }

    @Override
    public Boolean insertArea(Area area) {

        return areaMapper.insertArea(area);
    }

    @Override
    public Boolean deleteArea(Integer id) {
        return areaMapper.deleteArea(id);
    }

    @Override
    public Boolean updateArea(Area area) {
        return areaMapper.updateArea(area);
    }
}
