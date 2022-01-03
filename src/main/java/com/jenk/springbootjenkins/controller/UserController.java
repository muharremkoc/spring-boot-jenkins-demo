package com.jenk.springbootjenkins.controller;

import com.jenk.springbootjenkins.dto.UserDTO;
import com.jenk.springbootjenkins.model.User;
import com.jenk.springbootjenkins.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/jenkins/users")
public class UserController {

    final UserService userService;

    @PostMapping("/user/save")
    public User saveUser(@RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);
    }
    @GetMapping("/user/getUser/withID/{id}")
    public User getUser(@PathVariable("id") int id){
        return userService.getUser(id);
    }


    @PutMapping("/user/update/{id}")
    public User updateUser(@PathVariable("id") int id,@RequestBody UserDTO userDTO){
        return userService.updateUser(id, userDTO);
    }

    @DeleteMapping("/user/delete/{id}")
    public void deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
    }


    @GetMapping("/user/get/allUser")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/user/get/allUser/{job}")
    public List<User> getUsers(@PathVariable("job") String job){
        return userService.getUsersWithJob(job);
    }
}
