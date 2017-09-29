package com.wangq.ssm.service.serviceImple;

import com.wangq.ssm.dao.TestDao;
import com.wangq.ssm.entity.Test;
import com.wangq.ssm.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class TestServiceImpl implements TestService{

    @Autowired
    private TestDao testDao;

    @Override
    public List<Map<String,Object>> getOne() {
        return testDao.findAll();
    }

    @Override
    public String insert(Map map) {
        testDao.insert(map);
        return "success";
    }

    @Override
    public String findPassword(String name) {
        return testDao.selectUserByID(name);
    }

    @Override
    public String updateUser(Test t) {
        testDao.updateUser(t);
        return "update success";
    }

    @Override
    public String deleteUser(Integer id) {
        testDao.deleteUser(id);
        return "delete success";
    }
}
