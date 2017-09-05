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

    @RequestMapping(value="/get/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable(value = "userId")Long userId) throws Exception {
        if (userId != null) {
            return userService.findUserByAppId(userId);
        } else {
            throw new Exception("Must pass in a User Id");
        }
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

    @RequestMapping(value="/update/{userId}", method = RequestMethod.PATCH)
    @ResponseBody
    public User updateUser(@PathVariable(value="userId")Long userId, @RequestBody Map<String, Object> userJson) throws Exception{
        if(userJson != null && userId != null) {
            return userService.updateUser(userJson, userId);
        } else {
            throw new Exception("Must pass in a json request");
        }
    }

    @RequestMapping(value="/delete/{userId}", method = RequestMethod.DELETE)
    @ResponseBody
    public User deleteUser(@PathVariable(value="userId")Long userId) throws Exception {
        if (userId != null) {
            return userService.deleteUser(userId);
        } else {
            throw new Exception("Must pass in a User Id");
        }
    }
}

