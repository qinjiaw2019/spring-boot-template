package com.jcstool.base;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author : qinjiawang
 * @Date : 2019/10/28
 * @Desoription :
 * 若完全采用前后端分离的模式，即前端所有资源都放在addresourceHandler配置的路径下
 * 即,此时不能通过配置addViewController的方式解决，会抛出异常
 * 只能通过response.redirect(“temples/index.html”)的方式重指向默认主页，
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @Value("${jcstool.indexHtml}")
    String INDEX_HTML;

    @RequestMapping("/")
    public void index(HttpServletResponse response) throws IOException {
        response.sendRedirect(INDEX_HTML);
    }
}