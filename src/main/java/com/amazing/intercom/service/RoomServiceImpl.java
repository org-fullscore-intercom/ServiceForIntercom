package com.amazing.intercom.service;

import com.amazing.intercom.dao.RoomDAO;
import com.amazing.intercom.pojo.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoomServiceImpl implements RoomService{
    @Autowired
    private RoomDAO roomDAO;
    @Override
    public int addRoom(Room room) {
        roomDAO.save(room);
        return room.getId();
    }

    @Override
    public boolean deleteRoom(int id) {
        return roomDAO.delete(id)==1;
    }

    @Override
    public Room getRoom(int id) {
        return roomDAO.get(id);
    }

    @Override
    public List<Room> getRooms() {
        return roomDAO.findAll();
    }

    @Override
    public List<Room> getRoomsByOwner(int owner) {
        return roomDAO.findByOwner(owner);
    }

    @Override
    public List<Room> getRoomsByType(String type) {
        return roomDAO.findByType(type);
    }

    @Override
    public boolean updateRoom(Room room) {
        return roomDAO.update(room)==1;
    }
}
