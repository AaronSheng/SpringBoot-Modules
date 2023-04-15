package com.aaron.dao;

import com.aaron.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by com.aaron on 7/11/17.
 */
@Mapper
public interface UserMapper {
    User get(@Param("id") Long id);

    void update(@Param("user") User user);
}
