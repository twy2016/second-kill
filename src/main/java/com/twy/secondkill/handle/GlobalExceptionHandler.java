package com.twy.secondkill.handle;

import com.twy.secondkill.entity.BaseResponse;
import com.twy.secondkill.entity.StatusCode;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author gongpeng
 * @date 2021/3/29 21:06
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResponse handle() {
        return new BaseResponse(StatusCode.InvalidParam);
    }
}
