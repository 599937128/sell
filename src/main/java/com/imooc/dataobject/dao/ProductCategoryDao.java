package com.imooc.dataobject.dao;

import com.imooc.dataobject.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @program: sell
 * @Date: 2018/10/2 20:59
 * @Author: Mr.lv
 * @Description: 测试mybatis的dao
 */
public class ProductCategoryDao {

    @Autowired
    private ProductCategoryMapper mapper;

    public int insertByMapper(Map<String, Object> map) {
        return mapper.insertByMap(map);
    }
}
