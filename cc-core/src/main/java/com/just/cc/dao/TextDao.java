package com.just.cc.dao;

import com.just.cc.dao.mapper.TextMapper;
import com.just.cc.domain.bean.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Cc
 * @Date: 2022/8/23 13:38
 */
@Repository
public class TextDao {

    @Autowired
    private TextMapper textMapper;

    public int textBatchInsert(List<Text> texts){
        return textMapper.textBatchInsert(texts);
    }

    public int textInsert(Text text){
        return textMapper.textInsert(text);
    }
}