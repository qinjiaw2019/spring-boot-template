package com.jcstool.service.impl;

import com.jcstool.base.impl.BaseServiceImpl;
import com.jcstool.service.UserService;
import com.jcstool.util.MD5Util;
import com.jcstool.web.Operater;
import org.springframework.stereotype.Service;

/**
 * @Author : qinjiawang
 * @Date : 2019/10/09
 * @Desoription :
 */
@Service
public class UserServiceImpl extends BaseServiceImpl
        implements UserService {
    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @Override
    public boolean login(String username, String password) {
        /*
        User user = userMapper.queryByName(username);
        String enPassword = MD5Util.encode(password);
        if(Operater.isNull(user)){
            return false;
        }
        if(Operater.equals(user.getPassword(),enPassword)){
            return true;
        }*/

        return true;
    }
}
