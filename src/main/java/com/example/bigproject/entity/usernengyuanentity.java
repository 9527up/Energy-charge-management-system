package com.example.bigproject.entity;
import lombok.Data;
import java.io.Serializable;
@Data
public class usernengyuanentity implements Serializable {

    private String u_id;
    private String n_id;
    private String n_mon;
    private String n_use;
    private String n_price;

    public String getU_id(){
        return u_id;
    }
    public String getN_id(){
        return n_id;

    }
    public String getN_mon(){
        return n_mon;
    }
    public String getN_use(){
        return n_use;
    }
    public String getN_price(){
        return n_price;
    }

    public void setU_id(String u_id){
        this.u_id=u_id;
    }
    public void setN_num(String n_id){
        this.n_id=n_id;
    }
    public void setN_use(String n_use){
        this.n_use=n_use;
    }
    public void setN_price(String n_price){
        this.n_price=n_price;
    }

    public usernengyuanentity(){

    }
    public usernengyuanentity(String u_id,String n_id,String n_mon, String n_use,String n_price){
        this.u_id=u_id;
        this.n_id=n_id;
        this.n_mon=n_mon;
        this.n_use=n_use;
        this.n_price=n_price;
    }


}
