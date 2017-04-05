package com.mysql.repository;

import com.mysql.entity.ChickValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * Created by Administrator on 2017/3/1.
 */
@Repository
public interface ChickValueRepository extends JpaRepository<ChickValue, Long> {

}
