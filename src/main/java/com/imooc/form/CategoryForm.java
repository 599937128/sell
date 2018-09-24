package com.imooc.form;

import lombok.Data;

/**
 * @program: sell
 * @Date: 2018/9/24 18:00
 * @Author: Mr.lv
 * @Description:
 */
@Data
public class CategoryForm {

    private Integer categoryId;

    /**类目名*/
    private String categoryName;

    /**类目编号*/
    private Integer categoryType;
}
