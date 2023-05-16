dependencies {
    api(project(":plugin:plugin-core"))
    api(project(":plugin:plugin-system:plugin-system-cache"))
    api(project(":plugin:plugin-system:plugin-system-schedule"))
}

tasks.named<Jar>("jar") {
    manifest.attributes["Plugin-Name"] = "骚话插件"
    manifest.attributes["Plugin-Author"] = "DasoopsNicole@Gmail.com"
    manifest.attributes["Plugin-Version"] = "1.0.0"
    manifest.attributes["Plugin-Description"] = "土味情话插件 api来自UomgAPI"
}
