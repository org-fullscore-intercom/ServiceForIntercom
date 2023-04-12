package com.amazing.intercom.service;

import com.amazing.intercom.dao.UserDAO;
import com.amazing.intercom.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO;
    @Override
    public User login(String account, String password) {
        return userDAO.login(account, password);
    }

    @Override
    public int addUser(User user) {
        userDAO.save(user);
        return user.getId();
    }

    @Override
    public User getUser(int id) {
        return userDAO.get(id);
    }
    @Override
    public int getUserByAccount(String account){
        return userDAO.getByAccount(account);
    }

    @Override
    public boolean deleteUser(int id) {
        return userDAO.delete(id)==1;
    }

    @Override
    public boolean modifyUser(User user) {
        return userDAO.update(user)==1;
    }
}
