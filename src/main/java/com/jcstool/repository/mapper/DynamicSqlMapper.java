package com.jcstool.repository.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author : qinjiawang
 * @Date : 2019/09/26
 * @Desoription : 动态执行sql语句
 */
public interface DynamicSqlMapper {

    /**
     * 执行select sql
     * @param sql
     * @return
     */
    List<Map<String,Object>> findMapBySql(@Param("sql") String sql);
}
