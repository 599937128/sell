package com.imooc.service;

import com.imooc.dataobject.SellerInfo;

/**
 * @program: sell
 * @Date: 2018/9/25 23:28
 * @Author: Mr.lv
 * @Description:
 */
public interface SellerService {

    /**
     * 通过openid查询卖家端的信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
