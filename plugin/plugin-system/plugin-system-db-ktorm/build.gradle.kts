dependencies {
    api(project(":plugin:plugin-core"))

    api("com.dasoops:common-db-ktorm")
    //db
    runtimeOnly("org.postgresql:postgresql:42.6.0")
    api("org.flywaydb:flyway-core:9.16.3")
}

tasks.named<Jar>("jar") {
    manifest.attributes["Plugin-Name"] = "ktorm插件"
    manifest.attributes["Plugin-Author"] = "DasoopsNicole@Gmail.com"
    manifest.attributes["Plugin-Version"] = "1.0.0"
    manifest.attributes["Plugin-Description"] = "[System] 需要orm不要忘了我喵"
}