package com.mei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author mql
 * @date 2023年03月09日 20:30
 */
@Controller
public class HelloController {
    @RequestMapping("/hello123")
    public String hello(Model model){
        //封装数据
        model.addAttribute("msg", "Hello, SpringMVCAnnotation");
        return "hello";//会被视图解析器处理
    }

   
}
