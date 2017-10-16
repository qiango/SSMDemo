package com.wangq.ssm.dao;


import com.wangq.ssm.entity.People;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleDao {

    void insert(People people);

}
