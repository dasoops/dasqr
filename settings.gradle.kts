rootProject.name = "dasqr"

include(
    ":core",
    ":plugin:plugin-test",
    ":plugin:plugin-core",
    ":plugin:plugin-system:plugin-system-exception-log",
    ":plugin:plugin-system:plugin-system-message-log",
    ":plugin:plugin-system:plugin-system-config",
    ":plugin:plugin-system:plugin-system-cache",
    ":plugin:plugin-system:plugin-system-auth",
    ":plugin:plugin-system:plugin-system-register",
    ":plugin:plugin-loaj:plugin-reply",
    ":plugin:plugin-loaj:plugin-openai",
)