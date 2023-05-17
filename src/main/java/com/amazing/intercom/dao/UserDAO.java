package com.amazing.intercom.dao;

import com.amazing.intercom.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO {
    int save(@Param("user") User user);
    int delete(int id);
    int update(User user);
    List<User> findAll();
    User get(int id);
    User login(@Param("account") String account,@Param("password") String password);
    int getByAccount(String account);
}
