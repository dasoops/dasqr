ext["noPlugin"] = true

dependencies {
    api(project(":plugin:plugin-core"))
    api(project(":plugin:plugin-system:plugin-system-exception-log"))
    api(project(":plugin:plugin-system:plugin-system-message-log"))
    api(project(":plugin:plugin-system:plugin-system-config"))
    api(project(":plugin:plugin-system:plugin-system-schedule"))
    api(project(":plugin:plugin-system:plugin-system-plugin-manager"))
    api(project(":plugin:plugin-loaj:plugin-reply"))
    api(project(":plugin:plugin-loaj:plugin-ylynews"))
    api(project(":plugin:plugin-loaj:plugin-openai"))
    api(project(":plugin:plugin-loaj:plugin-sao"))
    api(project(":plugin:plugin-loaj:plugin-bilibili"))
    api(project(":plugin:plugin-loaj:plugin-roll"))
}