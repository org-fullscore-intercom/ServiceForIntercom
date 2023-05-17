package com.amazing.intercom.dao;

import com.amazing.intercom.pojo.RoomRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRoomRecordDAO {
    @Autowired
    private RoomRecordDAO dao;
    @Test
    public void findByR(){
        System.out.println(dao.findByR(1));
    }
    @Test
    public void onlineRR(){
        System.out.println(dao.onlineRR(1));
    }
    @Test
    public void get(){
        System.out.println(dao.get(1));
    }
    @Test
    public void save(){
        RoomRecord roomRecord = new RoomRecord(0, 1, 1, 0);
        System.out.println(dao.save(roomRecord));
    }
    @Test
    public void delete(){
        System.out.println(dao.delete(5));
    }
    @Test
    public void update(){
        RoomRecord roomRecord = new RoomRecord(4, 3, 1, 1);
        System.out.println(dao.update(roomRecord));
    }
    @Test
    public void countByRS(){
        System.out.println(dao.countByRS(1));
    }
    @Test
    public void countByR(){
        System.out.println(dao.countByR(1));
    }
    @Test
    public void countByUR(){
        System.out.println(dao.countByUR(1,1));
    }
}
