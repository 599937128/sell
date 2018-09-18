package com.imooc.service;

import com.imooc.dto.OrderDTO;

/**
 * @program: sell
 * @Date: 2018/9/18 22:17
 * @Author: Mr.lv
 * @Description: 微信支付
 */
public interface PayService {

    void create(OrderDTO orderDTO);
}
