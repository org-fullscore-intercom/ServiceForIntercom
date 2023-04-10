package com.amazing.intercom.dao;

import com.amazing.intercom.pojo.Follow;


import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowDAO {
    List<Follow> findAll();
    int save(Follow follow);
    void delete(int id);
    Follow get(int id);
    int update(Follow follow);

}
