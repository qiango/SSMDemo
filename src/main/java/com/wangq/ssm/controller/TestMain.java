package com.wangq.ssm.controller;


import com.wangq.ssm.entity.DataSource;
import com.wangq.ssm.entity.DefaultData;
import com.wangq.ssm.util.RedisCache;
import org.apache.log4j.Logger;
import org.junit.Test;

import static com.wangq.ssm.entity.DefaultData.dataSource;


public class TestMain {
    private static Logger logger = Logger.getLogger(TestMain.class);

    @Test
    public void get() {
        // 记录debug级别的信息
        logger.debug("This is debug message.");
        // 记录info级别的信息
        logger.info("This is info message.");
        // 记录error级别的信息
        logger.error("This is error message.");
    }

    @Test
    public void get1(){

        RedisCache.set(dataSource,"ww","wangqian");
        RedisCache.expire("ww",10);
        System.out.println(RedisCache.get("ww"));
    }

}
