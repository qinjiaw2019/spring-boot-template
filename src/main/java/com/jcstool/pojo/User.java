package com.jcstool.pojo;

import lombok.Data;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

/**
 * @Author : qinjiawang
 * @Date : 2019/09/19
 * @Desoription : 用户表
 */
@Repository
@Table(name = "user")
@Data
public class User {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    /**
     * 用户名
     */
    @Column(name = "username")
    String name;


    /**
     * 登录密码
     */
    @Column(name = "password")
    String password;

    /**
     * 创建时间
     */
    @Column(name = "created")
    Long created;
}
