package com.wcy.mpdemo.service;

import com.wcy.mpdemo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    void updateById() {
        User user = userService.getById("oeQsW5ofcuN8f24h_IU8ociV1Nok");
        user.setName("李四");
        userService.updateById(user);
    }
}