package com.imooc.utils;

/**
 * @program: sell
 * @Date: 2018/9/20 22:54
 * @Author: Mr.lv
 * @Description:比较两个金额是否一致
 */
public class MathUtil {
    private static final Double Money_Range = 0.01;
    public static Boolean equals(Double d1, Double d2) {

        Double result = Math.abs(d1 - d2);
        if (result < Money_Range) {
            return true;
        }else {
            return false;
        }
    }
}
