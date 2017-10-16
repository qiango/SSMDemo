package com.wangq.ssm.service.serviceImple;

import com.wangq.ssm.dao.PeopleDao;
import com.wangq.ssm.dao.TestDao;
import com.wangq.ssm.entity.People;
import com.wangq.ssm.entity.Test;
import com.wangq.ssm.service.TestService;
import com.wangq.ssm.util.YesmywineException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
public class TestServiceImpl implements TestService{

    @Autowired
    private TestDao testDao;
    @Autowired
    private PeopleDao peopleDao;

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
    public String deleteUser(int[] list)throws YesmywineException {
        testDao.deleteUser(list);
        return "delete success";
    }

    @Override
    public Map<String,Object> selectNameAndOr(Integer id) throws YesmywineException {
        return testDao.selectById(id);
    }

    @Override
    public String deleteByUser(String userName, Integer[] age) {
        testDao.deleteByUser(userName,age);
        return "success";
    }

    @Override
    public String updatePeople(People people) {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        try {
//            people.setCreateTime(new Timestamp(simpleDateFormat.parse("createTime").getTime()));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        people.setRealName("11111");
        people.setCreateTime(new Date());
        peopleDao.insert(people);
        return "success";
    }
}
