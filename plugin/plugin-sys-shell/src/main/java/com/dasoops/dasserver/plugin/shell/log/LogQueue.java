package com.dasoops.dasserver.plugin.shell.log;

import com.dasoops.dasserver.plugin.shell.entity.vo.LogDto;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Title: LogQueue
 * @ClassPath com.dasoops.dasserver.plugin.shell.log.LogQueue
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/25
 * @Version 1.0.0
 * @Description: 日志队列
 * @see LinkedList
 */
public class LogQueue {
    /**
     * 队列大小
     */
    public static final int QUEUE_MAX_SIZE = 500;
    private static final LogQueue INSTANCE = new LogQueue();
    /**
     * 阻塞队列
     */
    private final BlockingQueue<LogDto> blockingQueue = new LinkedBlockingQueue<>(QUEUE_MAX_SIZE);

    private LogQueue() {
    }

    public static LogQueue getInstance() {
        return INSTANCE;
    }

    public void clear() {
        this.blockingQueue.clear();
    }

    /**
     * @Description: 消息入队
     * @Return: boolean
     * @Author: leijun
     * @Date: 2019/11/26
     **/
    public void push(LogDto log) {
        this.blockingQueue.add(log);
    }

    /**
     * @Description: 消息出队
     * @Return: com.unismc.springbootudcap.powersecurity.entity.LoggerMessage
     * @Author: leijun
     * @Date: 2019/11/26
     **/
    public LogDto poll() {
        LogDto result = null;
        try {
            result = this.blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }
}
