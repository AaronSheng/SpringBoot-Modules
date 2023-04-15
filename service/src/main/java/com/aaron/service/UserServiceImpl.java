package com.aaron.service;

import com.aaron.dao.UserMapper;
import com.aaron.model.User;
import com.aaron.util.PackageUtils;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Aaron Sheng on 9/9/16.
 */
@Service
@Transactional(value="serverTransactionManager")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public String getName(Long id) {
        User user =  userMapper.get(id);
        if (user == null) {
            return null;
        }
        return user.getName();
    }

    public void setName(Long id, String name) {
        User user = userMapper.get(id);
        if (user != null) {
            user.setName(name);
            userMapper.update(user);
        }
    }
}
