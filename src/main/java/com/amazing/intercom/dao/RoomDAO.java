package com.amazing.intercom.dao;


import com.amazing.intercom.pojo.Room;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomDAO {
    List<Room> findAll();
    int save(Room room);
    void delete(int id);
    Room get(int id);
    int update(Room room);
}
