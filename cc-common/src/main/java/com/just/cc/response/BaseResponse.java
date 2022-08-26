package com.just.cc.response;

import com.just.cc.enums.ResponseEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: Cc
 * @Date: 2022/8/22 15:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<E> implements Serializable {
    private static final long serialVersionUID = 1L;

    private String code;

    private String message;

    private E data;

    public static  <E> BaseResponse<E> ok(E data){
        BaseResponse response =  of(ResponseEnum.SUCCESS);
        response.setData(data);
        return response;
    }

    public static  BaseResponse ok(){
        BaseResponse response =  of(ResponseEnum.SUCCESS);
        return response;
    }

    public static  BaseResponse fail(){
        BaseResponse response =  of(ResponseEnum.FAIL);
        return response;
    }

    public static BaseResponse of (ResponseEnum responseEnum){
        BaseResponse response = new BaseResponse();
        response.setCode(responseEnum.getCode());
        response.setMessage(responseEnum.getMessage());
        return response;
    }
}
