package com.aaron.web;

import com.aaron.service.UserService;
import com.aaron.util.PackageUtils;
import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private static Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public JSONObject getName(@RequestParam("id")long id) {
        try {
            return userService.getName(id);
        } catch (Exception e) {
            logger.error("getName", e);
            return PackageUtils.exception();
        }
    }

    @RequestMapping(value = "/name", method = RequestMethod.POST)
    public JSONObject setName(@RequestParam("id")long id, @RequestParam("name")String name) {
        try {
            return userService.setName(id, name);
        } catch (Exception e) {
            logger.error("setName", e);
            return PackageUtils.exception();
        }
    }
}
