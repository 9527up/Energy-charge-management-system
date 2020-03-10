package com.example.bigproject.entity;
import lombok.Data;

import java.io.Serializable;

@Data
public class recordbyyearentity implements Serializable {

    private String n_name;
    private String u_this;
    private String u_fee;

    public String getN_name(){
        return n_name;
    }
    public String getU_this(){
        return u_this;
    }
    public String getU_fee(){
        return u_fee;
    }


    public void setU_this(String u_this){
        this.u_this=u_this;
    }
    public void setN_name(String n_name){
        this.n_name=n_name;
    }
    public void setU_fee(String u_fee){
        this.u_fee= u_fee;
    }

    public recordbyyearentity(){

    }
    public recordbyyearentity(String n_name,String u_this,String u_fee){
        this.n_name=n_name;
        this.u_this=u_this;
        this.u_fee=u_fee;
    }


}
