package com.amazing.intercom.controller;

import com.alibaba.fastjson.JSON;
import com.amazing.intercom.pojo.RoomRecord;
import com.amazing.intercom.pojo.User;
import com.amazing.intercom.service.RoomRecordService;
import com.amazing.intercom.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RoomRecordController {
    @Autowired
    private RoomRecordService rrs;
    @Autowired
    private UserService userService;

    @GetMapping("/history")
    @ResponseBody
    public String history(int r_id, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "10")int size){
        PageHelper.startPage(start,size);
        List<RoomRecord> roomRecords = rrs.historyRR(r_id);
        return JSON.toJSONString(roomRecords);
    }

    @GetMapping("/onlineMans")
    @ResponseBody
    public int onlineN(int r_id){
        return rrs.onlineN(r_id);
    }
    @GetMapping("/historyMans")
    @ResponseBody
    public int historyN(int r_id){
        return rrs.historyN(r_id);
    }
    @PostMapping("/addRoomRecord")
    @ResponseBody
    public int add(int u_id,int r_id,int state){
        RoomRecord roomRecord = new RoomRecord(0,u_id,r_id,state);
        return rrs.addRR(roomRecord);
    }
    @GetMapping("/deleteRoomRecord")
    @ResponseBody
    public boolean delete(int id){
        return rrs.deleteRR(id);
    }
    @GetMapping("/outRoom")
    @ResponseBody
    public boolean leave(int u_id,int r_id){
        return rrs.leave(u_id, r_id);
    }
    @GetMapping("/inRoom")
    @ResponseBody
    public boolean come(int u_id,int r_id){
        return rrs.come(u_id, r_id);
    }
    @GetMapping("/onlineUsers")
    @ResponseBody
    public String onlineUs(int r_id,@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "10")int size){
        PageHelper.startPage(start,size);
        List<RoomRecord> roomRecords = rrs.onlineRR(r_id);
        ArrayList<User> users=new ArrayList<>();
        for (RoomRecord rr : roomRecords){
            users.add(userService.getUser(rr.getU_id()));
        }
        return JSON.toJSONString(users);
    }
}
