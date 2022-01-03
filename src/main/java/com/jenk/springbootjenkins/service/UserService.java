package com.jenk.springbootjenkins.service;


import com.jenk.springbootjenkins.dto.UserDTO;
import com.jenk.springbootjenkins.model.User;

import java.util.List;

public interface UserService {
    User saveUser(UserDTO userDTO);
    User updateUser(int id,UserDTO userDTO);
    User getUser(int id);
    void deleteUser(int id);
    List<User> getUsers();
    List<User> getUsersWithJob(String job);
}
