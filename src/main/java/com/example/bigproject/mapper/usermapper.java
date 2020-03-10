package com.example.bigproject.mapper;

import com.example.bigproject.entity.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface usermapper {
    userentity login(userentity userentity);
    //int userregister(userentity userentity);
    @Select("SELECT * FROM user1 WHERE u_id = #{userid}")
    List<userentity> getUserByname(String userid);
    @Insert("INSERT INTO user1(u_id,u_name,u_pass,u_company,u_tel,u_address" + ") VALUES(#{u_id},#{u_name},#{u_pass},#{u_company},#{u_tel}, #{u_address})")
    @Options(useGeneratedKeys = true,keyColumn = "id")
    void userregister(userentity user);
    @Update({"UPDATE user1 set u_id=#{u_id} ,u_name =#{u_name},u_pass=#{u_pass},u_company=#{u_company},u_tel=#{u_tel},u_address=#{u_address} where u_id=#{u_id}"})
    @Options(useGeneratedKeys = true,keyColumn = "id")
    int updateUser(userentity userentity);

    @Select("SELECT * FROM userwallet WHERE u_id = #{u_id}")
    List<userwalletentity> getwallet(String u_id);

    @Insert("INSERT INTO userwallet(u_id,u_charge,u_less,u_unpay,u_time" +
            ") VALUES(#{u_id},#{u_charge},#{u_less},#{u_unpay},#{u_time})")
    void chargerecord(userwalletentity userwallet);

    @Select("SELECT *FROM recordmonth WHERE u_id=#{u_id}")
    List<recordentity> getmonthrecord(String u_id);

    @Insert("INSERT INTO repair(f_id,u_id,f_content,u_address,f_time" +
            ") VALUES(#{f_id},#{u_id},#{f_content},#{u_address},#{f_time})")
    void filedweixiudan(weixiudanentity weixiudan);

    @Select("SELECT n_name, SUM (u_this) as u_this,sum(u_fee)as u_fee FROM recordmonth WHERE u_id=#{u_id} group by n_name")
   //@Select("SELECT  *FROM 月消费记录表 WHERE u_id=#{u_id}")
    List<recordbyyearentity> recordbyyear(String u_id);

    @Select("select sum(u_fee) as u_fee from recordmonth where u_id=#{u_id}")
    String getfee(String u_id);




}
