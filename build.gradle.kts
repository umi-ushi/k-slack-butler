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
    implementation("com.slack.api:slack-api-client:$slackClientVersion")
    implementation("com.slack.api:bolt:$slackClientVersion")
    implementation("com.slack.api:bolt-servlet:$slackClientVersion")
    implementation("com.slack.api:bolt-socket-mode:$slackClientVersion")

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