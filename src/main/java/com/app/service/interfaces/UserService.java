package com.app.service.interfaces;

import com.app.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by LukeMcDermott on 7/10/17.
 */
@Service
public interface UserService {

    User createUser(Map<String, Object> userJson) throws Exception;

    User updateUser(Map<String, Object> updateJson, Long userId) throws Exception;

    User deleteUser(Long userId) throws Exception;
}

