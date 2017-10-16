package com.wangq.ssm.entity;

public class DefaultData {

    public static DataSource dataSource = null;
    private Integer id;



    public static DataSource getDataSource() {
        return dataSource;
    }

    public static void setDataSource(DataSource dataSource) {
        DefaultData.dataSource = dataSource;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
