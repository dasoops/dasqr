package com.dasoops.dasserver.cq.conf;

import lombok.NonNull;

import java.util.concurrent.ThreadFactory;

/**
 * @title NamedThreadFactory
 * @classPath com.dasoops.dasserver.cq.threadfactory.NamedThreadFactory
 * @author DasoopsNicole@Gmail.com
 * @date 2022/11/01
 * @version 1.0.0
 * @description 命名线程工厂
 * @see ThreadFactory
 */
public class NamedThreadFactory implements ThreadFactory {
    private static Integer poolNumber = 0;
    private final String namePrefix;
    private final ThreadGroup group;

    @SuppressWarnings("all")
    public NamedThreadFactory(String name) {
        this.namePrefix = name + "-";
        SecurityManager s = System.getSecurityManager();
        group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
    }

    @Override
    public Thread newThread(@NonNull Runnable r) {
        Thread t = new Thread(group, r, namePrefix + NamedThreadFactory.poolNumber++, 0);
        if (t.isDaemon()) {
            t.setDaemon(false);
        }
        if (t.getPriority() != Thread.NORM_PRIORITY) {
            t.setPriority(Thread.NORM_PRIORITY);
        }
        return t;
    }
}