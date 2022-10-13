# todo

1. LogInterceptor 待完善 日志持久化(暂定mongo)
2. TokenVerifyInterceptor 待完善 对非cq_http消息进行token校验
3. heartBeatInterceptor 待完善 心跳检测-暂未开启 暂定3分钟一次,带错误输出
4. PassListInterceptor authorMatch 硬编码改为策略模式,优先度低
5. (ok by @Das) cq消息接受 按关键词分发处理 分发部分框架完善
6. (ok by @Das) ExceptionHandlerWrapperImpl 向用户/群组 发送错误id
7. (ok by @Das) getParameterMap dq码转换
8. go_cqhttp 重启
9. java gc (@Passssing认领)
10. (ok by @Das) dasServer 重启
11. 消息撤回记录 (das认领)
12. (ok by @Das)复读
13. 复读模块功能增强,支持图片复读
14. 取图关键词联想 你要找的是不是
15. 存图兼容手机
16. passList拦截器模块拆分