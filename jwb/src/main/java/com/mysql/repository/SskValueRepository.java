package com.mysql.repository;

import com.mysql.entity.SskValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * Created by Administrator on 2017/3/1.
 */
@Repository
public interface SskValueRepository extends JpaRepository<SskValue, Long> {

    @Query(value = "select s.* from ssk_value s where s.id=?1",nativeQuery = true)
    List<SskValue> findById(String id);
}
