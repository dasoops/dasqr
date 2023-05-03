package com.dasoops.dasqr.core;

import java.io.File;
import java.io.IOException;
import java.lang.instrument.Instrumentation;
import java.util.Arrays;
import java.util.jar.JarFile;

/**
 * Agent
 *
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/03
 */
public class Agent {
    public static Instrumentation instrumentation;

    public static void agentmain(String args, Instrumentation instrumentation) {
        Agent.instrumentation = instrumentation;
        File file = new File(System.getProperty("user.dir") + File.separator + "plugins");
        File[] pluginArray = file.listFiles();
        if (pluginArray == null) {
            return;
        }
        Arrays.stream(pluginArray).filter(it ->
                it.getName().endsWith(".jar") && it.getName().startsWith("plugin-")
        ).forEach(it -> {
            try {
                System.out.println("load plugin jar: " + it);
                instrumentation.appendToBootstrapClassLoaderSearch(new JarFile(it));
                instrumentation.appendToSystemClassLoaderSearch(new JarFile(it));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static void appendJarFile(JarFile file) {
        if (instrumentation != null) {
            instrumentation.appendToSystemClassLoaderSearch(file);
        }
    }
}