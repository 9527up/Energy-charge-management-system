package com.example.bigproject.entity;

public class indebtentity {
    private float u_id;
    private float u_fee;

    public float getU_id(){
        return u_id;
    }
    public float getU_fee(){
        return u_fee;
    }

    public void setU_id(float u_id){
        this.u_id=u_id;
    }
    public void setU_fee(float u_fee){
        this.u_fee=u_fee;
    }

    public indebtentity(){

    }
    public indebtentity(float u_id,float u_fee){
        this.u_id=u_id;
        this.u_fee=u_fee;
    }

}
