package com.just.cc.controller;

import com.just.cc.response.BaseResponse;
import com.just.cc.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.just.cc.constants.Constants.*;

/**
 * @Author: Cc
 * @Date: 2022/8/23 13:26
 */
@RestController
@RequestMapping(TEXT_BASEURL)
public class TextController {

    @Autowired
    private TextService textService;

    @GetMapping(TEST)
    public BaseResponse test(){

        return textService.test();
    }
}
