package com.imooc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: sell
 * @Date: 2018/9/17 23:30
 * @Author: Mr.lv
 * @Description:
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechart")
public class WechartAccountConfig {

    private String mpAppId;

    private String mpAppSecret;
}
