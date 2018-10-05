package com.imooc.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * http 最外层返回的对象
 * Created by nantian on 2018/9/5.
 */
@Data
public class ResultVO<T> implements Serializable {

    /** 保证序列化时id唯一*/
    private static final long serialVersionUID = 8748915755521391342L;

    /** 错误码*/
    private Integer code;

    /** 提示信息*/
    private String msg;

    /** 具体内容*/
    private T Data;
}
