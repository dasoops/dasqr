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