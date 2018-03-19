
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.attributes.Attribute

open class MyDeprecationPlugin: Plugin<Project> {

    enum class Lifecycle {
        ALIVE,
        DEPRECATED
    }

    private val lifecycleAttribute: Attribute<Lifecycle> = Attribute.of("org.myorg.lifecycle", Lifecycle::class.java)

    override fun apply(project: Project) {
        project.setupMatchingStrategy()

        // This information could be retrieved from an external service
        project.dependencies.deprecate("sustitutionrule:directsubstitute", "2.0.0")
        project.dependencies.deprecate("sustitutionrule:substitute", "1.0.0")
        // Lists all known versions of "rangesubstitute", but you could also implement/reuse range matching in the withDependencies.filter { }
        project.dependencies.deprecate("sustitutionrule:rangesubstitute", "2.0.0")
        project.dependencies.deprecate("sustitutionrule:rangesubstitute", "2.2.0")
    }

    private fun Project.setupMatchingStrategy() {
        dependencies.attributesSchema.attribute(Attribute.of("", String::class.java)).compatibilityRules.add()
        val matchingStrategy = dependencies.attributesSchema.attribute(lifecycleAttribute)
        matchingStrategy.ordered { a1: Lifecycle, a2: Lifecycle ->
            a1.ordinal.compareTo(a2.ordinal)
        }
        configurations.all {
            attributes {
                attribute(lifecycleAttribute, Lifecycle.ALIVE)
            }
        }
    }

    private fun DependencyHandler.deprecate(module: String, version: String) {
        components.withModule(module) {
            if (id.version == version) {
                allVariants {
                    attributes {
                        attribute(lifecycleAttribute, Lifecycle.DEPRECATED)
                    }
                }
            }
        }
    }
}

