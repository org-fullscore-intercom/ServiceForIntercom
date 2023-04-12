package com.amazing.intercom.dao;

import com.amazing.intercom.pojo.RoomRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRecordDAO {
    List<RoomRecord> findByR(int r_id);
    List<RoomRecord> onlineRR(int r_id);
    RoomRecord get(int id);
    int save(RoomRecord roomRecord);
    int delete(int id);
    int update(RoomRecord roomRecord);
    int countByRS(int r_id);
    int countByR(int r_id);
    int countByUR(int u_id,int r_id);
}
