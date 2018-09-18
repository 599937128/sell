package com.imooc.VO;

import lombok.Data;

/**
 * http 最外层返回的对象
 * Created by nantian on 2018/9/5.
 */
@Data
public class ResultVO<T> {

    /** 错误码*/
    private Integer code;

    /** 提示信息*/
    private String msg;

    /** 具体内容*/
    private T Data;
}
