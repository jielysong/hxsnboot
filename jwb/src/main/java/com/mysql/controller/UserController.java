package com.mysql.controller;

import com.mysql.entity.Department;
import com.mysql.entity.Role;
import com.mysql.entity.User;
import com.mysql.repository.DepartmentRepository;
import com.mysql.repository.RoleRepository;
import com.mysql.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by Administrator on 2017/3/1.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private RoleRepository roleRepository;

    @RequestMapping("/save")
    public String save(){
        User user = new User();
        Department department = new Department();
        department.setName("研发部1");
        departmentRepository.save(department);
        Role role = new Role();
        role.setName("android");
        user.setName("jiely1");
        user.setDepartment(department);
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        roleRepository.save(role);
        user.setRoles(roles);
        userRepository.save(user);
        Assert.notNull(user.getId());
        return userRepository.findByNameLike("jiely").getName();
    }

    @RequestMapping("/saveCount")
    public List<User> saveCount(int count){

        Department department = new Department();
        department.setName("研发部1");
        departmentRepository.save(department);
        Role role = new Role();
        role.setName("android");

        List<Role> roles = new ArrayList<>();
        roles.add(role);
        roleRepository.save(role);
        for(int i=0; i<count; i++){
            User user = new User();
            user.setRoles(roles);
            user.setName("jiely"+i);
            user.setDepartment(department);
            userRepository.save(user);
            Assert.notNull(user.getId());
        }
        return userRepository.findAll();
        //return userRepository.findByNameLike("jiely").getName();
    }

    @RequestMapping("/findPage")
    public List<User> findPage(int pageStart,int size){
        Pageable pageable = new PageRequest(pageStart, size, new Sort(Sort.Direction.ASC, "id"));
        Page<User> page = userRepository.findAll(pageable);
        Assert.notNull(page);
        for(User user : page.getContent()) {
            logger.info("====user==== user name:{}, department name:{}, role name:{}",
                    user.getName(), user.getDepartment().getName(), user.getRoles().get(0).getName());
        }
        List<User> users = page.getContent();
        return users;
    }

}
