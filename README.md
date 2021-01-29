# project-demo
杂七杂八的学习记录

# 测试记录
## 测试验证Controller层与前端交互的相关问题
    com.biki.project.controller.test.TestDbController

## 测试验证service接口多实现等问题
    com.biki.project.controller.test.TestController

## 测试验证了拦截器
    com.biki.project.common.interceptor
    
## 测试验证了注解
    com.biki.project.common.annotation
    
## 声明会话管理器 -- 管理事务
    com.biki.project.common.config.DuridDataSourceConfig
    
## 定义统一异常及异常枚举
    com.biki.project.common.exception.UnifiedException
    com.biki.project.common.constant.ErrorMessageEnum
    
## 归纳留存了实用但是网上难解决的工具类
    com.biki.project.common.utils
    
## 产生随机数的工具类，能够解决多个线程发生的竞争争夺
    com.biki.project.common.utils.RandomNumberUtils
    
## DTO、VO等对属性的校验的工具类
    com.biki.project.common.utils.ValidatorUtils
    该方法可在不止controller里对DTO里的属性进行自动校验
    若DTO、VO等加了validation的注解，如@NotBlank、@NotNull等，就可以调用该方法，对DTO里面的属性就行校验
    
## HttpClient
    com.biki.project.common.utils.HttpClientUtil
    包括get、post、put、delete等请求类型
    
   