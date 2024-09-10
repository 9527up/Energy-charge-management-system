package com.example.bigproject.controller;

import com.example.bigproject.entity.*;
import com.example.bigproject.mapper.usermapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
//  ggg
public class Usercontroller {
    private userentity userEntity;
    @Resource
    private usermapper usermapper;
    @RequestMapping("/userregister")
    public String userregister(){
        return"userregister";
    }
    @RequestMapping("/usergoresister")
    public String usergoregister(userentity userentity, HttpServletRequest request, Model model){
        String u_id=request.getParameter("u_id");
        String u_name=request.getParameter("u_name");
        String u_company=request.getParameter("u_company");
        String u_tel=request.getParameter("u_tel");
        String u_address=request.getParameter("u_address");
        String u_pass=request.getParameter("u_pass");
        userentity user=new userentity(u_id,u_name,u_pass,u_company,u_tel,u_address);
        usermapper.userregister(user);
        return"userlogin";
    }
    @RequestMapping("/filedweixiudan")
    public String filedweixiudan(weixiudanentity weixiudanentity,HttpServletRequest request, Model model ){
        HttpSession session =request.getSession();
        String u_id=request.getParameter("u_id");
        String f_content=request.getParameter("f_content");
        String u_address=request.getParameter("u_address");
        Date gtime =new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String f_time = format.format(gtime); //2013-01-14
        String f_id=u_id+f_time;
        weixiudanentity weixiudan =new weixiudanentity(f_id,u_id,f_content,u_address,f_time);
        usermapper.filedweixiudan(weixiudan);
        return "fiedweixiudan";
    }

    @RequestMapping("/userlogin")
    public String userlogin(){ return "userlogin"; }
    @RequestMapping("/userfix")
    public String userfix(){
        return "fiedweixiudan";
    }
    @RequestMapping("/recordyear")
    public String recordyear(recordbyyearentity recordbyyearentity,HttpServletRequest request, Model model){

        HttpSession session =request.getSession();
        Object obj=session.getAttribute("userid");
        String u_id=String.valueOf(obj);
        List<recordbyyearentity>recordyear=usermapper.recordbyyear(u_id);
        model.addAttribute("recordlist",recordyear);
        return "recordbyyear";

    }

    @RequestMapping( value = "/usergologin")
    public String usergologin(userentity userentity, HttpServletRequest request, Model model){
        String id=request.getParameter("userid");
        try{
            List<userentity> user=usermapper.getUserByname(id);
            userentity use=user.get(user.size()-1);
            String pss=use.getU_pass();
            String u_pass=request.getParameter("userpass");
            if(pss.equals(u_pass)){
                String userid=request.getParameter("userid");
                HttpSession session =  request.getSession(true);
                session.setAttribute("userid",userid);
                session.setAttribute("pass",userentity.getU_pass());
                List<userentity> user1=usermapper.getUserByname(userid);
                model.addAttribute("userlist",user1);
                return "user";
            }
            else
            {
                return "false";
            }
           }catch(Exception e){
            return "false";
           }
    }
    @RequestMapping("/usergocharge")
    public String usergocharge(){
        return "usercharge";
    }
    @RequestMapping("/userwallet")
    public String userwallet(userwalletentity userwallerentity,HttpServletRequest request,Model model){
        HttpSession session =request.getSession();
        Object obj=session.getAttribute("userid");
        String userid=String.valueOf(obj);
        List<userwalletentity>userwallet=usermapper.getwallet(userid);
        model.addAttribute("walletlist",userwallet);
        return "userwallet";
    }
    @RequestMapping("/usercharge")
    public String usercharge(userwalletentity waletentity, HttpServletRequest request, Model model){
        HttpSession session =request.getSession();
        String u_id=request.getParameter("userid");
        List<userwalletentity>userwallet=usermapper.getwallet(u_id);
        int size=userwallet.size();
        userwalletentity last=userwallet.get(size-1);
        String gless=last.getU_less();
        int a=Integer.parseInt(gless);
        String u_unpay=usermapper.getfee(u_id);
        String u_charge=request.getParameter("charge");
        int b=Integer.parseInt(u_charge);
        int c=a+b;
        String u_less=Integer.toString(c);
        Date gtime =new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd-hh:mm");
        String u_time = format.format(gtime); //2013-01-14
        userwalletentity userwalletinsert= new userwalletentity(u_id,u_charge,u_less,u_unpay,u_time);
        usermapper.chargerecord(userwalletinsert);
        List<userwalletentity>userwallet1=usermapper.getwallet(u_id);
        model.addAttribute("walletlist",userwallet1);
        return "userwallet";
    }
    @RequestMapping("/userrecord")
    public String userrecord(recordentity recordentity,HttpServletRequest request, Model model){
        HttpSession session =request.getSession();
        Object userid=session.getAttribute("userid");
        String u_id=String.valueOf(userid);
        List<recordentity>monthrecord=usermapper.getmonthrecord(u_id);
        model.addAttribute("recordlist",monthrecord);
        return "record";
    }
    @RequestMapping("/userupdate")
    public String userupdate(userentity userentity, HttpServletRequest request, Model model){
        HttpSession session =  request.getSession();
        Object userid=session.getAttribute("userid");
        String u_id=String.valueOf(userid);
        String u_name =request.getParameter("u_name");
        String u_company=request.getParameter("u_company");
        String u_tel=request.getParameter("u_tel");
        String u_address=request.getParameter("u_address");
        String u_pass=request.getParameter("u_pass");
        userentity user=new userentity(u_id,u_name,u_pass,u_company,u_tel,u_address);
        usermapper.updateUser(user);
        List<userentity> user1=usermapper.getUserByname(u_id);
        model.addAttribute("userlist",user1);
        return "user";
    }


}

