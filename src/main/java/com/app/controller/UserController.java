package com.app.controller;

import com.app.model.User;
import com.app.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by LukeMcDermott on 7/10/17.
 */
@RestController
public class UserController {

    UserService userService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(value="/create", method = RequestMethod.POST)
    @ResponseBody
    public User createUser(@RequestBody Map<String, Object> userJson) throws Exception{
        if(userJson != null) {
            return userService.createUser(userJson);
        } else {
            throw new Exception("Must pass in a json request");
        }
    }
}

