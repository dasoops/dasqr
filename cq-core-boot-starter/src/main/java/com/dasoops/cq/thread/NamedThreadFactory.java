package com.dasoops.cq.thread;

import com.dasoops.core.util.Assert;
import com.dasoops.cq.utils.EventUtil;
import com.dasoops.cq.utils.entity.EventInfo;
import lombok.NonNull;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Title: NamedThreadFactory
 * @ClassPath com.dasoops.cq.threadfactory.NamedThreadFactory
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/01
 * @Version 1.0.0
 * @Description: 命名线程工厂
 * @see ThreadFactory
 */
public class NamedThreadFactory implements ThreadFactory {
    private static final AtomicInteger POOL_NUMBER = new AtomicInteger(1);
    private final String namePrefix;
    private final ThreadGroup group;

    public NamedThreadFactory(String name) {
        this.namePrefix = name + "-" + POOL_NUMBER.getAndIncrement() + "-thread-";
        SecurityManager s = System.getSecurityManager();
        group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
    }

    @Override
    public Thread newThread(@NonNull Runnable r) {
        Thread t = new Thread(group, r, namePrefix + Assert.notNullOrElse(EventUtil.get(), EventInfo::getMessageId, res -> "sys"), 0);
        if (t.isDaemon()) {
            t.setDaemon(false);
        }
        if (t.getPriority() != Thread.NORM_PRIORITY) {
            t.setPriority(Thread.NORM_PRIORITY);
        }
        return t;
    }
}