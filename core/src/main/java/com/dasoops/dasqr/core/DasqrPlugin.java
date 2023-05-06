package com.dasoops.dasqr.core;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.jar.Attributes;
import java.util.jar.JarFile;

/**
 * dasqr插件
 *
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/06
 */
public class DasqrPlugin {

    /**
     * 路径
     */
    private String path;

    /**
     * 名称
     */
    private String name;

    /**
     * 版本
     */
    private String version;

    /**
     * 描述
     */
    private String description;

    /**
     * 作者
     */
    private String author;

    private DasqrPlugin() {

    }

    public DasqrPlugin(File file) throws IOException {
        try (JarFile jarFile = new JarFile(file)) {
            Attributes attributes = jarFile.getManifest().getMainAttributes();
            if (!attributes.containsKey(new Attributes.Name("Plugin-Name"))) {
                throw new LaunchException("no 'Plugin-Name', please check plugin? file: " + jarFile.getName());
            }

            this.path = file.getPath();
            this.name = attributes.getValue("Plugin-Name");
            this.author = attributes.getValue("Plugin-Author");
            this.version = attributes.getValue("Plugin-Version");
            this.description = attributes.getValue("Plugin-Description");
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DasqrPlugin that = (DasqrPlugin) o;
        return Objects.equals(path, that.path) && Objects.equals(name, that.name) && Objects.equals(version, that.version) && Objects.equals(description, that.description) && Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path, name, version, description, author);
    }

    @Override
    public String toString() {
        return String.format("""
                %s
                    name : %s
                    author : %s
                    version : %s
                    description : %s
                """, path, name, author, version, description);
    }
}
