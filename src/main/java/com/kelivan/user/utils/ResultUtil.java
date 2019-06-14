package com.kelivan.user.utils;

import org.springframework.stereotype.Component;

public class ResultUtil {

    public static Msg success(Object object){
        Msg msg=new Msg();
        msg.setCode(200);
        msg.setMsg("请求成功");
        msg.setResult(object);
        return msg;
    }

    public static Msg success(){
        return success(null);
    }

    public static Msg error(Integer code,String resultMsg){
        Msg msg=new Msg();
        msg.setCode(code);
        msg.setMsg(resultMsg);
        return msg;
    }


}
