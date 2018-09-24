package com.imooc.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 商品类目
 * Created by nantian on 2018/9/5.
 * 动态更新时间
 * DynamicUpdate
 * 映射数据库
 * Entity
 * 使用lombok生成get set tostring方法
 * Data
 */
@Entity
@DynamicUpdate
@Data
public class ProductCategory {

    /**类目id 自增*/
    @Id
    @GeneratedValue
    private Integer categoryId;

    /**类目名*/
    private String categoryName;

    /**类目编号*/
    private Integer categoryType;

    /** 创建时间*/
    private Date createTime;

    /** 修改时间*/
    private Date updateTime;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
