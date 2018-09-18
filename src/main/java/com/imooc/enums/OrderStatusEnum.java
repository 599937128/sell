package com.imooc.enums;

import lombok.Getter;

/**
 * Created by nantian on 2018/9/6.
 * 商品状态
 */
@Getter
public enum OrderStatusEnum {
    NEW(0,"新下单"),
    FINISHED(1,"完结"),
    CANCEL(2,"已取消"),
    ;
    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
