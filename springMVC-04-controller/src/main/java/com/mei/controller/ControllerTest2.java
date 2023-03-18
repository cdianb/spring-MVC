package com.mei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author mql
 * @date 2023年03月11日 12:59
 */
@Controller  //代表这个类会被spring接管，加上这个注解的类的所有方法，如果返回值是string，并且有具体的页面可以跳转，就可以被视图解析器解析
public class ControllerTest2 {
    @RequestMapping("/t2")
    public String test1(Model model){
       model.addAttribute("msg", "ControllerTest2");
       return "test";   //   WEB-INF/jsp/test.jsp
    }
    
    @RequestMapping("/t3")
    public String test3(Model model){
        model.addAttribute("msg", "只是跳转的页面不一样");
        return "test";   //   WEB-INF/jsp/test.jsp
    }
}
