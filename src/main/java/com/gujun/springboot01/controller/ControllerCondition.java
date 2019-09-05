package com.gujun.springboot01.controller;

import com.alibaba.fastjson.JSONObject;
import com.gujun.springboot01.beans.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("condition")
public class ControllerCondition {

    @Autowired(required = false)
    private Car car;

    @RequestMapping("/test01")
    public JSONObject test01(){
        JSONObject jsonObject=new JSONObject();
        System.out.println(car);
        jsonObject.put("car",car);
        return jsonObject;
    }

}
