package com.gujun.springboot01.controller;

import com.alibaba.fastjson.JSONObject;
import com.gujun.springboot01.beans.Game;
import com.gujun.springboot01.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("readProp")
public class ControllerTestReadProp {

    @Autowired
    private User user;

    @Autowired
    private Game game;

    @RequestMapping("/test01")
    public JSONObject test01(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("user",user);
        return jsonObject;
    }

    @RequestMapping("/test02")
    public JSONObject test02(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("game",game);
        return jsonObject;
    }

}
