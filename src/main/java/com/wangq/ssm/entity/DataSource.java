package com.wangq.ssm.entity;

public class DataSource {

    private String redisHost;
    private Integer redisPort;
    private String userName;
    private String password;
    private Integer expireSecond;


    public DataSource (String host,Integer port){
        this.redisHost=host;
        this.redisPort=port;
    }

    public String getRedisHost() {
        return redisHost;
    }

    public void setRedisHost(String redisHost) {
        this.redisHost = redisHost;
    }

    public Integer getRedisPort() {
        return redisPort;
    }

    public void setRedisPort(Integer redisPort) {
        this.redisPort = redisPort;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getExpireSecond() {
        if (null == this.expireSecond) {
            return 3600*24*7;
        } else {
            return expireSecond;
        }
    }

    public void setExpireSecond(Integer expireSecond) {
        this.expireSecond = expireSecond;
    }
}
