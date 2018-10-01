package com.imooc.service;

import com.imooc.dto.OrderDTO;

/**
 * @program: sell
 * @Date: 2018/10/1 10:02
 * @Author: Mr.lv
 * @Description: 消息推送
 */
public interface PushMessageService {

    /**
     * 订单状态消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
