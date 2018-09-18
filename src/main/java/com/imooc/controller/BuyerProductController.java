package com.imooc.controller;

import com.imooc.VO.ProductInfoVO;
import com.imooc.VO.ProductVO;
import com.imooc.VO.ResultVO;
import com.imooc.dataobject.ProductCategory;
import com.imooc.dataobject.ProductInfo;
import com.imooc.service.CategoryService;
import com.imooc.service.ProductService;
import com.imooc.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 买家商品
 * Created by nantian on 2018/9/5.
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;
    @GetMapping("/list")
    public ResultVO list(){

        // 1.查询所有的上架的商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        // 2.查询类目(一次性查询)
        /**
         * List<Integer> categoryTypeList = new ArrayList<>();
         * 传统方式
         * for (ProductInfo productInfo:productInfoList){
         * categoryTypeList.add(productInfo.getCategoryType());
         *  }
         */
        //精简做法(java8 lambad) 查询所有商品的类型(便利所有的商品获取到类型)
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        // 根据类目的标号查询到所有的类目表的信息
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        // 3. 数据拼装
        /** 最外层的商品的封装.也就是第二层的视图层也就是类目名,类目的
         *类型根据这个类型查到的所有的商品也就是第三层的东西
         */
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory:productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());
            //这个也就是商品的所有的信息根据类别查出来的所有商品的信息
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo:productInfoList){
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            //使用下边这个方法就可以把相对类型的所有的商品的的信息添加到第二层中
            productVO.setProductInfoVOList(productInfoVOList);
            //完成第二层结果的封装
            productVOList.add(productVO);
        }
        //第一大层返回结果的视图层3个大的方面
        return ResultVOUtil.success(productVOList);
    }
}
