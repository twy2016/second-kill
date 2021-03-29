package com.twy.secondkill.entity;

/**
 * @author gongpeng
 * @date 2021/3/29 21:01
 */
public enum StatusCode {
    //表示成功
    Success(0, "成功"),
    //表示失败
    Fail(-1, "失败"),
    //表示参数非法
    InvalidParam(201, "非法的参数"),
    //表示用户未登录
    UserNotLog(202, "用户未登录");
    private Integer code;
    private String msg;

    StatusCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

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
