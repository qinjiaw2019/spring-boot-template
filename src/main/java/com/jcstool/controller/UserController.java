package com.jcstool.controller;

import com.jcstool.base.BaseController;
import com.jcstool.constant.HttpCode;
import com.jcstool.constant.UserConst;
import com.jcstool.service.UserService;
import com.jcstool.vo.WebUser;
import com.jcstool.web.Operater;
import com.jcstool.web.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author : qinjiawang
 * @Date : 2019/10/09
 * @Desoription :
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/user")
public class UserController extends BaseController {

    @Autowired
    UserService userService;

    /**
     * 获取当前登录用户信息
     * @return
     */
    @GetMapping("/currentUser")
    public R getCurrentUser(){
        WebUser user = getUser();
        return user == null ?
                R.isFail().code(HttpCode.NOT_LOGIN).message("not login.") :
                R.isOK().build(user);
    }

    /**
     * 用户登录
     * @param request
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @PostMapping("/login")
    public R login(HttpServletRequest request, String username, String password){
        if(Operater.hasEmpty(username,password)){
            return R.isFail().message("username and password are required.");
        }


//        User user = userService.findByName(username);
        if(!userService.login(username,password)){
            return R.isFail().message("login failed.");
        }

        WebUser webUser = new WebUser();
//        userVo.setId(user.getId());
        webUser.setId(1L);
        webUser.setUsername(username);
        request.getSession().setAttribute(UserConst.LOGIN_TOKEN,webUser);
        request.getSession().setMaxInactiveInterval(3600 * 10);
        return R.isOK();
    }

    /**
     * 用户登出
     * @param request
     * @return
     */
    @PostMapping("/logout")
    public R logout(HttpServletRequest request){
        request.getSession().removeAttribute(UserConst.LOGIN_TOKEN);
        return R.isOK();
    }

    /**
     * 用户注册
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @PostMapping("/reg")
    public R register(String username,String password){
        /*
        if(Operater.hasEmpty(username,password)){
            return R.isFail().message("username and password are required.");
        }
        if(userService.exsist(username)){
            return R.isFail().message("username is already exsist.");
        }
        User user = new User();
        user.setName(username);
        user.setPassword(MD5Util.encode(password));
        return userService.add(user) ?
                R.isOK() : R.isFail().message("register failed.");

         */
        return R.isFail();
    }
}
