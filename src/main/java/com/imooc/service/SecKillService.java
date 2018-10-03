package com.imooc.service;

/**
 * @program: sell
 * @Date: 2018/10/3 15:28
 * @Author: Mr.lv
 * @Description:
 */
public interface SecKillService {
    String querySecKillProductInfo(String productId);
    void orderProductMockDiffUser(String productId);
}
