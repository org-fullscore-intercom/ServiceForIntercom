package com.amazing.intercom.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomControllerTest {
    @Autowired
    private RoomController roomController;
    @Test
    public void add(){

    }
    @Test
    public void delete(){

    }
    @Test
    public void get(){
        System.out.println(roomController.get(1));
    }
    @Test
    public void gets(){

    }
    @Test
    public void type(){

    }
    @Test
    public void owner(){

    }
    @Test
    public void update(){

    }
}
