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
    public User addUser(User user) {
        userDAO.save(user);
        return userDAO.get(user.getId());
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
        User realU = userDAO.get(user.getId());//获取旧的user信息，与将要修改的进行比较
        if (!realU.getAccount().equals(user.getAccount())) { //如果要修改account属性，因为要增加 account 不能重复的限制，这里进行处理
            if (userDAO.getByAccount(user.getAccount())==0){ //如果当前数据库中不存在该account记录，可以修改account
                return userDAO.update(user)==1;
            }else{ //已存在相同的account记录，请更换account
                return false;
            }
        }
        //如果不修改account，直接更新
        return userDAO.update(user)==1;
    }
}
