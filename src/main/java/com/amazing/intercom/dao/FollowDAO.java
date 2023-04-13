package com.amazing.intercom.dao;

import com.amazing.intercom.pojo.Follow;


import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowDAO {
    List<Follow> findAll();
    List<Follow> findFollows(int u_id);
    List<Follow> findFans(int f_u_id);
    int save(Follow follow);
    int delete(int id);
    int deleteByUF(@Param("u_id") int u_id,@Param("f_u_id") int f_u_id);
    Follow get(int id);
    int countByUF(@Param("u_id") int u_id,@Param("f_u_id") int f_u_id);
    int update(Follow follow);

}
