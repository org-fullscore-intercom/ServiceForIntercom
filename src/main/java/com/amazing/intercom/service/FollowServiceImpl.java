package com.amazing.intercom.service;

import com.amazing.intercom.dao.FollowDAO;
import com.amazing.intercom.pojo.Follow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowServiceImpl implements FollowService {
    @Autowired
    private FollowDAO followDAO;

    @Override
    public int add(Follow follow) {
        followDAO.save(follow);
        System.out.println(follow.getId());
        return follow.getId();
    }

    @Override
    public int delete(int u_id, int f_u_id) {
        return followDAO.deleteByUF(u_id, f_u_id);
    }

    @Override
    public List<Follow> getFollows(int u_id) {
        return followDAO.findFollows(u_id);
    }

    @Override
    public List<Follow> getFans(int f_u_id) {
        return followDAO.findFans(f_u_id);
    }
}
