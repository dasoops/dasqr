dependencies {
    api(project(":plugin:plugin-core"))
    api(project(":plugin:plugin-system:plugin-system-cache"))
    api(project(":plugin:plugin-system:plugin-system-schedule"))
    api(project(":plugin:plugin-system:plugin-system-http-client"))
    //爬虫框架
    api("org.jsoup:jsoup:1.15.3")
}

tasks.named<Jar>("jar") {
    manifest.attributes["Plugin-Name"] = "yly资讯插件"
    manifest.attributes["Plugin-Author"] = "DasoopsNicole@Gmail.com"
    manifest.attributes["Plugin-Version"] = "1.0.0"
    manifest.attributes["Plugin-Description"] = "由热心大姐姐yly提供的资讯服务"
}
