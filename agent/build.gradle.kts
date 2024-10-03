plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ktlint)
    application
    alias(libs.plugins.shadow)
}

dependencies {
    implementation(project(":shared"))
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.cio)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.serialization.jackson)
    implementation(libs.logback.classic)
}

application {
    mainClass.set("io.github.gtn1024.cangjieplayground.agent.ApplicationKt")
}
