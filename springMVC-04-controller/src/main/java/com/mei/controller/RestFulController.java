package com.mei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author mql
 * @date 2023年03月18日 9:17
 */
@Controller
public class RestFulController {
    /**
     * @author mql
     * @date 2023/3/18 9:38 
     * 原来的：http://localhost:8080/springMVC_04_controller_war_exploded/add?a=2&b=4 
     * 现在的：http://localhost:8080/springMVC_04_controller_war_exploded/add/a/b
     */
//  @RequestMapping(value = "/add/{a}/{b}", method = RequestMethod.GET)
    //等价于上面这种请求方式
    @GetMapping("/add/{a}/{b}")
    public String test1(@PathVariable int a, @PathVariable int b, Model model) {
        int res = a + b;
        model.addAttribute("msg", "GET请求下的：a + b = " + res);
        return "test";
    }

    @PostMapping("/add/{a}/{b}")
    public String test2(@PathVariable int a, @PathVariable int b, Model model) {
        int res = a + b;
        model.addAttribute("msg", "POST请求下的：a + b = " + res);
        return "test";
    }

}
