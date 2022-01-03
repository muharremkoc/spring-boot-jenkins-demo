package com.jenk.springbootjenkins.service;

import com.jenk.springbootjenkins.dto.UserDTO;
import com.jenk.springbootjenkins.mapstruct.UserMapper;
import com.jenk.springbootjenkins.model.User;
import com.jenk.springbootjenkins.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService{

    final UserRepository userRepository;
    final UserMapper userMapper;

    @Override
    public User saveUser(UserDTO userDTO) {
        User user=userMapper.userDTOtoUser(userDTO);
        return userRepository.save(user);
    }

    @Override
    public User updateUser(int id, UserDTO userDTO) {
        User getUser=userRepository.findById(id).orElseThrow();
        getUser.setName(userDTO.getName());
        getUser.setJob(userDTO.getJob());
        return userRepository.save(getUser);
    }

    @Override
    public User getUser(int id) {
        return userRepository.findById(id).get();
    }


    @Override
    public void deleteUser(int id) {
       userRepository.deleteById(id);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getUsersWithJob(String job) {
        List<User> getUsers=userRepository.findAll().stream().filter(user -> user.getJob().equals(job)).collect(Collectors.toList());
        return getUsers;
    }
}
