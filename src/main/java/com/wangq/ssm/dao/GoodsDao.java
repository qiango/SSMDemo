package com.wangq.ssm.dao;


import com.wangq.ssm.entity.Goods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface GoodsDao {

    List<Goods> findByType(@Param("type") String type);

    List<Goods> findAll(Integer currentPage,Integer pageSize);

    void insert(Map map);


}
