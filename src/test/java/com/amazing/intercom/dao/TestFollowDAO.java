package com.amazing.intercom.dao;

import com.amazing.intercom.pojo.Follow;
import org.junit.Test;
import org.junit.runner.RunWith;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestFollowDAO {
    @Autowired
    private FollowDAO dao;

    @Test
    public void get(){
        Follow follow = dao.get(1);
        System.out.println(follow);
    }
    @Test
    public void findAll(){
        System.out.println(dao.findAll());
    }
    @Test
    public void findFollows(){
        System.out.println(dao.findFollows(1));
    }
    @Test
    public void findFans(){
        System.out.println(dao.findFans(1));
    }
    @Test
    public void save(){
        Follow follow = new Follow(0,3,3);
        System.out.println(dao.save(follow));
    }
    @Test
    public void delete(){
        System.out.println(dao.delete(5));
    }
    @Test
    public void deleteByUF(){
        System.out.println(dao.deleteByUF(3,3));
    }
    @Test
    public void countByUF(){
        System.out.println(dao.countByUF(1,3));
    }
    @Test
    public void update(){
        Follow follow = new Follow(4,3,2);
        System.out.println(dao.update(follow));
    }

}
