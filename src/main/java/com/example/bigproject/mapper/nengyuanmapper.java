package com.example.bigproject.mapper;

import com.example.bigproject.entity.nengyuanentity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface nengyuanmapper {
    @Select("select n_id,n_name,n_price,n_last from resource")
    List<nengyuanentity> getnengyuan();
}
