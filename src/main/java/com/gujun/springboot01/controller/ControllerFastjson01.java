package com.gujun.springboot01.controller;

import com.alibaba.fastjson.JSONObject;
import com.gujun.springboot01.entity.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("fastjson")
public class ControllerFastjson01 {

    @RequestMapping("/test01")
    public JSONObject test01(){
        JSONObject jsonObject=new JSONObject();
        Person person=new Person(1,"li",22);
        jsonObject.put("人",person);
        return jsonObject;
    }

    @RequestMapping("/test02")
    public JSONObject test02(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("name","gujun");
        jsonObject.put("city","");
        jsonObject.put("com",null); //配置好了fastjson的话，该字段不会返回；
        return jsonObject;
    }

}
