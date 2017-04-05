package com.hxsn.lfqx.controller;

import com.hxsn.lfqx.entity.City;
import com.hxsn.lfqx.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * Created by Administrator on 2017/3/4.
 */
@RequestMapping("/citycode")
@RestController
public class CityController {

    @Autowired
    private CityService cityService;


    @RequestMapping("/findAll")
    public List<City> findOne(){
        return cityService.findAll();
    }
}
