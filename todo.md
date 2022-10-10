# todo

1. LogInterceptor 待完善 日志持久化(暂定mongo)
2. TokenVerifyInterceptor 待完善 对非cq_http消息进行token校验
3. heartBeatInterceptor 待完善 心跳检测-暂未开启 暂定3分钟一次,带错误输出
4. PassListInterceptor authorMatch 硬编码改为策略模式,暂未启动
5. cq消息接受 按关键词分发处理 分发部分框架完善
6. ExceptionHandlerWrapperImpl 向用户/群组 发送错误id