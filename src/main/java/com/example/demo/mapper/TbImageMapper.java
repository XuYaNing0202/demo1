package com.example.demo.mapper;

import com.example.demo.bean.TbImage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbImageMapper {

    Boolean insertImg(@Param("list") List<TbImage> list);

}
