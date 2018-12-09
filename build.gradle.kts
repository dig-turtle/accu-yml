group = "io.digturtle"
version = "0.0.1-SNAPSHOT"

val junitVersion = "5.1.1"

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.3.11"
    id ("com.gradle.plugin-publish") version "0.10.0"
    id ("java-gradle-plugin")
    id ("com.gradle.build-scan") version "2.1"
}

buildScan {
    termsOfServiceUrl = "https://gradle.com/terms-of-service"
    termsOfServiceAgree = "yes"

    publishAlways()
}

dependencies {
    compileOnly (gradleApi())
    implementation ("org.jetbrains.kotlin:kotlin-stdlib:1.3.11")
    implementation ("org.snakeyaml:snakeyaml-engine:1.0")
    testCompileOnly (gradleTestKit())
    testImplementation ("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testRuntimeOnly ("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
    testImplementation ("org.assertj:assertj-core:3.11.1")
}

tasks.withType<Test> {
    @Suppress("UnstableApiUsage")
    // JUnit 5 is considered incubating still.
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

repositories {
    jcenter()
    mavenCentral()
}

pluginBundle {
    website = "https://github.com/dig-turtle/accu-yml"
    vcsUrl = "https://github.com/dig-turtle/accu-yml.git"
    description = "A Yml validation plugin for Gradle"
    tags = listOf("yml", "yaml", "validation", "validations")

    plugins {
        create("accuYml") {
            id = "io.digturtle.gradle.accu.yml"
            displayName = "Accu Yml Gradle Plugin"
            description = "A Yml validation plugin for Gradle"
        }
    }
}
