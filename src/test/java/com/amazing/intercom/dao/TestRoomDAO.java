package com.amazing.intercom.dao;

import com.amazing.intercom.pojo.Room;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRoomDAO {
    @Autowired
    private RoomDAO dao;
    @Test
    public void findAll(){
        System.out.println(dao.findAll());
    }
    @Test
    public void save(){
        Room room = new Room(0,"test2","a room","12345678",2);
        System.out.println(dao.save(room));
    }
    @Test
    public void delete(){
        System.out.println(dao.delete(52));
    }
    @Test
    public void get(){
        System.out.println(dao.get(1));
    }
    @Test
    public void update(){
        Room room = new Room(10, "test", "a room for test", "4280391411", 1);
        System.out.println(dao.update(room));
    }
    @Test
    public void findByType(){
        System.out.println(dao.findByType("87654321"));
    }
    @Test
    public void findByOwner(){
        System.out.println(dao.findByOwner(1));
    }
}
