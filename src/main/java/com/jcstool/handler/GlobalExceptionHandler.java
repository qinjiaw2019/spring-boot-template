package com.jcstool.handler;

import com.jcstool.constant.HttpCode;
import com.jcstool.web.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @Author : qinjiawang
 * @Date : 2019/09/20
 * @Desoription : 全局异常处理
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler {

    /**
     * 在controller里面内容执行之前，校验一些参数不匹配啊，Get post方法不对啊之类的
     */
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_EXTENDED);
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public R jsonHandler(HttpServletRequest request, Exception e) throws Exception {
        log(e, request);
        return R.isFail().code(-1);
    }

    @ExceptionHandler(value = ServletException.class)
    @ResponseBody
    public R servletException(HttpServletRequest request, Exception e) throws Exception {
        log(e, request);
        return R.isFail().code(-1);
    }


    private void log(Exception ex, HttpServletRequest request) {
        logger.error("************************异常开始*******************************");
//        if(getUser() != null)
//            logger.error("当前用户id是" + getUser().getUserId());
        logger.error(ex);
        logger.error("请求地址：" + request.getRequestURL());
        Enumeration enumeration = request.getParameterNames();
        logger.error("请求参数");
        while (enumeration.hasMoreElements()) {
            String name = enumeration.nextElement().toString();
            logger.error(name + "---" + request.getParameter(name));
        }
        StackTraceElement[] error = ex.getStackTrace();
        for (StackTraceElement stackTraceElement : error) {
            logger.error(stackTraceElement.toString());
        }
        logger.error("************************异常结束*******************************");
    }
}
