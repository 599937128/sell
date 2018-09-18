package com.imooc.exception;

import com.imooc.enums.ResultEnum;

/**
 * @program: sell
 * @Date: 2018/9/7 23:35
 * @Author: Mr.lv
 * @Description:
 */
public class SellException extends RuntimeException{

    private Integer code;


    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
