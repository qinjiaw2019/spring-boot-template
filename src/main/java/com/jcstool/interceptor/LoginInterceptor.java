package com.jcstool.interceptor;

import com.jcstool.constant.HttpCode;
import com.jcstool.service.UserService;
import com.jcstool.vo.WebUser;
import com.jcstool.web.Operater;
import com.jcstool.web.R;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    UserService userService;

    public LoginInterceptor(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse response, Object o) throws Exception {

        //这个token免登陆
        WebUser user = userService.getCurrentUser();
        if(Operater.isNull(user)){
            R.isFail().code(HttpCode.NOT_LOGIN)
                    .message("not login.").write(response);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

}
