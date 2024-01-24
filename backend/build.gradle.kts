import io.gitlab.arturbosch.detekt.Detekt
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jooq.meta.jaxb.Logging
import org.jooq.meta.jaxb.MatcherRule
import org.jooq.meta.jaxb.MatcherTransformType
import org.jooq.meta.jaxb.Matchers
import org.jooq.meta.jaxb.MatchersTableType

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
	alias(libs.plugins.springframework.boot)
	alias(libs.plugins.kotlin.jvm)
	alias(libs.plugins.kotlin.plugin.spring)
	alias(libs.plugins.jooq)
	alias(libs.plugins.diktat)
	alias(libs.plugins.detekt)
	jacoco
	alias(libs.plugins.sonarqube)

}

group = "ch.v7"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {

	// enforcedPlatform: use this version. Earlier declarations take precedence
	implementation(enforcedPlatform(libs.kotlin.bom))
	implementation(enforcedPlatform(libs.spring.framework.bom))
	api(enforcedPlatform(libs.spring.boot.dependencies)) {
		exclude("org.yaml", "snakeyaml") // pull version from jackson (fix vulnerabilities)
	}

	implementation(libs.spring.boot.starter.actuator)
	implementation(libs.spring.boot.starter.jooq)
	implementation(libs.spring.boot.starter.web)
	implementation(libs.spring.boot.starter.security)
	implementation(libs.jackson.module.kotlin)
	implementation(libs.kotlin.reflect)
	implementation(libs.liquibase.core)
	implementation(libs.springdoc.openapi.ui)
	implementation(libs.springdoc.openapi.kotlin)
	implementation(libs.jsonwebtoken)


	implementation(libs.jooq)
	implementation(libs.jooq.codegen)
	implementation(libs.mariadb.java.client)

	testImplementation(libs.spring.boot.starter.test)
	testImplementation(libs.spring.security.test)
	testImplementation(libs.testcontainers.bom)
	testImplementation(libs.org.testcontainers.mariadb)
	testImplementation(libs.mockserver)
	testImplementation(libs.mockserver.client.java)
	testImplementation(libs.archunit)



	runtimeOnly(libs.mariadb.java.client)
	jooqGenerator(libs.mariadb.java.client)
	jooqGenerator(libs.jakarta.xml.bind.api)

}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict") // https://docs.gradle.org/current/userguide/kotlin_dsl.html#sec:kotlin_compiler_arguments
		jvmTarget = JavaVersion.VERSION_17.toString()
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.jacocoTestReport {
	reports {
		xml.required.set(true)
		html.required.set(true)
	}
}

tasks.test {
	finalizedBy(tasks.jacocoTestReport)
}

detekt {
	source.setFrom("src/main/kotlin")
	config.setFrom("detekt.yml")
	parallel = true
}

diktat {
	diktatConfigFile = file("diktat-analysis.yml")
	inputs {
		include("src/main/kotlin/**/*.kt")
	}
}

tasks.matching { it.name == LifecycleBasePlugin.CHECK_TASK_NAME }.first().apply {
	setDependsOn(dependsOn.filter { !(it is TaskProvider<*> && it.name == "detekt") })
	dependsOn("diktatCheck")
	dependsOn("detekt")
	// Run detektMain as well. See discussion https://github.com/detekt/detekt/issues/3122 and https://github.com/detekt/detekt/discussions/4959
	dependsOn("detektMain")
}

// Run detekt after diktat (diktat checks formatting errors that it can also fix)
tasks.matching { it.name == "detekt" }.first().mustRunAfter("diktatCheck")

// Required for detektMain not to pick up kotlin-gen
tasks.withType<Detekt>().configureEach {
	exclude {
		it.file.absolutePath.contains("kotlin-gen/")
	}
}


jooq {
	configurations {
		create("main") {
			generateSchemaSourceOnCompilation.set(false)
			jooqConfiguration.apply {
				logging = Logging.DEBUG
				jdbc.apply {
					driver = "org.mariadb.jdbc.Driver"
					url = "jdbc:mariadb://localhost:3306/backend"
					user = "backend"
					password = "backend"
				}
				generator.apply {
					name = "org.jooq.codegen.KotlinGenerator"
					database.apply {
						name = "org.jooq.meta.mariadb.MariaDBDatabase"
						inputSchema = "backend"
						excludes = "Databasechangelog|Databasechangeloglock"
					}
					generate.apply {
						isDaos = true
						isNonnullAnnotation = true
						isNullableAnnotation = true
						nullableAnnotationType = "org.jetbrains.annotations.Nullable"
						nonnullAnnotationType = "org.jetbrains.annotations.NotNull"
						isDeprecated = false
						isRecords = true
						isImmutablePojos = true
						isFluentSetters = true
						isKotlinNotNullPojoAttributes = true
						isKotlinNotNullRecordAttributes = true
					}
					target.apply {
						packageName = "ch.v7.backend.persistence"
						directory = "src/main/kotlin-gen/jooq-gen"
					}
					strategy.apply {
						name = "org.jooq.codegen.DefaultGeneratorStrategy"
						matchers = Matchers().apply {
							tables.add(
								MatchersTableType().apply {
									expression = "^t_(.*)$"
									tableIdentifier = MatcherRule().apply {
										expression = "$1"
										transform = MatcherTransformType.UPPER
									}
									tableClass = MatcherRule().apply {
										expression = "$1_TABLE"
										transform = MatcherTransformType.PASCAL
									}
									daoClass = MatcherRule().apply {
										expression = "$1_DAO"
										transform = MatcherTransformType.PASCAL
									}
									pojoClass = MatcherRule().apply {
										expression = "$1"
										transform = MatcherTransformType.PASCAL
									}
									recordClass = MatcherRule().apply {
										expression = "$1_RECORD"
										transform = MatcherTransformType.PASCAL
									}
								},
							)
						}
					}
				}
			}
		}
	}
}

sonar {
	properties {
		property("sonar.projectKey", "v7-bauma_website-backend")
		property("sonar.organization", "v7-bauma")
		property("sonar.host.url", "https://sonarcloud.io")
	}
}
