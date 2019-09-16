package com.example.demo.service;

import com.example.demo.bean.Area;

import java.util.List;

public interface AreaService {

    List<Area> areaList();

    Boolean insertArea(Area area);

    Boolean deleteArea(Integer id);

    Boolean updateArea(Area area);

}
