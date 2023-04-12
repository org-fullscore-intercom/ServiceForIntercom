package com.amazing.intercom.service;

import com.amazing.intercom.pojo.Room;

import java.util.List;

public interface RoomService {
    int addRoom(Room room);
    boolean deleteRoom(int id);
    Room getRoom(int id);
    List<Room> getRooms();
    List<Room> getRoomsByOwner(int owner);
    List<Room> getRoomsByType(String type);
    boolean updateRoom(Room room);
}
