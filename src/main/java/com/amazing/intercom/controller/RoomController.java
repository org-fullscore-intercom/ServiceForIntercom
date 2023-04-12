package com.amazing.intercom.controller;

import com.alibaba.fastjson.JSON;
import com.amazing.intercom.pojo.Room;
import com.amazing.intercom.pojo.Type;
import com.amazing.intercom.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String gets(){
        List<Room> rooms = rs.getRooms();
        return JSON.toJSONString(rooms);
    }
    @GetMapping("/getRooms/{type}")
    @ResponseBody
    public String type(@PathVariable String type){
        List<Room> roomsByType = rs.getRoomsByType(type);
        return JSON.toJSONString(roomsByType);
    }
    @GetMapping("/getRooms/{owner}")
    @ResponseBody
    public String owner(@PathVariable int owner){
        List<Room> roomsByOwner = rs.getRoomsByOwner(owner);
        return JSON.toJSONString(roomsByOwner);
    }
    @PostMapping("/updateRoom")
    @ResponseBody
    public boolean update(Room room){
        return rs.updateRoom(room);
    }
}
