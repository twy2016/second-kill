package com.twy.secondkill.entity;

import lombok.Data;

/**
 * @author gongpeng
 * @date 2021/3/29 21:00
 */
@Data
public class BaseResponse<T> {
    private Integer code;
    private String msg;
    private T data;

    public BaseResponse(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public BaseResponse(StatusCode code) {
        this.code = code.getCode();
        this.msg = code.getMsg();
    }

    public BaseResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
