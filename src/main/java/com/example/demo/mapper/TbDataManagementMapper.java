package com.example.demo.mapper;

import com.example.demo.bean.TbDataManagement;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbDataManagementMapper {

    Boolean forecastData(TbDataManagement tbDataManagement);

    List<TbDataManagement> listDataManagement();

    void report(Integer id);

}
