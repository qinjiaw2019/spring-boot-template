package com.jcstool.mapper;

import com.jcstool.BaseTest;
import com.jcstool.repository.mapper.DynamicSqlMapper;
import com.jcstool.repository.mapper.UserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author : qinjiawang
 * @Date : 2019/10/09
 * @Desoription :
 */
public class UserMapperTest extends BaseTest {

    @Autowired
    UserMapper userMapper;

    @Autowired
    DynamicSqlMapper dynamicSqlMapper;

    @Test
    public void test(){
        System.out.println(userMapper.selectAll());
    }

    @Test
    public void test2(){
        System.out.println(dynamicSqlMapper.findMapBySql("select * from `user`"));
    }
}
