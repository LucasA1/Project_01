package com.app.service;

import com.app.model.User;
import com.app.service.interfaces.UserService;
import com.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by LukeMcDermott on 7/10/17.
 */
@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(Map<String, Object> userJson) throws Exception {
        User userToCreate = new User();
        try {
            parseUserJson(userJson, userToCreate);
        } catch (Exception ex){
            throw new  Exception(ex.getMessage());
        }
        return userToCreate;
    }

    @Override
    public User updateUser(Map<String, Object> updateJson, Long userId) throws Exception {
//        User userToUpdate = findById(userId);
        User userToUpdate = new User();
        try {
            parseUserJson(updateJson, userToUpdate);
        } catch (Exception ex){
            throw new  Exception(ex.getMessage());
        }
        return userToUpdate;
    }

    private User parseUserJson(Map<String, Object> userJson, User user) throws Exception {
        try {
            for (Map.Entry<String, Object> entry : userJson.entrySet()) {
                switch (entry.getKey()) {
                    case "username": {
                        user.setUsername((String) entry.getValue());
                    }
                    case "fullname": {
                        user.setFullname((String) entry.getValue());
                    }
                    case "password": {
                        user.setPassword((String) entry.getValue());
                    }
                    case "role": {
                        user.setRole((String) entry.getValue());
                    }
                }
            }
        } catch (Exception ex){
            throw new Exception(ex);
        }
        return userRepository.save(user);
    }

    @Override
    public User deleteUser(Long userId) throws Exception{
//        User userToDelete = findById(userId);
        User userToDelete = new User();
        if(userToDelete != null){
            try {
                userRepository.delete(userToDelete);
            } catch (Exception ex){
                throw new Exception(ex.getMessage());
            }
        } else {
            throw new Exception("User to delete is null");
        }
        return userToDelete;
    }

}
