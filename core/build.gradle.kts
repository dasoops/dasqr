import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import java.io.ByteArrayOutputStream

dependencies {
    //mirai
    api(platform("net.mamoe:mirai-bom:2.15.0-dev-98"))
    api("net.mamoe:mirai-core-api")
    runtimeOnly("net.mamoe:mirai-core") // 运行时使用

    //common
    api("cn.hutool:hutool-all:5.8.18")
    api("com.google.guava:guava:31.1-jre")
    api(platform(("com.dasoops:common-bom:4.2.2")))
    api("com.dasoops:common-core")
    api("com.dasoops:common-json-core")
    api("com.dasoops:common-json-jackson")

    api("net.mamoe:mirai-logging-slf4j-logback")
    api("ch.qos.logback:logback-classic:1.4.7")

    //kt
    api("org.jetbrains.kotlin:kotlin-reflect")

    //cglib
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
        archiveFileName.set("dasqr.jar")
        manifest {
            attributes["Main-Class"] = "com.dasoops.dasqr.core.DasqrApplicationKt"
            attributes["Version"] = getGitHash()
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