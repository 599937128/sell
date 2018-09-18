package com.imooc.dto;

import lombok.Data;

/**
 * @program: sell
 * @Date: 2018/9/8 14:50
 * @Author: Mr.Deng
 * @Description:
 */
@Data
public class CartDTO {

    /** 商品id */
    private String productId;

    /** 商品数量*/
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
