import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.8.10"
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.8.10"
}

version = "1.0"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    implementation(group = "io.papermc.paper", name = "paper-api", version = "1.19.3-R0.1-SNAPSHOT")

    implementation(group = "org.jetbrains.kotlin", name = "kotlin-stdlib", version = "1.8.10")
    implementation(group = "org.jetbrains.kotlin", name = "kotlin-reflect", version = "1.8.10")
    implementation(group = "org.jetbrains.kotlin", name = "kotlin-serialization", version = "1.8.10")
}

tasks.withType<ShadowJar> {
    archiveBaseName.set("DependencyLoader")
    archiveVersion.set(version.toString())

    dependencies {
        exclude(dependency("io.papermc.paper:paper-api:.*"))
    }
}
