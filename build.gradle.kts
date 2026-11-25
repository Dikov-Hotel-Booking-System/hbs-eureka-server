plugins {
	java
	alias(libs.plugins.spring.boot)
	alias(libs.plugins.spring.dependency.management)
}

group = "ru.mephi"
version = "0.0.1-SNAPSHOT"
description = "Service discovery for the hotel booking system"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(libs.versions.java.get().toInt())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation(libs.spring.cloud.starter.netflix.eureka.server)
}

dependencyManagement {
	imports {
		val springCloudBom = libs.spring.cloud.bom.get()
		mavenBom("${springCloudBom.group}:${springCloudBom.name}:${springCloudBom.versionConstraint.requiredVersion}")
	}
}

tasks.bootJar {
	archiveFileName.set("app.jar")
}

tasks.jar {
	enabled = false
}
