package com.wangq.ssm.dao;

import com.wangq.ssm.entity.Test;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface TestDao {

    List<Map<String,Object>> findAll();

    void insert(Test test);

    String selectUserByID(String userName);

    void updateUser(Test test);

    void deleteUser(Integer id);
}
