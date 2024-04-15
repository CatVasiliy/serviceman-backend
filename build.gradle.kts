plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ktor)
}

group = "com.catvasiliy"
version = "0.0.1"

application {
    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {

    // Ktor core
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)

    // Dependency injection
    implementation(libs.koin.ktor)
    implementation(libs.koin.logger)

    // Ktor serialization
    implementation(libs.ktor.server.content.negotiation)
    implementation(libs.ktor.serialization.kotlinx.json)

    // Ktor logging
    implementation(libs.ktor.server.call.logging)
    implementation(libs.logback.classic)

    // Ktor authentication
    implementation(libs.ktor.server.auth)
    implementation(libs.ktor.server.auth.jwt)

    // Database
    implementation(libs.exposed.core)
    implementation(libs.exposed.jdbc)
    implementation(libs.postgresql)

    // Testing
    testImplementation(libs.ktor.server.tests)
    testImplementation(libs.kotlin.test.junit)
}
