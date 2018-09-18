package com.imooc.controller;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: sell
 * @Date: 2018/9/11 23:18
 * @Author: Mr.Deng
 * @Description:
 */
@RestController
@RequestMapping("/wechart")
@Slf4j
public class WeChartController {

    @Autowired
    private WxMpService wxMpService;

    @GetMapping("/authorize")
    public void authorize(@RequestParam("returnUrl") String returnUrl) {
         // 配置
        // 调用方法
        wxMpService.oauth2buildAuthorizationUrl(WxConsts)

    }

    @GetMapping("/userInfo")
    public void userInfo() {

    }
}
