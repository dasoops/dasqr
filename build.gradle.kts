import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("jvm") version "1.8.20"
}
allprojects {
    group = "com.dasoops.dasqr"
    version = "3.0.0"

    repositories {
        mavenLocal()
        mavenCentral()
        google()
        maven("https://repo.mirai.mamoe.net/snapshots")
    }
    configurations.all {
        resolutionStrategy {
            force("io.netty:netty-buffer:4.1.90.Final")
            force("io.netty:netty-codec:4.1.90.Final")
            force("io.netty:netty-common:4.1.90.Final")
            force("io.netty:netty-handler:4.1.90.Final")
            force("io.netty:netty-resolver:4.1.90.Final")
            force("io.netty:netty-transport:4.1.90.Final")
        }
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "17"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

apply(from = (file("config.gradle")))

subprojects {
    apply {
        plugin("io.spring.dependency-management")
        plugin("org.jetbrains.kotlin.jvm")
        file("config.gradle")
    }

    java.sourceCompatibility = JavaVersion.VERSION_17
    configurations {
        compileOnly {
            extendsFrom(configurations.annotationProcessor.get())
        }
    }
}