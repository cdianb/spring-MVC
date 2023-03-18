package com.mei.controller;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author mql
 * @date 2023年03月11日 12:47
 * z只要实现了Controller接口的类，说明这就是一个控制器了
 */
public class ControllerTest1 implements Controller {
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv = new ModelAndView();
        
        mv.addObject("msg", "ControllerTest1");
        mv.setViewName("test");
        
        return mv;
    }
}
