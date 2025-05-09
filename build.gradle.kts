import org.gradle.kotlin.dsl.implementation

plugins {
    kotlin("jvm") version "2.1.20"
    kotlin("plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.4.5"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "wa.umiushi"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.slack.api:bolt-jakarta-servlet:1.45.3")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}

tasks.bootBuildImage {
    imageName = "imumiushi/k-slack-butler:latest"

    builder = "paketobuildpacks/builder-jammy-java-tiny:latest"
    imagePlatform = "linux/amd64"
}