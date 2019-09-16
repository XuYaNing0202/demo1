package com.example.demo.mapper;

import com.example.demo.bean.TbCityData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbCityDataMapper {

    List<TbCityData> cityDataList(@Param("startTime")String startTime, @Param("endTime")String endTime);

    Boolean insertCityData(TbCityData tbCityData);

}
