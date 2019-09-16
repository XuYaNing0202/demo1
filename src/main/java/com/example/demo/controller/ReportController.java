package com.example.demo.controller;

import com.example.demo.bean.TbCityData;
import com.example.demo.bean.TbImage;
import com.example.demo.service.TbCityDataService;
import com.example.demo.service.TbDataManagementService;
import com.example.demo.service.TbImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequestMapping("/report")
@RestController
public class ReportController {

    @Autowired
    private TbCityDataService tbCityDataService;
    @Autowired
    private TbDataManagementService tbDataManagementService;
    @Autowired
    private TbImageService tbImageService;

    @RequestMapping("/reporting")
    public Boolean reporting(TbCityData tbCityData, String tdmId) {

        try {
            tbCityDataService.insertCityData(tbCityData);
            tbDataManagementService.report(Integer.parseInt(tdmId));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping("/uploadImage")
    public Boolean uploadImage(@RequestParam("multipartFiles") MultipartFile[] multipartFiles) throws IOException {

        System.out.println(multipartFiles.length);
        List<TbImage> list = new ArrayList();

        for (int i = 0; i < multipartFiles.length; i++) {

            TbImage tbImage = new TbImage();
            UUID uuid = UUID.randomUUID();
            String path = "E:/image/PacificCocktailParty-project/images/" + uuid + ".jpg";

            File file = new File(path);

            if (!file.getParentFile().exists())
                file.getParentFile().mkdir();

            multipartFiles[i].transferTo(file);

            tbImage.setUrl(uuid.toString());
            list.add(tbImage);
        }

        Boolean aBoolean = tbImageService.insertImg(list);

        return aBoolean;

    }

}
