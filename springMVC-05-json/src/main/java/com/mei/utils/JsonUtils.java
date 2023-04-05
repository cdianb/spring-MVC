package com.mei.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author mql
 * @date 2023年03月22日 20:55
 */
public class JsonUtils {
    public static String getJson(Object object) throws JsonProcessingException {
        return getJson(object, "yyyy-MM-dd HH:mm:ss");
    }
    
    public static String getJson(Object object, String dateFormat) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        //不使用时间戳方式
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //自定义日期格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        objectMapper.setDateFormat(simpleDateFormat);
        return objectMapper.writeValueAsString(object);
    }
}
