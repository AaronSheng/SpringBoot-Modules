package com.aaron.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by Aaron Sheng on 10/6/16.
 */
public interface UserService {
    JSONObject getName(Long id);

    JSONObject setName(Long id, String name);
}
