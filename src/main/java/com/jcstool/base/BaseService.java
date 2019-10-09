package com.jcstool.base;

import com.jcstool.vo.WebUser;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author : qinjiawang
 * @Date : 2019/10/09
 * @Desoription :
 */
public interface BaseService {

    /**
     * 获取当前登录的用户
     * @return
     */
    WebUser getCurrentUser();

    HttpServletRequest getRequest();

}
