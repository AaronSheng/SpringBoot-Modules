package com.aaron.web;

import com.aaron.api.UserController;
import com.aaron.model.Response;
import com.aaron.service.UserService;
import com.aaron.util.PackageUtils;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllerImpl implements UserController {
    @Autowired
    private UserService userService;

    public String login() {
        return "login";
    }

    public Response<String> getName(long id) {
        try {
            String name = userService.getName(id);
            return Response.success(name);
        } catch (Exception e) {
        }
        return Response.success(null);
    }

    public Response<Void> setName(long id, String name) {
        try {
            userService.setName(id, name);
        } catch (Exception e) {
        }
        return Response.success(null);
    }
}
