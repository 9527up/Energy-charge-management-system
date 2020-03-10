package com.example.bigproject.controller;

import com.example.bigproject.entity.userentity;
import com.example.bigproject.entity.workerentity;
import com.example.bigproject.entity.zhipaientity;
import com.example.bigproject.mapper.workermapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class workercontroller {
    @Resource
    private workermapper wmapper;
    @RequestMapping("/workerlo")
    public String workerlo(){
        return "workerlogin";
    }
    @RequestMapping("/workerlogin")
    public String workerlogin(workerentity workerentity, HttpServletRequest request, Model model){
        String id=request.getParameter("workerid");
        try{
            List<workerentity> work=wmapper.getworkerbyid(id);
            workerentity use=work.get(work.size()-1);
            String pss=use.getW_pass();
            String w_pass=request.getParameter("w_pass");
            if(pss.equals(w_pass)){
                String w_id=request.getParameter("workerid");
                HttpSession session =  request.getSession(true);
                session.setAttribute("workerid",w_id);
                session.setAttribute("w_pass",workerentity.getW_pass());
                List<workerentity> worker=wmapper.getworkerbyid(w_id);
                model.addAttribute("workerlist",worker);
                return "worker";}
            else{
                return "false";
            }
        }catch(Exception e){
            return "false";
        }

    }
    @RequestMapping("/zhuangtai")
    public  String zhuangtai(workerentity workerentity, HttpServletRequest request, Model model){
        HttpSession session =request.getSession();
        Object obj=session.getAttribute("workerid");
        String w_id=String.valueOf(obj);
        String w_zhuangtai=request.getParameter("w_zhuangtai2");
        List<workerentity> wo=wmapper.getworkerbyid(w_id);
        int size=wo.size();
        workerentity worker=wo.get(size-1);
        String w_pass=worker.getW_pass();
        String w_tel=worker.getW_tel();
        String w_name=worker.getW_name();
        workerentity worker2=new workerentity(w_id,w_pass,w_name,w_tel,w_zhuangtai);
        wmapper.zhuangtaiup(worker2);
        List<workerentity> wo1=wmapper.getworkerbyid(w_id);
        model.addAttribute("workerlist",wo1);
        return "worker";
    }
    @RequestMapping("/workerup")
    public String workerup(workerentity workerentity, HttpServletRequest request, Model model){
        HttpSession session =request.getSession();
        Object obj=session.getAttribute("workerid");
        String w_id=String.valueOf(obj);
        String w_pass=request.getParameter("w_pass1");
        String w_name=request.getParameter("w_name1");
        String w_tel=request.getParameter("w_tel1");
        String w_zhuangtai=request.getParameter("w_zhuangtai1");
        workerentity worker =new workerentity(w_id,w_pass,w_name,w_tel,w_zhuangtai);
        wmapper.workerup(worker);
        List<workerentity> wo1=wmapper.getworkerbyid(w_id);
        model.addAttribute("workerlist",wo1);
        return "worker";
    }
    @RequestMapping("/daiweixiu")
    public  String daiweixiu(workerentity workerentity, HttpServletRequest request, Model model){
        HttpSession session =request.getSession();
        Object obj=session.getAttribute("workerid");
        String w_id=String.valueOf(obj);
        List<zhipaientity> daiwei= wmapper.getdaiwei(w_id);
        model.addAttribute("daiweixiulist",daiwei);
        return "daiweixiu";
    }
    @RequestMapping("/finishweixiu")
    public String finishuweixiu(workerentity workerentity, HttpServletRequest request, Model model){
        HttpSession session =request.getSession();
        Object obj=session.getAttribute("workerid");
        String w_id=String.valueOf(obj);
        String f_id=request.getParameter("f_id");
        wmapper.finish(f_id);
        wmapper.finishweixiudan(f_id);
        List<zhipaientity> daiwei= wmapper.getdaiwei(w_id);
        model.addAttribute("daiweixiulist",daiwei);
        return "daiweixiu";

    }
}
