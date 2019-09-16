package com.example.demo.mapper;

import com.example.demo.bean.Area;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaMapper {

    List<Area> areaList();

    Boolean insertArea(Area area);

    Boolean deleteArea(Integer id);

    Boolean updateArea(Area area);

}
