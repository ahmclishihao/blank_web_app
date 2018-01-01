# 项目说明
该项目是一个spring boot jpa的web应用程序模板，可用于应对一般简单项目的快速开发的需求(crm,cms)，利于开箱即用快速开发。
推荐使用 IDEA 与其热更新插件 JRebel 一同开发。

>项目入口：http://127.0.0.1:8080/demo/index

# 已有主要框架
 1.时间：2018年01月01日
- spring mvc
- spring data jpa 持久层
- druid 数据源
- freemarker 模板
- layui 前端页面模板
- BaseService BaseRepository 基础类实现
- ValidateUtil验证工具（链式验证）
- 全局json 转换 `com.lshao.demo.web.StringJacksonMapper`
- 全局异常处理 `com.lshao.demo.exception.GlobalExceptionHandler`

# 未来继续添加的功能
- spring security
- 日志
- layui 模板组合
- 常用正则验证工具
- 断言式 ValidateUtil验证工具
......
