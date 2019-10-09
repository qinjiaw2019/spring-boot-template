package com.jcstool.service;

import com.jcstool.base.BaseService;

/**
 * @Author : qinjiawang
 * @Date : 2019/10/09
 * @Desoription :
 */
public interface UserService extends BaseService {

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return
     */
    boolean login(String username,String password);
}
