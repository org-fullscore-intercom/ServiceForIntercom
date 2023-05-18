package com.amazing.intercom.service;

import com.amazing.intercom.dao.RoomRecordDAO;
import com.amazing.intercom.pojo.RoomRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomRecordServiceImpl implements RoomRecordService{
    @Autowired
    private RoomRecordDAO rrDao;
    @Override
    public List<RoomRecord> historyRR(int r_id) {
        return rrDao.findByR(r_id);
    }

    @Override
    public int onlineN(int r_id) {
        return rrDao.countByRS(r_id);
    }

    @Override
    public int historyN(int r_id) {
        return rrDao.countByR(r_id);
    }

    @Override
    public int addRR(RoomRecord rr) {
        if (rrDao.countByUR(rr.getU_id(),rr.getR_id())!=0){
            return -1;
        }
        rrDao.save(rr);
        return rr.getId();
    }

    @Override
    public boolean deleteRR(int id) {
        return rrDao.delete(id)==1;
    }

    @Override
    public boolean leave(int u_id, int r_id) {
        RoomRecord rr = new RoomRecord(0, u_id, r_id, 0);
        return rrDao.update(rr)==1;
    }

    @Override
    public boolean come(int u_id, int r_id) {
        RoomRecord rr = new RoomRecord(0, u_id, r_id, 1);
        if (rrDao.countByUR(u_id,r_id)==0)
            return rrDao.save(rr)!=0;
        return rrDao.update(rr)==1;
    }

    @Override
    public List<RoomRecord> onlineRR(int r_id) {
        return rrDao.onlineRR(r_id);
    }
}
