package com.jenk.springbootjenkins.repository;

import com.jenk.springbootjenkins.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByJob(String job);

    //List<User> findAllByJob(String job);
}
