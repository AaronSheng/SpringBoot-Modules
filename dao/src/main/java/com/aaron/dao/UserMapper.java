package com.aaron.dao;

import com.aaron.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by com.aaron on 7/11/17.
 */
@Mapper
public interface UserMapper {
    @Select("select * from user where id= #{id}")
    User get(@Param("id") Long id);
}
