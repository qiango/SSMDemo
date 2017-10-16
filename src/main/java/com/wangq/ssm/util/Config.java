package com.wangq.ssm.util;

import com.wangq.ssm.entity.DataSource;
import com.wangq.ssm.entity.DefaultData;

public class Config {
    public static  DataSource get(){
        DataSource dataSource=new DataSource("88.88.88.36",6379);
        DefaultData.setDataSource(dataSource);
        return dataSource;
    }

//    public DataSource dataSource(){
//
//        DataSource dataSource=new DataSource();
//        dataSource.setHost("88.88.88.49");
//        dataSource.setPassword("123456");
//        dataSource.setUserName("wangqian");
//        dataSource.setPort("6379");
//        return dataSource;
//
//    }

}
