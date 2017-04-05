package com.hxsn.lfqx.controller;

import com.hxsn.lfqx.entity.Crop;
import com.hxsn.lfqx.service.CropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * Created by Administrator on 2017/3/4.
 */
@RequestMapping("/crop")
@RestController
public class CropController {

    @Autowired
    private CropService cropService;


    @RequestMapping("/findAll")
    public List<Crop> findOne(){
        return cropService.findAll();
    }
}
