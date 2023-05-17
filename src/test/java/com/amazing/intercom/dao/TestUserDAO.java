package com.amazing.intercom.dao;


import com.amazing.intercom.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserDAO {
    @Autowired UserDAO dao;
    @Test
    public void login(){
        User zhangsan = dao.login("zhangsan", "123123");
        System.out.println(zhangsan);
    }
    @Test
    public void save(){
        User user = new User(0,"root","admin123","admin","fav.png");
        dao.save(user);
    }
    @Test
    public void delete(){
        System.out.println(dao.delete(26));
    }
    @Test
    public void update(){
        User user = new User(2,"lisi","lisi","123123","docker.png");
        System.out.println(dao.update(user));
    }
    @Test
    public void findAll(){
        System.out.println(dao.findAll());
    }
    @Test
    public void get(){
        System.out.println(dao.get(1));
    }
    @Test
    public void getByAccount(){
        System.out.println(dao.getByAccount("zhangsan"));
    }
}
