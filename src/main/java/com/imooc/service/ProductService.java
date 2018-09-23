package com.imooc.service;

import com.imooc.dataobject.ProductInfo;
import com.imooc.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by nantian on 2018/9/5.
 */
public interface ProductService {

    ProductInfo findOne(String productId);
    /** 查询所有的在架商品列表*/
    List<ProductInfo> findUpAll();

    /** pageable 做分页*/
    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    /**加库存*/
    void increaseStock(List<CartDTO> cartDTOList);

    /**减库存*/
    void decreaseStock(List<CartDTO> cartDTOList);

    /** 上架*/
    ProductInfo onSale(String productId);

    /** 下架*/
    ProductInfo offSale(String productId);

}
