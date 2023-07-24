dependencies {
    api(project(":plugin:plugin-core"))
    api(project(":plugin:plugin-system:plugin-system-http-client"))
    api(project(":plugin:plugin-system:plugin-system-db-ktorm"))

    api("com.qcloud:cos_api:5.6.75")
}

tasks.named<Jar>("jar") {
    manifest.attributes["Plugin-Name"] = "存图取图插件"
    manifest.attributes["Plugin-Author"] = "DasoopsNicole@Gmail.com"
    manifest.attributes["Plugin-Version"] = "1.0.0"
    manifest.attributes["Plugin-Description"] = "存图"
}
