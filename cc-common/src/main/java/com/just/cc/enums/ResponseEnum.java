package com.just.cc.enums;

/**
 * @Author: Cc
 * @Date: 2022/8/22 15:20
 */
public enum ResponseEnum {
    /**
     * ResponseEnum
     */
    SUCCESS("000000", "成功"),
    TEST("000001", "TEST"),
    FAIL("999999", "未知错误");

    private String code;

    private String message;

    ResponseEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
