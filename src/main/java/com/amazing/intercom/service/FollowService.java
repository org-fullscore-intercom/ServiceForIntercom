package com.amazing.intercom.service;

import com.amazing.intercom.pojo.Follow;

import java.util.List;

public interface FollowService {
    int add(Follow follow);
    int delete(int u_id,int f_u_id);
    List<Follow> getFollows(int u_id);
    List<Follow> getFans(int f_u_id);
}
