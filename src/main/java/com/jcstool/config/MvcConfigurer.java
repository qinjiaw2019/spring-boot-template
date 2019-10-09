package com.jcstool.config;

import com.jcstool.interceptor.LoginInterceptor;
import com.jcstool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


/**
 * @Author : qinjiawang
 * @Date : 2019/09/19
 * @Desoription :
 */
@Configuration
public class MvcConfigurer extends WebMvcConfigurationSupport {

    @Autowired
    UserService userService;


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {//和页面有关的静态目录都放在项目的static目录下

        File path = null;
        try {
            path = new File(ResourceUtils.getURL("classpath:").getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String gitPath=path.getParentFile().getParentFile().getParent()+File.separator+"logistics"+File.separator+"uploads"+File.separator;
        registry.addResourceHandler("/uploads/**").addResourceLocations(gitPath);
        registry.addResourceHandler("/api/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/static/");
        super.addResourceHandlers(registry);
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor(userService))
                .excludePathPatterns("/api/v1/user/currentUser")
                .excludePathPatterns("/api/v1/user/login")
                .excludePathPatterns("/api/v1/user/reg")
                .excludePathPatterns("/api/v1/user/logout")
                .excludePathPatterns("/api/v1/user/upload/pic")
                .excludePathPatterns("/api/v1/user/uploads/**")
                .excludePathPatterns("/","/css/**","/js/**","/img/**","/**/*.json","/static/**/*");
    }
}

