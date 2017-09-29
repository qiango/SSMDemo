package com.wangq.ssm.service;


import com.wangq.ssm.entity.Test;

import java.util.List;
import java.util.Map;

public interface TestService {

     List<Map<String,Object>> getOne();

     String insert(Map map);

     String findPassword(String name);

     String updateUser(Test t);

     String deleteUser(Integer id);
}
