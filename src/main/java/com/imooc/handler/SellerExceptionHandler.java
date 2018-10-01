package com.imooc.handler;

import com.imooc.config.ProjectUrlConfig;
import com.imooc.exception.SellerAuthorizeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: sell
 * @Date: 2018/9/30 9:48
 * @Author: Mr.lv
 * @Description: 异常拦截器
 */
@ControllerAdvice
public class SellerExceptionHandler {

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    // 拦截登录异常
    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException() {
        return new ModelAndView("redirect:"
                // 授权的地址
            .concat(projectUrlConfig.getWechatOpenAuthorize())
            .concat("/sell/wechat/qrAuthorize")
            .concat("?returnUrl=")
            .concat(projectUrlConfig.getSell())
            .concat("/sell/seller/login"));
    }
}
