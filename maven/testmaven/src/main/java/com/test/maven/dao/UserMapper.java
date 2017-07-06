package com.test.maven.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.test.maven.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(String id);
    
    /**
     * 插入用户
     * @param record
     * @return
     */
    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
   /**
    * 根据用户名、密码查询用户
    * @param name
    * @param password
    * @return
    */
    User findByNameAndPassword(@Param("name") String name, @Param("password") String password);
    
    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();
    
    
}