package com.kelivan.user.utils;

public class Msg<T> {
    /*错误码*/
    private Integer code;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    /*提示信息 */
    private String msg;

    /*具体内容*/
    private  T result;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }




}
