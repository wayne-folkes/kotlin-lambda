// val aspectjVersion by extra("1.9.3")
plugins {
    kotlin("jvm") version "1.9.0"
    id("java")
    id("application")
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("io.freefair.aspectj.post-compile-weaving") version "8.4"
    // id("aspectj.gradle") version "0.1.6" apply false
}

// apply(plugin = "aspectj.gradle")

group = "org.example"

repositories {
    mavenCentral()
}


dependencies {
    testImplementation(kotlin("test"))
    runtimeOnly("org.aspectj:aspectjrt:1.9.20.1")
    implementation("com.amazonaws:aws-lambda-java-core:1.2.2")
    implementation("com.amazonaws:aws-lambda-java-events:3.11.1")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json-jvm:1.6.0")
    implementation("org.apache.logging.log4j:log4j-api:2.20.0")
    aspect("software.amazon.lambda:powertools-logging:1.17.0")
    aspect("software.amazon.lambda:powertools-tracing:1.17.0")
    aspect("software.amazon.lambda:powertools-metrics:1.17.0")
}

// aspectj {
//     configurations {
//         aspectpath
//     }

//     aspects {
//         aspectLibrary("software.amazon.lambda:powertools-logging:1.17.0") // Replace with the actual version
//     }

//     compileWeaving {
//         ajcOptions {
//             option("forceAjcCompile", "true")
//         }
//     }
// }

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

application {
    mainClass.set("example.Handler")
}

tasks.test {
    useJUnitPlatform()
}

// tasks.withType<ShadowJar>() {
//     transform(Log4j2PluginsCacheFileTransformer::class.java)
// }

kotlin {
    jvmToolchain(17)

}

application {
    mainClass.set("MainKt")
}
