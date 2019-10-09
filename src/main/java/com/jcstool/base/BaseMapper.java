package com.jcstool.base;


import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
import tk.mybatis.mapper.common.RowBoundsMapper;

/**
 * @Author : qinjiawang
 * @Date : 2019/09/19
 * @Desoription : 公用Mapper接口
 */
public interface BaseMapper<T> extends Mapper<T>,MySqlMapper<T>, ConditionMapper<T>, RowBoundsMapper<T> {
}
