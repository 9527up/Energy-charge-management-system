package com.example.bigproject.mapper;

import com.example.bigproject.entity.userentity;
import com.example.bigproject.entity.workerentity;
import com.example.bigproject.entity.zhipaientity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface workermapper {
    @Select("SELECT * FROM worker WHERE w_id = #{w_id}")
    List<workerentity> getworkerbyid(String workerid);

    @Update({"UPDATE worker set w_id=#{w_id} ,w_pass =#{w_pass},w_name=#{w_name},w_tel=#{w_tel},w_zhuangtai=#{w_zhuangtai} where w_id=#{w_id}"})
    @Options(useGeneratedKeys = true,keyColumn = "id")
    int zhuangtaiup(workerentity worker);

    @Update({"UPDATE worker set w_id=#{w_id} ,w_pass =#{w_pass},w_name=#{w_name},w_tel=#{w_tel},w_zhuangtai=#{w_zhuangtai} where w_id=#{w_id}"})
    @Options(useGeneratedKeys = true,keyColumn = "id")
    int workerup(workerentity worker);

    @Select("SELECT f_id,f_content,f_address,f_time,w_id  FROM zhipairepair WHERE w_id = #{w_id}")
    List<zhipaientity> getdaiwei(String w_id);

    @Delete("delete from zhipairepair where f_id=#{f_id}")
    void finish(String f_id);

    @Delete("delete from repair where f_id=#{f_id}")
    void finishweixiudan(String f_id);
}
