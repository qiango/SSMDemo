package com.wangq.ssm.dao;


import com.wangq.ssm.entity.People;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PeopleDao {

    void insert(People people);

    List<Map<String,Object>> findByName(@Param("realName") String realName, @Param("sex") String sex);

}
