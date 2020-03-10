package com.example.bigproject.entity;
import lombok.Data;

import java.io.Serializable;

@Data
public class workerentity implements Serializable {

    private String w_id;
    private String w_pass;
    private String w_name;
    private String w_tel;
    private String w_zhuangtai;


    public String getW_id(){
        return w_id;
    }
    public String getW_pass(){
        return w_pass;
    }
    public String getW_name(){
        return w_name;
    }
    public String getW_phone(){
        return w_tel;
    }
    public String getW_zhuangtai(){
        return w_zhuangtai ;
    }
    public void setW_pass(String w_pass){
        this.w_pass=w_pass;
    }
    public void setW_phone(String w_tel){
        this.w_tel=w_tel;
    }


    public void setW_zhuangtai(String w_zhuangtai){
        this.w_zhuangtai=w_zhuangtai;
    }

    public workerentity(){

    }
    public workerentity(String w_id,String w_pass,String w_name,String w_tel,String w_zhuangtai){
        this.w_id=w_id;
        this.w_pass=w_pass;
        this.w_name=w_name;
        this.w_tel=w_tel;
        this.w_zhuangtai=w_zhuangtai;

    }


}
