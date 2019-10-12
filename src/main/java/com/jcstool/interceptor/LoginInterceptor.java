package com.jcstool.interceptor;

import com.jcstool.config.SysConfig;
import com.jcstool.constant.HttpCode;
import com.jcstool.service.UserService;
import com.jcstool.util.SessionUtil;
import com.jcstool.vo.WebUser;
import com.jcstool.web.Operater;
import com.jcstool.web.R;
import org.apache.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {


    private SysConfig sysConfig;

    public LoginInterceptor(SysConfig sysConfig) {
        this.sysConfig = sysConfig;
    }

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse response, Object o) throws Exception {


        // 忽略的api
        String requestURI = (httpServletRequest.getRequestURI()+"").trim().toLowerCase();
        String[] ignores = null;
        try{
            ignores = sysConfig.getIgnore().split(",");
        }catch (Exception e){
            ignores = new String[1];
        }
        for (String api : ignores){
            api = (api+"").trim().toLowerCase();
            if(api.equals(requestURI)){
                return true;
            }
        }

        // 要拦截的api
        if(SessionUtil.getInstance().isNotLogin()){
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
