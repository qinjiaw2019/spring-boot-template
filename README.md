
spring-boot-template
-------

## 背景介绍
由于公司很主要基于springboot+多数据源的场景,所以做了一个模板,集成了仓用的web功能.加快开发速度而形成的一个常用的模板.

## Features
* 基于Springboot
* 基于Mybatis和通用Mapper
* 基于Druid数据源连接池
* 集成RestFull接口的常用工具(参数处理,ResponseBean)
* 支持多数据源

## 配置
```text
jcstool:        
  # 数据目录 baseDir/web 为html页面
  baseDir: D:\main\qinjiawang\project\wyc-nltp\wyc-nltp-fe
  # 静态资源路径
  publicDir: D:\main\qinjiawang\project\wyc-nltp\wyc-nltp-fe\public
```


源码结构
```text
|--base 基础包
|--config 配置包
|--constant 常量包
|--enums 枚举常量
|--controller controller
|--handler 处理器
    |--GlobalExceptionHandler 全局异常处理
|--interceptor 拦截器
    |--ControllerAopInterceptor 接口日志拦截
    |--LoginInterceptor 登录拦截
|--pojo pojo
|--repository
    |--mapper   mybatis mapper包
|--service 服务层
|--util 工具包
|--vo
```
