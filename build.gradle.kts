plugins {
    kotlin("jvm") version "1.8.0"
    `version-catalog`
    `maven-publish`
}

group = "kr.hsk"
version = "1.0.1"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

catalog {
    versionCatalog {
        from(files("libs.versions.toml"))
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["versionCatalog"])
        }
    }
}