package com.example.bigproject.mapper;

import com.example.bigproject.entity.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface administritormapper {
    administritorentity login(administritorentity administritorentity);
    @Select("select u_id,u_name,u_pass,u_company,u_tel,u_address from user1" )
    List<userentity> getUser();
    @Select("select f_id,u_id,f_content,u_address,f_time from repair")
    List<weixiudanentity> getWxiudan();
    @Insert("INSERT INTO recordmonth(u_id,n_name,u_this,u_last,u_fee" +
            ") VALUES(#{u_id},#{n_name},#{u_this},#{u_last},#{u_fee})")
    void liushui(recordentity liushui);

    @Select("select n_id,n_name,n_price,n_last from resource")
    List<nengyuanentity> getnengyuan();

    @Insert("INSERT INTO resource(n_id,n_name,n_price,n_last" +
            ") VALUES(#{n_id},#{n_name},#{n_price},#{n_last})")
    void nengyuanadd(nengyuanentity nengyuan);

    @Delete("delete from resource where n_id=#{n_id}")
    void nengyuandelete(String n_id);

    @Update({"UPDATE resource set n_id=#{n_id} ,n_name =#{n_name},n_price=#{n_price},n_last=#{n_last} where n_id=#{n_id}"})
    @Options(useGeneratedKeys = true,keyColumn = "id")
    int nengyuanup(nengyuanentity nengyuan);

    @Select("select f_id,u_id,f_content,u_address,f_time from repair where f_id=#{f_id}")
    List<weixiudanentity> getzhipai(String f_id);

    @Insert("INSERT INTO zhipairepair(f_id,f_content,f_address,f_time,w_id" +
            ") VALUES(#{f_id},#{f_content},#{f_address},#{f_time},#{w_id})")
     void zhipai(zhipaientity weixiu);

    @Select("select w_id,w_pass,w_name,w_tel,w_zhuangtai from worker")
    List<workerentity> getworker();

    @Insert("INSERT INTO worker(w_id,w_pass,w_name,w_tel,w_zhuangtai" +
            ") VALUES(#{w_id},#{w_pass},#{w_name},#{w_tel},#{w_zhuangtai})")
    void workeradd(workerentity worker);

    @Select("SELECT * FROM administrator WHERE a_id = #{ad_id}")
    List<administritorentity> getad(String userid);

    @Select("SELECT u_id, sum(u_fee)as u_fee FROM recordmonth  group by u_id")
    List<indebtentity>indebt();

    @Select("select u_unpay from userwallet where u_id=#{u_id}")
    List<unpayentity> getunpay(String u_id);

    @Delete("delete from user1 where u_id=#{u_id}")
    void delete(String u_id);

    @Delete("delete from userwallet where u_id=#{u_id}")
    void deleteuserwallet(String u_id);

    @Delete("delete from recordmonth where u_id=#{u_id}")
    void deleterecord(String u_id);

    @Delete("delete from repair where u_id=#{u_id}")
    void deleterepair(String u_id);

    @Delete("delete from repair where f_id=#{f_id}")
    void deleteweixiudan(String f_id);



    @Update("update userwallet set u_unpay=#{u_unpay} where u_id=#{u_id}")
    int unpayupdate(@Param(value="u_unpay") float u_unpay,@Param(value="u_id") String u_id);
    //@Param(value="uid")Integer uid,@Param(value="gameId") Integer gameId

}
