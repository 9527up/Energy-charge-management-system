package com.example.bigproject.entity;
import lombok.Data;

import java.io.Serializable;

@Data
public class nengyuanentity implements Serializable {

    private String n_id;
    private String n_name;
    private String n_price;
    private String n_last;


    public String getN_id(){
        return n_id;
    }

    public String getN_name(){
        return n_name;
    }
    public String getN_price(){
        return n_price;
    }
    public String getN_lastchange(){
        return n_last;
    }
    public void setN_id(String n_id){
        this.n_id=n_id;
    }
    public void setN_name(String n_name){
        this.n_name=n_name;
    }
    public void setN_price(String n_price){
        this.n_price=n_price;
    }

    public void setN_lastchange(String n_last){
        this.n_last=n_last;
    }

    public nengyuanentity(){

    }
    public nengyuanentity(String n_id,String n_name,String n_price,String n_last){
        this.n_id=n_id;
        this.n_name=n_name;
        this.n_price=n_price;
        this.n_last=n_last;
    }


}
