package com.example.bigproject.entity;
import lombok.Data;
import java.io.Serializable;

@Data
public class administritorentity implements Serializable {

    private String a_id;

    private String a_name;
    private String a_pass;
    private String a_phone;


    public String getA_pass(){
        return a_pass;
    }
    public String getA_id(){
        return a_id;

    }
    public String getA_name(){
        return a_name;
    }

    public String getA_phone(){
        return a_phone;
    }

    public void setA_id(String u_id){
        this.a_id=a_id;
    }
    public void setA_pass(String a_pass){
        this.a_pass=a_pass;
    }
    public void setA_name(String u_name){
        this.a_name=a_name;
    }

    public void setA_tel(String u_tel){
        this.a_phone=a_phone;
    }

    public administritorentity(){

    }
    public administritorentity(String a_id,String a_name,String a_pass,String a_phone){
        this.a_id=a_id;
        this.a_name=a_name;
        this.a_pass=a_pass;
        this.a_phone=a_phone;

    }


}
