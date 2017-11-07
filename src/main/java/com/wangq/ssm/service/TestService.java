package com.wangq.ssm.service;


import com.wangq.ssm.entity.People;
import com.wangq.ssm.entity.Test;
import com.wangq.ssm.util.YesmywineException;

import java.util.List;
import java.util.Map;

public interface TestService {

     List<Map<String,Object>> getOne()throws YesmywineException;

     String insert(Map map) throws YesmywineException;

     String findPassword(String name);

     String updateUser(Test t);

     String deleteUser(int[] list)throws YesmywineException;

     Map<String,Object> selectNameAndOr(Integer id) throws YesmywineException;

     String deleteByUser(String userName,Integer [] age);

     String updatePeople(People people);
}
