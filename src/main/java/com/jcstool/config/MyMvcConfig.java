package com.jcstool.config;

import java.io.File;
import java.nio.charset.Charset;
import java.util.List;

import com.jcstool.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.*;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/** 
 */
@Slf4j
@Component
@Configuration  
//@EnableWebMvc //这个注解使得默认配置失效  //开启Spring MVC支持，若无此句，重写WebMvcConfigurerAdapter方法无效
public class MyMvcConfig extends WebMvcConfigurationSupport {

    @Value("${jcstool.baseDir}")
    private String BASE_DIR;

    @Value("${jcstool.publicDir}")
    private String PUBLIC_DIR;

    @Autowired
    private SysConfig sysConfig;


    /**
     * c重写addInterceptors方法，注册拦截器 
     * @param registry 
     */  
    @Override  
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor(sysConfig))
                .addPathPatterns("/api/**");
        super.addInterceptors(registry);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    	registry.addRedirectViewController("/", "redirect:/index.html");
	}


    /**
     * 开启了3个静态资源仓库
     * public {dir,classpath} : airtom 的静态资源
     * static: 插件的静态资源
     */
    @Override  
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String web = BASE_DIR + "/web/";
        log.info("外部资源路径：" + PUBLIC_DIR);
        log.info("外部资源路径：" + web);
        registry.addResourceHandler("/**")
                .addResourceLocations("file:" + web, "file:" + PUBLIC_DIR + "/", "classpath:/static/", "classpath:/public/");

    }
}  