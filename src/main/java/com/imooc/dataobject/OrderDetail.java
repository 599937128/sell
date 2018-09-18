package com.imooc.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by nantian on 2018/9/6.
 * 订单的详情
 */
@Entity
@Data
public class OrderDetail {

    /** 订单详情的id*/
    @Id
    private String detailId;

    /** 订单id*/
    private String orderId;

    /** 商品的id*/
    private String productId;

    /** 商品名称*/
    private String productName;

    /** 商品价格*/
    private BigDecimal productPrice;

    /** 商品的数量*/
    private Integer productQuantity;

    /** 商品的小图*/
    private String productIcon;
}
