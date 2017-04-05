package com.hxsn.lfqx.service;

import com.hxsn.lfqx.entity.Crop;
import com.hxsn.lfqx.repository.CropRepository;
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
public class CropService {

    @Resource
    private CropRepository cropRepository;

    @Resource
    private JdbcTemplate jdbcTemplate;


    public Crop findOne(String id){
        RowMapper<Crop> rowMapper = new BeanPropertyRowMapper<>(Crop.class);
        return jdbcTemplate.queryForObject("select * from user where cropid = ?", rowMapper,id);
    }

    public List<Crop> findAll(){
        List<Crop> list = (List<Crop>) cropRepository.findAll();
        return list;
    }
}
