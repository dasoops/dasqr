package com.dasoops.dasqr.core;

import org.springframework.boot.loader.JarLauncher;

import java.io.File;
import java.net.URL;
import java.util.*;
import java.util.jar.Attributes;
import java.util.stream.Collectors;

/**
 * launcher
 *
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/04
 * @see JarLauncher
 */
public class MyLauncher extends JarLauncher {

    public static boolean fromLauncher = false;
    public static final Set<DasqrPlugin> loadPluginList = new HashSet<>();

    @Override
    protected ClassLoader createClassLoader(URL[] urls) throws Exception {
        String pluginPath = System.getProperty("user.dir") + "/plugin";
        File file = new File(pluginPath);
        if (!file.isDirectory()) {
            System.out.printf("no find plugin, please check directory: [%s]", pluginPath);
            return super.createClassLoader(urls);
        }
        File[] plugins = file.listFiles((var0, name) -> name.startsWith("plugin") && name.endsWith(".jar"));

        if (plugins == null) {
            System.out.printf("no find plugin, please check directory: [%s]", pluginPath);
            return super.createClassLoader(urls);
        }

        List<URL> urlList = Arrays.stream(urls).collect(Collectors.toList());
        System.out.println("loading plugin.........................");
        urlList.addAll(Arrays.stream(plugins).map(it -> {
            try {
                DasqrPlugin dasqrPlugin = new DasqrPlugin(it);
                loadPluginList.add(dasqrPlugin);
                System.out.println("load plugin jar: " + dasqrPlugin);
                return it.toURI().toURL();
            } catch (LaunchException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }).filter(Objects::nonNull).toList());
        System.out.println("end loading plugin.........................");
        return super.createClassLoader(urlList.toArray(urls));
    }

    private static boolean checkIsPlugin(Attributes attributes) {
        return attributes.containsKey(new Attributes.Name("Plugin-Name"));
    }

    private static void printMainfestInfo(Attributes attributes) {
        System.out.printf("""
                            name : %s
                            author : %s
                            version : %s
                            description : %s
                            
                        """, attributes.getValue("Plugin-Name"),
                attributes.getValue("Plugin-Author"),
                attributes.getValue("Plugin-Version"),
                attributes.getValue("Plugin-Description")
        );
    }

    public static void main(String[] args) throws Exception {
        fromLauncher = true;
        new MyLauncher().launch(args);
    }
}
