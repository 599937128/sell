package com.imooc.utils;

import com.imooc.enums.CodeEnum;

/**
 * @program: sell
 * @Date: 2018/9/22 11:46
 * @Author: Mr.lv
 * @Description: 枚举工具类
 */
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {

        for (T each: enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
