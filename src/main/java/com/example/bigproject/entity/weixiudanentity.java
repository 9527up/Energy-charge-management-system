package com.example.bigproject.entity;
import lombok.Data;

import java.io.Serializable;

@Data
public class weixiudanentity implements Serializable {

    private String f_id;
    private String u_id;
    private String f_time;
    private String f_content;
    private String u_address;


    public String getF_id(){
        return f_id;
    }
    public String getF_time(){
        return f_time;
    }
    public String getU_id(){
        return u_id;
    }
    public String getF_content(){
        return f_content;
    }
    public String getU_address(){
        return u_address;
    }
    public void setF_id(String f_id){
        this.f_id=f_id;
    }
    public void setU_id(String u_id){
        this.u_id=u_id;
    }
    public void setF_time(String f_time){
        this.f_time=f_time;
    }
    public void setF_content(String f_content){
        this.f_content=f_content;
    }

    public void setU_address(String u_address){
        this.u_address=u_address;
    }

    public weixiudanentity(){

    }
    public weixiudanentity(String f_id,String u_id,String f_content,String u_address,String f_time){
        this.f_id=f_id;
        this.u_id=u_id;
        this.f_time=f_time;
        this.f_content=f_content;
        this.u_address=u_address;
    }


}
