package com.amazing.intercom.web;

import com.amazing.intercom.dao.FollowDAO;
import com.amazing.intercom.pojo.Follow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {
    @Autowired
    FollowDAO dao;
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
//        List<Follow> all = dao.findAll();
        return "Hello Sprint Boot";
    }
}
