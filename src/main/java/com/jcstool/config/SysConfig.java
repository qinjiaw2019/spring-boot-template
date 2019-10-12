package com.jcstool.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Author : qinjiawang
 * @Date : 2019/10/12
 * @Desoription :
 */
@Configuration
@Data
public class SysConfig {

    /**
     * 要忽略的的api,多个用逗号分隔
     */
    @Value("${jcstool.api.ignore}")
    private String ignore;
}
