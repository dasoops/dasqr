dependencies {
    api(project(":plugin:plugin-core"))
    api(project(":plugin:plugin-system:plugin-system-cache"))
    //爬虫框架
    implementation("org.jsoup:jsoup:1.15.3")
}

tasks.named<Jar>("jar") {
    manifest.attributes["Plugin-Name"] = "yly资讯插件"
    manifest.attributes["Plugin-Author"] = "DasoopsNicole@Gmail.com"
    manifest.attributes["Plugin-Version"] = "1.0.0"
    manifest.attributes["Plugin-Description"] = "由热心大姐姐yly提供的资讯服务"
}
