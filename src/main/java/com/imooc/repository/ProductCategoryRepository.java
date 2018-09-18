package com.imooc.repository;

import com.imooc.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by nantian on 2018/9/5.
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer>{

    //根据商品的类别的标号去查
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
