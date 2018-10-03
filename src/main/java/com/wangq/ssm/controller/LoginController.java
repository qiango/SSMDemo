package com.wangq.ssm.controller;

import com.wangq.ssm.dao.TestDao;
import com.wangq.ssm.entity.Test;
import com.wangq.ssm.jwt.AccessToken;
import com.wangq.ssm.jwt.JwtHelper;
import com.wangq.ssm.util.ChanngeUtil;
import com.wangq.ssm.util.ValueUtil;
import com.wangq.ssm.util.YesmywineException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private TestDao testDao;
     //十秒过期
    final static Integer expiresSecond=1000*60;
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
            AccessToken accessTokenEntity = new AccessToken();
            String accessToken = JwtHelper.createJWT( byUserName.getId().toString(),byUserName.getUserName(),
                    expiresSecond);
            //返回accessToken
            accessTokenEntity.setAccess_token(accessToken);
            accessTokenEntity.setExpires_in(expiresSecond);
            accessTokenEntity.setToken_type("bearer");
            accessTokenEntity.setUserId(byUserName.getId());
            accessTokenEntity.setNickName(byUserName.getUserName());
            return ChanngeUtil.toJson(200,accessTokenEntity);
        } catch (YesmywineException e) {
            return ValueUtil.toError(e.getCode(),e.getMessage());
        }

    }

    @ResponseBody
    @RequestMapping(value = "/registered",method = RequestMethod.POST)
    public Object registered(@RequestParam Map<String,String> map){
        try {
            ValueUtil.qianVerifyEmpty(map.get("userName"),map.get("password"));
            Test t=testDao.findByUserName(map.get("userName"));
            if(null!=t){
             throw new YesmywineException("该用户名已存在!");
            }
            testDao.insert(map);
            return ChanngeUtil.toJson(200,"success");
        } catch (YesmywineException e) {
            return ValueUtil.toError(e.getCode(),e.getMessage());
        }

    }
}
