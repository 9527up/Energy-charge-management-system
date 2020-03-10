package com.example.bigproject.entity;
import lombok.Data;

import java.io.Serializable;

@Data
public class recordentity implements Serializable {

    private String u_id;
    private float u_last;
    private String n_name;
    private float u_this;
    private float u_fee;


    public String getU_id(){
        return u_id;
    }
    public String getN_name(){
        return n_name;
    }
    public float getU_last(){
        return u_last;
    }
    public float getU_this(){
        return u_this;
    }
    public float getU_fee(){
        return u_fee;
    }
    public void setU_id(String u_id){
        this.u_id=u_id;
    }
    public void setU_last(float u_last){
        this.u_last=u_last;
    }
    public void setU_this(float u_this){
        this.u_this=u_this;
    }
    public void setN_name(String n_name){
        this.n_name=n_name;
}
    public void setU_fee(float u_fee){
        this.u_fee= u_fee;
    }

    public recordentity(){

    }
    public recordentity(String u_id,String n_name,float u_this,float u_last,float u_fee){
        this.u_id=u_id;
        this.n_name=n_name;
        this.u_last=u_last;
        this.u_this=u_this;
        this.u_fee=u_fee;
    }


}
