package com.example.bigproject.controller;

import com.example.bigproject.entity.*;
import com.example.bigproject.mapper.administritormapper;
import com.example.bigproject.mapper.nengyuanmapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.List;

@Controller
public class administratorcontroller {
    @Resource
    administritormapper admapper;

    @RequestMapping("/administritorlogin")
    public String administritorlogin(){
        return "administritorlogin";
    }

    @RequestMapping( value = "/administritorgologin")
    public String usergologin(administritorentity adentity, HttpServletRequest request, Model model){
        String ad_id=request.getParameter("adid");
        String ad_pass=request.getParameter("adpass");
        try{
            List<administritorentity>ad=admapper.getad(ad_id);
            administritorentity adt=ad.get(ad.size()-1);
            String adpass=adt.getA_pass();
            if(adpass.equals(ad_pass)){
                HttpSession session =  request.getSession(true);
                session.setAttribute("administrratorid",adpass);
                session.setAttribute("adpass", adentity.getA_pass());
                List<userentity> users= admapper.getUser();
                model.addAttribute("aduserlist",users);
                return "administrator";}
            else{
                return "false";
            }
        }catch(Exception e){
            return "false";
        }
    }
    @RequestMapping("/weixiudan")
    public String weixiudan(administritorentity adentity, HttpServletRequest request, Model model){
        List<weixiudanentity> weixiudan=admapper.getWxiudan();
        model.addAttribute("fixlist",weixiudan);
        return "weixiudan";
    }
    @RequestMapping("/goliushui")
    public String goliushui(){
        return "liushui";
    }
    @RequestMapping("/liushui")
    public String liushui(recordentity recordentity,HttpServletRequest request,Model model){
        String u_id=request.getParameter("u_id");
        String n_name=request.getParameter("n_name");
        String uthis=request.getParameter("u_this");
        String ulast=request.getParameter("u_last");
        String ufee=request.getParameter("u_fee");
        int a=Integer.parseInt(uthis);
        float u_this=a;
        int b=Integer.parseInt(ulast);
        float u_last=b;
        int c=Integer.parseInt(ufee);
        float u_fee=c;
        List<unpayentity> unpay=admapper.getunpay(u_id);
        unpayentity unpay1=unpay.get(0);
        float unpay2=unpay1.getU_unpay();
        float u_unpay=u_fee+unpay2;
        admapper.unpayupdate(u_unpay,u_id);
        recordentity record=new recordentity(u_id,n_name,u_this,u_last,u_fee);
        admapper.liushui(record);
        return "liushui";

    }
    @RequestMapping("/nengyuan")
    public String nengyuan(nengyuanentity nyentity,HttpServletRequest request, Model model){
        List<nengyuanentity> nengyuan=admapper.getnengyuan();
        model.addAttribute("nengyuanlist",nengyuan);
        return "nengyuan";
    }
    @RequestMapping("/adworker")
    public String adworker(HttpServletRequest request, Model model){
        List<workerentity> worker=admapper.getworker();
        model.addAttribute("adworkerlist",worker);
        return "adworker";

    }
    @RequestMapping("/workeradd")
    public String workeradd(workerentity workerentity,HttpServletRequest request,Model model){
        String w_id=request.getParameter("w_id");
        String w_pass=request.getParameter("w_pass");
        String w_name=request.getParameter("w_name");
        String w_tel=request.getParameter("w_tel");
        String w_zhuangtai=request.getParameter("w_zhuangtai");
        workerentity worker=new workerentity(w_id,w_pass,w_name,w_tel,w_zhuangtai);
        admapper.workeradd(worker);
        List<workerentity> worker1=admapper.getworker();
        model.addAttribute("adworkerlist",worker1);
        return "adworker";

    }
    @RequestMapping("/nengyuanadd")
    public String nenyuanadd(nengyuanentity nyentity,HttpServletRequest request,Model model){
        String n_id=request.getParameter("1n_id1");
        String n_name=request.getParameter("1n_name1");
        String n_price=request.getParameter("1n_price1");
        Calendar cal = Calendar.getInstance();
        int mont_h = cal.get(Calendar.MONTH) + 1;
         String month=Integer.toString(mont_h);
        nengyuanentity nengyuan=new nengyuanentity(n_id,n_name,n_price,month);
        admapper.nengyuanadd(nengyuan);
        List<nengyuanentity> nengyuan1=admapper.getnengyuan();
        model.addAttribute("nengyuanlist",nengyuan1);
        return "nengyuan";
    }
    @RequestMapping("/nengyuandelete")
    public String nengyuandelete(nengyuanentity nyentity,HttpServletRequest request,Model model){
        String n_id=request.getParameter("1n_id2");
        admapper.nengyuandelete(n_id);
        List<nengyuanentity> nengyuan1=admapper.getnengyuan();
        model.addAttribute("nengyuanlist",nengyuan1);
        return "nengyuan";
    }
    @RequestMapping("/price")
    public String price(nengyuanentity nyentity,HttpServletRequest request,Model model){
        String n_id=request.getParameter("1n_id3");
        String n_name=request.getParameter("1n_name3");
        String n_price=request.getParameter("1n_price3");
        Calendar cal = Calendar.getInstance();
        int mont_h = cal.get(Calendar.MONTH) + 1;
        String month=Integer.toString(mont_h);
        nengyuanentity nengyuan=new nengyuanentity(n_id,n_name,n_price,month);
        admapper.nengyuanup(nengyuan);
        List<nengyuanentity> nengyuan1=admapper.getnengyuan();
        model.addAttribute("nengyuanlist",nengyuan1);
        return "nengyuan";
    }
    @RequestMapping("/weixiudanzhipai")
    public String weixiudanzhipai(zhipaientity zhipai,HttpServletRequest request,Model model){
        String f_id=request.getParameter("f_id");
        String w_id=request.getParameter("w_id");
        List<weixiudanentity> weixiuzhipai =admapper.getzhipai(f_id);
        int size=weixiuzhipai.size();
        weixiudanentity weixiudan =weixiuzhipai.get(size-1);
        String f_content=weixiudan.getF_content();
        String f_address=weixiudan.getU_address();
        String f_time=weixiudan.getF_time();
        zhipaientity zhipa=new zhipaientity(f_id,f_content,f_address,f_time,w_id);
        admapper.zhipai(zhipa);
        List<weixiudanentity> weixiudan1=admapper.getWxiudan();
        model.addAttribute("fixlist",weixiudan1);
        return "weixiudan";
    }
    @RequestMapping("/indebt")
    public String indebt(userwalletentity userwallet, HttpServletRequest request,Model model){
        List<indebtentity>indebt=admapper.indebt();
        model.addAttribute("indebtlist",indebt);
        return "indebt";
    }
    @RequestMapping("/deleteuser")
    public String deleteuser(userentity userentity,HttpServletRequest request,Model model){
        String u_id=request.getParameter("userid");
        admapper.deleterecord(u_id);
        admapper.deleterepair(u_id);
        admapper.deleteuserwallet(u_id);
        admapper.delete(u_id);
        List<userentity> users= admapper.getUser();
        model.addAttribute("aduserlist",users);
        return "administrator";
    }

}
