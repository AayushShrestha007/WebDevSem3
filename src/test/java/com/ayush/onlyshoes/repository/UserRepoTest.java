package com.ayush.onlyshoes.repository;
import org.assertj.core.api.Assertions;
import com.ayush.onlyshoes.model.Role;
import com.ayush.onlyshoes.model.User;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserRepoTest {




    @Autowired
    private UserRepository userRepository;

    //Test to find user by Email
    @Test
    @Order(1)
    void findUserByEmail() {
        User user= User.builder()
                .id(2)
                .firstName("Ayush")
                .lastName("shrestha")
                .email("ayooshshrestha@gmail.com")
                .password("123456")
                .build();
        User returnedUser= userRepository.save(user);
        Assertions.assertThat(returnedUser.getEmail()).isEqualTo("ayooshshrestha@gmail.com");
    }


    //Test to check if user is saved in repo or not
    @Test
    @Order(2)
    @Rollback(value = false)
    public void SaveUser(){

        User user= User.builder()
                .id(2)
                .firstName("Ayush")
                .lastName("shrestha")
                .email("ayooshshrestha@gmail.com")
                .password("123456")
                .build();
        userRepository.save(user);
        Assertions.assertThat(user.getId()).isGreaterThan(0);

    }

    @Test
    @Order(3)
    public void getUser(){
        User user= userRepository.findById(2).get();
        Assertions.assertThat(user.getId()).isEqualTo(2);
    }

}