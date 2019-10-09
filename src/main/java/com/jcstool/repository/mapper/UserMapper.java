package com.jcstool.repository.mapper;


import com.jcstool.base.BaseMapper;
import com.jcstool.pojo.User;

import java.util.List;

/**
 * @Author : qinjiawang
 * @Date : 2019/09/19
 * @Desoription :
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 查询所有
     * @return
     */
    List<User> queryAll();
}
