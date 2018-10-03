package com.wangq.ssm.dao;


import com.wangq.ssm.entity.ImageUrl;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UploadDao {

    void insert(Map map);

    @Select("select * from ImageUrl where id =#{id}")
    ImageUrl findById(@Param("id") String id);

}
