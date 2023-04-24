dependencies {
    //mirai
    api(platform("net.mamoe:mirai-bom:2.15.0-M1"))
    api("net.mamoe:mirai-core-api")     // 编译代码使用
    runtimeOnly("net.mamoe:mirai-core") // 运行时使用

    //common
    api("cn.hutool:hutool-all:5.8.18")
    api("com.google.guava:guava:31.1-jre")
    api("com.dasoops:common-core:4.0.3")
    api("com.dasoops:common-core-spring:4.0.3")

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
    developmentOnly("org.springframework.boot:spring-boot-devtools")
}