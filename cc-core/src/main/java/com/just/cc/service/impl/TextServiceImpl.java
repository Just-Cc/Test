package com.just.cc.service.impl;

import com.just.cc.dao.TextDao;
import com.just.cc.domain.bean.Text;
import com.just.cc.response.BaseResponse;
import com.just.cc.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * @Author: Cc
 * @Date: 2022/8/23 13:31
 */
@Service
public class TextServiceImpl implements TextService {

    @Autowired
    private TextDao textDao;

    @Override
    @Transactional
    public BaseResponse test() {
        ArrayList<Text> texts = new ArrayList<>();
        Text t1 = new Text();
        t1.setText1("TEXT1110");
        t1.setText2("TEXT2220");
        t1.setText3("TEXT3330");

        Text t2 = new Text();
        t2.setText1("TEXT11111");
        t2.setText2("TEXT22222");
        t2.setText3("TEXT33333");

        Text t3 = new Text();
        t3.setText1("TEXT11111111");
        t3.setText2("TEXT22222222");
        t3.setText3("TEXT33333333");
        texts.add(t1);
        texts.add(t2);
        texts.add(t3);
        textDao.textBatchInsert(texts);
        //textDao.textInsert(t1);
        return BaseResponse.ok();
    }
}
