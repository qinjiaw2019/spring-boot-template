package com.jcstool.handler;

import com.jcstool.constant.HttpCode;
import com.jcstool.web.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartException;

/**
 * @Author : qinjiawang
 * @Date : 2019/09/20
 * @Desoription : 全局异常处理
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MultipartException.class)
    @ResponseBody
    public R uploadPic(MultipartException e){
        return R.isFail().code(HttpCode.UPLOAD_SUFFIX_INVALID).message("file is not support.");
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public R nullpointer(MultipartException e){
        log.warn(e.getMessage());
        return R.isFail().message("unkonw error");
    }

}
