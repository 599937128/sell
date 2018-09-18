package com.imooc.utils;

import java.util.Random;

/**
 * @program: sell
 * @Date: 2018/9/8 11:54
 * @Author: Mr.Deng
 * @Description:
 */
public class KeyUtil {

    /**
    * @Description: 生成唯一的主键 时间+随机数
     * 处理多线程的问题synchronized
    * @Author: Mr.lv
    * @Date: 2018/9/8 11:55
    */
    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
