package com.just.cc.exception;

import com.just.cc.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: Cc
 * @Date: 2022/8/22 15:00
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler({CcException.class})
    public BaseResponse CcEx(Exception e){
        return BaseResponse.fail();
    }
}
