package com.jcstool.base.impl;

import com.jcstool.base.BaseService;
import com.jcstool.constant.UserConst;
import com.jcstool.vo.WebUser;
import com.jcstool.web.Operater;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author : qinjiawang
 * @Date : 2019/10/09
 * @Desoription :
 */
@Service
public class BaseServiceImpl implements BaseService {
    @Override
    public WebUser getCurrentUser() {
        HttpServletRequest request = getRequest();

        //这个token免登陆
        String token = request.getHeader(UserConst.TOKEN);
        if(token!=null && Operater.equals(token, UserConst.UNLOGIN_TOKEN)){
            String user = request.getHeader(UserConst.LOGIN_TOKEN);
            if(Operater.isEmpty(user)){
                return null;
            }

            if(Operater.isNull(user)){
                return null;
            }
            WebUser webUser = new WebUser();
            // TODO 根据需要这里可以指定一个默认用户
            request.setAttribute(UserConst.LOGIN_TOKEN,webUser);
            return  webUser;
        }

        /**
         * 从session中获取登录用户信息
         */
        Object user = request.getSession().getAttribute(UserConst.LOGIN_TOKEN);
        if (Operater.isEmpty(user)){
            return null;
        }
        return (WebUser) user;
    }

    @Override
    public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }
}
