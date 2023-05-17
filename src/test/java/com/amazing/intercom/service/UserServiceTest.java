package com.amazing.intercom.service;

import com.amazing.intercom.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Test
    public void login(){
        System.out.println(userService.login("zhangsan","123123"));
    }
    @Test
    public void addUser(){
        User user = new User(0,"test","unique","123123","fav.png");
        System.out.println(userService.addUser(user));
    }
    @Test
    public void getUser(){
        System.out.println(userService.getUser(1));
    }
    @Test
    public void getUserByAccount(){
        System.out.println(userService.getUserByAccount("zhangsan"));
    }
    @Test
    public void deleteUser(){
        System.out.println(userService.deleteUser(29));
    }
    @Test
    public void modifyUser(){
        User user = new User(2,"lisi","lisi","123123","docker.png");
        System.out.println(userService.modifyUser(user));
    }
}
