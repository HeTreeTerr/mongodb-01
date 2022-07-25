package com.hss.service.impl;

import com.hss.MongodbBootApplication;
import com.hss.dto.CreateUserDTO;
import com.hss.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@SpringBootTest(classes = MongodbBootApplication.class)
@RunWith(SpringRunner.class)
@Slf4j
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void createUser() {
        CreateUserDTO userDTO = CreateUserDTO.builder()
                .name("lisi")
                .age(18)
                .tags(Arrays.asList("A","B","C"))
                .build();
        userService.createUser(userDTO);
        log.info("createUser success");
    }
}