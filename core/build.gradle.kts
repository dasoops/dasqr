import org.springframework.boot.gradle.tasks.bundling.BootJar

dependencies {
    //mirai
    api(platform("net.mamoe:mirai-bom:2.15.0-M1"))
    api("net.mamoe:mirai-core-api")
    runtimeOnly("net.mamoe:mirai-core") // 运行时使用

    //common
    api("cn.hutool:hutool-all:5.8.18")
    api("com.google.guava:guava:31.1-jre")
    api(platform(("com.dasoops:common-bom:4.0.15")))
    api("com.dasoops:common-core")
    api("com.dasoops:common-core-spring")
    api("com.dasoops:common-json-spring")
    api("com.dasoops:common-db-mybatis-plus-spring")

    //kt
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    //db
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("org.postgresql:postgresql")
    implementation("org.flywaydb:flyway-core:9.16.3")

    //spring
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    implementation("org.springframework.boot:spring-boot-starter")

    //schedule task
    implementation("org.springframework.boot:spring-boot-starter-quartz")

    //test
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    //dev
    //developmentOnly("org.springframework.boot:spring-boot-devtools")
}

tasks.named("compileJava") {
    inputs.files(tasks.named("processResources"))
}
tasks.named("compileKotlin") {
    inputs.files(tasks.named("processResources"))
}
tasks.named<BootJar>("bootJar") {
    manifest {
        attributes["Launcher-Agent-Class"] = "com.dasoops.dasqr.core.Agent"
        attributes["Agent-Class"] = "com.dasoops.dasqr.core.Agent"
        attributes["Premain-Class"] = "com.dasoops.dasqr.core.Agent"
    }

    from("build/classes/java/main")
    this.archiveFileName.set("dasqr.jar")
}

tasks {
    val launchTest by creating(JavaExec::class) {
        dependsOn(bootJar)
        mainClass.set("-jar")
        args(bootJar.get().outputs.files.singleFile)
        val wk = project.file("launchTest")
        workingDir(wk)
        doFirst { wk.mkdir() }
    }
}