package com.dasoops.dasserver.plugin.shell.log;

import com.dasoops.dasserver.plugin.shell.entity.dto.LogDto;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @title LogQueue
 * @classPath com.dasoops.dasserver.plugin.shell.log.LogQueue
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/25
 * @version 1.0.0
 * @description 日志队列
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
     * @description 消息入队
     * @Return: boolean
     * @author: leijun
     * @date: 2019/11/26
     **/
    public void push(LogDto log) {
        this.blockingQueue.add(log);
    }

    /**
     * @description 消息出队
     * @Return: com.unismc.springbootudcap.powersecurity.entity.LoggerMessage
     * @author: leijun
     * @date: 2019/11/26
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
