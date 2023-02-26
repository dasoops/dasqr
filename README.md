# dasServer

### 介绍:

越来越杂，好事啊

### development

#### 配置

- core 依赖: go_cqhttp, jdk17
- 部分核心插件(推荐配置): mysql, redis
- WebManager 依赖: nginx(可通过配置忽略)
- plugin-image | plugin-setu 依赖: minio
- plugin-log | plugin-sys-exceptionWrapper 依赖: mongo

#### keyword

- string - str
- WebSocket - ws
- message - msg
- optional - opt
- array - arr
- minimum - min
- maximum - max
- annotation - anno

#### 错误码:

- 65535 - 65535: 未预料的异常
- 00000 - 10000: 通用异常
- 90000 - 99999: 通用包工具类异常
- 10000 - 20000: 业务异常

#### todo:

`-: 未开始;√:已完成;o:进行中`

1. ( √ ) 定时任务(plugin-sys-schedule)
2. ( √ ) sc2下周突变(每周提醒入土了)
3. ( √ ) webManager路由动态渲染
4. ( √ ) plugin-setu实现
5. ( √ ) plugin-sys-shell(暂未定实现方式,通过伪造CqTemplate?)
6. ( o ) webManager register | reply | shell
7. ( - ) webManager register password
8. ( - ) webManager token续签
9. ( - ) plugin-style
10. ( - ) help文档
11. ( √ ) 看看丢人实现(撤回记录)
12. ( - ) rss对接?(rssHub,plugin-rss)
13. ( o ) json包改为jackSon
14. ( - ) pluginLoader
15. ( - ) pluginStore
16. ( √ ) 后端扫包生成ts,request文件
17. ( - ) 枚举扫描生成字典,缓存,前端使用字典替代硬编码
18. ( - ) 群用户复读指数计算生成
19. ( - ) alas错误截图发送,前置为alas迁移,域名解析迁移
20. ( - ) 图片服务转至云平台,minio数据迁移
