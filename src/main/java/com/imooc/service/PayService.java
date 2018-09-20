package com.imooc.service;

import com.imooc.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;

/**
 * @program: sell
 * @Date: 2018/9/18 22:17
 * @Author: Mr.lv
 * @Description: 微信支付
 */
public interface PayService {

    PayResponse create(OrderDTO orderDTO);
}
