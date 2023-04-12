package com.amazing.intercom.service;

import com.amazing.intercom.pojo.User;

public interface UserService {
    User login(String account,String password);
    int addUser(User user);
    User getUser(int id);
    boolean modifyUser(User user);
    int getUserByAccount(String account);
    boolean deleteUser(int id);
}
