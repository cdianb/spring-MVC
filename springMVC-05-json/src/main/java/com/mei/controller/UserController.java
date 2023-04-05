package com.mei.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mei.pojo.User;
import com.mei.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author mql
 * @date 2023年03月22日 20:17
 */
@RestController
//@Controller
public class UserController {

    @RequestMapping(value = "/json1")
//    @ResponseBody   //他就不会走视图解析器，直接返回一个字符串
    public String json1() throws JsonProcessingException {
        //创建一个jackson的对象映射器，用来解析数据
        ObjectMapper mapper = new ObjectMapper();
        //创建一个对象
        User user = new User(1234, "张三", 25);
        //将我们的对象解析成为json格式
        String str = mapper.writeValueAsString(user);
        //由于@ResponseBody注解，这里会将str转成json格式返回；十分方便
        return str; 
    }

    @RequestMapping(value = "/json2")
    public String json2() throws JsonProcessingException {
        //创建一个jackson的对象映射器，用来解析数据
        ObjectMapper mapper = new ObjectMapper();
        List<User> userList = new ArrayList<User>();
        //创建一个对象
        User user = new User(1234, "张三", 25);
        User user1 = new User(4321, "李四", 35);
        User user2 = new User(2134, "王五", 45);
        User user3 = new User(2341, "赵六", 55);
        //将我们的对象解析成为json格式
        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        String str = mapper.writeValueAsString(userList);
        //由于@ResponseBody注解，这里会将str转成json格式返回；十分方便
        return str;
    }

    @RequestMapping(value = "/json3")
    public String json3() throws JsonProcessingException {
        //创建一个jackson的对象映射器，用来解析数据
        ObjectMapper mapper = new ObjectMapper();
        Date date = new Date();
        //不使用时间戳方式
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //自定义日期格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        mapper.setDateFormat(simpleDateFormat);

//        String str = mapper.writeValueAsString(simpleDateFormat.format(date));
        String str = mapper.writeValueAsString(date);

        //由于@ResponseBody注解，这里会将str转成json格式返回；十分方便
        return str;
    }

    @RequestMapping(value = "/json4")
    public String json4() throws JsonProcessingException {
        Date date = new Date();
        List<User> userList = new ArrayList<User>();
        User user = new User(1234, "张三", 25);
        User user1 = new User(4321, "李四", 35);
        User user2 = new User(2134, "王五", 45);
        User user3 = new User(2341, "赵六", 55);
        //将我们的对象解析成为json格式
        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        JSON.toJSONString(userList);
        return JSON.toJSONString(userList);
    }

}
