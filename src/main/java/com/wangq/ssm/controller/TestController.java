package com.wangq.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wangq.ssm.entity.Test;
import com.wangq.ssm.service.TestService;
import com.wangq.ssm.util.ChanngeUtil;
import com.wangq.ssm.util.ValueUtil;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService serviceUser;


    @ResponseBody
    @RequestMapping(value="/1",method = RequestMethod.GET)
    public String get(){
        return ValueUtil.toJson(HttpStatus.SC_OK,"hello my name is wangwangqian lala");
    }

    @ResponseBody
    @RequestMapping(value="/2",method = RequestMethod.GET)
    public  String getOne(){
        return "hello my name is wangwangqian lala";
    }

    @ResponseBody
    @RequestMapping(value="/3",method = RequestMethod.GET)
    public Object gettow(){
        return ChanngeUtil.toJson(HttpStatus.SC_OK,serviceUser.getOne());
    }

    @ResponseBody
    @RequestMapping(value="/4",method = RequestMethod.GET)
    public Object intert(@RequestParam Map<String,String> map){
        return ChanngeUtil.toJson(HttpStatus.SC_OK,serviceUser.insert(map));
    }

    @ResponseBody
    @RequestMapping(value="/5",method = RequestMethod.GET)
    public Object find(String name){
        return ChanngeUtil.toJson(HttpStatus.SC_OK,serviceUser.findPassword(name));
    }

    @ResponseBody
    @RequestMapping(value="/6",method = RequestMethod.GET)
    public Object find1(Test test){
        return ChanngeUtil.toJson(HttpStatus.SC_OK,serviceUser.updateUser(test));
    }

    @ResponseBody
    @RequestMapping(value="/7",method = RequestMethod.GET)
    public Object find2(Integer id){
        return ChanngeUtil.toJson(HttpStatus.SC_OK,serviceUser.deleteUser(id));
    }

}
