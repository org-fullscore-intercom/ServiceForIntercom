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
    public void test(){
        System.out.println(dao);
        List<Follow> all = dao.findAll();
        System.out.println(all);

    }
    @Test
    public void get(){
        Follow follow = dao.get(1);
        System.out.println(follow);
    }
}
