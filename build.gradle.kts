plugins {
    kotlin("jvm") version "2.1.20"
    application
}

group = "wa.umiushi"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val slackClientVersion = "1.45.3"

dependencies {
    implementation("com.slack.api:bolt-jetty:$slackClientVersion")

    implementation("org.slf4j:slf4j-simple:1.7.36")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}

application {
    mainClass = "wa.umiushi.butler.BotAppKt"
}