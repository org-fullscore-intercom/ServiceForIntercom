package com.amazing.intercom.dao;

import com.amazing.intercom.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO {
    int save(User user);
    int delete(int delete);
    int update(User user);
    List<User> findAll();
    User get(int id);
    User login(String account,String password);
    int getByAccount(String account);
}
