package com.jcstool.controller;

import com.jcstool.web.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author : qinjiawang
 * @Date : 2019/10/12
 * @Desoription :
 */
@Slf4j
@Controller
@RequestMapping(value="/error")
public class MyErrorController implements ErrorController {


    @Override
    public String getErrorPath() {
        log.info("/error");
        return R.isFail().message("unknown error.").toJSON();
    }

    @RequestMapping
    @ResponseBody
    public String error() {
        return getErrorPath();
    }
}