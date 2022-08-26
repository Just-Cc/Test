package com.just.cc.dao.mapper;

import com.just.cc.domain.bean.Text;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: Cc
 * @Date: 2022/8/23 14:02
 */
public interface TextMapper {
    int textBatchInsert(@Param("texts")List<Text> texts);

    int textInsert(@Param("text") Text text);
}
