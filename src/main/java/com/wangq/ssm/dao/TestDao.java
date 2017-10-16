package com.wangq.ssm.dao;

import com.wangq.ssm.entity.Test;
import com.wangq.ssm.util.YesmywineException;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface TestDao {

    List<Map<String,Object>> findAll();

    void insert(Map map);

    String selectUserByID(String userName);

    void updateUser(Test test);

    void deleteUser(int[] id);

    Map<String,Object> selectById(Integer id) throws YesmywineException;

    void deleteByUser(@Param("userName") String userName,@Param("age") Integer [] age);
}
