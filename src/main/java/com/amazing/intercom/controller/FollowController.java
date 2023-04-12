package com.amazing.intercom.controller;

import com.alibaba.fastjson.JSON;
import com.amazing.intercom.pojo.Follow;
import com.amazing.intercom.pojo.RoomRecord;
import com.amazing.intercom.pojo.User;
import com.amazing.intercom.service.FollowService;
import com.amazing.intercom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FollowController {
    @Autowired
    private FollowService followService;
    @Autowired
    private UserService userService;

    @GetMapping("/addFollow")
    @ResponseBody
    public String add(int u_id,int f_u_id){
        Follow follow = new Follow(u_id, f_u_id);
        int id=followService.add(follow);
        return String.valueOf(id);
    }

    @GetMapping("/deleteFollow")
    @ResponseBody
    public boolean delete(int u_id, int f_u_id) {
        int result=followService.delete(u_id, f_u_id);

        return result!=0;
    }

    @GetMapping("/follows")
    @ResponseBody
    public String follows(int u_id){
        List<Follow> follows = followService.getFollows(u_id);
        ArrayList<User> users=new ArrayList<>();
        for (Follow f : follows){
            users.add(userService.getUser(f.getF_u_id()));
        }
        return JSON.toJSONString(users);
    }
    @GetMapping("/fans")
    @ResponseBody
    public String fans(int f_u_id){
        List<Follow> fans = followService.getFans(f_u_id);
        ArrayList<User> users=new ArrayList<>();
        for (Follow f : fans){
            users.add(userService.getUser(f.getU_id()));
        }
        return JSON.toJSONString(users);
    }
}
