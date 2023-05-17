import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.gradle.internal.impldep.org.junit.experimental.categories.Categories.CategoryFilter.exclude
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


//tasks.named<ShadowJar>("shadowJar") {
//
//}
tasks.named<ShadowJar>("shadowJar") {

    val version = project.version.toString() + "-" + getGitHash()
    archiveFileName.set("dasqr-$version.jar")
    manifest {
        attributes["Main-Class"] = "com.dasoops.dasqr.core.DasqrApplicationKt"
        attributes["Version"] = version
    }
}

val fatJar = tasks.create("fatJar", Jar::class) {
    val writer = File("/temp/aoe.txt").writer()
    from(sourceSets.main.get().output)
    from(configurations.runtimeClasspath.get().map {
        if (it.isDirectory) it else zipTree(it)
    })
    exclude(
        "META-INF/LICENSE.txt",
        "META-INF/NOTICE.txt",
        "META-INF/NOTICE-tools.txt",
        "**/LICENSE",
        "**/NOTICE",
        "**/module-info.class"
    )

    val version = project.version.toString() + "-" + getGitHash()
    archiveClassifier.set("all")
    archiveFileName.set("dasqr-$version.jar")

    manifest {
        attributes["Main-Class"] = "com.dasoops.dasqr.core.DasqrApplicationKt"
        attributes["Version"] = version
    }
//
//    copySpec {
//        duplicatesStrategy = DuplicatesStrategy.INCLUDE
//    }
}

tasks {
    val launchTest by creating(JavaExec::class) {
        val workingDir = rootProject.ext["dasqrWorkingDir"] as String
        doFirst {
            fatJar.outputs.files.singleFile.copyTo(File("$workingDir/dasqr.jar"), true)
        }
        dependsOn(fatJar)
        mainClass.set("-jar")

        args(fatJar.outputs.files.singleFile)
        jvmArgs("-DSpring.profiles.active=master")
        workingDir(workingDir)
    }
}