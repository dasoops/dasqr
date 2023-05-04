package com.dasoops.dasqr.core;

import org.springframework.boot.loader.JarLauncher;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * launcher
 *
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/04
 * @see JarLauncher
 */
public class MyLauncher extends JarLauncher {

    @Override
    protected ClassLoader createClassLoader(URL[] urls) throws Exception {
        File file = new File("./plugin");
        if (!file.isDirectory()) {
            return super.createClassLoader(urls);
        }
        File[] plugins = file.listFiles((var0, name) -> name.startsWith("plugin") && name.endsWith(".jar"));

        if (plugins == null) {
            return super.createClassLoader(urls);
        }

        List<URL> urlList = Arrays.stream(urls).collect(Collectors.toList());
        urlList.addAll(Arrays.stream(plugins).map(it -> {
            try {
                URL url = it.toURI().toURL();
                System.out.println("load plugin jar: ./plugin");
                return url;
            } catch (MalformedURLException e) {
                System.out.println(e.getMessage());
                return null;
            }
        }).filter(Objects::nonNull).toList());
        return super.createClassLoader(urlList.toArray(urls));
    }
}
