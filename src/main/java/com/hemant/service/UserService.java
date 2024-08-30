package com.hemant.service;

import com.hemant.dto.UserDTO;
import com.hemant.model.User;

import java.util.Map;

public interface UserService {

    User signup(UserDTO userDto);
    UserDTO findUserByEmail(String email);
    UserDTO updateProfile(UserDTO userDto);
    User updateField(int id, Map<String, Object> fields);
    UserDTO changePassword(UserDTO userDto, String newPassword);
}
