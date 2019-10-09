# springboot 常规项目模板
架构:sprigboot2.0.5.Relase+mybatis+通用mapper+druid


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