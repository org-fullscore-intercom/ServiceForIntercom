package com.amazing.intercom.controller;

import com.alibaba.fastjson.JSON;
import com.amazing.intercom.pojo.Room;
import com.amazing.intercom.pojo.Type;
import com.amazing.intercom.service.RoomService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RoomController {
    @Autowired
    private RoomService rs;
    @GetMapping("/addRoom")
    @ResponseBody
    public int add(String name, String introduction, String type, int owner){
//        不查重也没事
        Room room = new Room(0, name, introduction, type, owner);
        return rs.addRoom(room);
    }
    @GetMapping("/deleteRoom")
    @ResponseBody
    public boolean delete(int id){
        return rs.deleteRoom(id);
    }
    @GetMapping("/getRoom")
    @ResponseBody
    public String get(int id){
        Room room = rs.getRoom(id);
        return JSON.toJSONString(room);
    }
    @GetMapping("/getRooms")
    @ResponseBody
    public String gets(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "10")int size){
        PageHelper.startPage(start,size);
        List<Room> rooms = rs.getRooms();
        return JSON.toJSONString(rooms);
    }
    @GetMapping("/getRooms/{type}")
    @ResponseBody
    public String type(@PathVariable String type,@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "10")int size){
        PageHelper.startPage(start,size);
        List<Room> roomsByType = rs.getRoomsByType(type);
        return JSON.toJSONString(roomsByType);
    }
    @GetMapping("/getRooms/{owner}")
    @ResponseBody
    public String owner(@PathVariable int owner,@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "10")int size){
        PageHelper.startPage(start,size);
        List<Room> roomsByOwner = rs.getRoomsByOwner(owner);
        return JSON.toJSONString(roomsByOwner);
    }
    @PostMapping("/updateRoom")
    @ResponseBody
    public boolean update(int id,String name,String introduction,String type,int owner){
        Room room = new Room(id, name, introduction, type, owner);
        return rs.updateRoom(room);
    }
}
