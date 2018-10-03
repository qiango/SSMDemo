package com.wangq.ssm.jwt;

import com.wangq.ssm.util.ValueUtil;
import com.wangq.ssm.util.YesmywineException;
import io.jsonwebtoken.Claims;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by SJQ on 2017/6/8.
 */
public class UserUtils {

    final static String base64Secret="MDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTgzMjYyN2I0ZOM=";
    public static String getUserJson(HttpServletRequest request) throws YesmywineException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        String auth = httpRequest.getHeader("Authorization");
        String requestPerm = httpRequest.getHeader("RequestPerm");

        if ((auth != null) && (auth.length() > 7))
        {
            String HeadStr = auth.substring(0, 6).toLowerCase();
            if (HeadStr.compareTo("bearer") == 0)
            {

                auth = auth.substring(7, auth.length());
                Claims claims = JwtHelper.parseJWT(auth, base64Secret);

                    if ( claims!= null)
                {
                    String username = claims.getSubject();
                    return username;
                }
            }
        }
        ValueUtil.isError("用户未登录或已登录超时,请重新登录");
        return null;
    }

}
