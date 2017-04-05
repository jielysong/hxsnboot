package com.hxsn.lfqx.service;

import com.hxsn.lfqx.entity.City;
import com.hxsn.lfqx.repository.CityRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * Created by Administrator on 2017/3/4.
 */
@Service
public class CityService {

    @Resource
    private CityRepository cityRepository;

    @Resource
    private JdbcTemplate jdbcTemplate;


    public City findOne(String id){
        RowMapper<City> rowMapper = new BeanPropertyRowMapper<>(City.class);
        return jdbcTemplate.queryForObject("select * from user where citycode = ?", rowMapper,id);
    }

    public List<City> findAll(){
        List<City> list = (List<City>) cityRepository.findAll();
        return list;
    }
}
