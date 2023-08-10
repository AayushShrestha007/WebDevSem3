package com.ayush.onlyshoes.repository;
import org.assertj.core.api.Assertions;
import com.ayush.onlyshoes.model.Role;
import com.ayush.onlyshoes.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepoTest {




    @Autowired
    private UserRepository userRepository;

    @Test
    @Rollback(value=false)
    void findUserByEmail() {
        User user= User.builder()
                .id(1)
                .firstName("Ayush")
                .lastName("shrestha")
                .email("ayooshshrestha@gmail.com")
                .password("123456")
                .build();
        userRepository.save(user);
        Assertions.assertThat(user.getId()).isEqualTo(1);


    }

//    @Test
//    public void getUserTest(){
//        User userCreated=userRepository.findById(1).get();
//        Assertions.assertThat(userCreated.getId()).isEqualTo(123);
//    }
}