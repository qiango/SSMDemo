package com.wangq.ssm.controller;

import com.wangq.ssm.dao.TestDao;
import com.wangq.ssm.entity.Test;
import com.wangq.ssm.util.ChanngeUtil;
import com.wangq.ssm.util.ValueUtil;
import com.wangq.ssm.util.YesmywineException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private TestDao testDao;


    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Object login(String userName, String passWord, HttpServletRequest request, HttpServletResponse response){
        try {
            System.out.println("发送登录》"+request.getSession().getId());
            ValueUtil.verify(userName,"userName");
            ValueUtil.verify(passWord,"passWord");
            Test byUserName = testDao.findByUserName(userName);
            if(null==byUserName||!byUserName.getPassword().equals(passWord)){
                ValueUtil.isError("用户名或密码错误");
            }
            String userJson=ValueUtil.toJsonObject(byUserName).toJSONString();
            Cookie cookie=new Cookie("user",userJson);
            response.addCookie(cookie);
            return ChanngeUtil.toJson(cookie);
        } catch (YesmywineException e) {
            return ValueUtil.toError(e.getCode(),e.getMessage());
        }

    }
}
