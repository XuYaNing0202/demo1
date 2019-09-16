package com.example.demo.service.impl;

import com.example.demo.bean.TbImage;
import com.example.demo.mapper.TbImageMapper;
import com.example.demo.service.TbImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbImageServiceImpl implements TbImageService {

    @Autowired
    private TbImageMapper tbImageMapper;

    @Override
    public Boolean insertImg(List<TbImage> list) {
        return tbImageMapper.insertImg(list);
    }
}
