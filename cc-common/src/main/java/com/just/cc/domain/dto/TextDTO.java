package com.just.cc.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Cc
 * @Date: 2022/8/23 13:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TextDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;

    private String text1;

    private String text2;

    private String text3;
}
