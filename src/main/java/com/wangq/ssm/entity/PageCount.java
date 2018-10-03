package com.wangq.ssm.entity;

import java.util.List;

public class PageCount<T> {

    private Long id;
    private Integer pageSize;
    private Integer allNum;
    private Integer currentNum;
    private List<T> entity;

    public void PageCount(){
        this.pageSize=10;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getAllNum() {
        return allNum;
    }

    public void setAllNum(Integer allNum) {
        this.allNum = allNum;
    }

    public Integer getCurrentNum() {
        return currentNum;
    }

    public void setCurrentNum(Integer currentNum) {
        this.currentNum = currentNum;
    }

    public List<T> getEntity() {
        return entity;
    }

    public void setEntity(List<T> entity) {
        this.entity = entity;
    }
}
