package com.mei.controller;

import com.mei.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author mql
 * @date 2023年03月18日 11:10
 */
@RequestMapping("/user")
@Controller
public class UserController {
    /**
     *
     * @author mql
     * @date 2023/3/18 11:17
     * @param name 
     * 当前端参数和后端接收参数名称一致的时候，可以直接接收
     * http://localhost:8080/springMVC_04_controller_war_exploded/user/param/same/name?name = ***
     * @return java.lang.String
     */
    @GetMapping("/param/same/name")
    public String test1(String name, Model model){
        //1. 接收前段参数
        System.out.println("接收到前端参数" + name);
        //2. 将返回的结果传递给前端
        model.addAttribute("msg", name);
        //3.跳转视图
        return "test";

    }

    /**
     *
     * @author mql
     * @date 2023/3/18 11:33
     * @param name
     * @param model 
     * 当接收参数名和前端传参名称不一样时，需要使用@RequestParam注解声明必要参数
     * http://localhost:8080/springMVC_04_controller_war_exploded/user/param/different/name?userName = ***
     * @return java.lang.String
     */
    @GetMapping("/param/different/name")
    public String test2(@RequestParam("userName") String name, Model model){
        //1. 接收前段参数
        System.out.println("接收到前端参数" + name);
        //2. 将返回的结果传递给前端
        model.addAttribute("msg", name);
        //3.跳转视图
        return "test";
    }
    
    /**
     *
     * @author mql
     * @date 2023/3/18 11:38
     * @param user 
     * 前端传递的是一个对象 id name age,接收解析流程如下：
     * 1. 接收前端用户传递的参数，判断参数的名字，假设名字直接在方法上，可以直接使用
     * 2. 假设传递的是一个对象，就会去匹配对象中的字段名，如果名称一致则匹配成功，反之则失败
     * @return java.lang.String
     */
    @GetMapping("/param/object")
    public String test3(User user){
        System.out.println(user.toString());
        return "test";
    }

    @GetMapping("/model/map")
    public String test4(User user, ModelMap modelMap){
        System.out.println(user.toString());
        modelMap.addAttribute("msg", "用户信息为：" + user.getId() + "-" + user.getName()  + "-" + user.getAge());
        return "test";
    }
}
