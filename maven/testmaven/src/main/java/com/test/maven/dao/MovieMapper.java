package com.test.maven.dao;

import com.test.maven.model.Movie;

public interface MovieMapper {
    int deleteByPrimaryKey(String id);

    int insert(Movie record);

    int insertSelective(Movie record);

    Movie selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Movie record);

    int updateByPrimaryKey(Movie record);
}