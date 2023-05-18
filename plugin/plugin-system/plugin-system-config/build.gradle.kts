dependencies {
    api(project(":plugin:plugin-core"))
    api(project(":plugin:plugin-system:plugin-system-db-ktorm"))
}

tasks.named<Jar>("jar") {
    manifest.attributes["Plugin-Name"] = "配置项持久化插件"
    manifest.attributes["Plugin-Author"] = "DasoopsNicole@Gmail.com"
    manifest.attributes["Plugin-Version"] = "1.0.0"
    manifest.attributes["Plugin-Description"] = "[System] 提供数据库配置存储"
}