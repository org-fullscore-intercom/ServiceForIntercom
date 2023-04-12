package com.amazing.intercom.service;

import com.amazing.intercom.pojo.RoomRecord;

import java.util.List;

public interface RoomRecordService {
    List<RoomRecord> historyRR(int r_id);
    int onlineN(int r_id);
    int historyN(int r_id);
    int addRR(RoomRecord rr);
    boolean deleteRR(int id);
    boolean leave(int u_id,int r_id);
    boolean come(int u_id,int r_id);
    List<RoomRecord> onlineRR(int r_id);
}
