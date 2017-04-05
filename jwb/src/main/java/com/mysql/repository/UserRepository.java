package com.mysql.repository;

import com.mysql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * Created by Administrator on 2017/3/1.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByNameLike(String name);
    User readByName(String name);
   // List<User> getByCreatedateLessThan(Date createDate);
}
