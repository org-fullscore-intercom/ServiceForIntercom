package com.amazing.intercom.controller;

import com.amazing.intercom.pojo.Room;
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
    public void add() {
        System.out.println(roomController.add("test2", "a test room", "4280391411", 1));
    }
    @Test
    public void delete(){
        System.out.println(roomController.delete(5));
    }
    @Test
    public void get(){
        System.out.println(roomController.get(4));
    }
    @Test
    public void gets(){
        System.out.println(roomController.gets(0,5));
    }
    @Test
    public void type(){
        System.out.println(roomController.type("4280391411",0,5));
    }
    @Test
    public void owner(){
        System.out.println(roomController.owner(1,0,2));
    }
    @Test
    public void update(){
        Room room = new Room(4,"wswsws","a test room","4280391411",1);
        System.out.println(roomController.update(room.getId(),room.getName(),room.getIntroduction(),room.getType(),room.getOwner()));
    }
}
