package com.hemant.service;

import com.hemant.dto.RoleDTO;
import com.hemant.dto.UserDTO;
import com.hemant.model.Role;
import com.hemant.model.User;
import com.hemant.repository.RoleRepo;
import com.hemant.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public User signup(UserDTO userDto) {
        User user = userRepo.findByEmail(userDto.getEmail());
        if(user==null) {




            Role role = new Role("USER");
            roleRepo.save(role);

            user = new User()
                    .setUserName(userDto.getUsername())
                    .setEmail(userDto.getEmail())
                    .setPassword(passwordEncoder.encode(userDto.getPassword()))
                    .setContact(userDto.getMobileNumber())
                    .setFirstName(userDto.getFirstName())
                    .setLastName(userDto.getLastName())
                    .setRoles(role);
            return userRepo.save(user);
        }
        return null;

    }

    @Override
    public UserDTO findUserByEmail(String email) {
        return null;
    }

    @Override
    public UserDTO updateProfile(UserDTO userDto) {
        return null;
    }

    @Override
    public User updateField(int id, Map<String, Object> fields) {
        Optional<User> userOptional = userRepo.findById(id);
        if (userOptional.isEmpty()) {
            return null;
        }

        User user = userOptional.get();

        fields.forEach((key, value) -> {
            switch (key) {
                case "userName":
                    user.setUserName((String) value);
                    break;
                case "email":
                    user.setEmail((String) value);
                    break;
                case "role":
                    Role roles = new Role((String) value);
                    roleRepo.save(roles);
                    user.setRoles(roles);
                    break;
                // Handle other fields here
            }
        });
        return userRepo.save(user);
    }

    @Override
    public UserDTO changePassword(UserDTO userDto, String newPassword) {
        return null;
    }
}
