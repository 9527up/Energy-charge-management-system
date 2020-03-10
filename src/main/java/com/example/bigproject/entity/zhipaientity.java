package com.example.bigproject.entity;
import lombok.Data;

import java.io.Serializable;

@Data
public class zhipaientity implements Serializable {

    private String f_id;
    private String w_id;
    private String f_time;
    private String f_content;
    private String f_address;


    public String getF_id(){
        return f_id;
    }
    public String getF_time(){
        return f_time;
    }
    public String getW_id(){
        return w_id;
    }
    public String getF_content(){
        return f_content;
    }
    public String getF_address(){
        return f_address;
    }
    public void setF_id(String f_id){
        this.f_id=f_id;
    }
    public void setW_id(String u_id){
        this.w_id=w_id;
    }
    public void setF_time(String f_time){
        this.f_time=f_time;
    }
    public void setF_content(String f_content){
        this.f_content=f_content;
    }

    public void setF_address(String f_address){
        this.f_address=f_address;
    }

    public zhipaientity(){

    }
    public zhipaientity (String f_id,String f_content,String f_address,String f_time,String w_id){
        this.f_id=f_id;
        this.w_id=w_id;
        this.f_time=f_time;
        this.f_content=f_content;
        this.f_address=f_address;
    }


}
