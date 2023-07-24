dependencies {
    api(project(":plugin:plugin-core"))
    api("com.dasoops:common-http-server-ktor")
}

tasks.named<Jar>("jar") {
    manifest.attributes["Plugin-Name"] = "httpClient插件"
    manifest.attributes["Plugin-Author"] = "DasoopsNicole@Gmail.com"
    manifest.attributes["Plugin-Version"] = "1.0.0"
    manifest.attributes["Plugin-Description"] = "[System] 提供http client服务 by okHttp"
}