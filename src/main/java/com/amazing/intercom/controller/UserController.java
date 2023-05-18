package com.amazing.intercom.controller;

import com.alibaba.fastjson.JSON;
import com.amazing.intercom.pojo.User;
import com.amazing.intercom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/login")
    @ResponseBody
    public String login(String account,String password){
        User user = userService.login(account, password);
        return JSON.toJSONString(user);
    }
    @GetMapping("/addUser")
    @ResponseBody
    public String add(String name,String account,String password,String avatar){
        if (avatar=="") avatar="fav.png";
        User user = new User(0, name, account, password, avatar);
        //如果账号存在，则不能新建
        if (userService.getUserByAccount(user.getAccount())!=0)
            return "null";
        return JSON.toJSONString(userService.addUser(user));
    }
    @GetMapping("/getUser")
    @ResponseBody
    public String get(int id){
        User user = userService.getUser(id);
        return JSON.toJSONString(user);
    }
    @PostMapping("/modifyUser")
    @ResponseBody
    public String modify(int id,String name,String account,String password,String avatar){

        User user = new User(id, name, account, password, avatar);
        return JSON.toJSONString(userService.modifyUser(user));
    }
    @GetMapping("/deleteUser")
    @ResponseBody
    public String delete(int id){
        return JSON.toJSONString(userService.deleteUser(id));
    }
}
