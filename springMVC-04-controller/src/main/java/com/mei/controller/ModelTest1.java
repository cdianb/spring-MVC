package com.mei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author mql
 * @date 2023年03月18日 10:40
 */
@Controller
public class ModelTest1 {
    @RequestMapping("/m1/t1")
    public String test(Model model, HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        System.out.println(session.getId());
        model.addAttribute("msg", "ModelTest1测试结果：" + session.getId());
        //forward： 和 redirect: 后面不可加空格 否则会找不到路径
        //转发
//        return "/WEB-INF/jsp/test.jsp";
//        return "forward:/WEB-INF/jsp/test.jsp";
        //重定向  
        return "redirect:/index.jsp";


    }
}
