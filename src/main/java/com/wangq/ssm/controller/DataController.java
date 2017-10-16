package com.wangq.ssm.controller;


import com.wangq.ssm.entity.DataSource;
import com.wangq.ssm.entity.People;
import com.wangq.ssm.service.TestService;
import com.wangq.ssm.util.ChanngeUtil;
import com.wangq.ssm.util.ValueUtil;
import com.wangq.ssm.util.YesmywineException;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/data")
public class DataController {

    @Autowired
    private TestService testService;


    @ResponseBody
    @RequestMapping(value = "/1",method = RequestMethod.GET)
    public String date(DataSource dataSource){
//        System.out.print(dataSource.getHost())
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/2",method = RequestMethod.GET)
    public Object select(Integer id){
        try {
            return ChanngeUtil.toJson(HttpStatus.SC_OK,testService.selectNameAndOr(id));
        } catch (YesmywineException e) {
            return ValueUtil.toError(e.getCode(),e.getMessage());
        }
    }


    @ResponseBody
    @RequestMapping(value="/3",method = RequestMethod.POST)
    public Object find1(People people){
        return ChanngeUtil.toJson(HttpStatus.SC_OK,testService.updatePeople(people));
    }


}
