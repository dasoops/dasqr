import org.springframework.boot.gradle.tasks.bundling.BootJar

dependencies {
    //TODO(依赖打包加载)
    //mirai
    api(platform("net.mamoe:mirai-bom:2.15.0-M1"))
    api("net.mamoe:mirai-core-api")
    runtimeOnly("net.mamoe:mirai-core") // 运行时使用

    //common
    api("cn.hutool:hutool-all:5.8.18")
    api("com.google.guava:guava:31.1-jre")
    api(platform(("com.dasoops:common-bom:4.0.25")))
    api("com.dasoops:common-core")
//    api("com.dasoops:common-core-spring")
    api("com.dasoops:common-json-spring")

    //db
    //implementation("org.springframework.boot:spring-boot-starter-data-redis")
    runtimeOnly("org.postgresql:postgresql")
    implementation("org.flywaydb:flyway-core:9.16.3")
    //orm
    //api("com.dasoops:common-db-mybatis-plus-spring")
    api("com.dasoops:common-db-ktorm-spring")
    //api("org.ktorm:ktorm-support-postgresql:3.6.0")
    api("org.springframework:spring-jdbc")

    //okHttp
    api("com.squareup.okhttp3:okhttp:5.0.0-alpha.11")

    //kt
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    //spring
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-loader")

    //schedule task
//    implementation("org.springframework.boot:spring-boot-starter-quartz")

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
    archiveFileName.set("dasqr.jar")
    mainClass.set("com.dasoops.dasqr.core.CoreApplicationKt")

    //反射替换Launcher
    val supportField = BootJar::class.java.getDeclaredField("support")
    supportField.isAccessible = true
    val support = supportField.get(this)
    val loadMainClassField = Class.forName("org.springframework.boot.gradle.tasks.bundling.BootArchiveSupport")
        .getDeclaredField("loaderMainClass")
    loadMainClassField.isAccessible = true
    loadMainClassField.set(support, "com.dasoops.dasqr.core.MyLauncher")
    //曲线救国,他排除我再添加回去
    from(zipTree("spring-boot-loader-3.0.5.jar"))
    exclude("META-INF/LICENSE.txt", "META-INF/NOTICE.txt")

    //添加MyLauncher
    from("build/classes/java/main")
}

tasks {
    val launchTest by creating(JavaExec::class) {
        val workingDir = rootProject.ext["dasqrWorkingDir"] as String
        doFirst {
            bootJar.get().outputs.files.singleFile.copyTo(File("$workingDir/dasqr.jar"), true)
        }
        dependsOn(bootJar)
        mainClass.set("-jar")

        args(bootJar.get().outputs.files.singleFile)
        jvmArgs("-DSpring.profiles.active=master")
        workingDir(workingDir)
    }
}