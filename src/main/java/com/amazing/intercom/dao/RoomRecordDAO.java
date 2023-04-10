package com.amazing.intercom.dao;

import com.amazing.intercom.pojo.RoomRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRecordDAO {
    List<RoomRecord> findAll();
    RoomRecord get(int id);
    int save(RoomRecord roomRecord);
    void delete(int id);
    int update(RoomRecord roomRecord);
}
