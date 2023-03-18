package com.mei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author mql
 * @date 2023年03月11日 13:10
 */
@Controller
@RequestMapping("/c3")
public class ControllerTest3 {
    @RequestMapping("/t1")
    public String test1(Model model){
        model.addAttribute("msg", "多级访问目录");
        return "test";
    }
}
