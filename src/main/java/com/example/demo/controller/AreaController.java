package com.example.demo.controller;

import com.example.demo.bean.Area;
import com.example.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/area")
@RestController
public class AreaController {

    @Autowired
    private AreaService areaService;

    @RequestMapping("/areaList")
    public List<Area> areaList(){

        List<Area> areas = areaService.areaList();
        for (Area a:areas
             ) {
            if (a.getId()<=2){
                a.setOpen(true);
            }
        }
        return areas;
    }

    @RequestMapping("/insertArea")
    public Boolean insertArea(Area area){

        Boolean aBoolean = areaService.insertArea(area);

        return aBoolean;
    }

    @RequestMapping("/deleteArea")
    public Boolean deleteArea(String id){

        Boolean aBoolean = areaService.deleteArea(Integer.parseInt(id));

        return aBoolean;
    }

    @RequestMapping("/updateArea")
    public Boolean updateArea(Area area){

        Boolean aBoolean = areaService.updateArea(area);

        return aBoolean;

    }

}
