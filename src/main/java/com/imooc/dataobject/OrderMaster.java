package com.imooc.dataobject;

import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by nantian on 2018/9/6.
 * 商品订单的信息
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    /** 订单id*/
    @Id
    private String orderId;

    /** 买家名*/
    private String buyerName;

    /** 买家电话*/
    private String buyerPhone;

    /** 买家地址*/
    private String buyerAddress;

    /** 买家微信 Openid*/
    private String buyerOpenid;

    /** 订单总金额*/
    private BigDecimal orderAmount;

    /** 订单状态 默认为新下单*/
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /** 支付状态,默认为0,未支付*/
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /** 创建时间*/
    private Date createTime;

    /** 更新时间*/
    private Date updateTime;

    /** 在数据库的对应的时候会忽略掉该属性 @Transient*/
}
