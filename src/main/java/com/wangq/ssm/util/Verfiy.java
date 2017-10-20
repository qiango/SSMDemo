package com.wangq.ssm.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Verfiy {

    public static String verfiy(HttpServletRequest request, HttpServletResponse response) throws YesmywineException {
        response.setHeader("Access-Control-Allow-Origin","");
        response.setHeader("www","123456");
        Cookie[] cookies = request.getCookies();
        String userCode = "";
        if ( null != cookies ) {
            boolean a=false;
            for (int i = 0; i < cookies.length ; i++) {
                switch (cookies[i].getName()) {
                    case "user" :
                        userCode = cookies[i].getValue();
                        a=true;
                        System.out.println(System.currentTimeMillis()+":uid:"+userCode);
                        break;
                }
            }
            if(!a){
                ValueUtil.isError("未登录,请登录");
            }else {
                return userCode;
            }
        } else {
            ValueUtil.isError("未登录,请登录");

        }
        return null;
    }

}
