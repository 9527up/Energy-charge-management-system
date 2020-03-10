package com.example.bigproject.entity;
import lombok.Data;

import java.io.Serializable;
@Data
public class userwalletentity implements Serializable {

    private String u_id;
    private String u_charge;
    private String u_less;
    private String u_unpay;
    private String u_time;

    public String getU_id(){
        return u_id;
    }
    public String getU_charge(){
        return u_charge;

    }
    public String getU_less(){
        return u_less;
    }
    public String getU_unpay(){
        return u_unpay;
    }
    public String getU_time(){
        return u_time;
    }

    public void setU_id(String u_id){
        this.u_id=u_id;
    }
    public void setU_charge(String u_charge){
        this.u_charge=u_charge;
    }
    public void setU_unpay(String u_unpay){
        this.u_unpay=u_unpay;
    }
    public void setU_time(String u_time){
        this.u_time=u_time;
    }

    public userwalletentity(){

    }
    public userwalletentity(String u_id, String u_charge, String u_less, String u_unpay, String  u_time){
        this.u_id=u_id;
        this.u_charge=u_charge;
        this.u_less=u_less;
        this.u_unpay=u_unpay;
        this.u_time=u_time;
    }


}
