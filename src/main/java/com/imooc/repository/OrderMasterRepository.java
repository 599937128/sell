package com.imooc.repository;

import com.imooc.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by nantian on 2018/9/6.
 * 订单商品
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String>{

    /** 按照买家的微信号来查*/
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid,Pageable pageable);
}
