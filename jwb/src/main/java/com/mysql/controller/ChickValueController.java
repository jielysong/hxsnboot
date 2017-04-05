package com.mysql.controller;

import com.mysql.entity.ChickValue;
import com.mysql.repository.ChickValueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 *
 * Created by Administrator on 2017/3/1.
 */
@RestController
@RequestMapping("/chick")
public class ChickValueController {

    private static Logger logger = LoggerFactory.getLogger(ChickValueController.class);

    @Autowired
    private ChickValueRepository chickValueRepository;


    @RequestMapping("/saveCount")
    public List<ChickValue> saveCount(int count){


        for(int i=0; i<count; i++){
            ChickValue chickValue = new ChickValue();
            chickValue.setCreateTime(new Date());
            chickValue.setDayAge(String.valueOf(i%45));
            Random random = new Random();
            int integer = Math.abs(random.nextInt()%40);

            chickValue.setTemperature(integer);
            chickValue.setName("鸡舍"+i);
            chickValue.setIsWarning(i%2==0 ? "0":"1");

            chickValueRepository.save(chickValue);

        }
        return chickValueRepository.findAll();
        //return userRepository.findByNameLike("jiely").getName();
    }

    @RequestMapping("/findPage")
    public List<ChickValue> findPage(int pageStart,int size){
        Pageable pageable = new PageRequest(pageStart, size, new Sort(Sort.Direction.ASC, "id"));
        Page<ChickValue> page = chickValueRepository.findAll(pageable);
        Assert.notNull(page);

        List<ChickValue> users = page.getContent();
        return users;
    }

    @RequestMapping(value = "findPageRequest",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    public List<ChickValue> findPageRequest(HttpServletRequest request){
        String start = request.getParameter("pageStart");
        String strSize = request.getParameter("size");
        Pageable pageable = new PageRequest(Integer.parseInt(start), Integer.parseInt(strSize), new Sort(Sort.Direction.ASC, "id"));
        Page<ChickValue> page = chickValueRepository.findAll(pageable);
        Assert.notNull(page);

        List<ChickValue> users = page.getContent();

        return users;
    }

}
