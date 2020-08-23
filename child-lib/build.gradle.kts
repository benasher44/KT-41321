import org.jetbrains.kotlin.gradle.tasks.FatFrameworkTask
import org.jetbrains.kotlin.gradle.plugin.mpp.NativeBuildType

plugins {
    kotlin("multiplatform") version "1.4.0"
    kotlin("plugin.serialization") version "1.4.0"
    id("maven-publish")
    id("com.android.library") version "3.6.4"
}
repositories {
    mavenCentral()
    google()
    jcenter()
}
group = "com.example"
version = "0.0.1"

kotlin {
    android {
        publishLibraryVariants("release", "debug")
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
    }
    ios()

    /**
     * Other Apple Options– un-comment each to enable
     *
     * each target will need its own `binaries { framework() }` configuration
     */
    //watchos()
    //iosArm32()
    //tvos()

    sourceSets {
        commonMain {
            dependencies {
                api("org.jetbrains.kotlinx:kotlinx-serialization-core:1.0.0-RC")
            }
        }
        commonTest {
            dependencies {
                implementation(kotlin("test-multiplatform"))
            }
        }
        val androidTest by getting {
            dependencies {
                // https://youtrack.jetbrains.com/issue/KT-41097
                implementation(kotlin("test-junit"))
            }
        }
    }
}

// Enough settings to gradle sync, but more can be added
android {
    compileSdkVersion(29)
}


kotlin {
    targets.all {
        compilations.all {
            kotlinOptions.freeCompilerArgs += listOf("-Xuse-experimental=kotlin.Experimental")
        }
    }
}

publishing {
    publications.withType<MavenPublication> {
        groupId = project.group as String
        version = project.version as String
        pom.withXml {
            asNode().apply {
                appendNode("name", "KT-41321-child")
                appendNode("description", "KT-41321 repro child lib")
                appendNode("url", "test")
                appendNode("scm").apply {
                    appendNode("url", "test")
                    appendNode("connection", "test")
                    appendNode("developerConnection", "test")
                }
                appendNode("developers").apply {
                    appendNode("developer").apply {
                        appendNode("id", "test")
                        appendNode("name", "test")
                    }
                }
            }
        }
    }
}