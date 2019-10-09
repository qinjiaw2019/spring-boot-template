package com.jcstool.base;

import com.jcstool.service.UserService;
import com.jcstool.vo.WebUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Author  qinjiawang
 * @Date  2019/09/19
 * @Desoription
 */
@Slf4j
@Controller
public class BaseController {

    @Autowired
    UserService userService;

    public WebUser getUser(){
        return userService.getCurrentUser();
    }

    public boolean isLogin(){
        return getUser()!=null;
    }
}
