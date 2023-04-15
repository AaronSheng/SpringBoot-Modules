package com.aaron.api;

import com.aaron.model.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(value = "/user")
public interface UserController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    String login();

    @RequestMapping(value = "/name", method = RequestMethod.GET)
    Response<String> getName(@RequestParam("id")long id);

    @RequestMapping(value = "/name", method = RequestMethod.POST)
    Response<Void> setName(@RequestParam("id")long id, @RequestParam("name")String name);
}