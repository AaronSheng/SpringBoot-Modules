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

    public JSONObject getName(Long id) {
        User user =  userMapper.get(id);
        if (user == null) {
            return PackageUtils.fail();
        }

        JSONObject content = new JSONObject();
        content.put("name", user.getName());
        return PackageUtils.success(content);
    }

    public JSONObject setName(Long id, String name) {
        User user = userMapper.get(id);
        if (user != null) {
            user.setName(name);
            userMapper.update(user);
        }

        return PackageUtils.success();
    }
}
