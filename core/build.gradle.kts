import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import java.io.ByteArrayOutputStream

val miraiVersion: String by project
val dasoopsCommonVersion: String by project
val hutoolVersion: String by project
val guavaVersion: String by project
val logbackVersion: String by project
val flywayVersion: String by project
val ktormVersion: String by project
val jsonpVersion: String by project
val okhttpVersion: String by project
val pgsqlVersion: String by project
val cglibVersion: String by project

dependencies {
    //TODO(依赖打包加载)
    //mirai
    api(platform("net.mamoe:mirai-bom:${miraiVersion}"))
    api("net.mamoe:mirai-core-api")
    runtimeOnly("net.mamoe:mirai-core") // 运行时使用

    //common
    api("cn.hutool:hutool-all:${hutoolVersion}")
    api("com.google.guava:guava:${guavaVersion}")
    api(platform(("com.dasoops:common-bom:${dasoopsCommonVersion}")))
    api("com.dasoops:common-core")
    api("com.dasoops:common-json")
    api("com.dasoops:common-db-ktorm")

//    api("net.mamoe:mirai-logging-log4j2")
    api("net.mamoe:mirai-logging-slf4j-logback")
//    api("org.apache.logging.log4j:log4j-core:2.20.0")
//    api("org.apache.logging.log4j:log4j-api:2.20.0")
    api("ch.qos.logback:logback-classic:${logbackVersion}")
//    api("ch.qos.logback:logback-core:${logbackVersion}")

    //db
    runtimeOnly("org.postgresql:postgresql:${pgsqlVersion}")
    api("org.flywaydb:flyway-core:${flywayVersion}")

    //orm
    api("org.ktorm:ktorm-jackson:${ktormVersion}")
    api("org.ktorm:ktorm-core:${ktormVersion}")

    //爬虫框架
    api("org.jsoup:jsoup:${jsonpVersion}")

    //okHttp
    api("com.squareup.okhttp3:okhttp:${okhttpVersion}")

    //kt
    api("org.jetbrains.kotlin:kotlin-reflect")

    //cglib
//    api("cglib:cglib:${cglibVersion}")
    api("net.bytebuddy:byte-buddy:1.14.4")

}

tasks.named("compileJava") {
    inputs.files(tasks.named("processResources"))
}
tasks.named("compileKotlin") {
    inputs.files(tasks.named("processResources"))
}

fun getGitHash(): String {
    val out = ByteArrayOutputStream()
    exec {
        commandLine = arrayListOf("git", "rev-parse", "--short", "HEAD")
        standardOutput = out
    }
    return out.toString().trim()
}

plugins {
    id("com.github.johnrengelman.shadow") version "2.0.4"
}

tasks {

    named<ShadowJar>("shadowJar") {
        val version = getGitHash()
        archiveFileName.set("dasqr-$version.jar")
        manifest {
            attributes["Main-Class"] = "com.dasoops.dasqr.core.DasqrApplicationKt"
            attributes["Version"] = version
        }
    }

    create<JavaExec>("launchTest") {
        val workingDir = rootProject.ext["dasqrWorkingDir"] as String
        val singleFile = shadowJar.get().outputs.files.singleFile
        doFirst {
            singleFile.copyTo(File("$workingDir/${singleFile.name}"), true)
        }
        dependsOn(shadowJar)
        mainClass.set("-jar")

        args(File("$workingDir/${singleFile.name}"))
        workingDir(workingDir)
    }
}