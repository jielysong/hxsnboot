package com.mysql.controller;

import com.mysql.entity.SskValue;
import com.mysql.repository.SskValueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

/**
 *
 * Created by Administrator on 2017/3/1.
 */
@RestController
@RequestMapping("/ssk")
public class SskalueController {

    private static Logger logger = LoggerFactory.getLogger(SskalueController.class);

    @Autowired
    private SskValueRepository sskValueRepository;


    @RequestMapping("/save")
    public List<SskValue> saveCount(String id){


        /*byte[] bytes = {id};
        String ids = MD5Encoder.encode(bytes);
        System.out.println("ids="+ids);*/
        for(int i=0; i<24; i++){
            SskValue sskValue = new SskValue();
            Random random = new Random();
            int integer = Math.abs(random.nextInt()%40);
            sskValue.setId(id);
            sskValue.setTemperature(integer);
            sskValue.setCreateTime(String.valueOf(i));
            sskValue.setName("随时看1");

            sskValueRepository.save(sskValue);

        }
        return sskValueRepository.findAll();
        //return userRepository.findByNameLike("jiely").getName();
    }

    @RequestMapping("/findById")
    public List<SskValue> findPage(String id){
        return sskValueRepository.findById(id);

    }



}
