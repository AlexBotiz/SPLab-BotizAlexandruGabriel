import org.gradle.kotlin.dsl.implementation

plugins {
	java
	id("org.springframework.boot") version "3.5.7"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "org.example"
version = "0.0.1-SNAPSHOT"
description = "ProiectSP"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(23)
    }
}

repositories {
	mavenCentral()
}

dependencies {
    implementation ("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation ("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation ("com.h2database:h2:2.1.214")
    implementation ("org.projectlombok:lombok:1.18.30")
    annotationProcessor ("org.projectlombok:lombok:1.18.30")

}


tasks.withType<Test> {
	useJUnitPlatform()
}
