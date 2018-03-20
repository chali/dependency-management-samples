import org.gradle.api.internal.attributes.CompatibilityRule

plugins {
    application
}

repositories {
    mavenCentral()
    maven { setUrl("repo") }
}

class TestRuntimeCompatibility : AttributeCompatibilityRule<Usage> {
    override fun execute(details: CompatibilityCheckDetails<Usage>) {
        if (details.consumerValue?.name == "test-java-runtime"
                && listOf(Usage.JAVA_RUNTIME, Usage.JAVA_RUNTIME_JARS).contains(details.producerValue?.name)) {
            details.compatible()
        }
    }
}
dependencies.attributesSchema.attribute(Usage.USAGE_ATTRIBUTE).compatibilityRules.add(TestRuntimeCompatibility::class.java)

val testRuntimeClasspath by configurations.getting  {
    attributes {
        attribute(Usage.USAGE_ATTRIBUTE, project.objects.named(Usage::class.java, "test-java-runtime"))
    }
}


dependencies {
    // main-module is published with a special "test-java-runtime" variant; this is not yet implemented in the publishing plugins
    implementation("org:main-module:1.0")

    testImplementation("junit:junit:4.12")
}

application {
    mainClassName = "org.example.MainClass"
}
