package com.example.bigproject.entity;
import lombok.Data;

import java.io.Serializable;

@Data
public class userentity implements Serializable {

    private String u_id;
    private String u_pass;
    private String u_name;
    private String u_company;
    private String u_tel;
    private String u_address;

    public String getU_pass(){
        return u_pass;
    }
    public String getU_id(){
        return u_id;

    }
    public String getU_name(){
        return u_name;
    }
    public String getU_company(){
        return u_company;
    }
    public String getU_tel(){
        return u_tel;
    }
    public String getU_address(){
        return u_address;
    }
    public void setU_id(String u_id){
        this.u_id=u_id;
    }
    public void setU_pass(String u_pass){
        this.u_pass=u_pass;
    }
    public void setU_name(String u_name){
        this.u_name=u_name;
    }
    public void setU_company(String u_company){
        this.u_company=u_company;
    }
    public void setU_tel(String u_tel){
        this.u_tel=u_tel;
    }
    public void setU_address(String u_address){
        this.u_address=u_address;
    }
    public userentity(){

    }
    public userentity(String u_id,String u_name,String u_pass,String u_company,String u_tel,String u_address){
        this.u_id=u_id;
        this.u_pass=u_pass;
        this.u_name=u_name;
        this.u_company=u_company;
        this.u_tel=u_tel;
        this.u_address=u_address;

    }


}
