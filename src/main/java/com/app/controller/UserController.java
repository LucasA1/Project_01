package com.app.controller;

import com.app.model.User;
import com.app.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;





import java.util.List;
import java.util.Map;

/**
 * Created by LukeMcDermott on 7/10/17.
 */
@Controller
@EnableAutoConfiguration
@RequestMapping(value="/user")
public class UserController {

    UserService userService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(value="/")
    public String index() {
        return "index";
    }

    @RequestMapping(value="/getAll", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUsers() throws Exception {
        return userService.listAllUsers();
    }

    @RequestMapping(value="/get/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable(value = "userId")Long userId) throws Exception {
        if (userId != null) {
            return userService.findById(userId);
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

